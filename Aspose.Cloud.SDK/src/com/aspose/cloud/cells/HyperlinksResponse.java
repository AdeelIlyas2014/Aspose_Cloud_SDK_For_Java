package com.aspose.cloud.cells;
import java.util.List;

    /// <summary>
    ///  Represents response from the Hyperlinks resource
    /// </summary>
    public class HyperlinksResponse extends com.aspose.cloud.common.BaseResponse
    {        
        private LinkResponse link;
        private int count;               
        private List<LinkResponse> hyperlinkList;
        private Hyperlink hyperlink;

        public LinkResponse getlink(){return link;}
        public int getCount(){return count;}               
        public List<LinkResponse> getHyperlinkList(){return hyperlinkList;}  
        public Hyperlink getHyperlink(){return hyperlink;} 
      
    }