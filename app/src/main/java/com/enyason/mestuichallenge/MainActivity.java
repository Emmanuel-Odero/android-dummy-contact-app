package com.enyason.mestuichallenge;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.koushikdutta.ion.Ion;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private final List<QuoteModel> quoteList = new ArrayList<>();

    private int pageToLoad = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        QuotesAdapter quotesAdapter = new QuotesAdapter(quoteList);

        loadQuotes(pageToLoad, quotesAdapter);

        RecyclerView quotesRecyclerView = findViewById(R.id.quotes_recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        quotesRecyclerView.setLayoutManager(layoutManager);
        quotesRecyclerView.setAdapter(quotesAdapter);
        quotesRecyclerView.addItemDecoration(new MarginItemDecoration(16, 8));
        quotesRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (!recyclerView.canScrollVertically(1)) {
                    // RecyclerView has reached the end of the data.
                    pageToLoad = pageToLoad + 1;
                    loadQuotes(pageToLoad, quotesAdapter);
                }
            }
        });
    }


    private void loadQuotes(int page, QuotesAdapter quotesAdapter) {
        String URL = "https://quotable.io/quotes?page=";
        Ion.with(this)
                .load(URL + page)
                .asJsonObject()
                .withResponse()
                .setCallback((error, response) -> {
                    if (error != null || response.getHeaders().code() != 200) {
                        return;
                    }

                    JsonArray jsonArray = response.getResult().getAsJsonArray("results");

                    for (JsonElement element : jsonArray) {
                        JsonObject object = element.getAsJsonObject();
                        QuoteModel quoteModel = new QuoteModel(object);
                        quoteList.add(quoteModel);
                    }

                    quotesAdapter.notifyDataSetChanged();

                });

    }
}
