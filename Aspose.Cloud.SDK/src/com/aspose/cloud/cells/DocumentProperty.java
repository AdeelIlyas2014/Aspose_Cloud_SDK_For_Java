package com.aspose.cloud.cells;
import java.lang.String;

public class DocumentProperty
    {
        public DocumentProperty()
        {
        }

        public DocumentProperty(String propName, String propValue)
        {
            name = propName;
            value = propValue;
        }

        private LinkResponse link ;
        private String name ;
        private String value;
        private boolean builtIn ;
        
        
        public LinkResponse getLink(){return link;}
        public boolean getIsBuiltIn(){return builtIn;}
        public String getName(){return name;}
        public String getValue(){return value;}

        public void setIsBuiltIn(boolean BuiltIn){ this.builtIn=BuiltIn;}
        public void setName(String Name ){ this.name=Name;}
        public void setValue(String Value){ this.value=Value;}


    }