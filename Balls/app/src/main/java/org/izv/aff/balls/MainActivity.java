package org.izv.aff.balls;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.izv.aff.balls.EasyDiff.DifficultyActivity;
import org.izv.aff.balls.HardDiff.HardDifficultyActivity;
import org.izv.aff.balls.MediumDiff.MediumDifficultyActivity;

public class MainActivity extends AppCompatActivity {

    private Button bteasy, btmedium, bthard;
    private TextView tvDiff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDiff = findViewById(R.id.tvDiff);
        bteasy = findViewById(R.id.btEasy);
        btmedium = findViewById(R.id.btMedium);
        bthard = findViewById(R.id.btHard);

        String easy = getIntent().getStringExtra("easy");
        String medium = getIntent().getStringExtra("medium");
        String hard = getIntent().getStringExtra("hard");

        //System.out.println("easy: "+easy);
        if(easy != null){
                bteasy.setBackground(getResources().getDrawable(R.drawable.botonaciertos));
                btmedium.setEnabled(true);
                //System.out.println("easy bro");
        }else{
            btmedium.setEnabled(false);
            bthard.setEnabled(false);
        }

        if(medium != null){
            btmedium.setBackground(getResources().getDrawable(R.drawable.botonaciertos));
            bteasy.setBackground(getResources().getDrawable(R.drawable.botonaciertos));
            bthard.setEnabled(true);
        }else{
            bthard.setEnabled(false);
        }
        if(hard != null){
            bthard.setBackground(getResources().getDrawable(R.drawable.botonaciertos));
            btmedium.setBackground(getResources().getDrawable(R.drawable.botonaciertos));
            bteasy.setBackground(getResources().getDrawable(R.drawable.botonaciertos));
            btmedium.setEnabled(true);
            tvDiff.setText("YOU FINISHED THE GAME");

            abreCamara();
        }

        bteasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DifficultyActivity.class);
                startActivity(intent);
            }
        });

        btmedium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MediumDifficultyActivity.class);
                startActivity(intent);
            }
        });

        bthard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, HardDifficultyActivity.class);
                startActivity(intent);
            }
        });
    }

    private void abreCamara(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivity(intent);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
            Bundle extras = data.getExtras();
            Bitmap imgBitmap = (Bitmap) extras.get("data");
            ImageView imageView = findViewById(R.id.imageView);
            imageView.setImageBitmap(imgBitmap);
    }

}