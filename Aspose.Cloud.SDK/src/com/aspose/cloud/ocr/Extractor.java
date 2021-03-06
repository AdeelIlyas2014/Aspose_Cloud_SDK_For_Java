package com.aspose.cloud.ocr;

import java.io.FileInputStream;
import java.io.InputStream;

import com.aspose.cloud.common.AsposeAppNonStatic;
import com.aspose.cloud.common.Product;
import com.aspose.cloud.common.Utils;
import com.google.gson.Gson;

/**
 * @author Muhammad Ijaz
 * 
 */

// / <summary>
// / Class to extract text from images.
// / 1. Image from Saaspose server.
// / </summary>
public class Extractor {
	private AsposeAppNonStatic auth;

	// / <summary>
	// / Default constructor
	// / </summary>
	public Extractor() {
		this.gson = new Gson();

	}

	public Extractor(AsposeAppNonStatic auth) {
		this();
		this.auth = auth;
	}

	Gson gson = null;

	// / <summary>
	// / Extract image text using default settings.
	// / </summary>
	// / <param name="fileName">The image file name.</param>
	// / <param name="folder">The image file folder.</param>
	// / <returns><see cref="OCRResponse"/> with the operation result.</returns>
	public OCRResponse extractText(String imageFileName, String folder) {
		try {
			// build URI to extract text
			String strURI = "";
			if (isNullOrEmpty(folder))
				strURI = Product.getBaseProductUri() + "/ocr/" + imageFileName
						+ "/recognize";
			else
				strURI = Product.getBaseProductUri() + "/ocr/" + imageFileName
						+ "/recognize?folder=" + folder;

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
			// execute signed URI request and get response
			InputStream responseStream = Utils.processCommand(signedURI, "GET");

			String strJSON = Utils.streamToString(responseStream);

			// Parse and deserialize the JSON to a object.
			OCRResponse ocrResponse = gson.fromJson(strJSON, OCRResponse.class);

			return ocrResponse;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// / <summary>
	// / Extract image text using specific language.
	// / </summary>
	// / <param name="fileName">The image file name.</param>
	// / <param name="language">The language.</param>
	// / <param name="useDefaultDictionaries">Use default dictionaries or
	// not.</param>
	// / <param name="folder">The image folder.</param>
	// / <returns><see cref="OCRResponse"/> with the operation result.</returns>
	public OCRResponse extractText(String imageFileName, LanguageName language,
			boolean useDefaultDictionaries, String folder) {
		try {

			// build URI to extract text
			String strURI = "";
			if (isNullOrEmpty(folder))
				strURI = Product.getBaseProductUri() + "/ocr/" + imageFileName
						+ "/recognize?language=" + language
						+ "&useDefaultDictionaries=" + useDefaultDictionaries;
			else
				strURI = Product.getBaseProductUri() + "/ocr/" + imageFileName
						+ "/recognize?language=" + language
						+ "&useDefaultDictionaries=" + useDefaultDictionaries
						+ "&folder=" + folder;

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

			// execute signed URI request and get response
			InputStream responseStream = Utils.processCommand(signedURI, "GET");

			String strJSON = Utils.streamToString(responseStream);

			// Parse and deserialize the JSON to a object.
			OCRResponse ocrResponse = gson.fromJson(strJSON, OCRResponse.class);

			return ocrResponse;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// / <summary>
	// / Extract image text from local file.
	// / </summary>
	// / <param name="localFile">The local file.</param>
	// / <param name="language">The text language.</param>
	// / <param name="useDefaultDictionaries">Use default dictionaries or
	// not.</param>
	// / <returns><see cref="OCRResponse"/> with the operation result.</returns>
	public OCRResponse extractText(String localFile, LanguageName language,
			boolean useDefaultDictionaries) {
		try {

			// build URI to extract text
			String strURI = Product.getBaseProductUri()
					+ "/ocr/recognize?language=" + language
					+ "&useDefaultDictionaries=" + useDefaultDictionaries;

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
			InputStream fileStream = new FileInputStream(localFile);

			// execute signed URI request and get response
			InputStream responseStream = Utils.processCommand(signedURI,
					"POST", fileStream);

			String strJSON = Utils.streamToString(responseStream);

			// Parse and deserialize the JSON to a object.
			OCRResponse ocrResponse = gson.fromJson(strJSON, OCRResponse.class);

			return ocrResponse;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// / <summary>
	// / Extract image text from stream.
	// / </summary>
	// / <param name="stream">The stream with image data.</param>
	// / <param name="language">Language.</param>
	// / <param name="useDefaultDictionaries">Use default dictionaries or
	// not.</param>
	// / <returns><see cref="OCRResponse"/> with the operation result.</returns>
	public OCRResponse extractText(InputStream stream, LanguageName language,
			boolean useDefaultDictionaries) {
		try {

			// build URI to extract text
			String strURI = Product.getBaseProductUri()
					+ "/ocr/recognize?language=" + language
					+ "&useDefaultDictionaries=" + useDefaultDictionaries;

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

			// execute signed URI request and get response
			InputStream responseStream = Utils.processCommand(signedURI,
					"POST", stream);

			String strJSON = Utils.streamToString(responseStream);

			// Parse and deserialize the JSON to a object.
			OCRResponse ocrResponse = gson.fromJson(strJSON, OCRResponse.class);

			return ocrResponse;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// / <summary>
	// / Scans whole or part of images and extracts OCR text
	// / </summary>
	// / <param name="imageFileName">Name of the image file</param>
	public OCRResponse extractText(String imageFileName) {
		try {
			// build URI to extract text
			String strURI = Product.getBaseProductUri() + "/ocr/"
					+ imageFileName + "/recognize?useDefaultDictionaries=true";

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

			// execute signed URI request and get response
			InputStream responseStream = Utils.processCommand(signedURI, "GET");

			String strJSON = Utils.streamToString(responseStream);

			// Parse and deserialize the JSON to a object.
			OCRResponse ocrResponse = gson.fromJson(strJSON, OCRResponse.class);

			return ocrResponse;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	// / <summary>
	// / Scans whole or part of images and extracts OCR text
	// / </summary>
	// / <param name="imageFileName">Name of the image file</param>
	// / <param name="language">Language of document to recognize</param>
	// / <param name="useDefaultDictionaries">Allows to correct text after
	// recognition using default dictionaries</param>
	// / <param name="x">Start x of the rectangle: Recognition of text inside
	// specified Rectangle region</param>
	// / <param name="y">Start y of the rectangle: Recognition of text inside
	// specified Rectangle region</param>
	// / <param name="width">Width of the rectangle: Recognition of text inside
	// specified Rectangle region</param>
	// / <param name="height">Height of the rectangle: Recognition of text
	// inside specified Rectangle region</param>
	// / <param name="folder">Folder with images to recognize</param>
	// / <returns></returns>
	public OCRResponse extractText(String imageFileName, LanguageName language,
			boolean useDefaultDictionaries, int x, int y, int width,
			int height, String folder) {
		try {
			// build URI to extract text
			String strURI = Product.getBaseProductUri()
					+ "/ocr/"
					+ imageFileName
					+ "/recognize?language="
					+ language
					+ ((x >= 0 && y >= 0 && width > 0 && height > 0) ? "&rectX="
							+ x
							+ "&rectY="
							+ y
							+ "&rectWidth="
							+ width
							+ "&rectHeight=" + height
							: "") + "&useDefaultDictionaries="
					+ ((useDefaultDictionaries) ? "true" : "false")
					+ ((isNullOrEmpty(folder)) ? "" : "&folder=" + folder);

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

			// execute signed URI request and get response
			InputStream responseStream = Utils.processCommand(signedURI, "GET");

			String strJSON = Utils.streamToString(responseStream);

			// Parse and deserialize the JSON to a object.
			OCRResponse ocrResponse = gson.fromJson(strJSON, OCRResponse.class);

			return ocrResponse;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	// / <summary>
	// / Extract Text from remote image URL.
	// / </summary>
	// / <param name="url">The image url.</param>
	// / <param name="language">The specific language.</param>
	// / <param name="useDefaultDictionaries">Use default dictionaries or
	// not.</param>
	// / <returns><see cref="OCRResponse"/> with the operation result.</returns>
	public OCRResponse extractTextFromURL(String url, LanguageName language,
			boolean useDefaultDictionaries) {
		try {

			// build URI to extract text
			String strURI = Product.getBaseProductUri() + "/ocr/recognize?url="
					+ url + "&language=" + language
					+ "&useDefaultDictionaries=" + useDefaultDictionaries;

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
			// execute signed URI request and get response
			InputStream responseStream = Utils
					.processCommand(signedURI, "POST");

			String strJSON = Utils.streamToString(responseStream);

			// Parse and deserialize the JSON to a object.
			OCRResponse ocrResponse = gson.fromJson(strJSON, OCRResponse.class);

			return ocrResponse;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static boolean isNull(String str) {
		return str == null ? true : false;
	}

	public static boolean isNullOrEmpty(String param) {
		if (isNull(param) || param.trim().length() == 0) {
			return true;
		}
		return false;
	}

}
