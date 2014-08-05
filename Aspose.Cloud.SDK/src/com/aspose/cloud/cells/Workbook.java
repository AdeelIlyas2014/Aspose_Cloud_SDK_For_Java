package com.aspose.cloud.cells;

import java.io.InputStream;
import java.util.List;

import com.aspose.cloud.common.AsposeAppNonStatic;
import com.aspose.cloud.common.BaseResponse;
import com.aspose.cloud.common.Product;
import com.aspose.cloud.common.Utils;
import com.google.gson.Gson;

public class Workbook {
	private AsposeAppNonStatic auth;

	// / <summary>
	// / Workbook Constructor, set the file name and password
	// / </summary>
	// / <param name="fileName"> File Name</param>
	public Workbook(String _fileName) {
		fileName = _fileName;
	}

	public Workbook(String fileName, AsposeAppNonStatic auth) {
		this(fileName);
		this.auth = auth;
	}

	// / <summary>
	// / Get Document's properties
	// / </summary>
	// / <returns>List of document properties</returns>
	public List<DocumentProperty> getProperties() {
		try {
			// check whether file is set or not
			if (fileName.equals(""))
				throw new Exception("No file name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + fileName;
			strURI += "/documentProperties";

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

			String strJSON = Utils.streamToString(responseStream);

			Gson gson = new Gson();

			WorkbookResponse workbookResponse = gson.fromJson(strJSON,
					WorkbookResponse.class);

			return workbookResponse.getDocumentProperties()
					.getDocumentPropertyList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// / <summary>
	// / Get a Particular Property
	// / </summary>
	// / <param name="propertyName"></param>
	// / <returns></returns>
	public DocumentProperty getProperty(String propertyName) {
		try {
			// check whether file is set or not
			if (fileName.equals(""))
				throw new Exception("No file name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + fileName;
			strURI += "/documentProperties/" + propertyName;

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

			String strJSON = Utils.streamToString(responseStream);

			Gson gson = new Gson();

			WorkbookResponse workbookResponse = gson.fromJson(strJSON,
					WorkbookResponse.class);

			return workbookResponse.getDocumentProperty();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// / <summary>
	// / Set document property
	// / </summary>
	// / <param name="propertyName">property name</param>
	// / <param name="propertyValue">property value</param>
	public boolean setProperty(String propertyName, String propertyValue) {
		try {
			// build URI to get page count
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + fileName + "/documentProperties/"
					+ propertyName;
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

			// serialize the JSON request content
			DocumentProperty docProperty = new DocumentProperty();
			docProperty.setValue(propertyValue);

			String strJSON = "";

			Gson gson = new Gson();

			strJSON = gson.toJson(docProperty, DocumentProperty.class);

			InputStream responseStream = Utils.processCommand(signedURI, "PUT",
					strJSON);

			String strResponse = Utils.streamToString(responseStream);

			// Parse the json string to JObject
			BaseResponse baseResponse = gson.fromJson(strResponse,
					BaseResponse.class);

			if (baseResponse.getCode().equals("201")
					& baseResponse.getStatus().equals("Created"))
				return true;
			else
				return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean removeAllProperties() {
		try {
			// check whether file is set or not
			if (fileName.equals(""))
				throw new Exception("No file name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + fileName;
			strURI += "/documentProperties";

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

			InputStream responseStream = Utils.processCommand(signedURI,
					"DELETE");

			String strJSON = Utils.streamToString(responseStream);

			Gson gson = new Gson();

			BaseResponse workbookResponse = gson.fromJson(strJSON,
					BaseResponse.class);

			if (workbookResponse.getStatus().equals("OK"))
				return true;
			else
				return false;

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public boolean removeProperty(String propertyName) {
		try {
			// check whether file is set or not
			if (fileName.equals(""))
				throw new Exception("No file name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + fileName;
			strURI += "/documentProperties/" + propertyName;

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

			InputStream responseStream = Utils.processCommand(signedURI,
					"DELETE");

			String strJSON = Utils.streamToString(responseStream);

			Gson gson = new Gson();

			BaseResponse workbookResponse = gson.fromJson(strJSON,
					BaseResponse.class);

			if (workbookResponse.getStatus().equals("OK"))
				return true;
			else
				return false;

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	// / <summary>
	// /
	// / </summary>
	// / <param name="newWorkbookName"></param>
	public boolean createEmptyWorkbook() {
		try {
			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/cells/" + fileName;

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

			InputStream responseStream = Utils.processCommand(signedURI, "PUT");

			String strJSON = Utils.streamToString(responseStream);

			Gson gson = new Gson();

			// Parse the json string to JObject and Deserializes the JSON to a
			// object.
			BaseResponse baseResponse = gson.fromJson(strJSON,
					BaseResponse.class);

			if (baseResponse.getCode().equals("200")
					&& baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public boolean createWorkbookFromTemplate(String templateFileName) {
		try {
			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/cells/" + fileName
					+ "?templatefile=" + templateFileName;
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

			InputStream responseStream = Utils.processCommand(signedURI, "PUT");

			String strJSON = Utils.streamToString(responseStream);

			Gson gson = new Gson();

			// Parse the json string to JObject and Deserializes the JSON to a
			// object.
			BaseResponse baseResponse = gson.fromJson(strJSON,
					BaseResponse.class);

			if (baseResponse.getCode().equals("200")
					&& baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	// / <summary>
	// /
	// / </summary>
	// / <param name="newWorkbookName"></param>
	// / <param name="templateFileName"></param>
	// / <param name="dataFile"></param>
	public boolean createWorkbookFromSmartMarkerTemplate(
			String templateFileName, String dataFile) {
		try {
			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/cells/" + fileName
					+ "?templatefile=" + templateFileName + "&dataFile="
					+ dataFile;
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

			InputStream responseStream = Utils.processCommand(signedURI, "PUT");

			String strJSON = Utils.streamToString(responseStream);

			Gson gson = new Gson();

			// Parse the json string to JObject and Deserializes the JSON to a
			// object.
			BaseResponse baseResponse = gson.fromJson(strJSON,
					BaseResponse.class);

			if (baseResponse.getCode().equals("200")
					&& baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public boolean processSmartMarker(String dataFile) {
		try {
			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/cells/" + fileName
					+ "/smartmarker?xmlFile=" + dataFile;
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

			InputStream responseStream = Utils
					.processCommand(signedURI, "POST");

			// further process JSON response
			String strJSON = Utils.streamToString(responseStream);

			Gson gson = new Gson();

			// Parse the json string to JObject and Deserializes the JSON to a
			// object.
			BaseResponse baseResponse = gson.fromJson(strJSON,
					BaseResponse.class);

			if (baseResponse.getCode().equals("200")
					&& baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	 public Name getName(String name)
     {
		 try {
				// check whether file is set or not
				if (fileName.equals(""))
					throw new Exception("No file name specified");

				// build URI
				String strURI = com.aspose.cloud.common.Product.getBaseProductUri()+ "/cells/" + fileName;
	             strURI += "/names/"+name;

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

				String strJSON = Utils.streamToString(responseStream);

				Gson gson = new Gson();

				// Parse the json string to JObject and Deserializes the JSON to a
				// object.
				NameResponse nameResponse = gson.fromJson(strJSON,
						NameResponse.class);
				return nameResponse.getSName();
				 
			}

			catch (Exception e) {
				e.printStackTrace();
				return null;
			}
}
	public int getWorksheetsCount() {

		try {
			// check whether file is set or not
			if (fileName.equals(""))
				throw new Exception("No file name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + fileName;
			strURI += "/worksheets";

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

			String strJSON = Utils.streamToString(responseStream);

			Gson gson = new Gson();

			WorkbookResponse workbookResponse = gson.fromJson(strJSON,
					WorkbookResponse.class);

			return workbookResponse.getWorksheets().getWorksheetList().size();
		}

		catch (Exception e) {
			e.printStackTrace();
			return 0;
		}

	}

	public int getNamesCount() {

		try {
			// check whether file is set or not
			if (fileName.equals(""))
				throw new Exception("No file name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + fileName;
			strURI += "/names";

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

			String strJSON = Utils.streamToString(responseStream);

			Gson gson = new Gson();

			WorkbookResponse workbookResponse = gson.fromJson(strJSON,
					WorkbookResponse.class);

			return workbookResponse.getNames().getCount();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}

	}

	public Style getDefaultStyle() {

		try {
			// check whether file is set or not
			if (fileName.equals(""))
				throw new Exception("No file name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + fileName;
			strURI += "/defaultStyle";

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

			String strJSON = Utils.streamToString(responseStream);

			Gson gson = new Gson();

			WorkbookResponse workbookResponse = gson.fromJson(strJSON,
					WorkbookResponse.class);

			return workbookResponse.getStyle();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean encryptWorkbook(EncryptionType encryptionType,
			String password, int keyLength) {
		try {
			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/cells/" + fileName
					+ "/encryption";
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

			// serialize the JSON request content
			Encryption encryption = new Encryption();
			encryption.setEncryptionType(encryptionType);
			encryption.setPassword(password);
			encryption.setKeylength(keyLength);

			String strJSON = "";

			Gson gson = new Gson();

			strJSON = gson.toJson(encryption, Encryption.class);

			InputStream responseStream = Utils.processCommand(signedURI,
					"POST", strJSON);

			String strResponse = Utils.streamToString(responseStream);

			// Parse the json string to JObject
			BaseResponse baseResponse = gson.fromJson(strResponse,
					BaseResponse.class);

			if (baseResponse.getCode().equals("200")
					& baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean protectWorkbook(ProtectionType protectionType,
			String password) {
		try {
			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/cells/" + fileName
					+ "/protection";
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

			// serialize the JSON request content
			Protection protection = new Protection();
			protection.setProtectionType(protectionType);
			protection.setPassword(password);

			String strJSON = "";

			Gson gson = new Gson();

			strJSON = gson.toJson(protection, Protection.class);

			InputStream responseStream = Utils.processCommand(signedURI,
					"POST", strJSON);

			String strResponse = Utils.streamToString(responseStream);

			// Parse the json string to JObject
			BaseResponse baseResponse = gson.fromJson(strResponse,
					BaseResponse.class);

			if (baseResponse.getCode().equals("200")
					& baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean unprotectWorkbook(String password) {
		try {
			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/cells/" + fileName
					+ "/protection";
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

			// serialize the JSON request content
			Protection protection = new Protection();
			protection.setPassword(password);

			String strJSON = "";

			Gson gson = new Gson();

			strJSON = gson.toJson(protection, Protection.class);

			InputStream responseStream = Utils.processCommand(signedURI,
					"POST", strJSON);

			String strResponse = Utils.streamToString(responseStream);

			// Parse the json string to JObject
			BaseResponse baseResponse = gson.fromJson(strResponse,
					BaseResponse.class);

			if (baseResponse.getCode().equals("200")
					& baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean setModifyPassword(String password) {
		try {
			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/cells/" + fileName
					+ "/writeProtection";
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

			// serialize the JSON request content
			Protection protection = new Protection();
			protection.setPassword(password);

			String strJSON = "";

			Gson gson = new Gson();

			strJSON = gson.toJson(protection, Protection.class);

			InputStream responseStream = Utils.processCommand(signedURI,
					"POST", strJSON);

			String strResponse = Utils.streamToString(responseStream);

			// Parse the json string to JObject
			BaseResponse baseResponse = gson.fromJson(strResponse,
					BaseResponse.class);

			if (baseResponse.getCode().equals("200")
					& baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean clearModifyPassword(String password) {
		try {
			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/cells/" + fileName
					+ "/writeProtection";
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

			// serialize the JSON request content
			Protection protection = new Protection();
			protection.setPassword(password);

			String strJSON = "";

			Gson gson = new Gson();

			strJSON = gson.toJson(protection, Protection.class);

			InputStream responseStream = Utils.processCommand(signedURI,
					"DELETE", strJSON);

			String strResponse = Utils.streamToString(responseStream);

			// Parse the json string to JObject
			BaseResponse baseResponse = gson.fromJson(strResponse,
					BaseResponse.class);

			if (baseResponse.getCode().equals("200")
					& baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean decryptWorkbook(String password) {

		try {
			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/cells/" + fileName
					+ "/encryption";
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
			// serialize the JSON request content
			Encryption encryption = new Encryption();

			encryption.setPassword(password);

			String strJSON = "";

			Gson gson = new Gson();

			strJSON = gson.toJson(encryption, Encryption.class);

			InputStream responseStream = Utils.processCommand(signedURI,
					"DELETE", strJSON);

			String strResponse = Utils.streamToString(responseStream);

			// Parse the json string to JObject
			BaseResponse baseResponse = gson.fromJson(strResponse,
					BaseResponse.class);

			if (baseResponse.getCode().equals("200")
					& baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// / <summary>
	// /
	// / </summary>
	// / <param name="worksheetName"></param>

	public boolean addWorksheet(String worksheetName) {
		try {
			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/cells/" + fileName
					+ "/worksheets/" + worksheetName;
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

			InputStream responseStream = Utils.processCommand(signedURI, "PUT");

			String strJSON = Utils.streamToString(responseStream);

			Gson gson = new Gson();

			// Parse the json string to JObject and Deserializes the JSON to a
			// object.
			BaseResponse baseResponse = gson.fromJson(strJSON,
					BaseResponse.class);

			if (baseResponse.getCode().equals("201"))
				return true;
			else
				return false;

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	// / <summary>
	// /
	// / </summary>
	// / <param name="worksheetName"></param>
	// / <returns></returns>
	public boolean removeWorksheet(String worksheetName) {

		try {

			// check whether file is set or not
			if (fileName.equals(""))
				throw new Exception("No file name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + fileName;
			strURI += "/worksheets/" + worksheetName;

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

			InputStream responseStream = Utils.processCommand(signedURI, "PUT");

			String strJSON = Utils.streamToString(responseStream);

			Gson gson = new Gson();

			// Parse the json string to JObject and Deserializes the JSON to a
			// object.
			BaseResponse baseResponse = gson.fromJson(strJSON,
					BaseResponse.class);

			if (baseResponse.getCode().equals("200")
					&& baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public boolean mergeWorkbook(String mergefileName) {
		try {
			// check whether file is set or not
			if (fileName.equals(""))
				throw new Exception("No file name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + fileName;
			strURI += "/merge?mergeWith=" + mergefileName;

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

			InputStream responseStream = Utils
					.processCommand(signedURI, "POST");

			// further process JSON response
			String strJSON = Utils.streamToString(responseStream);

			Gson gson = new Gson();

			// Parse the json string to JObject and Deserializes the JSON to a
			// object.
			BaseResponse baseResponse = gson.fromJson(strJSON,
					BaseResponse.class);

			if (baseResponse.getCode().equals("200")
					&& baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	public boolean splitDocument(SplitDocumentFormats format, int from, int to) {

		try {
			// check whether file is set or not
			if (fileName.equals(""))
				throw new Exception("No file name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + fileName;
            strURI += "/split?" +
                (format == null ? "" : "format=" + format) +
                (from == 0 ? "" : "&from=" + from) +
                (to == 0 ? "" : "&to=" + to);
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

			InputStream responseStream = Utils.processCommand(signedURI, "POST");
			String strJSON = Utils.streamToString(responseStream);
			Gson gson = new Gson();

			// Parse the json string to JObject and Deserializes the JSON to a
			// object.
			BaseResponse baseResponse = gson.fromJson(strJSON,
					BaseResponse.class);

			if (baseResponse.getCode().equals("200")
					&& baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// / <summary>
	// / Workbook name
	// / </summary>
	public String fileName;

}