package fr.mds.pokedex.rest.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofit = null;
    private static MyRestService myRestService = null;

    public static MyRestService getService(){
        if(myRestService == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.pokemontcg.io/v1/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            myRestService = retrofit.create(MyRestService.class);
        }
        return myRestService;
    }

}
