package com.example.applligent.newnagoriengg;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.List;

public class SplashActivity extends AppCompatActivity {
    ItemDao itemDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        itemDao = MyNagoriApplication.getDatabase().itemDao();
        readCsv();
        startActivity(new Intent(this, ItemListActivity.class));
    }

    public void readCsv() {
        InputStream is = getResources().openRawResource(R.raw.parts);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(is, Charset.forName("UTF-8")));
        String line = "";

        try {
            while ((line = reader.readLine()) != null) {
                // Split the line into different tokens (using the comma as a separator).
                String[] tokens; // Read the data and store it in the WellData POJO.
                tokens = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

                // Read the data and store it in the WellData POJO.
                Item items = new Item();
                items.sNo = Long.parseLong(tokens[0]);
                items.oem = (tokens[1]);
                items.telPartNumber = tokens[2];
                items.engine = (tokens[3]);
                items.application = (tokens[4]);
                items.mrp = Float.parseFloat(tokens[5]);
                items.orientationAlpha = Integer.parseInt(tokens[6]);
                items.orientationBeta = Integer.parseInt(tokens[7]);
                try {
                    items.strPre = (tokens[8]);
                    items.settingPre = (tokens[9]);
                    items.lift = (tokens[10]);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                //TODO items.reman = (tokens[11]);
                itemDao.insert(items);

                Log.d("MainActivity", "Just Created " + items);
            }
        } catch (IOException e1) {
            Log.e("MainActivity", "Error" + line, e1);
            e1.printStackTrace();
        }
        List<Item> list = itemDao.getAll();
        for (int i = 0; i < list.size(); i++) {
            Log.d("abc123", list.get(i).application);
        }
    }
}
