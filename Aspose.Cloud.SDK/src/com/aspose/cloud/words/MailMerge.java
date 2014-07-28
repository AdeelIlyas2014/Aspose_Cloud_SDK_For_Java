package com.aspose.cloud.words;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.aspose.cloud.common.AsposeAppNonStatic;
import com.aspose.cloud.common.Product;
import com.aspose.cloud.common.Utils;
import com.aspose.cloud.exceptions.AuthorizationException;
import com.aspose.cloud.exceptions.CommonIOException;
import com.aspose.cloud.exceptions.WordsException;
import com.aspose.cloud.exceptions.WordsIOException;
import com.aspose.cloud.storage.Folder;

public class MailMerge {
	private AsposeAppNonStatic auth;

	public MailMerge() {
	}

	public MailMerge(AsposeAppNonStatic auth) {
		this.auth = auth;
	}

	// / <summary>
	// / Execute mail merge without regions.
	// / </summary>
	// / <param name="FileName"></param>
	// / <param name="strXML"></param>
	// / <param name="saveformat"></param>
	// / <param name="output"></param>

	public void ExecuteMailMerege(String FileName, String strXML,
			SaveFormat saveformat, String outputPath) {
			// build URI to get Image
			String strURI = Product.getBaseProductUri() + "/words/" + FileName
					+ "/executeMailMerge";

			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("MailMerge.ExecuteMailMerege Please Specify AppKey and AppSID");
					
				} else {
					signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.Sign(strURI);
			}

			InputStream responseStream = Utils.ProcessCommand(signedURI,
					"POST", strXML, "xml");

			String strJSON = Utils.StreamToString(responseStream);

			InputSource source = new InputSource(new StringReader(strJSON));

			// Parse the input document
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			javax.xml.parsers.DocumentBuilder builder;
			try {
				builder = factory
						.newDocumentBuilder();
			} catch (ParserConfigurationException e1) {
			 throw new WordsException("MailMerge.ExecuteMailMerege Some Error occurred while doing mail merge for words.",e1);
			}
			org.w3c.dom.Document doc;
				try {
					doc = builder.parse(source);
				
				} catch (SAXException e) {
					 throw new WordsException("MailMerge.ExecuteMailMerege Some Error occurred while doing mail merge for words.",e);
						
				} catch (IOException e) {
					 throw new WordsIOException("MailMerge.ExecuteMailMerege Some IO Error occurred while doing mail merge for words.",e);
					 
				}	

			NodeList nodes = doc.getElementsByTagName("FileName");
			String DocName = nodes.item(0).getChildNodes().item(0)
					.getNodeValue();

			// build URI
			strURI = Product.getBaseProductUri() + "/words/" + DocName;
			strURI += "?format=" + saveformat;

