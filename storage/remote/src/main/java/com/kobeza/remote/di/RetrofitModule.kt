package com.kobeza.remote.di

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.kobeza.remote.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitModule {
    fun get() = Kodein.Module("RetrofitModule") {
        bind<Retrofit>() with singleton {
            Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .client(instance())
                .build()
        }

        bind<OkHttpClient>() with singleton {
            val builder = OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(instance<Interceptor>())
                .retryOnConnectionFailure(true)

            if (BuildConfig.DEBUG) {

                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }.let {
                    builder.addNetworkInterceptor(it)
                }
            }
            builder.build()
        }
    }
}