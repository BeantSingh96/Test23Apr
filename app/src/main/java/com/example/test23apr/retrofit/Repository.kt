package com.example.test23apr.retrofit

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Repository(val application: Application) {
    private var emojis: MutableLiveData<ArrayList<SmilyPojo>?>? = null

    init {

        emojis = MutableLiveData<ArrayList<SmilyPojo>?>()
    }

    fun callAPI(): MutableLiveData<ArrayList<SmilyPojo>?>? {
        val call: Call<ArrayList<SmilyPojo>?>? =
            RetrofitClient().getInstance()!!.getApi()!!.getEmojies()

        call!!.enqueue(object : Callback<ArrayList<SmilyPojo>?> {
            override fun onResponse(
                call: Call<ArrayList<SmilyPojo>?>, response: Response<ArrayList<SmilyPojo>?>
            ) {
                if (response.isSuccessful) {
                    if (response.body() != null) {

                        emojis!!.postValue(response.body())
                    } else {

                        Toast.makeText(
                            application.applicationContext, "response body null message",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                } else {
                    Toast.makeText(
                        application.applicationContext, "response error",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onFailure(call: Call<ArrayList<SmilyPojo>?>, t: Throwable) {
                Toast.makeText(
                    application.applicationContext, "error message " + t.message,
                    Toast.LENGTH_SHORT
                ).show()
                emojis!!.postValue(null)
            }

        })
        return emojis
    }

}