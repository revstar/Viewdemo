package com.revstar.measure;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;

import androidx.appcompat.widget.AppCompatTextView;

/**
 * Create on 2019/1/17 10:43
 * author revstar
 * Email 1967919189@qq.com
 */
public class MyTextView extends AppCompatTextView {

    public static final String TAG="MyTextView";
    public MyTextView(Context context) {
        super(context);
    }

    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        String testString = "测试：gafaeh:1234";
        Paint mPaint = new Paint();
        mPaint.setStrokeWidth(3);
        mPaint.setTextSize(15);
        mPaint.setColor(Color.RED);
        mPaint.setTextAlign(Paint.Align.LEFT);
        Rect bounds = new Rect();
        mPaint.getTextBounds(testString, 0, testString.length(), bounds);
        Paint.FontMetricsInt fontMetrics = mPaint.getFontMetricsInt();
        int baseline = (getMeasuredHeight() - fontMetrics.bottom + fontMetrics.top) / 2 - fontMetrics.top;
        canvas.drawText(testString, getMeasuredWidth() / 2 - bounds.width() / 2, baseline, mPaint);

    }
}