			// sign URI

			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("MailMerge.ExecuteMailMerege Please Specify AppKey and AppSID");
				} else {
					signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.Sign(strURI);
			}

			// get response stream
			responseStream = Utils.ProcessCommand(signedURI, "GET");

			Folder.SaveStreamToFile(outputPath, responseStream);
			try {
				responseStream.close();
			} catch (IOException e) {
				throw new WordsIOException("MailMerge.ExecuteMailMerege Some error occurred while closing steam",e);

			}
			
	}

	// / <summary>
	// / Execute mail merge with regions.
	// / </summary>
	// / <param name="FileName"></param>
	// / <param name="strXML"></param>
	// / <param name="saveformat"></param>
	// / <param name="output"></param>
	public void ExecuteMailMeregewithRegions(String FileName, String strXML,
			SaveFormat saveformat, String outputPath) {
			// build URI to get Image
			String strURI = Product.getBaseProductUri() + "/words/" + FileName
					+ "/executeMailMerge?withRegions=true";

			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("MailMerge.ExecuteMailMeregewithRegions Please Specify AppKey and AppSID");
					
				} else {
					signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.Sign(strURI);
			}
			InputStream responseStream = Utils.ProcessCommand(signedURI,
					"POST", strXML, "xml");

			// further process JSON response
			String strResponse = Utils.StreamToString(responseStream);

			InputSource source = new InputSource(new StringReader(strResponse));

			// Parse the input document
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			javax.xml.parsers.DocumentBuilder builder=null;
			try {
				builder = factory
						.newDocumentBuilder();
			} catch (ParserConfigurationException e) {
				 throw new WordsException("MailMerge.ExecuteMailMeregewithRegions Some Error occurred while doing mail merge for words.",e);
					
			}
			org.w3c.dom.Document doc;
			try {
				doc = builder.parse(source);
			} catch (SAXException e) {
				 throw new WordsException("MailMerge.ExecuteMailMeregewithRegions Some Error occurred while doing mail merge for words.",e);
					
			} catch (IOException e) {
				 throw new WordsIOException("MailMerge.ExecuteMailMeregewithRegions Some IO Error occurred while doing mail merge for words.",e);
					
			}

			NodeList nodes = doc.getElementsByTagName("FileName");
			String DocName = nodes.item(0).getChildNodes().item(0)
					.getNodeValue();

			// build URI
			strURI = Product.getBaseProductUri() + "/words/" + DocName;
			strURI += "?format=" + saveformat;

			// sign URI

			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("MailMerge.ExecuteMailMeregewithRegions Please Specify AppKey and AppSID");
					
				} else {
					signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.Sign(strURI);
			}

			// get response stream
			responseStream = Utils.ProcessCommand(signedURI, "GET");

			Folder.SaveStreamToFile(outputPath, responseStream);
			try {
				responseStream.close();
			} catch (IOException e) {
				throw new WordsIOException("MailMerge.ExecuteMailMeregewithRegions Some error occurred while closing steam",e);

			}

	}

	// / <summary>
	// / Execute mail merge template.
	// / </summary>
	// / <param name="FileName"></param>
	// / <param name="strXML"></param>
	// / <param name="saveformat"></param>
	// / <param name="output"></param>
	public void ExecuteTemplate(String FileName, String strXML,
			SaveFormat saveformat, String outputPath) {
			// build URI to get Image
			String strURI = Product.getBaseProductUri() + "/words/" + FileName
					+ "/executeTemplate";
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("MailMerge.ExecuteTemplate Please Specify AppKey and AppSID");
					
				} else {
					signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.Sign(strURI);
			}

			InputStream responseStream = Utils.ProcessCommand(signedURI,
					"POST", strXML, "xml");

			String strJSON = Utils.StreamToString(responseStream);

			InputSource source = new InputSource(new StringReader(strJSON));

			// Parse the input document
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			javax.xml.parsers.DocumentBuilder builder;
			try {
				builder = factory
						.newDocumentBuilder();
			} catch (ParserConfigurationException e) {
				 throw new WordsException("MailMerge.ExecuteTemplate Some Error occurred while doing mail merge for words.",e);
					
			}
			org.w3c.dom.Document doc;
			try {
				doc = builder.parse(source);
			} catch (SAXException e) {
				 throw new WordsException("MailMerge.ExecuteTemplate Some Error occurred while doing mail merge for words.",e);
					
			} catch (IOException e) {
				 throw new WordsIOException("MailMerge.ExecuteTemplate Some IO Error occurred while doing mail merge for words.",e);
					
			}

			NodeList nodes = doc.getElementsByTagName("FileName");
			String DocName = nodes.item(0).getChildNodes().item(0)
					.getNodeValue();

			// build URI
			strURI = Product.getBaseProductUri() + "/words/" + DocName;
			strURI += "?format=" + saveformat;

			// sign URI
			
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("MailMerge.ExecuteTemplate Please Specify AppKey and AppSID");
					
				} else {
					signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.Sign(strURI);
			}
			// get response stream
			responseStream = Utils.ProcessCommand(signedURI, "GET");

			Folder.SaveStreamToFile(outputPath, responseStream);
			try {
				responseStream.close();
			} catch (IOException e) {
				throw new WordsIOException("MailMerge.ExecuteTemplate Some error occurred while closing steam",e);

			}
	}

}
