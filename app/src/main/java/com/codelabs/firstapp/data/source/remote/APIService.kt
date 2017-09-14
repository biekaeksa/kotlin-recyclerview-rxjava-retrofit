package com.codelabs.firstapp.data.source.remote

import com.codelabs.firstapp.util.AppConstant
import com.codelabs.firstapp.data.MahasiswaModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import rx.Observable
import java.util.concurrent.TimeUnit

/**
 * Created by Biekaeksa on 9/9/2017.
 */
interface APIService {

    companion object {
        val BASE_URL: String = AppConstant.APIUrl.BASE_URL
    }

    @GET("makanan/{kategori}")
    fun loadFoodCategory(@Path("kategori") kategori: String): Observable<MahasiswaModel.MahasiswaDataModel>

    class factor {
        companion object {
            fun create(): APIService {
                val logging = HttpLoggingInterceptor()
                logging.level = HttpLoggingInterceptor.Level.BODY
                val builder = OkHttpClient().newBuilder()
                builder.addInterceptor(logging)
                builder.readTimeout(20, TimeUnit.SECONDS)
                builder.connectTimeout(10, TimeUnit.SECONDS)
                builder.writeTimeout(10, TimeUnit.SECONDS)

                val client = builder.build()
                val retrofit = Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .client(client)
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                        .build()

                return retrofit.create(APIService::class.java)
            }
        }
    }
}