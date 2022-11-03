package com.threadlocal;

import java.util.List;

/**
 * @ClassName ThreadLocalUtil
 * @Description 测试threadLocal
 * @Author kider
 * @Date 2021/8/28 12:24
 * @Version 1.0
 **/
public class ThreadLocalUtil {

    private static final ThreadLocal<List<String>> threadLocal = new ThreadLocal<>();

    private static final InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();

    public static List<String> getThreadLocal() {
        return threadLocal.get();
    }

    public static void setThreadLocal(List<String> str) {
        threadLocal.set(str);
    }

    public static void removeThreadLocal() {
        threadLocal.remove();
    }

    public static String getInheritableThreadLocal() {
        return inheritableThreadLocal.get();
    }

    public static void setInheritableThreadLocal(String str) {
        inheritableThreadLocal.set(str);
    }

    public static void removeInheritableThreadLocal() {
        inheritableThreadLocal.remove();
    }
}
