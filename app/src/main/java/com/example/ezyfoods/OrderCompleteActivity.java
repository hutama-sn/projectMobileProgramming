package com.example.ezyfoods;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class OrderCompleteActivity extends AppCompatActivity {

    ImageView mainImageView;
    TextView name, price,qtyTxt,totalTxt;

    String data1, data2;
    int myImage,qty,total,setPrice,mineral, apel, mangga, alpukat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_complete);

        mainImageView = findViewById(R.id.orderimageView);
        name = findViewById(R.id.ordernameTxt);
        price = findViewById(R.id.orderpriceTxt);
        qtyTxt = findViewById(R.id.orderqtyTxt);
        totalTxt = findViewById(R.id.ordertotalTxt);

        getData();
        setData();
    }

    private void getData(){
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
    }

    private void setData(){
        totalTxt.setText("Total: Rp." + String.valueOf(total));
        qtyTxt.setText("Quantity: " + String.valueOf(qty));
        name.setText(data1);
        price.setText(data2);
        mainImageView.setImageResource(myImage);
    }

    public void onClickHome(View view) {
        nextPageHome();
    }

    private void nextPageHome() {
        nextActivityHome();
    }

    private void nextActivityHome() {
        Intent i_1 = new Intent(this,MainActivity.class);
        startActivity(i_1);
    }
}