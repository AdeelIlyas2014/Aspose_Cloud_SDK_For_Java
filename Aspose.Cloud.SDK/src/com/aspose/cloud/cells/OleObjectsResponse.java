package com.aspose.cloud.cells;
import java.util.List;

    /// <summary>
    ///  Represents response from the OleObjects resource
    /// </summary>
    public class OleObjectsResponse extends com.aspose.cloud.common.BaseResponse
    {        
        private LinkResponse link ;
        private List<LinkResponse> oleOjectList ;
        private OleObject oleObject ;

        public LinkResponse getLink(){return link;}
        public List<LinkResponse> getOleOjectList(){return oleOjectList;}
        public OleObject getOleObject(){return oleObject;}
    }