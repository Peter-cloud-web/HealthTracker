
package com.moringa.healthtrackerapp.Models;

import java.util.List;
import com.google.gson.annotations.SerializedName;

import org.parceler.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Register {
    public Register(List<String> mAdress, List<String> mConfirmedPassword, List<String> mContact, List<String> mEmail, List<String> mFirstName, List<String> mLastName, List<String> mPassword, List<String> mRole, List<String> mUsername) {
        this.mAdress = mAdress;
        this.mConfirmedPassword = mConfirmedPassword;
        this.mContact = mContact;
        this.mEmail = mEmail;
        this.mFirstName = mFirstName;
        this.mLastName = mLastName;
        this.mPassword = mPassword;
        this.mRole = mRole;
        this.mUsername = mUsername;
    }

    @SerializedName("adress")
    private List<String> mAdress;
    @SerializedName("confirmed_password")
    private List<String> mConfirmedPassword;
    @SerializedName("contact")
    private List<String> mContact;
    @SerializedName("email")
    private List<String> mEmail;
    @SerializedName("first_name")
    private List<String> mFirstName;
    @SerializedName("last_name")
    private List<String> mLastName;
    @SerializedName("password")
    private List<String> mPassword;
    @SerializedName("role")
    private List<String> mRole;
    @SerializedName("username")
    private List<String> mUsername;

    public List<String> getAdress() {
        return mAdress;
    }

    public void setAdress(List<String> adress) {
        mAdress = adress;
    }

    public List<String> getConfirmedPassword() {
        return mConfirmedPassword;
    }

    public void setConfirmedPassword(List<String> confirmedPassword) {
        mConfirmedPassword = confirmedPassword;
    }

    public List<String> getContact() {
        return mContact;
    }

    public void setContact(List<String> contact) {
        mContact = contact;
    }

    public List<String> getEmail() {
        return mEmail;
    }

    public void setEmail(List<String> email) {
        mEmail = email;
    }

    public List<String> getFirstName() {
        return mFirstName;
    }

    public void setFirstName(List<String> firstName) {
        mFirstName = firstName;
    }

    public List<String> getLastName() {
        return mLastName;
    }

    public void setLastName(List<String> lastName) {
        mLastName = lastName;
    }

    public List<String> getPassword() {
        return mPassword;
    }

    public void setPassword(List<String> password) {
        mPassword = password;
    }

    public List<String> getRole() {
        return mRole;
    }

    public void setRole(List<String> role) {
        mRole = role;
    }

    public List<String> getUsername() {
        return mUsername;
    }

    public void setUsername(List<String> username) {
        mUsername = username;
    }

    @Override
    public String toString() {
        return "Register{" +
                "mAdress=" + mAdress +
                ", mConfirmedPassword=" + mConfirmedPassword +
                ", mContact=" + mContact +
                ", mEmail=" + mEmail +
                ", mFirstName=" + mFirstName +
                ", mLastName=" + mLastName +
                ", mPassword=" + mPassword +
                ", mRole=" + mRole +
                ", mUsername=" + mUsername +
                '}';
    }
}
