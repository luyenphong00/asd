package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String NAME = "extra_name" ;
    private static final String TASK_LIST =  "extra_list";
    private static final String STRING = "extra_string" ;
    TextView textViewSave;
    TextView textViewLoad;
    List<String> mStringList = new ArrayList<>();
    List<String> mStringListA = new ArrayList<>();
    String conrtact = "";
    String b;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        conrtact = "phonglt";
        mStringList.add("phong");
        mStringList.add("phong");
        mStringList.add("phong");
        mStringList.add("phong");
        mStringList.add("phong");
        textViewSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveString(conrtact);
            }
        });

        textViewLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadString();
            }
        });

    }

    private void initView() {
        textViewSave = findViewById(R.id.save);
        textViewLoad = findViewById(R.id.loadData);
    }

    private void saveString(String contact){
        SharedPreferences sharedPreferences = getSharedPreferences(NAME,MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(contact);
        editor.putString(STRING, json);
        editor.commit();
    }

    private void loadString(){
        SharedPreferences sharedPreferences = getSharedPreferences(NAME,MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString(STRING,null);
        Type type = new TypeToken<String>() {}.getType();
        b = gson.fromJson(json,type);
    }



    private void saveData(List<String> list){
        SharedPreferences sharedPreferences = getSharedPreferences(NAME,MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        editor.putString(TASK_LIST, json);
        editor.commit();

    }

    private void loadData(){
        SharedPreferences sharedPreferences = getSharedPreferences(NAME,MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString(TASK_LIST,null);
        Type type = new TypeToken<List<String>>() {}.getType();
        mStringListA = gson.fromJson(json,type);
        if (mStringListA == null){
            mStringListA = new ArrayList<>();
        }
    }
}
