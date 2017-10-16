package com.example.alex.ovenui;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;




public class SettingsActivity extends AppCompatActivity {
    private  int temp = 60;
    private int time = 5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);


        //temperature control
        final Button up = (Button) findViewById(R.id.Up);
        final Button down = (Button) findViewById(R.id.Down);
        final EditText tempTxt = (EditText)findViewById(R.id.tempScreen);

        final Button upTm = (Button) findViewById(R.id.UpTm);
        final Button downTm = (Button) findViewById(R.id.DownTm);
        final EditText timeText = (EditText)findViewById(R.id.timeScreen);

        final Button ok = (Button) findViewById(R.id.okId);
        final RadioGroup rg = (RadioGroup) findViewById(R.id.WayId);

        tempTxt.setText(String.valueOf(temp));
        ok.setEnabled(false);
        //+ temperature button listener
        up.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                down.setEnabled(true);
                temp=plusTemp(temp);
                tempTxt.setText(String.valueOf(temp));
                if(temp>=300){
                    up.setEnabled(false);
                }
            }
        });


        //- temperature button listener
        down.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                up.setEnabled(true);
                temp=minusTemp(temp);
                tempTxt.setText(String.valueOf(temp));
                if(temp<=50){

                    down.setEnabled(false);

                }
            }
        });

        //+ time button listener
        upTm.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                downTm.setEnabled(true);
                ok.setEnabled(true);
                time=plusTime(time);
                timeText.setText(String.valueOf(time));
            }
        });
        //- time button listener
        downTm.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                time=minusTime(time);
                timeText.setText(String.valueOf(time));
                if(time<=0){
                    downTm.setEnabled(false);
                    ok.setEnabled(false);
                }
            }
        });

        tempTxt.setEnabled(false);
        timeText.setEnabled(false);

        //alert for ok button to inform the user that he set the parameters and the oven is working

        ok.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                RadioButton b1 = (RadioButton) findViewById(R.id.radioButton1) ;
                RadioButton b2 = (RadioButton) findViewById(R.id.radioButton2) ;
                RadioButton b3 = (RadioButton) findViewById(R.id.radioButton3) ;
                RadioButton b4 = (RadioButton) findViewById(R.id.radioButton4) ;

                RadioButton rb = null;
                if(b1.isChecked() ){
                    rb = b1;
                }else if(b2.isChecked()){
                    rb = b2;
                }else if(b3.isChecked()){
                    rb=b3;

                }else if(b4.isChecked()){
                    rb = b4;
                }
                if(rb!=null){
                    showMyAlertDialog(tempTxt,timeText,rb);
                }
                }

        });



    }

    //helping method so we can pop an alert every time ok button is clicked
    private void showMyAlertDialog(EditText temp,EditText tm,RadioButton rb) {

        new AlertDialog.Builder(this)
                .setTitle("")
                .setMessage("Ο φούρνος ξεκίνησε και λειτουργεί σε θερμοκρασία "+ temp.getText()+" βαθμούς C" + " και χρειάζεται ακόμα  "+tm.getText()+ " λεπτά"
                +" με "+ rb.getText() )
                .setPositiveButton("Κλείσιμο", null)
                .create().show();
    }



    /* plus and minus methods are used to make the + and
        - buttons to actually function
    */
    private int plusTemp(int i){
        i+=10;
        return i;
    }

    private int plusTime(int i){
        i+=5;
        return i;
    }

    private int minusTemp(int i ){
        i-=10;
        return i;
    }

    private int minusTime(int i){
        i-=5;
        return i;
    }

}
