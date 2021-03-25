package com.example.proyecto1.ui;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.proyecto1.db.entity.NotaEntity;
import com.example.proyecto1.R;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link }.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyNotaRecyclerViewAdapter extends RecyclerView.Adapter<MyNotaRecyclerViewAdapter.ViewHolder> {

    private final List<NotaEntity> mValues;
//    private final NotasInteractionListener mListener;
    private Context ctx;
    public MyNotaRecyclerViewAdapter(List<NotaEntity> items, Context ctx) {
        mValues = items;
        this.ctx = ctx;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.textViewTitulo.setText(holder.mItem.getTitulo());
        holder.textViewContenido.setText(holder.mItem.getContenido());

        if (holder.mItem.isFavorita()){
            holder.ivFavorita.setImageResource(R.drawable.ic_baseline_star_24);
        }else{
            holder.ivFavorita.setImageResource(R.drawable.ic_baseline_star_border_24);
        }

        holder.ivFavorita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView textViewTitulo;
        public final TextView textViewContenido;
        public final ImageView ivFavorita;
        public NotaEntity mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            textViewTitulo = view.findViewById(R.id.textViewTitulo);
            textViewContenido = view.findViewById(R.id.textViewContenido);
            ivFavorita = view.findViewById(R.id.imageViewfavorita);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + textViewTitulo.getText() + "'";
        }
    }
}