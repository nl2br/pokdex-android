package fr.mds.pokedex.rest.service;

import fr.mds.pokedex.rest.container.PokeContainer;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MyRestService {
    @GET("cards")
    Call<PokeContainer> getCards(@Query("page") int page);
}
