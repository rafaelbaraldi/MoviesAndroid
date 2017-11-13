package rb.moviesandroid;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

/**
 * Created by santander on 13/11/2017.
 */

public class MoviesAndroidApplication extends Application {

    @SuppressLint("StaticFieldLeak")
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();

        context = this;
    }

    public static Context getContext() {
        return context;
    }
}
