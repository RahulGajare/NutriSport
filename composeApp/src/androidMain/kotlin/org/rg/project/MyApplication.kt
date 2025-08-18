package org.rg.project

import android.app.Application
import com.google.firebase.Firebase
import com.google.firebase.initialize
import org.koin.android.ext.koin.androidContext
import org.rg.di.initializeKoin

class MyApplication : Application()
{
    override fun onCreate() {
        super.onCreate()
        initializeKoin(
            config  = { androidContext(this@MyApplication)

            }
        )
        Firebase.initialize(context = this)
    }
}