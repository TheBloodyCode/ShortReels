package com.shortreels.data.local.dao

import androidx.room.*
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.shortreels.data.local.entities.*
import kotlinx.coroutines.flow.Flow

// ===== Type Converters =====
class Converters {
    private val gson = Gson()

    @TypeConverter
    fun fromStringList(value: List<String>?): String =
        gson.toJson(value ?: emptyList<String>())

    @TypeConverter
    fun toStringList(value: String): List<String> =
        gson.fromJson(value, object : TypeToken<List<String>>() {}.type) ?: emptyList()
}

// ===== Video DAO =====
@Dao
interface VideoDao {

    @Query("SELECT * FROM videos ORDER BY createdAt DESC LIMIT :limit OFFSET :offset")
    fun getFeedVideos(limit: Int = 20, offset: Int = 0): Flow<List<VideoEntity>>

    @Query("SELECT * FROM videos WHERE seriesId = :seriesId ORDER BY season, episode")
    fun getSeriesEpisodes(seriesId: String): Flow<List<VideoEntity>>

    @Query("SELECT * FROM videos WHERE genre = :genre ORDER BY viewCount DESC LIMIT :limit")
    fun getVideosByGenre(genre: String, limit: Int = 20): Flow<List<VideoEntity>>

    @Query("SELECT * FROM videos WHERE id = :videoId")
    suspend fun getVideoById(videoId: String): VideoEntity?

    @Query("SELECT * FROM videos WHERE isBookmarked = 1 ORDER BY cachedAt DESC")
    fun getBookmarkedVideos(): Flow<List<VideoEntity>>

    @Query("""
        SELECT v.* FROM videos v
        WHERE v.title LIKE '%' || :query || '%'
        OR v.description LIKE '%' || :query || '%'
        OR v.seriesTitle LIKE '%' || :query || '%'
        ORDER BY v.viewCount DESC
        LIMIT :limit
    """)
    suspend fun searchVideos(query: String, limit: Int = 30): List<VideoEntity>

    @Query("SELECT * FROM videos WHERE viewCount > 500000 ORDER BY viewCount DESC LIMIT 20")
    fun getTrendingVideos(): Flow<List<VideoEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertVideo(video: VideoEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertVideos(videos: List<VideoEntity>)

    @Update
    suspend fun updateVideo(video: VideoEntity)

    @Query("UPDATE videos SET isLiked = :isLiked WHERE id = :videoId")
    suspend fun updateLikeStatus(videoId: String, isLiked: Boolean)

    @Query("UPDATE videos SET isBookmarked = :isBookmarked WHERE id = :videoId")
    suspend fun updateBookmarkStatus(videoId: String, isBookmarked: Boolean)

    @Query("UPDATE videos SET watchProgress = :progress WHERE id = :videoId")
    suspend fun updateWatchProgress(videoId: String, progress: Float)

    @Query("UPDATE videos SET isDownloaded = :downloaded, localPath = :path WHERE id = :videoId")
    suspend fun updateDownloadStatus(videoId: String, downloaded: Boolean, path: String?)

    @Query("DELETE FROM videos WHERE cachedAt < :threshold AND isDownloaded = 0 AND isBookmarked = 0")
    suspend fun deleteOldCache(threshold: Long)

    @Query("DELETE FROM videos WHERE id = :videoId")
    suspend fun deleteVideo(videoId: String)
}

// ===== Series DAO =====
@Dao
interface SeriesDao {

    @Query("SELECT * FROM series ORDER BY cachedAt DESC")
    fun getAllSeries(): Flow<List<SeriesEntity>>

    @Query("SELECT * FROM series WHERE genre = :genre ORDER BY rating DESC LIMIT :limit")
    fun getSeriesByGenre(genre: String, limit: Int = 20): Flow<List<SeriesEntity>>

    @Query("SELECT * FROM series WHERE isFollowing = 1 ORDER BY cachedAt DESC")
    fun getFollowedSeries(): Flow<List<SeriesEntity>>

    @Query("SELECT * FROM series WHERE id = :seriesId")
    suspend fun getSeriesById(seriesId: String): SeriesEntity?

    @Query("""
        SELECT * FROM series
        WHERE title LIKE '%' || :query || '%'
        OR description LIKE '%' || :query || '%'
        ORDER BY rating DESC
        LIMIT :limit
    """)
    suspend fun searchSeries(query: String, limit: Int = 30): List<SeriesEntity>

