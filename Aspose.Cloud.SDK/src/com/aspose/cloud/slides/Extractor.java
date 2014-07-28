/**
 * 
 */
package com.aspose.cloud.slides;

import java.io.InputStream;
import java.util.List;

import com.aspose.cloud.common.AsposeAppNonStatic;
import com.aspose.cloud.common.Product;
import com.aspose.cloud.common.Utils;
import com.aspose.cloud.exceptions.AuthorizationException;
import com.aspose.cloud.exceptions.CommonIOException;
import com.aspose.cloud.storage.StorageType;
import com.google.gson.Gson;

/**
 * @author Mudassir
 * 
 */
// / <summary>
// / Deals with PowerPoint presentation level aspects
// / </summary>
public class Extractor {
	private AsposeAppNonStatic auth;

	public Extractor(String fileName) {
		FileName = fileName;
		gson = new Gson();
	}

	public Extractor(String fileName, AsposeAppNonStatic auth) {
		this(fileName);
		this.auth = auth;
	}

	// / <summary>
	// / Presentation name
	// / </summary>
	public String FileName;
	Gson gson = null;

	// / <summary>
	// / Gets total number of images in a presentation
	// / </summary>
	// / <returns>Total number of images</returns>
	public int GetImageCount() {
			// build URI to get image count
			String strURI = Product.getBaseProductUri() + "/slides/" + FileName
					+ "/images";
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("Document.GetImageCount: Please Specify AppKey and AppSID");

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
			ImagesResponse imagesResponse = gson.fromJson(strJSON,
					ImagesResponse.class);

			return imagesResponse.getImages().getList().size();
	}

	public int GetImageCount(StorageType storageType, String storageName,
			String folderName) {
			// build URI to get image count
			String strURI = Product.getBaseProductUri()
					+ "/slides/"
					+ FileName
					+ "/images"
					+ (folderName.equals("") || folderName.equals(null) ? ""
							: "?folder=" + folderName);
			if (storageType.equals(StorageType.AmazonS3)) {
				strURI.concat("&storage=" + storageName);
			}
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("Document.GetImageCount: Please Specify AppKey and AppSID");

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
			ImagesResponse imagesResponse = gson.fromJson(strJSON,
					ImagesResponse.class);

			return imagesResponse.getImages().getList().size();
	}

	// / <summary>
	// / Gets total number of images in a presentation
	// / </summary>
	// / <returns>Total number of images</returns>
	public List<com.aspose.cloud.slides.Image> GetPresentationImages() {
			// build URI to get image count
			String strURI = Product.getBaseProductUri() + "/slides/" + FileName
					+ "/images";
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("Document.GetPresentationImages: Please Specify AppKey and AppSID");

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
			ImagesResponse imagesResponse = gson.fromJson(strJSON,
					ImagesResponse.class);

			return imagesResponse.getImages().getList();
	}

	// / <summary>
	// / Gets number of images in the specified slide
	// / </summary>
	// / <param name="slideNumber"></param>
	// / <returns></returns>
	public int GetImageCount(int slideNumber) {
			// build URI to get image count
			String strURI = Product.getBaseProductUri() + "/slides/" + FileName
					+ "/slides/" + Integer.toString(slideNumber) + "/images";
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("Document.GetImageCount: Please Specify AppKey and AppSID");

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
			ImagesResponse imagesResponse = gson.fromJson(strJSON,
					ImagesResponse.class);

			return imagesResponse.getImages().getList().size();
	}

	public int GetImageCount(int slideNumber, StorageType storageType,
			String storageName, String folderName) {
			// build URI to get image count
			String strURI = Product.getBaseProductUri()
					+ "/slides/"
					+ FileName
					+ "/slides/"
					+ Integer.toString(slideNumber)
					+ "/images"
					+ (folderName.equals("") || folderName.equals(null) ? ""
							: "?folder=" + folderName);
			if (storageType.equals(StorageType.AmazonS3)) {
				strURI.concat("&storage=" + storageName);
			}
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("Document.GetImageCount: Please Specify AppKey and AppSID");

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
			ImagesResponse imagesResponse = gson.fromJson(strJSON,
					ImagesResponse.class);

			return imagesResponse.getImages().getList().size();
	}

