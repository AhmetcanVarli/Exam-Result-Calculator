package com.example.finaldenkaalmamlazm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button hesapla;
    EditText vizeNot,vizeYuzde;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hesapla = findViewById(R.id.btn_hesapla);
        vizeNot = findViewById(R.id.txt_vizeNot);
        vizeYuzde = findViewById(R.id.txt_vizeYuzde);

        hesapla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (vizeNot.getText().toString().trim().equals("")||vizeYuzde.getText().toString().trim().equals("")) {
                    Toast.makeText(getApplicationContext(), "Kutucukları Doldurun", Toast.LENGTH_LONG).show();
                }
                else{
                    Random r = new Random();
                    int sayi;

                    String [] alt ={"çok calış lan","bok gecersin","ins seneye","ABVH"};
                    String [] yakın ={"aslansın yaparsın","gecersin lan","biraz daha calıs"};
                    String [] ustyakın ={"Hadi yine iyisin","Aferin lan","gectin yine"};
                    String [] ust ={"Helal len sana","Aferin lan","seneye gel ders anlat"};

                    double vize = Double.parseDouble(vizeNot.getText().toString());
                    double yuzde= Double.parseDouble(vizeYuzde.getText().toString());

                    double almanGereken,vizeNot,finalYuzde,enaz;

                    vizeNot = vize*yuzde/100;
                    finalYuzde = 100-yuzde;
                    enaz = 50 - vizeNot;
                    almanGereken = 100*enaz/finalYuzde;
                    NumberFormat ondalık = new DecimalFormat("#0.00");

                    if (vize > 100 || yuzde > 100){
                        Toast.makeText(getApplicationContext(),"yanlış değer girildi",Toast.LENGTH_LONG).show();
                    }else if(vize >= 50){
                        Toast.makeText(getApplicationContext(),"50 Al gec zorlama",Toast.LENGTH_LONG).show();
                    } else if (vize > 37){
                            sayi=r.nextInt(yakın.length);
                            Toast.makeText(getApplicationContext(),"Alman gereken not:"+ondalık.format(almanGereken)+" "+yakın[sayi],Toast.LENGTH_LONG).show();
                    }else {
                            sayi = r.nextInt(alt.length);
                            Toast.makeText(getApplicationContext(), "Alman gereken not:" + ondalık.format(almanGereken) +" "+ alt[sayi], Toast.LENGTH_LONG).show();
                        }
                    }
                }

        });

    }
}