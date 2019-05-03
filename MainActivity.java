package com.iesp.teladelogin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    EditText user;
    EditText pass;
    Button login;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Boolean savelogin;
    CheckBox savelogincheckbox;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        user=(EditText)findViewById(R.id.usuario);
        pass=(EditText)findViewById(R.id.senha);
        login=(Button)findViewById(R.id.btnlogin);
        sharedPreferences = getSharedPreferences("loginref",MODE_PRIVATE);
        savelogincheckbox = (CheckBox)findViewById(R.id.checkbox);
        editor = sharedPreferences.edit();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    login();
            }
        });
        savelogin=sharedPreferences.getBoolean("savelogin",true);
        if(savelogin==true){
            user.setText(sharedPreferences.getString("usuario",null));
            pass.setText(sharedPreferences.getString("senha",null));
        }



    }

    public void login(){
        String usuario = user.getText().toString();
        String senha = pass.getText().toString();
        if (usuario.equals("glauciomeperturbademais")&& senha.equals("123456")){
            Toast.makeText(this, "Login realizado com sucesso!",Toast.LENGTH_LONG).show();
            if(savelogincheckbox.isChecked()){
                editor.putBoolean("savelogin", true);
                editor.putString("usuario",usuario);
                editor.putString("senha",senha);
                editor.commit();


            }
        }else{
            Toast.makeText(this,"Login ou senha inválido",Toast.LENGTH_LONG).show();

        }
    }
}
