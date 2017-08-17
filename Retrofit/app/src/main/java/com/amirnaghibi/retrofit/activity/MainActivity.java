package com.amirnaghibi.retrofit.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.amirnaghibi.retrofit.R;
import com.amirnaghibi.retrofit.adapter.MoviesAdapter;
import com.amirnaghibi.retrofit.model.Movie;
import com.amirnaghibi.retrofit.model.MoviesResponse;
import com.amirnaghibi.retrofit.rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    // get activity name
    private static final String TAG = MainActivity.class.getSimpleName();

    // API KEY
    private final static String API_KEY = "f09fcdc415401049e5d4a1921c098afd";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(API_KEY.isEmpty()){
            Toast.makeText(getApplicationContext(),"Enter API key from themoviedb",Toast.LENGTH_LONG).show();
            return;
        }


        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.movies_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ApiInterface apiService = ApiInterface.getClient().create(ApiInterface.class);

        Call<MoviesResponse> call = apiService.getTopRateMovies(API_KEY);

        call.enqueue(new Callback<MoviesResponse>() {
            @Override
            public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
                int statusCode = response.code();
                List<Movie> movies = response.body().getResults();
                recyclerView.setAdapter(new MoviesAdapter(movies,R.layout.list_item_movie, getApplicationContext()));
            }

            @Override
            public void onFailure(Call<MoviesResponse> call, Throwable t) {
                Log.e(TAG,t.toString());
            }
        });
    }
}
