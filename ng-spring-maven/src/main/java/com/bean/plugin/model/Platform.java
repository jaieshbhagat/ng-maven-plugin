package com.bean.plugin.model;

public class Platform {

    public static OS os;
    public static Architecture architecture;

    static {
        OS os = OS.guess();
        Architecture architecture = Architecture.guess();
    }

    public Platform(OS os, Architecture architecture) {
        Platform.os = os;
        Platform.architecture = architecture;
    }

    public static String getArchiveExtension() {
        return os.getArchiveExtension();
    }

    public static String getCodename() {
        return os.getCodename();
    }

    public static boolean isWindows() {
        return os == OS.Windows;
    }

    public static boolean isMac() {
        return os == OS.Mac;
    }

}