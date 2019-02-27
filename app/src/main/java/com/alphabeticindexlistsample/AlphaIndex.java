package com.alphabeticindexlistsample;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AlphaIndex extends AppCompatActivity {
    private RecyclerView rvContact,rvAlphabet;
    private TextView tvSelectedAlphabet;
    private LinearLayoutManager mLayoutManager,mAlphabetManager;
    private AlphabetAdapter mAlphabetAdapter;
    private ContactAdapter mContactAdapter;
    private String[] alphabet={ "A","B","C","D","E","F","G","H","I","J", "K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    public List<ContactModel> ContactList;
    private String[] contactName={"Alpha","Alex","Alice","Anthoni","Bela","Britani","Catherin","Charlotte","David","Robin","Harry","John","Nick","Niklon","Peter","Parth","Sandy","Monk","Sheldon","Ace","Abel","Adams","Bent","Steve","Josh","Frank"};
    private Handler handler;
    private Runnable runnable;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alpha_index);
        mLayoutManager=new LinearLayoutManager(AlphaIndex.this);
        mAlphabetManager=new LinearLayoutManager(AlphaIndex.this);
        ContactList=new ArrayList<>();
        setIds();
        setContactList();
        setContactListAdapter();
    }

    private void setContactList() {

        for(int i=0;i<contactName.length;i++){
            ContactModel model=new ContactModel();
            model.setContact_name(contactName[i]);
            ContactModel.ContactType contactType=new ContactModel.ContactType();
            contactType.setContact_number("8378383802");
            contactType.setType("home");
            model.setContactInfo(contactType);
            ContactList.add(model);
        }
        Collections.sort(ContactList,ContactModel.comparator);

    }

    private void setIds() {
      rvAlphabet=findViewById(R.id.rvAlphabet);
      rvContact=findViewById(R.id.rvContact);
      tvSelectedAlphabet=findViewById(R.id.tvSelectedAlphabet);
    }

    private void setContactListAdapter() {
        mAlphabetAdapter=new AlphabetAdapter(AlphaIndex.this,alphabet, new OnAlphabeticClick() {
            @Override
            public void onClick(final int position) {
                for(int i=0;i<ContactList.size();i++){
                    if(String.valueOf(ContactList.get(i).getContact_name().charAt(0)).toUpperCase().equalsIgnoreCase(alphabet[position])){
                        rvContact.smoothScrollToPosition(i);
                        break;
                    }
                }
                tvSelectedAlphabet.setText(alphabet[position]);
                tvSelectedAlphabet.setVisibility(View.VISIBLE);
                if(handler!=null){
                    handler.removeCallbacks(runnable);
                }

                runnable=new Runnable() {
                    @Override
                    public void run() {
                        tvSelectedAlphabet.setText(alphabet[position]);
                        tvSelectedAlphabet.setVisibility(View.GONE);
                    }
                };
                handler=new Handler();
                handler.postDelayed(runnable,1000);
            }
        });
        rvAlphabet.setLayoutManager(mAlphabetManager);
        rvAlphabet.setAdapter(mAlphabetAdapter);

        mContactAdapter=new ContactAdapter(AlphaIndex.this,ContactList);
        rvContact.setLayoutManager(mLayoutManager);
        rvContact.setAdapter(mContactAdapter);
    }
}
