package com.example.tugas8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    CheckBox CBCotoMakassar, CBSopSaudara, CBKetupat;
    EditText ETCotoMakassar, ETSopSaudara, ETKetupat;
    TextView TVTotal;
    boolean statuscoto = false, statussop = false, statusketupat = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickSopSaudara(View view) {
        ETSopSaudara = (EditText) findViewById(R.id.EDSopSaudara);
        CBSopSaudara = (CheckBox) findViewById(R.id.CBSopSaudara);
        ETSopSaudara.setText("0");
        if (CBSopSaudara.isChecked()){
            ETSopSaudara.setText("0");
            statussop = true;
        }

        if (!CBSopSaudara.isChecked()){
            ETSopSaudara.setText("");
            statussop = false;
        }
    }

    public void clickCotoMakassar(View view) {
        ETCotoMakassar = (EditText) findViewById(R.id.EDCotoMakassar);
        CBCotoMakassar = (CheckBox) findViewById(R.id.CBCotoMakassar);
        ETCotoMakassar.setText("0");
        if (CBCotoMakassar.isChecked()){
            ETCotoMakassar.setText("0");
            statuscoto = true;
        }

        if (!CBCotoMakassar.isChecked()){
            ETCotoMakassar.setText("");
            statuscoto = false;
        }
    }

    public void clickKetupat(View view) {
        ETKetupat= (EditText) findViewById(R.id.EDKetupat);
        CBKetupat = (CheckBox) findViewById(R.id.CBKetupat);
        if (CBKetupat.isChecked()){
            ETKetupat.setText("0");
            statusketupat = true;
        }

        if (!CBKetupat.isChecked()){
            ETKetupat.setText("");
            statusketupat = false;
        }

    }

    public void clickReset(View view) {
        ETKetupat= (EditText) findViewById(R.id.EDKetupat);
        ETCotoMakassar = (EditText) findViewById(R.id.EDCotoMakassar);
        ETSopSaudara = (EditText) findViewById(R.id.EDSopSaudara);
        TVTotal = (TextView) findViewById(R.id.TVTotal);
        CBKetupat = (CheckBox) findViewById(R.id.CBKetupat);
        CBCotoMakassar = (CheckBox) findViewById(R.id.CBCotoMakassar);
        CBSopSaudara = (CheckBox) findViewById(R.id.CBSopSaudara);

        ETKetupat.setText("");
        ETCotoMakassar.setText("");
        ETSopSaudara.setText("");
        TVTotal.setText("Total");
        CBKetupat.setChecked(false);
        CBCotoMakassar.setChecked(false);
        CBSopSaudara.setChecked(false);
    }

    public void clickOk(View view) {
        Locale localeID = new Locale("in", "ID");
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
        ETKetupat= (EditText) findViewById(R.id.EDKetupat);
        ETCotoMakassar = (EditText) findViewById(R.id.EDCotoMakassar);
        ETSopSaudara = (EditText) findViewById(R.id.EDSopSaudara);
        TVTotal = (TextView) findViewById(R.id.TVTotal);
        int jmlcoto = 0, jmlsop = 0, jmlketupat = 0, hasilcoto = 0, hasilsop = 0, hasilketupat = 0, total = 0;
        jmlcoto = (statuscoto == true) ? Integer.parseInt(ETCotoMakassar.getText().toString()) : 0;
        jmlsop = (statussop == true) ? Integer.parseInt(ETSopSaudara.getText().toString()) : 0;
        jmlketupat = (statusketupat == true) ? Integer.parseInt(ETKetupat.getText().toString()) : 0;
        hasilcoto = (statuscoto == true) ? jmlcoto * 13000 : 0 ;
        hasilsop = (statussop == true) ? jmlsop * 20000 : 0 ;
        hasilketupat  = (statusketupat == true) ? jmlketupat * 1000 : 0 ;

        total = hasilcoto + hasilsop + hasilketupat;
        TVTotal.setText("Total : " + formatRupiah.format((double)total));


    }
}
