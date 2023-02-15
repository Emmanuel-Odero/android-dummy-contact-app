package com.enyason.mestuichallenge;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class QuoteViewHolder extends RecyclerView.ViewHolder {

    private final TextView tvAuthorName;
    private final TextView tvDateAdded;
    private final TextView tvQuote;

    public QuoteViewHolder(@NonNull View itemView) {
        super(itemView);
        tvAuthorName = itemView.findViewById(R.id.author_name);
        tvDateAdded = itemView.findViewById(R.id.date_added);
        tvQuote = itemView.findViewById(R.id.quote);
    }

    public void bind(QuoteModel model) {
        tvAuthorName.setText(model.getAuthor());
        tvDateAdded.setText(model.getDateAdded());
        tvQuote.setText(model.getContent());
    }
}
