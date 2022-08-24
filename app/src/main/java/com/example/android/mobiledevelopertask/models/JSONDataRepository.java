package com.example.android.mobiledevelopertask.models;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

public class JSONDataRepository {

    private MutableLiveData<JSONData> jsonDataMutableLiveData;

    public JSONDataRepository(@NonNull Application application) {
        JSONData jsonData = new JSONData(application);
        jsonDataMutableLiveData = new MutableLiveData<>();
        jsonDataMutableLiveData.postValue(jsonData);
    }

    public MutableLiveData<JSONData> getJsonDataMutableLiveData() {
        return jsonDataMutableLiveData;
    }
}
