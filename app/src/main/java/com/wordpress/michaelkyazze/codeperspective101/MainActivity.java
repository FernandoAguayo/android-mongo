package com.wordpress.michaelkyazze.codeperspective101;

import java.net.UnknownHostException;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.wordpress.michaelkyazze.codeperspective101.MongoHQ.SaveAsyncTask;

public class MainActivity extends Activity {
	EditText EdtxtMes, EdtxtDia, EdtxtDes, EdtxtNom;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		EdtxtMes = (EditText) findViewById(R.id.EdtxtMes);
		EdtxtDia = (EditText) findViewById(R.id.EdtxtDia);
		EdtxtDes = (EditText) findViewById(R.id.EdtxtDes);
		EdtxtNom = (EditText) findViewById(R.id.EdtxtNom);


	}

	public void saveContact(View v) throws UnknownHostException {

		MyContact contact = new MyContact();
		contact.Mes = EdtxtMes.getText().toString();
		contact.Descripcion = EdtxtDes.getText().toString();
		contact.Nombre = EdtxtNom.getText().toString();
		contact.Dia = EdtxtDia.getText().toString();

		SaveAsyncTask tsk = new SaveAsyncTask();
		tsk.execute(contact);


		Toast.makeText(this, "Cita agregada correctamente", Toast.LENGTH_LONG).show();
	}

}
