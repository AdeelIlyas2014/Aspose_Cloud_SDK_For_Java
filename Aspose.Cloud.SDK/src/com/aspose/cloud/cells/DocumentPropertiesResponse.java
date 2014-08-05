package com.aspose.cloud.cells;
import java.util.List;

    /// <summary>
    ///  Represents response from the Document Properties resource
    /// </summary>
    public class DocumentPropertiesResponse 
    {
        public DocumentPropertiesResponse() { }
               
        private LinkResponse link ;
        private List<DocumentProperty> documentPropertyList ;
        
        public LinkResponse getLink(){return link;}
        public List<DocumentProperty> getDocumentPropertyList(){return documentPropertyList;}
    }