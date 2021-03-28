package com.vinie4apps.horriobusaosd;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import com.appodeal.ads.Appodeal;
import com.facebook.ads.AdSize;
import com.facebook.ads.AudienceNetworkAds;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.vinie4apps.horriobusaosd.fav.Fav;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Classes antes do OnCreate


    ListView listView;
    ListViewAdapter adapter;
    String[] linhas;
    int[] icon;
    ArrayList<Model> arrayList = new ArrayList<Model>();
    Button button;
    private AdView mAdView;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Appodeal.initialize(this, "0b585a9e125098def4a3a6ef1c677188489c96c0a36b26ce", Appodeal.BANNER, true);
        Appodeal.setBannerViewId(R.id.appodealBannerView);
        Appodeal.show(this, Appodeal.BANNER_VIEW);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.statusbar));
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }


        int orientation = this.getResources().getConfiguration().orientation;
        if ( orientation == Configuration.ORIENTATION_PORTRAIT) {
            showStartDialog();
        }






        // Actionbar Configurações

        Toolbar toolbar = findViewById(R.id.toobar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Horário Busão SD");


// Strings de Linhas e icones

        linhas = new String[]{
                "Bairro Boa Vista","Bairro da Glória","Bairro Vila Esperança","Bairro Santo Antônio","Barra", "Bairro Capitão Nestor", "Bairro de Fátima", "CAIC", "Bairro Córrego do Ouro", "Bairro Const. Horta", "Campo Alegre", "Francesa",  "Patrimônio da Serra", "Perobas", "Patrimônio dos Paiva", "Rio Pinho", "João Calixto"
        };
        icon = new int[]{R.mipmap.buslogonovo_round,R.mipmap.buslogonovo_round,R.mipmap.buslogonovo_round,R.mipmap.buslogonovo_round,R.mipmap.buslogonovo_round,R.mipmap.buslogonovo_round,R.mipmap.buslogonovo_round,R.mipmap.buslogonovo_round,R.mipmap.buslogonovo_round,R.mipmap.buslogonovo_round,R.mipmap.buslogonovo_round,R.mipmap.buslogonovo_round,R.mipmap.buslogonovo_round,R.mipmap.buslogonovo_round,R.mipmap.buslogonovo_round,R.mipmap.buslogonovo_round,R.mipmap.buslogonovo_round,};



//Config da ListView

        listView = findViewById(R.id.lv);

        for (int i =0; i<linhas.length; i++){
        Model model = new Model(linhas[i],icon[i]);
        arrayList.add(model);
        }

        adapter = new ListViewAdapter(this, arrayList);

        listView.setAdapter(adapter);

        }

        //MSG do Covid

    private void showStartDialog() {

        new AlertDialog.Builder(this)
                .setTitle("AVISO")
                .setMessage("Por conta das medidas de prevenção causada pelo COVID-19 algumas linhas podem ter horários modificados ou cancelados sem aviso prévio, o App não se responsabiliza pelas alterações ou cancelamento excepcionais de horários de alguma linha. Obrigado pela compreensão !")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create().show();


    }

// Config do Menu e da Searchview


@Override
public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        MenuItem myActionMenuItem = menu.findItem(R.id.searchView);
        SearchView searchView = (SearchView)myActionMenuItem.getActionView();
        searchView.setQueryHint("Pesquise sua Linha Aqui !");
        searchView.setBackgroundColor(Color.parseColor("#ffffff"));


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
@Override
public boolean onQueryTextSubmit(String s) {
        return false;
        }

@Override
public boolean onQueryTextChange(String s) {
        if (TextUtils.isEmpty(s)){
        adapter.filter("");
        listView.clearTextFilter();
        }
        else {
        adapter.filter(s);
        }
        return true;
        }
        });
        return true;
        }

// Config do botão Menu (Sobre App)

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id ==R.id.fav){
            Intent intent = new Intent(this, Fav.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

        }
