package com.example.assignment;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textview=findViewById(R.id.textView);
        ImageView imageView = findViewById(R.id.imageView);
        Button button = findViewById(R.id.signinbutton);
        Button button2=findViewById(R.id.signupbutton);


        button.setOnClickListener(v -> {
            Intent intent=new Intent(MainActivity.this,button.class);
            startActivity(intent);
            Toast.makeText(this, "Sign In is Clicked", Toast.LENGTH_SHORT).show();
        });
        button2.setOnClickListener(v->{
            Intent intent=new Intent(MainActivity.this,loginActivity.class);
            startActivity(intent);
            Toast.makeText(this, "Sign Up is Clicked", Toast.LENGTH_SHORT).show();
        });
    }
}