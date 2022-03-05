package sv.edu.udb.primerejercicio;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultadosEjercicio1 extends AppCompatActivity {

    private TextView MostrarNombre;
    private TextView MostrarCodigo;
    private TextView MostrarVentas;
    private TextView MostrarMes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados_ejercicio1);
        MostrarNombre= (TextView) findViewById(R.id.txtnombre);
        MostrarCodigo= (TextView) findViewById(R.id.txtcodigoempleado);
        MostrarVentas= (TextView) findViewById(R.id.txtventas);
        MostrarMes= (TextView) findViewById(R.id.txtmesventas);
        Bundle bundle= getIntent().getExtras();
        String nombre= bundle.getString("txtnombre");
        String codigo = bundle.getString("txtCodigo");
        double ventas = Double.parseDouble(bundle.getString("txtnumeroVentas"));
        String mes = bundle.getString("txtmesventas");



    }

}