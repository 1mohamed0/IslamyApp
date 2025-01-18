package com.devoma.islamiapp

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class CarouselSpacingItemDecoration(private val spacing: Int) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        // Add spacing to the left and right of each item
        outRect.left = spacing / 2
        outRect.right = spacing / 2
    }
}