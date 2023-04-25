package com.bca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        Intent i=getIntent();
        TextView emailTv=findViewById(R.id.emailTv);
        emailTv.setText(i.getStringExtra("EmailId"));
        TextView passwordTv=findViewById(R.id.passwordTv);
        passwordTv.setText(i.getStringExtra("passwordId"));




        Button btn=findViewById(R.id.gotoId);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.putExtra("message","Login Back");
                setResult(2,intent);
                finish();
            }
        });
    }
}



