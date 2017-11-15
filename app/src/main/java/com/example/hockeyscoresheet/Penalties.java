package com.example.hockeyscoresheet;

import android.provider.FontsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class Penalties extends AppCompatActivity {


    String blnFlag = "false";
    String strPenaltyData;

    String strPenalty;
    Spinner HomeVisitor;
    Spinner Period;
    EditText PlayerNumber;
    Spinner Penalty;
    EditText PenaltyMinutes;
    EditText PenaltyTime;
    TableLayout tv;
    TextView DebugCode;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_penalties);
        tv = (TableLayout) findViewById(R.id.tblPenalties);
       CommitPenatlties(new View(this));

    }



    public void CommitPenatlties(View view) {

        HomeVisitor = (Spinner) findViewById(R.id.ddPenHomeVisitor);
        Period = (Spinner) findViewById(R.id.ddPeriod);
        PlayerNumber = (EditText) findViewById(R.id.intPenPlayerNumber);
        Penalty = (Spinner) findViewById(R.id.ddPenalty);
        PenaltyMinutes = (EditText) findViewById(R.id.edPenPenaltyMin);
        PenaltyTime = (EditText) findViewById(R.id.edPenPenaltyTime);
        DebugCode = (TextView) findViewById(R.id.txtDebugCode);


        // converge all data into a string that can be parsed out when dynamically building out the rows

        if (blnFlag == "false"){
            strPenalty = "Team;Period;Number;Penalty;Minutes;Time";
            blnFlag = "true";
        }
        else {

            strPenalty = HomeVisitor.getSelectedItem().toString() + ";" + Period.getSelectedItem().toString() + ";" + PlayerNumber.getText().toString() + ";" +
                    Penalty.getSelectedItem().toString() + ";" + PenaltyMinutes.getText().toString() + ";" + PenaltyTime.getText().toString();
        }


        strPenaltyData= strPenaltyData + strPenalty + ";";

        String[] cols = strPenalty.split(";");



        DebugCode.setText(strPenaltyData.toString());


        TableRow tr = new TableRow(this);

        for (int i = 0; i< cols.length; i++){
            TextView tv = new TextView(this);
            tv.setTextSize(14);
            if (i == 0 || i==cols.length){
                tv.setGravity(3);
            }else{
                tv.setGravity(1);
            }
            tv.setText(cols[i]);
            tr.addView(tv);
        }

        tv.addView(tr);
        resetPenaltyValues();

    }
    public void resetPenaltyValues() {
        //Reset the values to default for Team Number, Penalty and Time

        HomeVisitor.setSelection(0);
        Period.setSelection(0);
        PlayerNumber.setText("");
        Penalty.setSelection(0);
        PenaltyTime.setText("");

    }
}
