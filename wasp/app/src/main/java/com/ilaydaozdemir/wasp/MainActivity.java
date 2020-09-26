package com.ilaydaozdemir.wasp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnLogin,btnAccount;
    public void init(){
        btnLogin=(Button) findViewById(R.id.btnLogin);
        btnAccount=(Button) findViewById(R.id.btnAccount);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void goToLogin(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    public  void goToAccount(View view){
        Intent intent=new Intent(this,new_account.class);
        startActivity(intent);
        finish();
    }

}
