package com.shortreels.presentation.ui.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.shortreels.R
import com.shortreels.databinding.BottomSheetCommentsBinding
import com.shortreels.presentation.adapters.CommentsAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

/**
 * CommentsBottomSheet - Slide-up comments panel.
 * Matches Dramabox/TikTok style comment sheets.
 */
@AndroidEntryPoint
class CommentsBottomSheet : BottomSheetDialogFragment() {

    private var _binding: BottomSheetCommentsBinding? = null
    private val binding get() = _binding!!
    private lateinit var commentsAdapter: CommentsAdapter
    private var videoId: String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = BottomSheetCommentsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        videoId = arguments?.getString(ARG_VIDEO_ID) ?: return

        setupBottomSheet()
        setupRecyclerView()
        setupInput()
    }

    private fun setupBottomSheet() {
        dialog?.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
        // Set initial height to 70% of screen
        val behavior = BottomSheetBehavior.from(requireView().parent as View)
        behavior.peekHeight = (resources.displayMetrics.heightPixels * 0.7).toInt()
        behavior.state = BottomSheetBehavior.STATE_EXPANDED
    }

    private fun setupRecyclerView() {
        commentsAdapter = CommentsAdapter(
            onLike = { commentId, isLiked -> /* viewModel.toggleCommentLike */ },
            onReply = { comment -> binding.etComment.setText("@${comment.author.username} ") }
        )
        binding.rvComments.apply {
            adapter = commentsAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun setupInput() = with(binding) {
        btnSendComment.setOnClickListener {
            val text = etComment.text?.toString()?.trim() ?: ""
            if (text.isNotEmpty()) {
                // viewModel.postComment(videoId, text)
                etComment.text?.clear()
            }
        }

        tvCommentCount.text = "Comentarios"
        btnClose.setOnClickListener { dismiss() }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val TAG = "CommentsBottomSheet"
        private const val ARG_VIDEO_ID = "video_id"

        fun newInstance(videoId: String) = CommentsBottomSheet().apply {
            arguments = Bundle().apply { putString(ARG_VIDEO_ID, videoId) }
        }
    }
}
