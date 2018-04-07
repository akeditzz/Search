package com.akeditzz.search;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.akeditzz.search.adapter.SearchAdapter;
import com.akeditzz.search.model.SearchModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    EditText editText;
    ArrayList<SearchModel> list;
    SearchAdapter searchAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();


    }

    private void initView() {
        recyclerView = (RecyclerView)findViewById(R.id.rv_searchlist);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        editText = (EditText)findViewById(R.id.et_search);

        list = new ArrayList<>();
        list.add(new SearchModel("John"));
        list.add(new SearchModel("Lion"));
        list.add(new SearchModel("Mark"));
        list.add(new SearchModel("Logan"));
        list.add(new SearchModel("Robert"));
        list.add(new SearchModel("Cris"));
        list.add(new SearchModel("Mango"));
        list.add(new SearchModel("Grapes"));
        list.add(new SearchModel("Akshay"));

        setAdapter();

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                try {
                    searchAdapter.Filter(""+charSequence.toString().trim());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });



    }

    private void setAdapter() {
        searchAdapter = new SearchAdapter(list,this);
        recyclerView.setAdapter(searchAdapter);
    }
}
