package com.example.ezyfoods;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickDrink(View view) {
        nextPageDrink();
    }

    private void nextPageDrink() {
        nextActivityDrink();
    }

    private void nextActivityDrink() {
        Intent i_1 = new Intent(this, DrinksActivity.class);
        startActivity(i_1);
    }

    public void onClickMyOrder(View view) {
        nextPageMyOrder();
    }

    private void nextPageMyOrder() {
        nextActivityMyOrder();
    }

    private void nextActivityMyOrder() {
        Intent i_2 = new Intent(this, MyOrderActivity.class);
        startActivity(i_2);
    }
}