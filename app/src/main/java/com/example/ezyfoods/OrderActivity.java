package com.example.ezyfoods;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity {

    ImageView mainImageView;
    TextView name, price;

    String data1, data2;
    int myImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        mainImageView = findViewById(R.id.mainImageView);
        name = findViewById(R.id.drink_name);
        price = findViewById(R.id.price);

        getData();
        setData();
    }

    private void getData(){
        if(getIntent().hasExtra("myImage") && getIntent().hasExtra("data1") && getIntent().hasExtra("data2")){
            data1 = getIntent().getStringExtra("data1");
            data2 = getIntent().getStringExtra("data2");
            myImage = getIntent().getIntExtra("myImage", 1);
        }else{
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }
    }

    private void setData(){
        name.setText(data1);
        price.setText(data2);
        mainImageView.setImageResource(myImage);
    }

    public void onClickDrink(View view) {
        prevPageDrink();
    }

    private void prevPageDrink() {
        prevActivityDrink();
    }

    private void prevActivityDrink() {
        Intent i_1 = new Intent (this, DrinksActivity.class);
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
        EditText quan = (EditText) findViewById(R.id.quantity);
        int qty = Integer.parseInt(quan.getText().toString());
        int priceMineral = 5000;
        int priceApel = 8000;
        int priceMangga = 12000;
        int priceAlpukat = 15000;
        i_2.putExtra("mineral",priceMineral);
        i_2.putExtra("apel",priceApel);
        i_2.putExtra("mangga",priceMangga);
        i_2.putExtra("alpukat",priceAlpukat);
        i_2.putExtra("quantity",qty);
        i_2.putExtra("data1", data1);
        i_2.putExtra("data2",data2);
        i_2.putExtra("myImage",myImage);
        startActivity(i_2);
    }
}