package com.generalmotors.artists;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,MainPresenterContract.Presenter{
   @BindView(R.id.editArtistName)
    EditText editArtistName;

   @BindView(R.id.button)
   Button viewDetailsBtn;

   MainActivityPresenter mainActivityPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setUpPresenter();
        setUpViews();
    }

    private void setUpPresenter() {
        mainActivityPresenter = new MainActivityPresenter(this);
    }

    private void setUpViews() {
        viewDetailsBtn.setOnClickListener(this);
    }

    @Override
    public void showArtistDataResults(Context context, String artistName) {

    }

    @Override
    public void onClick(View v) {

        mainActivityPresenter.showArtistDataResults(this,editArtistName.getText().toString());
    }
}