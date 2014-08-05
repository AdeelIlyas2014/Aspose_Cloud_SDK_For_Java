package com.aspose.cloud.cells;
import java.util.List;

public class DataSort
    {
        public DataSort()
        { 
        
        }

        private boolean caseSensitive ;
        private boolean hasHeaders ;
        private boolean sortLeftToRight ;
        private List <SortKey> keyList ;
        
        
        public boolean getCaseSensitive(){return caseSensitive;}
        public boolean getHasHeaders(){return hasHeaders;}
        public boolean getSortLeftToRight(){return sortLeftToRight;}
        public List <SortKey> getKeyList(){return keyList;}

		public void setCaseSensitive(boolean CaseSensitive) { this.caseSensitive = CaseSensitive; }
		public void setHasHeaders(boolean HasHeaders) { this.hasHeaders = HasHeaders; }
		public void setSortLeftToRight(boolean SortLeftToRight) { this.sortLeftToRight = SortLeftToRight; }
		public void setKeyList(List<SortKey> KeyList) { this.keyList = KeyList; }
    }