package com.example.cakeorderingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity {

    int triesCount = 3;//this is going to handle the tries count
    StringBuilder info = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void loginUserAccount() {

        System.out.print("Muhammad N Zahid");
        String uname = "mzahid", pass = "password";//credentials that are going to be used
        EditText name, word;
        name = findViewById(R.id.idUserName);
        word = findViewById(R.id.idPassword);


        if (uname.equals(name.getText().toString()) && pass.equals(word.getText().toString())
                && triesCount != 0) {
// if login info is correct then move forward
            Toast.makeText(this, "Successful Login. Redirecting...",
                    Toast.LENGTH_LONG).show();

            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        }
        // if login info is wrong then decrease the count size
        else if ((!uname.equals(name.getText().toString()) || !pass.equals(
                word.getText().toString())) && triesCount >= 1) {
            triesCount = triesCount - 1;

            info.append("User " + name.getText() + "has " + "\n" + triesCount + "tries left\n");
            showMessage(info.toString());
        }

        else {
            //locked message if the tries are done
            Toast.makeText(this, "Account locked", Toast.LENGTH_LONG).show();
        }
    }


}
