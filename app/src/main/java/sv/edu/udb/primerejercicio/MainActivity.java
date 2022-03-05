package sv.edu.udb.primerejercicio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText numbera;
    private EditText numberb;
    private EditText numberc;
    private TextView resultado;
    private TextView tx1;
    private TextView tx2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numbera = (EditText) findViewById(R.id.Numbera);
        numberb=(EditText) findViewById(R.id.Numberb);
        numberc=(EditText) findViewById(R.id.Numberc);
        tx1=(TextView) findViewById(R.id.resultado);
        tx2=(TextView) findViewById(R.id.resultado2);





    }

    public void btncalcular(View v){

        double a = Double.parseDouble(numbera.getText().toString());
        double b = Double.parseDouble(numberb.getText().toString());
        double c = Double.parseDouble(numberc.getText().toString());

        double d=Math.pow(b,2)-4*a*c;
        if(d<0){

            tx1.setText("No hay raices reales");
            tx2.setText("No hay raices reales");

        }
        else {
            double x1 = (-b + (Math.sqrt(Math.pow(b, 2) - 4 * a * c))) / (2 * a);
            double x2 = (-b - (Math.sqrt(Math.pow(b, 2) - 4 * a * c))) / (2 * a);

            tx1.setText(String.valueOf(x1));
            tx2.setText(String.valueOf(x2));
        }
    }
}