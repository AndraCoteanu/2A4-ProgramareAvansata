package app;


import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;
import java.util.Scanner;

public class LocaleExplore {
    Properties command = new Properties();

    public void run() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, IOException {
        command.load(this.getClass().getClassLoader().getResourceAsStream("command.properties"));
        LocaleCommand.setLocale("en-US");
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.print(LocaleCommand.message("prompt"));
            String com = scan.nextLine();
            if (com.equals("exit")) break;
            String[] params = com.trim().split("\\s+");
            switch (params[0]) {
                case "locales" : {
                    Class cls = Class.forName(command.getProperty("display-locale.impl"));
                    cls.getConstructor().newInstance();
                    break;
                }
                case "set" : {
                    Class cls = Class.forName(command.getProperty("set-locale.impl"));
                    cls.getConstructor(String.class).newInstance(params[1]);
                    break;
                }
                case "info" : {
                    Class cls = Class.forName(command.getProperty("info-locale.impl"));
                    cls.getConstructor().newInstance();
                    break;
                }
                default : System.out.println(LocaleCommand.message("invalid"));
            }
        }
    }


    public static void main(String args[]) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, IOException {
        new LocaleExplore().run();
    }
}