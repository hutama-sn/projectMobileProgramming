package com.example.ezyfoods;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.ezyfoods.R.*;
import static com.example.ezyfoods.R.array.*;

public class MyOrderActivity extends AppCompatActivity {

    ImageView mainImageView;
    TextView name, price,qtyTxt,totalTxt;
    Button buttonPay,buttonDel;
    String data1, data2;
    int myImage,qty,total,setPrice,mineral, apel, mangga, alpukat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_my_order);
        buttonPay = findViewById(id.paynowBtn);
        buttonDel = findViewById(id.deleteBtn);
        mainImageView = findViewById(id.mainImageView);
        name = findViewById(id.drink_name);
        price = findViewById(id.price);
        qtyTxt = findViewById(id.qtyTxt);
        totalTxt = findViewById(id.totalTxt);

        getData();
        setData();

    }

    private void getData(){
        if(getIntent().hasExtra("myImage") && getIntent().hasExtra("data1") && getIntent().hasExtra("data2")){
            qty = getIntent().getIntExtra("quantity",1);
            data1 = getIntent().getStringExtra("data1");
            data2 = getIntent().getStringExtra("data2");
            myImage = getIntent().getIntExtra("myImage", 1);
            mineral = getIntent().getIntExtra("mineral", 0);
            apel = getIntent().getIntExtra("apel", 0);
            mangga = getIntent().getIntExtra("mangga", 0);
            alpukat = getIntent().getIntExtra("alpukat", 0);
            if (data1.equals("Jus Apel")) {
                total = apel * qty;
            }else if(data1.equals("Air Mineral")){
                total = mineral * qty;
            }else if(data1.equals("Jus Mangga")){
                total = mangga * qty;
            }else if(data1.equals("Jus Alpukat")){
                total = alpukat * qty;
            }
        }else{
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
            buttonPay.setEnabled(total!=0 && qty!=0);
            buttonDel.setEnabled(total!=0 && qty!=0);
        }
    }

    private void setData(){
        totalTxt.setText("Total: Rp." + String.valueOf(total));
        if(qty == 0){
            qtyTxt.setText("");
        }else{
            qtyTxt.setText("Quantity: " + String.valueOf(qty));
        }
        name.setText(data1);
        price.setText(data2);
        mainImageView.setImageResource(myImage);
    }

    public void onClickOrderComplete(View view) {
        nextPageOrder();
    }

    private void nextPageOrder() {
        nextActivityOrder();
    }

    private void nextActivityOrder() {
        Intent i_3 = new Intent(this, OrderCompleteActivity.class);
        int priceMineral = 5000;
        int priceApel = 8000;
        int priceMangga = 12000;
        int priceAlpukat = 15000;
        i_3.putExtra("data1", data1);
        i_3.putExtra("data2", data2);
        i_3.putExtra("myImage", myImage);
        i_3.putExtra("mineral",priceMineral);
        i_3.putExtra("apel",priceApel);
        i_3.putExtra("mangga",priceMangga);
        i_3.putExtra("alpukat",priceAlpukat);
        i_3.putExtra("quantity",qty);
        i_3.putExtra("data1", data1);
        i_3.putExtra("data2",data2);
        i_3.putExtra("myImage",myImage);
        startActivity(i_3);
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
}