package app;

import java.text.DateFormatSymbols;
import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ResourceBundle;

public class LocaleCommand
{
    private static Locale locale;
    private static ResourceBundle resourceBundle;
    private static final String name = "Messages";

    /**
     * <p> Functia ia proprietatea unei comenzi din bundle-ul Messages si in functie de aceasta va formata parametri. </p>
     * @param key comanda apelata si cautata in bundle
     * @param arguments argumentele necesare pentru comanda respectiva
     * @return mesajul de apelare a functiei pentru comanda instantiata
     */
    public static String message(String key, String ... arguments) {
        String commandName = resourceBundle.getString(key);
        String msg = new MessageFormat(commandName).format(arguments);
        return msg;
    }

    /* seteaza limba si in functie de aceasta va apela bundle-ul corespunzator */
    public static void setLocale(String language) {
        LocaleCommand.locale = Locale.forLanguageTag(language);
        LocaleCommand.resourceBundle = ResourceBundle.getBundle(name, locale);
        message("locale.set", language);
    }

    /* afiseaza rezultatul comenzii */
    public static void displayLocales() {
        System.out.println(LocaleCommand.message("locales"));
        for (Locale locale : Locale.getAvailableLocales())
        {
            System.out.println(locale.toString());
        }
    }

    public static void localeInfo() {
        System.out.println(LocaleCommand.message("locale.set",LocaleCommand.getLocale().getDisplayName()));
        DateFormatSymbols date = DateFormatSymbols.getInstance(LocaleCommand.getLocale());
        System.out.println(LocaleCommand.getLocale().getCountry());
        System.out.println(LocaleCommand.getLocale().getLanguage());
        for (String i : date.getWeekdays()) {
            System.out.print(i + ' ');
        }
        System.out.println();
        for (String i : date.getMonths()) {
            System.out.print(i + ' ');
        }
        System.out.println();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("DD/MMM/YYYY", LocaleCommand.getLocale());
        LocalDateTime presentTime = LocalDateTime.now();
        System.out.println(dateFormat.format(presentTime));
    }

    public static Locale getLocale()
    {
        return LocaleCommand.locale;
    }
}