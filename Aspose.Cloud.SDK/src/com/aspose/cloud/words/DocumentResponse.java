package com.aspose.cloud.words;

    public class DocumentResponse extends com.aspose.cloud.common.BaseResponse
    {
        /// <summary>
        /// Document Properties response
        /// </summary>
    	private DocumentPropertiesResponse documentProperties;
    	public DocumentPropertiesResponse getDocumentProperties(){return documentProperties;}
    	public void setDocumentProperties(DocumentPropertiesResponse documentProperties){this.documentProperties=documentProperties;}


        /// <summary>
        /// Document Property response
        /// </summary>
    	private DocumentProperty documentProperty;
    	public DocumentProperty getDocumentProperty(){return documentProperty;}
    	public void setDocumentProperty(DocumentProperty documentProperty){this.documentProperty=documentProperty;}

    }