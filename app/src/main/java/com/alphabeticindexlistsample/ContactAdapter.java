package com.alphabeticindexlistsample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter <ContactAdapter.ViewHolder>{
    private Context context;
    private List<ContactModel> contactList;
    public ContactAdapter(Context context, List<ContactModel> contact) {
        this.contactList=contact;
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
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textContact;
        View view;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textContact=itemView.findViewById(R.id.textContact);
            view=itemView.findViewById(R.id.view);
        }
    }
}
