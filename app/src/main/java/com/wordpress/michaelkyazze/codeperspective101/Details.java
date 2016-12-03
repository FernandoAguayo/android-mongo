package com.wordpress.michaelkyazze.codeperspective101;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.widget.TextView;

public class Details extends Activity {
    TextView txtVwMes,txtVwDia,txtVwAño,txtVwHora,txtVwSome, edTxtSome, edTxtName;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        txtVwMes = (TextView)findViewById(R.id.txtVwMes);
        txtVwDia = (TextView)findViewById(R.id.txtVwDia);
        txtVwAño = (TextView)findViewById(R.id.txtVwAño);
        txtVwHora = (TextView)findViewById(R.id.txtVwHora);
        txtVwSome = (TextView)findViewById(R.id.txtVwSome);
        edTxtName = (TextView)findViewById(R.id.edTxtName);
        edTxtSome=(TextView)findViewById(R.id.edTxtSome);




    }

}
