package app.oswaldogh89.marvelhero.Ui.HeroesList;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.gson.Gson;

import java.util.ArrayList;

import app.oswaldogh89.marvelhero.Adapters.HeroItemView;
import app.oswaldogh89.marvelhero.Adapters.HeroesAdapter;
import app.oswaldogh89.marvelhero.Entities.Heroe;
import app.oswaldogh89.marvelhero.R;
import app.oswaldogh89.marvelhero.Ui.HeroeDetail.HeroeDetailActivity;

/**
 * Created by oswaldogh89 on 22/04/18.
 */


public class HeroesListActivity extends AppCompatActivity implements Interface.View, HeroItemView {

    private HeroesPresenter heroesPresenter;
    private RecyclerView rv_heroes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heroes_list);

        heroesPresenter = new HeroesPresenter(this);
        initList();
    }

    private void initList() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rv_heroes = findViewById(R.id.rv_heroes);
        rv_heroes.setLayoutManager(linearLayoutManager);
        heroesPresenter.loadHeroes();
    }

    @Override
    public void createHeroesList(ArrayList<Heroe> heroes) {
        HeroesAdapter adapter = new HeroesAdapter(this, heroes, this);
        rv_heroes.setAdapter(adapter);
    }

    @Override
    public void onClickItem(Heroe heroe, int position) {

        Gson gson = new Gson();
        Intent iDetail = new Intent(this, HeroeDetailActivity.class);
        iDetail.putExtra("heroe_data", gson.toJson(heroe));
        startActivity(iDetail);
    }
}
