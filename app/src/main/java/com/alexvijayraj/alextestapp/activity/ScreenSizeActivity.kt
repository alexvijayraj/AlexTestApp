package com.alexvijayraj.alextestapp.activity

import android.os.Bundle
import com.alexvijayraj.alextestapp.R
import kotlinx.android.synthetic.main.activity_screen_size.*

class ScreenSizeActivity : BaseActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen_size)

    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)

        if(hasFocus){

            val screenSize = "" + ivScreenSize.width + "w  X  " + ivScreenSize.height + "h"

            tvScreenSize.setText(screenSize)

        }

    }

}
