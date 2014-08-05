/**
 * 
 */
package com.aspose.cloud.slides;
import java.lang.String;
import java.util.List;
/**
 * @author Mudassir
 *
 */
/// <summary>
/// represents container part of the slides resource response
/// </summary>
public class TextItemsEnvelop
{

    private List<String> alternateLinks;
    private List<ShapeURI> links;
    private UriResponse selfUri;
    private List<TextItem> items;
    
    public  List<String> getAlternateLinks(){return alternateLinks;}
    public  List<ShapeURI> getLinks(){return links;}
    public  List<TextItem> getItems(){return items;}
    public  UriResponse getSelfUri(){return selfUri;}
}