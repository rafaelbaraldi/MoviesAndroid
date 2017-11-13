package rb.moviesandroid.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import rb.moviesandroid.model.Movie;

/**
 * Created by santander on 13/11/2017.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieViewHolder> {

    private List<Movie> moviesList;

    public MovieAdapter() {
        this.moviesList = new ArrayList<>();
    }

    public void addAll(List<Movie> moviesList) {
        this.moviesList.addAll(moviesList);
        notifyDataSetChanged();
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MovieViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        holder.bind(moviesList.get(position));
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}
