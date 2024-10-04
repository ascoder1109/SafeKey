package com.ascoder1109.securekey.di

import com.ascoder1109.securekey.data.repository.UserRepository
import com.google.android.datatransport.runtime.dagger.Module
import com.google.android.datatransport.runtime.dagger.Provides

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun provideUserRepository(): UserRepository {
        return UserRepository()
    }
}