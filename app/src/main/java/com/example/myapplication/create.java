package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;
import java.util.prefs.Preferences;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class create extends AppCompatActivity {

    private Button homebtn,create,settings,createTask;
    private DatabaseReference mDatabase,mDatabase2;


    private EditText title,desc,prio;
    private TextView errMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        String uname = getIntent().getStringExtra("username");


        homebtn = (Button) findViewById(R.id.homebtn);
        create = (Button) findViewById(R.id.create);
        settings = (Button) findViewById(R.id.settings);
        createTask = (Button) findViewById(R.id.submitButton);
        title = findViewById(R.id.titleField);
        desc = findViewById(R.id.description);
        prio = findViewById(R.id.priorityField);
        errMsg = findViewById(R.id.errorMessage);



        mDatabase = FirebaseDatabase.getInstance().getReference();


        homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(create.this, Home.class);
                intent.putExtra("editTextValue", "HOME");
                intent.putExtra("username", uname);
                startActivity(intent);

            }
        });

        createTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createTask();

            }
        });




        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(create.this, settings.class);
                startActivity(intent);

            }
        });


    }
    public void createTask(){
        String uname = getIntent().getStringExtra("username");

        String prioStr = prio.getText().toString();
        if(prioStr.isEmpty()){
            errMsg.setText("Please Enter Priority Number");

        }
        else{

            int prioInt = Integer.parseInt(prioStr);

            if(prioInt  <=5 ){

                TaskGetter tGetter = new TaskGetter(title.getText().toString(), desc.getText().toString());
                mDatabase.child("users").child(uname).child("tasks").child(prio.getText().toString()).setValue(tGetter);
                errMsg.setText("");

                Intent intent = new Intent(create.this, Home.class);
                intent.putExtra("username", uname);
                startActivity(intent);

            }
            else{
                errMsg.setText("Please Choose a Number Between 1-5");
            }

        }






    }
}

