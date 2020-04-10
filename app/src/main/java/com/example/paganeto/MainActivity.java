package com.example.paganeto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText paga_bruto;
    TextView kontributi_punetorit,kontributi_punedhenesit,kontributi_total,tatimi_total,paga_neto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        paga_bruto = (EditText) findViewById(R.id.paga_bruto_id);
        kontributi_punedhenesit = (TextView) findViewById(R.id.kontributi_punedhenesit_id);
        kontributi_punetorit = (TextView) findViewById(R.id.kontributi_punetorit_id);
        kontributi_total = (TextView) findViewById(R.id.kontributi_total_id);
        tatimi_total = (TextView) findViewById(R.id.tatimi_id);
        paga_neto = (TextView) findViewById(R.id.paga_neto_id);
    }

    public void pagaNeto(View v){
        Double pagaBruto = Double.parseDouble(String.valueOf(paga_bruto.getText()));
        Double kontributiPesPerqind = pagaBruto * 0.05;
        Double kontributiTotal = kontributiPesPerqind * 2;
        kontributi_punedhenesit.setText(kontributiPesPerqind.toString());
        kontributi_punetorit.setText(kontributiPesPerqind.toString());
        kontributi_total.setText(kontributiTotal.toString());

        Double tatimi;
        if ((pagaBruto <= 80) && (pagaBruto >0)) {
            tatimi = 0.0;

        }
        else if ((pagaBruto <= 250) && (pagaBruto >80)) {
            tatimi = 6.8;
        }
        else if ((pagaBruto <= 450) && (pagaBruto >250)) {
            tatimi = 16.0;
        }
        else {
            tatimi =6.8 + 16.0 + ((pagaBruto- kontributiPesPerqind -450)*0.1);
        }

        tatimi_total.setText(tatimi.toString());

        Double pagaPerfundimtare = pagaBruto - kontributiPesPerqind - tatimi;

        paga_neto.setText(pagaPerfundimtare.toString());
    }
}
