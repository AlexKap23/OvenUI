package com.example.alex.ovenui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AutoActivity extends AppCompatActivity {
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader = new ArrayList<String>();
    HashMap<String, List<String>> listDataChild = new HashMap<String, List<String>>();

    FoodParameters f = new FoodParameters("Λουκάνικα",150,30,"Αέρας");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto);


        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);
        final Button add = (Button) findViewById(R.id.addId);
        add.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //listDataHeader.add();
            }
        });
    }

    private void prepareListData() {
       // listDataHeader = new ArrayList<String>();
        //listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Διαθέσιμες Συνταγές");

        // Adding child data
        List<String> avaliable = new ArrayList<String>();
        avaliable.add(f.getName());
        avaliable.add("Γεμιστά");
        avaliable.add("Μπιφτέκια");




        listDataChild.put(listDataHeader.get(0), avaliable); // Header, Child data
    }
}
