package com.aspose.cloud.cells;
import java.util.List;

    /// <summary>
    ///  Represents response from the Pictures resource
    /// </summary>
    public class PicturesResponse extends com.aspose.cloud.common.BaseResponse
    {
        
        private LinkResponse link;
        private List<LinkResponse> pictureList;
        private Picture picture;
        
        public LinkResponse getLink(){return link;}
        public List<LinkResponse> getPictureList(){return pictureList;}
        public Picture getPicture(){return picture;}

    }