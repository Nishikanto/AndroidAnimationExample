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
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by nishikanto on 6/5/17.
 */

public class Activity_Animation001_Layout extends SurfaceView implements Runnable {

    Thread thread = null;
    Boolean canDraw = false;
    Bitmap background;
    SurfaceHolder surfaceHolder;
    Canvas canvas;
    Paint red_paintbrush_fill, green_paintbrush_fill, blue_paintbrush_fill;
    Paint red_paintbrush_stroke, green_paintbrush_stroke, blue_paintbrush_stroke;
    Path triangle;
    private Rect rectangle;
    private Rect rectangle01;
    int x_dir, y_dir;
    private int mickey_height=200;
    private int mickey_width=300;
    private int mickey_x;
    private int mickey_y;
    private Bitmap mickey_bm;
    private int[] anims = new int[]{R.drawable.anim8, R.drawable.anim9, R.drawable.anim10, R.drawable.anim11};

    public Activity_Animation001_Layout(Context context) {
        super(context);
        surfaceHolder = getHolder();
        background = BitmapFactory.decodeResource(getResources(), R.drawable.bg2);


        x_dir = 1;
        y_dir = 1;
        mickey_x = 0;
        mickey_y = 100;

    }

    @Override
    public void run() {

        int i = 0;
        while (canDraw){

            try {
                thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            //carry out some drawing
            if(!surfaceHolder.getSurface().isValid()){
                continue;
            }

            canvas = surfaceHolder.lockCanvas();
            canvas.drawBitmap(background, 0, 0, null);

            mickey_bm= BitmapFactory.decodeResource(getResources(), anims[i]);
            mickey_bm = Bitmap.createScaledBitmap(mickey_bm, mickey_width, mickey_height, false);


            /*red_paintbrush_fill = new Paint();
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
            }*/





            mickey_y = mickey_y;

            canvas.drawBitmap(mickey_bm, mickey_x, mickey_y, null);
            mickey_x = mickey_x + 30;
            i+=1;
            if(i==4){
                i=0;
            }
            surfaceHolder.unlockCanvasAndPost(canvas);
        }

    }

    public void pause() {
        canDraw = false;

        while (true){
            try {
                thread.join();
                break;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        thread = null;


    }

    public void resume() {
        canDraw = true;
        thread = new Thread(this);
        thread.start();
    }
}
