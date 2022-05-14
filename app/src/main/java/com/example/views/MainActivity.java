package com.example.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtNome;
    private EditText edtEmail;
    private EditText edtTelefone;

    private Switch swtWhats;
    private Switch swtNotificacao;


    private RadioGroup rdgSexo;
    private RadioButton rdbMasculino;
    private RadioButton rdbFeminino;

    private RadioGroup rdgPeriodo;
    private RadioButton rdbManha;
    private RadioButton rdbTarde;
    private RadioButton rdbNoite;

    private CheckBox chbInternet;
    private CheckBox chbTv;
    private CheckBox chbStreaming;
    private CheckBox chbTelefone;

    private Button btnExibir;
    private Button btnLimpar;

    private LinearLayout lblDados;
    private TextView txtNome;
    private TextView txtEmail;
    private TextView txtTelefone;
    private TextView txtWhats;
    private TextView txtPeriodo;
    private TextView txtPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNome = findViewById(R.id.edtNome);
        edtEmail = findViewById(R.id.edtEmail);


        edtTelefone = findViewById(R.id.edtTelefone);

        swtWhats = findViewById(R.id.swtWhats);

        swtNotificacao = findViewById(R.id.swtNotificacao);


        rdgSexo = findViewById(R.id.rdgSexo);
        rdbMasculino = findViewById(R.id.rdbMasculino);
        rdbFeminino = findViewById(R.id.rdbFeminino);

        rdgPeriodo = findViewById(R.id.rdgPeriodo);
        rdbManha = findViewById(R.id.rdbManha);
        rdbTarde = findViewById(R.id.rdbTarde);
        rdbNoite = findViewById(R.id.rdbNoite);

        chbInternet = findViewById(R.id.chkInternet);
        chbTv = findViewById(R.id.chkTv);
        chbStreaming = findViewById(R.id.chkStreaming);
        chbTelefone = findViewById(R.id.chkTelefone);

        btnExibir = findViewById(R.id.btnOk);
        btnLimpar = findViewById(R.id.btnCancelar);

        btnExibir.setOnClickListener(this);
        btnLimpar.setOnClickListener(this);

        edtNome.setFilters(new InputFilter[] {new InputFilter.AllCaps()});

        lblDados = findViewById(R.id.lblDados);
        txtNome = findViewById(R.id.txtNome);
        txtEmail = findViewById(R.id.txtEmail);
        txtTelefone = findViewById(R.id.txtTelefone);
        txtWhats = findViewById(R.id.txtWhats);
        txtPeriodo = findViewById(R.id.txtPeriodo);
        txtPref = findViewById(R.id.txtPref);
    }
    @Override
    public  void onClick(View view){
        if(view.getId() == R.id.btnOk) {
            Toast.makeText(this,"Exibir", Toast.LENGTH_LONG).show();
            if (view.getId() == R.id.btnOk){
                //Toast.makeText(this, "Exibir", Toast.LENGTH_LONG).show();
                lblDados.setVisibility(View.VISIBLE);
                txtNome.setText("Nome: " + edtNome.getText().toString());
                txtEmail.setText(edtEmail.getText().toString());
                txtTelefone.setText(edtTelefone.getText().toString());
                if (swtWhats.isChecked())
                    txtWhats.setText("WhatsApp: " + swtWhats.getTextOn());
                else
                    txtWhats.setText("WhatsApp: " + swtWhats.getTextOff());

                int idrdbSelecionado = rdgPeriodo.getCheckedRadioButtonId();
                if (idrdbSelecionado > 0){
                    RadioButton rdbSelecionado = findViewById(idrdbSelecionado);
                    txtPeriodo.setText("Período: " + rdbSelecionado.getText().toString());
                }

                String pref="";
                if (chbInternet.isChecked())
                    pref = chbInternet.getText().toString();
                if (chbTelefone.isChecked()) {
                    pref += " ";
                    pref += chbTelefone.getText().toString();
                }
                if(chbTv.isChecked()){
                    pref += " ";
                    pref += chbTv.getText().toString();
                }
                if(chbStreaming.isChecked()){
                    pref += " ";
                    pref += chbStreaming.getText().toString();
                }
                txtPref.setText("Preferências: " + pref);

            }


        }else if(view.getId() == R.id.btnCancelar){
            //Toast.makeText(this,"Limpar", Toast.LENGTH_SHORT).show();
            edtNome.setText("");
            edtTelefone.setText("");
            edtEmail.setText("");

            swtWhats.setChecked(false);
            swtNotificacao.setChecked(false);

            rdgSexo.clearCheck();
            rdgPeriodo.clearCheck();

            chbInternet.setChecked(false);
            chbTv.setChecked(false);
            chbStreaming.setChecked(false);
            chbTelefone.setChecked(false);

        }
    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

}