package com.example.movers_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MoversList extends AppCompatActivity {

    //call the list view
    private ListView mListView;
    //working with hardcoded list
    private String[] movers = new String[] {"Mover1", "Mover2",
            "Mover3", "Mover4", "Mover5", "Mover6",
            "Mover7", "Mover8", "Mover9", "Mover10",
            "Mover11", "Mover12", "Mover13",
            "Mover14", "Mover15"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movers_list);

        mListView = (ListView) findViewById(R.id.listView);

        //adapter to display the list
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, movers);
        mListView.setAdapter(adapter);

        //show list on layout view
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //display call on the hardcoded list
                String restaurant = ((TextView)view).getText().toString();
                Toast.makeText(MoversList.this, restaurant, Toast.LENGTH_LONG).show();
            }
        });
    }
}