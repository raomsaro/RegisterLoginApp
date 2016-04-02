package com.login.rafael.loginapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    EditText Name, Email, Pass, ConPass;
    Button RegButton;
    AlertDialog.Builder builder;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        /*toolbar = (Toolbar)findViewById(R.id.tool_bar);
        getSupportActionBar().setTitle(R.string.reg_act);
        getSupportActionBar().setLogo(R.drawable.app_logo);*/

        Name = (EditText)findViewById(R.id.name);

        Email = (EditText)findViewById(R.id.reg_mail);

        Pass = (EditText)findViewById(R.id.reg_pass);

        ConPass = (EditText)findViewById(R.id.con_pass);

        RegButton = (Button)findViewById(R.id.register);
        RegButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Name.getText().toString().equals("")||Email.getText().toString().equals("")||Pass.getText().toString().equals("")||ConPass.getText().toString().equals("")){
                    builder = new AlertDialog.Builder(RegisterActivity.this);
                    builder.setTitle("Something went wrong...");
                    builder.setMessage("Please provide the required information");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();

                        }
                    });

                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();

                } else if (!Pass.getText().toString().equals(ConPass.getText().toString())){
                    builder = new AlertDialog.Builder(RegisterActivity.this);
                    builder.setTitle("Something went wrong...");
                    builder.setMessage("Passwords do not match.");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            Pass.setText("");
                            ConPass.setText("");

                        }
                    });

                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();

                } else {
                    BackgroundTask backgroundTask = new BackgroundTask(RegisterActivity.this);
                    backgroundTask.execute("register", Name.getText().toString(), Email.getText().toString(), Pass.getText().toString());
                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(intent);
                }

            }
        });

    }
}
