package com.wordpress.michaelkyazze.codeperspective101;

import android.os.AsyncTask;
import android.widget.Toast;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.wordpress.michaelkyazze.codeperspective101.MongoHQ.QueryBuilder;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by ferna on 11/30/2016.
 */
public class GetContactsAsyncTask extends AsyncTask<MyContact, Void, ArrayList<MyContact>> {
    static BasicDBObject user = null;
    static String OriginalObject = "";
    static String server_output = null;
    static String temp_output = null;

    @Override
    protected ArrayList<MyContact> doInBackground(MyContact... arg0) {

        ArrayList<MyContact> mycontacts = new ArrayList<MyContact>();
        try
        {

            QueryBuilder qb = new QueryBuilder();
            URL url = new URL(qb.buildContactsGetURL());
            HttpURLConnection conn = (HttpURLConnection) url
                    .openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            InputStream json = conn.getInputStream();
            InputStreamReader isjson = new InputStreamReader(json);

            BufferedReader br = new BufferedReader(isjson);


            while ((temp_output = br.readLine()) != null) {


                server_output = temp_output;
            }



            // create a basic db list
            String mongoarray = "{ artificial_basicdb_list: "+server_output+"}";
            Object o = com.mongodb.util.JSON.parse(mongoarray);

            DBObject dbObj = (DBObject) o;

            BasicDBList contacts = (BasicDBList) dbObj.get("artificial_basicdb_list");

            System.out.println(""+ contacts);
            System.out.println(""+ contacts);
            System.out.println(""+ contacts);
            System.out.println(""+ contacts);
            System.out.println(""+ contacts);
            System.out.println(""+ contacts);
            System.out.println(""+ contacts);




            for (Object obj : contacts) {
                DBObject userObj = (DBObject) obj;

                MyContact temp = new MyContact();
                temp.setDoc_id(userObj.get("_id").toString());
                temp.setMes(userObj.get("Mes").toString());
                temp.setDia(userObj.get("Dia").toString());
                temp.setAno(userObj.get("Ano").toString());
                temp.setHora(userObj.get("Hora").toString());
                temp.setDescripcion(userObj.get("Descripcion").toString());
                temp.setNombre(userObj.get("Nombre").toString());

                mycontacts.add(temp);


            }


        }catch (Exception e) {
            e.getMessage();
        }

        return mycontacts;
    }


}

