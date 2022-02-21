package org.izv.aff.balls.MediumDiff;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import org.izv.aff.balls.ComprobacionBallsActivity;
import org.izv.aff.balls.HardDiff.HardDifficultyActivity;
import org.izv.aff.balls.R;

public class MediumDifficultyActivity extends AppCompatActivity {

    public static int MILISEGUNDOS_ESPERA = 5000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medium_difficulty);

        final MediumBouncing mediumBouncing = new MediumBouncing(this);
        setContentView(mediumBouncing);

        esperarYCambiar(MILISEGUNDOS_ESPERA);
    }

    public void esperarYCambiar(int milisegundos) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                // acciones que se ejecutan tras los milisegundos
                Intent intent = new Intent(MediumDifficultyActivity.this, ComprobacionBallsActivity.class);
                intent.putExtra("nbolas","8");
                startActivity(intent);
            }
        }, milisegundos);
    }
}