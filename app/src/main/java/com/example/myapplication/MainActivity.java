package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
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

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private Button buttonRegT;
    Preferences preferences = Preferences.userRoot().node("com.example.myapplication");

    private DatabaseReference mDatabase;
    private EditText user,pass;
    private TextView errMsg;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        user = (EditText)findViewById(R.id.username);
        pass = (EditText)findViewById(R.id.password);
        button = (Button) findViewById(R.id.button);
        buttonRegT = (Button) findViewById(R.id.buttonReg);
        errMsg = (TextView) findViewById(R.id.errMsg);
        Intent intent = new Intent(this, Home.class);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mDatabase = FirebaseDatabase.getInstance().getReference().child("users").child(user.getText().toString());
                mDatabase.addValueEventListener(new ValueEventListener() {


                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String uname = snapshot.child("username").getValue(String.class);
                        String pasStrVal= pass.getText().toString();
                        String upass = snapshot.child("password").getValue(String.class);
                        String firstname = snapshot.child("fname").getValue(String.class);
                        String lastname = snapshot.child("lname").getValue(String.class);



                        if(!Objects.isNull(uname)){
                            if(upass.equals(pasStrVal)){
                                intent.putExtra("editTextValue", "Welcome "+firstname+" "+lastname);
                                intent.putExtra("username", uname);

                                startActivity(intent);
                            }else{
                                errMsg.setText("Invalid Password");
                            }
                        }// if uname is not equal to null
                        else{
                            errMsg.setText("Invalid Username");
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }
        });
        buttonRegT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });




    }




    public void successLogin(){
        Intent intent = new Intent(this, Home.class);
        intent.putExtra("editTextValue", "hello");
        startActivity(intent);
    }
    public void register(){
        Intent intent = new Intent(this, Register.class);
        startActivity(intent);
    }
}