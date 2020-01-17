package com.xgtl.weather;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class AddCity extends Activity {
    EditText inputIv;
    Button affirmIv;

    public void init() {
        inputIv = findViewById(R.id.addCity);
        affirmIv = findViewById(R.id.affirm);
        Intent intent = getIntent();
        String msg = intent.getStringExtra("msg");
        inputIv.setText(msg);
        affirmIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddCity.this, MainActivity.class);
                String city = inputIv.getText().toString();
                intent.putExtra("city", city+"");
                intent.setAction(Intent.ACTION_VIEW);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        init();
    }
}
