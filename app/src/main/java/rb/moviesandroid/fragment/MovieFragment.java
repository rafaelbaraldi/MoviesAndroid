package rb.moviesandroid.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.LinearLayout;

import com.github.pwittchen.infinitescroll.library.InfiniteScrollListener;

import java.util.ArrayList;
import java.util.List;

import rb.moviesandroid.R;
import rb.moviesandroid.adapter.MovieAdapter;
import rb.moviesandroid.model.Movie;
import rb.moviesandroid.model.MovieResponse;
import rb.moviesandroid.retrofit.ServiceFactory;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment {

    public RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private MovieAdapter movieAdapter;
    private static int page = 1;

    public static MovieFragment newInstance() {
        Bundle args = new Bundle();
        MovieFragment fragment = new MovieFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_movie, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        movieAdapter = new MovieAdapter();

        layoutManager = new LinearLayoutManager(getContext(), LinearLayout.VERTICAL, false);
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(movieAdapter);

        recyclerView.addOnScrollListener(new InfiniteScrollListener(20, layoutManager) {
            @Override
            public void onScrolledToEnd(int firstVisibleItemPosition) {
                page++;
                getMovies();
            }
        });
        getMovies();
    }

    private void getMovies() {
        ServiceFactory.getMovieService().getMovies("d7378b8d8f3194315f9163bd01782a7b", page).enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                movieAdapter.addAll(response.body().getMovieList());
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {

            }
        });
    }
}
