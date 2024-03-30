package com.example.pr5_graf;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.view.View;
import android.widget.Button;

import java.util.Timer;
import java.util.TimerTask;



public class MainActivity extends AppCompatActivity
{
    TextView tv_timer;
    int time = 0;

    Timer timer;
    TimerTask mTimerTask;
    boolean active = false;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_timer = findViewById(R.id.tv_timer);
    }
    protected void OnStart(View view)
    {
        active = !active;
        if(active)
        {
            if (timer != null)
            {
                timer.cancel();
            }
            timer = new Timer();
            mTimerTask = new MyTimerTask();
            timer.schedule(mTimerTask, 0, 1000);
            Button button = findViewById(R.id.button3);
            button.setText("СТОП");
        }
        else {
            if(timer != null)
            {
                timer.cancel();
            }
            timer = null;
            Button button = findViewById(R.id.button3);
            button.setText("ПРОДОЛЖИТЬ");
        }
    }
    public void onClear(View view){
        if(timer != null)
        {
            timer.cancel();
        }
        timer = null;
        time = 0;
        tv_timer.setText("00:00:00");
        Button button = findViewById(R.id.button2);
        button.setText("НАЧАТЬ");
    }
}