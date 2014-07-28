package com.aspose.cloud.words;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import com.aspose.cloud.common.AsposeAppNonStatic;
import com.aspose.cloud.common.Product;
import com.aspose.cloud.common.Utils;
import com.aspose.cloud.exceptions.AuthorizationException;
import com.aspose.cloud.exceptions.CommonIOException;
import com.aspose.cloud.exceptions.ParameterMissingException;
import com.aspose.cloud.exceptions.SlidesIOException;
import com.aspose.cloud.exceptions.WordsException;
import com.aspose.cloud.exceptions.WordsIOException;
import com.aspose.cloud.storage.Folder;

/// <summary>
/// Class to convert file to different formats
/// </summary>
public class Converter {
	private AsposeAppNonStatic auth;

	public Converter(String fileName) {
		// set default values
		FileName = fileName;
		saveformat = SaveFormat.Doc;
	}

	public Converter(String fileName, AsposeAppNonStatic auth) {
		this(fileName);
		this.auth = auth;
	}

	// / <summary>
	// / get or set Doc file name
	// / </summary>
	public String FileName;

	// / <summary>
	// / get or set the SaveFormat type
	// / </summary>
	public SaveFormat saveformat;

	// / <summary>
	// / convert a document to SaveFormat
	// / </summary>
	// / <param name="output">the location of the output file</param>
	public boolean Convert(String output) {
			// check whether file is set or not
			if (FileName.equals(""))
				throw new ParameterMissingException("No file name specified");

			// build URI
			String strURI = Product.getBaseProductUri() + "/words/" + FileName;
			strURI += "?format=" + saveformat;

			// sign URI
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
			boolean response = Folder.SaveStreamToFile(output, responseStream);
			try {
				responseStream.close();
			} catch (IOException e) {
				throw new WordsIOException("Conveter.Convert Some error occurred while closing steam",e);

			}
			return response;
	}

	// / <summary>
	// / convert a document to SaveFormat
	// / </summary>
	// / <param name="output">the location of the output file</param>
	// / /// <param name="output">SaveFormat of the output file</param>
	public boolean Convert(String output, SaveFormat OutPutType) {
			// check whether file is set or not
			if (FileName.equals(""))
				throw new ParameterMissingException("No file name specified");

			// build URI
			String strURI = Product.getBaseProductUri() + "/words/" + FileName;
			strURI += "?format=" + OutPutType;

			// sign URI
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("Converter.Convert: Please Specify AppKey and AppSID");

					
				} else {
					signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.Sign(strURI);
			}

			InputStream responseStream = Utils.ProcessCommand(signedURI, "GET");
			boolean response = Folder.SaveStreamToFile(output, responseStream);
			try {
				responseStream.close();
			} catch (IOException e) {
				throw new WordsIOException("Conveter.Convert Some error occurred while closing steam",e);

			}
			return response;
	}

	// / <summary>
	// / Convert Document to different file format without using storage
	// / </summary>
	// / <param name="outputFileName"></param>
	// / <param name="outputFormat"></param>
	public void ConvertLocalFile(String inputPath, String outputPath,
			SaveFormat outputFormat) {

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/words/convert?format=" + outputFormat;

			// sign URI
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("Converter.ConvertLocalFile: Please Specify AppKey and AppSID");

					
				} else {
					signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.Sign(strURI);
			}
			InputStream fileStream;
			try {
				fileStream = new FileInputStream(inputPath);
			} catch (FileNotFoundException e) {
			    throw new WordsException("Converter.ConvertLocalFile: Specified file not found.",e);
			}

			// get response stream
			InputStream responseStream = Utils.ProcessCommand(signedURI, "PUT",
					fileStream);

			Folder.SaveStreamToFile(outputPath, responseStream);
			responseStream.close();

	}

	// / <summary>
	// / Convert document to different file format without using storage
	// / </summary>
	// / <param name="outputFileName"></param>
	// / <param name="outputFormat"></param>
	public InputStream ConvertLocalFile(InputStream inputStream,
			SaveFormat outputFormat) {
			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/words/convert?format=" + outputFormat;

			// sign URI
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("Converter.ConvertLocalFile: Please Specify AppKey and AppSID");

				} else {
					signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.Sign(strURI);
			}

			// InputStream ResponseStream;

			// ResponseStream = Utils.ProcessCommand(signedURI, "PUT",
			// inputStream);//, Stream);

			return Utils.ProcessCommand(signedURI, "PUT", inputStream);

	}

}