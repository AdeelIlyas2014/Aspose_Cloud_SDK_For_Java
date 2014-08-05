package com.aspose.cloud.words;
import java.util.List;

    public class DocumentPropertiesResponse
    {
        public DocumentPropertiesResponse() { }

        /// <summary>
        /// Link Response related to document properties
        /// <link href="http://api.saaspose.com/v1.0/words/TestProperties.doc/documentProperties/Author" rel="self" />
        /// </summary>
        private LinkResponse link ;
        private List<DocumentProperty> list;
        
        public LinkResponse getlink(){return link;} 
        public List<DocumentProperty> getList(){return list;}
        
        public void setlink (LinkResponse link){this.link=link;}
        public void setList(List<DocumentProperty> List){this.list=List;}
    }