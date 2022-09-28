package com.example.sumador;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 *
 * @author amna
 * @version 1.0
 */
public class MainActivity extends AppCompatActivity {

    EditText et1;
    EditText et2;
    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1=findViewById(R.id.numUno);
        et2=findViewById(R.id.numDos);
        tv1=findViewById(R.id.result);
    }

    /**
     *
     * @param view
     */
    public void sumar(View view) {

        // Obtenemos los números
        int n1=Integer.parseInt(et1.getText().toString());
        int n2=Integer.parseInt(et2.getText().toString());

        // Hacemos la suma
        int suma=n1+n2;

        // Establecemos el resultado en el TextView
        tv1.setText(""+suma);
    }

    /**
     *
     * @param view
     */
    public void restar(View view) {

        // Obtenemos los números
        int n1=Integer.parseInt(et1.getText().toString());
        int n2=Integer.parseInt(et2.getText().toString());

        // Hacemos la resta
        int resta=n1-n2;

        // Establecemos el resultado en el TextView
        tv1.setText(""+resta);
    }

    /**
     *
     * @param view
     */
    public void multiplicar(View view) {

        // Obtenemos los números
        int n1=Integer.parseInt(et1.getText().toString());
        int n2=Integer.parseInt(et2.getText().toString());

        // Hacemos la multiplicación
        int multiplicar=n1*n2;

        // Establecemos el resultado en el TextView
        tv1.setText(""+multiplicar);
    }

    /**
     *
     * @param view
     */
    public void dividir(View view){
        // Obtenemos los números
        int n1=Integer.parseInt(et1.getText().toString());
        int n2=Integer.parseInt(et2.getText().toString());

        // Hacemos la división
        int dividir=n1/n2;

        // Establecemos el resultado en el TextView
        tv1.setText(""+dividir);
    }
}