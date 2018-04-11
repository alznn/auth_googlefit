/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.watchmen;

import com.google.gson.Gson;

/**
 *
 * @author hp
 */
public class Decode {

    public class Steps {

        public long minStartTimeNs;
        public long maxEndTimeNs;
        public String dataSourceId;
        public Point point[];

        public class Point {

            public String modifiedTimeMillis;
            public String startTimeNanos;
            public String endTimeNanos;
            public Value value[];
            public String dataType;

            public class Value {

                public int intVal;
                public int mapVal[];
            }
        }
    }
}
