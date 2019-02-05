package com.hernanfiuba.petagram;

import android.content.res.Resources;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.util.Log;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    SwipeRefreshLayout sriPlanets;
    ListView lvPlanets;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        agregarFAB();

        sriPlanets = (SwipeRefreshLayout) findViewById(R.id.sriSwipe);
        lvPlanets = (ListView) findViewById(R.id.lvList);

        refreshPlanets();
        
        sriPlanets.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshPlanets();
                sriPlanets.setRefreshing(false);
            }
        });
    }

    public void refreshPlanets() {
        String [] planets = getResources().getStringArray(R.array.planets);
        lvPlanets.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, planets));
    }

    public void agregarFAB() {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabStar);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, getResources().getString(R.string.message), Snackbar.LENGTH_LONG).setAction(
                        getResources().getString(R.string.textAccion), new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Log.i("SNACKBAR", "click on snackbar");
                            }
                        }
                ).setActionTextColor(getResources().getColor(R.color.colorPrimary)).show();
            }
        });
    }
}
