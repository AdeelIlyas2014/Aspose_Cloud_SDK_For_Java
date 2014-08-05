package com.aspose.cloud.words;

    public class DocumentProperty 
    {
        public DocumentProperty() { }

        /// <summary>
        /// Resource BuiltIn Property
        /// </summary>
        private Boolean builtIn;
        public Boolean getBuiltIn(){return builtIn;}
        public void setBuiltIn(Boolean BuiltIn){this.builtIn=BuiltIn;}
        /// <summary>
        /// Resource Name Property
        /// </summary>
        private String name;
        public String getName(){return name;}
        public void setName(String Name){this.name=Name;}

        /// <summary>
        /// Resource Value Property
        /// </summary>
        private String value;
        public String getValue(){return value;}
        public void setValue(String Value){this.value=Value;}


        /// <summary>
        /// Link Response related to document properties
        /// <link href="http://api.saaspose.com/v1.0/words/TestProperties.doc/documentProperties/Author" rel="self" />
        /// </summary>
        private LinkResponse link;
        public LinkResponse getlink(){return link;}
        public void setlink(LinkResponse link){this.link=link;}


        public DocumentProperty(String propName, String propValue)
        {
            name = propName;
            value = propValue;
        }
    }