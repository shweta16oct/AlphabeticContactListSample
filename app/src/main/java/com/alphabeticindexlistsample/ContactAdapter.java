package com.alphabeticindexlistsample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter <ContactAdapter.ViewHolder>{
    private Context context;
    private List<CommonModel> contactList;
    private List<CommonModel> alphabetList;
    public ContactAdapter(Context context, List<CommonModel> alphabetList, List<CommonModel> contact) {
        this.contactList=contact;
        this.alphabetList=alphabetList;
        this.context=context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(context).inflate(R.layout.row_contact,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
     viewHolder.textContact.setText(contactList.get(i).getContact_name());
     if(i==getItemCount()-1){
       viewHolder.view.setVisibility(View.GONE);
     }else
         viewHolder.view.setVisibility(View.VISIBLE);

     if(i==0){
         viewHolder.textHeader.setVisibility(View.VISIBLE);
         viewHolder.viewHeader.setVisibility(View.VISIBLE);
         viewHolder.viewDivider.setVisibility(View.GONE);
         viewHolder.textHeader.setText(contactList.get(i).getAlphabet());
     }else if(contactList.get(i).getAlphabet().equalsIgnoreCase(contactList.get(i-1).getAlphabet())){
         viewHolder.textHeader.setVisibility(View.GONE);
         viewHolder.viewHeader.setVisibility(View.GONE);
         viewHolder.viewDivider.setVisibility(View.GONE);
     }else{
         viewHolder.textHeader.setVisibility(View.VISIBLE);
         viewHolder.viewHeader.setVisibility(View.VISIBLE);
         viewHolder.textHeader.setText(contactList.get(i).getAlphabet());
         viewHolder.viewDivider.setVisibility(View.VISIBLE);
     }
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textContact,textHeader;
        View view,viewHeader;
        LinearLayout viewDivider;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textContact=itemView.findViewById(R.id.textContact);
            textHeader=itemView.findViewById(R.id.textHeader);
            view=itemView.findViewById(R.id.view);
            viewHeader=itemView.findViewById(R.id.viewHeader);
            viewDivider=itemView.findViewById(R.id.viewDivider);
        }
    }
}
