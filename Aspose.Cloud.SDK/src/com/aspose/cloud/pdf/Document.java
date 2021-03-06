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
	public String fileName;

	public Document(String _fileName) {
		fileName = _fileName;
	}

	public Document(String _fileName, AsposeAppNonStatic auth) {
		this(_fileName);
		this.auth = auth;
	}

	// / <summary>
	// / Gets the page count of the specified PDF document
	// / </summary>
	// / <returns>page count</returns>
	public int getPageCount() {
		try {
			// build URI to get page count

			String strURI = Product.getBaseProductUri() + "/pdf/" + fileName
					+ "/Pages";
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
				} else {
					signedURI = Utils.sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.sign(strURI);
			}

			InputStream responseStream = Utils.processCommand(signedURI, "GET");

			String strJSON = Utils.streamToString(responseStream);

			Gson gson = new Gson();

			// Parse the json string to JObject
			PagesResponse pagesResponse = gson.fromJson(strJSON,
					PagesResponse.class);

			int count = pagesResponse.getPages().getList().size();
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	// / <summary>
	// / Gets all the properties of the specified document
	// / </summary>
	// / <returns>list of properties</returns>
	public List<DocumentProperty> getDocumentProperties() {
		try {

			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/pdf/" + fileName
					+ "/documentProperties";
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
				} else {
					signedURI = Utils.sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.sign(strURI);
			}

			InputStream responseStream = Utils.processCommand(signedURI, "GET");

			String strJSON = Utils.streamToString(responseStream);

			Gson gson = new Gson();

			DocumentPropertiesResponse documentPropertiesResponse = gson
					.fromJson(strJSON, DocumentPropertiesResponse.class);

			return documentPropertiesResponse.getDocumentProperties().getList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	// / <summary>
	// / Gets the value of a particular property
	// / </summary>
	// / <param name="propertyName"></param>
	// / <returns>value of the specified property</returns>
	public DocumentProperty getDocumentProperty(String propertyName) {
		try {

			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/pdf/" + fileName
					+ "/documentProperties/" + propertyName;
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
				} else {
					signedURI = Utils.sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.sign(strURI);
			}
			InputStream responseStream = Utils.processCommand(signedURI, "GET");

			String strJSON = Utils.streamToString(responseStream);

			Gson gson = new Gson();

			// Parse the json string to JObject
			DocumentPropertyResponse documentPropertyResponse = gson.fromJson(
					strJSON, DocumentPropertyResponse.class);

			return documentPropertyResponse.getDocumentProperty();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	// / <summary>
	// / Sets the value of a particular property
	// / </summary>
	// / <param name="propertyName"></param>
	// / <param name="propertyValue"></param>
	// / <returns></returns>
	public boolean setDocumentProperty(String propertyName, String propertyValue)
			throws SignatureException {

		// build URI to get page count
		String strURI = Product.getBaseProductUri() + "/pdf/" + fileName
				+ "/documentProperties/" + propertyName;
		String signedURI = "";
		if (this.auth != null) {
			if (!this.auth.validateAuth()) {
				System.out.println("Please Specify AppKey and AppSID");
			} else {
				signedURI = Utils.sign(strURI, this.auth.getAppKey(),
						this.auth.getAppSID());
			}
		} else {
			signedURI = Utils.sign(strURI);
		}
		// serialize the JSON request content
		DocumentProperty docProperty = new DocumentProperty();
		docProperty.setValue(propertyValue);

		String strJSON = "";

		Gson gson = new Gson();

		strJSON = gson.toJson(docProperty, DocumentProperty.class);

		InputStream responseStream = Utils.processCommand(signedURI, "PUT",
				strJSON);

		String strResponse = Utils.streamToString(responseStream);

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
	public boolean removeAllProperties() throws SignatureException {
		try {

			// throw new Exception("Resource removeAll throws exception");

			// with POST following exception
			// throw new
			// Exception("Exception received: The remote server returned an error: (405) Method Not Allowed");
			// if GET works then documentation needs to be updated

			// with GET following exception
			// The remote server returned an error: (400) Bad Request

			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/pdf/" + fileName
					+ "/documentProperties";
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
				} else {
					signedURI = Utils.sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.sign(strURI);
			}

			InputStream responseStream = Utils.processCommand(signedURI,
					"DELETE");

			String strResponse = Utils.streamToString(responseStream);

			Gson gson = new Gson();
			// Parse the json string to JObject
			BaseResponse baseResponse = gson.fromJson(strResponse,
					BaseResponse.class);

			if (baseResponse.getCode().equals("200")
					& baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	// /////
	// / <summary>
	// / Gets the form field count
	// / </summary>
	// / <returns>count of the form fields</returns>
	public int getFormFieldCount() {

		try {
			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/pdf/" + fileName
					+ "/fields";
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
				} else {
					signedURI = Utils.sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.sign(strURI);
			}

			InputStream responseStream = Utils.processCommand(signedURI, "GET");

			String strJSON = Utils.streamToString(responseStream);

			Gson gson = new Gson();

			// Parse the json string to JObject and Deserializes the JSON to a
			// object.
			FormFieldsResponse formFieldsResponse = gson.fromJson(strJSON,
					FormFieldsResponse.class);

			return formFieldsResponse.getFields().getList().size();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}

	}

	// / <summary>
	// / Gets list of all the fields in the PDF file
	// / </summary>
	// / <returns>list of the form fields</returns>
	public List<FormField> getFormFields() {
		try {

			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/pdf/" + fileName
					+ "/fields";
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
				} else {
					signedURI = Utils.sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.sign(strURI);
			}

			InputStream responseStream = Utils.processCommand(signedURI, "GET");

			String strJSON = Utils.streamToString(responseStream);

			Gson gson = new Gson();

			// Parse the json string to JObject and Deserializes the JSON to a
			// object.
			FormFieldsResponse formFieldsResponse = gson.fromJson(strJSON,
					FormFieldsResponse.class);

			return formFieldsResponse.getFields().getList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	// / <summary>
	// / Gets a particular form field
	// / </summary>
	// / <param name="fieldName"></param>
	// / <returns>form field</returns>
	public FormField getFormField(String fieldName) {

		try {

			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/pdf/" + fileName
					+ "/fields/" + fieldName;
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
				} else {
					signedURI = Utils.sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.sign(strURI);
			}

			InputStream responseStream = Utils.processCommand(signedURI, "GET");

			String strJSON = Utils.streamToString(responseStream);

			Gson gson = new Gson();

			// Parse the json string to JObject and Deserializes the JSON to a
			// object.
			FormFieldResponse formFieldResponse = gson.fromJson(strJSON,
					FormFieldResponse.class);

			return formFieldResponse.getFormField();
		}

		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// / <summary>
	// / Creates a Pdf from XML
	// / </summary>
	// / <param name="pdfFileName"></param>
	// / <param name="xsltFileName"></param>
	// / <param name="xmlFileName"></param>
	// / <returns></returns>
	public boolean createFromXml(String pdfFileName, String xsltFileName,
			String xmlFileName) {
		try {

			String strURI = Product.getBaseProductUri() + "/pdf/" + pdfFileName
					+ "?templateFile=" + xsltFileName + "&dataFile="
					+ xmlFileName + "&templateType=xml";

			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
				} else {
					signedURI = Utils.sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.sign(strURI);
			}

			InputStream responseStream = Utils.processCommand(signedURI, "PUT");

			String strJSON = Utils.streamToString(responseStream);

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

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}

	}

	// / <summary>
	// / Creates a Pdf from HTML
	// / </summary>
	// / <param name="pdfFileName"></param>
	// / <param name="htmlFileName"></param>
	// / <returns></returns>
	public boolean createFromHtml(String pdfFileName, String htmlFileName) {
		try {

			String strURI = Product.getBaseProductUri() + "/pdf/" + pdfFileName
					+ "?templateFile=" + htmlFileName + "&templateType=html";
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
				} else {
					signedURI = Utils.sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.sign(strURI);
			}

			InputStream responseStream = Utils.processCommand(signedURI, "PUT");

			String strJSON = Utils.streamToString(responseStream);

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

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}

	}

	// / <summary>
	// / Creates an Empty Pdf document
	// / </summary>
	// / <param name="newDocumentName"></param>
	// / <returns></returns>

	public boolean createEmptyPdf(String newDocumentName) {

		try {
			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/pdf/"
					+ newDocumentName;
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
				} else {
					signedURI = Utils.sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.sign(strURI);
			}

			InputStream responseStream = Utils.processCommand(signedURI, "PUT");

			String strJSON = Utils.streamToString(responseStream);

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

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}

	}

	// / <summary>
	// / Merge two or more Pdf documents. A new pdf file will be generated.
	// / </summary>
	// / <param name="sourceFiles"></param>
	// / <returns></returns>

	public boolean mergeDocuments(List<String> sourceFiles) {

		try {
			// New PDF Filename
			String mergedFileName = fileName;

			if (sourceFiles.isEmpty())
				throw new Exception("File to merge are not specified");

			if (sourceFiles.size() < 2)
				throw new Exception("Two or more files are requred to merge");

			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/pdf/"
					+ mergedFileName + "/merge";
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
				} else {
					signedURI = Utils.sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.sign(strURI);
			}

			Map<String, Object> mp = new HashMap<String, Object>();
			mp.put("List", sourceFiles);

			Gson jsonlist = new Gson();
			String jsondata = jsonlist.toJson(mp);

			InputStream responseStream = Utils.processCommand(signedURI, "PUT",
					jsondata, "json");

			// further process JSON response
			String strJSON = Utils.streamToString(responseStream);

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

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}

	}

	// / <summary>
	// / Appends two Pdf documents. The newPdf is appended at the end of basePdf
	// / </summary>
	// / <param name="basePdf"></param>
	// / <param name="newPdf"></param>
	// / <returns></returns>

	public boolean appendDocument(String basePdf, String newPdf) {

		try {
			// Saving Exisiting File name
			String sOldFile = fileName;

			// Getting Total page in PDF
			fileName = newPdf;
			int iPageCount = getPageCount();

			// Setting Old File name again
			fileName = sOldFile;

			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/pdf/" + basePdf
					+ "/appendDocument?appendFile=" + newPdf
					+ "&startPage=1&endPage=" + Integer.toString(iPageCount);
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
				} else {
					signedURI = Utils.sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.sign(strURI);
			}

			InputStream responseStream = Utils
					.processCommand(signedURI, "POST");

			// further process JSON response
			String strJSON = Utils.streamToString(responseStream);

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

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}

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

	public boolean appendDocument(String basePdf, String newPdf, int startPage,
			int endPage) {

		try {

			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/pdf/" + basePdf
					+ "/appendDocument/?appendFile=" + newPdf + "&startPage="
					+ Integer.toString(startPage) + "&endPage="
					+ Integer.toString(endPage);
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
				} else {
					signedURI = Utils.sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.sign(strURI);
			}

			InputStream responseStream = Utils
					.processCommand(signedURI, "POST");

			// further process JSON response
			String strJSON = Utils.streamToString(responseStream);

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

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}

	}

	// / <summary>
	// / Adds new page to opened Pdf document
	// / </summary>
	// / <returns></returns>

	public boolean addNewPage() {

		try {

			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/pdf/" + fileName
					+ "/pages";
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
				} else {
					signedURI = Utils.sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.sign(strURI);
			}

			InputStream responseStream = Utils.processCommand(signedURI, "PUT");

			// further process JSON response
			String strJSON = Utils.streamToString(responseStream);

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

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	// / <summary>
	// / Deletes selected page in Pdf document
	// / </summary>
	// / <param name="pageNumber"></param>
	// / <returns></returns>

	public boolean deletePage(int pageNumber) {
		try {

			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/pdf/" + fileName
					+ "/pages/" + Integer.toString(pageNumber);
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
				} else {
					signedURI = Utils.sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.sign(strURI);
			}
			InputStream responseStream = Utils.processCommand(signedURI,
					"DELETE");

			// further process JSON response
			String strJSON = Utils.streamToString(responseStream);

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

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	// / <summary>
	// / Moves selected page in Pdf document to new location
	// / </summary>
	// / <param name="pageNumber"></param>
	// / <param name="newLocation"></param>
	// / <returns></returns>
	public boolean movePage(int pageNumber, int newLocation) {
		try {
			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/pdf/" + fileName
					+ "/pages/" + Integer.toString(pageNumber)
					+ "/movePage?newIndex=" + Integer.toString(newLocation);
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
				} else {
					signedURI = Utils.sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.sign(strURI);
			}

			InputStream responseStream = Utils
					.processCommand(signedURI, "POST");

			// further process JSON response
			String strJSON = Utils.streamToString(responseStream);

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

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	// / <summary>
	// / Replace Image in PDF File using Local Image Stream
	// / </summary>
	// / <param name="pageNumber"></param>
	// / <param name="imageIndex"></param>
	// / <param name="imageStream"></param>
	// / <returns></returns>
	public boolean replaceImageUsingStream(int pageNumber, int imageIndex,
			InputStream imageStream) {
		try {
			// build URI to replace image
			String strURI = Product.getBaseProductUri() + "/pdf/" + fileName
					+ "/pages/" + pageNumber + "/images/" + imageIndex;

			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
				} else {
					signedURI = Utils.sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.sign(strURI);
			}

			InputStream responseStream = Utils.processCommand(signedURI,
					"POST", imageStream);

			// further process JSON response
			String strJSON = Utils.streamToString(responseStream);

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

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	// / <summary>
	// / Replace Image in PDF document using Image File uploaded on Server
	// / </summary>
	// / <param name="pageNumber"></param>
	// / <param name="imageIndex"></param>
	// / <param name="fileName"></param>
	// / <returns></returns>
	public boolean replaceImageUsingFile(int pageNumber, int imageIndex,
			String _fileName) {
		try {
			// build URI to replace image
			String strURI = Product.getBaseProductUri() + "/pdf/" + fileName
					+ "/pages/" + pageNumber + "/images/" + imageIndex
					+ "?imageFile=" + _fileName;

			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
				} else {
					signedURI = Utils.sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.sign(strURI);
			}

			InputStream responseStream = Utils
					.processCommand(signedURI, "POST");

			// further process JSON response
			String strJSON = Utils.streamToString(responseStream);

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

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	public PdfDocument getDocument()
	{ 
		try {
			// check whether file is set or not
			if (fileName.equals(""))
				throw new Exception("No file name specified");

			// build URI
			String strURI = Product.getBaseProductUri()  + "/pdf/" + fileName;


			// sign URI
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
				} else {
					signedURI = Utils.sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.sign(strURI);
			}

			InputStream responseStream = Utils.processCommand(signedURI, "GET");

			String strJSON = Utils.streamToString(responseStream);

			Gson gson = new Gson();

			DocumentResponse docResponse = gson.fromJson(strJSON,
					DocumentResponse.class);

			return docResponse.getDocument();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean insertFormField(FormField formField)
	{
		try {
			// check whether file is set or not
			if (fileName.equals(""))
				throw new Exception("No file name specified");

			// build URI
			String strURI = Product.getBaseProductUri()  + "/pdf/" + fileName + "/fields/"+formField.getName();

			// sign URI
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
				} else {
					signedURI = Utils.sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.sign(strURI);
			}
			Gson gson = new Gson();


			String strJSON = "";
			strJSON = gson.toJson(formField, FormField.class);

			InputStream responseStream = Utils.processCommand(signedURI, "PUT",strJSON);

			String strResponse = Utils.streamToString(responseStream);

			// Parse the json string to JObject
			BaseResponse baseResponse = gson.fromJson(strResponse,
					BaseResponse.class);

			if (baseResponse.getCode().equals("200")
					& baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean insertFormFields(FormFields formField)
	{
		try {
			// check whether file is set or not
			if (fileName.equals(""))
				throw new Exception("No file name specified");

			// build URI
			String strURI = Product.getBaseProductUri()  + "/pdf/" + fileName + "/fields";

			// sign URI
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
				} else {
					signedURI = Utils.sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.sign(strURI);
			}
			Gson gson = new Gson();


			String strJSON = "";
			strJSON = gson.toJson(formField, FormFields.class);

			InputStream responseStream = Utils.processCommand(signedURI, "PUT",strJSON);

			String strResponse = Utils.streamToString(responseStream);

			// Parse the json string to JObject
			BaseResponse baseResponse = gson.fromJson(strResponse,
					BaseResponse.class);

			if (baseResponse.getCode().equals("200")
					& baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean saveAsTiff(SaveAsTiffOptions imageOptions, String folderName)
	{
		try {
			// check whether file is set or not
			if (fileName.equals(""))
				throw new Exception("No file name specified");

			// build URI
			String strURI = Product.getBaseProductUri()  + "/pdf/" + fileName + "/SaveAs/tiff?folder=" + folderName;

			// sign URI
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
				} else {
					signedURI = Utils.sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.sign(strURI);
			}
			Gson gson = new Gson();


			String strJSON = "";
			strJSON = gson.toJson(imageOptions, SaveAsTiffOptions.class);

			InputStream responseStream = Utils.processCommand(signedURI, "PUT",strJSON);

			String strResponse = Utils.streamToString(responseStream);

			// Parse the json string to JObject
			BaseResponse baseResponse = gson.fromJson(strResponse,
					BaseResponse.class);

			if (baseResponse.getCode().equals("200")
					& baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean saveAsTiff(String outputFile, String compression, String folderName)
	{
		try {
			// check whether file is set or not
			if (fileName.equals(""))
				throw new Exception("No file name specified");

			// build URI
			String strURI = Product.getBaseProductUri()  + "/pdf/" + fileName + "/SaveAs/tiff?resultFile=" + outputFile + "&compression=" + compression + "&folder=" + folderName;

			// sign URI
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
				} else {
					signedURI = Utils.sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.sign(strURI);
			}
			Gson gson = new Gson();


			//String strJSON = "";
			//strJSON = gson.toJson(imageOptions, SaveAsTiffOptions.class);

			InputStream responseStream = Utils.processCommand(signedURI, "PUT");

			String strResponse = Utils.streamToString(responseStream);

			// Parse the json string to JObject
			BaseResponse baseResponse = gson.fromJson(strResponse,
					BaseResponse.class);

			if (baseResponse.getCode().equals("200")
					& baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public LinkResponse[] splitDocument()
	{
		try {
			// check whether file is set or not
			if (fileName.equals(""))
				throw new Exception("No file name specified");

			// build URI
			String strURI = Product.getBaseProductUri()  + "/pdf/" + fileName + "/split";

			// sign URI
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
				} else {
					signedURI = Utils.sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.sign(strURI);
			}
			Gson gson = new Gson();


			InputStream responseStream = Utils.processCommand(signedURI, "POST");

			String strResponse = Utils.streamToString(responseStream);

			// Parse the json string to JObject
			SplitPDFResponse PDFResponse = gson.fromJson(strResponse,
					SplitPDFResponse.class);

			return PDFResponse.getResult().getDocuments();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public LinkResponse[] splitDocument(int from, int to)
	{
		try {
			// check whether file is set or not
			if (fileName.equals(""))
				throw new Exception("No file name specified");

			// build URI
			String strURI = Product.getBaseProductUri()   + "/pdf/" + fileName + "/split?from=" + from + "&to=" + to;

			// sign URI
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
				} else {
					signedURI = Utils.sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.sign(strURI);
			}
			Gson gson = new Gson();


			InputStream responseStream = Utils.processCommand(signedURI, "POST");

			String strResponse = Utils.streamToString(responseStream);

			// Parse the json string to JObject
			SplitPDFResponse PDFResponse = gson.fromJson(strResponse,
					SplitPDFResponse.class);

			return PDFResponse.getResult().getDocuments();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public LinkResponse[] splitDocument(int from, int to, SplitDocumentFormat format)
	{
		try {
			// check whether file is set or not
			if (fileName.equals(""))
				throw new Exception("No file name specified");

			// build URI
			String strURI = Product.getBaseProductUri()   + "/pdf/" + fileName + "/split?from=" + from + "&to=" + to + "&format=" + format.toString();

			// sign URI
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
				} else {
					signedURI = Utils.sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.sign(strURI);
			}
			Gson gson = new Gson();


			InputStream responseStream = Utils.processCommand(signedURI, "POST");

			String strResponse = Utils.streamToString(responseStream);

			// Parse the json string to JObject
			SplitPDFResponse PDFResponse = gson.fromJson(strResponse,
					SplitPDFResponse.class);

			return PDFResponse.getResult().getDocuments();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public boolean addStamp(StampRequest stampRequest)
	{
		try {
			// check whether file is set or not
			if (fileName.equals(""))
				throw new Exception("No file name specified");

			// build URI
			String strURI = Product.getBaseProductUri()  + "/pdf/" + fileName + "/pages/" + stampRequest.getPageIndex() + "/stamp/";

			// sign URI
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
				} else {
					signedURI = Utils.sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.sign(strURI);
			}
			Gson gson = new Gson();
			String strJSON = "";
			strJSON = gson.toJson(stampRequest, StampRequest.class);

			InputStream responseStream = Utils.processCommand(signedURI, "PUT",strJSON);

			String strResponse = Utils.streamToString(responseStream);

			BaseResponse baseResponse = gson.fromJson(strResponse,								BaseResponse.class);

			if (baseResponse.getCode().equals("200")
					& baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean addStampWithTextState(StampRequest stampRequest)
	{
		try {
			// check whether file is set or not
			if (fileName.equals(""))
				throw new Exception("No file name specified");

			// build URI
			String strURI = Product.getBaseProductUri()  + "/pdf/" + fileName + "/pages/" + stampRequest.getPageIndex() + "/stamp/";

			// sign URI
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
				} else {
					signedURI = Utils.sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.sign(strURI);
			}
			Gson gson = new Gson();
			String strJSON = "";
			strJSON = gson.toJson(stampRequest, StampRequest.class);

			InputStream responseStream = Utils.processCommand(signedURI, "PUT",strJSON);

			String strResponse = Utils.streamToString(responseStream);

			BaseResponse baseResponse = gson.fromJson(strResponse,								BaseResponse.class);

			if (baseResponse.getCode().equals("200")
					& baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public int getTotalWordCount()
	{ 
		try {
			// check whether file is set or not
			if (fileName.equals(""))
				throw new Exception("No file name specified");

			// build URI
			String strURI = Product.getBaseProductUri() + "/pdf/" + fileName + "/Pages";
			strURI += "/wordCount";
            

			// sign URI
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
				} else {
					signedURI = Utils.sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.sign(strURI);
			}

			InputStream responseStream = Utils.processCommand(signedURI, "GET");

			String strJSON = Utils.streamToString(responseStream);

			Gson gson = new Gson();

			WordsPerPage wordsResponse = gson.fromJson(strJSON,	WordsPerPage.class);

			 int count = 0;
             for (WordResponse wordResponse : wordsResponse.getWordsPerPage().getList())
                 count += wordResponse.getCount();
             return count;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
}
