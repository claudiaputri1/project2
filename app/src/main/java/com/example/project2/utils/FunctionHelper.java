package com.example.project2.utils;

import android.text.format.DateFormat;

import java.util.Date;
import java.text.DecimalFormat;
import java.util.Calendar;

public class FunctionHelper {

    public static String rupiahFormat(int price) {
        DecimalFormat formatter = new DecimalFormat("#,###");
        return "Rp " + formatter.format(price).replaceAll(",", ".");
    }

    public static String getToday() {
        Date date = Calendar.getInstance().getTime();
        return (String) DateFormat.format("d MMM yyyy", date);
    }
}