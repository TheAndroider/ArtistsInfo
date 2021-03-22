package com.generalmotors.artists;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * The type Pagination scroll listener.
 */
public abstract class PaginationScrollListener extends RecyclerView.OnScrollListener {

    private final LinearLayoutManager layoutManager;

    /**
     * Instantiates a new Pagination scroll listener.
     *
     * @param lm the {@link RecyclerView.LayoutManager}
     */
    protected PaginationScrollListener(LinearLayoutManager lm) {
        this.layoutManager = lm;
    }

    @Override
    public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        int visibleItemCount = layoutManager.getChildCount();
        int totalItemCount = layoutManager.getItemCount();
        int firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition();

        if (!isLoading() && !isLastPage()) {
            if ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount
                    && firstVisibleItemPosition >= 0) {
                loadMoreItems();
            }
        }
    }

    /**
     * Is loading boolean.
     *
     * @return the boolean
     */
    public abstract boolean isLoading();

    /**
     * Is last page boolean.
     *
     * @return the boolean
     */
    public abstract boolean isLastPage();

    /**
     * Load more items.
     */
    protected abstract void loadMoreItems();
}
