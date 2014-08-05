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
/// represents a single annotation in document
/// </summary>

public class Annotation
{
    private Annotation() { }

  //  private List<LinkResponse> Links { get; set; }
    private Color color;
    private String contents;
    
    //Consider it to be of date type
    private String creationDate;
  //  private Date CreationDate;
    private String subject;
    private String title;
    private String modified;
    
    
 //   public Date getCreationDate(){return CreationDate;}
    public String getCreationDate(){return creationDate;}
    public String getContents(){return contents;}
    public String getSubject(){return subject;}
    public String getTitle(){return title;}
    public String getModified(){return modified;}
    public Color getColor(){return color;}
  
  //  public void setCreationDate(String date){ CreationDate=date;}
    public void setContents(String temContents){ contents=temContents;}
    public void setSubject(String temSubject){ subject=temSubject;}
    public void setTitle(String temTitle){ title=temTitle;}
    public void setModified(String temModified){modified=temModified;}
    public void SetColor(Color temColor){ color=temColor;}

}