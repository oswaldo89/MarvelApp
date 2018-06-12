package app.oswaldogh89.marvelhero.Ui.HeroesList;

import java.util.ArrayList;

import app.oswaldogh89.marvelhero.Entities.Heroe;

/**
 * Created by oswaldogh89 on 22/04/18.
 */


public class HeroesPresenter implements Interface.Presenter {

    private Interface.View view;
    private Interface.Model model;

    HeroesPresenter(Interface.View view) {
        this.view = view;
        this.model = new HeroesModel(this);
    }

    void loadHeroes() {
        if (view != null) {
            this.model.getHeroes();
        }
    }

    @Override
    public void onLoadHeroesList(ArrayList<Heroe> heroes) {
        if (this.view != null) {
            this.view.createHeroesList(heroes);
        }
    }
}
