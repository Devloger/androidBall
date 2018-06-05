package com.example.a219.kulka;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;


public class ViewKulki extends View {


    private float x = 50;
    private float y = 200;

    private float mx;
    private float my;

    private float dx = 0;
    private float dy = 0;

    private ViewKulki header;

    public ViewKulki(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ViewKulki(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public ViewKulki(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public ViewKulki(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        header = this;
        ViewTreeObserver vto = header.getViewTreeObserver();

        if(vto!=null){
            vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                @Override
                public void onGlobalLayout() {
                    mx = header.getWidth();
                    my = header.getHeight();
                }
            });
        }


        System.out.println(mx + "+++" + my);


        int radius = 50;
        int startingY = 200;

        Paint p = new Paint(Paint.ANTI_ALIAS_FLAG);
        p.setARGB(0,0, 0, 0);
        canvas.drawCircle(x, y, 50, p);


        if (((x>radius || dx>0) && (x<mx-radius || dx<0))) {
            x = x + dx;
        }
        if (((y>startingY || dy>0) && (y<my-radius || dy<0))) {
            y = y + dy;
        }

        p.setARGB(255,200, 0, 255);
        canvas.drawCircle(x, y, 50, p);
    }

    public void setXsetY(float dx, float dy) {

        this.dx = dx;
        this.dy = dy;

        this.invalidate();
    }

    protected void onMeasure(final int widthMeasureSpec, final int heightMeasureSpec) {
        final int newHeight= MeasureSpec.getSize(heightMeasureSpec);
        final int newWidth= MeasureSpec.getSize(widthMeasureSpec);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
