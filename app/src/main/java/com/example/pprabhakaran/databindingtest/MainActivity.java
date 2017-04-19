package com.example.pprabhakaran.databindingtest;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.pprabhakaran.databindingtest.databinding.ActivityMainBinding;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    Timer timer;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        DataModel dataModel = new DataModel(R.drawable.ic_pets_black_24dp,  getString(R.string.dog_name), getString(R.string.dog_summary));
        binding.setData(dataModel);

        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (i == 0) {
                            DataModel dataModel = new DataModel(R.drawable.ic_pets_black_24dp, getString(R.string.dog_name), getString(R.string.dog_summary));
                            binding.setData(dataModel);
                            i = 1;
                        } else {
                            i = 0;
                            DataModel dataModel = new DataModel(R.drawable.ic_sentiment_satisfied_black_24dp, getString(R.string.baby_name), getString(R.string.baby_summary));
                            binding.setData(dataModel);
                        }
                    }
                });
            }
        }, 3000, 3000);
    }

    @BindingAdapter({"android:src"})
    public static void setImageViewResource(ImageView imageView, int resource) {
        imageView.setImageResource(resource);
    }
}