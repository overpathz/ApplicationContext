package com.pathz.appcontext.app.context;

import io.github.classgraph.ClassGraph;
import io.github.classgraph.ClassInfo;
import io.github.classgraph.ScanResult;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class ApplicationContext {

    private Map<String, Object> context;
    private final String scanningPackageName;

    public ApplicationContext(String scanningPackageName) {
        this.scanningPackageName = scanningPackageName;
        this.context = resolveComponents();
    }

    public Object getComponent(String componentName) {
        return context.get(componentName);
    }

    public <T> T getComponent(String componentName, Class<T> requiredType) {
        return (T) getComponent(componentName);
    }

    public List<Object> getPresentComponents() {
        return new ArrayList<>(context.values());
    }

    public Map<String, Object> resolveComponents() {
        Set<String> classNames = new HashSet<>();
        Map<String, Object> components = new HashMap<>();

        try (ScanResult scanResult = new ClassGraph()
                .whitelistPackages(scanningPackageName)
                .scan()) {
            for (ClassInfo classInfo : scanResult.getAllClasses()) {
                classNames.add(classInfo.getName());
            }
        }

        for (String className: classNames) {
            try {
                Object obj = Class.forName(className).getConstructor().newInstance();

                if (obj.getClass().isAnnotationPresent(Component.class)) {
                    String beanName = obj.getClass().getAnnotation(Component.class).name();
                    components.put(beanName, obj);
                }

            } catch (ClassNotFoundException | NoSuchMethodException |
                    IllegalAccessException | InstantiationException |
                    InvocationTargetException e) {
                e.printStackTrace();
            }
        }

        return components;

    }
}
