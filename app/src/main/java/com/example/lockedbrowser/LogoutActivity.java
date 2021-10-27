package com.example.lockedbrowser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LogoutActivity extends AppCompatActivity {

    Button btnLogout;
    EditText etPasscode;
    String passcode;
    String tryPasscode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);

        btnLogout = findViewById(R.id.btnLogout);
        etPasscode = findViewById(R.id.etPasscode);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passcode = getIntent().getStringExtra("pass");
                tryPasscode = etPasscode.getText().toString();
                if (tryPasscode.equals(passcode)) {
                    launchLogin();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Incorrect passcode!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void launchLogin() {
        Intent i = new Intent(LogoutActivity.this, LoginActivity.class);
        startActivity(i);
    }
}