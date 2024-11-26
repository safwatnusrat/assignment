package com.example.assignment;

import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class customlistview extends AppCompatActivity {

    private ListView listView;
    private String[] food;
    private int[] images={R.drawable.margeritte,R.drawable.pepperonipizza,R.drawable.bbq_chicken,R.drawable.veggie_supreme_pizza,R.drawable.hawaiian_pizza,R.drawable.cheeseburger,R.drawable.bacon_burgerjpg,R.drawable.double_patty_burger,R.drawable.mushroom_swiss_burger,R.drawable.spicy_chiecken_burger};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_customlistview);

        listView=findViewById(R.id.customlistview);
        food=getResources().getStringArray(R.array.food);
        customAdapter adapter= new customAdapter(this,food,images);
        listView.setAdapter((ListAdapter) adapter);


    }
}