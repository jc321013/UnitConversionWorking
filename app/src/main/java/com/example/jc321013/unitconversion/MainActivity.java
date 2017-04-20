package com.example.jc321013.unitconversion;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText centimeters, meters, inches, feet;
    Button submitButton;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        centimeters = (EditText) findViewById(R.id.centimeterConversion);
        meters = (EditText) findViewById(R.id.meterConversion);
        inches = (EditText) findViewById(R.id.InchesConversion);
        feet = (EditText) findViewById(R.id.footConversion);
        submitButton = (Button) findViewById(R.id.button);





        submitButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                double cm = Double.parseDouble(centimeters.getText().toString());
                double m = cm / 100;
                double inch = cm / 2.54;
                double foot = inch / 12;

                meters.setText("" + m);
                inches.setText("" + inch);
                feet.setText("" + foot);


            }
        });

    }
}

