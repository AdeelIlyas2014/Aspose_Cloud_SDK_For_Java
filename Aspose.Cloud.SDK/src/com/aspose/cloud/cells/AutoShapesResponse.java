package com.aspose.cloud.cells;
import java.util.List;

    /// <summary>
    /// Represents response from the Autoshape resource
    /// </summary>
    public class AutoShapesResponse extends com.aspose.cloud.common.BaseResponse
    {
       
        private LinkResponse link ;
                
        private List<LinkResponse> autoShapeList ;

        private AutoShape autoShape ;
        
        
        public LinkResponse getlink(){return link;}
        
        public List<LinkResponse> getAuotShapeList(){return autoShapeList;}
        
        public AutoShape getAutoShape(){return autoShape;}
    }