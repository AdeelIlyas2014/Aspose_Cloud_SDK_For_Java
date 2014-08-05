/**
 * 
 */
package com.aspose.cloud.pdf;

import java.io.InputStream;

import com.aspose.cloud.common.AsposeAppNonStatic;
import com.aspose.cloud.common.Product;
import com.aspose.cloud.common.Utils;
import com.aspose.cloud.storage.Folder;
import com.google.gson.Gson;

/**
 * @author Mudassir
 * 
 */
// / <summary>
// / Extract various types of information from the document
// / </summary>
public class Extractor {
	private AsposeAppNonStatic auth;

	public Extractor(String _fileName) {
		fileName = _fileName;
	}

	public Extractor(String fileName, AsposeAppNonStatic auth) {
		this(fileName);
		this.auth = auth;
	}

	// / <summary>
	// / PDF document name
	// / </summary>
	public String fileName;

	// / <summary>
	// / Gets number of images in a specified page
	// / </summary>
	// / <param name="pageNumber"></param>
	// / <returns></returns>
	public int getImageCount(int pageNumber) {
		try {
			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/pdf/" + fileName
					+ "/pages/" + Integer.toString(pageNumber) + "/images";
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
			;

			Gson gson = new Gson();
			// Parse and Deserializes the JSON to a object.
			ImagesResponse imagesResponse = gson.fromJson(strJSON,
					ImagesResponse.class);

			return imagesResponse.getImages().getList().size();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}

	}

	// / <summary>
	// / Get the particular image from the specified page
	// / </summary>
	// / <param name="outputPath"></param>
	// / <param name="pageNumber"></param>
	public boolean getImage(String outputPath, int pageNumber, int imageIndex,
			ExtractImageFormat imageFormat, SaveLocation saveLocation,
			int imageHeight, int imageWidth) {
		try {

			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/pdf/" + fileName
					+ "/pages/" + Integer.toString(pageNumber) + "/images/"
					+ Integer.toString(imageIndex);
			strURI += "?format=" + imageFormat.toString();
			strURI += "&width=" + Integer.toString(imageWidth);
			strURI += "&height=" + Integer.toString(imageHeight);

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
			boolean response = Folder.saveStreamToFile(outputPath,
					responseStream);
			responseStream.close();
			return response;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	// / <summary>
	// / Get the particular image from the specified page with the default image
	// size
	// / </summary>
	// / <param name="outputPath"></param>
	// / <param name="pageNumber"></param>
	public boolean getImage(String outputPath, int pageNumber, int imageIndex,
			ExtractImageFormat imageFormat, SaveLocation saveLocation) {
		try {

			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/pdf/" + fileName
					+ "/pages/" + Integer.toString(pageNumber) + "/images/"
					+ Integer.toString(imageIndex);
			strURI += "?format=" + imageFormat.toString();

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

			boolean response = Folder.saveStreamToFile(outputPath,
					responseStream);
			responseStream.close();
			return response;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

}
