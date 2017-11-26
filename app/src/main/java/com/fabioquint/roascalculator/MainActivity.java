package com.fabioquint.roascalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int revenue;
    int adSpend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText edtRevenue = (EditText) findViewById(R.id.edtRevenue);
        final EditText edtAdSpend = (EditText) findViewById(R.id.edtAdSpend);
        final TextView resultTxt = (TextView) findViewById(R.id.resultTxt);
        final TextView messageTxt = (TextView) findViewById(R.id.messageTxt);
        Button calcButton = (Button) findViewById(R.id.calcBtn);


        calcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int result;
                String ratio;

                ROASMetric analytics = new ROASMetric();
                revenue = Integer.parseInt(edtRevenue.getText().toString());
                adSpend = Integer.parseInt(edtAdSpend.getText().toString());

                analytics.setRevenue(revenue);
                analytics.setAdSpend(adSpend);
                result = analytics.calcMetric();
                ratio = analytics.getRatio();

                resultTxt.setText("$" + result + " or " + ratio);
                messageTxt.setText(analytics.printData());

            }
        });

    }

}
