package com.example.OutilDeTests;

import junit.framework.TestCase;
import org.junit.Test;
import java.util.Date;

/**
 * Created by eleves on 16-05-26.
 */
public class DateUtilTest extends TestCase {

    @Test
    public void testDateToString()
    {
        String expectedValue = "2016-05-26 16:30:16";

        Date date = new Date();
        date.setYear(116);
        date.setMonth(04);
        date.setDate(26);
        date.setHours(16);
        date.setMinutes(30);
        date.setSeconds(16);

        String convertedValue = DateUtil.dateToString(date);
        assertEquals("Converted value is different than expected value", expectedValue, convertedValue);
    }
}
