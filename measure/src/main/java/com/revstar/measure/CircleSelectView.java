package com.revstar.measure;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * Create on 2019/1/17 16:03
 * author revstar
 * Email 1967919189@qq.com
 */
public class CircleSelectView extends View {

    //里面圆的颜色
    private int inCircleColor;
    private Paint mPaintInCircle=new Paint(Paint.ANTI_ALIAS_FLAG);

    //外部边框圆的颜色
    private int outCircleColor;
    private Paint mPaintOutSideCircle =new Paint(Paint.ANTI_ALIAS_FLAG);
    //选中状态圆的颜色
    private int selectCircleColor;
    private Paint mPaintSelectCircle =new Paint(Paint.ANTI_ALIAS_FLAG);
    //折线的颜色
    private int lineColor;
    private Paint mPaintLine =new Paint(Paint.ANTI_ALIAS_FLAG);
    //文字颜色
    private int textColor;
    private Paint mPaintText=new Paint(Paint.ANTI_ALIAS_FLAG);
    //什么颜色
    private String colorString;

    public CircleSelectView(Context context) {
        this(context,null);
    }

    public CircleSelectView(Context context, @Nullable AttributeSet attrs) {
       this(context,attrs,0);

    }

    public CircleSelectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs);
    }


    private void init(Context context,AttributeSet attrs){

        TypedArray ta=context.obtainStyledAttributes(attrs,R.styleable.CircleSelectView);
        //获取里面圆的颜色
        inCircleColor=ta.getColor(R.styleable.CircleSelectView_inCircleColor,Color.BLACK);
        mPaintInCircle.setColor(inCircleColor);
        //获取外部边框圆的颜色
        outCircleColor=ta.getColor(R.styleable.CircleSelectView_outCircleColor,Color.BLUE);
        mPaintOutSideCircle.setColor(outCircleColor);
        //选中圆的颜色
        selectCircleColor=ta.getColor(R.styleable.CircleSelectView_selectCircleColor,Color.BLUE);
        mPaintSelectCircle.setColor(selectCircleColor);
        //折线圆的颜色
        lineColor=ta.getColor(R.styleable.CircleSelectView_lineColor,Color.WHITE);
        mPaintLine.setColor(lineColor);
        mPaintLine.setStrokeWidth(2);
        //文字颜色
        textColor=ta.getColor(R.styleable.CircleSelectView_textColor,Color.GREEN);
        mPaintText.setColor(textColor);
        mPaintText.setTextSize(30);
        //什么颜色
        colorString=ta.getString(R.styleable.CircleSelectView_colorString);


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width=getWidth();
        int height=getHeight();
        //设置padding
        int radious=Math.min(width,height)/4;
        canvas.translate(width/2,height/2);
        canvas.save();
        //外面圆的颜色
        canvas.drawCircle(0,0,radious+3,mPaintOutSideCircle);
        //里面圆的颜色
        canvas.drawCircle(0,0,radious,mPaintInCircle);

        canvas.translate(-radious,-radious/2);
        canvas.save();
        //选中圆的颜色
        int selectRadious=13;
        canvas.drawCircle(0,0,selectRadious,mPaintSelectCircle);

        canvas.translate(-selectRadious/8,selectRadious/6);
        canvas.save();
        //折线
        canvas.drawLine(0,0,-selectRadious/5,-selectRadious/5,mPaintLine);
        canvas.drawLine(0,0,selectRadious/3,-selectRadious/3,mPaintLine);


        //文字
        canvas.restoreToCount(1);
        canvas.translate(-width/2,0);
        String testString = "红色";
        Paint mPaint = new Paint();
        mPaint.setStrokeWidth(3);
        mPaint.setTextSize(15);
        mPaint.setColor(Color.BLACK);
        mPaint.setTextAlign(Paint.Align.LEFT);
        Rect bounds = new Rect();
        mPaint.getTextBounds(colorString, 0, testString.length(), bounds);
        canvas.drawText(colorString, getMeasuredWidth() / 2 - bounds.width() / 2, radious*5/4+15, mPaint);
        canvas.translate(-width/2,0);




    }

  public void isSelect(boolean isSelect,int color){
        if (isSelect){
            return;
        }
      //获取里面圆的颜色
      inCircleColor=color;
      mPaintInCircle.setColor(inCircleColor);
      //选中圆的颜色
      selectCircleColor=Color.WHITE;
      mPaintSelectCircle.setColor(selectCircleColor);

  }
}
