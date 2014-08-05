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
/// represents a single property of the document
/// </summary>
public class DocumentProperty {
	
    public DocumentProperty() { }

 /*   public List<LinkResponse> Links;
    public boolean BuiltIn;
    public String Name ;
    public String Value ;
*/
    private boolean builtIn;
    private String name ;
    private String value ;

    public boolean getIsBuiltIn(){return builtIn;}
    public String getName(){return name;}
    public String getValue(){return value;}

    public void setIsBuiltIn(boolean BuiltIn){ this.builtIn=BuiltIn;}
    public void setName(String Name ){ this.name=Name;}
    public void setValue(String Value){ this.value=Value;}

   
}
