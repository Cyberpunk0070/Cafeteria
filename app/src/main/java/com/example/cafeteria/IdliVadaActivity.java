package com.example.cafeteria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class IdliVadaActivity extends AppCompatActivity {

    EditText idliNos;
    Button idliAdd,idliSub,idliOrder;

    int nos=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idli_vada);

        idliNos = (EditText) findViewById(R.id.idliNos);
        idliAdd = (Button) findViewById(R.id.idliAdd);
        idliSub = (Button) findViewById(R.id.idliSub);
        idliOrder = (Button) findViewById(R.id.idliOrder);

        idliNos.setText("0");
        idliAdd.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                nos+=1;
                idliNos.setText(String.valueOf(nos));
            }
        });

        idliSub.setOnClickListener(new View.OnClickListener()
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
                idliNos.setText(String.valueOf(nos));
            }
        });

        idliOrder.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent idliOrder = new Intent(IdliVadaActivity.this,MainActivity.class);
                if(nos>0) startActivity(idliOrder);
                else Toast.makeText(getBaseContext(),"Add item before Ordering!",Toast.LENGTH_LONG).show();
            }
        });

    }
}