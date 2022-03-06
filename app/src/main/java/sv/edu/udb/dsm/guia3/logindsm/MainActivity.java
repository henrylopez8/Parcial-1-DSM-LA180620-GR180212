package sv.edu.udb.dsm.guia3.logindsm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;


import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText campoUsuario,campoPassword;
    TextView txtMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoUsuario = (EditText) findViewById(R.id.inputEmail);
        campoPassword = (EditText) findViewById(R.id.inputPassword);
        txtMsg = (TextView) findViewById(R.id.txtMsg);

    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.btnGuardar:
                guardarDatos();
                break;

            case R.id.btnLogearse:
                cargarPreferencias(view);
                break;
        }
    }

    public  void cargarPreferencias(View view)
    {
        SharedPreferences preferences =
                getSharedPreferences("Credenciales", Context.MODE_PRIVATE);

        String userInput = campoUsuario.getText().toString();
        String passInput = campoPassword.getText().toString();

        String email = preferences.getString("user","No existe aun el usuario");
        String pass = preferences.getString("pass","No existe la password");

        if(email.equals(userInput) && pass.equals(passInput))
        {
            txtMsg.setText("");
            Intent intent = new Intent(this,menuExercices.class);
            startActivity(intent);

        }
        else
        {
            txtMsg.setText("Usuario o password incorrecta, verifique su registro");
        }


    }

    public void guardarDatos()
    {
        SharedPreferences preferences =
                getSharedPreferences("Credenciales", Context.MODE_PRIVATE);

            String usuario = campoUsuario.getText().toString();
            String password = campoPassword.getText().toString();

            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("user",usuario);
            editor.putString("pass",password);

            editor.commit();

            if(txtMsg.getText().toString().length()>0)
            {
                txtMsg.setText("");
            }

    }


}