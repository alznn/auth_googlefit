/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.watchmen;

import com.google.gson.Gson;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author hp
 */
public class Database {

    public void Decoder(String entity, String day) throws SQLException {
        String dataSource;
        String sttime;
        String edtime;
        int intValue;
        String str;
        String UserID;
        String pw;

        //Date sd = new Date(1486807002917L);
        //  Date ed = new Date(1486807757568L);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS");
        Gson gson = new Gson();
        Decode.Steps step = gson.fromJson(entity, Decode.Steps.class);
        for (int i = 0; i < step.point.length; i++) {

            dataSource = step.dataSourceId;

            sttime = step.point[i].startTimeNanos;
            edtime = step.point[i].endTimeNanos;
            sttime = sttime.substring(0, 13);
            edtime = edtime.substring(0, 13);
            long st = Long.parseLong(sttime, 10);
            long ed = Long.parseLong(edtime, 10);
            String sdateStr = sdf.format(st).substring(0,19);
            String edateStr = sdf.format(ed).substring(0,19);
            String date = sdateStr.substring(0, 10);

            intValue = step.point[i].value[0].intVal;
            System.out.println("s: " + sdateStr);
            System.out.println("e: " + edateStr);
            System.out.println("v: " + intValue);
            System.out.println("d: " + date);
            insert(dataSource,sdateStr,edateStr,intValue,"gftest@gmail.com",date,day);

        }
        System.out.println(step.point.length);
    }

    public static void insert(String dataSource, String sttime, String edtime, int intValue, String UserID,String date,String day) throws SQLException {
        MySQLConnector step_sql = new MySQLConnector("Host", "USR", "PWD", "DB name");
        step_sql.connectDB();
        // device_sql.updateQuery("delete from activities_heart where id =" + id );                                                                                                                                                                                                                                               //values('" +dateTime +"',"+"'"+ restingHeartRate + "',"                                                       
        step_sql.updateQuery("insert into Activity_Detail(User_ID,ID_Activity,DateTime,DataSource,StartTime,EndTime,Value,Frequency,UpdateTime)"
                + " values('" + UserID + "', '" + "Steps" + "', '" + date+ "', '" + dataSource + "', '" + sttime + "','" + edtime + "','" + intValue + "','" + "minute" + "','" + day + "');");
        step_sql.close();
        System.out.println("data done");
        return;
    }
}
