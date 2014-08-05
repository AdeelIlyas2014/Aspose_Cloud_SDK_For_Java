package com.aspose.cloud.words;

import java.io.InputStream;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.aspose.cloud.common.AsposeAppNonStatic;
import com.aspose.cloud.common.Product;
import com.aspose.cloud.common.Utils;
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

	public void executeMailMerege(String fileName, String strXML,
			SaveFormat saveformat, String outputPath) {
		try {
			// build URI to get Image
			String strURI = Product.getBaseProductUri() + "/words/" + fileName
					+ "/executeMailMerge";

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
					"POST", strXML, "xml");

			String strJSON = Utils.streamToString(responseStream);

			InputSource source = new InputSource(new StringReader(strJSON));

			// Parse the input document
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			javax.xml.parsers.DocumentBuilder builder = factory
					.newDocumentBuilder();
			org.w3c.dom.Document doc = builder.parse(source);

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
				} else {
					signedURI = Utils.sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.sign(strURI);
			}

			// get response stream
			responseStream = Utils.processCommand(signedURI, "GET");

			Folder.saveStreamToFile(outputPath, responseStream);
			responseStream.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// / <summary>
	// / Execute mail merge with regions.
	// / </summary>
	// / <param name="FileName"></param>
	// / <param name="strXML"></param>
	// / <param name="saveformat"></param>
	// / <param name="output"></param>
	public void executeMailMeregewithRegions(String fileName, String strXML,
			SaveFormat saveformat, String outputPath) {
		try {
			// build URI to get Image
			String strURI = Product.getBaseProductUri() + "/words/" + fileName
					+ "/executeMailMerge?withRegions=true";

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
					"POST", strXML, "xml");

			// further process JSON response
			String strResponse = Utils.streamToString(responseStream);

			InputSource source = new InputSource(new StringReader(strResponse));

			// Parse the input document
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			javax.xml.parsers.DocumentBuilder builder = factory
					.newDocumentBuilder();
			org.w3c.dom.Document doc = builder.parse(source);

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
				} else {
					signedURI = Utils.sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.sign(strURI);
			}

			// get response stream
			responseStream = Utils.processCommand(signedURI, "GET");

			Folder.saveStreamToFile(outputPath, responseStream);
			responseStream.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// / <summary>
	// / Execute mail merge template.
	// / </summary>
	// / <param name="FileName"></param>
	// / <param name="strXML"></param>
	// / <param name="saveformat"></param>
	// / <param name="output"></param>
	public void executeTemplate(String fileName, String strXML,
			SaveFormat saveformat, String outputPath) {
		try {
			// build URI to get Image
			String strURI = Product.getBaseProductUri() + "/words/" + fileName
					+ "/executeTemplate";
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
					"POST", strXML, "xml");

			String strJSON = Utils.streamToString(responseStream);

			InputSource source = new InputSource(new StringReader(strJSON));

			// Parse the input document
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			javax.xml.parsers.DocumentBuilder builder = factory
					.newDocumentBuilder();
			org.w3c.dom.Document doc = builder.parse(source);

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
				} else {
					signedURI = Utils.sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.sign(strURI);
			}
			// get response stream
			responseStream = Utils.processCommand(signedURI, "GET");

			Folder.saveStreamToFile(outputPath, responseStream);
			responseStream.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
