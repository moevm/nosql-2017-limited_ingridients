package com.eatproject.main_pages;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.eatproject.Constants.KEYS;
import com.eatproject.Constants.VALUES;
import com.eatproject.R;

public class MainPage extends AppCompatActivity {

    private Button eat;
    private Button showbase;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        context = this;
        eat = (Button) findViewById(R.id.eat);
        showbase = (Button) findViewById(R.id.showbase);

        eat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ShowDish.class);
                intent.putExtra(KEYS.FIND, VALUES.FINDEAT);
                startActivity(intent);
            }
        });

        showbase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ShowBase.class);
                startActivity(intent);
            }
        });
    }
}
