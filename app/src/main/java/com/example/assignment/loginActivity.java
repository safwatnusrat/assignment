package com.example.assignment;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Objects;
import java.util.regex.Pattern;

public class loginActivity extends AppCompatActivity {
    private EditText nameEditText,emailEditText,contactnoEditText,passwordEditText,confirmpassEdittext;
    private Spinner division;
    private Button submit,clear;
    private String name,email,contactno,pass,conpass,div;
    private LinearLayout inputLayout,outputLayout;
    private TextView outputText;
    private Pattern namePattern=Pattern.compile("[a-z A-Z_.]+");
    private Pattern emailPattern=Pattern.compile("^[a-z0-9]+@(gmail|yahoo|org)\\.com$");
    private Pattern contactnoPattern=Pattern.compile("^[01][\\d]{10}$");
    private Pattern passPattern=Pattern.compile("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        nameEditText=findViewById(R.id.name);
        emailEditText=findViewById(R.id.email);
        contactnoEditText=findViewById(R.id.contact);
        division=findViewById(R.id.spinner);
        submit=findViewById(R.id.buttonsubmit);
        inputLayout=findViewById(R.id.inputlayout);
        outputLayout=findViewById(R.id.outputlayout);
        outputText=findViewById(R.id.outputText);
        clear=findViewById(R.id.clear);
        passwordEditText=findViewById(R.id.password);
        confirmpassEdittext=findViewById(R.id.confirmpassword);

        String [] divisions=new String[]{"Select Division","Dhaka","Chottogram","Rajshahi","Khulna","Sylhet","Barishal","cumilla"};
        division.setAdapter(new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item,divisions));
        division.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                div=division.getSelectedItem().toString();
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
                contactno=contactnoEditText.getText().toString();
                pass=passwordEditText.getText().toString();
                conpass=confirmpassEdittext.getText().toString();
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
                else if(contactno.isEmpty()){
                    contactnoEditText.setError("Empty");
                    contactnoEditText.requestFocus();
                }
                else if(!contactnoPattern.matcher(contactno).matches()){
                    contactnoEditText.setError("Please Provide correct Phone no!");
                    contactnoEditText.requestFocus();
                }
                else if(!passPattern.matcher(pass).matches()){
                    passwordEditText.setError("One UpperCase,One Lowercase,One digit,One special char and minimum length 8");
                    passwordEditText.requestFocus();
                }
                else if(!pass.equals(conpass)){
                    confirmpassEdittext.setError("Does not match with password");
                    confirmpassEdittext.requestFocus();
                }  else if(Objects.equals(div,"Select Division")){
                    Toast.makeText(loginActivity.this, "Please Select Division", Toast.LENGTH_SHORT).show();
                }
                else {
                    outputLayout.setVisibility(View.VISIBLE);
                    inputLayout.setVisibility(View.GONE);
                    String res="Name: "+name+"\nEmail: "+email+"\nContact no: "+contactno+"\nDivision: "+div;
                    outputText.setText(res);
                        clear.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                outputLayout.setVisibility(View.GONE);
                                inputLayout.setVisibility(View.VISIBLE);
                                nameEditText.setText("");
                                emailEditText.setText("");
                                contactnoEditText.setText("");
                                passwordEditText.setText("");
                                confirmpassEdittext.setText("");
                                division.setSelection(0);


                            }
                        });
                    }

                }



        });
    }

}