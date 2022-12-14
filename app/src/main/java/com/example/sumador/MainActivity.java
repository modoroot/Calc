package com.example.sumador;

import androidx.appcompat.app.AppCompatActivity;


import android.app.AlertDialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;


/**
 * Clase main de la app Calc donde se contienen los métodos que harán funcionar
 * las operaciones de suma, resta, multiplicación, división. Además, se controlan
 * diversos posibles errores
 * @author amna
 * @version 1.0
 */
public class MainActivity extends AppCompatActivity {
    //Declaración variables
    EditText et1;
    EditText et2;
    TextView tv1;
    Button btnSuma;
    Button btnResta;
    Button btnMultiplicacion;
    Button btnDivision;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Asignación de variables a los componentes de la app
        et1 = findViewById(R.id.numUno);
        et2 = findViewById(R.id.numDos);
        tv1 = findViewById(R.id.result);
        btnSuma = findViewById(R.id.sumarBt);
        btnResta = findViewById(R.id.restarBt);
        btnMultiplicacion = findViewById(R.id.multiBt);
        btnDivision = findViewById(R.id.divisionBt);
        et1.addTextChangedListener(textWatcher);
        et2.addTextChangedListener(textWatcher);
    }

    /**
     * Interfaz que se compone de 3 métodos diferentes los cuales
     * realizan ciertas acciones según se cambie el texto, antes, durante o después
     * En mi caso, sólo usé el método onTextChanged para habilitar o deshabilitar
     * los botones si hay al menos un número en ambos TextView
     * Disclaimer: para que funcione correctamente, hay que modificar el estado
     * por defecto de los botones a false. Así, al iniciar la aplicación, se encontrarán
     * desactivados
     */
    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String numUnoInput = et1.getText().toString().trim();
                String numDosInput = et2.getText().toString().trim();
                //Comprueba si hay algún campo de texto vacío. Si sí, los botones
            //se desactivan
                btnSuma.setEnabled(!numUnoInput.isEmpty() && !numDosInput.isEmpty());
                btnResta.setEnabled(!numUnoInput.isEmpty() && !numDosInput.isEmpty());
                btnMultiplicacion.setEnabled(!numUnoInput.isEmpty() && !numDosInput.isEmpty());
                btnDivision.setEnabled(!numUnoInput.isEmpty() && !numDosInput.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
    /**
     * Método que controla las sumas en la calculadora
     * @param view
     */
    public void sumar(View view) {

        // Obtenemos los números
        double n1=Double.parseDouble(et1.getText().toString());
        double n2=Double.parseDouble(et2.getText().toString());

        // Hacemos la suma
        double suma=n1+n2;
        //Define el formato de los decimales hasta 3
        DecimalFormat df = new DecimalFormat ("#.000");
        String sumFormat = df.format(suma);
        // Establecemos el resultado en el TextView
        tv1.setText(""+sumFormat);
    }

    /**
     * Método que controla las restas en la calculadora
     * @param view
     */
    public void restar(View view) {

        // Obtenemos los números
        double n1=Double.parseDouble(et1.getText().toString());
        double n2=Double.parseDouble(et2.getText().toString());

        // Hacemos la resta
        double resta=n1-n2;
        //Define el formato de los decimales hasta 3
        DecimalFormat df = new DecimalFormat ("#.000");
        String restaFormat = df.format(resta);
        // Establecemos el resultado en el TextView
        tv1.setText(""+restaFormat);
    }

    /**
     * Método que controla las multiplicaciones de la Calculadora
     * @param view
     */
    public void multiplicar(View view) {
        // Obtenemos los números
        double n1=Double.parseDouble(et1.getText().toString());
        double n2=Double.parseDouble(et2.getText().toString());

        // Hacemos la multiplicación
        double multiplicar=n1*n2;
        //Define el formato de los decimales hasta 3
        DecimalFormat df = new DecimalFormat ("#.000");
        String multiFormat = df.format(multiplicar);
        // Establecemos el resultado en el TextView
        tv1.setText(""+multiFormat);
    }

    /**
     * Método que controla las divisiones en la Calculadora.
     * @param view
     */
    public void dividir(View view){
        // Obtenemos los números
        double n1=Double.parseDouble(et1.getText().toString());
        Double n2=Double.parseDouble(et2.getText().toString());

        //Controlamos si el denominador es 0
        if(n2==0) {
            //Muestra un diálogo de alerta
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("CUIDAOOOOOOOO");
            builder.setMessage("No dividas entre 0");
            builder.setPositiveButton("perdón", null);
            AlertDialog dialog = builder.create();
            dialog.show();
        }else{
            // Hacemos la división
            double dividir=n1/n2;
            //Define el formato de los decimales hasta 3
            DecimalFormat df = new DecimalFormat ("#.000");
            String divFormat = df.format(dividir);
            // Establecemos el resultado en el TextView
            tv1.setText(""+divFormat);
        }
    }


}