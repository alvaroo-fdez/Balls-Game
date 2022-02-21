package org.izv.aff.balls;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.izv.aff.balls.EasyDiff.DifficultyActivity;

public class ComprobacionBallsActivity extends AppCompatActivity {

    private Button btComprobar, btEasy, btMedium, btHard;
    private EditText etComprobar;
    private TextView tvComprobar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comprobacion_balls);

        String nbolas = getIntent().getStringExtra("nbolas");

        etComprobar = findViewById(R.id.etComprobar);
        tvComprobar = findViewById(R.id.tvMala);
        btComprobar = findViewById(R.id.btComprobar);
        btEasy = findViewById(R.id.btEasy);
        btComprobar.setEnabled(true);

        btComprobar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!etComprobar.getText().equals("")){
                    if(etComprobar.getText().toString().equals(nbolas)){
                        etComprobar.setBackground(getResources().getDrawable(R.drawable.botonaciertos));
                        tvComprobar.setText("¡Enhorabuena! Habían " + nbolas + " bolas");
                        btComprobar.setEnabled(false);
                        if(Integer.parseInt(nbolas) == 4){
                            esperarYCambiarEasy(3000);
                        } else if(Integer.parseInt(nbolas) == 8){
                            esperarYCambiarMedium(3000);
                        } else if(Integer.parseInt(nbolas) == 12){
                            esperarYCambiarHard(3000);
                        }
                    }else{
                        etComprobar.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
                        tvComprobar.setText("Has fallado :(");
                        esperarYCambiar(2000);
                    }
                }else{
                    Context context = getApplicationContext();
                    CharSequence text = "Debes poner un número de bolas";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            }
        });
    }

    public void esperarYCambiar(int milisegundos) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                // acciones que se ejecutan tras los milisegundos
                Intent intent = new Intent(ComprobacionBallsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        }, milisegundos);
    }

    public void esperarYCambiarEasy(int milisegundos) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                // acciones que se ejecutan tras los milisegundos
                Intent intent = new Intent(ComprobacionBallsActivity.this, MainActivity.class);
                intent.putExtra("easy","1");
                startActivity(intent);
            }
        }, milisegundos);
    }

    public void esperarYCambiarMedium(int milisegundos) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                // acciones que se ejecutan tras los milisegundos
                Intent intent = new Intent(ComprobacionBallsActivity.this, MainActivity.class);
                intent.putExtra("medium","1");
                startActivity(intent);
            }
        }, milisegundos);
    }

    public void esperarYCambiarHard(int milisegundos) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                // acciones que se ejecutan tras los milisegundos
                Intent intent = new Intent(ComprobacionBallsActivity.this, MainActivity.class);
                intent.putExtra("hard","1");
                startActivity(intent);
            }
        }, milisegundos);
    }
}