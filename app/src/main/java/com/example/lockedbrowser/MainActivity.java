package com.example.lockedbrowser;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    WebView wvWebsite;
    String url;
    String passcode;
    Toolbar toolbar;
    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // set the toolbar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        // get passcode
        passcode = getIntent().getStringExtra("pass");

        // get url and load website
        url = "http://" + getIntent().getStringExtra("web");
        wvWebsite = findViewById(R.id.wvWebsite);
        wvWebsite.setWebViewClient(new WebViewClient());
        wvWebsite.loadUrl(url);
    }

    public void LogOutAction(MenuItem item) {
        Intent i = new Intent(MainActivity.this, LogoutActivity.class);
        i.putExtra("pass", passcode);
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    // prevents user from going back and exiting app
    @Override
    public void onBackPressed() {
        if (wvWebsite.canGoBack()) {
            wvWebsite.goBack();
        }
    }
}