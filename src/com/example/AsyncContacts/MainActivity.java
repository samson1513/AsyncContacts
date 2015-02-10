package com.example.AsyncContacts;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class MainActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    private ListView lvContacts;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        lvContacts = (ListView)findViewById(R.id.lvContacts);
        try {
            prepareContactsList();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void prepareContactsList() throws ExecutionException, InterruptedException {
        ArrayList<ContObj> contObjs = getArrayCont();
        ContListAdapter contListAdapter = new ContListAdapter(this,contObjs);
        lvContacts.setAdapter(contListAdapter);
    }

    public ArrayList<ContObj> getArrayCont() throws ExecutionException, InterruptedException {
        ContactsAsync contactsAsync = new ContactsAsync(this);
        contactsAsync.execute();
        return contactsAsync.get();

    }
}
