package rb.moviesandroid.adapter;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import rb.moviesandroid.R;
import rb.moviesandroid.model.Movie;
import rb.moviesandroid.model.MovieResponse;

/**
 * Created by santander on 13/11/2017.
 */

public class MovieViewHolder extends RecyclerView.ViewHolder {

    private MovieView movieView;

    public MovieViewHolder(ViewGroup parent) {
        super(new MovieView(parent.getContext()));
        movieView = (MovieView) itemView;
    }

    public void bind(Movie movie){
        movieView.txtName.setText(movie.getTitle());

        Drawable drawable = ContextCompat.getDrawable(movieView.getContext(), R.drawable.ic_local_movies_black_24dp);

        Picasso.with(movieView.getContext())
                .load("http://image.tmdb.org/t/p/original" + movie.getPosterPath())
                .placeholder(drawable)
                .networkPolicy(NetworkPolicy.OFFLINE)
                .into(movieView.imgPoster);

    }
}