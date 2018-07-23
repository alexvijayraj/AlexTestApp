package com.alexvijayraj.alextestapp.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.RelativeLayout
import com.alexvijayraj.alextestapp.R
import com.alexvijayraj.alextestapp.constants.constants
import kotlinx.android.synthetic.main.activity_main.*
import android.util.TypedValue
import android.os.Build
import com.alexvijayraj.alextestapp.logger.Log

var tests: List<RelativeLayout>? = null;

val OPEN_CANVAS_ACTIVITY = 1

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //add relative layouts to list
        tests = listOf(rlElement)

        init()
    }

    private fun init() {
        
        initClickListeners()

    }

    private fun initClickListeners() {
        
        for (relativeLayout in tests!!) {
            
            setRippleEffect(relativeLayout)
            
            setClickListener(relativeLayout)
            
        }
        
    }

    private fun setClickListener(relativeLayout: RelativeLayout) {

        relativeLayout.setOnClickListener {

            if(relativeLayout == rlElement){

                openActivity(OPEN_CANVAS_ACTIVITY)

            }

        }

    }

    private fun openActivity(activityName: Int) {

        if(activityName == OPEN_CANVAS_ACTIVITY){

            val intent = Intent(this, CanvasActivity::class.java)
            startActivityForResult(intent, 0)

        }

    }

    private fun setRippleEffect(relativeLayout: RelativeLayout) {

        val outValue = TypedValue()
        getTheme().resolveAttribute(android.R.attr.selectableItemBackground, outValue, true)
        relativeLayout.setBackgroundResource(outValue.resourceId)

    }

}
