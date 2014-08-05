package com.aspose.cloud.cells;
import java.lang.String;

public class SortKey
    {
        public SortKey()
        { 
        
        }

        private int key;
        private String sortOrder;
        
        public int getKey(){return key;}
        public String getSortOrder(){return sortOrder;}

		public void setKey(int Key) { this.key = Key; }
		public void setSortOrder(String SortOrder) { this.sortOrder = SortOrder; }
    }