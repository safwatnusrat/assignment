package com.example.assignment;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class button extends AppCompatActivity {
    private CheckBox redvelvet,cheesecake,chocolatecake,cheesepizza,mexicanhot,beefpizza;
    ArrayList<String>arr=new ArrayList<>();
    private RadioGroup radiogroup;
    private RadioButton radiobutton;
    private RatingBar ratingbar;
    private TextView resturanttext,deserttext,pizzatext,ratingtext,foodtext;
    private Button placeorder;
    private Switch cashondelivery;

    private AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_button);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        redvelvet=findViewById(R.id.redvelvet);
        cheesecake=findViewById(R.id.cheesecake);
        chocolatecake=findViewById(R.id.chocolatecake);
        cheesepizza=findViewById(R.id.cheesepizza);
        mexicanhot=findViewById(R.id.mexicanhot);
        beefpizza=findViewById(R.id.beefpizza);
        placeorder=findViewById(R.id.order_btn);


        radiogroup=findViewById(R.id.radioButton);
        ratingbar=findViewById(R.id.ratingbar);

        resturanttext=findViewById(R.id.resturants);
        deserttext=findViewById(R.id.deserttext);
        pizzatext=findViewById(R.id.pizzatext);
        ratingtext=findViewById(R.id.rating);
        foodtext=findViewById(R.id.food);

        cashondelivery=findViewById(R.id.cashondelivery);
        builder = new AlertDialog.Builder(this);

        ratingbar.setOnRatingBarChangeListener((ratingbar,rating,fromUser)->{
            ratingtext.setText("Rating: "+rating);
        });

        redvelvet.setOnCheckedChangeListener((buttonView, isChecked) -> {
            check(buttonView, isChecked);
        });
        cheesecake.setOnCheckedChangeListener((buttonView, isChecked) -> {
            check(buttonView, isChecked);
        });
        chocolatecake.setOnCheckedChangeListener((buttonView, isChecked) -> {
            check(buttonView, isChecked);
        });
        cheesepizza.setOnCheckedChangeListener((buttonView, isChecked) -> {
            check(buttonView, isChecked);
        });
        mexicanhot.setOnCheckedChangeListener((buttonView, isChecked) -> {
            check(buttonView, isChecked);
        });
        beefpizza.setOnCheckedChangeListener((buttonView, isChecked) -> {
            check(buttonView, isChecked);
        });

        placeorder.setOnClickListener(v -> showOrderSummary());
    }

    private void showOrderSummary() {
        ArrayList<String> pizzaList = new ArrayList<>();
        ArrayList<String> dessertList = new ArrayList<>();

        for (String item : arr) {
            if (item.toLowerCase().contains("pizza")) {
                pizzaList.add(item);
            } else {
                dessertList.add(item);
            }
        }

        String orderSummary = "Order Summary:\n\nPizza: " + pizzaList + "\nDessert: " + dessertList;

        builder.setTitle("Your Order")
                .setMessage(orderSummary)
                .setCancelable(false)
                .setPositiveButton("Confirm", (dialog, id) -> {
                    dialog.dismiss();

                    Toast.makeText(getApplicationContext(), "Order Placed!", Toast.LENGTH_SHORT).show();
                })
                .setNegativeButton("Cancel", (dialog, id) -> dialog.cancel())
                .show();

        cashondelivery.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                Toast.makeText(getApplicationContext(), "Cash on Delivery Selected", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "Cash on Delivery Unselected", Toast.LENGTH_SHORT).show();
            }
        });
    }

    void check(CompoundButton buttonView, Boolean isChecked) {
        if (isChecked) {
            arr.add(buttonView.getText().toString());
            Log.d("array", String.valueOf(arr));
        } else {
            arr.remove(buttonView.getText().toString());
        }
    }



}