import org.junit.Test;

import java.lang.annotation.Annotation;

public class TestClass implements TestInterface {
    @Test
    public static void metoda1() {
    }

    @Test
    public static void metoda2() {
        throw new RuntimeException("A crapat");
    }

    @Test
    public static void metoda3() {
        throw new RuntimeException("Segmentation fault :')");
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
