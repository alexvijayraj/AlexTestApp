package com.alexvijayraj.alextestapp.application

import android.app.Application
import com.alexvijayraj.alextestapp.logger.Log
import com.alexvijayraj.alextestapp.logger.Tag

class AlexTestApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        Log.d(Tag.APPLICATION, "Application Started")

    }
}