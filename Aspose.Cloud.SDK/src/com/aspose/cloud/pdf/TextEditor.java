/**
 * 
 */
package com.aspose.cloud.pdf;

import java.io.InputStream;
import java.util.List;

import com.aspose.cloud.common.AsposeAppNonStatic;
import com.aspose.cloud.common.Product;
import com.aspose.cloud.common.Utils;
import com.aspose.cloud.exceptions.AuthorizationException;
import com.aspose.cloud.exceptions.CommonIOException;
import com.google.gson.Gson;

/**
 * @author Mudassir
 * 
 */
// / <summary>
// / This class contains features to work with text
// / </summary>
public class TextEditor {
	private AsposeAppNonStatic auth;

	public TextEditor(String fileName) {
		FileName = fileName;
		gson = new Gson();
	}

	public TextEditor(String fileName, AsposeAppNonStatic auth) {
		this(fileName);
		this.auth = auth;
	}

	// / <summary>
	// / PDF document name
	// / </summary>
	public String FileName;
	Gson gson = null;

	// / <summary>
	// / Gets raw text from the whole PDF file
	// / </summary>
	// / <returns></returns>
	public String GetText() {

			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/pdf/" + FileName
					+ "/TextItems";
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

			InputStream responseStream = Utils.ProcessCommand(signedURI, "GET");
			String strJSON = Utils.StreamToString(responseStream);

			// Parse and Deserialize the JSON to a object.
			TextItemsResponse textItemsResponse = gson.fromJson(strJSON,
					TextItemsResponse.class);

			StringBuilder stringBuilder = new StringBuilder();

			for (TextItem textItem : textItemsResponse.getTextItems().getList()) {
				stringBuilder.append(textItem.getText());
			}

			return stringBuilder.toString();
	}

	// / <summary>
	// / Gets raw text from a particular page
	// / </summary>
	// / <returns></returns>
	public String GetText(int pageNumber) {
			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/pdf/" + FileName
					+ "/pages/" + Integer.toString(pageNumber) + "/TextItems";
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("TextEditor.GetText: Please Specify AppKey and AppSID");

				} else {
					signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.Sign(strURI);
			}

			InputStream responseStream = Utils.ProcessCommand(signedURI, "GET");

			String strJSON = Utils.StreamToString(responseStream);
			;

			// Parse and Deserialize the JSON to a object.
			TextItemsResponse textItemsResponse = gson.fromJson(strJSON,
					TextItemsResponse.class);

			StringBuilder stringBuilder = new StringBuilder();

			for (TextItem textItem : textItemsResponse.getTextItems().getList()) {
				stringBuilder.append(textItem.getText());
			}

