package com.login.rafael.loginapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class HomeActivity extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        /*toolbar = (Toolbar)findViewById(R.id.tool_bar);
        getSupportActionBar().setTitle(R.string.app_name);*/
    }
}
