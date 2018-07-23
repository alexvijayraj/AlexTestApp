package com.alexvijayraj.alextestapp.logger

import android.util.Log

class Log {

    companion object {

        fun d(tag: String, text: String){

            Log.d(tag, text)

        }

        fun e(tag: String, text: String){

            Log.e(tag, text)

        }

    }

}