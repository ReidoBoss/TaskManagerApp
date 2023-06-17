package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

public class task extends AppCompatActivity {
    private TextView title,descr;
    private Button homeBtn,doneBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = new Intent(task.this, Home.class);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
        title = (TextView) findViewById(R.id.title);
        descr = (TextView) findViewById(R.id.descriptionTextView);
        String editTextValue = getIntent().getStringExtra("titolo");
        String desc = getIntent().getStringExtra("desc");
        String num = getIntent().getStringExtra("num");
        String uname = getIntent().getStringExtra("username");
        int numInt = Integer.parseInt(num);

        DatabaseReference parentRef = FirebaseDatabase.getInstance().getReference().child("users").child(uname).child("tasks");

                String childKey = "num";

                DatabaseReference childRef = parentRef.child(childKey);


        title.setText(editTextValue);
        descr.setText(""+desc);

        homeBtn = (Button) findViewById(R.id.homeButton);
        doneBtn = (Button) findViewById(R.id.doneButton);

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent.putExtra("editTextValue", "HOME");
                startActivity(intent);

            }
        });
        doneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




            }
        });


    }
}