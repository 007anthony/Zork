package ch.bbw.zork;

import ch.bbw.zork.annotation.CommandHandler;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.annotation.Annotation;
import java.util.Arrays;

public class Reflection {

    private ClassLoader classLoader;

    public Reflection() {
        classLoader = ClassLoader.getSystemClassLoader();
    }

    public Class[] getClassesFromPackage(String packageName) {
        InputStream inputStream = classLoader.getResourceAsStream(packageName.replaceAll("[.]", "/"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        return reader.lines()
                .filter(line -> line.endsWith(".class"))
                .map(line -> {
                    try {
                        return classLoader.loadClass(packageName + "." + line.substring(0, line.lastIndexOf(".")));
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                })
                .toArray(Class[]::new);
    }

    public Class[] getClassesWithAnnotation(String packageName, Class<? extends Annotation> annotation) {
        Class[] classes = this.getClassesFromPackage(packageName);
        return Arrays.stream(classes).filter(c -> c.getAnnotation(annotation) != null).toArray(Class[]::new);
    }
}
