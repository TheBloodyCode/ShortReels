package com.shortreels.data.repository;

import com.shortreels.data.local.dao.*;
import com.shortreels.data.local.entities.*;
import com.shortreels.data.remote.api.ExtractorApi;
import com.shortreels.data.remote.api.ShortReelsApiService;
import com.shortreels.data.remote.dto.ExtractorVideoDto;
import com.shortreels.data.remote.models.*;
import com.shortreels.domain.model.*;
import com.shortreels.utils.NetworkResult;
import kotlinx.coroutines.flow.Flow;
import javax.inject.Inject;
import javax.inject.Singleton;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0000\u001a\u00020\u0003*\u00020\u0004\u001a\n\u0010\u0000\u001a\u00020\u0005*\u00020\u0006\u001a\n\u0010\u0000\u001a\u00020\u0005*\u00020\u0007\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\b\u001a\n\u0010\u0000\u001a\u00020\u0003*\u00020\t\u001a\n\u0010\u0000\u001a\u00020\u0005*\u00020\n\u001a\n\u0010\u000b\u001a\u00020\u0002*\u00020\b\u001a\n\u0010\u000b\u001a\u00020\u0004*\u00020\t\u001a\n\u0010\u000b\u001a\u00020\u0006*\u00020\n\u00a8\u0006\f"}, d2 = {"toDomain", "Lcom/shortreels/domain/model/Series;", "Lcom/shortreels/data/local/entities/SeriesEntity;", "Lcom/shortreels/domain/model/User;", "Lcom/shortreels/data/local/entities/UserEntity;", "Lcom/shortreels/domain/model/Video;", "Lcom/shortreels/data/local/entities/VideoEntity;", "Lcom/shortreels/data/remote/dto/ExtractorVideoDto;", "Lcom/shortreels/data/remote/models/SeriesDto;", "Lcom/shortreels/data/remote/models/UserDto;", "Lcom/shortreels/data/remote/models/VideoDto;", "toEntity", "app_debug"})
public final class RepositoriesKt {
    
    @org.jetbrains.annotations.NotNull()
    public static final com.shortreels.data.local.entities.VideoEntity toEntity(@org.jetbrains.annotations.NotNull()
    com.shortreels.data.remote.models.VideoDto $this$toEntity) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final com.shortreels.domain.model.Video toDomain(@org.jetbrains.annotations.NotNull()
    com.shortreels.data.remote.models.VideoDto $this$toDomain) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final com.shortreels.domain.model.Video toDomain(@org.jetbrains.annotations.NotNull()
    com.shortreels.data.local.entities.VideoEntity $this$toDomain) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final com.shortreels.domain.model.Video toDomain(@org.jetbrains.annotations.NotNull()
    com.shortreels.data.remote.dto.ExtractorVideoDto $this$toDomain) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final com.shortreels.data.local.entities.SeriesEntity toEntity(@org.jetbrains.annotations.NotNull()
    com.shortreels.data.remote.models.SeriesDto $this$toEntity) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final com.shortreels.domain.model.Series toDomain(@org.jetbrains.annotations.NotNull()
    com.shortreels.data.remote.models.SeriesDto $this$toDomain) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final com.shortreels.domain.model.Series toDomain(@org.jetbrains.annotations.NotNull()
    com.shortreels.data.local.entities.SeriesEntity $this$toDomain) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final com.shortreels.domain.model.User toDomain(@org.jetbrains.annotations.NotNull()
    com.shortreels.data.remote.models.UserDto $this$toDomain) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final com.shortreels.data.local.entities.UserEntity toEntity(@org.jetbrains.annotations.NotNull()
    com.shortreels.data.remote.models.UserDto $this$toEntity) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final com.shortreels.domain.model.User toDomain(@org.jetbrains.annotations.NotNull()
    com.shortreels.data.local.entities.UserEntity $this$toDomain) {
        return null;
    }
}