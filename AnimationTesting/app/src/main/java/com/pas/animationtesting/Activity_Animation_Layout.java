package com.pas.animationtesting;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;

/**
 * Created by nishikanto on 6/5/17.
 */

public class Activity_Animation_Layout extends View {

    private int mickey_x;
    private int mickey_y;
    Paint red_paintbrush_fill, green_paintbrush_fill, blue_paintbrush_fill;
    Paint red_paintbrush_stroke, green_paintbrush_stroke, blue_paintbrush_stroke;
    Path triangle;
    private Bitmap mickey_bm;
    private Rect rectangle;
    private Rect rectangle01;
    int x_dir, y_dir;
    private int mickey_height=500;
    private int mickey_width=500;


    public Activity_Animation_Layout(Context context) {
        super(context);

        setBackgroundResource(R.drawable.bg);
        inti();



    }

    private void inti() {
        x_dir = 1;
        y_dir = 1;
        mickey_x = 320;
        mickey_y = 470;

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mickey_bm= BitmapFactory.decodeResource(getResources(), R.drawable.head);
        mickey_bm = Bitmap.createScaledBitmap(mickey_bm, mickey_width, mickey_height, false);

        red_paintbrush_fill = new Paint();
        red_paintbrush_fill.setColor(Color.RED);
        red_paintbrush_fill.setStyle(Paint.Style.FILL);

        blue_paintbrush_fill = new Paint();
        blue_paintbrush_fill.setColor(Color.BLUE);
        blue_paintbrush_fill.setStyle(Paint.Style.FILL);

        green_paintbrush_fill = new Paint();
        green_paintbrush_fill.setColor(Color.GREEN);
        green_paintbrush_fill.setStyle(Paint.Style.FILL);


        red_paintbrush_stroke = new Paint();
        red_paintbrush_stroke.setColor(Color.RED);
        red_paintbrush_stroke.setStyle(Paint.Style.STROKE);
        red_paintbrush_stroke.setStrokeWidth(10);

        blue_paintbrush_stroke = new Paint();
        blue_paintbrush_stroke.setColor(Color.BLUE);
        blue_paintbrush_stroke.setStyle(Paint.Style.STROKE);
        blue_paintbrush_stroke.setStrokeWidth(10);

        green_paintbrush_stroke = new Paint();
        green_paintbrush_stroke.setColor(Color.GREEN);
        green_paintbrush_stroke.setStyle(Paint.Style.STROKE);
        green_paintbrush_stroke.setStrokeWidth(10);

        rectangle = new Rect();
        rectangle01 = new Rect();
        triangle = new Path();

        rectangle.set(210,125,250,175);
        canvas.drawRect(rectangle, green_paintbrush_stroke);


        rectangle01.set(420,125,460,175);
        canvas.drawRect(rectangle, red_paintbrush_fill);

        canvas.drawCircle(400,400,70, blue_paintbrush_stroke);
        canvas.drawCircle(400,400,20, green_paintbrush_fill);
        canvas.drawCircle(400,400,10, red_paintbrush_fill);


        triangle.moveTo(400,400);
        triangle.lineTo(600,600);
        triangle.moveTo(600,600);
        triangle.lineTo(200,600);
        triangle.moveTo(200,600);
        triangle.lineTo(400,400);

        canvas.drawPath(triangle, red_paintbrush_stroke);

        canvas.drawCircle(600,600,70, blue_paintbrush_stroke);
        canvas.drawCircle(600,600,20, green_paintbrush_fill);
        canvas.drawCircle(600,600,10, red_paintbrush_fill);

        canvas.drawCircle(200,600,70, blue_paintbrush_stroke);
        canvas.drawCircle(200,600,20, green_paintbrush_fill);
        canvas.drawCircle(200,600,10, red_paintbrush_fill);

        if(mickey_x>=canvas.getWidth()-mickey_width){
            x_dir = -1;
        }

        if(mickey_x<=0){
            x_dir = 1;
        }


        if(mickey_y>=canvas.getHeight()-mickey_height){
            y_dir = -1;
        }

        if(mickey_y<=0){
            y_dir = 1;
        }




        mickey_x = mickey_x + x_dir;
        mickey_y = mickey_y + y_dir;

        Log.d("simul", mickey_x+"");
        Log.d("simul", mickey_y+"");

        mickey_height = mickey_height+y_dir;
        mickey_width = mickey_width+x_dir;
        mickey_bm = Bitmap.createScaledBitmap(mickey_bm, mickey_width+x_dir, mickey_height+y_dir, false);
        canvas.drawBitmap(mickey_bm, mickey_x, mickey_y, null);


        invalidate();




    }
}
