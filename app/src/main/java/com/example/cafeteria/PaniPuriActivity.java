package com.example.cafeteria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PaniPuriActivity extends AppCompatActivity {

    EditText paniNos;
    Button paniAdd,paniSub,paniOrder;

    int nos=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pani_puri);

        paniNos = (EditText) findViewById(R.id.paniNos);
        paniAdd = (Button) findViewById(R.id.paniAdd);
        paniSub = (Button) findViewById(R.id.paniSub);
        paniOrder = (Button) findViewById(R.id.paniOrder);

        paniNos.setText("0");
        paniAdd.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                nos+=1;
                paniNos.setText(String.valueOf(nos));
            }
        });

        paniSub.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            { if(nos>0){
                nos -= 1;
            }
            else {
                nos=0;
            }
                paniNos.setText(String.valueOf(nos));
            }
        });

        paniOrder.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent paniOrder = new Intent(PaniPuriActivity.this,MainActivity.class);
                if(nos>0) startActivity(paniOrder);
                else Toast.makeText(getBaseContext(),"Add item before Ordering!",Toast.LENGTH_LONG).show();
            }
        });


    }
}