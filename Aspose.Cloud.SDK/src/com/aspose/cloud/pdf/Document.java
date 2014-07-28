/**
 * 
 */
package com.aspose.cloud.pdf;

import java.io.InputStream;
import java.security.SignatureException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aspose.cloud.common.AsposeAppNonStatic;
import com.aspose.cloud.common.BaseResponse;
import com.aspose.cloud.common.Product;
import com.aspose.cloud.common.Utils;
import com.aspose.cloud.exceptions.AuthorizationException;
import com.aspose.cloud.exceptions.CommonIOException;
import com.aspose.cloud.exceptions.ParameterMissingException;
import com.google.gson.Gson;

/**
 * @author Mudassir
 * 
 */
public class Document {
	// / <summary>
	// / PDF document name
	// / </summary>
	private AsposeAppNonStatic auth;
	public String FileName;

	public Document(String fileName) {
		FileName = fileName;
	}

	public Document(String fileName, AsposeAppNonStatic auth) {
		this(fileName);
		this.auth = auth;
	}

	// / <summary>
	// / Gets the page count of the specified PDF document
	// / </summary>
	// / <returns>page count</returns>
	public int GetPageCount() {
			// build URI to get page count

			String strURI = Product.getBaseProductUri() + "/pdf/" + FileName
					+ "/Pages";
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("Document.GetPageCount: Please Specify AppKey and AppSID");

				} else {
					signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.Sign(strURI);
			}

			InputStream responseStream = Utils.ProcessCommand(signedURI, "GET");

			String strJSON = Utils.StreamToString(responseStream);

			Gson gson = new Gson();

			// Parse the json string to JObject
			PagesResponse pagesResponse = gson.fromJson(strJSON,
					PagesResponse.class);

