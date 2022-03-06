package sv.edu.udb.dsm.guia3.logindsm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.nio.charset.StandardCharsets;

public class ventas extends AppCompatActivity {

    private EditText nombreCompleto;
    private EditText Codigo;
    private EditText numerodeventas;
    private EditText mesVentas;
    Uri path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventas);

        nombreCompleto = (EditText) (findViewById(R.id.txtnombre));
        Codigo = (EditText) findViewById(R.id.txtcodigoempleado);
        numerodeventas= (EditText) findViewById(R.id.txtventas);
        mesVentas= (EditText) findViewById(R.id.txtmesventas);

    }

    public void onCLick(View v)
    {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/");
        startActivityForResult(intent.createChooser(intent,"Seleccione la aplicacion"),10);
    }

    public void btncalcularsalarios (View view){

        Intent i = new Intent(this, resultadoVentas.class);
        i.putExtra("txtnombre",nombreCompleto.getText().toString());
        i.putExtra("txtcodigo",Codigo.getText().toString());
        i.putExtra("txtventas",numerodeventas.getText().toString());
        i.putExtra("txtmes",mesVentas.getText().toString());
        i.putExtra("imageViewFoto",path.toString());
        startActivity(i);
    }

    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data)
    {

        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK)
        {
             path = data.getData();
        }
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