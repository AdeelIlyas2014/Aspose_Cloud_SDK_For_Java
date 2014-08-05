package com.aspose.cloud.common;


import java.lang.String;
/**
 * @author Mudassir
 *
 */
public class AsposeApp {
    /// <summary>
    /// Represents AppSID for the app.
    /// </summary>
    private static String appSID;
    /// <summary>
    /// Represnts the AppKey for the app.
    /// </summary>
    private static String appKey;
    
    public static String getAppSID(){return appSID;}
    public static String getAppKey(){return appKey;}
    public static void setAppSID(String _appSID){ appSID=_appSID;}
    public static void setAppKey(String _appKey){ appKey=_appKey;}
    public static void setAppInfo(String _appKey, String _appSID)
    {
    	appSID=_appSID;
    	appKey=_appKey;
    }

}
