package com.example.uyishi_recycleview;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MyAdapter.OnLongClickListener{

   private RecyclerView recyclerView;
   private ArrayList<Model> list;
    private MyAdapter myAdapter;
    private EditText name, surname;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=findViewById(R.id.etext1);
        surname=findViewById(R.id.etext2);
        recyclerView=findViewById(R.id.resV);
        btn=findViewById(R.id.btn);

        loaddata();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myAdapter.addItem(name.getText().toString(),surname.getText().toString());
                name.getText().clear();
                surname.getText().clear();

            }
        });
        myAdapter=new MyAdapter(list,this);// malumotlarni adapterga berish
        myAdapter.setListener(this);
        recyclerView.setAdapter(myAdapter);
        LinearLayoutManager l=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(l);
        ItemTouchHelper.Callback callback=new RecycleDragDrog(myAdapter);
        ItemTouchHelper touchHelper=new ItemTouchHelper(callback);
        touchHelper.attachToRecyclerView(recyclerView);


    }
    public  void loaddata(){
        list=new ArrayList<>();

            list.add(new Model("Abroror","Yuldoshov"));
            list.add(new Model("Sarvar","Yulchiev"));
            list.add(new Model("Asror", "Bozorov"));
        list.add(new Model("Abroror","Yuldoshov"));
        list.add(new Model("Sarvar","Yulchiev"));
        list.add(new Model("Asror", "Bozorov"));
        list.add(new Model("Abroror","Yuldoshov"));
        list.add(new Model("Sarvar","Yulchiev"));
        list.add(new Model("Asror", "Bozorov"));
        list.add(new Model("Abroror","Yuldoshov"));
        list.add(new Model("Sarvar","Yulchiev"));
        list.add(new Model("Asror", "Bozorov"));
        list.add(new Model("Abroror","Yuldoshov"));
        list.add(new Model("Sarvar","Yulchiev"));
        list.add(new Model("Asror", "Bozorov"));
        list.add(new Model("Abroror","Yuldoshov"));
        list.add(new Model("Sarvar","Yulchiev"));
        list.add(new Model("Asror", "Bozorov"));
        list.add(new Model("Abroror","Yuldoshov"));
        list.add(new Model("Sarvar","Yulchiev"));
        list.add(new Model("Asror", "Bozorov"));

    }

    @Override
    public void onClick(int i) {
        myAdapter.removedItem(i);
        ItemTouchHelper.Callback callback=new RecycleDragDrog(myAdapter);
        ItemTouchHelper touchHelper=new ItemTouchHelper(callback);
        touchHelper.attachToRecyclerView(recyclerView);
    }
}