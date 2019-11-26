package com.example.app_fichas_rpg.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_fichas_rpg.Ficha;
import com.example.app_fichas_rpg.ListarFichaActivity;
import com.example.app_fichas_rpg.R;
import com.example.app_fichas_rpg.RecuperarFichaActivity;

import java.util.List;

public class FichaAdapter extends RecyclerView.Adapter<FichaAdapter.ViewHolder> {

    private List<Ficha> fichas;

    private Context mContext;


    public FichaAdapter(List<Ficha> fichas, Context mContext) {

        this.fichas = fichas;
        this.mContext = mContext;
    }


    @NonNull

    @Override

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_ficha, parent, false);

        return new ViewHolder(view);

    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        holder.name.setText(fichas.get(position).getNome());
        holder.nivel.setText(String.valueOf(fichas.get(position).getNivel()));

        holder.container.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {
                Intent intent = new Intent(mContext, RecuperarFichaActivity.class);
                intent.putExtra("ficha", fichas.get(position));
                mContext.startActivity(intent);
            }

        });

    }


    @Override

    public int getItemCount() {

        return fichas.size();

    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView nivel;
        LinearLayout container;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);

            name = itemView.findViewById(R.id.txt_Personagem_Ficha);
            nivel = itemView.findViewById(R.id.txt_Nivel_Ficha);
            container = itemView.findViewById(R.id.container);

        }

    }
}
