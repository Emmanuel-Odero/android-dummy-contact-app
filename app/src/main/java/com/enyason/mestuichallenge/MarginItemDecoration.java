package com.enyason.mestuichallenge;


import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MarginItemDecoration extends RecyclerView.ItemDecoration {
    private final int mMarginHorizontal;
    private final int mMarginVertical;


    public MarginItemDecoration(int marginHorizontal, int marginVertical) {
        mMarginHorizontal = marginHorizontal;
        mMarginVertical = marginVertical;
    }

    @Override
    public void getItemOffsets(Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        outRect.bottom = mMarginVertical;
        outRect.top = mMarginVertical;

        outRect.left = mMarginHorizontal;
        outRect.right = mMarginHorizontal;

    }
}
