package com.example.cafeteria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SamosaActivity extends AppCompatActivity {

    EditText samosaNos;
    Button samosaAdd,samosaSub,samosaOrder;

    int nos=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_samosa);

        samosaNos = (EditText) findViewById(R.id.samosaNos);
        samosaAdd = (Button) findViewById(R.id.samosaAdd);
        samosaSub = (Button) findViewById(R.id.samosaSub);
        samosaOrder = (Button) findViewById(R.id.samosaOrder);

        samosaNos.setText("0");
        samosaAdd.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                nos+=1;
                samosaNos.setText(String.valueOf(nos));
            }
        });

        samosaSub.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(nos>0){
                    nos -= 1;
                }
                else {
                    nos=0;
                }
                samosaNos.setText(String.valueOf(nos));
            }
        });

        samosaOrder.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent samosaOrder = new Intent(SamosaActivity.this,MainActivity.class);
                if(nos>0) startActivity(samosaOrder);
                else Toast.makeText(getBaseContext(),"Add item before Ordering!",Toast.LENGTH_LONG).show();
            }
        });

    }
}