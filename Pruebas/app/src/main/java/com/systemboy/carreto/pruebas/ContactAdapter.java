package com.systemboy.carreto.pruebas;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Daniel on 08/02/2015.
 */
public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {
    private List<ContactInfo> contactList;
    public ContactAdapter(List<ContactInfo> contactList) {
        this.contactList = contactList;
    }
    @Override
    public int getItemCount() {
        return contactList.size();
    }
    @Override
    public void onBindViewHolder(ContactViewHolder contactViewHolder, int i) {
        ContactInfo ci = contactList.get(i);
        contactViewHolder.vName.setText(ci.name);
        contactViewHolder.vSurname.setText(ci.surname);
        contactViewHolder.vEmail.setText(ci.email);
        contactViewHolder.vTitle.setText(ci.name + " " + ci.surname);
        contactViewHolder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("uno->");
            }
        });
        contactViewHolder.relative.setBackgroundResource(R.drawable.big_card);
       // contactViewHolder.card.setCardBackgroundColor(Color.BLUE);
       // contactViewHolder.card.setBackgroundColor(Color.BLUE);
    }
    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.card_layout, viewGroup, false);
        return new ContactViewHolder(itemView);
    }
    public static class ContactViewHolder extends RecyclerView.ViewHolder {
        protected TextView vName;
        protected TextView vSurname;
        protected TextView vEmail;
        protected TextView vTitle;
        protected CardView card;
        protected FrameLayout relative;
        public ContactViewHolder(View v) {
            super(v);
            vName = (TextView) v.findViewById(R.id.txtName);
            vSurname = (TextView) v.findViewById(R.id.txtSurname);
            vEmail = (TextView) v.findViewById(R.id.txtEmail);
            vTitle = (TextView) v.findViewById(R.id.title);
            card =  (CardView) v.findViewById(R.id.card_view);
            relative = (FrameLayout) v.findViewById(R.id.fondo);
        }
    }
}