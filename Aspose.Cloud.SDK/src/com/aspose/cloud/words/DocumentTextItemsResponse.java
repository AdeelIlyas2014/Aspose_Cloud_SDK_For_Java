package com.aspose.cloud.words;
import java.util.List;


    public class DocumentTextItemsResponse 
    {
        public DocumentTextItemsResponse() { }

        /// <summary>
        /// Link Response related to document text
        /// <link href="http://api.saaspose.com/v1.0/words/TestTextItems.doc/textItems" rel="self" />
        /// </summary>
        private LinkResponse link;
        public LinkResponse getlink(){return link;}
        public void setlink(LinkResponse link){this.link=link;}


        /// <summary>
        /// TextItem of document
        /// </summary>
        private List<Paragraph> list;
        public List<Paragraph> getList(){return list;}
        public void setList(List<Paragraph> list){this.list=list;}


    }