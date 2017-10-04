package com.example.david.teamaura;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private Button login,register,connect;
    private EditText etEmail,etPass;
    private DbHelper db;
    private Sesiones sesion;
    private TextView tbError;
    private Conexion objBBDD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layaout_principal);

        db = new DbHelper(this);
        objBBDD = new Conexion();
        sesion = new Sesiones(this);
        login = (Button)findViewById(R.id.btnLogin);
        register = (Button)findViewById(R.id.btnReg);
        connect = (Button)findViewById(R.id.btnConnect);
        etEmail = (EditText)findViewById(R.id.etEmail);
        etPass = (EditText)findViewById(R.id.etPass);
        login.setOnClickListener(this);
        register.setOnClickListener(this);

        if(sesion.loggedin()){
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnLogin:
                login();
                break;

            case R.id.btnReg:
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                break;

            case R.id.btnConnect:
                objBBDD.conectarBD();
                connect.setText("CONECTADO");

            default:
        }
    }

    private void login() {
        String email = etEmail.getText().toString();
        String pass = etPass.getText().toString();

        if (email.isEmpty() && pass.isEmpty()) {
            //Toast.makeText(getApplicationContext(), "Falta un campo", Toast.LENGTH_SHORT).show();
            tbError.setVisibility(View.VISIBLE);
        } else {
            if (db.getUser(email, pass)) {
                sesion.setLoggedin(true);
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                finish();
            } else
                Toast.makeText(getApplicationContext(), "Contraseña o Usuario Incorrectos", Toast.LENGTH_SHORT).show();
        }
    }
}
