package com.example.lesson_1_month_3;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.lesson_1_month_3.databinding.ActivityMainBinding;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {
private ActivityMainBinding binding;
private String feedback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.nextAct.setOnClickListener(view -> {
            Intent i = new Intent(this,MainActivity2.class);
            i.putExtra("res",R.drawable.ic_launcher_background);
            startActivity(i);
        });


        binding.btnGmail.setOnClickListener(view -> {

            if (binding.feedbackEdittext.getText().length()!=0){
                feedback = binding.feedbackEdittext.getText().toString();
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setType("plain/text");

                emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"sbstillwaiting@gmail.com"});

                emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, feedback);

                startActivity(Intent.createChooser(emailIntent, "."));            }
            else {
                Toast.makeText(MainActivity.this,"Введите текст, текста нет",Toast.LENGTH_SHORT).show();
            }
        });
    }



}