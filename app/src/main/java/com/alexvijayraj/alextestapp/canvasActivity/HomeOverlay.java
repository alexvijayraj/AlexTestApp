package com.alexvijayraj.alextestapp.canvasActivity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;

public class HomeOverlay {

    public static Bitmap getBitMap(int width, int height){

        Bitmap bitMap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);

        bitMap = bitMap.copy(bitMap.getConfig(), true);
        // Construct a canvas with the specified bitmap to draw into
        Canvas canvas = new Canvas(bitMap);
        // Create a new paint with default settings.
        Paint paint = new Paint();
        // smooths out the edges of what is being drawn
        paint.setAntiAlias(true);
        // set color
        paint.setColor(Color.WHITE);
        // set style
        paint.setStyle(Paint.Style.STROKE);
        // set stroke
        paint.setStrokeWidth(4.5f);

        canvas.drawColor(0xdd007600);

//        canvas.drawCircle(width/2, height/2, width/3, paint);

        Path path = new Path();

        path.addCircle(width/2, height/2, width/3, Path.Direction.CCW);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            canvas.clipOutPath(path);

        }else{

            canvas.clipPath(path);

        }

        return bitMap;

    }

}
