package com.ilaydaozdemir.wasp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class new_account extends AppCompatActivity {

    private EditText txtUsername, txtEmail, txtPassword;
    private Button btnRegister;
    private FirebaseAuth auth;


    private Toolbar actionbarNew;

    public void init() {
        actionbarNew = (Toolbar) findViewById(R.id.actionbarNew);
        setSupportActionBar(actionbarNew);
        getSupportActionBar().setTitle("Hesap Oluştur");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        auth = FirebaseAuth.getInstance();
        txtUsername = (EditText) findViewById(R.id.name);
        txtEmail = (EditText) findViewById(R.id.mail);
        txtPassword = (EditText) findViewById(R.id.password);
        btnRegister = (Button) findViewById(R.id.btn1);

    }


    public void showSuccessMessage() {
        Toast.makeText(this, "Hesabınız Oluşturuldu", Toast.LENGTH_LONG).show();
        Intent LoginIntent = new Intent(new_account.this, LoginActivity.class);
        startActivity(LoginIntent);
        finish();
    }

    public void showFailedMessage() {
        Toast.makeText(this, "Bir hata oluştu!", Toast.LENGTH_LONG).show();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_account);
        init();
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createNewAccount();
            }
        });
    }

    private void createNewAccount() {

        String username = txtUsername.getText().toString();
        String email = txtEmail.getText().toString();
        String password = txtPassword.getText().toString();

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Email adresi giriniz!", Toast.LENGTH_LONG).show();
        } else if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Password giriniz!", Toast.LENGTH_LONG).show();
        } else {
            auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        showSuccessMessage();
                    } else {
                        showFailedMessage();
                    }
                }
            });
        }
    }
}
