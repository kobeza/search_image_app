package com.kobeza.remote

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {

        return chain.request().newBuilder().let { request ->

            chain.request().url.let { originalHttpUrl ->

                originalHttpUrl.newBuilder().addQueryParameter(KEY, BuildConfig.AUTH_KEY).build()
                    .let {

                        request.url(it).let {

                            chain.proceed(it.build())
                        }
                    }
            }
        }
    }

    companion object {
        private const val KEY = "key"
    }
}