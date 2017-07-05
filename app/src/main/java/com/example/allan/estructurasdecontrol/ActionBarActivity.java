package com.example.allan.estructurasdecontrol;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class ActionBarActivity extends AppCompatActivity {

    private Menu menu;
    private Toolbar actual;
    private CardView actualc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        this.actual = toolbar;
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Button btnAplicar = (Button) findViewById(R.id.BtnAplicar);
        btnAplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup rgOpciones = (RadioGroup) findViewById(R.id.RgToolbars);
                int checkedId =rgOpciones.getCheckedRadioButtonId();
                actual.setVisibility(View.GONE);
                TabLayout tabs = (TabLayout)findViewById(R.id.appbartabs);
                ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
                tabs.setVisibility(View.GONE);
                viewPager.setVisibility(View.GONE);
                boolean estado = false;
                Toolbar toolbar = null;
                switch(checkedId) {
                    case R.id.RbToolbar1:
                        toolbar = (Toolbar) findViewById(R.id.toolbar);
                        toolbar.setTitle("Toolbar");
                        estado= true;
                        break;
                    case R.id.RbToolbar2:
                        toolbar = (Toolbar) findViewById(R.id.toolbar2);
                        setTitle("");
                        estado= false;
                        break;
                    case R.id.RbToolbar3:
                        toolbar = (Toolbar) findViewById(R.id.appbar);
                        setTitle("");
                        tabs.setVisibility(View.VISIBLE);
                        viewPager.setVisibility(View.VISIBLE);
                        estado= false;
                        break;
                    default:
                        toolbar = (Toolbar) findViewById(R.id.toolbar);
                        toolbar.setTitle("Toolbar");
                        estado= true;
                        break;
                }
                toolbar.setVisibility(View.VISIBLE);
                setSupportActionBar(toolbar);
                onCreateOptionsMenu(getMenu());
                getSupportActionBar().setDisplayHomeAsUpEnabled(estado);
                actual =toolbar;
            }
        });
        Toolbar tbCard = null;
        tbCard = (Toolbar) findViewById(R.id.TbCard);
        tbCard.inflateMenu(R.menu.menu_tarjeta);
        tbCard = (Toolbar) findViewById(R.id.TbCard2);
        tbCard.inflateMenu(R.menu.menu_tarjeta);
        tbCard = (Toolbar) findViewById(R.id.TbCard3);
        tbCard.inflateMenu(R.menu.menu_tarjeta);

        actualc = (CardView) findViewById(R.id.card_view);

        //Appbar page filter
        Spinner cmbToolbar = (Spinner) findViewById(R.id.CmbToolbar);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                getSupportActionBar().getThemedContext(),
                R.layout.appbar_filter_title,
                new String[]{"Opción 1 ", "Opción 2 ", "Opción 3 "});

        adapter.setDropDownViewResource(R.layout.appbar_filter_list);

        cmbToolbar.setAdapter(adapter);

        cmbToolbar.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //... Acciones al seleccionar una opción de la lista
                Log.i("Toolbar 3", "Seleccionada opción " + i);
                actualc.setVisibility(View.GONE);
                CardView card= null;
                switch(i) {
                    case 0:
                        card = (CardView) findViewById(R.id.card_view);
                        card.setVisibility(View.VISIBLE);
                        break;
                    case 1:
                        card = (CardView) findViewById(R.id.card_view2);
                        card.setVisibility(View.VISIBLE);
                        break;
                    case 2:
                        card = (CardView) findViewById(R.id.card_view3);
                        card.setVisibility(View.VISIBLE);
                        break;
                }
                actualc= card;

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                //... Acciones al no existir ningún elemento seleccionado
            }
        });

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new MiFragmentPagerAdapter(
                getSupportFragmentManager()));

        TabLayout tabLayout = (TabLayout) findViewById(R.id.appbartabs);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.setupWithViewPager(viewPager);
    }

    public Menu getMenu(){
        return this.menu;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        this.menu = menu;
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_nuevo:
                Log.i("ActionBar", "Nuevo!");
                return true;
            case R.id.action_buscar:
                Log.i("ActionBar", "Buscar!");;
                return true;
            case R.id.action_settings:
                Log.i("ActionBar", "Settings!");;
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
