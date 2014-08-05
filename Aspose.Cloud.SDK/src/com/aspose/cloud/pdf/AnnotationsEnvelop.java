/**
 * 
 */
package com.aspose.cloud.pdf;
import java.util.List;

/**
 * @author Mudassir
 *
 */
/// <summary>
/// represents container part of the Annotations resource response
/// </summary>
public  class AnnotationsEnvelop
{
    private List<LinkResponse> links;
    private List<Annotation> list;
    
    public List<LinkResponse> getLinkResponseList(){return links;}
    public List<Annotation> getAnnotationList(){return getList();}
	public List<Annotation> getList() {
		return list;
	}
	public void setList(List<Annotation> _list) {
		list = _list;
	}
    

}
