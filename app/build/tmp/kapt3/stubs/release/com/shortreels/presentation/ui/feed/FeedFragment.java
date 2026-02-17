package com.shortreels.presentation.ui.feed;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.chip.Chip;
import com.shortreels.R;
import com.shortreels.databinding.FragmentFeedBinding;
import com.shortreels.domain.model.Genre;
import com.shortreels.presentation.adapters.FeedAdapter;
import com.shortreels.presentation.viewmodel.FeedViewModel;
import com.shortreels.presentation.viewmodel.FeedUiState;
import dagger.hilt.android.AndroidEntryPoint;

/**
 * FeedFragment - Full-screen vertical scroll feed (ViewPager2).
 * Each item is a VideoPlayerViewHolder with ExoPlayer.
 * Mimics TikTok/Dramabox/Melolo swipe-up experience.
 */
@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J$\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0011H\u0016J\b\u0010\u001c\u001a\u00020\u0011H\u0016J\b\u0010\u001d\u001a\u00020\u0011H\u0016J\u001a\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010#\u001a\u00020\u00112\u0006\u0010$\u001a\u00020\"H\u0002J\u0010\u0010%\u001a\u00020\u00112\u0006\u0010&\u001a\u00020\"H\u0002J\b\u0010\'\u001a\u00020\u0011H\u0002J\b\u0010(\u001a\u00020\u0011H\u0002J\u0010\u0010)\u001a\u00020\u00112\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010*\u001a\u00020\u00112\u0006\u0010+\u001a\u00020\"H\u0002J\b\u0010,\u001a\u00020\u0011H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r\u00a8\u0006-"}, d2 = {"Lcom/shortreels/presentation/ui/feed/FeedFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/shortreels/databinding/FragmentFeedBinding;", "binding", "getBinding", "()Lcom/shortreels/databinding/FragmentFeedBinding;", "feedAdapter", "Lcom/shortreels/presentation/adapters/FeedAdapter;", "viewModel", "Lcom/shortreels/presentation/viewmodel/FeedViewModel;", "getViewModel", "()Lcom/shortreels/presentation/viewmodel/FeedViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "hideLoading", "", "observeViewModel", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onPause", "onResume", "onViewCreated", "view", "openComments", "videoId", "", "openProfile", "authorId", "openSeries", "seriesId", "setupGenreChips", "setupViewPager", "shareVideo", "showError", "message", "showLoading", "app_release"})
public final class FeedFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable()
    private com.shortreels.databinding.FragmentFeedBinding _binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    private com.shortreels.presentation.adapters.FeedAdapter feedAdapter;
    
    public FeedFragment() {
        super();
    }
    
    private final com.shortreels.databinding.FragmentFeedBinding getBinding() {
        return null;
    }
    
    private final com.shortreels.presentation.viewmodel.FeedViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupViewPager() {
    }
    
    private final void setupGenreChips() {
    }
    
    private final void observeViewModel() {
    }
    
    private final void showLoading() {
    }
    
    private final void hideLoading() {
    }
    
    private final void showError(java.lang.String message) {
    }
    
    private final void shareVideo(java.lang.String videoId) {
    }
    
    private final void openComments(java.lang.String videoId) {
    }
    
    private final void openProfile(java.lang.String authorId) {
    }
    
    private final void openSeries(java.lang.String seriesId) {
    }
    
    @java.lang.Override()
    public void onResume() {
    }
    
    @java.lang.Override()
    public void onPause() {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
}