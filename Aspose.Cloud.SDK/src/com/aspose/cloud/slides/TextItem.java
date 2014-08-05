/**
 * 
 */
package com.aspose.cloud.slides;
import java.lang.String;
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

    private String text; 
    private ShapeURI uri;
    
    public String getText(){return text;}
    public ShapeURI getUri(){return uri;}
}