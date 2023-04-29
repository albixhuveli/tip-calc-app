package com.tip.TipCalculatorActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edt15,edt20,edt25;
    EditText edt15T,edt20T,edt25T;
    Button buttonCompute;
    EditText edt_amount,edt_party_size;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt15 = findViewById(R.id.edt_15);
        edt20 = findViewById(R.id.edt_20);
        edt25 = findViewById(R.id.edt_25);

        edt15T = findViewById(R.id.edt_15_t);
        edt20T = findViewById(R.id.edt_20_t);
        edt25T = findViewById(R.id.edt_25_t);

        buttonCompute = findViewById(R.id.compute);

        edt_party_size  =  findViewById(R.id.edt_party_size);
        edt_amount = findViewById(R.id.edt_amount);


        buttonCompute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String amount = edt_amount.getText().toString().trim();
                String partySize = edt_party_size.getText().toString().trim();
                if(amount.isEmpty() ||amount.contains("-")){
                    Toast.makeText(MainActivity.this, "Enter valid amount", Toast.LENGTH_SHORT).show();
                }
                else if(partySize.isEmpty() || partySize.contains("-")||partySize.contentEquals("0")){
                    Toast.makeText(MainActivity.this, "Enter Valid Size", Toast.LENGTH_SHORT).show();
                }
                else{
                    double am = Double.parseDouble(amount);
                    int ps = Integer.parseInt(partySize);

                    double result = am/ps;

                    edt15.setText(String.valueOf(Math.round(result*0.15)));
                    edt20.setText(String.valueOf(Math.round(result*0.20)));
                    edt25.setText(String.valueOf(Math.round(result*0.25)));

                    edt15T.setText(String.valueOf(Math.round(result*1.15)));
                    edt20T.setText(String.valueOf(Math.round(result*1.20)));
                    edt25T.setText(String.valueOf(Math.round(result*1.25)));


                }
            }
        });


    }
}