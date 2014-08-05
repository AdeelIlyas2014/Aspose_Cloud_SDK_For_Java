package com.aspose.cloud.pdf;

public class PdfDocument {
	private LinkResponse[] links;
	public LinkResponse[] getLinks(){return links;}
	public void setLinks(LinkResponse[] Links){this.links=Links;}

	private DocumentPropertiesEnvelop documentProperties;
	public DocumentPropertiesEnvelop getDocumentProperties(){return documentProperties;}
	public void setDocumentProperties(DocumentPropertiesEnvelop DocumentProperties){this.documentProperties=DocumentProperties;}

	private PagesEnvelop pages;
	public PagesEnvelop getPages(){return pages;}
	public void setPages(PagesEnvelop Pages){this.pages=Pages;}

}
