package com.example.brodcastreciverproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void smsSendMessage(View view) {
        //TextView textView = (TextView) findViewById(R.id.number_to_call);
        // Use format with "smsto:" and phone number to create smsNumber.
        String smsNumber = String.format("smsto: %s", "0530890208");
        // Find the sms_message view.
        EditText smsEditText = (EditText) findViewById(R.id.smsMessage);
        // Get the text of the sms message.
        String sms = smsEditText.getText().toString();
        // Create the intent.
        Intent smsIntent = new Intent(Intent.ACTION_SENDTO);
        // Set the data for the intent as the phone number.
        smsIntent.setData(Uri.parse(smsNumber));
        // Add the message (sms) with the key ("sms_body").
        smsIntent.putExtra("sms_body", sms);
        // If package resolves (target app installed), send intent.
        if (smsIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(smsIntent);
        } else {
            Log.d(TAG, "Can't resolve app for ACTION_SENDTO Intent");
        }
    }

    }
