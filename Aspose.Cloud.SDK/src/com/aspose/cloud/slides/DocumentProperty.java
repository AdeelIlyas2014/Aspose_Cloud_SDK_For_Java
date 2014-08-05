/**
 * 
 */
package com.aspose.cloud.slides;
/**
 * @author Mudassir
 *
 */
/// <summary>
/// represents a single property of the document
/// </summary>
public class DocumentProperty
{
    public DocumentProperty() { }

 //   public List<LinkResponse> Links;
    private boolean builtIn;
    private String name;
    private String value;
    
    public boolean getIsBuiltIn(){return builtIn;}
    public String getName(){return name;}
    public String getValue(){return value;}

    public void setIsBuiltIn(boolean temBuiltIn){ builtIn=temBuiltIn;}
    public void setName(String temName){ name=temName;}
    public void setValue(String temValue){ 
    	value=temValue;}

}