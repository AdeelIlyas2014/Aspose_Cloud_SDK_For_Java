package com.aspose.cloud.cells;
import java.util.List;

    /// <summary>
    ///  Represents response from the Column resource
    /// </summary>
    public class ColumnsResponse extends com.aspose.cloud.common.BaseResponse
    {
        
        private LinkResponse link ;
        private int maxColumn ;
        private List<LinkResponse> columnsList ;
        private Column column ;
        
        public LinkResponse getlink(){return link;}
        public int getMaxColumn(){return maxColumn;}
        public List<LinkResponse> getColumnsList(){return columnsList;}
        public Column getColumn(){return column;}
       
    }