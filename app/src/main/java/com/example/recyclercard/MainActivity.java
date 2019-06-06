package com.example.recyclercard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText t1, t2;
    private Button b1, b2;
    ArrayList<ExampleItem> examplelist;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    RecyclerView.EdgeEffectFactory edgeEffectFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        generateFakeData();
        recyclerViewConfig();

        t1 = findViewById(R.id.edittextadd);
        t2 = findViewById(R.id.edittextdelete);
        b1 = findViewById(R.id.buttonadd);
        b2 = findViewById(R.id.buttondelete);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int position = Integer.parseInt(t1.getText().toString());
                addCard(position);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = Integer.parseInt(t2.getText().toString());
                removeCard(position);

            }
        });
    }

    public void generateFakeData() {
        //creating a ArrayList
        examplelist = new ArrayList<>();
        examplelist.add(new ExampleItem(R.drawable.node, "Clicked at Studio"));
        examplelist.add(new ExampleItem(R.drawable.oner, "Clicked at Germany"));
        examplelist.add(new ExampleItem(R.drawable.twor, "Clicked at Egypt"));
        examplelist.add(new ExampleItem(R.drawable.threer, "Clicked at Greece"));
        examplelist.add(new ExampleItem(R.drawable.fourr, "Clicked at Austria"));
        examplelist.add(new ExampleItem(R.drawable.fiver, "Clicked at India"));
        examplelist.add(new ExampleItem(R.drawable.sixr, "Clicked at GReeCe"));


    }

    public void recyclerViewConfig() {
        //config for recyclerView
        recyclerView = findViewById(R.id.recycleriew);
        //performance
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(MainActivity.this);

        adapter = new ExampleAdapter(examplelist);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    public void addCard(int position) {
        examplelist.add(position, new ExampleItem(R.drawable.sixr, "new card clicked"));
        adapter.notifyItemInserted(position);

    }

    public void removeCard(int position) {
        examplelist.remove(position);
        adapter.notifyItemRemoved(position);
    }
}

