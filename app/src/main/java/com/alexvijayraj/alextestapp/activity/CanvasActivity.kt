package com.alexvijayraj.alextestapp.activity

import android.os.Bundle
import com.alexvijayraj.alextestapp.R
import com.alexvijayraj.alextestapp.canvasActivity.HomeOverlay
import com.alexvijayraj.alextestapp.logger.Log
import com.alexvijayraj.alextestapp.logger.Tag
import kotlinx.android.synthetic.main.activity_canvas.*

class CanvasActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_canvas)

    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)

        if(hasFocus){

            ivCanvas.setImageBitmap(HomeOverlay.getBitMap(ivCanvas.width, ivCanvas.height))

        }

    }

}
