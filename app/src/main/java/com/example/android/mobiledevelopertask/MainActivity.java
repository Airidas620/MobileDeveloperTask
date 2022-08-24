package com.example.android.mobiledevelopertask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.android.mobiledevelopertask.viewmodels.MainViewModel;

public class MainActivity extends AppCompatActivity {

    MainViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView enlargedURLImage = findViewById(R.id.enlarged_url_image);
        enlargedURLImage.setOnClickListener(view -> view.setVisibility(View.INVISIBLE));

        RecyclerView recyclerView = findViewById(R.id.recycler_View);
        JSONDataRecyclerAdapter adapter = new JSONDataRecyclerAdapter(enlargedURLImage);
        recyclerView.setAdapter(adapter);

        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        viewModel.getJsonDataMutableLiveData().observe(this, adapter::setJsonData);
    }
}