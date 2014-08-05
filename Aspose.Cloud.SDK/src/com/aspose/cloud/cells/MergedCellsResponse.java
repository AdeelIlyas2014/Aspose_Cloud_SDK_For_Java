package com.aspose.cloud.cells;
import java.util.List;

    /// <summary>
    ///  Represents response from the MergedCells resource
    /// </summary>
    public class MergedCellsResponse extends com.aspose.cloud.common.BaseResponse
    {      
        private LinkResponse link ;
        private int count ;
        private List<LinkResponse> mergedCellList ;
        private MergedCell mergedCell ;
        
        public LinkResponse getlink(){return link;}
        public int getCount(){return count;}
        public List<LinkResponse> getMergedCellList(){return mergedCellList;}
        public MergedCell getMergedCell(){return mergedCell;}

    }