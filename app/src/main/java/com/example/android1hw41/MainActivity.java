package com.example.android1hw41;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MainAdapter.ItemClickListener {

    public RecyclerView recyclerView;
    public MainAdapter mainAdapter;
    EditText editText;
    Button button;
    Title title;
    String string;
    ArrayList data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        button=findViewById(R.id.btn);
        editText=findViewById(R.id.edt_text);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                string=editText.getText().toString();//из вьюшки вытаскиваем данные и приравнием к переменной
                mainAdapter.addText(string);
                mainAdapter.notifyDataSetChanged();
/*
                title=new Title(string);
*/
            }
        });


    }

    private void init() {
        data=new ArrayList();
        recyclerView = findViewById(R.id.recycler_view);
        mainAdapter = new MainAdapter(data);
        mainAdapter.setOnClickListener(this);
        recyclerView.setAdapter(mainAdapter);

    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this,"Type " + position,Toast.LENGTH_LONG).show();

    }
}