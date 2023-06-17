package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.databinding.ActivityMainBinding;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity2 extends AppCompatActivity {

    private DatabaseReference mDatabase;
    private EditText fname,lname,username,password;
// ...

    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        fname = findViewById(R.id.firstname);
        lname = findViewById(R.id.lastname);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        mDatabase = FirebaseDatabase.getInstance().getReference();


        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeNewUser();
            }
        });



    }


    public void writeNewUser() {
        Users user = new Users( fname.getText().toString(),
                                lname.getText().toString(),
                                username.getText().toString(),
                                password.getText().toString());

        mDatabase.child("users").child(user.getUsername()).setValue(user);
        openact1();
    }




    public void openact1(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}