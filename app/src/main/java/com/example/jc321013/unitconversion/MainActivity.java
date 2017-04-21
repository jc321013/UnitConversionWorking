package com.example.jc321013.unitconversion;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity
        implements SeekBar.OnSeekBarChangeListener, TextWatcher {


    private EditText centimeterConversion;
    private EditText meterConversion;
    private EditText InchesConversion;
    private TextView percentageText;
    private Context context;
    SeekBar percentageBar;
    Button submitButton;
    private Button button2;


    private NumberFormat percentageFormatter = NumberFormat.getPercentInstance();
    private NumberFormat unitFormatter = NumberFormat.getCurrencyInstance();

    private double percentageValue;
    private double afterPercentValue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
//        when the settings button is clicked it take user to new page
        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Main2Activity.class);
                startActivity(intent);

            }
        });


        centimeterConversion = (EditText) findViewById(R.id.centimeterConversion);
        meterConversion = (EditText) findViewById(R.id.meterConversion);
        InchesConversion = (EditText) findViewById(R.id.InchesConversion);
        percentageText = (TextView) findViewById(R.id.percentageText);
        percentageBar = (SeekBar) findViewById(R.id.percentageBar);
        submitButton = (Button) findViewById(R.id.button);


        percentageBar.setOnSeekBarChangeListener(this);


//        centimeterConversion.addTextChangedListener(this);
//        meterConversion.addTextChangedListener(this);
//        InchesConversion.addTextChangedListener(this);
//        footConversion.addTextChangedListener(this);


        submitButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
//converts centimeters to meters and inches and displays it in the text fields
                double cm = Double.parseDouble(centimeterConversion.getText().toString());
                double m = cm / 100;
                double inch = cm / 2.54;


                meterConversion.setText("" + m);
                InchesConversion.setText("" + inch);


            }
        });


    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        percentageValue = progress / 100.0;
        percentageText.setText(percentageFormatter.format(percentageValue));

        double percentValue = afterPercentValue * percentageValue;

        meterConversion.setText(unitFormatter.format(percentValue));
        InchesConversion.setText(unitFormatter.format(percentValue));


    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence text, int start, int before, int count) {
        if (text.length() > 0) {
            double value = Double.parseDouble(text.toString());
            afterPercentValue = value / 100;
            centimeterConversion.setText(unitFormatter.format(afterPercentValue));

            double percentValue = afterPercentValue * percentageValue;

            meterConversion.setText(unitFormatter.format(percentValue));
            InchesConversion.setText(unitFormatter.format(percentValue));

        } else {

        }

    }


    @Override
    public void afterTextChanged(Editable s) {

    }


}


