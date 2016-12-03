package com.wordpress.michaelkyazze.codeperspective101;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class VerCitas extends ListActivity {
    ArrayList<MyContact> returnValues = new ArrayList<MyContact>();
    ArrayList<String> listItems = new ArrayList<String>();
    String _id;
    String Mes;
    String Dia;
    String Ano;
    String Hora;
    String Descripcion;
    String Nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_citas);

        GetContactsAsyncTask task = new GetContactsAsyncTask();
        try {
            returnValues = task.execute().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        //variable = fecha hoy
        //vector[] = variable.split(-)
        //vector = [mes, Dia, año, hora]
        for(MyContact x: returnValues) {
            //if (vector [1] = x.getdia){
//vector1 [] = push.xdia
            listItems.add(x.getMes() + " - "+ x.getDia() + " - " + x.getHora());
            //}

        }
        //vetor.ordenar de mayor a menor
        //listitems.add(vetor1)
        //System.out.println(""+ listItems);

        setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, listItems));


    }
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        String selectedValue = (String) getListAdapter().getItem(position);
        Toast.makeText(this, selectedValue, Toast.LENGTH_SHORT).show();
        selectedContact(selectedValue);

        Bundle dataBundle = new Bundle();
        dataBundle.putString("_id", _id);
        dataBundle.putString("Mes", Mes);
        dataBundle.putString("Dia", Dia);
        dataBundle.putString("Ano", Ano);
        dataBundle.putString("Hora", Hora);
        dataBundle.putString("Des", Descripcion);
        dataBundle.putString("Nombre", Nombre);
        Intent DetailsIntent = new Intent(this,Details.class);
        DetailsIntent.putExtras(dataBundle);
        startActivity(DetailsIntent);
    }

    /*
     * Retrieves the full details of a selected contact.
     * The details are then passed onto the Update Contacts Record.
     *
     * This is a quick way for demo purposes.
     * You should consider storing this data in a database, shared preferences or text file
     */
    public void selectedContact(String selectedValue){
        for(MyContact x: returnValues){
            if(selectedValue.contains(x.getHora())){
                _id = x.getDoc_id();
                Mes = x.getMes();
                Dia = x.getDia();
                Ano = x.getAno();
                Hora = x.getHora();
                Descripcion = x.getDescripcion();
                Nombre = x.getNombre();
            }
        }

    }


    public void onClickregrear (View v){
        startActivity(new Intent(getApplicationContext(), NDMain.class));
        finish();
    }

    }


