package com.example.assignment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class practice extends AppCompatActivity {
    private EditText nameEditText, idEditText, emailEditText, passwordEditText;
    private RadioGroup genderRadioGroup;
    private RadioButton selectedGenderRadioButton;
    private CheckBox localCheckBox, globalCheckBox;
    private RatingBar ratingBar;
    private TextView ratingTextView;
    private Button submitButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_practice);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize views
        nameEditText = findViewById(R.id.pracname);
        idEditText = findViewById(R.id.pracid);
        emailEditText = findViewById(R.id.pracemail);
        passwordEditText = findViewById(R.id.pracpassword);
        genderRadioGroup = findViewById(R.id.pracradio);
        localCheckBox = findViewById(R.id.local);
        globalCheckBox = findViewById(R.id.global);
        ratingBar = findViewById(R.id.ratingbar);
        ratingTextView = findViewById(R.id.rating);
        submitButton = findViewById(R.id.pracbutton);

        // Handle RatingBar updates
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ratingTextView.setText("Rating: " + rating);
            }
        });

        // Handle submit button click
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString();
                String id = idEditText.getText().toString();
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                // Validate inputs
                if (name.isEmpty()) {
                    nameEditText.setError("Empty");
                    nameEditText.requestFocus();
                    return;
                }
                if (id.isEmpty()) {
                    idEditText.setError("Empty");
                    idEditText.requestFocus();
                    return;
                }
                if (email.isEmpty()) {
                    emailEditText.setError("Empty");
                    emailEditText.requestFocus();
                    return;
                }
                if (password.isEmpty()) {
                    passwordEditText.setError("Empty");
                    passwordEditText.requestFocus();
                    return;
                }

                // Get selected gender
                int selectedGenderId = genderRadioGroup.getCheckedRadioButtonId();
                if (selectedGenderId == -1) {
                    Toast.makeText(practice.this, "Please select your gender", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    selectedGenderRadioButton = findViewById(selectedGenderId);
                }

                // Check if any membership type is selected
                StringBuilder memberType = new StringBuilder();
                if (localCheckBox.isChecked()) {
                    memberType.append("Local ");
                }
                if (globalCheckBox.isChecked()) {
                    memberType.append("Global ");
                }
                if (memberType.length() == 0) {
                    Toast.makeText(practice.this, "Please select a membership type", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Display collected information as a Toast
                String gender = selectedGenderRadioButton.getText().toString();
                float rating = ratingBar.getRating();
                String result = "Name: " + name + "\nID: " + id + "\nEmail: " + email + "\nGender: " + gender +
                        "\nMembership: " + memberType + "\nRating: " + rating;
                Toast.makeText(practice.this, result, Toast.LENGTH_LONG).show();
            }
        });
    }
}