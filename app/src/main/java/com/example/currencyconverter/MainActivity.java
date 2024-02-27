package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Spinner sp1, sp2;
    EditText editText;
    TextView editText2, last;
    Button convert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.amt);
        sp1 = findViewById(R.id.sp1);
        sp2 = findViewById(R.id.sp2);
        convert = findViewById(R.id.button);
        editText2 = findViewById(R.id.editText2);
        last = findViewById(R.id.last);

        editText2.setText("");
        getSupportActionBar().hide();

editText.setOnKeyListener(new View.OnKeyListener() {
    @Override
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (editText.length() > 15) {
            editText.setText("");
            Toast.makeText(MainActivity.this, "Please enter proper amount", Toast.LENGTH_SHORT).show();
        }else if(editText.length() > 0){
          convert.setVisibility(view.VISIBLE);
        }else if(editText.length()-1 == -1){
            convert.setVisibility(view.GONE);
            last.setText("");
            editText2.setText("");
        }
        System.out.println(editText.length()-1);

        return false;
    }
});

        String[] from = {"Select currency","USD", "INR", "EURO", "CAD", "GBP", "HKD", "AED"};

        ArrayAdapter ad1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, from);
        sp1.setAdapter(ad1);
        String[] to = {"Select currency","INR", "USD", "EURO", "CAD", "GBP", "HKD", "AED"};
        ArrayAdapter ad2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, to);
        sp2.setAdapter(ad2);


        convert.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                Double total;
                Double amt = Double.parseDouble(editText.getText().toString());

                if(sp1.getSelectedItem().toString().equals("Select currency") && (sp2.getSelectedItem().toString().equals("INR") ||
                        sp2.getSelectedItem().toString().equals("USD") || sp2.getSelectedItem().toString().equals("HKD")
                        || sp2.getSelectedItem().toString().equals("AED")
                        || sp2.getSelectedItem().toString().equals("EURO") || sp2.getSelectedItem().toString().equals("GBP") ||
                        sp2.getSelectedItem().toString().equals("CAD"))){
                    Toast.makeText(MainActivity.this, "Please select proper currency", Toast.LENGTH_SHORT).show();
                }else
                if(sp2.getSelectedItem().toString().equals("Select currency") && (sp1.getSelectedItem().toString().equals("INR") ||
                        sp1.getSelectedItem().toString().equals("USD") || sp1.getSelectedItem().toString().equals("HKD") ||
                        sp1.getSelectedItem().toString().equals("AED")
                        || sp1.getSelectedItem().toString().equals("EURO") || sp1.getSelectedItem().toString().equals("GBP") ||
                        sp1.getSelectedItem().toString().equals("CAD"))){
                    Toast.makeText(MainActivity.this, "please select proper currency", Toast.LENGTH_SHORT).show();
                }else
                    if(sp1.getSelectedItem().toString().equals("Select currency") && sp2.getSelectedItem().toString().equals("Select currency")){
                    Toast.makeText(MainActivity.this, "Please select proper currency", Toast.LENGTH_SHORT).show();
                }else
                if(sp1.getSelectedItem().toString().equals("USD") && sp2.getSelectedItem().toString().equals("INR")) {
                    total = 81 * amt;
                    total = Math.round(total * 100.0) / 100.0;
                    editText2.setText(""+total);
                }else
                    if(sp1.getSelectedItem().toString().equals("INR") && sp2.getSelectedItem().toString().equals("USD")){
                        total = amt / 81;
                        total = Math.round(total * 100.0) / 100.0;
                    editText2.setText(""+total);
                }else
                    if(sp1.getSelectedItem().toString().equals("INR") && sp2.getSelectedItem().toString().equals("INR")){
                        total = amt;
//                        total = Math.round(total * 100.0) / 100.0;
                        editText2.setText(""+total);
                    }else
                        if(sp1.getSelectedItem().toString().equals("USD") && sp2.getSelectedItem().toString().equals("USD")) {
                            total = amt;
//                            total = Math.round(total * 100.0) / 100.0;
                            editText2.setText("" + total);
                        }else
                            if(sp1.getSelectedItem().toString().equals("INR") && sp2.getSelectedItem().toString().equals("EURO")) {
                            total = amt / 78;
                                total = Math.round(total * 100.0) / 100.0;
                            editText2.setText("" + total);
            }else
                if(sp1.getSelectedItem().toString().equals("EURO") && sp2.getSelectedItem().toString().equals("INR")) {
                    total = amt * 78;
                    total = Math.round(total * 100.0) / 100.0;
                    editText2.setText("" + total);
                }else
                if(sp1.getSelectedItem().toString().equals("EURO") && sp2.getSelectedItem().toString().equals("EURO")) {
                    total = amt;
//                    total = Math.round(total * 100.0) / 100.0;
                    editText2.setText("" + total);
                }else
                if(sp1.getSelectedItem().toString().equals("INR") && sp2.getSelectedItem().toString().equals("CAD")) {
                    total = amt / 60;
                    total = Math.round(total * 100.0) / 100.0;
                    editText2.setText("" + total);
                }else
                if(sp1.getSelectedItem().toString().equals("CAD") && sp2.getSelectedItem().toString().equals("INR")) {
                    total = amt * 60;
                    total = Math.round(total * 100.0) / 100.0;
                    editText2.setText("" + total);
                }else
                if(sp1.getSelectedItem().toString().equals("CAD") && sp2.getSelectedItem().toString().equals("CAD")) {
                    total = amt;
//                    total = Math.round(total * 100.0) / 100.0;
                    editText2.setText("" + total);
                }else
                if(sp1.getSelectedItem().toString().equals("INR") && sp2.getSelectedItem().toString().equals("GBP")) {
                    total = amt / 88;
                    total = Math.round(total * 100.0) / 100.0;
                    editText2.setText("" + total);
                }else
                if(sp1.getSelectedItem().toString().equals("GBP") && sp2.getSelectedItem().toString().equals("INR")) {
                    total = amt * 88;
                    total = Math.round(total * 100.0) / 100.0;
                    editText2.setText("" + total);
                }else
                if(sp1.getSelectedItem().toString().equals("GBP") && sp2.getSelectedItem().toString().equals("GBP")) {
                    total = amt;
//                    total = Math.round(total * 100.0) / 100.0;
                    editText2.setText("" + total);
                }else
                if(sp1.getSelectedItem().toString().equals("INR") && sp2.getSelectedItem().toString().equals("HKD")) {
                    total = amt / 10;
                    total = Math.round(total * 100.0) / 100.0;
                    editText2.setText("" + total);
                }else
                if(sp1.getSelectedItem().toString().equals("HKD") && sp2.getSelectedItem().toString().equals("INR")) {
                    total = amt * 10;
                    total = Math.round(total * 100.0) / 100.0;
                    editText2.setText("" + total);
                }else
                if(sp1.getSelectedItem().toString().equals("HKD") && sp2.getSelectedItem().toString().equals("HKD")) {
                    total = amt;
                    total = Math.round(total * 100.0) / 100.0;
                    editText2.setText("" + total);
                }else
                if(sp1.getSelectedItem().toString().equals("INR") && sp2.getSelectedItem().toString().equals("AED")) {
                    total = amt / 22;
                    total = Math.round(total * 100.0) / 100.0;
                    editText2.setText("" + total);
                }else
                if(sp1.getSelectedItem().toString().equals("AED") && sp2.getSelectedItem().toString().equals("INR")) {
                    total = amt * 22;
                    total = Math.round(total * 100.0) / 100.0;
                    editText2.setText("" + total);
                }else
                if(sp1.getSelectedItem().toString().equals("AED") && sp2.getSelectedItem().toString().equals("AED")) {
                    total = amt;
//                    total = Math.round(total * 100.0) / 100.0;
                    editText2.setText("" + total);
                }else
                if(sp1.getSelectedItem().toString().equals("USD") && sp2.getSelectedItem().toString().equals("EURO")) {
                    total = amt * 1.03;
                    total = Math.round(total * 100.0) / 100.0;
                    editText2.setText("" + total);
                }else
                if(sp1.getSelectedItem().toString().equals("EURO") && sp2.getSelectedItem().toString().equals("USD")) {
                    total = amt / 1.03;
                    total = Math.round(total * 100.0) / 100.0;
                    editText2.setText("" + total);
                }else
                if(sp1.getSelectedItem().toString().equals("USD") && sp2.getSelectedItem().toString().equals("CAD")) {
                    total = amt * 1.36;
                    total = Math.round(total * 100.0) / 100.0;
                    editText2.setText("" + total);
                }else
                if(sp1.getSelectedItem().toString().equals("CAD") && sp2.getSelectedItem().toString().equals("USD")) {
                    total = amt / 1.36;
                    total = Math.round(total * 100.0) / 100.0;
                    editText2.setText("" + total);
                }else
                if(sp1.getSelectedItem().toString().equals("USD") && sp2.getSelectedItem().toString().equals("GBP")) {
                    total = amt / 1.09;
                    total = Math.round(total * 100.0) / 100.0;
                    editText2.setText("" + total);
                }else
                if(sp1.getSelectedItem().toString().equals("GBP") && sp2.getSelectedItem().toString().equals("USD")) {
                    total = amt * 1.09;
                    total = Math.round(total * 100.0) / 100.0;
                    editText2.setText("" + total);
                }else
                if(sp1.getSelectedItem().toString().equals("USD") && sp2.getSelectedItem().toString().equals("HKD")) {
                    total = amt * 7.85;
                    total = Math.round(total * 100.0) / 100.0;
                    editText2.setText("" + total);
                }else
                if(sp1.getSelectedItem().toString().equals("HKD") && sp2.getSelectedItem().toString().equals("USD")) {
                    total = amt / 7.85;
                    total = Math.round(total * 100.0) / 100.0;
                    editText2.setText("" + total);
                }else
                if(sp1.getSelectedItem().toString().equals("USD") && sp2.getSelectedItem().toString().equals("AED")) {
                    total = amt * 3.6;
                    total = Math.round(total * 100.0) / 100.0;
                    editText2.setText("" + total);
                }else
                if(sp1.getSelectedItem().toString().equals("AED") && sp2.getSelectedItem().toString().equals("USD")) {
                    total = amt / 3.6;
                    total = Math.round(total * 100.0) / 100.0;
                    editText2.setText("" + total);
                }else
                if(sp1.getSelectedItem().toString().equals("EURO") && sp2.getSelectedItem().toString().equals("CAD")) {
                    total = amt * 1.3;
                    total = Math.round(total * 100.0) / 100.0;
                    editText2.setText("" + total);
                }else
                if(sp1.getSelectedItem().toString().equals("CAD") && sp2.getSelectedItem().toString().equals("EURO")) {
                    total = amt / 1.3;
                    total = Math.round(total * 100.0) / 100.0;
                    editText2.setText("" + total);
                }else
                if(sp1.getSelectedItem().toString().equals("EURO") && sp2.getSelectedItem().toString().equals("GBP")) {
                    total = amt / 1.12;
                    total = Math.round(total * 100.0) / 100.0;
                    editText2.setText("" + total);
                }else
                if(sp1.getSelectedItem().toString().equals("GBP") && sp2.getSelectedItem().toString().equals("EURO")) {
                    total = amt * 1.12;
                    total = Math.round(total * 100.0) / 100.0;
                    editText2.setText("" + total);
                }else
                if(sp1.getSelectedItem().toString().equals("EURO") && sp2.getSelectedItem().toString().equals("HKD")) {
                    total = amt * 7.61;
                    total = Math.round(total * 100.0) / 100.0;
                    editText2.setText("" + total);
                }else
                if(sp1.getSelectedItem().toString().equals("HKD") && sp2.getSelectedItem().toString().equals("EURO")) {
                    total = amt / 7.61;
                    total = Math.round(total * 100.0) / 100.0;
                    editText2.setText("" + total);
                }else
                if(sp1.getSelectedItem().toString().equals("EURO") && sp2.getSelectedItem().toString().equals("AED")) {
                    total = amt * 3.56;
                    total = Math.round(total * 100.0) / 100.0;
                    editText2.setText("" + total);
                }else
                if(sp1.getSelectedItem().toString().equals("AED") && sp2.getSelectedItem().toString().equals("EURO")) {
                    total = amt / 3.56;
                    total = Math.round(total * 100.0) / 100.0;
                    editText2.setText("" + total);
                }else
                if(sp1.getSelectedItem().toString().equals("CAD") && sp2.getSelectedItem().toString().equals("HKD")) {
                    total = amt * 5.78;
                    total = Math.round(total * 100.0) / 100.0;
                    editText2.setText("" + total);
                }else
                if(sp1.getSelectedItem().toString().equals("HKD") && sp2.getSelectedItem().toString().equals("CAD")) {
                    total = amt / 5.78;
                    total = Math.round(total * 100.0) / 100.0;
                    editText2.setText("" + total);
                }else
                if(sp1.getSelectedItem().toString().equals("CAD") && sp2.getSelectedItem().toString().equals("AED")) {
                    total = amt * 2.7;
                    total = Math.round(total * 100.0) / 100.0;
                    editText2.setText("" + total);
                }else
                if(sp1.getSelectedItem().toString().equals("AED") && sp2.getSelectedItem().toString().equals("CAD")) {
                    total = amt / 2.7;
                    total = Math.round(total * 100.0) / 100.0;
                    editText2.setText("" + total);
                }else
                if(sp1.getSelectedItem().toString().equals("CAD") && sp2.getSelectedItem().toString().equals("GBP")) {
                    total = amt / 1.5;
                    total = Math.round(total * 100.0) / 100.0;
                    editText2.setText("" + total);
                }else
                if(sp1.getSelectedItem().toString().equals("GBP") && sp2.getSelectedItem().toString().equals("CAD")) {
                    total = amt * 1.5;
                    total = Math.round(total * 100.0) / 100.0;
                    editText2.setText("" + total);
                }else
                if(sp1.getSelectedItem().toString().equals("GBP") && sp2.getSelectedItem().toString().equals("HKD")) {
                    total = amt * 8.52;
                    total = Math.round(total * 100.0) / 100.0;
                    editText2.setText("" + total);
                }else
                if(sp1.getSelectedItem().toString().equals("HKD") && sp2.getSelectedItem().toString().equals("GBP")) {
                    total = amt / 8.52;
                    total = Math.round(total * 100.0) / 100.0;
                    editText2.setText("" + total);
                }else
                if(sp1.getSelectedItem().toString().equals("GBP") && sp2.getSelectedItem().toString().equals("AED")) {
                    total = amt * 4;
                    total = Math.round(total * 100.0) / 100.0;
                    editText2.setText("" + total);
                }else
                if(sp1.getSelectedItem().toString().equals("AED") && sp2.getSelectedItem().toString().equals("GBP")) {
                    total = amt / 4;
                    total = Math.round(total * 100.0) / 100.0;
                    editText2.setText("" + total);
                }else
                if(sp1.getSelectedItem().toString().equals("HKD") && sp2.getSelectedItem().toString().equals("AED")) {
                    total = amt / 2.14;
                    total = Math.round(total * 100.0) / 100.0;
                    editText2.setText("" + total);
                }else
                if(sp1.getSelectedItem().toString().equals("AED") && sp2.getSelectedItem().toString().equals("HKD")) {
                    total = amt * 2.14;
                    total = Math.round(total * 100.0) / 100.0;
                    editText2.setText("" + total);
                }

    if(sp1.getSelectedItem().toString().equals("Select currency") && (sp2.getSelectedItem().toString().equals("INR") ||
            sp2.getSelectedItem().toString().equals("USD") || sp2.getSelectedItem().toString().equals("HKD")
            || sp2.getSelectedItem().toString().equals("AED")
            || sp2.getSelectedItem().toString().equals("EURO") || sp2.getSelectedItem().toString().equals("GBP") ||
            sp2.getSelectedItem().toString().equals("CAD"))){
        last.setText("");
        editText2.setText("");
    }else
    if(sp2.getSelectedItem().toString().equals("Select currency") && (sp1.getSelectedItem().toString().equals("INR") ||
            sp1.getSelectedItem().toString().equals("USD") || sp1.getSelectedItem().toString().equals("HKD") ||
            sp1.getSelectedItem().toString().equals("AED")
            || sp1.getSelectedItem().toString().equals("EURO") || sp1.getSelectedItem().toString().equals("GBP") ||
            sp1.getSelectedItem().toString().equals("CAD"))){
        last.setText("");
        editText2.setText("");
    }else
    if(sp1.getSelectedItem().toString().equals("Select currency") && sp2.getSelectedItem().toString().equals("Select currency")){
        last.setText("");
        editText2.setText("");
    }else if(editText.length()-1 == -1){
        last.setText("");
        editText2.setText("");
    }else {
        last.setText("Converted currency is ");
    }
            }
        });
    }
}
