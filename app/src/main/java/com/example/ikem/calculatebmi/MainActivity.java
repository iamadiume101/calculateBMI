package com.example.ikem.calculatebmi;

import android.app.Activity;


        import com.example.ikem.calculatebmi.R;

        import android.app.Activity;
        import android.os.Bundle;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.RadioButton;
        import android.widget.TextView;

public class MainActivity extends Activity {

    private RadioButton radioEnglish;
    private RadioButton radioMetric;
    private Button calculateBT;
    private EditText weightTV;
    private EditText heightTV;
    private TextView resultText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weightTV = (EditText) findViewById(R.id.weighteditText);
        heightTV = (EditText) findViewById(R.id.heighteditText);
        calculateBT = (Button) findViewById(R.id.calcbutton);
        resultText = (TextView) findViewById(R.id.resulttextView);

        radioEnglish = (RadioButton) findViewById(R.id.radio_english);
        radioMetric = (RadioButton) findViewById(R.id.radio_metric);

        radioMetric.setOnCheckedChangeListener(new Listner(MainActivity.this));
        radioEnglish.setOnCheckedChangeListener(new Listner(MainActivity.this));
        calculateBT.setOnClickListener(new Listner(MainActivity.this));

    }

    public RadioButton getRadioEnglish() {
        return radioEnglish;
    }

    public void setRadioEnglish(RadioButton radioEnglish) {
        this.radioEnglish = radioEnglish;
    }

    public RadioButton getRadioMetric() {
        return radioMetric;
    }

    public void setRadioMetric(RadioButton radioMetric) {
        this.radioMetric = radioMetric;
    }

    public Button getCalculateBT() {
        return calculateBT;
    }

    public void setCalculateBT(Button calculateBT) {
        this.calculateBT = calculateBT;
    }

    public EditText getWeightTV() {
        return weightTV;
    }

    public void setWeightTV(EditText weightTV) {
        this.weightTV = weightTV;
    }

    public EditText getHeightTV() {
        return heightTV;
    }

    public void setHeightTV(EditText heightTV) {
        this.heightTV = heightTV;
    }

    public TextView getResultText() {
        return resultText;
    }

    public void setResultText(TextView resultText) {
        this.resultText = resultText;
    }

}
