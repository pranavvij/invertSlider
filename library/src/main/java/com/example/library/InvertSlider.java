package com.example.library;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.SeekBar;


public class InvertSlider extends SeekBar {

    private Drawable thumb;
    private Listener listener;

    public InvertSlider(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void setThumb(Drawable thumb) {
        super.setThumb(thumb);
        this.thumb = thumb;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if (event.getAction() == MotionEvent.ACTION_DOWN) {

            if (thumb.getBounds().contains((int) event.getX(), (int) event.getY())) {

                if (listener != null) listener.onInvertSlide();

                super.onTouchEvent(event);

            } else return false;

        } else if (event.getAction() == MotionEvent.ACTION_UP) {

            if (getProgress() < 50) setProgress(0);

            else setProgress(100);

            if (listener != null)
                listener.onInvertSlideCompleted(getProgress() == 0);

        } else super.onTouchEvent(event);

        return true;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    /**
     * Listens to the Events performed on the Sliding
     */
    public interface Listener {

        void onInvertSlide();

        void onInvertSlideCompleted(boolean isMax);
    }
}