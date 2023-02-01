package com.example.whitelabel.di

import com.example.whitelabel.network.DummyApi
import com.skydoves.sandwich.adapters.ApiResponseCallAdapterFactory
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideClient(): OkHttpClient {

        val loggingInterceptor =
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC)

        val builder = OkHttpClient().newBuilder()
            .connectTimeout(35, TimeUnit.SECONDS)
            .readTimeout(35, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor)

        return builder.build()
    }


    @Singleton
    @Provides
    fun provideApi(client: OkHttpClient): DummyApi {
        /**
         * We instantiate moshi.
         * */
        val moshi = Moshi
            .Builder()
            .build()

        /**
         * With the help of Retrofit we can communicate with the Pokemon API.
         * [*] Base Url, the base url of the api [Mondatory]
         * [*] Client, we use the OkHttpClient we created above [Mondatory]
         * [*] A kotlin coroutines factory and the a moshi factory [Mondatory]
         * */
        return Retrofit.Builder()
            .baseUrl("/")
            .client(client)
            .addCallAdapterFactory(ApiResponseCallAdapterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create(moshi).asLenient())
            .build()
            .create(DummyApi::class.java)
    }


}