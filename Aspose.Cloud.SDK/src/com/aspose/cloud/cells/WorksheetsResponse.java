package com.aspose.cloud.cells;
import java.util.List;

    /// <summary>
    ///  Represents response from the worksheets resource
    /// </summary>
    public class WorksheetsResponse extends com.aspose.cloud.common.BaseResponse
    {

        private List<Worksheet> worksheetList;
        private LinkResponse link ;
        
        public List<Worksheet> getWorksheetList(){return worksheetList;}
        public LinkResponse getLink(){return link;}

    }