			int count = pagesResponse.getPages().getList().size();
			return count;
	}

	// / <summary>
	// / Gets all the properties of the specified document
	// / </summary>
	// / <returns>list of properties</returns>
	public List<DocumentProperty> GetDocumentProperties() {

			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/pdf/" + FileName
					+ "/documentProperties";
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("Document.GetDocumentProperties: Please Specify AppKey and AppSID");

				} else {
					signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.Sign(strURI);
			}

			InputStream responseStream = Utils.ProcessCommand(signedURI, "GET");

			String strJSON = Utils.StreamToString(responseStream);

			Gson gson = new Gson();

			DocumentPropertiesResponse documentPropertiesResponse = gson
					.fromJson(strJSON, DocumentPropertiesResponse.class);

			return documentPropertiesResponse.getDocumentProperties().getList();

	}

	// / <summary>
	// / Gets the value of a particular property
	// / </summary>
	// / <param name="propertyName"></param>
	// / <returns>value of the specified property</returns>
	public DocumentProperty GetDocumentProperty(String propertyName) {

			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/pdf/" + FileName
					+ "/documentProperties/" + propertyName;
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("Document.GetDocumentProperty: Please Specify AppKey and AppSID");

					
				} else {
					signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.Sign(strURI);
			}
			InputStream responseStream = Utils.ProcessCommand(signedURI, "GET");

			String strJSON = Utils.StreamToString(responseStream);

			Gson gson = new Gson();

			// Parse the json string to JObject
			DocumentPropertyResponse documentPropertyResponse = gson.fromJson(
					strJSON, DocumentPropertyResponse.class);

			return documentPropertyResponse.getDocumentProperty();

	}

	// / <summary>
	// / Sets the value of a particular property
	// / </summary>
	// / <param name="propertyName"></param>
	// / <param name="propertyValue"></param>
	// / <returns></returns>
	public boolean SetDocumentProperty(String propertyName, String propertyValue)
			throws SignatureException, CommonIOException {

		// build URI to get page count
		String strURI = Product.getBaseProductUri() + "/pdf/" + FileName
				+ "/documentProperties/" + propertyName;
		String signedURI = "";
		if (this.auth != null) {
			if (!this.auth.validateAuth()) {
				System.out.println("Please Specify AppKey and AppSID");
				throw new AuthorizationException("Document.SetDocumentProperty: Please Specify AppKey and AppSID");

				
			} else {
				signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
						this.auth.getAppSID());
			}
		} else {
			signedURI = Utils.Sign(strURI);
		}
		// serialize the JSON request content
		DocumentProperty docProperty = new DocumentProperty();
		docProperty.setValue(propertyValue);

		String strJSON = "";

		Gson gson = new Gson();

		strJSON = gson.toJson(docProperty, DocumentProperty.class);

		InputStream responseStream = Utils.ProcessCommand(signedURI, "PUT",
				strJSON);

		String strResponse = Utils.StreamToString(responseStream);

		// Parse the json string to JObject
		DocumentPropertyResponse baseResponse = gson.fromJson(strResponse,
				DocumentPropertyResponse.class);

		if (baseResponse.getCode().equals("200")
				& baseResponse.getStatus().equals("OK"))
			return true;
		else
			return false;
	}

	// / <summary>
	// / removes values of all the properties
	// / </summary>
	// / <returns></returns>
	public boolean RemoveAllProperties() throws SignatureException {

			// throw new Exception("Resource removeAll throws exception");

			// with POST following exception
			// throw new
			// Exception("Exception received: The remote server returned an error: (405) Method Not Allowed");
			// if GET works then documentation needs to be updated

			// with GET following exception
			// The remote server returned an error: (400) Bad Request

			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/pdf/" + FileName
					+ "/documentProperties";
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("Document.RemoveAllProperties: Please Specify AppKey and AppSID");

				} else {
					signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.Sign(strURI);
			}

			InputStream responseStream = Utils.ProcessCommand(signedURI,
					"DELETE");

			String strResponse = Utils.StreamToString(responseStream);

			Gson gson = new Gson();
			// Parse the json string to JObject
			BaseResponse baseResponse = gson.fromJson(strResponse,
					BaseResponse.class);

			if (baseResponse.getCode().equals("200")
					& baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;

	}

	// /////
	// / <summary>
	// / Gets the form field count
	// / </summary>
	// / <returns>count of the form fields</returns>
	public int GetFormFieldCount() {

			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/pdf/" + FileName
					+ "/fields";
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("Document.GetFormFieldCount: Please Specify AppKey and AppSID");

				} else {
					signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.Sign(strURI);
			}

			InputStream responseStream = Utils.ProcessCommand(signedURI, "GET");

			String strJSON = Utils.StreamToString(responseStream);

			Gson gson = new Gson();

			// Parse the json string to JObject and Deserializes the JSON to a
			// object.
			FormFieldsResponse formFieldsResponse = gson.fromJson(strJSON,
					FormFieldsResponse.class);

			return formFieldsResponse.getFields().getList().size();

	}

	// / <summary>
	// / Gets list of all the fields in the PDF file
	// / </summary>
	// / <returns>list of the form fields</returns>
	public List<FormField> GetFormFields() {

			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/pdf/" + FileName
					+ "/fields";
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("Document.GetFormFields: Please Specify AppKey and AppSID");

				} else {
					signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.Sign(strURI);
			}

			InputStream responseStream = Utils.ProcessCommand(signedURI, "GET");

			String strJSON = Utils.StreamToString(responseStream);

			Gson gson = new Gson();

			// Parse the json string to JObject and Deserializes the JSON to a
			// object.
			FormFieldsResponse formFieldsResponse = gson.fromJson(strJSON,
					FormFieldsResponse.class);

			return formFieldsResponse.getFields().getList();

	}

	// / <summary>
	// / Gets a particular form field
	// / </summary>
	// / <param name="fieldName"></param>
	// / <returns>form field</returns>
	public FormField GetFormField(String fieldName) {


			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/pdf/" + FileName
					+ "/fields/" + fieldName;
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("Document.GetFormField: Please Specify AppKey and AppSID");

				} else {
					signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.Sign(strURI);
			}

			InputStream responseStream = Utils.ProcessCommand(signedURI, "GET");

			String strJSON = Utils.StreamToString(responseStream);

			Gson gson = new Gson();

			// Parse the json string to JObject and Deserializes the JSON to a
			// object.
			FormFieldResponse formFieldResponse = gson.fromJson(strJSON,
					FormFieldResponse.class);

			return formFieldResponse.getFormField();
	}

	// / <summary>
	// / Creates a Pdf from XML
	// / </summary>
	// / <param name="pdfFileName"></param>
	// / <param name="xsltFileName"></param>
	// / <param name="xmlFileName"></param>
	// / <returns></returns>
	public boolean CreateFromXml(String pdfFileName, String xsltFileName,
			String xmlFileName) {

			String strURI = Product.getBaseProductUri() + "/pdf/" + pdfFileName
					+ "?templateFile=" + xsltFileName + "&dataFile="
					+ xmlFileName + "&templateType=xml";

			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("Document.CreateFromXml: Please Specify AppKey and AppSID");

				} else {
					signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.Sign(strURI);
			}

			InputStream responseStream = Utils.ProcessCommand(signedURI, "PUT");

			String strJSON = Utils.StreamToString(responseStream);

			Gson gson = new Gson();

			// Parse the json string to JObject and Deserializes the JSON to a
			// object.
			BaseResponse baseResponse = gson.fromJson(strJSON,
					BaseResponse.class);

			if (baseResponse.getCode().equals("200")
					&& baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;


	}

	// / <summary>
	// / Creates a Pdf from HTML
	// / </summary>
	// / <param name="pdfFileName"></param>
	// / <param name="htmlFileName"></param>
	// / <returns></returns>
	public boolean CreateFromHtml(String pdfFileName, String htmlFileName) {

			String strURI = Product.getBaseProductUri() + "/pdf/" + pdfFileName
					+ "?templateFile=" + htmlFileName + "&templateType=html";
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("Document.CreateFromHtml: Please Specify AppKey and AppSID");

				} else {
					signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.Sign(strURI);
			}

			InputStream responseStream = Utils.ProcessCommand(signedURI, "PUT");

			String strJSON = Utils.StreamToString(responseStream);

			Gson gson = new Gson();

			// Parse the json string to JObject and Deserializes the JSON to a
			// object.
			BaseResponse baseResponse = gson.fromJson(strJSON,
					BaseResponse.class);

			if (baseResponse.getCode().equals("200")
					&& baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;


	}

	// / <summary>
	// / Creates an Empty Pdf document
	// / </summary>
	// / <param name="newDocumentName"></param>
	// / <returns></returns>

	public boolean CreateEmptyPdf(String newDocumentName) {

			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/pdf/"
					+ newDocumentName;
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("Document.CreateEmptyPdf: Please Specify AppKey and AppSID");

				} else {
					signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.Sign(strURI);
			}

			InputStream responseStream = Utils.ProcessCommand(signedURI, "PUT");

			String strJSON = Utils.StreamToString(responseStream);

			Gson gson = new Gson();

			// Parse the json string to JObject and Deserializes the JSON to a
			// object.
			BaseResponse baseResponse = gson.fromJson(strJSON,
					BaseResponse.class);

			if (baseResponse.getCode().equals("200")
					&& baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;


	}

	// / <summary>
	// / Merge two or more Pdf documents. A new pdf file will be generated.
	// / </summary>
	// / <param name="sourceFiles"></param>
	// / <returns></returns>

	public boolean MergeDocuments(List<String> sourceFiles) {

			// New PDF Filename
			String mergedFileName = FileName;

			if (sourceFiles.isEmpty())
				throw new ParameterMissingException("File to merge are not specified");

			if (sourceFiles.size() < 2)
				throw new ParameterMissingException("Two or more files are requred to merge");

			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/pdf/"
					+ mergedFileName + "/merge";
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("Document.MergeDocuments: Please Specify AppKey and AppSID");

				} else {
					signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.Sign(strURI);
			}

			Map<String, Object> mp = new HashMap<String, Object>();
			mp.put("List", sourceFiles);

			Gson jsonlist = new Gson();
			String jsondata = jsonlist.toJson(mp);

			InputStream responseStream = Utils.ProcessCommand(signedURI, "PUT",
					jsondata, "json");

			// further process JSON response
			String strJSON = Utils.StreamToString(responseStream);

			Gson gson = new Gson();

			// Parse the json string to JObject and Deserializes the JSON to a
			// object.
			BaseResponse baseResponse = gson.fromJson(strJSON,
					BaseResponse.class);

			if (baseResponse.getCode().equals("200")
					&& baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;


	}

	// / <summary>
	// / Appends two Pdf documents. The newPdf is appended at the end of basePdf
	// / </summary>
	// / <param name="basePdf"></param>
	// / <param name="newPdf"></param>
	// / <returns></returns>

	public boolean AppendDocument(String basePdf, String newPdf) {

			// Saving Exisiting File name
			String sOldFile = FileName;

			// Getting Total page in PDF
			FileName = newPdf;
			int iPageCount = GetPageCount();

			// Setting Old File name again
			FileName = sOldFile;

			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/pdf/" + basePdf
					+ "/appendDocument?appendFile=" + newPdf
					+ "&startPage=1&endPage=" + Integer.toString(iPageCount);
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("Document.AppendDocument: Please Specify AppKey and AppSID");

				} else {
					signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.Sign(strURI);
			}

			InputStream responseStream = Utils
					.ProcessCommand(signedURI, "POST");

			// further process JSON response
			String strJSON = Utils.StreamToString(responseStream);

			Gson gson = new Gson();

			// Parse the json string to JObject and Deserializes the JSON to a
			// object.
			BaseResponse baseResponse = gson.fromJson(strJSON,
					BaseResponse.class);

			if (baseResponse.getCode().equals("200")
					&& baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;


	}

	// / <summary>
	// / Appends two Pdf documents. The start and end pages number newPdf is
	// given and it is appended at the end of basePdf
	// / </summary>
	// / <param name="basePdf"></param>
	// / <param name="newPdf"></param>
	// / <param name="startPage"></param>
	// / <param name="endPage"></param>
	// / <returns></returns>

	public boolean AppendDocument(String basePdf, String newPdf, int startPage,
			int endPage) {


			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/pdf/" + basePdf
					+ "/appendDocument/?appendFile=" + newPdf + "&startPage="
					+ Integer.toString(startPage) + "&endPage="
					+ Integer.toString(endPage);
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("Document.AppendDocument: Please Specify AppKey and AppSID");

				} else {
					signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.Sign(strURI);
			}

			InputStream responseStream = Utils
					.ProcessCommand(signedURI, "POST");

			// further process JSON response
			String strJSON = Utils.StreamToString(responseStream);

			Gson gson = new Gson();

			// Parse the json string to JObject and Deserializes the JSON to a
			// object.
			BaseResponse baseResponse = gson.fromJson(strJSON,
					BaseResponse.class);

			if (baseResponse.getCode().equals("200")
					&& baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;


	}

	// / <summary>
	// / Adds new page to opened Pdf document
	// / </summary>
	// / <returns></returns>

	public boolean AddNewPage() {


			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/pdf/" + FileName
					+ "/pages";
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("Document.AddNewPage: Please Specify AppKey and AppSID");

				} else {
					signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.Sign(strURI);
			}

			InputStream responseStream = Utils.ProcessCommand(signedURI, "PUT");

			// further process JSON response
			String strJSON = Utils.StreamToString(responseStream);

			Gson gson = new Gson();

			// Parse the json string to JObject and Deserializes the JSON to a
			// object.
			BaseResponse baseResponse = gson.fromJson(strJSON,
					BaseResponse.class);

			if (baseResponse.getCode().equals("200")
					&& baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;

	}

	// / <summary>
	// / Deletes selected page in Pdf document
	// / </summary>
	// / <param name="pageNumber"></param>
	// / <returns></returns>

	public boolean DeletePage(int pageNumber) {

			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/pdf/" + FileName
					+ "/pages/" + Integer.toString(pageNumber);
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("Document.DeletePage: Please Specify AppKey and AppSID");

				} else {
					signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.Sign(strURI);
			}
			InputStream responseStream = Utils.ProcessCommand(signedURI,
					"DELETE");

			// further process JSON response
			String strJSON = Utils.StreamToString(responseStream);

			Gson gson = new Gson();

			// Parse the json string to JObject and Deserializes the JSON to a
			// object.
			BaseResponse baseResponse = gson.fromJson(strJSON,
					BaseResponse.class);

			if (baseResponse.getCode().equals("200")
					&& baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;

	}

	// / <summary>
	// / Moves selected page in Pdf document to new location
	// / </summary>
	// / <param name="pageNumber"></param>
	// / <param name="newLocation"></param>
	// / <returns></returns>
	public boolean MovePage(int pageNumber, int newLocation) {
			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/pdf/" + FileName
					+ "/pages/" + Integer.toString(pageNumber)
					+ "/movePage?newIndex=" + Integer.toString(newLocation);
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("Document.MovePage: Please Specify AppKey and AppSID");

				} else {
					signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.Sign(strURI);
			}

			InputStream responseStream = Utils
					.ProcessCommand(signedURI, "POST");

			// further process JSON response
			String strJSON = Utils.StreamToString(responseStream);

			Gson gson = new Gson();

			// Parse the json string to JObject and Deserializes the JSON to a
			// object.
			BaseResponse baseResponse = gson.fromJson(strJSON,
					BaseResponse.class);

			if (baseResponse.getCode().equals("200")
					&& baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;
	}

	// / <summary>
	// / Replace Image in PDF File using Local Image Stream
	// / </summary>
	// / <param name="pageNumber"></param>
	// / <param name="imageIndex"></param>
	// / <param name="imageStream"></param>
	// / <returns></returns>
	public boolean ReplaceImageUsingStream(int pageNumber, int imageIndex,
			InputStream imageStream) {
			// build URI to replace image
			String strURI = Product.getBaseProductUri() + "/pdf/" + FileName
					+ "/pages/" + pageNumber + "/images/" + imageIndex;

			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("Document.ReplaceImageUsingStream: Please Specify AppKey and AppSID");

				} else {
					signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.Sign(strURI);
			}

			InputStream responseStream = Utils.ProcessCommand(signedURI,
					"POST", imageStream);

			// further process JSON response
			String strJSON = Utils.StreamToString(responseStream);

			Gson gson = new Gson();

			// Parse the json string to JObject and Deserializes the JSON to a
			// object.
			BaseResponse baseResponse = gson.fromJson(strJSON,
					BaseResponse.class);

			if (baseResponse.getCode().equals("200")
					&& baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;

	}

	// / <summary>
	// / Replace Image in PDF document using Image File uploaded on Server
	// / </summary>
	// / <param name="pageNumber"></param>
	// / <param name="imageIndex"></param>
	// / <param name="fileName"></param>
	// / <returns></returns>
	public boolean ReplaceImageUsingFile(int pageNumber, int imageIndex,
			String fileName) {
			// build URI to replace image
			String strURI = Product.getBaseProductUri() + "/pdf/" + FileName
					+ "/pages/" + pageNumber + "/images/" + imageIndex
					+ "?imageFile=" + fileName;

			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("Document.ReplaceImageUsingFile: Please Specify AppKey and AppSID");

				} else {
					signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.Sign(strURI);
			}

			InputStream responseStream = Utils
					.ProcessCommand(signedURI, "POST");

			// further process JSON response
			String strJSON = Utils.StreamToString(responseStream);

			Gson gson = new Gson();

			// Parse the json string to JObject and Deserializes the JSON to a
			// object.
			BaseResponse baseResponse = gson.fromJson(strJSON,
					BaseResponse.class);

			if (baseResponse.getCode().equals("200")
					&& baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;
	}
	public PdfDocument GetDocument()
	{ 
			// check whether file is set or not
			if (FileName.equals(""))
				throw new ParameterMissingException("No file name specified");

			// build URI
			String strURI = Product.getBaseProductUri()  + "/pdf/" + FileName;


			// sign URI
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("Document.GetDocument: Please Specify AppKey and AppSID");

				} else {
					signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.Sign(strURI);
			}

			InputStream responseStream = Utils.ProcessCommand(signedURI, "GET");

			String strJSON = Utils.StreamToString(responseStream);

			Gson gson = new Gson();

			DocumentResponse docResponse = gson.fromJson(strJSON,
					DocumentResponse.class);

			return docResponse.getDocument();
	
	}

	public boolean InsertFormField(FormField formField)
	{
			// check whether file is set or not
			if (FileName.equals(""))
				throw new ParameterMissingException("No file name specified");

			// build URI
			String strURI = Product.getBaseProductUri()  + "/pdf/" + FileName + "/fields/"+formField.getName();

			// sign URI
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("Document.InsertFormField: Please Specify AppKey and AppSID");

				} else {
					signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.Sign(strURI);
			}
			Gson gson = new Gson();


			String strJSON = "";
			strJSON = gson.toJson(formField, FormField.class);

			InputStream responseStream = Utils.ProcessCommand(signedURI, "PUT",strJSON);

			String strResponse = Utils.StreamToString(responseStream);

			// Parse the json string to JObject
			BaseResponse baseResponse = gson.fromJson(strResponse,
					BaseResponse.class);

			if (baseResponse.getCode().equals("200")
					& baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;
	
	}
	public boolean InsertFormFields(FormFields formField)
	{
			// check whether file is set or not
			if (FileName.equals(""))
				throw new ParameterMissingException("No file name specified");

			// build URI
			String strURI = Product.getBaseProductUri()  + "/pdf/" + FileName + "/fields";

			// sign URI
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("Document.InsertFormFields: Please Specify AppKey and AppSID");

				} else {
					signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.Sign(strURI);
			}
			Gson gson = new Gson();


			String strJSON = "";
			strJSON = gson.toJson(formField, FormFields.class);

			InputStream responseStream = Utils.ProcessCommand(signedURI, "PUT",strJSON);

			String strResponse = Utils.StreamToString(responseStream);

			// Parse the json string to JObject
			BaseResponse baseResponse = gson.fromJson(strResponse,
					BaseResponse.class);

			if (baseResponse.getCode().equals("200")
					& baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;
	
	}
	public boolean SaveAsTiff(SaveAsTiffOptions imageOptions, String folderName)
	{
			// check whether file is set or not
			if (FileName.equals(""))
				throw new ParameterMissingException("No file name specified");

			// build URI
			String strURI = Product.getBaseProductUri()  + "/pdf/" + FileName + "/SaveAs/tiff?folder=" + folderName;

			// sign URI
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("Document.SaveAsTiff: Please Specify AppKey and AppSID");

				} else {
					signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.Sign(strURI);
			}
			Gson gson = new Gson();


			String strJSON = "";
			strJSON = gson.toJson(imageOptions, SaveAsTiffOptions.class);

			InputStream responseStream = Utils.ProcessCommand(signedURI, "PUT",strJSON);

			String strResponse = Utils.StreamToString(responseStream);

			// Parse the json string to JObject
			BaseResponse baseResponse = gson.fromJson(strResponse,
					BaseResponse.class);

			if (baseResponse.getCode().equals("200")
					& baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;
	
	}
	public boolean SaveAsTiff(String outputFile, String compression, String folderName)
	{
			// check whether file is set or not
			if (FileName.equals(""))
				throw new ParameterMissingException("No file name specified");

			// build URI
			String strURI = Product.getBaseProductUri()  + "/pdf/" + FileName + "/SaveAs/tiff?resultFile=" + outputFile + "&compression=" + compression + "&folder=" + folderName;

			// sign URI
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("Document.SaveAsTiff: Please Specify AppKey and AppSID");

				} else {
					signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.Sign(strURI);
			}
			Gson gson = new Gson();


			//String strJSON = "";
			//strJSON = gson.toJson(imageOptions, SaveAsTiffOptions.class);

			InputStream responseStream = Utils.ProcessCommand(signedURI, "PUT");

			String strResponse = Utils.StreamToString(responseStream);

			// Parse the json string to JObject
			BaseResponse baseResponse = gson.fromJson(strResponse,
					BaseResponse.class);

			if (baseResponse.getCode().equals("200")
					& baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;
	}
	public LinkResponse[] SplitDocument()
	{
			// check whether file is set or not
			if (FileName.equals(""))
				throw new ParameterMissingException("No file name specified");

			// build URI
			String strURI = Product.getBaseProductUri()  + "/pdf/" + FileName + "/split";

			// sign URI
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("Document.SplitDocument: Please Specify AppKey and AppSID");

				} else {
					signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.Sign(strURI);
			}
			Gson gson = new Gson();


			InputStream responseStream = Utils.ProcessCommand(signedURI, "POST");

			String strResponse = Utils.StreamToString(responseStream);

			// Parse the json string to JObject
			SplitPDFResponse PDFResponse = gson.fromJson(strResponse,
					SplitPDFResponse.class);

			return PDFResponse.getResult().getDocuments();
	}
	public LinkResponse[] SplitDocument(int from, int to)
	{
			// check whether file is set or not
			if (FileName.equals(""))
				throw new ParameterMissingException("No file name specified");

			// build URI
			String strURI = Product.getBaseProductUri()   + "/pdf/" + FileName + "/split?from=" + from + "&to=" + to;

			// sign URI
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("Document.SplitDocument: Please Specify AppKey and AppSID");

				} else {
					signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.Sign(strURI);
			}
			Gson gson = new Gson();


			InputStream responseStream = Utils.ProcessCommand(signedURI, "POST");

			String strResponse = Utils.StreamToString(responseStream);

			// Parse the json string to JObject
			SplitPDFResponse PDFResponse = gson.fromJson(strResponse,
					SplitPDFResponse.class);

			return PDFResponse.getResult().getDocuments();
	}
	public LinkResponse[] SplitDocument(int from, int to, SplitDocumentFormat format)
	{
			// check whether file is set or not
			if (FileName.equals(""))
				throw new ParameterMissingException("No file name specified");

			// build URI
			String strURI = Product.getBaseProductUri()   + "/pdf/" + FileName + "/split?from=" + from + "&to=" + to + "&format=" + format.toString();

			// sign URI
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("Document.SplitDocument: Please Specify AppKey and AppSID");

				} else {
					signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.Sign(strURI);
			}
			Gson gson = new Gson();


			InputStream responseStream = Utils.ProcessCommand(signedURI, "POST");

			String strResponse = Utils.StreamToString(responseStream);

			// Parse the json string to JObject
			SplitPDFResponse PDFResponse = gson.fromJson(strResponse,
					SplitPDFResponse.class);

			return PDFResponse.getResult().getDocuments();
	}
	public boolean AddStamp(StampRequest stampRequest)
	{
			// check whether file is set or not
			if (FileName.equals(""))
				throw new ParameterMissingException("No file name specified");

			// build URI
			String strURI = Product.getBaseProductUri()  + "/pdf/" + FileName + "/pages/" + stampRequest.getPageIndex() + "/stamp/";

			// sign URI
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("Document.AddStamp: Please Specify AppKey and AppSID");

				} else {
					signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.Sign(strURI);
			}
			Gson gson = new Gson();
			String strJSON = "";
			strJSON = gson.toJson(stampRequest, StampRequest.class);

			InputStream responseStream = Utils.ProcessCommand(signedURI, "PUT",strJSON);

			String strResponse = Utils.StreamToString(responseStream);

			BaseResponse baseResponse = gson.fromJson(strResponse,								BaseResponse.class);

			if (baseResponse.getCode().equals("200")
					& baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;
	}
	public boolean AddStampWithTextState(StampRequest stampRequest)
	{
			// check whether file is set or not
			if (FileName.equals(""))
				throw new ParameterMissingException("No file name specified");

			// build URI
			String strURI = Product.getBaseProductUri()  + "/pdf/" + FileName + "/pages/" + stampRequest.getPageIndex() + "/stamp/";

			// sign URI
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("Document.AddStampWithTextState: Please Specify AppKey and AppSID");

				} else {
					signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.Sign(strURI);
			}
			Gson gson = new Gson();
			String strJSON = "";
			strJSON = gson.toJson(stampRequest, StampRequest.class);

			InputStream responseStream = Utils.ProcessCommand(signedURI, "PUT",strJSON);

			String strResponse = Utils.StreamToString(responseStream);

			BaseResponse baseResponse = gson.fromJson(strResponse,								BaseResponse.class);

			if (baseResponse.getCode().equals("200")
					& baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;
	}
	
	public int GetTotalWordCount()
	{ 
			// check whether file is set or not
			if (FileName.equals(""))
				throw new ParameterMissingException("No file name specified");

			// build URI
			String strURI = Product.getBaseProductUri() + "/pdf/" + FileName + "/Pages";
			strURI += "/wordCount";
            

			// sign URI
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("Document.GetTotalWordCount: Please Specify AppKey and AppSID");

				} else {
					signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.Sign(strURI);
			}

			InputStream responseStream = Utils.ProcessCommand(signedURI, "GET");

			String strJSON = Utils.StreamToString(responseStream);

			Gson gson = new Gson();

			WordsPerPage wordsResponse = gson.fromJson(strJSON,	WordsPerPage.class);

			 int count = 0;
             for (WordResponse wordResponse : wordsResponse.getWordsPerPage().getList())
                 count += wordResponse.getCount();
             return count;
	}
}
