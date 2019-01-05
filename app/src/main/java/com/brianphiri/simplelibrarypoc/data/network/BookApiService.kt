package com.brianphiri.simplelibrarypoc.data.network

import androidx.lifecycle.LiveData
import com.brianphiri.simplelibrarypoc.data.model.Book
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.POST

interface BookApiService {
    @GET
    fun getBooks(): LiveData<List<Book>>

    @POST
    fun postBook(book: Book)

    companion object {
        operator fun invoke(): BookApiService{
            val requesInterceptor = Interceptor{chain ->
                val request = chain.request().newBuilder().build()

                return@Interceptor chain.proceed(request)
            }

            val okHttpClient = OkHttpClient.Builder().addInterceptor(requesInterceptor).build()

            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("https://api.apixu.com/v1/")
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(BookApiService::class.java)
        }
    }
}