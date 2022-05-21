package com.example.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{

    private Button botao;
    private TextView txtPais;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        botao = findViewById(R.id.btnPais);
        txtPais = findViewById(R.id.txtPais);
        botao.setOnClickListener(this);

    }
    public void onClick(View view){
        if(view.getId() == R.id.btnPais){
            txtPais.setVisibility(View.VISIBLE);
            txtPais.setText(R.string.pais);
        }

    }
}