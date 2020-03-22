package com.zhoujian.scalableimageview.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.view.GestureDetectorCompat;

import com.zhoujian.scalableimageview.utils.Utils;

public class ScalableImageView extends View {
    //图片宽度
    private static final float IMAGE_WIDTH = Utils.dpToPixel(300);

    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    private Bitmap bitmap;

    //x轴偏移
    private float offsetX;

    //y轴偏移
    private float offsetY;

    private float bigScale;
    private float smallScale;

    //触摸及手势识别
    private GestureDetectorCompat detectorCompat;

    public ScalableImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        bitmap = Utils.getAvatar(getResources(), (int) IMAGE_WIDTH);
//        detectorCompat = new GestureDetectorCompat(context,)
    }

    /**
     * 每次尺寸改变的时候调用
     *
     * @param w
     * @param h
     * @param width
     * @param height
     */
    @Override
    protected void onSizeChanged(int w, int h, int width, int height) {
        super.onSizeChanged(w, h, width, height);
        offsetX = (getWidth() - bitmap.getWidth()) / 2f;
        offsetY = (getHeight() - bitmap.getHeight()) / 2f;

        if ((float) bitmap.getWidth() / bitmap.getHeight() > (float) getWidth() / getHeight()) {
            smallScale = (float) getWidth() / bitmap.getWidth();
            bigScale = (float) getHeight() / bitmap.getHeight();
        } else {
            smallScale = (float) getHeight() / bitmap.getHeight();
            bigScale = (float) getWidth() / bitmap.getWidth();
        }
    }

    /**
     * 绘制
     *
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //计算缩放比
        float scale = bigScale;
        //缩放
        canvas.scale(scale, scale, getWidth() / 2f, getHeight() / 2f);
        canvas.drawBitmap(bitmap, offsetX, offsetY, paint);
    }
}
