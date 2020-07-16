package com.example.kibabiihostels;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegistrationActivity extends AppCompatActivity {

    //Widgets
    EditText regidno,regfname,regmname,reglname,regreno,regemail,regphone,regpassword;
    Button btnreg;

    //Firebase
    private DatabaseReference mDatabase;

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

        //Creating an instance of the database
        mDatabase = FirebaseDatabase.getInstance().getReference();

        btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //fetch data from input fields
                try {
                    String email = regemail.getText().toString();
                    String firstname = regfname.getText().toString();
                    String middlename = regmname.getText().toString();
                    String lastname = reglname.getText().toString();
                    String retistrationnumber = regreno.getText().toString();
                    String password = regpassword.getText().toString();
                    String idnumber = regidno.getText().toString();
                    String phone = regphone.getText().toString();

                    Student student = new Student(email, firstname, middlename, lastname, retistrationnumber, password, idnumber, phone);

                    //this will create a student table where all other values will be set, this means the idnumbers have to be unique otherwise
                    //if the id is the same, the data will be overwritten
                    mDatabase.child("students").child(idnumber).setValue(student);
                }
                catch(Exception e){
                    Toast.makeText(getApplicationContext(),"error" + e,Toast.LENGTH_LONG);

                }
            }
        });
    }
}
