package com.aspose.cloud.words;

public class DocumentLink {
	private String href ;
	private String rel ;
	private Object type ;
	private Object title ;
    
    public String getHref(){return href;}
    public String getRel(){return rel;}
    public Object getType(){return type;}
    public Object getTitle(){return title;}
    
    public void setHref(String href) {this.href=href;}
    public void setRel(String Rel) {this.rel=Rel;}
    public void setType (Object Type) {this.type=Type;}
    public void setTitle(Object Title) {this.title=Title;}
}
