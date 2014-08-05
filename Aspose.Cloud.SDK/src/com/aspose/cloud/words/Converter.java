package com.aspose.cloud.words;

import java.io.FileInputStream;
import java.io.InputStream;

import com.aspose.cloud.common.AsposeAppNonStatic;
import com.aspose.cloud.common.Product;
import com.aspose.cloud.common.Utils;
import com.aspose.cloud.storage.Folder;

/// <summary>
/// Class to convert file to different formats
/// </summary>
public class Converter {
	private AsposeAppNonStatic auth;

	public Converter(String _fileName) {
		// set default values
		fileName = _fileName;
		saveformat = SaveFormat.Doc;
	}

	public Converter(String fileName, AsposeAppNonStatic auth) {
		this(fileName);
		this.auth = auth;
	}

	// / <summary>
	// / get or set Doc file name
	// / </summary>
	public String fileName;

	// / <summary>
	// / get or set the SaveFormat type
	// / </summary>
	public SaveFormat saveformat;

	// / <summary>
	// / convert a document to SaveFormat
	// / </summary>
	// / <param name="output">the location of the output file</param>
	public boolean convert(String output) {
		try {
			// check whether file is set or not
			if (fileName.equals(""))
				throw new Exception("No file name specified");

			// build URI
			String strURI = Product.getBaseProductUri() + "/words/" + fileName;
			strURI += "?format=" + saveformat;

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
			boolean response = Folder.saveStreamToFile(output, responseStream);
			responseStream.close();
			return response;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	// / <summary>
	// / convert a document to SaveFormat
	// / </summary>
	// / <param name="output">the location of the output file</param>
	// / /// <param name="output">SaveFormat of the output file</param>
	public boolean convert(String output, SaveFormat OutPutType) {
		try {
			// check whether file is set or not
			if (fileName.equals(""))
				throw new Exception("No file name specified");

			// build URI
			String strURI = Product.getBaseProductUri() + "/words/" + fileName;
			strURI += "?format=" + OutPutType;

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
			boolean response = Folder.saveStreamToFile(output, responseStream);
			responseStream.close();
			return response;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	// / <summary>
	// / Convert Document to different file format without using storage
	// / </summary>
	// / <param name="outputFileName"></param>
	// / <param name="outputFormat"></param>
	public void convertLocalFile(String inputPath, String outputPath,
			SaveFormat outputFormat) {
		try {

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/words/convert?format=" + outputFormat;

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
			InputStream fileStream = new FileInputStream(inputPath);

			// get response stream
			InputStream responseStream = Utils.processCommand(signedURI, "PUT",
					fileStream);

			Folder.saveStreamToFile(outputPath, responseStream);
			responseStream.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	// / <summary>
	// / Convert document to different file format without using storage
	// / </summary>
	// / <param name="outputFileName"></param>
	// / <param name="outputFormat"></param>
	public InputStream convertLocalFile(InputStream inputStream,
			SaveFormat outputFormat) {
		try {
			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/words/convert?format=" + outputFormat;

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

			// InputStream ResponseStream;

			// ResponseStream = Utils.ProcessCommand(signedURI, "PUT",
			// inputStream);//, Stream);

			return Utils.processCommand(signedURI, "PUT", inputStream);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}

	}

}