package com.example.test23apr.retrofit

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class EmojiViewModel(application: Application) : AndroidViewModel(application) {

    private var repository: Repository = Repository(application)

    fun loadData(): MutableLiveData<ArrayList<SmilyPojo>?>? {

        return repository.callAPI()
    }
}