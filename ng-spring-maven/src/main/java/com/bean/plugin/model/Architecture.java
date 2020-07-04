package com.bean.plugin.model;

public enum Architecture {
    x86, x64, ppc64le, s390x, arm64, armv7l;

    public static Architecture guess() {
        String arch = System.getProperty("os.arch");
        String version = System.getProperty("os.version");

        if (arch.equals("ppc64le")) {
            return ppc64le;
        } else if (arch.equals("aarch64")) {
            return arm64;
        } else if (arch.equals("s390x")) {
            return s390x;
        } else if (arch.equals("arm") && version.contains("v7")) {
            return armv7l;
        } else {
            return arch.contains("64") ? x64 : x86;
        }
    }
}