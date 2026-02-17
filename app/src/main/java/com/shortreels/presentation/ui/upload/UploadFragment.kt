package com.shortreels.presentation.ui.upload

import android.Manifest
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.shortreels.databinding.FragmentUploadBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * UploadFragment - Video upload interface.
 * Allows content creators to upload short drama episodes.
 * Supports video picker, metadata input, and upload progress.
 */
@AndroidEntryPoint
class UploadFragment : Fragment() {

    private var _binding: FragmentUploadBinding? = null
    private val binding get() = _binding!!
    private var selectedVideoUri: Uri? = null

    private val videoPickerLauncher = registerForActivityResult(
        ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        uri?.let {
            selectedVideoUri = it
            binding.ivVideoPreview.setImageURI(it)
            binding.tvVideoName.text = getFileName(it)
            binding.btnUpload.isEnabled = true
        }
    }

    private val permissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { granted ->
        if (granted) openVideoPicker()
        else Snackbar.make(binding.root, "Permiso requerido para acceder a videos", Snackbar.LENGTH_LONG).show()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentUploadBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
    }

    private fun setupViews() = with(binding) {
        btnClose.setOnClickListener { findNavController().navigateUp() }

        btnSelectVideo.setOnClickListener { checkPermissionAndOpenPicker() }
        ivVideoPreview.setOnClickListener { checkPermissionAndOpenPicker() }

        btnUpload.isEnabled = false
        btnUpload.setOnClickListener { startUpload() }

        // Character counters
        etTitle.doAfterTextChanged { updateCharCount(it?.length ?: 0, 100, tvTitleCount) }
        etDescription.doAfterTextChanged { updateCharCount(it?.length ?: 0, 500, tvDescCount) }
    }

    private fun checkPermissionAndOpenPicker() {
        val permission = if (android.os.Build.VERSION.SDK_INT >= 33) {
            Manifest.permission.READ_MEDIA_VIDEO
        } else {
            Manifest.permission.READ_EXTERNAL_STORAGE
        }

        when {
            ContextCompat.checkSelfPermission(requireContext(), permission) == PackageManager.PERMISSION_GRANTED ->
                openVideoPicker()
            shouldShowRequestPermissionRationale(permission) ->
                Snackbar.make(binding.root, "Necesitamos acceso a tus videos", Snackbar.LENGTH_INDEFINITE)
                    .setAction("Permitir") { permissionLauncher.launch(permission) }
                    .show()
            else -> permissionLauncher.launch(permission)
        }
    }

    private fun openVideoPicker() {
        videoPickerLauncher.launch("video/*")
    }

    private fun startUpload() {
        val uri = selectedVideoUri ?: return
        val title = binding.etTitle.text?.toString()?.trim() ?: ""
        val description = binding.etDescription.text?.toString()?.trim() ?: ""

        if (title.isEmpty()) {
            binding.tilTitle.error = "El título es requerido"
            return
        }

        // Show upload progress
        binding.uploadProgressGroup.visibility = View.VISIBLE
        binding.btnUpload.isEnabled = false

        // Start upload via ViewModel/Repository
        // viewModel.uploadVideo(uri, title, description, ...)
    }

    private fun updateCharCount(current: Int, max: Int, textView: android.widget.TextView) {
        textView.text = "$current/$max"
    }

    private fun getFileName(uri: Uri): String {
        val cursor = requireContext().contentResolver.query(uri, null, null, null, null)
        return cursor?.use {
            val nameIndex = it.getColumnIndex(android.provider.OpenableColumns.DISPLAY_NAME)
            it.moveToFirst()
            it.getString(nameIndex)
        } ?: "video.mp4"
    }

    // Extension helper (inline for clarity)
    private fun android.widget.EditText.doAfterTextChanged(action: (CharSequence?) -> Unit) {
        addTextChangedListener(object : android.text.TextWatcher {
            override fun afterTextChanged(s: android.text.Editable?) = action(s)
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
