package com.example.test23apr.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    private val baseUrl = "https://emojihub.herokuapp.com/api/"

    private var instance: RetrofitClient? = null
    private var retrofit : Retrofit? = null

    init {
        retrofit = Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Synchronized
    fun getInstance(): RetrofitClient? {
        if (instance == null) {
            instance = RetrofitClient()
        }
        return instance
    }

    fun getApi(): ApiInterface? {
        return retrofit!!.create(ApiInterface::class.java)
    }
}