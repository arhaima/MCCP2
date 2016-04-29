
package com.example.hassannaqvi.mccp2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);




    }

    public void updateUsers(View view) {

        GetUsers users = new GetUsers(getApplicationContext());
        users.execute();


    }

    public void loginUser(View view) {
        final EditText txtUserName = (EditText) findViewById(R.id.email);
        final EditText txtPassword = (EditText) findViewById(R.id.password);

        String username = txtUserName.getText().toString();
        String password = txtPassword.getText().toString();
        try {
            if (username.length() > 0 && password.length() > 0) {
                FormsDbHelper db = new FormsDbHelper(LoginActivity.this);


                if (db.Login(username, password)) {
                    Toast.makeText(LoginActivity.this, "Successfully Logged In", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(LoginActivity.this, "Invalid Username/Password", Toast.LENGTH_LONG).show();
                }
                db.close();
            }

        } catch (Exception e) {
            Toast.makeText(LoginActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

}



