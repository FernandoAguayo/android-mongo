package com.wordpress.michaelkyazze.codeperspective101;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;

import android.app.TimePickerDialog;

import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.wordpress.michaelkyazze.codeperspective101.MongoHQ.SaveAsyncTask;

import java.net.UnknownHostException;
import java.util.Calendar;



public class Calendario extends Activity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener{
    int iYear,iMonth,iDay,iFinalYear,iFinalMonth,iFinalDay,iHour,iMinute,iFinalHour,iFinalMinute;
    TextView txtVwMes,txtVwDia,txtVwAño,txtVwHora,txtVwSome;
    EditText edTxtSome, edTxtName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendario2);
        txtVwMes = (TextView)findViewById(R.id.txtVwMes);
        txtVwDia = (TextView)findViewById(R.id.txtVwDia);
        txtVwAño = (TextView)findViewById(R.id.txtVwAño);
        txtVwHora = (TextView)findViewById(R.id.txtVwHora);
        txtVwSome = (TextView)findViewById(R.id.txtVwSome);
        edTxtName = (EditText)findViewById(R.id.edTxtName);
        edTxtSome=(EditText)findViewById(R.id.edTxtSome);

        Calendar c = Calendar.getInstance();
        iYear = c.get(Calendar.YEAR);
        iMonth = c.get(Calendar.MONTH);
        iDay = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dpdDatSelect = new DatePickerDialog(Calendario.this,Calendario.this, iYear, iMonth, iDay);
        dpdDatSelect.show();
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        iFinalYear = i;
        iFinalMonth = i1 + 1;
        iFinalDay = i2;

        Calendar c = Calendar.getInstance();
        iHour = c.get(Calendar.HOUR_OF_DAY);
        iMinute = c.get(Calendar.MINUTE);

        TimePickerDialog tpDialog = new TimePickerDialog(Calendario.this, Calendario.this, iHour, iMinute,
                android.text.format.DateFormat.is24HourFormat(this));
        tpDialog.show();
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {
        String Array[] = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

        iFinalHour = i;
        iFinalMinute = i1;

        txtVwMes.setText("" + Array[iFinalMonth-1]);
        txtVwDia.setText(""+ iFinalDay);
        txtVwAño.setText(""+ iFinalYear);


        if (iFinalMinute < 10) {
            txtVwHora.setText("" + iFinalHour + ":0" + iFinalMinute);
        } else {
            txtVwHora.setText(""+ iFinalHour + ":" +iFinalMinute);
        }

    }

    public void onClickCita(View v) throws UnknownHostException {
        MyContact contact = new MyContact();
        contact.Mes = txtVwMes.getText().toString();
        contact.Descripcion = edTxtSome.getText().toString();
        contact.Nombre = edTxtName.getText().toString();
        contact.Dia = txtVwDia.getText().toString();
        contact.Ano = txtVwAño.getText().toString();
        contact.Hora= txtVwHora.getText().toString();

        SaveAsyncTask tsk = new SaveAsyncTask();
        tsk.execute(contact);
        Toast.makeText(this, "Cita agregada correctamente", Toast.LENGTH_LONG).show();

        startActivity(new Intent(getApplicationContext(), VerCitas.class));
        finish();



    }
}



