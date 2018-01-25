package com.example.perside.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.perside.login.vod.CartoonEn;
import com.example.perside.login.vod.CartoonFr;
import com.example.perside.login.vod.Concerts;
import com.example.perside.login.vod.Documentaire;
import com.example.perside.login.vod.EnglishDocumentary;
import com.example.perside.login.vod.EnglishMovies;
import com.example.perside.login.vod.EnglishSeries;
import com.example.perside.login.vod.FrenchMovies;
import com.example.perside.login.vod.FrenchSeries;
import com.example.perside.login.vod.Music;
import com.example.perside.login.vod.Tvreplay;

/**
 * Created by perside on 11/6/17.
 */

public class Vod extends AppCompatActivity {

    String[] mobileArray = {"French Movies","French Series","Cartoon Fr", "Music", "Documentaires", "English Movies",
                            "English Series", "English Documentory", "Concerts", "Cartoon Eng", "TV Replay"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vod);

        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.activity_listview, mobileArray);

        ListView listView = (ListView) findViewById(R.id.mobile_list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {//adding onclick event to the menu
            @Override
            public void onItemClick(AdapterView<?> listView, View view, int position, long id) {
                String vodmenu = (String) listView.getAdapter().getItem(position);

                switch(vodmenu) {
                    case "English Movies":
                        Intent intent = new Intent(Vod.this, EnglishMovies.class);
                        intent.putExtra("Listvod1", vodmenu);
                        startActivity(intent);
                        break;
                    case "French Series":
                        Intent intent1 = new Intent(Vod.this, FrenchSeries.class);
                        intent1.putExtra("Listvod2", vodmenu);
                        startActivity(intent1);
                        break;
                    case "Cartoon Fr":
                        Intent intent2 = new Intent(Vod.this, CartoonFr.class);
                        intent2.putExtra("Listvod3", vodmenu);
                        startActivity(intent2);
                        break;
                    case "French Movies":
                        Intent intent3 = new Intent(Vod.this, FrenchMovies.class);
                        intent3.putExtra("Listvod4", vodmenu);
                        startActivity(intent3);
                        break;
                    case "Music":
                        Intent intent4 = new Intent(Vod.this, Music.class);
                        intent4.putExtra("Listvod5", vodmenu);
                        startActivity(intent4);
                        break;
                    case "Documentaires":
                        Intent intent5 = new Intent(Vod.this, Documentaire.class);
                        intent5.putExtra("Listvod6", vodmenu);
                        startActivity(intent5);
                        break;
                    case "English Series":
                        Intent intent6 = new Intent(Vod.this, EnglishSeries.class);
                        intent6.putExtra("Listvod7", vodmenu);
                        startActivity(intent6);
                        break;
                    case "English Documentory":
                        Intent intent7 = new Intent(Vod.this, EnglishDocumentary.class);
                        intent7.putExtra("Listvod8", vodmenu);
                        startActivity(intent7);
                        break;
                    case "Concerts":
                        Intent intent8 = new Intent(Vod.this, Concerts.class);
                        intent8.putExtra("Listvod9", vodmenu);
                        startActivity(intent8);
                        break;
                    case "Cartoon Eng":
                        Intent intent9 = new Intent(Vod.this, CartoonEn.class);
                        intent9.putExtra("Listvod0", vodmenu);
                        startActivity(intent9);
                    case "TV Replay":
                        Intent intent0 = new Intent(Vod.this, Tvreplay.class);
                        intent0.putExtra("Listvod01", vodmenu);
                        startActivity(intent0);
                        break;
                }
            }
        });

    }
}
