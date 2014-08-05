package com.aspose.cloud.cells;
import java.lang.String;

public class Column
    {
        /// <summary>
        /// Column Class Default Constructor
        /// </summary>
        public Column()
        {
            
        }
       
        private LinkResponse link ;
        private String index ;
        private int groupLevel ;
        private double width ;
        private boolean isHidden ;       
        
        public LinkResponse getlink(){return link;}
        public String getIndex(){return index;}
        public int getGroupLevel(){return groupLevel;}
        public double getWidth(){return width;}
        public boolean getIsHidden(){return isHidden;}    

    }