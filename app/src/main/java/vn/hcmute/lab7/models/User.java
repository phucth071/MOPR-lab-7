package vn.hcmute.lab7.models;

import androidx.databinding.Bindable;
import androidx.databinding.BaseObservable;

import java.io.Serializable;

import vn.hcmute.lab7.BR;

public class User implements Serializable {
    private String firstName;
    private String lastName;

    public User() {
    }
    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
