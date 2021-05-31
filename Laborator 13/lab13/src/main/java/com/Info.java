package com;

import app.LocaleCommand;

public class Info {
    public Info()
    {
        LocaleCommand.localeInfo();
    }
}

//
//import java.text.DateFormatSymbols;
//import java.text.SimpleDateFormat;
//import java.util.Currency;
//import java.util.Locale;
//
//public class Info {
//    private String country;
//    private String language;
//
//    public Info(String country, String language) {
//        this.country = country;
//        this.language = language;
//    }
//
//    public void showCurrentLocale() {
//        Locale myLocale = new Locale(this.country, this.language);
//        Currency currency = Currency.getInstance(Locale.forLanguageTag(myLocale.getCountry()));
//        String[] weekDays = new DateFormatSymbols(Locale.forLanguageTag(myLocale.getCountry())).getWeekdays();
//        SimpleDateFormat D = new SimpleDateFormat("F", Locale.forLanguageTag(myLocale.getCountry()));
//        SimpleDateFormat M = new SimpleDateFormat("M", Locale.forLanguageTag(myLocale.getCountry()));
//        SimpleDateFormat Y = new SimpleDateFormat("y", Locale.forLanguageTag(myLocale.getCountry()));
//        System.out.println("Country: " + myLocale.getCountry());
//        System.out.println("Language: " + myLocale.getLanguage());
//        System.out.println("Currency: " + currency);
//        for (int i = 0; i < weekDays.length; i++) {
//            System.out.println(weekDays[i] + ",");
//        }
//        System.out.println("Today is: " + D + " " + M + " " + Y);    }
//}
