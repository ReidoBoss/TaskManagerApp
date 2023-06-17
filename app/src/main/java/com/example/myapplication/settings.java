package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class settings extends AppCompatActivity {
    private Button homebtn,create,settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        homebtn = (Button) findViewById(R.id.homebtn);
        create = (Button) findViewById(R.id.create);
        settings = (Button) findViewById(R.id.settings);
        String uname = getIntent().getStringExtra("username");

        homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(settings.this, Home.class);
                intent.putExtra("editTextValue", "HOME");
                intent.putExtra("username", uname);

                startActivity(intent);

            }
        });

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(settings.this, create.class);
                intent.putExtra("username", uname);
                startActivity(intent);

            }
        });


    }
}