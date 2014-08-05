/**
 * 
 */
package com.aspose.cloud.slides;
import java.util.List;
import java.lang.String;
/**
 * @author Mudassir
 *
 */
/// <summary>
/// represents container part of the slides resource response
/// </summary>
public class SlidesEnvelop
{

    private List<String> alternateLinks;
    private List<LinkResponse> links;
    private UriResponse selfUri;
    private List<SlideResponse> slideList;
    
    public List<String> getAlternateLinks(){return alternateLinks;}
    public List<LinkResponse> getLinks(){return links;}
    public List<SlideResponse> getSlideList(){return slideList;}
    public UriResponse getSelfUri(){return selfUri;}
}