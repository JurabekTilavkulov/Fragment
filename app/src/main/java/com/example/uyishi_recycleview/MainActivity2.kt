package com.example.uyishi_recycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity2 : AppCompatActivity(),MyKotlinAdapter.OnlongItemClickListener{

    private var adapter:MyKotlinAdapter ?=null
   private var recyclerView:RecyclerView?=null
    private var lists: ArrayList<Model>?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        recyclerView=findViewById(R.id.resV)


        lists?.add(Model("jiyan","balman"))
        recyclerView?.layoutManager=LinearLayoutManager(this)
        recyclerView?.adapter= lists?.let { MyKotlinAdapter(it,this,this) }





    }
      private fun  loaddat(): ArrayList<Model>? {

         var data: ArrayList<Model>?=null
        (0..20).forEach {i->data?.add(Model("Name$i ","surname$i"))  }
        return data
    }

    override fun onClick(i: Int) {
        adapter?.onRemoved(i)

    }
}