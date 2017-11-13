package rb.moviesandroid.retrofit;

import rb.moviesandroid.model.MovieResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by santander on 13/11/2017.
 */

public interface MovieService {
    @GET("movie/popular")
    Call<MovieResponse> getMovies(@Query("api_key") String apiKey, @Query("page") int page);
}
