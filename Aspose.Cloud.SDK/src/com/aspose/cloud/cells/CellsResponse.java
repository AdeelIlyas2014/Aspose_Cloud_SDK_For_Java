package com.aspose.cloud.cells;
import java.util.List;

    /// <summary>
    ///  Represents response from the Cells resource
    /// </summary>
    public class CellsResponse extends com.aspose.cloud.common.BaseResponse
    {
        
        private LinkResponse link ;
        private int cellCount ;               
        private List<LinkResponse> cellList ;
        private int maxRow ;
        private int maxColumn ;
        private Cell cell ;
        private Style style ;
        
        public LinkResponse getlink(){return link;}
        public int getCellCount(){return cellCount;}               
        public List<LinkResponse> getCellList(){return cellList;}
        public int getMaxRow(){return maxRow;}
        public int getMaxColumn(){return maxColumn;}
        public Cell getCell(){return cell;}
        public Style getStyle(){return style;}
        
        
    }