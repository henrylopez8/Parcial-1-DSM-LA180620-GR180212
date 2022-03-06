package sv.edu.udb.dsm.guia3.logindsm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

public class menuExercices extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_exercices);
    }

    public void redirectToCuadratica(View v)
    {
        Intent intent = new Intent(this,cuadratica.class);
        startActivity(intent);
    }

    public void redirectToVentas(View v)
    {
        Intent intent = new Intent(this,ventas.class);
        startActivity(intent);
    }

    public void cerrarSesion()
    {
        SharedPreferences preferences =
                getSharedPreferences("Credenciales", Context.MODE_PRIVATE);
        preferences.edit().remove("Credenciales").commit();

        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

}