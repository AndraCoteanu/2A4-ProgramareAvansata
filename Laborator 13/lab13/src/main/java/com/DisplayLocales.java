package com;

import app.LocaleCommand;

public class DisplayLocales {
    public DisplayLocales()
    {
        LocaleCommand.displayLocales();
    }
}

//import java.util.Locale;
//public class DisplayLocales {
//    Locale availableLocales[];
//
//    public DisplayLocales(){
//        this.availableLocales = Locale.getAvailableLocales();
//        System.out.println("Locales: ");
//        for(Locale locale :this.availableLocales){
//            System.out.println(locale.getDisplayName());
//        }
//    }
//}
