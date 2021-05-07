package com.peter.appwork_midterm.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.peter.appwork_midterm.data.ContentData

class HomeViewModel():ViewModel() {

    var item = MutableLiveData<ContentData>()



}