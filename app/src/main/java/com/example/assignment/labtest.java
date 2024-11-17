package com.example.assignment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.regex.Pattern;

public class labtest extends AppCompatActivity {

    private EditText nameEditText,emailEditText;
    private Button submit,increase,decrease;
    private Spinner spinner;
    private String name,email,div;
    private TextView quantity,price;
    private SeekBar seekBar;

    private Pattern namePattern=Pattern.compile("[a-z A-Z_.]+");
    private Pattern emailPattern=Pattern.compile("^[a-z0-9]+@(gmail|yahoo|org)\\.com$");
    private int quantityy=0,priceunit=100;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_labtest);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        nameEditText=findViewById(R.id.name);
        emailEditText=findViewById(R.id.email);
        spinner=findViewById(R.id.spinner);
        submit=findViewById(R.id.testsubmit);
        increase=findViewById(R.id.btn_increase);
        decrease=findViewById(R.id.btn_decrease);
        quantity=findViewById(R.id.tv_quantity);
        price=findViewById(R.id.tv_price);
        seekBar=findViewById(R.id.seekbar);
        seekBar.setMax(100);
        seekBar.setProgress(1);
        increase.setOnClickListener(v -> {
            quantityy++;
            quantity.setText(String.valueOf(quantityy));
            updateprice();


        });
        decrease.setOnClickListener(v -> {
            if (quantityy > 0) {
                quantityy--;
                quantity.setText(String.valueOf(quantityy));
                updateprice();
            }
        });



        String [] divisions=new String[]{"Select Division","Dhaka","Chottogram","Rajshahi","Khulna","Sylhet","Barishal","cumilla"};
        spinner.setAdapter(new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item,divisions));
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                div=spinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name=nameEditText.getText().toString();
                email=emailEditText.getText().toString();
                if(name.isEmpty()){
                    nameEditText.setError("Empty");
                    nameEditText.requestFocus();
                }
                else if(!namePattern.matcher(name).matches()){
                    nameEditText.setError("name should be in Alphabet!");
                    nameEditText.requestFocus();
                }
                else if(email.isEmpty()){
                    emailEditText.setError("Empty");
                    emailEditText.requestFocus();
                }
                else if(!emailPattern.matcher(email).matches()){
                    emailEditText.setError("Please Provide correct Email!");
                    emailEditText.requestFocus();
                }
            }
        });

    }

    private void updateprice() {

            int totalPrice = priceunit * quantityy;
            price.setText(String.format("Price: %d", totalPrice));

    }
}