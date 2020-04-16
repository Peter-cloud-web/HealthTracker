
package com.moringa.healthtrackerapp.Models;

import java.util.List;
import com.google.gson.annotations.SerializedName;

import org.parceler.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Login {

    @SerializedName("email")
    private List<String> mEmail;
    @SerializedName("password")
    private List<String> mPassword;

    public List<String> getEmail() {
        return mEmail;
    }

    public void setEmail(List<String> email) {
        mEmail = email;
    }

    public List<String> getPassword() {
        return mPassword;
    }

    public void setPassword(List<String> password) {
        mPassword = password;
    }

}