	// / <summary>
	// / Gets all shapes from the specified slide
	// / </summary>
	// / <param name="slideNumber"></param>
	// / <returns></returns>
	public List<Shape> GetShapes(int slideNumber) {
			// build URI to get shapes
			String strURI = Product.getBaseProductUri() + "/slides/" + FileName
					+ "/slides/" + Integer.toString(slideNumber) + "/shapes";
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("Document.GetShapes: Please Specify AppKey and AppSID");

				} else {
					signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.Sign(strURI);
			}

			InputStream responseStream = Utils.ProcessCommand(signedURI, "GET");

			String strJSON = Utils.StreamToString(responseStream);
			System.out.println(strJSON);
			
			// Parse and deserialize the JSON to a object.
			ShapesResponse shapesResponse = gson.fromJson(strJSON,
					ShapesResponse.class);

			List<Shape> shapes = new java.util.ArrayList<Shape>();
			for (ShapeURI shapeURI : shapesResponse.getShapes().getList()) {
				// Parse the json String to JObject
				String strResponse = ProcessURI(shapeURI.getUri().getHref());

				// Parse and deserialize the JSON to a object.
				ShapeResponse shapeResponse = gson.fromJson(strResponse,
						ShapeResponse.class);
				shapes.add(shapeResponse.getShape());
			}

