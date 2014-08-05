/**
 * 
 */
package com.aspose.cloud.slides;

import java.io.InputStream;
import java.util.List;

import com.aspose.cloud.common.AsposeAppNonStatic;
import com.aspose.cloud.common.Product;
import com.aspose.cloud.common.Utils;
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

	public Extractor(String _fileName) {
		fileName = _fileName;
		gson = new Gson();
	}

	public Extractor(String _fileName, AsposeAppNonStatic auth) {
		this(_fileName);
		this.auth = auth;
	}

	// / <summary>
	// / Presentation name
	// / </summary>
	public String fileName;
	Gson gson = null;

	// / <summary>
	// / Gets total number of images in a presentation
	// / </summary>
	// / <returns>Total number of images</returns>
	public int getImageCount() {
		try {
			// build URI to get image count
			String strURI = Product.getBaseProductUri() + "/slides/" + fileName
					+ "/images";
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

			// Parse and deserialize the JSON to a object.
			ImagesResponse imagesResponse = gson.fromJson(strJSON,
					ImagesResponse.class);

			return imagesResponse.getImages().getList().size();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	public int getImageCount(StorageType storageType, String storageName,
			String folderName) {
		try {
			// build URI to get image count
			String strURI = Product.getBaseProductUri()
					+ "/slides/"
					+ fileName
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
				} else {
					signedURI = Utils.sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.sign(strURI);
			}

			InputStream responseStream = Utils.processCommand(signedURI, "GET");

			String strJSON = Utils.streamToString(responseStream);

			// Parse and deserialize the JSON to a object.
			ImagesResponse imagesResponse = gson.fromJson(strJSON,
					ImagesResponse.class);

			return imagesResponse.getImages().getList().size();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	// / <summary>
	// / Gets total number of images in a presentation
	// / </summary>
	// / <returns>Total number of images</returns>
	public List<com.aspose.cloud.slides.Image> getPresentationImages() {
		try {
			// build URI to get image count
			String strURI = Product.getBaseProductUri() + "/slides/" + fileName
					+ "/images";
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

			// Parse and deserialize the JSON to a object.
			ImagesResponse imagesResponse = gson.fromJson(strJSON,
					ImagesResponse.class);

			return imagesResponse.getImages().getList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// / <summary>
	// / Gets number of images in the specified slide
	// / </summary>
	// / <param name="slideNumber"></param>
	// / <returns></returns>
	public int getImageCount(int slideNumber) {
		try {
			// build URI to get image count
			String strURI = Product.getBaseProductUri() + "/slides/" + fileName
					+ "/slides/" + Integer.toString(slideNumber) + "/images";
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

			// Parse and deserialize the JSON to a object.
			ImagesResponse imagesResponse = gson.fromJson(strJSON,
					ImagesResponse.class);

			return imagesResponse.getImages().getList().size();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	public int getImageCount(int slideNumber, StorageType storageType,
			String storageName, String folderName) {
		try {
			// build URI to get image count
			String strURI = Product.getBaseProductUri()
					+ "/slides/"
					+ fileName
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
				} else {
					signedURI = Utils.sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.sign(strURI);
			}

			InputStream responseStream = Utils.processCommand(signedURI, "GET");

			String strJSON = Utils.streamToString(responseStream);

			// Parse and deserialize the JSON to a object.
			ImagesResponse imagesResponse = gson.fromJson(strJSON,
					ImagesResponse.class);

			return imagesResponse.getImages().getList().size();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	// / <summary>
	// / Gets all shapes from the specified slide
	// / </summary>
	// / <param name="slideNumber"></param>
	// / <returns></returns>
	public List<Shape> getShapes(int slideNumber) {
		try {
			// build URI to get shapes
			String strURI = Product.getBaseProductUri() + "/slides/" + fileName
					+ "/slides/" + Integer.toString(slideNumber) + "/shapes";
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
			System.out.println(strJSON);
			
			// Parse and deserialize the JSON to a object.
			ShapesResponse shapesResponse = gson.fromJson(strJSON,
					ShapesResponse.class);

			List<Shape> shapes = new java.util.ArrayList<Shape>();
			for (ShapeURI shapeURI : shapesResponse.getShapes().getList()) {
				// Parse the json String to JObject
				String strResponse = processURI(shapeURI.getUri().getHref());

				// Parse and deserialize the JSON to a object.
				ShapeResponse shapeResponse = gson.fromJson(strResponse,
						ShapeResponse.class);
				shapes.add(shapeResponse.getShape());
			}

			return shapes;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Shape> getShapes(int slideNumber, StorageType storageType,
			String storageName, String folderName) {
		try {
			// build URI to get shapes
			String strURI = Product.getBaseProductUri()
					+ "/slides/"
					+ fileName
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
				} else {
					signedURI = Utils.sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.sign(strURI);
			}

			InputStream responseStream = Utils.processCommand(signedURI, "GET");

			String strJSON = Utils.streamToString(responseStream);

			// Parse and deserialize the JSON to a object.
			ShapesResponse shapesResponse = gson.fromJson(strJSON,
					ShapesResponse.class);

			List<Shape> shapes = new java.util.ArrayList<Shape>();
			for (ShapeURI shapeURI : shapesResponse.getShapes().getList()) {
				// Parse the json String to JObject
				String strResponse = processURI(shapeURI.getUri().getHref());

				// Parse and deserialize the JSON to a object.
				ShapeResponse shapeResponse = gson.fromJson(strResponse,
						ShapeResponse.class);
				shapes.add(shapeResponse.getShape());
			}

			return shapes;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// / <summary>
	// / Gets all shapes from the specified slide
	// / </summary>
	// / <param name="slideNumber"></param>
	// / <returns></returns>
	public int getShapesCount(int slideNumber) {
		try {
			// build URI to get shapes
			String strURI = Product.getBaseProductUri() + "/slides/" + fileName
					+ "/slides/" + Integer.toString(slideNumber) + "/shapes";
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

			// Parse and deserialize the JSON to a object.
			ShapesResponse shapesResponse = gson.fromJson(strJSON,
					ShapesResponse.class);

			List<Shape> shapes = new java.util.ArrayList<Shape>();
			for (ShapeURI shapeURI : shapesResponse.getShapes().getList()) {
				// Parse the json String to JObject
				String strResponse = processURI(shapeURI.getUri().getHref());

				// Parse and deserialize the JSON to a object.
				ShapeResponse shapeResponse = gson.fromJson(strResponse,
						ShapeResponse.class);
				shapes.add(shapeResponse.getShape());
			}

			return shapes.size();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	// / <summary>
	// / Processes URI and returns JObject
	// / </summary>
	// / <param name="strURI"></param>
	// / <returns></returns>
	private String processURI(String strURI) {
		try {
			// build URI
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

			// Parse the json String to JObject
			return Utils.streamToString(responseStream);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public ColorScheme getColorScheme(int slideNumber) {
		try {
			String strURI = Product.getBaseProductUri() + "/slides/"
					+ this.fileName + "/slides/"
					+ Integer.toString(slideNumber) + "/theme/colorScheme";
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
			ColorSchemeResponse colorSchemeResponse = gson.fromJson(strJSON,
					ColorSchemeResponse.class);
			return colorSchemeResponse.getColorScheme();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public ColorScheme getColorScheme(int slideNumber, StorageType storageType,
			String storageName) {
		try {
			String strURI = Product.getBaseProductUri() + "/slides/"
					+ this.fileName + "/slides/"
					+ Integer.toString(slideNumber) + "/theme/colorScheme";
			if (storageType.equals(StorageType.AmazonS3)) {
				strURI.concat("?storage=" + storageName);
			}
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
			ColorSchemeResponse colorSchemeResponse = gson.fromJson(strJSON,
					ColorSchemeResponse.class);
			return colorSchemeResponse.getColorScheme();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public FontScheme getFontScheme(int slideNumber) {
		try {
			String strURI = Product.getBaseProductUri() + "/slides/"
					+ this.fileName + "/slides/"
					+ Integer.toString(slideNumber) + "/theme/fontScheme";
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
			FontSchemeResponse fontSchemeResponse = gson.fromJson(strJSON,
					FontSchemeResponse.class);
			return fontSchemeResponse.getFontScheme();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public FontScheme getFontScheme(int slideNumber, StorageType storageType,
			String storageName) {
		try {
			String strURI = Product.getBaseProductUri() + "/slides/"
					+ this.fileName + "/slides/"
					+ Integer.toString(slideNumber) + "/theme/fontScheme";
			if (storageType.equals(StorageType.AmazonS3)) {
				strURI.concat("?storage=" + storageName);
			}
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
			FontSchemeResponse fontSchemeResponse = gson.fromJson(strJSON,
					FontSchemeResponse.class);
			return fontSchemeResponse.getFontScheme();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public FormatScheme getFormatScheme(int slideNumber) {
		try {
			String strURI = Product.getBaseProductUri() + "/slides/"
					+ this.fileName + "/slides/"
					+ Integer.toString(slideNumber) + "/theme/formatScheme";
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
			FormatSchemeResponse fontSchemeResponse = gson.fromJson(strJSON,
					FormatSchemeResponse.class);
			return fontSchemeResponse.getFormatScheme();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public FormatScheme getFormatScheme(int slideNumber,
			StorageType storageType, String storageName) {
		try {
			String strURI = Product.getBaseProductUri() + "/slides/"
					+ this.fileName + "/slides/"
					+ Integer.toString(slideNumber) + "/theme/formatScheme";
			if (storageType.equals(StorageType.AmazonS3)) {
				strURI.concat("?storage=" + storageName);
			}
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
			FormatSchemeResponse fontSchemeResponse = gson.fromJson(strJSON,
					FormatSchemeResponse.class);
			return fontSchemeResponse.getFormatScheme();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public int getPlaceholderCount(int slideNumber) {
		try {
			String strURI = Product.getBaseProductUri() + "/slides/"
					+ this.fileName + "/slides/"
					+ Integer.toString(slideNumber) + "/placeholders";
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
			PlaceholdersResponse placeholderResponse = gson.fromJson(strJSON,
					PlaceholdersResponse.class);
			return placeholderResponse.getPlaceholders().getPlaceholderLinks().size();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}

	}

	public int getPlaceholderCount(int slideNumber, StorageType storageType,
			String storageName, String folderName) {
		try {
			String strURI = Product.getBaseProductUri()
					+ "/slides/"
					+ this.fileName
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
				} else {
					signedURI = Utils.sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.sign(strURI);
			}
			InputStream responseStream = Utils.processCommand(signedURI, "GET");
			String strJSON = Utils.streamToString(responseStream);
			PlaceholdersResponse placeholderResponse = gson.fromJson(strJSON,
					PlaceholdersResponse.class);
			return placeholderResponse.getPlaceholders().getPlaceholderLinks().size();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}

	}

	public Placeholder getPlaceholder(int slideNumber, int placeholderIndex) {
		try {
			String strURI = Product.getBaseProductUri() + "/slides/"
					+ this.fileName + "/slides/"
					+ Integer.toString(slideNumber) + "/placeholders/"
					+ Integer.toString(placeholderIndex);
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
			PlaceholderResponse placeholderResponse = gson.fromJson(strJSON,
					PlaceholderResponse.class);
			return placeholderResponse.getPlaceholder();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public Placeholder getPlaceholder(int slideNumber, int placeholderIndex,
			StorageType storageType, String storageName, String folderName) {
		try {
			String strURI = Product.getBaseProductUri()
					+ "/slides/"
					+ this.fileName
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
				} else {
					signedURI = Utils.sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.sign(strURI);
			}
			InputStream responseStream = Utils.processCommand(signedURI, "GET");
			String strJSON = Utils.streamToString(responseStream);
			PlaceholderResponse placeholderResponse = gson.fromJson(strJSON,
					PlaceholderResponse.class);
			return placeholderResponse.getPlaceholder();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}
