package com.example.jc321013.unitconversion;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by jc321013 on 21/04/2017.
 */

public class Main2Activity extends AppCompatActivity {
    private EditText editTextConvert;
    private TextView convertedText;
    private Context context;
    Button convert;
    Button back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        convert = (Button) findViewById(R.id.convert);
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                converts centimeters to feet in the setting page when convert is clicked and displays it in the text field
                double foot = Double.parseDouble(editTextConvert.getText().toString());
                double cm = foot / 30.48;

                convertedText.setText("" + cm + "feet");


            }
        });

        context = this;
        back = (Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                when back button is clicked it take suser back to main screen from settings page

                Intent intent = new Intent(context, MainActivity.class);
                startActivity(intent);
            }
        });


        editTextConvert = (EditText) findViewById(R.id.editTextConvert);
        convertedText = (TextView) findViewById(R.id.convertedText);

        convertedText.setText("Your Conversion is:");
        editTextConvert.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence text, int start, int before, int count) {


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }


}

//}