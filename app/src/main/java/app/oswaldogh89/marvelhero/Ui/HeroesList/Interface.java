package app.oswaldogh89.marvelhero.Ui.HeroesList;

import java.util.ArrayList;
import app.oswaldogh89.marvelhero.Entities.Heroe;

/**
 * Created by oswaldogh89 on 22/04/18.
 */


public interface Interface {
    interface View {
        void createHeroesList(ArrayList<Heroe> heroes);
    }
    interface Presenter{
        void onLoadHeroesList(ArrayList<Heroe> heroes);
    }
    interface Model{
        void getHeroes();
    }
}
