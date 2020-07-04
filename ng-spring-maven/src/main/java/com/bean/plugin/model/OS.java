package com.bean.plugin.model;

public enum OS {
    Windows, Mac, Linux, SunOS;

    public static OS guess() {
        final String osName = System.getProperty("os.name");
        return osName.contains("Windows") ? OS.Windows :
                osName.contains("Mac") ? OS.Mac :
                        osName.contains("SunOS") ? OS.SunOS :
                                OS.Linux;
    }

    public String getArchiveExtension() {
        if (this == OS.Windows) {
            return "zip";
        } else {
            return "tar.gz";
        }
    }

    public String getCodename() {
        if (this == OS.Mac) {
            return "darwin";
        } else if (this == OS.Windows) {
            return "win";
        } else if (this == OS.SunOS) {
            return "sunos";
        } else {
            return "linux";
        }
    }
}