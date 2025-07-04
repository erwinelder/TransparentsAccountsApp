package com.transparentaccountsapp

import android.app.Application
import com.transparentaccountsapp.di.initKoin
import org.koin.android.ext.koin.androidContext

class TransparentAccountsApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin {
            androidContext(this@TransparentAccountsApplication)
        }
    }

}