			return shapes;
	}

	public List<Shape> GetShapes(int slideNumber, StorageType storageType,
			String storageName, String folderName) {
			// build URI to get shapes
			String strURI = Product.getBaseProductUri()
					+ "/slides/"
					+ FileName
					+ "/slides/"
					+ Integer.toString(slideNumber)
					+ "/shapes"
					+ (folderName.equals("") || folderName.equals(null) ? ""
							: "?folder=" + folderName);
			if (storageType.equals(StorageType.AmazonS3)) {
				strURI.concat("&storage=" + storageName);
			}
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("Document.GetShapes: Please Specify AppKey and AppSID");

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
			ShapesResponse shapesResponse = gson.fromJson(strJSON,
					ShapesResponse.class);

			List<Shape> shapes = new java.util.ArrayList<Shape>();
			for (ShapeURI shapeURI : shapesResponse.getShapes().getList()) {
				// Parse the json String to JObject
				String strResponse = ProcessURI(shapeURI.getUri().getHref());

				// Parse and deserialize the JSON to a object.
				ShapeResponse shapeResponse = gson.fromJson(strResponse,
						ShapeResponse.class);
				shapes.add(shapeResponse.getShape());
			}

			return shapes;
	}

	// / <summary>
	// / Gets all shapes from the specified slide
	// / </summary>
	// / <param name="slideNumber"></param>
	// / <returns></returns>
	public int GetShapesCount(int slideNumber) {
			// build URI to get shapes
			String strURI = Product.getBaseProductUri() + "/slides/" + FileName
					+ "/slides/" + Integer.toString(slideNumber) + "/shapes";
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("Document.GetShapesCount: Please Specify AppKey and AppSID");

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
			ShapesResponse shapesResponse = gson.fromJson(strJSON,
					ShapesResponse.class);

			List<Shape> shapes = new java.util.ArrayList<Shape>();
			for (ShapeURI shapeURI : shapesResponse.getShapes().getList()) {
				// Parse the json String to JObject
				String strResponse = ProcessURI(shapeURI.getUri().getHref());

				// Parse and deserialize the JSON to a object.
				ShapeResponse shapeResponse = gson.fromJson(strResponse,
						ShapeResponse.class);
				shapes.add(shapeResponse.getShape());
			}

			return shapes.size();
	}

	// / <summary>
	// / Processes URI and returns JObject
	// / </summary>
	// / <param name="strURI"></param>
	// / <returns></returns>
	private String ProcessURI(String strURI) {
			// build URI
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("Document.ProcessURI: Please Specify AppKey and AppSID");

				} else {
					signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.Sign(strURI);
			}
			InputStream responseStream = Utils.ProcessCommand(signedURI, "GET");

			// Parse the json String to JObject
			return Utils.StreamToString(responseStream);

	}

	public ColorScheme GetColorScheme(int slideNumber) {
			String strURI = Product.getBaseProductUri() + "/slides/"
					+ this.FileName + "/slides/"
					+ Integer.toString(slideNumber) + "/theme/colorScheme";
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("Document.GetColorScheme: Please Specify AppKey and AppSID");

				} else {
					signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.Sign(strURI);
			}
			InputStream responseStream = Utils.ProcessCommand(signedURI, "GET");
			String strJSON = Utils.StreamToString(responseStream);
			ColorSchemeResponse colorSchemeResponse = gson.fromJson(strJSON,
					ColorSchemeResponse.class);
			return colorSchemeResponse.getColorScheme();
	}

	public ColorScheme GetColorScheme(int slideNumber, StorageType storageType,
			String storageName) {
			String strURI = Product.getBaseProductUri() + "/slides/"
					+ this.FileName + "/slides/"
					+ Integer.toString(slideNumber) + "/theme/colorScheme";
			if (storageType.equals(StorageType.AmazonS3)) {
				strURI.concat("?storage=" + storageName);
			}
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("Document.GetColorScheme: Please Specify AppKey and AppSID");

				} else {
					signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.Sign(strURI);
			}
			InputStream responseStream = Utils.ProcessCommand(signedURI, "GET");
			String strJSON = Utils.StreamToString(responseStream);
			ColorSchemeResponse colorSchemeResponse = gson.fromJson(strJSON,
					ColorSchemeResponse.class);
			return colorSchemeResponse.getColorScheme();
	}

	public FontScheme getFontScheme(int slideNumber) {
			String strURI = Product.getBaseProductUri() + "/slides/"
					+ this.FileName + "/slides/"
					+ Integer.toString(slideNumber) + "/theme/fontScheme";
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("Document.getFontScheme: Please Specify AppKey and AppSID");

				} else {
					signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.Sign(strURI);
			}
			InputStream responseStream = Utils.ProcessCommand(signedURI, "GET");
			String strJSON = Utils.StreamToString(responseStream);
			FontSchemeResponse fontSchemeResponse = gson.fromJson(strJSON,
					FontSchemeResponse.class);
			return fontSchemeResponse.getFontScheme();
	}

	public FontScheme getFontScheme(int slideNumber, StorageType storageType,
			String storageName) {
			String strURI = Product.getBaseProductUri() + "/slides/"
					+ this.FileName + "/slides/"
					+ Integer.toString(slideNumber) + "/theme/fontScheme";
			if (storageType.equals(StorageType.AmazonS3)) {
				strURI.concat("?storage=" + storageName);
			}
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("Document.getFontScheme: Please Specify AppKey and AppSID");

				} else {
					signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.Sign(strURI);
			}
			InputStream responseStream = Utils.ProcessCommand(signedURI, "GET");
			String strJSON = Utils.StreamToString(responseStream);
			FontSchemeResponse fontSchemeResponse = gson.fromJson(strJSON,
					FontSchemeResponse.class);
			return fontSchemeResponse.getFontScheme();
	}

	public FormatScheme getFormatScheme(int slideNumber) {
			String strURI = Product.getBaseProductUri() + "/slides/"
					+ this.FileName + "/slides/"
					+ Integer.toString(slideNumber) + "/theme/formatScheme";
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("Document.getFormatScheme: Please Specify AppKey and AppSID");

				} else {
					signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.Sign(strURI);
			}
			InputStream responseStream = Utils.ProcessCommand(signedURI, "GET");
			String strJSON = Utils.StreamToString(responseStream);
			FormatSchemeResponse fontSchemeResponse = gson.fromJson(strJSON,
					FormatSchemeResponse.class);
			return fontSchemeResponse.getFormatScheme();
	}

	public FormatScheme getFormatScheme(int slideNumber,
			StorageType storageType, String storageName) {
			String strURI = Product.getBaseProductUri() + "/slides/"
					+ this.FileName + "/slides/"
					+ Integer.toString(slideNumber) + "/theme/formatScheme";
			if (storageType.equals(StorageType.AmazonS3)) {
				strURI.concat("?storage=" + storageName);
			}
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("Document.getFormatScheme: Please Specify AppKey and AppSID");

				} else {
					signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.Sign(strURI);
			}
			InputStream responseStream = Utils.ProcessCommand(signedURI, "GET");
			String strJSON = Utils.StreamToString(responseStream);
			FormatSchemeResponse fontSchemeResponse = gson.fromJson(strJSON,
					FormatSchemeResponse.class);
			return fontSchemeResponse.getFormatScheme();
	}

	public int getPlaceholderCount(int slideNumber) {
			String strURI = Product.getBaseProductUri() + "/slides/"
					+ this.FileName + "/slides/"
					+ Integer.toString(slideNumber) + "/placeholders";
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("Document.getPlaceholderCount: Please Specify AppKey and AppSID");

				} else {
					signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.Sign(strURI);
			}
			InputStream responseStream = Utils.ProcessCommand(signedURI, "GET");
			String strJSON = Utils.StreamToString(responseStream);
			PlaceholdersResponse placeholderResponse = gson.fromJson(strJSON,
					PlaceholdersResponse.class);
			return placeholderResponse.getPlaceholders().getPlaceholderLinks().size();

	}

	public int getPlaceholderCount(int slideNumber, StorageType storageType,
			String storageName, String folderName) {
			String strURI = Product.getBaseProductUri()
					+ "/slides/"
					+ this.FileName
					+ "/slides/"
					+ Integer.toString(slideNumber)
					+ "/placeholders"
					+ (folderName.equals("") || folderName.equals(null) ? ""
							: "?folder=" + folderName);
			if (storageType.equals(StorageType.AmazonS3)) {
				strURI.concat("&storage=" + storageName);
			}
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("Document.getPlaceholderCount: Please Specify AppKey and AppSID");

				} else {
					signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.Sign(strURI);
			}
			InputStream responseStream = Utils.ProcessCommand(signedURI, "GET");
			String strJSON = Utils.StreamToString(responseStream);
			PlaceholdersResponse placeholderResponse = gson.fromJson(strJSON,
					PlaceholdersResponse.class);
			return placeholderResponse.getPlaceholders().getPlaceholderLinks().size();

	}

	public Placeholder GetPlaceholder(int slideNumber, int placeholderIndex) {
			String strURI = Product.getBaseProductUri() + "/slides/"
					+ this.FileName + "/slides/"
					+ Integer.toString(slideNumber) + "/placeholders/"
					+ Integer.toString(placeholderIndex);
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("Document.GetPlaceholder: Please Specify AppKey and AppSID");

				} else {
					signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.Sign(strURI);
			}
			InputStream responseStream = Utils.ProcessCommand(signedURI, "GET");
			String strJSON = Utils.StreamToString(responseStream);
			PlaceholderResponse placeholderResponse = gson.fromJson(strJSON,
					PlaceholderResponse.class);
			return placeholderResponse.getPlaceholder();

	}

	public Placeholder GetPlaceholder(int slideNumber, int placeholderIndex,
			StorageType storageType, String storageName, String folderName) {
			String strURI = Product.getBaseProductUri()
					+ "/slides/"
					+ this.FileName
					+ "/slides/"
					+ Integer.toString(slideNumber)
					+ "/placeholders/"
					+ Integer.toString(placeholderIndex)
					+ (folderName.equals("") || folderName.equals(null) ? ""
							: "?folder=" + folderName);
			if (storageType.equals(StorageType.AmazonS3)) {
				strURI.concat("&storage=" + storageName);
			}
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("Document.GetPlaceholder: Please Specify AppKey and AppSID");

				} else {
					signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.Sign(strURI);
			}
			InputStream responseStream = Utils.ProcessCommand(signedURI, "GET");
			String strJSON = Utils.StreamToString(responseStream);
			PlaceholderResponse placeholderResponse = gson.fromJson(strJSON,
					PlaceholderResponse.class);
			return placeholderResponse.getPlaceholder();

	}

}