    @Query("SELECT * FROM series ORDER BY rating DESC LIMIT 10")
    fun getTopRatedSeries(): Flow<List<SeriesEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSeries(series: SeriesEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSeriesList(seriesList: List<SeriesEntity>)

    @Query("UPDATE series SET isFollowing = :isFollowing WHERE id = :seriesId")
    suspend fun updateFollowStatus(seriesId: String, isFollowing: Boolean)

    @Query("DELETE FROM series WHERE id = :seriesId")
    suspend fun deleteSeries(seriesId: String)
}

// ===== User DAO =====
@Dao
interface UserDao {

    @Query("SELECT * FROM users WHERE id = :userId")
    suspend fun getUserById(userId: String): UserEntity?

    @Query("SELECT * FROM users LIMIT 1")
    fun getCurrentUser(): Flow<UserEntity?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: UserEntity)

    @Update
    suspend fun updateUser(user: UserEntity)

    @Query("DELETE FROM users WHERE id = :userId")
    suspend fun deleteUser(userId: String)

    @Query("DELETE FROM users")
    suspend fun deleteAll()
}

// ===== Comment DAO =====
@Dao
interface CommentDao {

    @Query("SELECT * FROM comments WHERE videoId = :videoId ORDER BY isPinned DESC, createdAt DESC LIMIT :limit")
    fun getVideoComments(videoId: String, limit: Int = 50): Flow<List<CommentEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertComment(comment: CommentEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertComments(comments: List<CommentEntity>)

    @Query("UPDATE comments SET isLiked = :isLiked, likeCount = likeCount + :delta WHERE id = :commentId")
    suspend fun toggleLike(commentId: String, isLiked: Boolean, delta: Int)

    @Query("DELETE FROM comments WHERE videoId = :videoId")
    suspend fun deleteVideoComments(videoId: String)
}

// ===== Watch History DAO =====
@Dao
interface WatchHistoryDao {

    @Query("SELECT * FROM watch_history WHERE userId = :userId ORDER BY watchedAt DESC LIMIT :limit")
    fun getWatchHistory(userId: String, limit: Int = 50): Flow<List<WatchHistoryEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHistory(history: WatchHistoryEntity)

    @Query("""
        UPDATE watch_history SET watchProgress = :progress, completed = :completed, watchedAt = :watchedAt
        WHERE userId = :userId AND videoId = :videoId
    """)
    suspend fun updateProgress(userId: String, videoId: String, progress: Float, completed: Boolean, watchedAt: Long)

    @Query("SELECT watchProgress FROM watch_history WHERE userId = :userId AND videoId = :videoId LIMIT 1")
    suspend fun getProgress(userId: String, videoId: String): Float?

    @Query("DELETE FROM watch_history WHERE userId = :userId")
    suspend fun clearHistory(userId: String)
}

// ===== Download DAO =====
@Dao
interface DownloadDao {

    @Query("SELECT * FROM downloads ORDER BY createdAt DESC")
    fun getAllDownloads(): Flow<List<DownloadEntity>>

    @Query("SELECT * FROM downloads WHERE status = 'COMPLETED' ORDER BY completedAt DESC")
    fun getCompletedDownloads(): Flow<List<DownloadEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDownload(download: DownloadEntity)

    @Query("UPDATE downloads SET progress = :progress, downloadedSize = :size, status = :status WHERE videoId = :videoId")
    suspend fun updateProgress(videoId: String, progress: Int, size: Long, status: String)

    @Query("UPDATE downloads SET status = 'COMPLETED', localPath = :path, completedAt = :completedAt WHERE videoId = :videoId")
    suspend fun markCompleted(videoId: String, path: String, completedAt: Long)

    @Query("UPDATE downloads SET status = 'FAILED' WHERE videoId = :videoId")
    suspend fun markFailed(videoId: String)

    @Query("DELETE FROM downloads WHERE videoId = :videoId")
    suspend fun deleteDownload(videoId: String)
}

// ===== Search History DAO =====
@Dao
interface SearchHistoryDao {

    @Query("SELECT * FROM search_history ORDER BY searchedAt DESC LIMIT 10")
    fun getSearchHistory(): Flow<List<SearchHistoryEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSearch(search: SearchHistoryEntity)

    @Query("DELETE FROM search_history WHERE query = :query")
    suspend fun deleteSearch(query: String)

    @Query("DELETE FROM search_history")
    suspend fun clearAll()
}
