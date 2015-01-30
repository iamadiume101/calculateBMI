package com.example.ikem.calculatebmi;

import android.widget.CompoundButton;

/**
 * Created by IKEM on 29/01/2015.
 */
        import java.text.DecimalFormat;

        import com.example.ikem.calculatebmi.R;

        import android.view.View;
        import android.view.View.OnClickListener;
        import android.widget.CompoundButton.OnCheckedChangeListener;
        import android.widget.TextView;
        import android.widget.Toast;

public class Listner implements OnClickListener, OnCheckedChangeListener {
    private MainActivity mainActivty;

    public Listner(MainActivity mainActivty) {
        this.mainActivty = mainActivty;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.calcbutton:
                if ((mainActivty.getWeightTV().getText().toString().length() > 0)
                        && (mainActivty.getHeightTV().getText().toString().length() > 0)) {
                    double weight = Float.parseFloat(mainActivty.getWeightTV()
                            .getText().toString());
                    double height = Float.parseFloat(mainActivty.getHeightTV()
                            .getText().toString());
                    double result=0.0;
                    DecimalFormat d = new DecimalFormat("0.00");

                    if (mainActivty.getRadioMetric().isChecked()) {
                        result = weight / (height * height);
                        mainActivty.getResultText().setText("" + d.format(result));
                    } else if (mainActivty.getRadioEnglish().isChecked()) {
                        result = ((weight * 703) / (height * height));
                        mainActivty.getResultText().setText("" + d.format(result));
                    }
                    TextView resultTV = (TextView)mainActivty.findViewById(R.id.textView2);
                    if(result<18.5){
                        resultTV.setText(mainActivty.getResources().getString(R.string.underweight));
                    }else if(result >= 18.5 && result < 24.99){
                        resultTV.setText(mainActivty.getResources().getString(R.string.normal));
                    }else if(result >= 24.99 && result < 29.99){
                        resultTV.setText(mainActivty.getResources().getString(R.string.overweight));
                    }else if(result >29.99){
                        resultTV.setText(mainActivty.getResources().getString(R.string.obese));
                    }

                }else{
                    Toast.makeText(mainActivty, "Enter All values", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.radio_english:
                if (isChecked) {
                    mainActivty.getRadioMetric().setChecked(false);
                }
                break;
            case R.id.radio_metric:
                if (isChecked) {
                    mainActivty.getRadioEnglish().setChecked(false);
                }
                break;
        }
    }

}
