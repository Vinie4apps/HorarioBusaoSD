package com.vinie4apps.horriobusaosd.Linhas;

import android.animation.ArgbEvaluator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.appodeal.ads.Appodeal;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;
import com.vinie4apps.horriobusaosd.R;
import com.vinie4apps.horriobusaosd.item.Horarios_Adapter;
import com.vinie4apps.horriobusaosd.item.Horarios_Model;

import java.util.ArrayList;
import java.util.List;

import static com.vinie4apps.horriobusaosd.fav.Fav.arrayList_fav;

public class Bairro_Const_Horta extends AppCompatActivity {
    ViewPager viewPager;
    Horarios_Adapter adapter;
    List<Horarios_Model> models;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();
    private BottomSheetBehavior bottomSheetBehavior;
    private TextView mTextViewS;
    private AdView mAdView;
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.horarios);

        Appodeal.initialize(this, "0b585a9e125098def4a3a6ef1c677188489c96c0a36b26ce", Appodeal.BANNER, true);
        Appodeal.setBannerViewId(R.id.appodealBannerView);
        Appodeal.show(this, Appodeal.BANNER_VIEW);

        final Toolbar toolbar = findViewById(R.id.toobar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Bairro Const. Horta");
        toolbar.setBackgroundColor(Color.parseColor("#FFAB00"));
        toolbar.setTitleTextColor(Color.parseColor("#FFFFFF"));

        models = new ArrayList<>();
        models.add(new Horarios_Model("Saída Bairro","06:15 \t06:45 \t07:15 \t07:45 \t08:15 \t08:45 \t09:15 \t09:45 \t10:15 \t10:45 (ter/qui) \t11:15 \t11:45 \t" +
                "12:15 \t12:45 \t13:15 \t13:45 \t14:15 \t14:45 \t15:15 \t15:45 \t16:15 \t16:45 \t17:15 \t17:45 \t" +
                "18:15 \t18:45 \t19:15 \t19:45 \t20:15 \t20:45 \t21:45 \t22:45 \t23:10","Saída Centro","06:00 \t06:30 \t07:00 \t07:30 \t08:00 \t08:30 \t09:00 \t09:30 \t10:00 \t10:30 (ter/qui) \t11:00 \t11:30 \t" +
                "12:00 \t12:30 \t13:00 \t13:30 \t14:00 \t14:30 \t15:00 \t15:30 \t16:00 \t16:30 \t17:00 \t17:30 \t" +
                "18:00 \t18:30 \t19:00 \t19:30 \t20:00 \t20:30 \t21:00 \t22:00 \t23:00  "));

        models.add(new Horarios_Model("Saída Bairro","06:15 \t06:45 \t07:15 \t07:45 \t08:15 \t08:45 \t09:15 \t09:45 \t10:15 \t10:45 \t11:15 \t11:45 \t" +
                "12:15 \t12:45 \t13:15 \t13:45 \t14:15 \t14:45 \t15:45 \t16:45 \t17:45 \t" +
                "18:45 \t19:45 \t20:45 \t21:45 \t22:45 \t23:10","Saída Centro","06:00 \t06:30 \t07:00 \t07:30 \t08:00 \t08:30 \t09:00 \t09:30 \t10:00 \t10:30 \t11:00 \t11:30 \t" +
                "12:00 \t12:30 \t13:00 \t13:30 \t14:00 \t14:30 \t15:00 \t16:00 \t17:00 \t" +
                "18:00 \t19:00 \t20:00 \t21:00 \t22:00 \t23:00"));

        models.add(new Horarios_Model("Saída Bairro","06:15 \t06:45 \t07:15 \t07:45 \t08:15 \t08:45 \t09:15 \t09:45 \t10:15 \t10:45 \t11:15 \t11:45 \t" +
                "12:15 \t12:45 \t13:15 \t13:45 \t14:15 \t14:45 \t15:45 \t16:45 \t17:45 \t" +
                "18:45 \t19:45 \t20:45 \t21:45 \t22:45 \t23:10","Saída Centro","06:00 \t06:30 \t07:00 \t07:30 \t08:00 \t08:30 \t09:00 \t09:30 \t10:00 \t10:30 \t11:00 \t11:30 \t" +
                "12:00 \t12:30 \t13:00 \t13:30 \t14:00 \t14:30 \t15:00 \t16:00 \t17:00 \t" +
                "18:00 \t19:00 \t20:00 \t21:00 \t22:00 \t23:00"));

        adapter = (Horarios_Adapter) new Horarios_Adapter(models, this);

        viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter((PagerAdapter) adapter);
        viewPager.setPadding(5, 0, 5, 0);

        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);




        //copiar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.arrowleft);
        tabs.setBackgroundColor(Color.parseColor("#FFAB00"));
        tabs.setSelectedTabIndicatorColor(Color.parseColor("#FFFFFF"));
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));
        }


        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        final SharedPreferences prefs = getSharedPreferences("sharedPreferences", Context.MODE_PRIVATE);
        final MenuItem favNO = menu.findItem(R.id.favNO);
        final MenuItem favSI = menu.findItem(R.id.favSI);

        favNO.setVisible(prefs.getBoolean("ch1",true));
        favSI.setVisible(prefs.getBoolean("ch2",false));

        favNO.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                prefs.edit().putBoolean("ch1", false).apply();
                prefs.edit().putBoolean("ch2", true).apply();
                favNO.setVisible(false);
                favSI.setVisible(true);
                arrayList_fav.add("Bairro Const. Horta");
                saveData();
                Toast.makeText(Bairro_Const_Horta.this, "Bairro Const. Horta adiconado aos favoritos !", Toast.LENGTH_LONG).show();

                return true;
            }
        });

        favSI.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                prefs.edit().putBoolean("ch1", true).apply();
                prefs.edit().putBoolean("ch2", false).apply();
                favNO.setVisible(true);
                favSI.setVisible(false);
                arrayList_fav.remove("Bairro Const. Horta");
                saveData();
                Toast.makeText(Bairro_Const_Horta.this, "Bairro Const. Horta removido dos favoritos !", Toast.LENGTH_LONG).show();
                return true;
            }
        });


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

        }

        return super.onOptionsItemSelected(item);

    }

    private void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(arrayList_fav);
        editor.putString("task list", json);
        editor.apply();
    }

}