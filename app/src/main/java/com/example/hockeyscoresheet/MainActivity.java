package com.example.hockeyscoresheet;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {

    Button showValue_Team1;
    Button showValue_Team2;
    Button btnPeriod;
    int counter_Team1 = 0;
    int counter_Team2 = 0;
    int totalPeriod_Team1 = 0;
    int totalPeriod_Team2 = 0;
    int intperiod = 1;
    String strCurPeriod_Home;
    String strCurPeriod_Visitor;

    TextView txtHome1;
    TextView txtHome2;
    TextView txtHome3;
    TextView txtHomeTotal;


    TextView txtVisitor1;
    TextView txtVisitor2;
    TextView txtVisitor3;
    TextView txtVisitorTotal;

    private int mCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        showValue_Team1 = (TextView) findViewById(R.id.button4);
//        showValue_Team2 = (TextView) findViewById(R.id.button3);
        showValue_Team1 = (Button) findViewById(R.id.button4);
        showValue_Team2 = (Button) findViewById(R.id.button3);
        btnPeriod = (Button) findViewById(R.id.btnPeriod);

        txtHome1 = (TextView) findViewById(R.id.txtHome1);
        txtHome2 = (TextView) findViewById(R.id.txtHome2);
        txtHome3 = (TextView) findViewById(R.id.txtHome3);
        txtHomeTotal = (TextView) findViewById(R.id.txtHomeTotal);

        txtVisitor1 = (TextView) findViewById(R.id.txtVisitor1);
        txtVisitor2 = (TextView) findViewById(R.id.txtVisitor2);
        txtVisitor3 = (TextView) findViewById(R.id.txtVisitor3);
        txtVisitorTotal = (TextView) findViewById(R.id.txtVisitorTotal);

    }
    // The following method is called by the Penalty button, it implements an Intent and
    // changes the view to Penalties view.  I also had to make changes in the manifest in order
    // create a "back button" by parenting to the main screen.

    public void goTOPenalty(View view){
            Intent intent = new Intent(this, Penalties.class);
            startActivity(intent);
    }

    public void CountIncrease_Team1(View view){
        counter_Team1 ++;
        showValue_Team1.setText(Integer.toString(counter_Team1));

    }

    public void CountIncrease_Team2(View v){
        counter_Team2 ++;
        showValue_Team2.setText(Integer.toString(counter_Team2));


    }
    public void Reset_SOG1 (View view) {
        ResetCounters(1);
//        showValue_Team1.setText((Integer.toString(counter_Team1)));
    }
    public void Reset_SOG2 (View view) {
//        counter_Team2 = 0;
        ResetCounters(2);
//        showValue_Team2.setText((Integer.toString(counter_Team2)));

    }

    public void ResetCounters (Integer intFlag) {

        if (intFlag == 1){
            counter_Team1 = 0;
            showValue_Team1.setText(Integer.toString(counter_Team1));
        }
        else if (intFlag == 2){
            counter_Team2 = 0;
            showValue_Team2.setText(Integer.toString(counter_Team2));
        }
        else if (intFlag == 3){
            counter_Team1 = 0;
            counter_Team2 = 0;
            showValue_Team1.setText(Integer.toString(counter_Team1));
            showValue_Team2.setText(Integer.toString(counter_Team2));

//            intperiod ++;
        }


    }

    public void CommitPeriodTotals(View v) {

        if (intperiod == 1) {
            txtHome1.setText(Integer.toString(counter_Team1));
            txtVisitor1.setText(Integer.toString(counter_Team2));
        }
        else if (intperiod == 2) {
            txtHome2.setText(Integer.toString(counter_Team1));
            txtVisitor2.setText(Integer.toString(counter_Team2));
        }
        else if (intperiod == 3) {
            txtHome3.setText(Integer.toString(counter_Team1));
            txtVisitor3.setText(Integer.toString(counter_Team2));
        }

        totalPeriod_Team1 = totalPeriod_Team1 + counter_Team1;
        totalPeriod_Team2 = totalPeriod_Team2 + counter_Team2;

        txtHomeTotal.setText(Integer.toString(totalPeriod_Team1));
        txtVisitorTotal.setText(Integer.toString(totalPeriod_Team2));

        btnPeriod.setText("Period Total " + Integer.toString(intperiod));

        intperiod ++;

        ResetCounters(3);

    }
}

