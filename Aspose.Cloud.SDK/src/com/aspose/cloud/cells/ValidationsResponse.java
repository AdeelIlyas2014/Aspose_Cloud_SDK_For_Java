package com.aspose.cloud.cells;
import java.util.List;

    /// <summary>
    ///  Represents response from the Validations resource
    /// </summary>
    public class ValidationsResponse extends com.aspose.cloud.common.BaseResponse
    {       
        private LinkResponse link;
        private int count;            
        private List<LinkResponse> validationList;
        private Validation validation;
        
        public LinkResponse getLink(){return link;}
        public int getCount(){return count;}            
        public List<LinkResponse> getValidationList(){return validationList;}
        public Validation getValidation(){return validation;};

    }