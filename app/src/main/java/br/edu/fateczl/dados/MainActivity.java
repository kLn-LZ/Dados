package br.edu.fateczl.dados;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    /*
     *@author: Kelvin Santos Guimarães
    */
    
    private RadioButton rbD4;
    private RadioGroup rgDados;
    private Button btnRolar;
    private Spinner spQtdDado;
    private TextView tvRes;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        rbD4 = findViewById(R.id.rbD4);
        rbD4.setChecked(true);
        rgDados = findViewById(R.id.rgDado);
        spQtdDado = findViewById(R.id.spQtdDado);
        btnRolar = findViewById(R.id.btnDados);
        tvRes = findViewById(R.id.tvRes);

        preencheSpinner();
        btnRolar.setOnClickListener(op -> gerar());

    }

    private void gerar() {
        switch (rgDados.getCheckedRadioButtonId()) {
            case 2131231084: rolarDados(4);
                break;
            case 2131231085: rolarDados(6);
                break;
            case 2131231086: rolarDados(8);
                break;
            case 2131231080: rolarDados(10);
                break;
            case 2131231082: rolarDados(12);
                break;
            case 2131231083: rolarDados(20);
                break;
            case 2131231081: rolarDados(100);
                break;

        }
    }

    private void rolarDados(int faces) {
        StringBuffer buffer =  new StringBuffer();
        Integer qtd = (Integer) spQtdDado.getSelectedItem();
        buffer.append("Faces que caíram: ");
        for (int i = 0; i < qtd; i++) {
            buffer.append((int) (Math.random() * faces) + 1);
            if (i < qtd - 1 ) {
                buffer.append(", ");
            }
        }
        mostrarResultado(buffer);
    }

    private void mostrarResultado(StringBuffer buffer) {
        tvRes.setText(buffer.toString());
    }

    private void preencheSpinner() {
        List<Integer> lista = new ArrayList<>();
        lista.add(1);
        lista.add(2);
        lista.add(3);

        ArrayAdapter adapter =  new ArrayAdapter(this, android.R.layout.simple_spinner_item, lista);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spQtdDado.setAdapter(adapter);
    }
}