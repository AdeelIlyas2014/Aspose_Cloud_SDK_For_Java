/**
 * 
 */
package com.aspose.cloud.pdf;

import java.lang.String;
import java.util.List;
/**
 * @author Mudassir
 *
 */
/// <summary>
/// represents a single text item
/// </summary>
public class TextItem
{
    public TextItem() { }

    private List<LinkResponse> links;
    public List<LinkResponse> getLinks(){return links;}
    public void setLinks(List<LinkResponse> links){this.links=links;}

    private TextFormat format;
    private String text;
    
    public TextFormat getTextFormat(){return format;}
    public String getText(){return text;}

}