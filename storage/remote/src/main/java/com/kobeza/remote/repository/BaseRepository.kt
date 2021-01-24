package com.kobeza.remote.repository

import kotlinx.coroutines.Deferred
import retrofit2.Response

abstract class BaseRepository {
    suspend fun <T> execute(call: (() -> Deferred<Response<T>?>)): T? {
        return try {

            call.invoke().await()?.let {
                if (it.isSuccessful) {
                    it.body()
                } else {
                    null
                }
            }
        } catch (e: Exception) {
            null
        }
    }
}