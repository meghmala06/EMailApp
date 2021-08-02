package com.example.emailapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText medtTo,medtMesage,medtsubject;
    Button mbtnSend;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mbtnSend=findViewById(R.id.btnSend);
        medtMesage=findViewById(R.id.edtMessage);
        medtTo=findViewById(R.id.edtToEmail);
        medtsubject=findViewById(R.id.edtSubject);

        mbtnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMail();
            }
        });
    }

    private void sendMail() {
        String recipientList=medtTo.getText().toString();
        String[] recipients=recipientList.split(",");

        String message=medtMesage.getText().toString();
        String subject=medtsubject.getText().toString();

        Intent intent=new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL,recipients);
        intent.putExtra(Intent.EXTRA_SUBJECT,subject);
        intent.putExtra(Intent.EXTRA_TEXT,message);

          intent.setType("message/rfc822");
          startActivity(Intent.createChooser(intent,"Choose an email client"));

    }
}