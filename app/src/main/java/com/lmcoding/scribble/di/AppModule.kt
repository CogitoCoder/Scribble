package com.lmcoding.scribble.di

import android.app.Application
import android.content.Context
import com.google.gson.Gson
import com.lmcoding.scribble.data.remote.api.SetupApi
import com.lmcoding.scribble.data.remote.ws.CustomGsonMessageAdapter
import com.lmcoding.scribble.data.remote.ws.DrawingApi
import com.lmcoding.scribble.data.remote.ws.FlowStreamAdapter
import com.lmcoding.scribble.repository.DefaultSetupRepository
import com.lmcoding.scribble.repository.SetupRepository
import com.lmcoding.scribble.util.Constants.HTTP_BASE_URL
import com.lmcoding.scribble.util.Constants.HTTP_BASE_URL_LOCALHOST
import com.lmcoding.scribble.util.Constants.RECONNECT_INTERVAL
import com.lmcoding.scribble.util.Constants.USE_LOCALHOST
import com.lmcoding.scribble.util.Constants.WS_BASE_URL
import com.lmcoding.scribble.util.Constants.WS_BASE_URL_LOCALHOST
import com.lmcoding.scribble.util.DispatcherProvider
import com.lmcoding.scribble.util.clientId
import com.lmcoding.scribble.util.dataStore
import com.tinder.scarlet.Scarlet
import com.tinder.scarlet.lifecycle.android.AndroidLifecycle
import com.tinder.scarlet.retry.LinearBackoffStrategy
import com.tinder.scarlet.websocket.okhttp.newWebSocketFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@ExperimentalCoroutinesApi
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideOkHttpClient(clientId: String): OkHttpClient {
        return OkHttpClient.Builder()
                .addInterceptor { chain ->
                    val url = chain.request().url.newBuilder()
                            .addQueryParameter("client_id", clientId)
                            .build()
                    val request = chain.request().newBuilder()
                            .url(url)
                            .build()
                    chain.proceed(request)
                }
                .addInterceptor(HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                })
                .build()
    }

    @Singleton
    @Provides
    fun provideClientId(@ApplicationContext context: Context): String {
        return runBlocking { context.dataStore.clientId() }
    }

    @Singleton
    @Provides
    fun provideApplicationContext(
            @ApplicationContext context: Context
    ) = context

    @Singleton
    @Provides
    fun provideGsonInstance(): Gson {
        return Gson()
    }

    @Singleton
    @Provides
    fun provideDispatcherProvider(): DispatcherProvider {
        return object : DispatcherProvider {
            override val main: CoroutineDispatcher
                get() = Dispatchers.Main
            override val io: CoroutineDispatcher
                get() = Dispatchers.IO
            override val default: CoroutineDispatcher
                get() = Dispatchers.Default
        }
    }
}