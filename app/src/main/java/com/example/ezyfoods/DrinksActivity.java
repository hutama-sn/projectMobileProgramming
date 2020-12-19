package com.example.ezyfoods;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DrinksActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    String s1[], s2[];
    int images[] = {R.drawable.air_mineral, R.drawable.jus_apel, R.drawable.jus_mangga, R.drawable.jus_alpukat};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks);

        recyclerView = findViewById(R.id.recyclerView);

        s1 =  getResources().getStringArray(R.array.drinks_name);
        s2 = getResources().getStringArray(R.array.harga);

        MyAdapter myAdapter = new MyAdapter(this, s1, s2, images);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void onClickMyOrder(View view) {
        nextPageMyOrder();
    }

    private void nextPageMyOrder() {
        nextActivityMyOrder();
    }

    private void nextActivityMyOrder() {
        Intent i_3 = new Intent (this, MyOrderActivity.class);
        startActivity(i_3);
    }
}