package ru.ssau;

import org.junit.Assert;
import org.junit.Test;
import ru.ssau.singleton.PropertiesLoader;
import java.io.PrintWriter;
import java.util.Properties;

/**
 * Created by Вячеслав on 18.02.2018.
 */
public class SingletonTest extends Assert {

    @Test
    public void singletonTest() {
        assertEquals(PropertiesLoader.getInstance(), PropertiesLoader.getInstance());
    }

    @Test
    public void printPropertiesTest() {
        Properties properties = PropertiesLoader.getInstance().getProperties();
        properties.list(new PrintWriter(System.out, true));
        assertNotNull(properties);
    }
}
