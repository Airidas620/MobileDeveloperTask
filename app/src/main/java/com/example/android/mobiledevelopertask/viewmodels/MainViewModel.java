package com.example.android.mobiledevelopertask.viewmodels;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.android.mobiledevelopertask.models.JSONData;
import com.example.android.mobiledevelopertask.models.JSONDataRepository;

public class MainViewModel extends AndroidViewModel {

    private MutableLiveData<JSONData> jsonDataMutableLiveData;

    public MainViewModel(@NonNull Application application) {
        super(application);
        JSONDataRepository repository = new JSONDataRepository(application);

        jsonDataMutableLiveData = repository.getJsonDataMutableLiveData();
    }

    public MutableLiveData<JSONData> getJsonDataMutableLiveData() {
        return jsonDataMutableLiveData;
    }

}