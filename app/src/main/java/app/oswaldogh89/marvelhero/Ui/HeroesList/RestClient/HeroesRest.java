package app.oswaldogh89.marvelhero.Ui.HeroesList.RestClient;


import app.oswaldogh89.marvelhero.BuildConfig;
import app.oswaldogh89.marvelhero.Entities.Marvel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface HeroesRest {
    @GET(BuildConfig.HOST + "/v1/public/characters")
    Call<Marvel> getHeroesList(@Query("apikey") String apikey, @Query("hash") String hash, @Query("ts") String ts);
}