package com.example.quinnh.userinput;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity
{
double PercentCost;
double MealPrice;
double TotalCharge;
String PercentChoice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText Mprice=(EditText)findViewById(R.id.text_Mprice);
        final Spinner group=(Spinner)findViewById(R.id.txt_group);
        Button calculate=(Button)findViewById(R.id.btn);
        calculate.setOnClickListener(new View.OnClickListener() {
            final TextView result = ((TextView)findViewById(R.id.text_result));
            @Override
            public void onClick(View v)
            {
                MealPrice = Double.parseDouble (Mprice.getText().toString());
                DecimalFormat currency = new DecimalFormat("$###,###.##");
                PercentChoice = group.getSelectedItem().toString();
                if(PercentChoice.equals("5%"))
                {
                    PercentCost = 0.05;
                }
                else if(PercentChoice.equals("10%"))
                {
                    PercentCost = 0.1;
                }
                else if(PercentChoice.equals("15%"))
                {
                    PercentCost = 0.15;
                }
                else if(PercentChoice.equals("20%"))
                {
                    PercentCost = 0.2;
                }
                else if(PercentChoice.equals("25%"))
                {
                    PercentCost = 0.25;
                }
                TotalCharge = PercentCost * MealPrice;
                result.setText("You have selected " + PercentChoice + " so the proper tip is " + currency.format(TotalCharge));
            }
        });

    }
}
