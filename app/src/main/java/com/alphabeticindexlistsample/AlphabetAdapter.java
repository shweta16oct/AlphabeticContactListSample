package com.alphabeticindexlistsample;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

class AlphabetAdapter extends RecyclerView.Adapter<AlphabetAdapter.ViewHolder> {

    private Context context;
    private List<CommonModel> alphabet;
    private OnAlphabeticClick onAlphabeticClick;

    public AlphabetAdapter(Context context, List<CommonModel> alphabet, OnAlphabeticClick onAlphabeticClick) {
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
       viewHolder.textAlphabet.setText(alphabet.get(i).getAlphabet());
       viewHolder.textAlphabet.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               onAlphabeticClick.onClick(i);
           }
       });

       if(alphabet.get(i).isClicked()){
           viewHolder.textAlphabet.setTextColor(ContextCompat.getColor(context,R.color.colorPrimary));
           viewHolder.textAlphabet.setTypeface(viewHolder.textAlphabet.getTypeface(), Typeface.BOLD);
       }else{
           viewHolder.textAlphabet.setTextColor(ContextCompat.getColor(context,R.color.textColor));
           viewHolder.textAlphabet.setTypeface(viewHolder.textAlphabet.getTypeface(), Typeface.NORMAL);
       }
    }

    @Override
    public int getItemCount() {
        return alphabet.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textAlphabet;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textAlphabet=itemView.findViewById(R.id.textAlphabet);

        }
    }
}
