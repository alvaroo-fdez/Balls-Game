package org.izv.aff.balls.EasyDiff;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import org.izv.aff.balls.ComprobacionBallsActivity;
import org.izv.aff.balls.R;

public class DifficultyActivity extends AppCompatActivity {
    public static int MILISEGUNDOS_ESPERA = 5000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty);

        final BouncingBallInside bouncingballi = new BouncingBallInside(this);
        setContentView(bouncingballi);

        esperarYCambiar(MILISEGUNDOS_ESPERA);
    }

    public void esperarYCambiar(int milisegundos) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                // acciones que se ejecutan tras los milisegundos
                Intent intent = new Intent(DifficultyActivity.this, ComprobacionBallsActivity.class);
                intent.putExtra("nbolas","4");
                startActivity(intent);
            }
        }, milisegundos);
    }
}