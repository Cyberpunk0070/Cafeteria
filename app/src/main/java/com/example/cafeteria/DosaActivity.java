package com.example.cafeteria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DosaActivity extends AppCompatActivity {

    EditText dosaNos;
    Button dosaAdd,dosaSub,dosaOrder;

    int nos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dosa);

        dosaNos = (EditText) findViewById(R.id.dosaNos);
        dosaAdd = (Button) findViewById(R.id.dosaAdd);
        dosaSub = (Button) findViewById(R.id.dosaSub);
        dosaOrder = (Button) findViewById(R.id.dosaOrder);

        dosaNos.setText("0");
        dosaAdd.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                nos+=1;
                dosaNos.setText(String.valueOf(nos));
            }
        });

        dosaSub.setOnClickListener(new View.OnClickListener()
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
                dosaNos.setText(String.valueOf(nos));
            }
        });

        dosaOrder.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent dosaOrder = new Intent(DosaActivity.this,MainActivity.class);
                if(nos>0) startActivity(dosaOrder);
                else Toast.makeText(getBaseContext(),"Add item before Ordering!",Toast.LENGTH_LONG).show();
            }
        });
    }
}