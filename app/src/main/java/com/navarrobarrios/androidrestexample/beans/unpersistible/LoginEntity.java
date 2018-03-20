package com.navarrobarrios.androidrestexample.beans.unpersistible;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ${Navarro} on 12/1/17.
 */

public class LoginEntity extends ErrorEntity{
    //region Varibles
    @SerializedName("name")
    private String name;
    @SerializedName("lastname")
    private String lastname;
    //endregion

    //region Constructor's
    public LoginEntity() {
        super();
    }

    public LoginEntity(String name, String lastname) {
        super();
        this.name = name;
        this.lastname = lastname;
    }
    //endregion

    //region Setter's & Getter's
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    //endregion
}
