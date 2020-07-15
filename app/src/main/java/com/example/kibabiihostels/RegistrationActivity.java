package com.example.kibabiihostels;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegistrationActivity extends AppCompatActivity {

    TextInputLayout regidno,regfname,regmname,reglname,regreno,regemail,regphone,regpassword;
    Button btnreg;
    FirebaseDatabase rootDb;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        regemail = findViewById(R.id.email);
        regidno = findViewById(R.id.idnumber);
        regfname = findViewById(R.id.firstname);
        reglname = findViewById(R.id.lastname);
        regmname = findViewById(R.id.middlename);
        regreno = findViewById(R.id.regno);
        regpassword = findViewById(R.id.password);
        regphone = findViewById(R.id.phone);
        btnreg = findViewById(R.id.btnregnow);

        btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //fetch data from input fields
                try {
                    String email = regemail.getEditText().getText().toString();
                    String firstname = regfname.getEditText().getText().toString();
                    String middlename = regmname.getEditText().getText().toString();
                    String lastname = reglname.getEditText().getText().toString();
                    String retistrationnumber = regreno.getEditText().getText().toString();
                    String password = regpassword.getEditText().getText().toString();
                    String idnumber = regidno.getEditText().getText().toString();
                    String phone = regphone.getEditText().getText().toString();

                    rootDb = FirebaseDatabase.getInstance();
                    reference = rootDb.getReference("studentusers");
                    DbhelperClass helperclass = new DbhelperClass(email, firstname, middlename, lastname, retistrationnumber, password, idnumber, phone);
                    reference.child(idnumber).setValue(helperclass);
                }
                catch(Exception e){
                    Toast.makeText(getApplicationContext(),"error" + e,Toast.LENGTH_LONG);

                }
            }
        });


    }
}
