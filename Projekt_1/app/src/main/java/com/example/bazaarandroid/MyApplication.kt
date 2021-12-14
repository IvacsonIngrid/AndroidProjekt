package com.example.bazaarandroid

import android.app.Application
import com.example.bazaarandroid.utils.SessionManager

class MyApplication: Application(){
    companion object{
        var token: String ="\"04ddf0c5aebe7c9548481f3abe8d055f6e0c2e18eb3a58baab2f4230892baa155cb734b9eeb7616a793507f02dca48566d40fdea510a0de4f63657800bc07eab\""
        var limit: Int  = 100
    }
}