package pe.edu.cibertec.moviedbapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    EditText etMovie;
    Button btSearch;
    RecyclerView rvMovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etMovie = findViewById(R.id.etMovie);
        btSearch = findViewById(R.id.btSearch);

        rvMovie = findViewById(R.id.rvMovie);

        btSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String apikey = "3cae426b920b29ed2fb1c0749f258325";
                String movie = etMovie.getText().toString();

                searchMovies(apikey, movie);
            }
        });
    }

    private void searchMovies(String apikey, String movie) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/search/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        MovieInterface movieInterface = retrofit.create(MovieInterface.class);


        Call<MovieResponse> methodSearch = movieInterface.searchMovies(apikey, movie);


        methodSearch.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call,
                                   Response<MovieResponse> response) {

                if (response.isSuccessful()) {
                    MovieResponse movieResponse = response.body();

                    ArrayList<Movie> results = movieResponse.getMovies();

                    Log.d("MainActivity", String.valueOf(results.size()));
                }

            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                Log.d("MainActivity", t.toString());
            }
        });
    }
}
