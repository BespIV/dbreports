package com.dbreports;
import com.dbreports.utils.Debugger;
import com.dbreports.utils.RandomUtil;

public class TestUtil {
    public static void main(String[] args) {
        RandomUtil randomString = new RandomUtil();
        for (int i=0; i<300; i++){
            Debugger.out("testutil", randomString.getRandomString(6));
            Debugger.out("testutil", randomString.getRandomInteger(6));
            Debugger.out("testutil", randomString.getRandomDate(2019));
        }
    }
}
