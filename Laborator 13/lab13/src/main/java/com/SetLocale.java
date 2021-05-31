package com;

import app.LocaleCommand;

public class SetLocale {
    public SetLocale(String languageTag) {
        LocaleCommand.setLocale(languageTag);
    }
}