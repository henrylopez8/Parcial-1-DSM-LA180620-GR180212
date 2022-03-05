package sv.edu.udb.primerejercicio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import javax.xml.transform.Result;

public class Ejercicio2 extends AppCompatActivity {

    private EditText nombreCompleto;
    private EditText Codigo;
    private EditText numerodeventas;
    private EditText mesVentas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio2);

        nombreCompleto = (EditText) (findViewById(R.id.txtnombre));
        Codigo = (EditText) findViewById(R.id.txtcodigoempleado);
        numerodeventas= (EditText) findViewById(R.id.txtventas);
        mesVentas= (EditText) findViewById(R.id.txtmesventas);


    }

    public void btncalcularsalarios (View view){

        Intent i = new Intent(this, ResultadosEjercicio1.class);
        i.putExtra("txtnombrecompleto",nombreCompleto.getText().toString());
        i.putExtra("txtCodigo",Codigo.getText().toString());
        i.putExtra("txtnumeroVentas",numerodeventas.getText().toString());
        i.putExtra("txtmesventas",mesVentas.getText().toString());
        startActivity(i);

    }


}
