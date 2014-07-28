package com.aspose.cloud.slides;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.aspose.cloud.common.AsposeAppNonStatic;
import com.aspose.cloud.common.BaseResponse;
import com.aspose.cloud.common.Product;
import com.aspose.cloud.common.Utils;
import com.aspose.cloud.exceptions.AuthorizationException;
import com.aspose.cloud.exceptions.CommonIOException;
import com.aspose.cloud.exceptions.ParameterMissingException;
import com.aspose.cloud.exceptions.SlidesIOException;
import com.aspose.cloud.storage.Folder;
import com.aspose.cloud.storage.StorageType;
import com.google.gson.Gson;

/**
 * @author Mudassir
 * 
 */
// / <summary>
// / Deals with PowerPoint presentation level aspects
// / </summary>
public class Document {
	private AsposeAppNonStatic auth;

	public Document(String fileName) {
		FileName = fileName;
		gson = new Gson();
	}

	public Document(String fileName, AsposeAppNonStatic auth) {
		this(fileName);
		this.auth = auth;
	}

	// / <summary>
	// / Presentation name
	// / </summary>
	public String FileName;
	Gson gson = null;

	public boolean Convert(InputStream stream, String outputPath,
			SaveFormat saveFormat) {
			String strURI = Product.getBaseProductUri()
					+ "/slides/convert?format=" + saveFormat;
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("Document.Convert: Please Specify AppKey and AppSID");

				} else {
					signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.Sign(strURI);
			}
			InputStream responseStream = Utils.ProcessCommand(signedURI, "PUT");
			boolean response = Folder.SaveStreamToFile(outputPath,
					responseStream);
			try {
				responseStream.close();
			} catch (IOException e) {
				throw new SlidesIOException("Document.Convert Some error occurred while closing steam",e);

			}
			return response;

	}

	// / <summary>
	// / Finds the slide count of the specified PowerPoint document
	// / </summary>
	// / <returns>slide count</returns>
	public int GetSlideCount() {
			// build URI to get slide count

			String strURI = Product.getBaseProductUri() + "/slides/" + FileName
					+ "/slides";
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("Document.GetSlideCount: Please Specify AppKey and AppSID");

				} else {
					signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.Sign(strURI);
			}
			InputStream responseStream = Utils.ProcessCommand(signedURI, "GET");

			String strJSON = Utils.StreamToString(responseStream);

			// Parse and deserialize the JSON to a object.
			SlidesResponse slidesResponse = gson.fromJson(strJSON,
					SlidesResponse.class);

			int count = slidesResponse.getSlides().getSlideList().size();
			return count;

	}

	public int GetSlideCount(StorageType storageType, String storageName,
			String folderName) {
			// build URI to get slide count

			String strURI = Product.getBaseProductUri()
					+ "/slides/"
					+ FileName
					+ "/slides"
					+ (folderName.equals("") || folderName.equals(null) ? ""
							: "?folder=" + folderName);
			if (storageType.equals(StorageType.AmazonS3)) {
				strURI.concat("?storage=" + storageName);
			}
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("Document.GetSlideCount: Please Specify AppKey and AppSID");

				} else {
					signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.Sign(strURI);
			}

			InputStream responseStream = Utils.ProcessCommand(signedURI, "GET");

			String strJSON = Utils.StreamToString(responseStream);

			// Parse and deserialize the JSON to a object.
			SlidesResponse slidesResponse = gson.fromJson(strJSON,
					SlidesResponse.class);

			int count = slidesResponse.getSlides().getSlideList().size();
			return count;

	}

	// / <summary>
	// / Gets a list containing all document properties
	// / </summary>
	// / <returns>List of document properties</returns>
	public int GetDocumentPropertiesCount() {
			// build URI to get document properties

			String strURI = Product.getBaseProductUri() + "/slides/" + FileName
					+ "/documentProperties";
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("Document.GetDocumentPropertiesCount: Please Specify AppKey and AppSID");

				} else {
					signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.Sign(strURI);
			}

			InputStream responseStream = Utils.ProcessCommand(signedURI, "GET");

			String strJSON = Utils.StreamToString(responseStream);

			// Parse and deserialize the JSON to a object.
			DocumentPropertiesResponse documentPropertiesResponse = gson
					.fromJson(strJSON, DocumentPropertiesResponse.class);

			return documentPropertiesResponse.getDocumentProperties().getList()
					.size();

	}

	// / <summary>
	// / Gets a list containing all document properties
	// / </summary>
	// / <returns>List of document properties</returns>
	public List<com.aspose.cloud.slides.DocumentProperty> GetDocumentProperties() {
			// build URI to get document properties

			String strURI = Product.getBaseProductUri() + "/slides/" + FileName
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

			// Parse and deserialize the JSON to a object.
			DocumentPropertiesResponse documentPropertiesResponse = gson
					.fromJson(strJSON, DocumentPropertiesResponse.class);

			return documentPropertiesResponse.getDocumentProperties().getList();

	}

	// / <summary>
	// / Gets the value of a particular property
	// / </summary>
	// / <param name="propertyName"></param>
	// / <returns>value of the specified property</returns>
	public com.aspose.cloud.slides.DocumentProperty GetDocumentProperty(
			String propertyName) {
			// build URI to get single property
			String strURI = Product.getBaseProductUri() + "/slides/" + FileName
					+ "/presentation/documentproperties/" + propertyName;
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

			// Parse and deserialize the JSON to a object.
			DocumentPropertyResponse documentPropertyResponse = gson.fromJson(
					strJSON, DocumentPropertyResponse.class);

			return documentPropertyResponse.getDocumentProperty();
	}

	// / <summary>
	// / Removes all the custom properties and resets all the built-in
	// properties
	// / </summary>
	public boolean RemoveAllProperties() {
			// build URI to remove/reset all the properties
			String strURI = Product.getBaseProductUri() + "/slides/" + FileName
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

			String strJSON = Utils.StreamToString(responseStream);

			// Parse and deserialize the JSON to a object.
			BaseResponse baseResponse = gson.fromJson(strJSON,
					BaseResponse.class);

			if (baseResponse.getCode().equals("200")
					&& baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;
	}

	// / <summary>
	// / Replaces all instances of old text with new text in a presentation
	// / </summary>
	// / <param name="oldText"></param>
	// / <param name="newText"></param>
	public boolean ReplaceText(String oldText, String newText) {
			// build URI to replace text
			String strURI = Product.getBaseProductUri() + "/slides/" + FileName
					+ "/replaceText?oldValue=" + oldText + "&newValue="
					+ newText;// + "&ignoreCase=true";
			strURI = strURI.replace(" ", "%20");
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("Document.ReplaceText: Please Specify AppKey and AppSID");

				} else {
					signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.Sign(strURI);
			}

			InputStream responseStream = Utils
					.ProcessCommand(signedURI, "POST");

			String strJSON = Utils.StreamToString(responseStream);

			// Parse and deserialize the JSON to a object.
			BaseResponse baseResponse = gson.fromJson(strJSON,
					BaseResponse.class);

			if (baseResponse.getCode().equals("200")
					&& baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;

	}

	// / <summary>
	// / Replaces all instances of old text with new text in a slide
	// / </summary>
	// / <param name="oldText"></param>
	// / <param name="newText"></param>
	// / <param name="slideNumber"></param>
	public boolean ReplaceText(String oldText, String newText, int slideNumber) {
			// build URI to replace text in a particular slide
			String strURI = Product.getBaseProductUri() + "/slides/" + FileName
					+ "/slides/" + Integer.toString(slideNumber)
					+ "/replaceText?oldValue=" + oldText + "&newValue="
					+ newText + "&ignoreCase=true";
			strURI = strURI.replace(" ", "%20");
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("Document.ReplaceText: Please Specify AppKey and AppSID");

				} else {
					signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.Sign(strURI);
			}

			InputStream responseStream = Utils
					.ProcessCommand(signedURI, "POST");

			String strJSON = Utils.StreamToString(responseStream);

			// Parse and deserialize the JSON to a object.
			BaseResponse baseResponse = gson.fromJson(strJSON,
					BaseResponse.class);

			if (baseResponse.getCode().equals("200")
					&& baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;

	}

	// / <summary>
	// / Deletes a particular custom property or resets a particular built-in
	// property
	// / </summary>
	// / <param name="propertyName"></param>
	public boolean DeleteDocumentProperty(String propertyName) {
			// build URI to remove single property
			String strURI = Product.getBaseProductUri() + "/slides/" + FileName
					+ "/documentProperties/" + propertyName;
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("Document.DeleteDocumentProperty: Please Specify AppKey and AppSID");

				} else {
					signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.Sign(strURI);
			}

			InputStream responseStream = Utils.ProcessCommand(signedURI,
					"DELETE");

			String strJSON = Utils.StreamToString(responseStream);

			// Parse and deserialize the JSON to a object.
			BaseResponse baseResponse = gson.fromJson(strJSON,
					BaseResponse.class);

			if (baseResponse.getCode().equals("200")
					&& baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;
	}

	// / <summary>
	// / Gets all the text items in a presentation
	// / </summary>
	// / <returns>A list containing all the text items</returns>
	public List<TextItem> GetAllTextItems() {
			// build URI to get all text items in a presentation
			String strURI = Product.getBaseProductUri() + "/slides/" + FileName
					+ "/textItems";
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("Document.GetAllTextItems: Please Specify AppKey and AppSID");

				} else {
					signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.Sign(strURI);
			}

			InputStream responseStream = Utils.ProcessCommand(signedURI, "GET");

			String strJSON = Utils.StreamToString(responseStream);

			// Parse and deserialize the JSON to a object.
			TextItemsResponse textItemsResponse = gson.fromJson(strJSON,
					TextItemsResponse.class);

			return textItemsResponse.getTextItems().getItems();

	}

	public List<TextItem> GetAllTextItems(StorageType storageType,
			String storageName, String folderName) {
			// build URI to get all text items in a presentation
			String strURI = Product.getBaseProductUri()
					+ "/slides/"
					+ FileName
					+ "/textItems"
					+ (folderName.equals("") || folderName.equals(null) ? ""
							: "?folder=" + folderName);
			if (folderName.equals(StorageType.AmazonS3)) {
				strURI.concat("&storage=" + storageName);
			}
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("Document.GetAllTextItems: Please Specify AppKey and AppSID");

				} else {
					signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.Sign(strURI);
			}
			InputStream responseStream = Utils.ProcessCommand(signedURI, "GET");

			String strJSON = Utils.StreamToString(responseStream);

			// Parse and deserialize the JSON to a object.
			TextItemsResponse textItemsResponse = gson.fromJson(strJSON,
					TextItemsResponse.class);

			return textItemsResponse.getTextItems().getItems();

	}

	// / <summary>
	// / Gets all the text items in a slide
	// / </summary>
	// / <param name="slideNumber"></param>
	// / /// <param name="withEmpty">Set this to true to include items for
	// shapes without text</param>
	// / <returns>A list containing all the text items in a slide</returns>
	public List<TextItem> GetAllTextItems(int slideNumber, boolean withEmpty) {
			// build URI to get all text items in a slide
			String strURI = Product.getBaseProductUri() + "/slides/" + FileName
					+ "/slides/" + Integer.toString(slideNumber)
					+ "/textItems?withEmpty="
					+ new Boolean(withEmpty).toString();
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("Document.GetAllTextItems: Please Specify AppKey and AppSID");

				} else {
					signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.Sign(strURI);
			}
			InputStream responseStream = Utils.ProcessCommand(signedURI, "GET");

			String strJSON = Utils.StreamToString(responseStream);

			// Parse and deserialize the JSON to a object.
			TextItemsResponse textItemsResponse = gson.fromJson(strJSON,
					TextItemsResponse.class);

			return textItemsResponse.getTextItems().getItems();
	}

	public List<TextItem> GetAllTextItems(int slideNumber, boolean withEmpty,
			StorageType storageType, String storageName, String folderName) {
			// build URI to get all text items in a slide
			String strURI = Product.getBaseProductUri()
					+ "/slides/"
					+ FileName
					+ "/slides/"
					+ Integer.toString(slideNumber)
					+ "/textItems?withEmpty="
					+ new Boolean(withEmpty).toString()
					+ (folderName.equals("") || folderName.equals(null) ? ""
							: "&folder=" + folderName);
			if (storageType.equals(StorageType.AmazonS3)) {
				strURI.concat("&storage=" + storageName);
			}
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("Document.GetAllTextItems: Please Specify AppKey and AppSID");

				} else {
					signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.Sign(strURI);
			}

			InputStream responseStream = Utils.ProcessCommand(signedURI, "GET");

			String strJSON = Utils.StreamToString(responseStream);

			// Parse and deserialize the JSON to a object.
			TextItemsResponse textItemsResponse = gson.fromJson(strJSON,
					TextItemsResponse.class);

			return textItemsResponse.getTextItems().getItems();
	}

	// / <summary>
	// / saves the document into various formats
	// / </summary>
	// / <param name="outputPath"></param>
	// / <param name="saveFormat"></param>
	public void SaveAs(String outputPath, SaveFormat saveFormat) {

			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/slides/" + FileName;
			strURI += "?format=" + saveFormat.toString().toLowerCase();

			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("Document.SaveAs: Please Specify AppKey and AppSID");

				} else {
					signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.Sign(strURI);
			}

			InputStream responseStream = Utils.ProcessCommand(signedURI, "GET");

			com.aspose.cloud.storage.Folder.SaveStreamToFile(outputPath,
					responseStream);

			try {
				responseStream.close();
			} catch (IOException e) {
				throw new SlidesIOException("Document.SaveAs Some error occurred while closing steam",e);

			}
	}

	public void SaveAs(String outputPath, SaveFormat saveFormat,
			StorageType storageType, String storageName, String folderName) {

			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/slides/" + FileName;
			strURI += "?format="
					+ saveFormat.toString().toLowerCase()
					+ (folderName.equals("") || folderName.equals(null) ? ""
							: "&folder=" + folderName);
			if (storageType.equals(StorageType.AmazonS3)) {
				strURI.concat("&storage=" + storageName);
			}
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("Document.SaveAs: Please Specify AppKey and AppSID");

				} else {
					signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.Sign(strURI);
			}

			InputStream responseStream = Utils.ProcessCommand(signedURI, "GET");

			com.aspose.cloud.storage.Folder.SaveStreamToFile(outputPath,
					responseStream);

			try {
				responseStream.close();
			} catch (IOException e) {
				throw new SlidesIOException("Document.SaveAs Some error occurred while closing steam",e);

			}
	}

	// / <summary>
	// / Saves a particular slide into various formats
	// / </summary>
	// / <param name="outputPath"></param>
	// / <param name="slideNumber"></param>
	// / <param name="imageFormat"></param>
	public void SaveSlideAs(String outputPath, int slideNumber,
			ImageFormat imageFormat)// Returns 100x100 image
	{


			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/slides/" + FileName
					+ "/slides/" + Integer.toString(slideNumber) + "?format="
					+ imageFormat.toString().toLowerCase();

			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("Document.SaveSlideAs: Please Specify AppKey and AppSID");

				} else {
					signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.Sign(strURI);
			}

			InputStream responseStream = Utils.ProcessCommand(signedURI, "GET");

			com.aspose.cloud.storage.Folder.SaveStreamToFile(outputPath,
					responseStream);

			try {
				responseStream.close();
			} catch (IOException e) {
				throw new SlidesIOException("Document.SaveSlideAs Some error occurred while closing steam",e);

			};
	}

	public void SaveSlideAs(String outputPath, int slideNumber,
			ImageFormat imageFormat, StorageType storageType,
			String storageName, String folderName)// Returns 100x100 image
	{


			// build URI to get page count
			String strURI = Product.getBaseProductUri()
					+ "/slides/"
					+ FileName
					+ "/slides/"
					+ Integer.toString(slideNumber)
					+ "?format="
					+ imageFormat.toString().toLowerCase()
					+ (folderName.equals("") || folderName.equals(null) ? ""
							: "&folder=" + folderName);
			if (storageType.equals(StorageType.AmazonS3)) {
				strURI.concat("&storage=" + storageName);
			}
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("Document.SaveSlideAs: Please Specify AppKey and AppSID");

				} else {
					signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.Sign(strURI);
			}

			InputStream responseStream = Utils.ProcessCommand(signedURI, "GET");

			com.aspose.cloud.storage.Folder.SaveStreamToFile(outputPath,
					responseStream);

			try {
				responseStream.close();
			} catch (IOException e) {
				throw new SlidesIOException("Document.SaveSlideAs Some error occurred while closing steam",e);

			};
	}

	// / <summary>
	// / Saves a particular slide into various formats with specified width and
	// height
	// / </summary>
	// / <param name="outputPath"></param>
	// / <param name="slideNumber"></param>
	// / <param name="imageFormat"></param>
	// / <param name="width"></param>
	// / <param name="height"></param>
	public void SaveSlideAs(String outputPath, int slideNumber,
			ImageFormat imageFormat, int width, int height) {
			// build URI to get page count
			// String strURI = Product.getBaseProductUri() + "/slides/" +
			// FileName + "/slides/" + slideNumber+"/images" + "?format=" +
			// imageFormat.toString().toLowerCase() + "&width=" +
			// Integer.toString(width) + "&height=" + Integer.toString(height);
			String strURI = Product.getBaseProductUri() + "/slides/" + FileName
					+ "/slides/" + slideNumber + "?format="
					+ imageFormat.toString().toLowerCase() + "&width="
					+ Integer.toString(width) + "&height="
					+ Integer.toString(height);

			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("Document.SaveSlideAs: Please Specify AppKey and AppSID");

				} else {
					signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.Sign(strURI);
			}

			InputStream responseStream = Utils.ProcessCommand(signedURI, "GET");

			com.aspose.cloud.storage.Folder.SaveStreamToFile(outputPath,
					responseStream);

			try {
				responseStream.close();
			} catch (IOException e) {
				throw new SlidesIOException("Document.SaveSlideAs Some error occurred while closing steam",e);

			}

	}

	public void SaveSlideAs(String outputPath, int slideNumber,
			ImageFormat imageFormat, int width, int height,
			StorageType storageType, String storageName, String folderName) {
			// build URI to get page count
			// String strURI = Product.getBaseProductUri() + "/slides/" +
			// FileName + "/slides/" + slideNumber+"/images" + "?format=" +
			// imageFormat.toString().toLowerCase() + "&width=" +
			// Integer.toString(width) + "&height=" + Integer.toString(height);
			String strURI = Product.getBaseProductUri()
					+ "/slides/"
					+ FileName
					+ "/slides/"
					+ slideNumber
					+ "?format="
					+ imageFormat.toString().toLowerCase()
					+ "&width="
					+ Integer.toString(width)
					+ "&height="
					+ Integer.toString(height)
					+ (folderName.equals("") || folderName.equals(null) ? ""
							: "&folder=" + folderName);
			if (storageType.equals(StorageType.AmazonS3)) {
				strURI.concat("&storage=" + storageName);
			}
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("Document.SaveSlideAs: Please Specify AppKey and AppSID");

				} else {
					signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.Sign(strURI);
			}
			InputStream responseStream = Utils.ProcessCommand(signedURI, "GET");

			com.aspose.cloud.storage.Folder.SaveStreamToFile(outputPath,
					responseStream);

			try {
				responseStream.close();
			} catch (IOException e) {
				throw new SlidesIOException("Document.SaveSlideAs Some error occurred while closing steam",e);

			}
	}

	// / <summary>
	// / Sets the value of a particular property or adds a new property if the
	// specified property does not exist
	// / </summary>
	// / <param name="propertyName"></param>
	// / <param name="value"></param>
	public boolean SetDocumentProperty(String propertyName, String value) {

		// build URI to remove single property
		String strURI = Product.getBaseProductUri() + "/slides/" + FileName
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
		com.aspose.cloud.slides.DocumentProperty docProperty = new com.aspose.cloud.slides.DocumentProperty();
		docProperty.setValue(value);

		String strJSON = "";
		strJSON = gson.toJson(docProperty,
				com.aspose.cloud.slides.DocumentProperty.class);

		InputStream responseStream = Utils.ProcessCommand(signedURI, "PUT",
				strJSON);

		String strResponse = Utils.StreamToString(responseStream);
		// Parse and deserialize the JSON to a object.
		DocumentPropertyResponse baseResponse = gson.fromJson(strResponse,
				DocumentPropertyResponse.class);

		if ((baseResponse.getCode().equals("200") && baseResponse.getStatus()
				.equals("OK"))
				|| (baseResponse.getCode().equals("201") && baseResponse
						.getStatus().equals("Created")))
			return true;
		else
			return false;
	}

	public boolean DeleteAllSlides() {
			String strURI = Product.getBaseProductUri() + "/slides/"
					+ this.FileName + "/slides";
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("Document.DeleteAllSlides: Please Specify AppKey and AppSID");

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
			BaseResponse baseResponse = gson.fromJson(strResponse,
					BaseResponse.class);
			if (baseResponse.getCode().equals("200")) {
				return true;
			} else {
				return false;
			}

	}

	public boolean DeleteAllSlides(StorageType storageType, String storageName,
			String folderName) {
			String strURI = Product.getBaseProductUri()
					+ "/slides/"
					+ this.FileName
					+ "/slides"
					+ (folderName.equals("") || folderName.equals(null) ? ""
							: "?folder=" + folderName);
			if (storageType.equals(StorageType.AmazonS3)) {
				strURI.concat("&storage=" + storageName);
			}
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
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
			BaseResponse baseResponse = gson.fromJson(strResponse,
					BaseResponse.class);
			if (baseResponse.getCode().equals("200")) {
				return true;
			} else {
				return false;
			}

	}
	public boolean MergeDocuments(String[] sourceFiles) {
			String mergedFileName = FileName;

			if (sourceFiles.length < 1)
			{
				throw new ParameterMissingException("One or more files are requred to merge.");
			}
			// build URI to remove single property
			String strURI = Product.getBaseProductUri() + "/slides/" + mergedFileName + "/merge";
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
			SourceFilesList sourcefileslist = new SourceFilesList();
			sourcefileslist.setList( sourceFiles);

			String strJSON = "";
			strJSON = gson.toJson(sourcefileslist,
					SourceFilesList.class);

			InputStream responseStream = Utils.ProcessCommand(signedURI, "POST",
					strJSON);

			String strResponse = Utils.StreamToString(responseStream);
			// Parse and deserialize the JSON to a object.
			BaseResponse baseResponse = gson.fromJson(strResponse,
					BaseResponse.class);
			if (baseResponse.getCode().equals("200")) {
				return true;
			} else {
				return false;
			}
	}
	public Slide GetSlide(int slideNumber) {
			// build URI to get slide count

			String strURI = Product.getBaseProductUri()+ "/slides/" + FileName + "/slides/" + slideNumber;
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("Document.GetSlide: Please Specify AppKey and AppSID");

				} else {
					signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.Sign(strURI);
			}
			InputStream responseStream = Utils.ProcessCommand(signedURI, "GET");

			String strJSON = Utils.StreamToString(responseStream);

			// Parse and deserialize the JSON to a object.
			SlideDetailResponse slidesResponse = gson.fromJson(strJSON,
					SlideDetailResponse.class);

			return slidesResponse.getSlide();

	}
	public boolean DeleteSlide(int slideNumber) {
			String strURI = Product.getBaseProductUri() + "/slides/" + FileName + "/slides/" + slideNumber;
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("Document.DeleteSlide: Please Specify AppKey and AppSID");

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
			BaseResponse baseResponse = gson.fromJson(strResponse,
					BaseResponse.class);
			if (baseResponse.getCode().equals("200")) {
				return true;
			} else {
				return false;
			}

	}
	public Theme GetTheme(int slideNumber) {
			// build URI to get slide count

			String strURI = Product.getBaseProductUri()+ "/slides/" + FileName + "/slides/" + slideNumber + "/theme";
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("Document.GetTheme: Please Specify AppKey and AppSID");

				} else {
					signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.Sign(strURI);
			}
			InputStream responseStream = Utils.ProcessCommand(signedURI, "GET");

			String strJSON = Utils.StreamToString(responseStream);

			// Parse and deserialize the JSON to a object.
			ThemeResponse themeResponse = gson.fromJson(strJSON,
					ThemeResponse.class);

			return themeResponse.getTheme();

	}
}