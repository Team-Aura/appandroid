package com.example.david.teamaura;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{

    private Button reg;
    private TextView tvLogin,tvError;
    private EditText etEmail,etPass;
    private DbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = new DbHelper(this);
        reg = (Button)findViewById(R.id.btnReg);
        etEmail = (EditText)findViewById(R.id.etEmail);
        etPass = (EditText)findViewById(R.id.etPass);
        tvLogin = (TextView)findViewById(R.id.tvLogin);
        tvError = (TextView)findViewById(R.id.tvError);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnReg:
                register();
                break;

            case R.id.tvLogin:
                back();
                break;

            default:
        }
    }

    private void register(){
        String email = etEmail.getText().toString();
        String pass = etPass.getText().toString();

        if(email.isEmpty() && pass.isEmpty()){
            mostrarMensaje("Falta usuario o pass");
        }else{
            db.addUser(email,pass);
            mostrarMensaje("Usuario Registrado");
            finish();
        }
    }

    private void mostrarMensaje(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    private void back(){
        startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
        finish();
    }


}


