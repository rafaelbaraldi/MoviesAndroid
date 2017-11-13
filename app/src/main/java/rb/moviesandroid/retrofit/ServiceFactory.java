package rb.moviesandroid.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by santander on 13/11/2017.
 */

public class ServiceFactory {

    private static ServiceFactory instance;

    private Retrofit retrofit;

    private static ServiceFactory getInstance() {
        if (instance == null) {
            instance = new ServiceFactory();
        }
        return instance;
    }

    private ServiceFactory() {
        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static MovieService getMovieService() {
        return getInstance().retrofit.create(MovieService.class);
    }
}
