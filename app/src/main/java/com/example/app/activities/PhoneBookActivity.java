package com.example.app.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.app.R;
import com.example.app.adapters.ContactApdapter;
import com.example.app.models.Contact;
import com.example.app.utils.PermissionUtils;

import java.util.ArrayList;
import java.util.List;

public class PhoneBookActivity extends AppCompatActivity {
    private List<Contact> contacts;
    private ArrayAdapter<Contact> contactArrayAdapter;

    private EditText edtName;
    private EditText edtPhoneNumber;
    private RadioButton rbtnMale;
    private RadioButton rbtnFemale;
    private Button btnSave;
    private ListView lvContacts;

    private void initComponent(){
        edtName = findViewById(R.id.edtName);
        edtPhoneNumber = findViewById(R.id.edtPhoneNumber);
        rbtnMale = findViewById(R.id.rbtnMale);
        rbtnFemale = findViewById(R.id.rbtnFemale);
        btnSave = findViewById(R.id.btnSave);
        lvContacts = findViewById(R.id.lvContacts);

        contacts = new ArrayList<>();
        contactArrayAdapter = new ContactApdapter(PhoneBookActivity.this, R.layout.item_contact_listview, contacts);
        lvContacts.setAdapter(contactArrayAdapter);
        lvContacts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showConfirmDialog(position);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_book);
        initComponent();
    }

    public void addContact(View view){
        if(view.getId() == R.id.btnSave){
            Contact contact = new Contact();
            String name = edtName.getText().toString();
            if(TextUtils.isEmpty(name)){
                Toast.makeText(PhoneBookActivity.this, "Please input name!", Toast.LENGTH_LONG);
                return;
            }else{
                contact.setName(name);
            }
            String phoneNumber = edtPhoneNumber.getText().toString();
            if(TextUtils.isEmpty(phoneNumber)){
                Toast.makeText(PhoneBookActivity.this, "Please input phonenumber!", Toast.LENGTH_LONG);
                return;
            }else{
                contact.setPhoneNumber(phoneNumber);
            }

            if(rbtnMale.isChecked()){
                contact.setGender("Male");
            }else if(rbtnFemale.isChecked()){
                contact.setGender("Female");
            }

            contacts.add(contact);
            contactArrayAdapter.notifyDataSetChanged();
        }
    }

    public void showConfirmDialog(int position){
        Dialog dialog = new Dialog(PhoneBookActivity.this);
        dialog.setContentView(R.layout.custom_dialog);
        TextView tvConfirm = (TextView) dialog.findViewById(R.id.tvConfirm);
        tvConfirm.setText("Do you want to call or send message " + contacts.get(position).getName() + "?");

        Button btnCall = (Button) dialog.findViewById(R.id.btnCall);
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PermissionUtils.askForPermission(PhoneBookActivity.this, Manifest.permission.CALL_PHONE);
                if(PermissionUtils.checkPermission(PhoneBookActivity.this, Manifest.permission.CALL_PHONE)){
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:"+contacts.get(position).getPhoneNumber()));
                    startActivity(intent);
                }
            }
        });

        Button btnSendMessage = (Button) dialog.findViewById(R.id.btnSendMessage);
        btnSendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PermissionUtils.askForPermission(PhoneBookActivity.this, Manifest.permission.SEND_SMS);
                if(PermissionUtils.checkPermission(PhoneBookActivity.this, Manifest.permission.SEND_SMS)){
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:"+contacts.get(position).getPhoneNumber()));
//                    intent.setAction(Intent.ACTION_SEND);
//                    intent.setData(Uri.parse("tel:"+contacts.get(position).getPhoneNumber()));
                    startActivity(intent);
                }
            }
        });

        dialog.show();
    }
}