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

    public ArtistInfoDetailsAdapter(Context context){
        this.context = context;
    }

    public void setArtistInfo(List<ArtistInfoResults> artistInfoResultsList) {
      this.artistInfoResultsList = artistInfoResultsList;
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
        View viewItem = inflater.inflate(R.layout.artist_info_item_view, parent, false);
        viewHolder = new ArtistInfoViewHolder(viewItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ArtistInfoResults artistInfo = artistInfoResultsList.get(holder.getAdapterPosition());
        ArtistInfoViewHolder artistInfoViewHolder = (ArtistInfoViewHolder) holder;
        artistInfoViewHolder.artistName.setText(artistInfo.getArtistName());
        artistInfoViewHolder.trackName.setText(artistInfo.getTrackName());
        artistInfoViewHolder.primaryGenreName.setText(artistInfo.getPrimaryGenreName());

    }
    @Override
    public int getItemCount() {
      return artistInfoResultsList == null ? 0 : artistInfoResultsList.size() ;
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

    }
