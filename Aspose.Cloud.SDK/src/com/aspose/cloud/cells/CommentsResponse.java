package com.aspose.cloud.cells;
import java.util.List;

    /// <summary>
    ///  Represents response from the Comments resource
    /// </summary>
    public class CommentsResponse extends com.aspose.cloud.common.BaseResponse
    {        
        private LinkResponse link ;
        private List<LinkResponse> commentList ;
        private Comment comment ;
        
        public LinkResponse getlink(){return link;}
        public List<LinkResponse> getCommentList(){return commentList;}
        public Comment getComment(){return comment;}
    }