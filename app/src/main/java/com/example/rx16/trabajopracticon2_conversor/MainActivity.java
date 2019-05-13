package com.example.rx16.trabajopracticon2_conversor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public final float DOLAR = 44.80f;
    public final float EURO = 50.35f;
    public final float REAL = 11.32f;

    private EditText editTextMontoIN;
    private RadioGroup radioGroup;
    private RadioButton radioButtonDolar;
    private RadioButton radioButtonEuro;
    private RadioButton radioButtonReal;
    private Button buttonConvertir;
    private Button buttonReset;
    private TextView textViewResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        identificar();
        clicBotones();

    }

    public void identificar(){
        editTextMontoIN = findViewById(R.id.editTextMontoIN);
        radioGroup = findViewById(R.id.radioGroup);
        radioButtonDolar = findViewById(R.id.radioButtonDolar);
        radioButtonEuro = findViewById(R.id.radioButtonEuro);
        radioButtonReal = findViewById(R.id.radioButtonReal);
        buttonConvertir = findViewById(R.id.buttonConvertir);
        buttonReset = findViewById(R.id.buttonReset);
        textViewResultado = findViewById(R.id.textViewResultado);
    }

    public void clicBotones(){
        buttonConvertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                convertir();
            }
        });
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reiniciar();
            }
        });
    }

    public void convertir(){
        float monto=0.00f;
        if (editTextMontoIN.getText().toString().isEmpty()){
            Toast.makeText(this, "Ingrese un Monto en Pesos", Toast.LENGTH_SHORT).show();
        }
        else{
            if (radioButtonDolar.isChecked()){
                monto = Float.parseFloat(String.valueOf(editTextMontoIN.getText())) / DOLAR;
            }
            if (radioButtonEuro.isChecked()){
                monto = Float.parseFloat(String.valueOf(editTextMontoIN.getText())) / EURO;
            }
            if (radioButtonReal.isChecked()){
                monto = Float.parseFloat(String.valueOf(editTextMontoIN.getText())) / REAL;
            }
            textViewResultado.setText(String.valueOf(monto));
        }

    }
    public void reiniciar(){
        editTextMontoIN.setText("");
        textViewResultado.setText("$ 0.00");
    }

}
