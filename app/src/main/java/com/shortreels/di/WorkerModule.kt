package com.shortreels.di

import androidx.work.WorkerFactory
import com.shortreels.workers.VideoDownloadWorker
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object WorkerModule
