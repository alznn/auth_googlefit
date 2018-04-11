/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.watchmen;

/**
 *
 * @author hp
 */
public class config{
    private String  urlstr = "host";
    private String userStr= "USR";
    private String pwStr= "PWD";
    private String DBname ="DB name"; 

   public void setDBname(String DBname) {
        this.DBname = DBname;
    }
   
   public String getDBname() {
        return DBname;
    }

    public String getUrlstr() {
        return urlstr;
    }

    public void setUrlstr(String urlstr) {
        this.urlstr = urlstr;
    }

    public void setUserStr(String userStr) {
        this.userStr = userStr;
    }

    public void setPwStr(String pwStr) {
        this.pwStr = pwStr;
    }

    public String getUserStr() {
        return userStr;
    }

    public String getPwStr() {
        return pwStr;
    }
}