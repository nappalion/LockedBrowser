package com.example.lockedbrowser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ToggleButton;

public class LoginActivity extends AppCompatActivity {

    private EditText etUrl;
    // EditText etPasscode;
    private Button btnLogin;
    private Button btnEnable;
    private ToggleButton toggleButton;
    private String url;
    // String passcode;

    // SharedPreferences constants
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String ETURL = "etUrl";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUrl = findViewById(R.id.etUrl);
        // etPasscode = findViewById(R.id.etPasscode);
        btnLogin = findViewById(R.id.btnLogin);
        toggleButton = findViewById(R.id.toggleButton);

        etUrl.setEnabled(false);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
                url = etUrl.getText().toString();
                // passcode = etPasscode.getText().toString();
                launchWebsite();
            }
        });

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    etUrl.setEnabled(true);
                }
                else {
                    etUrl.setEnabled(false);
                }
            }
        });

        loadData();
    }

    // using SharedPreferences to save url
    public void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // save variables
        editor.putString(ETURL, etUrl.getText().toString());

        editor.apply();
    }

    // loading url
    public void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        etUrl.setText(sharedPreferences.getString(ETURL, ""));
    }

    public void launchWebsite() {
        Intent i = new Intent(LoginActivity.this, MainActivity.class);
        i.putExtra("web", url);
        // i.putExtra("pass", passcode);
        startActivity(i);
    }
}