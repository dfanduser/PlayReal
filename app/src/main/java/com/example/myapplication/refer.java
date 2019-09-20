package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class refer extends AppCompatActivity {

    TextView   textView;
    Button codebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refer);

        textView =findViewById(R.id.textView);
        codebtn = findViewById(R.id.codebtn);


        codebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random =new Random();
                int number = random.nextInt(999999);
                textView.setText(String.format(String.valueOf(number), "%06d",number));

            }
        });



    }


}
