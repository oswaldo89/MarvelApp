package app.oswaldogh89.marvelhero.Ui.HeroesList;

import java.util.ArrayList;

import app.oswaldogh89.marvelhero.Entities.Heroe;
import app.oswaldogh89.marvelhero.Entities.Marvel;
import app.oswaldogh89.marvelhero.Network.Client;
import app.oswaldogh89.marvelhero.Ui.HeroesList.RestClient.HeroesRest;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by oswaldogh89 on 22/04/18.
 */


public class HeroesModel implements Interface.Model {

    private Interface.Presenter presenter;

    HeroesModel(Interface.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void getHeroes() {
        Client client = new Client();
        HeroesRest petsRest = client.build().create(HeroesRest.class);

        String apikey = "38519a16e3451f0569cf52de1afc6179";
        String hash = "4ff62231fb0bc6b55620ebd199cd2288";
        String ts = "1528755013334";

        Call<Marvel> call = petsRest.getHeroesList(apikey, hash, ts);
        call.enqueue(new Callback<Marvel>() {
            @Override
            public void onResponse(Call<Marvel> call, Response<Marvel> response) {
                if (response.body() != null) {
                    ArrayList<Heroe> heroes = new ArrayList<>(response.body().getData().getResults());
                    presenter.onLoadHeroesList(heroes);
                }
            }

            @Override
            public void onFailure(Call<Marvel> call, Throwable t) {

            }
        });
    }
}
