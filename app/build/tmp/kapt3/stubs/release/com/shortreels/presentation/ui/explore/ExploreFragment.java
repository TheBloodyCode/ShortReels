package com.shortreels.presentation.ui.explore;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.shortreels.databinding.FragmentExploreBinding;
import com.shortreels.presentation.adapters.SeriesGridAdapter;
import com.shortreels.presentation.adapters.VideoSearchAdapter;
import com.shortreels.presentation.viewmodel.ExploreViewModel;
import com.shortreels.presentation.viewmodel.SearchResultState;
import com.shortreels.utils.NetworkResult;
import dagger.hilt.android.AndroidEntryPoint;

/**
 * ExploreFragment - Discover new series and videos.
 * Features: Search bar, trending section, category grid, featured series.
 */
@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0002J$\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0013H\u0016J\u001a\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001f\u001a\u00020\u0013H\u0002J\b\u0010 \u001a\u00020\u0013H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006!"}, d2 = {"Lcom/shortreels/presentation/ui/explore/ExploreFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/shortreels/databinding/FragmentExploreBinding;", "binding", "getBinding", "()Lcom/shortreels/databinding/FragmentExploreBinding;", "searchAdapter", "Lcom/shortreels/presentation/adapters/VideoSearchAdapter;", "seriesAdapter", "Lcom/shortreels/presentation/adapters/SeriesGridAdapter;", "viewModel", "Lcom/shortreels/presentation/viewmodel/ExploreViewModel;", "getViewModel", "()Lcom/shortreels/presentation/viewmodel/ExploreViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "observeViewModel", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onViewCreated", "view", "setupRecyclerViews", "setupSearch", "app_release"})
public final class ExploreFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable()
    private com.shortreels.databinding.FragmentExploreBinding _binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    private com.shortreels.presentation.adapters.SeriesGridAdapter seriesAdapter;
    private com.shortreels.presentation.adapters.VideoSearchAdapter searchAdapter;
    
    public ExploreFragment() {
        super();
    }
    
    private final com.shortreels.databinding.FragmentExploreBinding getBinding() {
        return null;
    }
    
    private final com.shortreels.presentation.viewmodel.ExploreViewModel getViewModel() {
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
    
    private final void setupSearch() {
    }
    
    private final void setupRecyclerViews() {
    }
    
    private final void observeViewModel() {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
}