package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Home extends AppCompatActivity {

    private TextView welcome;

    private DatabaseReference mDatabase,m2,m3,m4,m5;

    private Button create,settings,t1,t2,t3,t4,t5;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Intent intent = new Intent(Home.this, task.class);

        welcome = (TextView) findViewById(R.id.welcomeText);
        String editTextValue = getIntent().getStringExtra("editTextValue");
        String uname = getIntent().getStringExtra("username");

        welcome.setText(editTextValue);


        create = (Button) findViewById(R.id.create);
        settings = (Button) findViewById(R.id.settings);
        t1 = (Button) findViewById(R.id.task1);
        t2 = (Button) findViewById(R.id.task2);
        t3 = (Button) findViewById(R.id.task3);
        t4 = (Button) findViewById(R.id.task4);
        t5 = (Button) findViewById(R.id.task5);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase = FirebaseDatabase.getInstance().getReference().child("users").child(uname).child("tasks").child("1");
        m2 = FirebaseDatabase.getInstance().getReference().child("users").child(uname).child("tasks").child("2");
        m3 = FirebaseDatabase.getInstance().getReference().child("users").child(uname).child("tasks").child("3");
        m4 = FirebaseDatabase.getInstance().getReference().child("users").child(uname).child("tasks").child("4");
        m5 = FirebaseDatabase.getInstance().getReference().child("users").child(uname).child("tasks").child("5");

        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String t1Text = snapshot.child("title").getValue(String.class);
                String desc1 = snapshot.child("desc").getValue(String.class);
                if(t1Text==null){
                    t1.setText("DONE or NULL");
                }
                else{
                    t1.setText(t1Text);
                    intent.putExtra("titled", t1Text);
                    intent.putExtra("desc", desc1);


                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        m2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String t1Text = snapshot.child("title").getValue(String.class);
                if(t1Text==null){
                    t2.setText("DONE or NULL");
                }
                else{
                    t2.setText(t1Text);
                    intent.putExtra("title", t1Text);

                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        m3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String t1Text = snapshot.child("title").getValue(String.class);
                if(t1Text==null){
                    t3.setText("DONE or NULL");
                }
                else{
                    t3.setText(t1Text);
                    intent.putExtra("title", t1Text);

                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        m4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String t1Text = snapshot.child("title").getValue(String.class);
                if(t1Text==null){
                    t4.setText("DONE or NULL");
                }
                else{
                    t4.setText(t1Text);
                    intent.putExtra("title", t1Text);

                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        m5.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String t1Text = snapshot.child("title").getValue(String.class);
                if(t1Text==null){
                    t5.setText("DONE or NULL");
                }
                else{
                    t5.setText(t1Text);
                    intent.putExtra("title", t1Text);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mDatabase = FirebaseDatabase.getInstance().getReference().child("users").child(uname).child("tasks").child("1");

                mDatabase.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        String t1Text = snapshot.child("title").getValue(String.class);
                        String t1T = snapshot.child("title").getValue(String.class);
                        String desc1 = snapshot.child("desc").getValue(String.class);
                        if(t1Text==null){
                            t1.setText("DONE or NULL");
                        }
                        else{
                            Intent intent = new Intent(Home.this, task.class);
                            intent.putExtra("editTextValue", "Testing lang gud");
                            intent.putExtra("username", uname);
                            intent.putExtra("num", "1");
                            intent.putExtra("titolo", t1T);
                            intent.putExtra("desc", desc1);
                            startActivity(intent);

                        }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                    }
                });



            }
        });
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mDatabase = FirebaseDatabase.getInstance().getReference().child("users").child(uname).child("tasks").child("2");

                mDatabase.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        String t1Text = snapshot.child("title").getValue(String.class);
                        String t1T = snapshot.child("title").getValue(String.class);
                        String desc1 = snapshot.child("desc").getValue(String.class);
                        if(t1Text==null){
                            t1.setText("DONE or NULL");
                        }
                        else{
                            Intent intent = new Intent(Home.this, task.class);
                            intent.putExtra("editTextValue", "Testing lang gud");
                            intent.putExtra("username", uname);
                            intent.putExtra("num", "2");
                            intent.putExtra("titolo", t1T);
                            intent.putExtra("desc", desc1);
                            startActivity(intent);

                        }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                    }
                });



            }
        });
        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mDatabase = FirebaseDatabase.getInstance().getReference().child("users").child(uname).child("tasks").child("3");

                mDatabase.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        String t1Text = snapshot.child("title").getValue(String.class);
                        String t1T = snapshot.child("title").getValue(String.class);
                        String desc1 = snapshot.child("desc").getValue(String.class);
                        if(t1Text==null){
                            t1.setText("DONE or NULL");
                        }
                        else{
                            Intent intent = new Intent(Home.this, task.class);
                            intent.putExtra("editTextValue", "Testing lang gud");
                            intent.putExtra("username", uname);
                            intent.putExtra("num", "3");
                            intent.putExtra("titolo", t1T);
                            intent.putExtra("desc", desc1);
                            startActivity(intent);

                        }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                    }
                });




            }
        });
        t4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mDatabase = FirebaseDatabase.getInstance().getReference().child("users").child(uname).child("tasks").child("4");

                mDatabase.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        String t1Text = snapshot.child("title").getValue(String.class);
                        String t1T = snapshot.child("title").getValue(String.class);
                        String desc1 = snapshot.child("desc").getValue(String.class);
                        if(t1Text==null){
                            t1.setText("DONE or NULL");
                        }
                        else{
                            Intent intent = new Intent(Home.this, task.class);
                            intent.putExtra("editTextValue", "Testing lang gud");
                            intent.putExtra("username", uname);
                            intent.putExtra("num", "4");
                            intent.putExtra("titolo", t1T);
                            intent.putExtra("desc", desc1);
                            startActivity(intent);

                        }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                    }
                });




            }
        });
        t5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mDatabase = FirebaseDatabase.getInstance().getReference().child("users").child(uname).child("tasks").child("5");

                mDatabase.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        String t1Text = snapshot.child("title").getValue(String.class);
                        String t1T = snapshot.child("title").getValue(String.class);
                        String desc1 = snapshot.child("desc").getValue(String.class);
                        if(t1Text==null){
                            t1.setText("DONE or NULL");
                        }
                        else{
                            Intent intent = new Intent(Home.this, task.class);
                            intent.putExtra("editTextValue", "Testing lang gud");
                            intent.putExtra("username", uname);
                            intent.putExtra("num", "5");
                            intent.putExtra("titolo", t1T);
                            intent.putExtra("desc", desc1);
                            startActivity(intent);

                        }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                    }
                });




            }
        });

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Home.this, create.class);
                intent.putExtra("username", uname);

                startActivity(intent);

            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Home.this, settings.class);
                intent.putExtra("username", uname);

                startActivity(intent);

            }
        });



    }
}