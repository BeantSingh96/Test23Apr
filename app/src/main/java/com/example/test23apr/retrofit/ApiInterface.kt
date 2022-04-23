package com.example.test23apr.retrofit

import okhttp3.ResponseBody
import retrofit2.Call

import retrofit2.http.GET


interface ApiInterface {

    @GET("all")
    fun getEmojies(): Call<ArrayList<SmilyPojo>?>?
}