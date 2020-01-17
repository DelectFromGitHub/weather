package com.xgtl.weather;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class delectCity extends AppCompatActivity {
    LinearLayout delectCity;

    public void init() {

        delectCity = findViewById(R.id.delect);
        Intent intent = getIntent();

        final ArrayList<String> arrayList = intent.getStringArrayListExtra("city");
        assert arrayList != null;
        arrayList.size();
        for (int i = 0; i < arrayList.size(); i++) {
            //每次循环新建View
            View view = View.inflate(this, R.layout.activity_delect_city, null);
            delectCity.addView(view);
            final TextView citys = view.findViewById(R.id.citys);
            ImageView error = view.findViewById(R.id.error);
            final String city = arrayList.get(i);
            citys.setText(city);
            error.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(delectCity.this, MainActivity.class);
                    intent.putExtra("citys", city);
                    startActivity(intent);
                }
            });
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delect_city);
        init();
    }


}
