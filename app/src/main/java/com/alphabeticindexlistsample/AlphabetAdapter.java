package com.alphabeticindexlistsample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

class AlphabetAdapter extends RecyclerView.Adapter<AlphabetAdapter.ViewHolder> {

    private Context context;
    private String[] alphabet;
    private OnAlphabeticClick onAlphabeticClick;

    public AlphabetAdapter(Context context, String[] alphabet, OnAlphabeticClick onAlphabeticClick) {
       this.context=context;
       this.alphabet=alphabet;
       this.onAlphabeticClick=onAlphabeticClick;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(context).inflate(R.layout.row_alphabet,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
       viewHolder.textAlphabet.setText(alphabet[i]);
       viewHolder.textAlphabet.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               onAlphabeticClick.onClick(i);
           }
       });
    }

    @Override
    public int getItemCount() {
        return alphabet.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textAlphabet;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textAlphabet=itemView.findViewById(R.id.textAlphabet);
        }
    }
}
