package com.aspose.cloud.cells;
import java.util.List;

    /// <summary>
    ///  Represents response from the Charts resource
    /// </summary>
    public class ChartsResponse extends com.aspose.cloud.common.BaseResponse
    {        
        private LinkResponse link ;

        private List<LinkResponse> chartList ;

        private Chart chart ;
        
        public LinkResponse getlink() {return link;}

        public List<LinkResponse> getChartList(){return chartList;}

        public Chart getChart(){return chart;}

    }