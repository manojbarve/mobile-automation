package com.bdd.mobile.base;

/*
 * This class has the data information related to app
 */

public class AppData {
    public static String platform = System.getProperty("platform", "android");
    public static String useGesturePlugin = System.getProperty("useGesturePlugin", "true");
    public static String chromeAutoDownloadDriver = System.getProperty("chromeAutoDownloadDriver", "false");


}
//mvn clean test -Dplatform=android312412