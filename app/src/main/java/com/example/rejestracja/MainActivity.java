package com.example.rejestracja;

import android.os.Bundle;

import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText ETemail;
    private EditText ETpassword;
    private EditText ETpasswordAgain;
    private Button Bbutton;
    private TextView TVkomunikat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ETemail = findViewById(R.id.email);
        ETpassword = findViewById(R.id.password);
        ETpasswordAgain = findViewById(R.id.passwordAgain);
        Bbutton = findViewById(R.id.button);
        TVkomunikat = findViewById(R.id.komunikat);

        Bbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email = ETemail.getText().toString().trim();
                String Password = ETpassword.getText().toString().trim();
                String PasswordAgain = ETpasswordAgain.getText().toString().trim();

                if (Email.isEmpty()) {
                    TVkomunikat.setText("Proszę wprowadzdić adres e-mail");
                } else if (!Patterns.EMAIL_ADDRESS.matcher(Email).matches()) {
                    TVkomunikat.setText("Nieprawidłowy adres e-mail");
                } else if (Password.isEmpty()) {
                    TVkomunikat.setText("Proszę wprowadzić hasło");
                } else if (PasswordAgain.isEmpty()) {
                    TVkomunikat.setText("Proszę ponownie wprowadzić hasło");
                } else if (!PasswordAgain.matches(Password)) {
                    TVkomunikat.setText("Hasła się różnią");
                } else {
                    TVkomunikat.setText("Witaj " + Email);
                }
            }
        });
    }
}