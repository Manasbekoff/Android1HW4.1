package com.example.android1hw41;

import android.service.quicksettings.Tile;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

    public ItemClickListener listener;
    public ArrayList<String> list;
    public MainAdapter(ArrayList<String> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_recyclerview,parent,false);
        return new MainViewHolder(view);//считанный view прикрепляем к viewHolder
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        holder.onBind(list.get(position));//заполнение листа

    }

    @Override
    public int getItemCount() {
        return list.size();//сколько отобразить
    }
    public void addText(String string){
        list.add(string);
        notifyDataSetChanged();
    }

    public class MainViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textView;

        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
            textView= itemView.findViewById(R.id.txt_view);
            itemView.setOnClickListener(this);
        }

        void onBind(String title) {
            textView.setText(title);//обращаемся и говорим что он должен отобразить
        }

        @Override
        public void onClick(View view) {
            if (listener !=null ) listener.onItemClick(view,getAdapterPosition());
        }
    }

    public void setOnClickListener(ItemClickListener mListener){
        this.listener = mListener;
    }
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
