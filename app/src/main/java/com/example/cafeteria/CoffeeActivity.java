package com.example.cafeteria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CoffeeActivity extends AppCompatActivity {

    EditText coffeeNos;
    Button coffeeAdd,coffeeSub,coffeeOrder;

    int nos=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee);

        coffeeNos = (EditText) findViewById(R.id.coffeeNos);
        coffeeAdd = (Button) findViewById(R.id.coffeeAdd);
        coffeeSub = (Button) findViewById(R.id.coffeeSub);
        coffeeOrder = (Button) findViewById(R.id.coffeeOrder);

        coffeeNos.setText("0");
        coffeeAdd.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                nos+=1;
                coffeeNos.setText(String.valueOf(nos));
            }
        });

        coffeeSub.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {   if(nos>0){
                nos -= 1;
            }
            else {
                nos=0;
            }
                coffeeNos.setText(String.valueOf(nos));
            }
        });

        coffeeOrder.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent coffeeOrder = new Intent(CoffeeActivity.this,MainActivity.class);
                if(nos>0) startActivity(coffeeOrder);
                else Toast.makeText(getBaseContext(),"Add item before Ordering!",Toast.LENGTH_LONG).show();
            }
        });

    }
}