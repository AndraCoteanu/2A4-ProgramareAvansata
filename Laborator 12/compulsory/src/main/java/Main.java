import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws MalformedURLException, ClassNotFoundException {
        int testPassed = 0;
        int testFailed = 0;
        String path = "E:/[FII] Facultate/[JAVA] Programare Avansata/BANG/target/classes/AboutUs";
        ClassLoader classLoader = new ClassLoader();
        File pathClass = new File(path);
        URL urlClasa = null;
        if (pathClass.exists()) {
             urlClasa = pathClass.toURI().toURL();
        }
        classLoader.addURL(urlClasa);

        for (Method metodaInClasa : classLoader.loadClass("TestClass").getMethods()) {
            if (metodaInClasa.isAnnotationPresent(TestClass.class)) {
                try {
                    metodaInClasa.invoke(null);
                    testPassed++;
                } catch (Throwable ex) {
                    System.out.printf("Test %s failed: %s %n", metodaInClasa, ex.getCause());
                    testFailed++;
                }
            }
        }
        System.out.printf("Passed: %d\nFailed %d\n", testPassed, testFailed);
    }
}
