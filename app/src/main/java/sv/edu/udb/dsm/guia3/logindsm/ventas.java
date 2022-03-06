package sv.edu.udb.dsm.guia3.logindsm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ventas extends AppCompatActivity {

    private EditText nombreCompleto;
    private EditText Codigo;
    private EditText numerodeventas;
    private EditText mesVentas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventas);

        nombreCompleto = (EditText) (findViewById(R.id.txtnombre));
        Codigo = (EditText) findViewById(R.id.txtcodigoempleado);
        numerodeventas= (EditText) findViewById(R.id.txtventas);
        mesVentas= (EditText) findViewById(R.id.txtmesventas);


    }

    public void btncalcularsalarios (View view){

        Intent i = new Intent(this, resultadoVentas.class);
        i.putExtra("txtnombrecompleto",nombreCompleto.getText().toString());
        i.putExtra("txtCodigo",Codigo.getText().toString());
        i.putExtra("txtnumeroVentas",numerodeventas.getText().toString());
        i.putExtra("txtmesventas",mesVentas.getText().toString());
        startActivity(i);

    }

    public void cerrarSesion(View v)
    {
        SharedPreferences preferences =
                getSharedPreferences("Credenciales", Context.MODE_PRIVATE);
        preferences.edit().remove("Credenciales").commit();

        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}