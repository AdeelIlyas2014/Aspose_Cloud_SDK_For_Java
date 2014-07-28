/**
 * 
 */
package com.aspose.cloud.pdf;

import com.aspose.cloud.common.*;
import com.aspose.cloud.exceptions.AuthorizationException;
import com.aspose.cloud.exceptions.CommonIOException;
import com.aspose.cloud.exceptions.PdfIOException;
import com.aspose.cloud.pdf.SaveFormat;
import com.aspose.cloud.storage.Folder;

import java.lang.String;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Mudassir
 * 
 */
// / <summary>
// / converts pages or document into different formats
// / </summary>
public class Converter {
	private AsposeAppNonStatic auth;

	public Converter(String fileName) {
		FileName = fileName;
	}

	public Converter(String fileName, AsposeAppNonStatic auth) {
		this(fileName);
		this.auth = auth;
	}

	// / <summary>
	// / PDF document name
	// / </summary>
	public String FileName;

	// / <summary>
	// / convert a particular page to image
	// / </summary>
	// / <param name="outputPath"></param>
	// / <param name="pageNumber"></param>
	public boolean GetImage(String outputPath, int pageNumber,
			ConvertImageFormat imageFormat, SaveLocation saveLocation,
			int imageHeight, int imageWidth) {
			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/pdf/" + FileName
					+ "/pages/" + Integer.toString(pageNumber);
			strURI += "?format=" + imageFormat.toString();
			strURI += "&width=" + Integer.toString(imageWidth);
			strURI += "&height=" + Integer.toString(imageHeight);

			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("Converter.GetImage: Please Specify AppKey and AppSID");

				} else {
					signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.Sign(strURI);
			}

			InputStream responseStream = Utils.ProcessCommand(signedURI, "GET");
			boolean response = Folder.SaveStreamToFile(outputPath,
					responseStream);
			try {
				responseStream.close();
			} catch (IOException e) {
				throw new PdfIOException("Converter.GetImage Some error occurred while closing stream",e);

			}
			return response;

	}

	// / <summary>
	// / convert a particular page to image with default size
	// / </summary>
	// / <param name="outputPath"></param>
	// / <param name="pageNumber"></param>
	public boolean GetImage(String outputPath, int pageNumber,
			ConvertImageFormat imageFormat, SaveLocation saveLocation) {
			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/pdf/" + FileName
					+ "/pages/" + Integer.toString(pageNumber);
			strURI += "?format=" + imageFormat.toString();

			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("Converter.GetImage: Please Specify AppKey and AppSID");

				} else {
					signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.Sign(strURI);
			}
			InputStream responseStream = Utils.ProcessCommand(signedURI, "GET");
			boolean response = Folder.SaveStreamToFile(outputPath,
					responseStream);
			try {
				responseStream.close();
			} catch (IOException e) {
				throw new PdfIOException("Converter.GetImage Some error occurred while closing stream",e);
			}
			return response;
	

	}

	// / <summary>
	// / save the document into various formats
	// / </summary>
	// / <param name="outputPath"></param>
	// / <param name="saveFormat"></param>
	public boolean Convert(String outputPath, SaveFormat saveFormat) {


			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/pdf/" + FileName;
			strURI += "?format=" + saveFormat.toString();

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
			boolean response = Folder.SaveStreamToFile(outputPath,
					responseStream);
			try {
				responseStream.close();
			} catch (IOException e) {
				throw new PdfIOException("Converter.Convert Some error occurred while closing stream",e);
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
					+ "/pdf/convert?format=" + outputFormat;

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
				throw new PdfIOException("Converter.ConvertLocalFile: Specified file not found!",e);
			}

			// get response stream
			InputStream responseStream = Utils.ProcessCommand(signedURI, "PUT",
					fileStream);

			Folder.SaveStreamToFile(outputPath, responseStream);

			try {
				responseStream.close();
			} catch (IOException e) {
				throw new PdfIOException("Converter.ConvertLocalFile Some error occurred while closing stream",e);
			}


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
					+ "/pdf/convert?format=" + outputFormat;

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

			return Utils.ProcessCommand(signedURI, "PUT", inputStream);

	}

}
