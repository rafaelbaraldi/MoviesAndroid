package rb.moviesandroid.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import rb.moviesandroid.R;

public class MovieView extends FrameLayout {

    public TextView txtName;
    public ImageView imgPoster;

    public MovieView(Context context) {
        super(context);
        init();
    }

    public MovieView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MovieView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.adapter_movie, this);
        txtName = findViewById(R.id.txtName);
        imgPoster = findViewById(R.id.image);
    }
}