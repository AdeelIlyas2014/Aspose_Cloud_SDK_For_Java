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
/// represents a single attachment in document
/// </summary>    

public class Attachment
{
    public Attachment() { }

  //  public List<LinkResponse> Links { get; set; }
    private Color color;
    private String mimeType;
    private String name;
    //Consider adding it as Date
    private String creationDate;
    private String modificationDate;
    private int size;
    
    public Color getColor(){return color;}
    public String getMimeType(){return mimeType;}
    public String getName(){return name;}
    public String getCreationDate(){return creationDate;}
    public String getModificationDate(){return modificationDate;}
    public int getAttachmentSize(){return size;}
  
}