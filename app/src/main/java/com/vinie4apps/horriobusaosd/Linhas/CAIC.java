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
import com.facebook.ads.AdSize;
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

public class CAIC extends AppCompatActivity {
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
        getSupportActionBar().setTitle("CAIC");
        toolbar.setBackgroundColor(Color.parseColor("#FFAB00"));
        toolbar.setTitleTextColor(Color.parseColor("#FFFFFF"));

        models = new ArrayList<>();
        models.add(new Horarios_Model("Saída Bairro","07:35 \t08:55 \t10:15 \t11:35 \t12:55 \t14:15 \t15:35 \t16:55 \t18:15 \t19:35\n","Saída Centro","07:05 \t08:35 \t09:55 \t11:15 \t12:35 \t13:55 \t15:15 \t16:35 \t17:55 \t19:15\n"));

        models.add(new Horarios_Model("Saída Bairro","07:35 \t08:55 \t10:15 \t11:35 \t12:55\n","Saída Centro","07:05 \t08:35 \t09:55 \t11:15 \t12:35\n"));

        models.add(new Horarios_Model("Saída Bairro","07:35 \t08:55 \t10:15 \t11:35 \t12:55\n","Saída Centro","07:05 \t08:35 \t09:55 \t11:15 \t12:35\n"));

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

        favNO.setVisible(prefs.getBoolean("c1",true));
        favSI.setVisible(prefs.getBoolean("c2",false));

        favNO.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                prefs.edit().putBoolean("c1", false).apply();
                prefs.edit().putBoolean("c2", true).apply();
                favNO.setVisible(false);
                favSI.setVisible(true);
                arrayList_fav.add("CAIC");
                saveData();
                Toast.makeText(CAIC.this, "CAIC adiconado aos favoritos !", Toast.LENGTH_LONG).show();

                return true;
            }
        });

        favSI.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                prefs.edit().putBoolean("c1", true).apply();
                prefs.edit().putBoolean("c2", false).apply();
                favNO.setVisible(true);
                favSI.setVisible(false);
                arrayList_fav.remove("CAIC");
                saveData();
                Toast.makeText(CAIC.this, "CAIC removido dos favoritos !", Toast.LENGTH_LONG).show();
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