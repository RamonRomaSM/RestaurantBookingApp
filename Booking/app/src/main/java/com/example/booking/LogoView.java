package com.example.booking;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.view.View;

import androidx.annotation.NonNull;

public class LogoView extends View {
    public LogoView(Context context){
        super(context);

    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        Paint pincel = new Paint();
        Path trazo = new Path();
        RectF contorno = new RectF(100,100,900,900);
        trazo.addArc(contorno,180,180);
        pincel.setColor(Color.BLACK);
        pincel.setStrokeWidth(12);
        pincel.setStyle(Paint.Style.FILL);
        pincel.setTextSize(100);
        pincel.setTypeface(Typeface.SANS_SERIF);
        canvas.drawTextOnPath("BooKing", trazo, 450, 100, pincel);
        Path otroTrazo = new Path();
        otroTrazo.addCircle(520, 500, 500, Path.Direction.CCW);
        pincel.setColor(Color.BLUE);
        pincel.setStrokeWidth(16);
        pincel.setStyle(Paint.Style.STROKE);
        canvas.drawPath(otroTrazo, pincel);
    }
}
