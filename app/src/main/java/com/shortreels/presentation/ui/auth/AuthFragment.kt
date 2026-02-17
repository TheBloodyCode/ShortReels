package com.shortreels.presentation.ui.auth

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.shortreels.databinding.FragmentAuthBinding
import com.shortreels.presentation.ui.MainActivity
import com.shortreels.presentation.viewmodel.AuthUiState
import com.shortreels.presentation.viewmodel.AuthViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AuthFragment : Fragment() {

    private var _binding: FragmentAuthBinding? = null
    private val binding get() = _binding!!
    private val viewModel: AuthViewModel by viewModels()

    private var isLoginMode = true

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentAuthBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        observeViewModel()
    }

    private fun setupViews() = with(binding) {
        btnAction.setOnClickListener {
            val email = etEmail.text?.toString()?.trim() ?: ""
            val password = etPassword.text?.toString() ?: ""

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(context, "Completa todos los campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (isLoginMode) {
                viewModel.login(email, password)
            } else {
                val username = etUsername.text?.toString()?.trim() ?: ""
                if (username.isEmpty()) {
                    Toast.makeText(context, "Ingresa un nombre de usuario", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                viewModel.register(username, email, password)
            }
        }

        btnToggleMode.setOnClickListener {
            isLoginMode = !isLoginMode
            updateUiMode()
        }

        btnSkip.setOnClickListener {
            navigateToMain()
        }
    }

    private fun updateUiMode() = with(binding) {
        if (isLoginMode) {
            tvTitle.text = "¡Bienvenido de vuelta!"
            tvSubtitle.text = "Inicia sesión para continuar"
            btnAction.text = "Iniciar Sesión"
            tvToggleHint.text = "¿No tienes cuenta?"
            btnToggleMode.text = "Registrarse"
            layoutDisplayName.visibility = View.GONE
            layoutUsername.visibility = View.GONE
        } else {
            tvTitle.text = "Crear Cuenta"
            tvSubtitle.text = "Únete a la mejor comunidad de dramas cortos"
            btnAction.text = "Registrarse"
            tvToggleHint.text = "¿Ya tienes cuenta?"
            btnToggleMode.text = "Iniciar Sesión"
            layoutDisplayName.visibility = View.VISIBLE
            layoutUsername.visibility = View.VISIBLE
        }
    }

    private fun observeViewModel() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.authState.collect { state ->
                binding.progressBar.visibility = if (state is AuthUiState.Loading) View.VISIBLE else View.GONE
                binding.btnAction.isEnabled = state !is AuthUiState.Loading

                when (state) {
                    is AuthUiState.Success -> navigateToMain()
                    is AuthUiState.Error -> Toast.makeText(context, state.message, Toast.LENGTH_LONG).show()
                    else -> {}
                }
            }
        }
    }

    private fun navigateToMain() {
        startActivity(Intent(requireContext(), MainActivity::class.java))
        requireActivity().finish()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
