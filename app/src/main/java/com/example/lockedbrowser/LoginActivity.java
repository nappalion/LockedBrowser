package com.example.lockedbrowser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    EditText etUrl;
    EditText etPasscode;
    Button btnLogin;
    String url;
    String passcode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUrl = findViewById(R.id.etUrl);
        etPasscode = findViewById(R.id.etPasscode);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url = etUrl.getText().toString();
                passcode = etPasscode.getText().toString();
                launchWebsite();
            }
        });
    }

    public void launchWebsite() {
        Intent i = new Intent(LoginActivity.this, MainActivity.class);
        i.putExtra("web", url);
        i.putExtra("pass", passcode);
        startActivity(i);
    }
}