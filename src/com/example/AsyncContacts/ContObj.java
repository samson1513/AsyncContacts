package com.example.AsyncContacts;

/**
 * Created by samson on 04.02.2015.
 */
public class ContObj {

    private String mName;
    private String mPhone;

    public ContObj(String _name, String _phone){
        this.mName = _name;
        this.mPhone = _phone;
    }
    public String getmName() {
        return mName;
    }
    public String getmPhone() {
        return mPhone;
    }
    public void setmName(String mName) {
        this.mName = mName;
    }
    public void setmPhone(String mPhone) {
        this.mPhone = mPhone;
    }
}
