package com.vinie4apps.horriobusaosd.fav;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import com.appodeal.ads.Appodeal;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.vinie4apps.horriobusaosd.Linhas.Bairro_Boa_Vista;
import com.vinie4apps.horriobusaosd.Linhas.Bairro_Capitão_Nestor;
import com.vinie4apps.horriobusaosd.Linhas.Bairro_Const_Horta;
import com.vinie4apps.horriobusaosd.Linhas.Bairro_Córrego_do_Ouro;
import com.vinie4apps.horriobusaosd.Linhas.Bairro_Santo_Antônio;
import com.vinie4apps.horriobusaosd.Linhas.Bairro_Vila_Esperança;
import com.vinie4apps.horriobusaosd.Linhas.Bairro_da_Glória;
import com.vinie4apps.horriobusaosd.Linhas.Bairro_de_Fátima;
import com.vinie4apps.horriobusaosd.Linhas.Barra;
import com.vinie4apps.horriobusaosd.Linhas.CAIC;
import com.vinie4apps.horriobusaosd.Linhas.Campo_Alegre;
import com.vinie4apps.horriobusaosd.Linhas.Francesa;
import com.vinie4apps.horriobusaosd.Linhas.João_Calixto;
import com.vinie4apps.horriobusaosd.Linhas.Patrimônio_da_Serra;
import com.vinie4apps.horriobusaosd.Linhas.Patrimônio_dos_Paiva;
import com.vinie4apps.horriobusaosd.Linhas.Perobas;
import com.vinie4apps.horriobusaosd.Linhas.Rio_Pinho;
import com.vinie4apps.horriobusaosd.R;


import java.lang.reflect.Type;
import java.util.ArrayList;

public class Fav extends AppCompatActivity {

    ListView listView;



    public static ArrayList<String> arrayList_fav = new ArrayList<>();
    public static ArrayAdapter arrayAdapter;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav);

        Appodeal.initialize(this, "0b585a9e125098def4a3a6ef1c677188489c96c0a36b26ce", Appodeal.BANNER, true);
        Appodeal.setBannerViewId(R.id.appodealBannerView);
        Appodeal.show(this, Appodeal.BANNER_VIEW);

        loadData();




        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }


        // Actionbar Configurações

        Toolbar toolbar = findViewById(R.id.toobarfv);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Favoritos");


        //Config da ListView

        listView = findViewById(R.id.lv_fav);


        arrayAdapter = new ArrayAdapter(this, android.R.layout.select_dialog_item, arrayList_fav);

        listView.setAdapter(arrayAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String intem = (String) listView.getItemAtPosition(position);
                if (intem.equals("Bairro Boa Vista")) {
                    Intent i = new Intent(Fav.this, Bairro_Boa_Vista.class);
                    startActivity(i);
                    finish();

                }
                if (intem.equals("Bairro da Glória")) {
                    Intent intent = new Intent(Fav.this, Bairro_da_Glória.class);
                    Fav.this.startActivity(intent);
                    finish();
                    finish();
                }
                if (intem.equals("Bairro Vila Esperança")) {
                    Intent intent = new Intent(Fav.this, Bairro_Vila_Esperança.class);
                    Fav.this.startActivity(intent);
                    finish();
                }
                if (intem.equals("Bairro Santo Antônio")) {
                    Intent intent = new Intent(Fav.this, Bairro_Santo_Antônio.class);
                    Fav.this.startActivity(intent);
                    finish();
                }
                if (intem.equals("Barra")) {
                    Intent intent = new Intent(Fav.this, Barra.class);
                    Fav.this.startActivity(intent);
                    finish();
                }
                if (intem.equals("Bairro Capitão Nestor")) {
                    Intent intent = new Intent(Fav.this, Bairro_Capitão_Nestor.class);
                    Fav.this.startActivity(intent);
                    finish();
                }
                if (intem.equals("Bairro de Fátima")) {
                    Intent intent = new Intent(Fav.this, Bairro_de_Fátima.class);
                    Fav.this.startActivity(intent);
                    finish();
                }
                if (intem.equals("CAIC")) {
                    Intent intent = new Intent(Fav.this, CAIC.class);
                    Fav.this.startActivity(intent);
                    finish();
                }
                if (intem.equals("Bairro Córrego do Ouro")) {
                    Intent intent = new Intent(Fav.this, Bairro_Córrego_do_Ouro.class);
                    Fav.this.startActivity(intent);
                    finish();
                }
                if (intem.equals("Bairro Const. Horta")) {
                    Intent intent = new Intent(Fav.this, Bairro_Const_Horta.class);
                    Fav.this.startActivity(intent);
                    finish();
                }
                if (intem.equals("Campo Alegre")) {
                    Intent intent = new Intent(Fav.this, Campo_Alegre.class);
                    Fav.this.startActivity(intent);
                    finish();
                }
                if (intem.equals("Francesa")) {
                    Intent intent = new Intent(Fav.this, Francesa.class);
                    Fav.this.startActivity(intent);
                    finish();
                }
                if (intem.equals("Patrimônio da Serra")) {
                    Intent intent = new Intent(Fav.this, Patrimônio_da_Serra.class);
                    Fav.this.startActivity(intent);
                    finish();
                }

                if (intem.equals("Perobas")) {
                    Intent intent = new Intent(Fav.this, Perobas.class);
                    Fav.this.startActivity(intent);
                    finish();
                }
                if (intem.equals("Patrimônio dos Paiva")) {
                    Intent intent = new Intent(Fav.this, Patrimônio_dos_Paiva.class);
                    Fav.this.startActivity(intent);
                    finish();
                }
                if (intem.equals("Rio Pinho")) {
                    Intent intent = new Intent(Fav.this, Rio_Pinho.class);
                    Fav.this.startActivity(intent);
                    finish();
                }
                if (intem.equals("João Calixto")) {
                    Intent intent = new Intent(Fav.this, João_Calixto.class);
                    Fav.this.startActivity(intent);
                    finish();

                }
            }
        });

    }

    private void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(arrayList_fav);
        editor.putString("task list", json);
        editor.apply();
    }


    private void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("task list", null);
        Type type = new TypeToken<ArrayList<String>>() {
        }.getType();
        arrayList_fav = gson.fromJson(json, type);
        if (arrayList_fav == null) {
            arrayList_fav = new ArrayList<>();
        }
    }
    @Override
    public void onContentChanged() {
        super.onContentChanged();

        View empty = findViewById(R.id.favbaneer);
        ListView list = (ListView) findViewById(R.id.lv_fav);
        list.setEmptyView(empty);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_fav, menu);

        MenuItem myActionMenuItem = menu.findItem(R.id.searchView_fav);
        SearchView searchView = (SearchView)myActionMenuItem.getActionView();
        searchView.setQueryHint(Html.fromHtml("<font color = #000000>" + getResources().getString(R.string.hintSearchMess) + "</font>"));
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {

                arrayAdapter.getFilter().filter(s);
                TextView tx = (TextView) findViewById(R.id.textfav);
                tx.setText("Nenhuma Linha Encontada :(\n Verifique se foi adicionada nos favoritos corretamente :)");



                return true;

            }
        });
        return true;
    }


}
