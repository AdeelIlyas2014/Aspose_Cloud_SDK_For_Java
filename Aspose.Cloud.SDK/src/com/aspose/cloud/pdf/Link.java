/**
 * 
 */
package com.aspose.cloud.pdf;
import java.lang.String;
/**
 * @author Mudassir
 *
 */
/// <summary>
/// represents a single Pdf Link in document
/// </summary>

public class Link
{
    public Link() { }

    private LinkActionType actionType;
    private String action;
    private LinkHighlightingMode highlighting;
    private Color color;

    public LinkActionType getLinkActionType(){return actionType;}
    public LinkHighlightingMode getLinkHighlightingMode(){return highlighting;}
    public Color getColor(){return color;}
    public String getAction(){return action;}
    
    
}