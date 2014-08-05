package com.aspose.cloud.cells;
import java.lang.String;

public class Cell
    {
        /// <summary>
        /// Cell Class Default Constructor
        /// </summary>
        public Cell()
        {
            
        }
       
        private LinkResponse link ;
        private String name ;
        private String type ;
        private int row ;
        private int column ;
        private String value ;
        private String formula ;
        private boolean isFormula ;
        private boolean isMerged ;  
        
        
        public LinkResponse getlink(){return link;}
        public String getName(){return name;}
        public String getType(){return type;}
        public int getRow(){return row;}
        public int getColumn(){return column;}
        public String getValue(){return value;}
        public String getFormula(){return formula;}
        public boolean getIsFormula(){return isFormula;}
        public boolean getIsMerged(){return isMerged;}

    }
