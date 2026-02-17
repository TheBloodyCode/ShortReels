package com.shortreels.presentation.ui.auth

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.shortreels.R
import com.shortreels.databinding.ActivityAuthBinding
import com.shortreels.databinding.FragmentLoginBinding
import com.shortreels.databinding.FragmentRegisterBinding
import com.shortreels.presentation.ui.MainActivity
import com.shortreels.presentation.viewmodel.AuthUiState
import com.shortreels.presentation.viewmodel.AuthViewModel
import com.shortreels.utils.Extensions.isValidEmail
import com.shortreels.utils.Extensions.isValidPassword
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

/**
 * AuthActivity - Container for Login/Register navigation.
 */
@AndroidEntryPoint
class AuthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAuthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}

/**
 * LoginFragment
 */
@AndroidEntryPoint
class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private val viewModel: AuthViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        observeViewModel()
    }

    private fun setupViews() = with(binding) {
        btnLogin.setOnClickListener { attemptLogin() }

        tvRegister.setOnClickListener {
            findNavController().navigate(R.id.action_login_to_register)
        }

        btnGoogleLogin.setOnClickListener {
            // Google OAuth
        }

        // Real-time validation
        etEmail.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                tilEmail.error = if (s.toString().isNotEmpty() && !s.toString().isValidEmail())
                    "Email inválido" else null
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        etPassword.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                tilPassword.error = if (s.toString().isNotEmpty() && !s.toString().isValidPassword())
                    "Mínimo 8 caracteres" else null
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
    }

    private fun attemptLogin() {
        val email = binding.etEmail.text?.toString()?.trim() ?: ""
        val password = binding.etPassword.text?.toString() ?: ""

        var valid = true
        if (!email.isValidEmail()) {
            binding.tilEmail.error = "Ingresa un email válido"
            valid = false
        }
        if (!password.isValidPassword()) {
            binding.tilPassword.error = "Mínimo 8 caracteres"
            valid = false
        }
        if (valid) viewModel.login(email, password)
    }

    private fun observeViewModel() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.authState.collect { state ->
                when (state) {
                    is AuthUiState.Loading -> setLoadingState(true)
                    is AuthUiState.Success -> navigateToMain()
                    is AuthUiState.Error -> {
                        setLoadingState(false)
                        Snackbar.make(binding.root, state.message, Snackbar.LENGTH_LONG).show()
                    }
                    else -> setLoadingState(false)
                }
            }
        }
    }

    private fun setLoadingState(loading: Boolean) {
        binding.progressBar.visibility = if (loading) View.VISIBLE else View.GONE
        binding.btnLogin.isEnabled = !loading
        binding.btnLogin.text = if (loading) "" else "Iniciar Sesión"
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

/**
 * RegisterFragment
 */
@AndroidEntryPoint
class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!
    private val viewModel: AuthViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        observeViewModel()
    }

    private fun setupViews() = with(binding) {
        btnBack.setOnClickListener { findNavController().navigateUp() }

        btnRegister.setOnClickListener {
            val username = etUsername.text?.toString()?.trim() ?: ""
            val email = etEmail.text?.toString()?.trim() ?: ""
            val password = etPassword.text?.toString() ?: ""
            val confirmPassword = etConfirmPassword.text?.toString() ?: ""

            var valid = true
            if (username.length < 3) { tilUsername.error = "Mínimo 3 caracteres"; valid = false }
            if (!email.isValidEmail()) { tilEmail.error = "Email inválido"; valid = false }
            if (!password.isValidPassword()) { tilPassword.error = "Mínimo 8 caracteres"; valid = false }
            if (password != confirmPassword) { tilConfirmPassword.error = "Las contraseñas no coinciden"; valid = false }
            if (valid) viewModel.register(username, email, password)
        }

        tvLogin.setOnClickListener { findNavController().navigateUp() }
    }

    private fun observeViewModel() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.authState.collect { state ->
                when (state) {
                    is AuthUiState.Loading -> {
                        binding.progressBar.visibility = View.VISIBLE
                        binding.btnRegister.isEnabled = false
                    }
                    is AuthUiState.Success -> {
                        startActivity(Intent(requireContext(), MainActivity::class.java))
                        requireActivity().finish()
                    }
                    is AuthUiState.Error -> {
                        binding.progressBar.visibility = View.GONE
                        binding.btnRegister.isEnabled = true
                        Snackbar.make(binding.root, state.message, Snackbar.LENGTH_LONG).show()
                    }
                    else -> {
                        binding.progressBar.visibility = View.GONE
                        binding.btnRegister.isEnabled = true
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
