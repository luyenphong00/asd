package com.example.myapplication;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.ultils.Utils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static com.example.myapplication.ultils.Utils.LIST_NAME;
import static com.example.myapplication.ultils.Utils.TASK_LIST;

public class SeconActivity extends AppCompatActivity {
    List<String> mStringListA = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadData();
    }

    private void loadData(){
        SharedPreferences sharedPreferences = getSharedPreferences(LIST_NAME,MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString(TASK_LIST,null);
        Type type = new TypeToken<List<String>>() {}.getType();
        mStringListA = gson.fromJson(json,type);
        if (mStringListA == null){
            mStringListA = new ArrayList<>();
        }
    }
}
