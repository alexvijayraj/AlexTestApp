package com.alexvijayraj.alextestapp.activity

import android.content.Intent
import android.os.Bundle
import android.widget.RelativeLayout
import com.alexvijayraj.alextestapp.R
import kotlinx.android.synthetic.main.activity_main.*
import android.util.TypedValue

var tests: List<RelativeLayout>? = null;

val OPEN_CANVAS_ACTIVITY = 1
val OPEN_CONSTRAINT_ACTIVITY = 2
val OPEN_SCREEN_SIZE_ACTIVITY = 3

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //add relative layouts to list
        tests = listOf(rlElementCanvas, rlElementConstraint, rlElementScreenSize)

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

            if(relativeLayout == rlElementCanvas){

                openActivity(OPEN_CANVAS_ACTIVITY)

            }else if(relativeLayout == rlElementConstraint){

                openActivity(OPEN_CONSTRAINT_ACTIVITY)

            }else if(relativeLayout == rlElementScreenSize){

                openActivity(OPEN_SCREEN_SIZE_ACTIVITY)

            }

        }

    }

    private fun openActivity(activityName: Int) {

        if(activityName == OPEN_CANVAS_ACTIVITY){

            val intent = Intent(this, CanvasActivity::class.java)
            startActivityForResult(intent, 0)

        }else if(activityName == OPEN_CONSTRAINT_ACTIVITY){

            val intent = Intent(this, ConstraintLayoutActivity::class.java)
            startActivityForResult(intent, 0)

        }else if(activityName == OPEN_SCREEN_SIZE_ACTIVITY){

            val intent = Intent(this, ScreenSizeActivity::class.java)
            startActivityForResult(intent, 0)

        }

    }

    private fun setRippleEffect(relativeLayout: RelativeLayout) {

        val outValue = TypedValue()
        getTheme().resolveAttribute(android.R.attr.selectableItemBackground, outValue, true)
        relativeLayout.setBackgroundResource(outValue.resourceId)

    }

}
