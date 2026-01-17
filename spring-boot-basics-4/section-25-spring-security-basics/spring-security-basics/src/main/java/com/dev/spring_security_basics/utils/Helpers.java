package com.dev.spring_security_basics.utils;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.security.web.FilterChainProxy;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Helpers {

    // printContextBeans
    public static void printContextBeans(AnnotationConfigApplicationContext context) {
        AtomicInteger count = new AtomicInteger(1);

        System.out.println("-----------------------------------------------");
        System.out.println("Context Beans (Instantiated Beans Marked):");

        Arrays.stream(context.getBeanDefinitionNames())
                .forEach(beanName -> {
                    String beanStatus = isBeanAlreadyInitialized(context, beanName) ? "INSTANTIATED" : "NOT INSTANTIATED";
                    System.out.printf("%d. %s [%s]%n", count.getAndIncrement(), beanName, beanStatus);
                });

        System.out.println("-----------------------------------------------");
    }

    // isBeanAlreadyInitialized
    private static boolean isBeanAlreadyInitialized(AnnotationConfigApplicationContext context, String beanName) {
        try {
            return context.getBeanFactory().containsSingleton(beanName);
        } catch (Exception e) {
            return false;
        }
    }

    // printSecurityFilters
    public static void printSecurityFilters(FilterChainProxy filterChainProxy) {
        AtomicReference<Integer> counter = new AtomicReference<>(1);

            System.out.println("-----------------------------------------------");
            System.out.println("Registered Security Filters: " + filterChainProxy.getFilterChains().getFirst().getFilters().size() + " items.");
            filterChainProxy.getFilterChains().forEach(chain -> {
                chain.getFilters().forEach(filter -> {
                    String[] filterFullName = filter.getClass().getName().split("\\.");
                    String filterName = filterFullName[filterFullName.length - 1];
                    String counterStr = counter.get().toString();

                    String idx = counter.get() < 10 ? "0" + counterStr : counterStr;

                    System.out.println(idx + ". " + filterName);

                    counter.set(counter.get() + 1);

                });
            });
            System.out.println("-----------------------------------------------");

    }

    // printMemoryUsage
    public static void printMemoryUsage() {
        Runtime runtime = Runtime.getRuntime();

        long maxMemory = runtime.maxMemory(); // Maximum memory the JVM can use
        long allocatedMemory = runtime.totalMemory(); // Memory currently allocated to the JVM
        long freeMemory = runtime.freeMemory(); // Free memory within the allocated memory

        System.out.println("-----------------------------------------------");
        System.out.println("Memory Usage:");
        System.out.printf("Max Memory: %.2f MB%n", maxMemory / 1024.0 / 1024.0);
        System.out.printf("Allocated Memory: %.2f MB%n", allocatedMemory / 1024.0 / 1024.0);
        System.out.printf("Free Memory (In Allocated): %.2f MB%n", freeMemory / 1024.0 / 1024.0);
        System.out.printf("Used Memory: %.2f MB%n", (allocatedMemory - freeMemory) / 1024.0 / 1024.0);
        System.out.println("-----------------------------------------------");
    }
}
