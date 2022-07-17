package com.example.cafeteria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CakeActivity extends AppCompatActivity {

    EditText cakeNos;
    Button cakeAdd,cakeSub,cakeOrder;

    int nos=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cake);

        cakeNos = (EditText) findViewById(R.id.cakeNos);
        cakeAdd = (Button) findViewById(R.id.cakeAdd);
        cakeSub = (Button) findViewById(R.id.cakeSub);
        cakeOrder = (Button) findViewById(R.id.cakeOrder);

        cakeNos.setText("0");
        cakeAdd.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                nos+=1;
                cakeNos.setText(String.valueOf(nos));
            }
        });

        cakeSub.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(nos>0){
                    nos-=1;
                }
                else{
                    nos=0;

                }
                cakeNos.setText(String.valueOf(nos));

            }
        });

        cakeOrder.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent cakeOrder = new Intent(CakeActivity.this,MainActivity.class);
                if(nos>0) startActivity(cakeOrder);
                else Toast.makeText(getBaseContext(),"Add item before Ordering!",Toast.LENGTH_LONG).show();
            }
        });

    }
}