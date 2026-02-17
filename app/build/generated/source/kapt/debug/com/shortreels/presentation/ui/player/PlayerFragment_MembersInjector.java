package com.shortreels.presentation.ui.player;

import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class PlayerFragment_MembersInjector implements MembersInjector<PlayerFragment> {
  private final Provider<VideoPlayerManager> playerManagerProvider;

  public PlayerFragment_MembersInjector(Provider<VideoPlayerManager> playerManagerProvider) {
    this.playerManagerProvider = playerManagerProvider;
  }

  public static MembersInjector<PlayerFragment> create(
      Provider<VideoPlayerManager> playerManagerProvider) {
    return new PlayerFragment_MembersInjector(playerManagerProvider);
  }

  @Override
  public void injectMembers(PlayerFragment instance) {
    injectPlayerManager(instance, playerManagerProvider.get());
  }

  @InjectedFieldSignature("com.shortreels.presentation.ui.player.PlayerFragment.playerManager")
  public static void injectPlayerManager(PlayerFragment instance,
      VideoPlayerManager playerManager) {
    instance.playerManager = playerManager;
  }
}
