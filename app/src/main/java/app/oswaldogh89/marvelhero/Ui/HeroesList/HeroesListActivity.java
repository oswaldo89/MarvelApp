package app.oswaldogh89.marvelhero.Ui.HeroesList;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

import app.oswaldogh89.marvelhero.Adapters.HeroesAdapter;
import app.oswaldogh89.marvelhero.Entities.Heroe;
import app.oswaldogh89.marvelhero.R;

/**
 * Created by oswaldogh89 on 22/04/18.
 */


public class HeroesListActivity extends AppCompatActivity implements Interface.View {

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
        HeroesAdapter adapter = new HeroesAdapter(this, heroes);
        rv_heroes.setAdapter(adapter);
    }
}
