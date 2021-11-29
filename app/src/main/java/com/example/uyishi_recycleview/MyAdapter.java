package com.example.uyishi_recycleview;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> implements RecycleDragDrog.ItemTouchHelperDragRrog {
    private ArrayList<Model> list;
    private Context context;
    private OnLongClickListener listener;

    public MyAdapter(ArrayList<Model> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public void setListener(OnLongClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.layout_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Animation animation= AnimationUtils.loadAnimation(holder.itemView.getContext(),R.anim.myanim);
        int i=position;
        String name=list.get(position).getName();

        String surname=list.get(position).getSurname();
        holder.textView2.setText(name);
        holder.textView3.setText(surname);
        holder.textView1.setText(i+1+"");
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                listener.onClick(i);
                return true;
            }
        });
        holder.itemView.startAnimation(animation);

    }



    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onMoveSelected(int from, int to) {
        if(from<to){
            for(int i=from; i<to; i++){
                Collections.swap(list,i,i+1);
            }
        }else {
            for (int i = from; i >to ; i--) {
                Collections.swap(list,i,i-1);

            }
        }
        notifyItemMoved(from, to); // transit ni ko'rsatdai
    }

    @Override
    public void onItemSelected(RecyclerView.ViewHolder viewHolder) {

        viewHolder.itemView.setBackgroundColor(Color.RED);
    }

    @Override
    public void onClearSelected(RecyclerView.ViewHolder viewHolder) {
        viewHolder.itemView.setBackgroundColor(Color.GRAY);

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView1,textView2, textView3;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

           textView1=itemView.findViewById(R.id.tartibraqam);
           textView2=itemView.findViewById(R.id.ism);
           textView3=itemView.findViewById(R.id.surname);
        }
    }
    public  void addItem(String x,String y){
        list.add(new Model(x,y));

        notifyItemInserted(list.size());
    }
    public  void removedItem(int i){
        list.remove(i);
        notifyDataSetChanged();

    }
    interface OnLongClickListener{
        void onClick(int i);
    }
}
