package com.example.cl_macmini81.invertslider;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.library.InvertSlider;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.sliderInvert) InvertSlider invertSlider;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }
}
