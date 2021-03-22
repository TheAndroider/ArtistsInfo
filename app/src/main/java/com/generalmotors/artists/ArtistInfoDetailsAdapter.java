package com.generalmotors.artists;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

class ArtistInfoDetailsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {
    List<ArtistInfoResults> artistInfoResultsList = new ArrayList<>();
    private Context context;
    private static final int LOADING = 0;
    private static final int ITEM = 1;
    private boolean isLoadingAdded = false;
    private boolean isLoading = false;

    public ArtistInfoDetailsAdapter(Context context){
        this.context = context;
    }

    public void setArtistInfo(List<ArtistInfoResults> artistInfoResultsList,boolean isLoading) {
      //this.artistInfoResultsList = artistInfoResultsList;
        this.isLoading = isLoading;
        if (artistInfoResultsList != null) {
            for (ArtistInfoResults artistInfoResult : artistInfoResultsList) {
                add(artistInfoResult);
            }
        }
    }
    /**
     * Add.
     *
     * @param artistInfoResult the artistInfoResult
     */
    void add(ArtistInfoResults artistInfoResult) {
        artistInfoResultsList.add(artistInfoResult);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
//        View viewItem = inflater.inflate(R.layout.artist_info_item_view, parent, false);
//        viewHolder = new ArtistInfoViewHolder(viewItem);
        switch (viewType) {
            case ITEM:
                View viewItem = inflater.inflate(R.layout.artist_info_item_view, parent, false);
                viewHolder = new ArtistInfoViewHolder(viewItem);
                break;
            case LOADING:
                View viewLoading = inflater.inflate(R.layout.item_progress, parent, false);
                viewHolder = new LoadingViewHolder(viewLoading);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ArtistInfoResults artistInfo = artistInfoResultsList.get(holder.getAdapterPosition());
//        ArtistInfoViewHolder artistInfoViewHolder = (ArtistInfoViewHolder) holder;
//        artistInfoViewHolder.artistName.setText(artistInfo.getArtistName());
//        artistInfoViewHolder.trackName.setText(artistInfo.getTrackName());
//        artistInfoViewHolder.primaryGenreName.setText(artistInfo.getPrimaryGenreName());
//        if(holder instanceof ArtistInfoViewHolder){
//            ArtistInfoViewHolder artistInfoViewHolder = (ArtistInfoViewHolder) holder;
//            artistInfoViewHolder.artistName.setText(artistInfo.getArtistName());
//            artistInfoViewHolder.trackName.setText(artistInfo.getTrackName());
//            artistInfoViewHolder.primaryGenreName.setText(artistInfo.getPrimaryGenreName());
//        }else if(holder instanceof LoadingViewHolder){
//            LoadingViewHolder loadingViewHolder = (LoadingViewHolder) holder;
//            loadingViewHolder.progressBar.setVisibility(View.VISIBLE);
//        }
        switch (getItemViewType(position)) {
            case ITEM:
                ArtistInfoViewHolder artistInfoViewHolder = (ArtistInfoViewHolder) holder;
                artistInfoViewHolder.artistName.setText(artistInfo.getArtistName());
                artistInfoViewHolder.trackName.setText(artistInfo.getTrackName());
                artistInfoViewHolder.primaryGenreName.setText(artistInfo.getPrimaryGenreName());
                break;

            case LOADING:
                LoadingViewHolder loadingViewHolder = (LoadingViewHolder) holder;
                loadingViewHolder.progressBar.setVisibility(View.VISIBLE);
                break;
        }
    }
    @Override
    public int getItemCount() {
      return artistInfoResultsList == null ? 0 : artistInfoResultsList.size() ;
    }

    @Override
    public int getItemViewType(int position) {
        if (isLoadingAdded) {
            return position == artistInfoResultsList.size() - 1 ? LOADING : ITEM;
        } else {
            return ITEM;
        }
    }

    public void addLoadingFooter() {
        isLoadingAdded = true;
        notifyDataSetChanged();
    }

    public void removeLoadingFooter() {
        isLoadingAdded = false;

        int position = artistInfoResultsList.size() - 1;
        ArtistInfoResults item = getItem(position);

        if (item != null) {
            artistInfoResultsList.remove(position);
            notifyItemRemoved(position);
        }
    }

    /**
     * Gets item.
     *
     * @param position the position
     * @return the item
     */
    ArtistInfoResults getItem(int position) {
        return artistInfoResultsList.get(position);
    }

    public class ArtistInfoViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_artist_name)
        TextView artistName;
        @BindView(R.id.tv_track_name)
        TextView trackName;
        @BindView(R.id.tv_primary_genre_name)
        TextView primaryGenreName;

        public ArtistInfoViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }

        public class LoadingViewHolder extends RecyclerView.ViewHolder {
            @BindView(R.id.loadmore_progress)
            ProgressBar progressBar;

            public LoadingViewHolder(View itemView) {
                super(itemView);
                ButterKnife.bind(this, itemView);

            }
        }

    }
