package sv.edu.udb.dsm.guia3.logindsm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class resultadoVentas extends AppCompatActivity {

    private TextView MostrarNombre;
    private TextView MostrarCodigo;
    private TextView MostrarVentas;
    private TextView MostrarMes;
    private TextView MostrarComision;
    private ImageView Foto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_ventas);

        Foto = (ImageView) findViewById(R.id.image);
        MostrarNombre = (TextView) findViewById(R.id.txtNombre);
        MostrarCodigo = (TextView) findViewById(R.id.txtCodigo);
        MostrarVentas = (TextView) findViewById(R.id.txtVentas);
        MostrarMes    = (TextView) findViewById(R.id.txtMes);
        MostrarComision = (TextView) findViewById(R.id.txtComision);

        Intent intent = getIntent();
        String ruta = intent.getStringExtra("imageViewFoto");
        String name = intent.getStringExtra("txtnombre");
        String code = intent.getStringExtra("txtcodigo");
        String sell = intent.getStringExtra("txtventas");
        String month = intent.getStringExtra("txtmes");
        Double help = Double.parseDouble(sell);
        Double Commision = getCommision(help);

        //Mostramos los datos
        MostrarNombre.setText("Nombre: "+name);
        MostrarCodigo.setText("Codigo Empleado: "+code);
        MostrarVentas.setText("N Ventas: "+sell);
        MostrarMes.setText("Mes de venta: $"+month);
        MostrarComision.setText(Commision.toString());
        Foto.setImageURI(Uri.parse(ruta));


    }

    public void cerrarSesion(View v)
    {
        SharedPreferences preferences =
                getSharedPreferences("Credenciales", Context.MODE_PRIVATE);
        preferences.edit().remove("Credenciales").commit();

        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public Double getCommision(Double quantity)
    {
        Double commision = 0.00;
        if(quantity < 500)
        {
            commision = 00.00;
        }
        else if(quantity>=500 && quantity < 1000)
        {
            commision = quantity*0.05;
        }
        else if(quantity>=1000 && quantity < 2000)
        {
            commision = quantity*0.1;
        }
        else if(quantity>=2000 && quantity < 3000)
        {
            commision = quantity*0.15;
        }
        else if(quantity>=3000 && quantity < 4000)
        {
            commision = quantity*0.20;
        }
        else if(quantity>=4000)
        {
            commision = quantity*0.30;
        }

        return  commision;
    }

}