package com.example.itc_errorhandling;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView tvHitung;
    Button btnLogin;
    EditText etNama,etNim,etHasil;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvHitung = findViewById(R.id.tv_hitung);
        etNama = findViewById(R.id.et_nama);
        etHasil = findViewById(R.id.et_hasil);
        etNim = findViewById(R.id.et_nim);
        btnLogin = findViewById(R.id.btn_login);

        int num1, num2;
        int bound = 15;
        Random rand = new Random();
        num1 = rand.nextInt(bound);
        num2 = rand.nextInt(bound);
        int hasil = num1 + num2;

        tvHitung.setText(num1 + " + " + num2 + " = ");

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // dengan try catch biasa
                try {
                    checkAngka(Integer.parseInt(etHasil.getText().toString()));
                }catch (NumberFormatException e){ //mengecek apa hasil input berupa angka atau bukan
                    Toast.makeText(MainActivity.this,"HASIL BERUPA ANGKA" ,Toast.LENGTH_SHORT).show();
                }

                // try catch dengan method
                try{
                    int inputHasil = Integer.parseInt(etHasil.getText().toString());
                    if(hasil != inputHasil || inputHasil < 0)
                        throw new IllegalArgumentException();
                    // jika hasil input tidak sesuai dengan hasil maka terjadi error yaitu illegal argument exception
                }catch (IllegalArgumentException e){
                    Toast.makeText(MainActivity.this,"HASIL OPERASI SALAH" ,Toast.LENGTH_SHORT).show();
                }

                try{
                    checkAngka(Integer.parseInt(etNim.getText().toString())); // mengecek apa nim berupa angka atau bukan
                } catch (NumberFormatException e){
                    Toast.makeText(MainActivity.this,"NIM BERUPA ANGKA" ,Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private static int checkAngka(int i) throws NumberFormatException{
        int nim;
        nim = i;
        return nim;
    }

}