package com.generalmotors.artists;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ArtistInfoActivity extends Activity implements ArtistsInfoContract.ArtistsInfoView{
    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;

    @BindView(R.id.progress)
    ProgressBar progressBar;

    ArtistInfoDetailsAdapter artistInfoDetailsAdapter;
    ArtistsInfoContract.ArtistsInfoPresenter presenter;
    private String artistName ="";
    List<ArtistInfoResults> artistInfoResultsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.artist_info_details);
        ButterKnife.bind(this);
        Bundle bundle = getIntent().getExtras();
        artistName = bundle.getString("artistName");
        setupMVP(artistName);
        setupViews();

    }

    private void setupViews() {
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        artistInfoDetailsAdapter = new ArtistInfoDetailsAdapter(this);
        recyclerView.setAdapter(artistInfoDetailsAdapter);

    }

    private void loadData() {
        artistInfoDetailsAdapter = new ArtistInfoDetailsAdapter(this);
        artistInfoDetailsAdapter.setArtistInfo(artistInfoResultsList);
       recyclerView.setAdapter(artistInfoDetailsAdapter);
        artistInfoDetailsAdapter.notifyDataSetChanged();
    }

    private void setupMVP(String artistName) {
        presenter = new ArtistInfoPresenterImp(this);
        presenter.getArtistsInfo(artistName);
    }

    @Override
    public void showProgressBar() {
      progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
      progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showArtistInfoResults(List<ArtistInfoResults> artistInfoResults) {
        this.artistInfoResultsList = artistInfoResults;
        loadData();
    }
}
