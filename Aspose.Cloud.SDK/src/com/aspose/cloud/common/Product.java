package com.aspose.cloud.common;

import java.lang.String;
/**
 * @author Mudassir
 *
 */
public class Product {
    /// <summary>
    /// this property represents the base product uri i.e. http://api.saaspose.com/v1.0
    /// you can set this property according to the current version you're using
    /// </summary>
    private static String baseProductUri;
    
    public static String getBaseProductUri(){return baseProductUri;}
    
    public static void setBaseProductUri(String temBaseProductUri){ baseProductUri=temBaseProductUri;}
    
}
