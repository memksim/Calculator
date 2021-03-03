package com.example.calculator;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;
import android.view.View;

import java.util.List;

public class HistoryActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;
    HistoryAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        if(getSupportActionBar() != null) {
            getSupportActionBar().setTitle("History");
        }

        mRecyclerView =(RecyclerView)findViewById(R.id.history_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        update();

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    private void update(){
        List<HistoryItem> operations = Operations.get().getOperations();
        if(mAdapter == null){
            mAdapter = new HistoryAdapter(operations);
            mRecyclerView.setAdapter(mAdapter);
        }else{
            mAdapter.notifyDataSetChanged();
        }
    }
}
