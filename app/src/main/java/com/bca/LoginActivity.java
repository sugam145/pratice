package com.bca;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView signUpTv = (TextView) findViewById(R.id.signUpTb);
        EditText emailEt = (EditText) findViewById(R.id.emailEt);
        EditText passwordEt = (EditText) findViewById(R.id.passwordEt);
        Button loginBtn = (Button) findViewById(R.id.loginBtn);


        loginBtn.setOnClickListener(view -> {
            Intent i = new Intent(LoginActivity.this, DisplayActivity.class);
            i.putExtra("EmailId", emailEt.getText().toString());
            i.putExtra("passwordId", passwordEt.getText().toString());
            startActivityForResult(i, 2);
        });


        signUpTv.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
                return true;
            }
        });

//        loginBtn.setOnClickListener(view -> {
//            startActivity(new Intent(LoginActivity.this,SignUpActivity.class));
//        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        EditText email = (EditText) findViewById(R.id.emailEt);
        if (requestCode == 2) {

            String message = data.getStringExtra("message");
            email.setText(message);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.nav_menu, menu);
        return true;


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.settings:
                return true;
            case R.id.share:
                return true;
            case R.id.logout:
                showDialog();
                return  true;
            default:


                return super.onOptionsItemSelected(item);
        }
    }
    public void showDialog(){
        AlertDialog.Builder builder=new AlertDialog.Builder(LoginActivity.this);
        builder.setTitle("Logout");
        builder.setMessage("Are you sure you want to logout?");
        builder.setCancelable(true);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        AlertDialog alert=builder.create();
        alert.show();
    }


}





