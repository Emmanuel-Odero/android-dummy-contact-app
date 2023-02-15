package com.enyason.mestuichallenge;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class QuotesAdapter extends RecyclerView.Adapter<QuoteViewHolder> {

    private final List<QuoteModel> quotes;

    public QuotesAdapter(List<QuoteModel> quoteModels) {
        quotes = quoteModels;
    }

    @NonNull
    @Override
    public QuoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View quoteView = inflater.inflate(R.layout.quote_item_layout, parent, false);
        return new QuoteViewHolder(quoteView);
    }

    @Override
    public void onBindViewHolder(@NonNull QuoteViewHolder holder, int position) {
        QuoteModel quoteModel = quotes.get(position);
        holder.bind(quoteModel);
    }

    @Override
    public int getItemCount() {
        return quotes.size();
    }
}
