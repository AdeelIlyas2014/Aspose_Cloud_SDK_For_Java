package com.aspose.cloud.cells;
import java.util.List;

    /// <summary>
    ///  Represents response from the Rows resource
    /// </summary>
    public class RowsResponse extends com.aspose.cloud.common.BaseResponse
    {
        
        private LinkResponse link;
        private int rowCount;               
        private List<LinkResponse> rowsList;
        private Row row;
        
        public LinkResponse getLink(){return link;}
        public int getRowCount(){return rowCount;}               
        public List<LinkResponse> getRowsList(){return rowsList;}
        public Row getRow(){return row;}
       
    }