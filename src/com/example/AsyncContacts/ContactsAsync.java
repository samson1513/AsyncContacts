package com.example.AsyncContacts;

import android.content.Context;
import android.database.Cursor;
import android.os.AsyncTask;
import android.provider.ContactsContract;

import java.util.ArrayList;

/**
 * Created by samson on 04.02.2015.
 */
public class ContactsAsync extends AsyncTask<Void,Void,ArrayList<ContObj>> {

    private Context mContext;

    public ContactsAsync(Context _context){
        mContext = _context;
    }

    @Override
    protected ArrayList<ContObj> doInBackground(Void... params) {

        ArrayList<ContObj> contacts = new ArrayList<ContObj>();
        Cursor cursorContacts = mContext.getContentResolver().query(ContactsContract.Contacts.CONTENT_URI,
                null,
                null,
                null,
                null
        );
        int nameIndex = cursorContacts.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME_PRIMARY);
        while (cursorContacts.moveToNext()){
            String name = cursorContacts.getString(nameIndex);

            String contactId = cursorContacts.getString(cursorContacts.getColumnIndex(ContactsContract.Contacts._ID));

            Cursor cursorPhone = mContext.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                    null,
                    ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = " + contactId,
                    null,
                    null
            );
            int phoneIndex = cursorPhone.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
            String phone = "";
            while (cursorPhone.moveToNext()){
                phone += cursorPhone.getString(phoneIndex);
            }
            cursorPhone.close();

            contacts.add(new ContObj(name,phone));
        }
        cursorContacts.close();

        return contacts;
    }

    @Override
    protected void onPostExecute(ArrayList<ContObj> contObjs) {
        super.onPostExecute(contObjs);
        mContext = null;
    }
}
