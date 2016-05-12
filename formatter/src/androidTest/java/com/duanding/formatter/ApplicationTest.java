package com.duanding.formatter;

import android.app.Application;
import android.test.ApplicationTestCase;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }

//    public void testInsertionFormatter(){
//        InsertionFormatter inf = new InsertionFormatter(" ","399998");
//        assertEquals("123 456", inf.format("123456"));
//    }

    public void testMoneyFormatter(){
        MoneyFormatter mf = new MoneyFormatter();
        assertEquals("112,123,122,313",mf.format("112123122313"));
    }
}