			return stringBuilder.toString();

	}

	// / <summary>
	// / Gets text items from the whole PDF file
	// / </summary>
	// / <returns></returns>
	public List<TextItem> GetTextItems() {
			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/pdf/" + FileName
					+ "/TextItems";
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("TextEditor.GetTextItems: Please Specify AppKey and AppSID");

				} else {
					signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.Sign(strURI);
			}

			InputStream responseStream = Utils.ProcessCommand(signedURI, "GET");

			String strJSON = Utils.StreamToString(responseStream);
			;

			// Parse and Deserializes the JSON to a object.
			TextItemsResponse textItemsResponse = gson.fromJson(strJSON,
					TextItemsResponse.class);

			return textItemsResponse.getTextItems().getList();

	}

	// / <summary>
	// / Gets text items from a particular page
	// / </summary>
	// / <returns></returns>
	public List<TextItem> GetTextItems(int pageNumber) {
			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/pdf/" + FileName
					+ "/pages/" + Integer.toString(pageNumber) + "/TextItems";
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("TextEditor.GetTextItems: Please Specify AppKey and AppSID");

				} else {
					signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.Sign(strURI);
			}

			InputStream responseStream = Utils.ProcessCommand(signedURI, "GET");

			String strJSON = Utils.StreamToString(responseStream);
			;

			// Parse and Deserialize the JSON to a object.
			TextItemsResponse textItemsResponse = gson.fromJson(strJSON,
					TextItemsResponse.class);

			return textItemsResponse.getTextItems().getList();
	}

	// / <summary>
	// / Gets all text items from a fragment
	// / </summary>
	// / <returns></returns>
	public List<TextItem> GetTextItems(int pageNumber, int fragmentNumber) {
			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/pdf/" + FileName
					+ "/pages/" + Integer.toString(pageNumber) + "/fragments/"
					+ Integer.toString(fragmentNumber);
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("TextEditor.GetTextItems: Please Specify AppKey and AppSID");

				} else {
					signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.Sign(strURI);
			}

			InputStream responseStream = Utils.ProcessCommand(signedURI, "GET");

			String strJSON = Utils.StreamToString(responseStream);
			;

			// Parse and Deserializes the JSON to a object.
			TextItemsResponse textItemsResponse = gson.fromJson(strJSON,
					TextItemsResponse.class);

			return textItemsResponse.getTextItems().getList();
	}

	// / <summary>
	// / Gets count of the fragments from a particular page
	// / </summary>
	// / <param name="pageNumber"></param>
	// / <returns></returns>
	public int GetFragmentCount(int pageNumber) {

			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/pdf/" + FileName
					+ "/pages/" + Integer.toString(pageNumber) + "/fragments";
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("TextEditor.GetFragmentCount: Please Specify AppKey and AppSID");

				} else {
					signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.Sign(strURI);
			}

			InputStream responseStream = Utils.ProcessCommand(signedURI, "GET");

			String strJSON = Utils.StreamToString(responseStream);
			;

			// Parse and deserializes the JSON to a object.
			TextItemsResponse textItemsResponse = gson.fromJson(strJSON,
					TextItemsResponse.class);

			return textItemsResponse.getTextItems().getList().size();
	}

	// / <summary>
	// / Gets count of segments in a fragment
	// / </summary>
	// / <param name="pageNumber"></param>
	// / <param name="fragmentNumber"></param>
	// / <returns></returns>
	public int GetSegmentCount(int pageNumber, int fragmentNumber) {

			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/pdf/" + FileName
					+ "/pages/" + Integer.toString(pageNumber) + "/fragments/"
					+ Integer.toString(fragmentNumber);
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("TextEditor.GetSegmentCount: Please Specify AppKey and AppSID");

				} else {
					signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.Sign(strURI);
			}
			InputStream responseStream = Utils.ProcessCommand(signedURI, "GET");

			String strJSON = Utils.StreamToString(responseStream);
			;

			// Parse and deserializes the JSON to a object.
			TextItemsResponse textItemsResponse = gson.fromJson(strJSON,
					TextItemsResponse.class);

			return textItemsResponse.getTextItems().getList().size();
	}

	// / <summary>
	// / Gets TextFormat of a particular Fragment
	// / </summary>
	// / <param name="pageNumber"></param>
	// / <param name="fragmentNumber"></param>
	// / <returns></returns>
	public TextFormat GetTextFormat(int pageNumber, int fragmentNumber) {
			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/pdf/" + FileName
					+ "/pages/" + Integer.toString(pageNumber) + "/fragments/"
					+ Integer.toString(fragmentNumber) + "/textformat";
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("TextEditor.GetTextFormat: Please Specify AppKey and AppSID");

				} else {
					signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.Sign(strURI);
			}

			InputStream responseStream = Utils.ProcessCommand(signedURI, "GET");

			String strJSON = Utils.StreamToString(responseStream);
			;

			// Parse and Deserialize the JSON to a object.
			TextFormatResponse textformatResponse = gson.fromJson(strJSON,
					TextFormatResponse.class);

			return textformatResponse.getTextFormat();
	}

	// / <summary>
	// / Gets TextFormat of a particular Segment
	// / </summary>
	// / <param name="pageNumber"></param>
	// / <param name="fragmentNumber"></param>
	// / <param name="segmentNumber"></param>
	// / <returns></returns>
	public TextFormat GetTextFormat(int pageNumber, int fragmentNumber,
			int segmentNumber) {

			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/pdf/" + FileName
					+ "/pages/" + Integer.toString(pageNumber) + "/fragments/"
					+ Integer.toString(fragmentNumber) + "/segments/"
					+ Integer.toString(segmentNumber) + "/textformat";
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("TextEditor.GetTextFormat: Please Specify AppKey and AppSID");

				} else {
					signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.Sign(strURI);
			}

			InputStream responseStream = Utils.ProcessCommand(signedURI, "GET");

			String strJSON = Utils.StreamToString(responseStream);
			;

			// Parse and Deserialize the JSON to a object.
			TextFormatResponse textformatResponse = gson.fromJson(strJSON,
					TextFormatResponse.class);
			return textformatResponse.getTextFormat();
	}

	// / <summary>
	// / Replace Text in a PDF Document
	// / </summary>
	// / <param name="oldText"></param>
	// / <param name="newText"></param>
	// / <param name="isRegularExpression"></param>
	// / <returns>Number of Matches</returns>
	public int ReplaceText(String oldText, String newText,
			boolean isRegularExpression) {
			// build URI to get replace text
			String strURI = Product.getBaseProductUri() + "/pdf/" + FileName
					+ "/replaceText";
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("TextEditor.ReplaceText: Please Specify AppKey and AppSID");

				} else {
					signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.Sign(strURI);
			}
			// serialize the JSON request content
			TextReplace replaceText = new TextReplace();
			replaceText.setOldValue(oldText);
			replaceText.setNewValue(newText);
			if (isRegularExpression)
				replaceText.setRegex("true");
			else
				replaceText.setRegex("false");

			String strJSON = gson.toJson(replaceText, TextReplace.class);

			InputStream responseStream = Utils.ProcessCommand(signedURI,
					"POST", strJSON);

			// further process JSON response
			String strResponse = Utils.StreamToString(responseStream);

			Gson gson = new Gson();

			// Parse the json string to JObject and Deserializes the JSON to a
			// object.
			ReplaceTextResponse replaceTextResponse = gson.fromJson(
					strResponse, ReplaceTextResponse.class);

			if (replaceTextResponse.getCode().equals("200")
					&& replaceTextResponse.getStatus().equals("OK"))
				return replaceTextResponse.getMatches();
			else
				return 0;

	}

	// / <summary>
	// / Replace Text in Particular Page of PDF Document
	// / </summary>
	// / <param name="pageNumber"></param>
	// / <param name="oldText"></param>
	// / <param name="newText"></param>
	// / <param name="isRegularExpression"></param>
	// / <returns>Number of Matches</returns>
	public int ReplaceText(int pageNumber, String oldText, String newText,
			boolean isRegularExpression) {
			// build URI to get replace text
			String strURI = Product.getBaseProductUri() + "/pdf/" + FileName
					+ "/pages/" + pageNumber + "/replaceText";
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("TextEditor.ReplaceText: Please Specify AppKey and AppSID");

				} else {
					signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.Sign(strURI);
			}

			// serialize the JSON request content
			TextReplace replaceText = new TextReplace();
			replaceText.setOldValue(oldText);
			replaceText.setNewValue(newText);
			if (isRegularExpression)
				replaceText.setRegex("true");
			else
				replaceText.setRegex("false");

			String strJSON = gson.toJson(replaceText, TextReplace.class);

			InputStream responseStream = Utils.ProcessCommand(signedURI,
					"POST", strJSON);

			// further process JSON response
			String strResponse = Utils.StreamToString(responseStream);

			Gson gson = new Gson();

			// Parse the json string to JObject and Deserializes the JSON to a
			// object.
			ReplaceTextResponse replaceTextResponse = gson.fromJson(
					strResponse, ReplaceTextResponse.class);

			if (replaceTextResponse.getCode().equals("200")
					&& replaceTextResponse.getStatus().equals("OK"))
				return replaceTextResponse.getMatches();
			else
				return 0;
	}
	public String GetSegment(int pageNumber, int fragmentNumber, int segmentNumber) {

			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/pdf/" + FileName + "/pages/" +
			pageNumber + "/fragments/" + 
			fragmentNumber + "/segments/" +
			segmentNumber;
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("TextEditor.GetSegment: Please Specify AppKey and AppSID");

				} else {
					signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.Sign(strURI);
			}
			InputStream responseStream = Utils.ProcessCommand(signedURI, "GET");

			String strJSON = Utils.StreamToString(responseStream);
			

			// Parse and deserializes the JSON to a object.
			SagmentResponse segmentResponse = gson.fromJson(strJSON,
					SagmentResponse.class);

			return segmentResponse.getTextItem().getText();
	}
	public int GetAllSegmentCount(int pageNumber, int fragmentNumber) {

			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/pdf/" + FileName + 
					"/pages/" + pageNumber +
					"/fragments/" + fragmentNumber + 
					"/segments";
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("TextEditor.GetAllSegmentCount: Please Specify AppKey and AppSID");
				} else {
					signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.Sign(strURI);
			}
			InputStream responseStream = Utils.ProcessCommand(signedURI, "GET");

			String strJSON = Utils.StreamToString(responseStream);
			;

			// Parse and deserializes the JSON to a object.
			TextItemsResponse textItemsResponse = gson.fromJson(strJSON,
					TextItemsResponse.class);

			return textItemsResponse.getTextItems().getList().size();
	}

}
