package com.example.jsonbrani;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final String JSON_FILE="brani.json";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Brano[] brani = readJson();
        ArrayList<String> titoli = new ArrayList<String>();
        for (int i = 0; i< brani.length;i++){
            titoli.add(brani[i].getTitolo());

        }
        ListView lv = (ListView) findViewById(R.id.lv1);
        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, titoli);
        // Set The Adapter
        lv.setAdapter(arrayAdapter);

    }

    public Brano[] readJson(){
        String json = null;
        Brano[] brani=null;
        try {
            InputStream is = getAssets().open(JSON_FILE);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
            JSONArray jsonArray = new JSONObject(json).getJSONArray("brani");
            brani = new Brano[jsonArray.length()];
            int index = 0;
            for (int x=0; x< jsonArray.length(); x++) {
                Brano brano = new Brano();
                JSONObject rec = jsonArray.getJSONObject(x);
                brano.setGenere(rec.getString("genere"));
                brano.setTitolo(rec.getString("titolo"));
                brano.setAutore(rec.getString("autore"));
                brano.setDurata(rec.getString("durata"));

                brani[index++] = brano;
            }

        } catch (IOException ex) {
            ex.printStackTrace();
            Toast.makeText(getApplicationContext(),(String)ex.toString(),
                    Toast.LENGTH_SHORT).show();
            return null;
        } catch (Exception ex) {
            ex.printStackTrace();
            Toast.makeText(getApplicationContext(),(String)ex.toString() + ex.getLocalizedMessage(),
                    Toast.LENGTH_SHORT).show();
            return null;
        }
        return brani;
    }
}