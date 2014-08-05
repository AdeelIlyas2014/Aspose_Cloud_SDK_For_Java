package com.aspose.cloud.cells;
import java.lang.String;

public class Row
    {
        /// <summary>
        /// Row Class Default Constructor
        /// </summary>
        public Row()
        {
            
        }
       
        private LinkResponse link ;
        private String index ;
        private int groupLevel ;
        private double height ;
        private boolean isHidden ;
        private boolean isBlank ;
        private boolean isHeightMatched ;       

        public LinkResponse getLink(){return link;}
        public String getIndex(){return index;}
        public int getGroupLevel(){return groupLevel;}
        public double getHeight(){return height;}
        public boolean getIsHidden(){return isHidden;}
        public boolean getIsBlank(){return isBlank;}
        public boolean getIsHeightMatched(){return isHeightMatched;}
    }