package com.alexvijayraj.alextestapp.canvasActivity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Region;
import android.graphics.Shader;
import android.os.Build;

public class HomeOverlay {

    public static Bitmap getBitMap(int width, int height){

        Bitmap bitMap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        bitMap = bitMap.copy(bitMap.getConfig(), true);

        Canvas canvas = new Canvas(bitMap);

        drawCircle(canvas, width, height);

        clipCircle(canvas, width, height);

        drawShadowCircle(canvas, width, height);

        drawBackground(canvas);

        return bitMap;

    }

    private static void clipCircle(Canvas canvas, int width, int height) {

        Path path = new Path();

        path.addCircle(width / 2, height / 2, width / 3, Path.Direction.CCW);

        canvas.clipPath(path,  Region.Op.DIFFERENCE);

    }

    private static void drawShadowCircle(Canvas canvas, int width, int height) {

        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.FILL);
        paint.setShader(new RadialGradient(width / 2, height / 2,
                (width/3) * 1.1f, Color.BLACK, Color.TRANSPARENT, Shader.TileMode.CLAMP));

        canvas.drawCircle(width/2, height/2, (width/3) * 1.1f , paint);

    }

    private static void drawCircle(Canvas canvas, int width, int height) {

        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(6f);
        canvas.drawCircle(width/2, height/2, width/3, paint);

    }

    private static void drawBackground(Canvas canvas) {

        canvas.drawColor(0xdd007600);

    }

}
