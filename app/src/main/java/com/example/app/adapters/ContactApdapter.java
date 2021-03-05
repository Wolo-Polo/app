package com.example.app.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app.R;
import com.example.app.models.Contact;

import java.util.List;

public class ContactApdapter extends ArrayAdapter<Contact> {
    private Context context;
    private int resource;
    private List<Contact> contacts;

    public ContactApdapter(@NonNull Context context, int resource, @NonNull List<Contact> contacts) {
        super(context, resource, contacts);
        this.context = context;
        this.resource = resource;
        this.contacts = contacts;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null){
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_contact_listview, parent, false);
            viewHolder.ivAvatar = (ImageView) convertView.findViewById(R.id.ivAvatar);
            viewHolder.tvName = (TextView) convertView.findViewById(R.id.tvName);
            viewHolder.tvPhoneNumber = (TextView) convertView.findViewById(R.id.tvPhoneNumber);

            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Contact contact = contacts.get(position);
        viewHolder.tvName.setText(contact.getName());
        viewHolder.tvPhoneNumber.setText(contact.getPhoneNumber());
        if(contact.getGender().equals("Male")){
            viewHolder.ivAvatar.setBackgroundResource(R.drawable.icon_male);
        }else if(contact.getGender().equals("Female")){
            viewHolder.ivAvatar.setBackgroundResource(R.drawable.icon_female);
        }

        return convertView;
    }

    public class ViewHolder{
        ImageView ivAvatar;
        TextView tvName;
        TextView tvPhoneNumber;
    }

    @NonNull
    @Override
    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public int getResource() {
        return resource;
    }

    public void setResource(int resource) {
        this.resource = resource;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }
}
