package rb.moviesandroid;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import rb.moviesandroid.fragment.MovieFragment;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private BottomNavigationView navigation;
    private BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

//            if (item.getItemId() == navigation.getSelectedItemId()){
//                return false;
//            }

            switch (item.getItemId()){
                case R.id.navigation_movie:
                    inflateMovieFragment();
                    return true;
                case R.id.navigation_profile:
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
        navigation.setSelectedItemId(R.id.navigation_movie);
    }


    private void inflateMovieFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, MovieFragment.newInstance())
                .addToBackStack(null)
                .commit();
    }
}
