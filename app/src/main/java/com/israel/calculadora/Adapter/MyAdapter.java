package com.israel.calculadora.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.israel.calculadora.R;
import com.israel.calculadora.objetos.Region;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Holder> {

    Context context;
    ArrayList<Region> lista;

    public MyAdapter(Context context, ArrayList<Region> lista) {
        this.context = context;
        this.lista = lista;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_recycler,viewGroup,false);
        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int i) {
        String sId =  lista.get(i).getId() +"";
        holder.getId().setText(sId);
        holder.getNombre().setText(String.valueOf(lista.get(i).getNombre()));
        holder.getContagiados().setText(String.valueOf(lista.get(i).getContagiados()));
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    class Holder extends RecyclerView.ViewHolder{

        TextView nombre, id, contagiados;

        public Holder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.nombreItem);
            id = itemView.findViewById(R.id.id);
            contagiados = itemView.findViewById(R.id.contagiados);
        }

        public TextView getNombre() {
            return nombre;
        }

        public TextView getId() {
            return id;
        }

        public TextView getContagiados() {
            return contagiados;
        }
    }
}