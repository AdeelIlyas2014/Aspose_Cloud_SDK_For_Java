package com.aspose.cloud.cells;
import java.util.List;

    /// <summary>
    ///  Represents response from the TextItems resource
    /// </summary>
    public class TextItemsResponse
    {
        public TextItemsResponse() { }       
        private LinkResponse link;     
        private List<TextItem> textItemList;
        
        public LinkResponse getLink(){return link;}   
        public List<TextItem> getTextItemList(){return textItemList;}
        
        
    }