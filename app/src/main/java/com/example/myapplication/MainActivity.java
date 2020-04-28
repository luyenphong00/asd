package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

import static com.example.myapplication.ultils.Utils.LIST_NAME;
import static com.example.myapplication.ultils.Utils.TASK_LIST;

public class MainActivity extends AppCompatActivity {

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
        initData();
        textViewSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData(mStringList);
            }
        });

        textViewLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SeconActivity.class));
            }
        });

    }

    private void initData() {
        conrtact = "phonglt";
        mStringList.add("phong");
        mStringList.add("phong");
        mStringList.add("phong");
        mStringList.add("phong");
        mStringList.add("phong");
    }

    private void initView() {
        textViewSave = findViewById(R.id.save);
        textViewLoad = findViewById(R.id.loadData);
    }

//    private void saveString(String contact){
//        SharedPreferences sharedPreferences = getSharedPreferences(NAME,MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        Gson gson = new Gson();
//        String json = gson.toJson(contact);
//        editor.putString(NAME, json);
//        editor.commit();
//    }

//    private void loadString(){
//        SharedPreferences sharedPreferences = getSharedPreferences(NAME,MODE_PRIVATE);
//        Gson gson = new Gson();
//        String json = sharedPreferences.getString(STRING,null);
//        Type type = new TypeToken<String>() {}.getType();
//        b = gson.fromJson(json,type);
//    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.d("AAAA","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("AAAA","onDestroy");
    }

    private void saveData(List<String> list){
        SharedPreferences sharedPreferences = getSharedPreferences(LIST_NAME,MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        editor.putString(TASK_LIST, json);
        editor.commit();
    }

}
