package com.shortreels.presentation.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import com.shortreels.R;
import com.shortreels.databinding.ActivityMainBinding;
import com.shortreels.presentation.viewmodel.AuthViewModel;
import com.shortreels.presentation.viewmodel.AuthUiState;
import com.shortreels.presentation.ui.auth.AuthActivity;
import dagger.hilt.android.AndroidEntryPoint;

/**
 * MainActivity - Root activity hosting the bottom nav and NavHostFragment.
 * Tabs: Feed | Explore | (Add) | Library | Profile
 */
@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\u0012\u0010\u0010\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0014J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u000eH\u0002J\b\u0010\u0016\u001a\u00020\u000eH\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/shortreels/presentation/ui/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "authViewModel", "Lcom/shortreels/presentation/viewmodel/AuthViewModel;", "getAuthViewModel", "()Lcom/shortreels/presentation/viewmodel/AuthViewModel;", "authViewModel$delegate", "Lkotlin/Lazy;", "binding", "Lcom/shortreels/databinding/ActivityMainBinding;", "navController", "Landroidx/navigation/NavController;", "navigateToAuth", "", "observeAuthState", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onSupportNavigateUp", "", "setupEdgeToEdge", "setupNavigation", "app_debug"})
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.shortreels.databinding.ActivityMainBinding binding;
    private androidx.navigation.NavController navController;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy authViewModel$delegate = null;
    
    public MainActivity() {
        super();
    }
    
    private final com.shortreels.presentation.viewmodel.AuthViewModel getAuthViewModel() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupEdgeToEdge() {
    }
    
    private final void setupNavigation() {
    }
    
    private final void observeAuthState() {
    }
    
    private final void navigateToAuth() {
    }
    
    @java.lang.Override()
    public boolean onSupportNavigateUp() {
        return false;
    }
}