package com.example.hifzclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button github, homeButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        github = findViewById(R.id.github);
        homeButton = findViewById(R.id.homeButton);

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Home_Page.class);
                startActivity(intent);
            }
        });

        github.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://github.com/aaaalii/Hifz_Record";

                // Create an intent with ACTION_VIEW and the URL
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));

                // Verify if there's an activity that can handle the intent
                if (intent.resolveActivity(getPackageManager()) != null) {
                    // Start the activity to open the URL
                    startActivity(intent);
                }
            }
        });

    }

    public static class EnrollStudent extends AppCompatActivity {
        EditText name, age, rollno;
        Button enroll;
        TextView textView;

        StudentsDbHelper studentsDbHelper;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_enroll_student);

            Intent intent = getIntent();

            studentsDbHelper = new StudentsDbHelper(this);

            name = findViewById(R.id.name);
            age = findViewById(R.id.age);
            enroll = findViewById(R.id.enrollStudent);
            rollno = findViewById(R.id.rollno);
            textView = findViewById(R.id.textView3);

            enroll.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String n = name.getText().toString();
                    String a = age.getText().toString();
                    String r = rollno.getText().toString();

                    Student student = new Student(Integer.parseInt(r), n, a, null);

                    if(n == null || a == null || r == null){
                        // Add Toast
                    }
                    else {
                        studentsDbHelper.insertStudent(student);
                    }
                }
            });








        }
    }
}