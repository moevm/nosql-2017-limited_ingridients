package com.eatproject.main_pages;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.eatproject.R;

public class ShowBase extends AppCompatActivity {

    private Context context;
    private Button ingrs;
    private Button dish;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_base);
        intent = getIntent();
        context = this;

        ingrs = (Button) findViewById(R.id.ingrs);
        dish = (Button) findViewById(R.id.dish);

        ingrs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.setClass(context,ShowIngrs_Type.class);
                startActivity(intent);
            }
        });

        dish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.setClass(context,ShowMeal.class);
                startActivity(intent);
            }
        });
    }
}
