package org.izv.aff.balls.HardDiff;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import org.izv.aff.balls.ComprobacionBallsActivity;
import org.izv.aff.balls.EasyDiff.DifficultyActivity;
import org.izv.aff.balls.R;

public class HardDifficultyActivity extends AppCompatActivity {

    public static int MILISEGUNDOS_ESPERA = 5000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hard_difficulty);

        final HardBouncing hardBouncing = new HardBouncing(this);
        setContentView(hardBouncing);

        esperarYCambiar(MILISEGUNDOS_ESPERA);
    }

    public void esperarYCambiar(int milisegundos) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                // acciones que se ejecutan tras los milisegundos
                Intent intent = new Intent(HardDifficultyActivity.this, ComprobacionBallsActivity.class);
                intent.putExtra("nbolas","12");
                startActivity(intent);
            }
        }, milisegundos);
    }
}