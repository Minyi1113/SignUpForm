package edu.temple.signupform;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FormActivity extends AppCompatActivity {

    AlertDialog.Builder alertDialog;
    Button SignUp;
    EditText name,email,password, passwordConfirm;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formactivity);

       // get all  fields using id
        SignUp = (Button)findViewById(R.id.Button);
        name = (EditText)findViewById(R.id.name);
        email = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.password);
        passwordConfirm = (EditText) findViewById(R.id.passwordConfirm);

        //creating alertbox for showing the username after successfull signup
        alertDialog=new AlertDialog.Builder(FormActivity.this);

        //checking the empty edittext
        SignUp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //check whether the fields are empty of not
                if(name.getText().toString().isEmpty() || email.getText().toString().isEmpty() || password.getText().toString().isEmpty() || passwordConfirm.getText().toString().isEmpty()  )
                {
                    //if yes then toast will apear to show the fields are mandatory
                    Toast.makeText(getApplicationContext(), "All Fields Are Mandatory !", Toast.LENGTH_SHORT).show();

                }
                else if(!password.getText().toString().equals(passwordConfirm.getText().toString()))
                {
                    //if password mismatch then this toast will apear
                    Toast.makeText(getApplicationContext(), "Password Do not Match !", Toast.LENGTH_SHORT).show();

                }
                else
                {
                    //successfully showing the message in the form of alert
                    Toast.makeText(getApplicationContext(), "Welcome, " + name.getText().toString() + ", to the SignUpForm App.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
