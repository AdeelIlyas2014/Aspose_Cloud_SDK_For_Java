package com.aspose.cloud.cells;

import java.io.FileInputStream;
import java.io.InputStream;

import com.aspose.cloud.common.AsposeAppNonStatic;
import com.aspose.cloud.common.Utils;
import com.aspose.cloud.storage.Folder;

public class Converter {
	private AsposeAppNonStatic auth;

	// / <summary>
	// / Converter Class Constructor
	// / </summary>
	public Converter() {

	}

	public Converter(AsposeAppNonStatic auth) {
		this();
		this.auth = auth;
	}

	// / <summary>
	// / Converter Class Constructor
	// / </summary>
	public Converter(String fileName) {
		_fileName = fileName;
	}

	public Converter(String fileName, AsposeAppNonStatic auth) {
		this(fileName);
		this.auth = auth;
	}

	// / <summary>
	// / Converter Class Constructor
	// / </summary>
	public Converter(String fileName, String worksheetName) {
		_fileName = fileName;
		workSheetName = worksheetName;

	}

	public Converter(String fileName, String worksheetName,
			AsposeAppNonStatic auth) {
		this(fileName, worksheetName);
		this.auth = auth;
	}

	// / <summary>
	// /
	// / </summary>
	// / <param name="index"></param>
	// / <param name="outputFileName"></param>
	// / <param name="outputformat"></param>
	public boolean autoShapeToImage(int index, String outputFileName,
			ImageFormat outputformat) {
		try {
			// check whether file is set or not 
			if (_fileName.equals(""))
				throw new Exception("No file name specified");
			else if (workSheetName.equals(""))
				throw new Exception("No Worksheet name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + _fileName;
			strURI += "/worksheets/" + workSheetName + "/autoshapes/" + index
					+ "?format=" + outputformat;

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
			boolean response = Folder.saveStreamToFile(outputFileName,
					responseStream);
			responseStream.close();
			return response;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	// / <summary>
	// /
	// / </summary>
	// / <param name="index"></param>
	// / <param name="outputFileName"></param>
	// / <param name="outputformat"></param>
	public boolean chartToImage(int index, String outputFileName,
			ImageFormat outputformat) {
		try {
			// check whether file is set or not
			if (_fileName.equals(""))
				throw new Exception("No file name specified");
			else if (workSheetName.equals(""))
				throw new Exception("No Worksheet name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + _fileName;
			strURI += "/worksheets/" + workSheetName + "/charts/" + index
					+ "?format=" + outputformat;

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
			boolean response = Folder.saveStreamToFile(outputFileName,
					responseStream);
			responseStream.close();
			return response;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}

	}

	// / <summary>
	// /
	// / </summary>
	// / <param name="index"></param>
	// / <param name="outputFileName"></param>
	// / <param name="outputformat"></param>
	public boolean oleObjectToImage(int index, String outputFileName,
			ImageFormat outputformat) {
		try {
			// check whether file is set or not
			if (_fileName.equals(""))
				throw new Exception("No file name specified");
			else if (workSheetName.equals(""))
				throw new Exception("No Worksheet name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + _fileName;
			strURI += "/worksheets/" + workSheetName + "/oleobjects/" + index
					+ "?format=" + outputformat;

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
			boolean response = Folder.saveStreamToFile(outputFileName,
					responseStream);
			responseStream.close();
			return response;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	// / <summary>
	// /
	// / </summary>
	// / <param name="index"></param>
	// / <param name="outputFileName"></param>
	// / <param name="outputformat"></param>
	public boolean pictureToImage(int index, String outputFileName,
			ImageFormat outputformat) {

		try {
			// check whether file is set or not
			if (_fileName.equals(""))
				throw new Exception("No file name specified");
			else if (workSheetName.equals(""))
				throw new Exception("No Worksheet name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + _fileName;
			strURI += "/worksheets/" + workSheetName + "/pictures/" + index
					+ "?format=" + outputformat;

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
			boolean response = Folder.saveStreamToFile(outputFileName,
					responseStream);
			responseStream.close();
			return response;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	// / <summary>
	// /
	// / </summary>
	// / <param name="outputFileName"></param>
	// / <param name="outputFormat"></param>
	// / <param name="saveLocation"></param>

	public boolean worksheetToImage(String outputFileName,
			ImageFormat outputFormat) {
		try {
			// check whether file is set or not
			if (_fileName.equals(""))
				throw new Exception("No file name specified");
			else if (workSheetName.equals(""))
				throw new Exception("No Worksheet name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + _fileName;
			strURI += "/worksheets/" + workSheetName + "?format="
					+ outputFormat;

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
			boolean response = Folder.saveStreamToFile(outputFileName,
					responseStream);
			responseStream.close();
			return response;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public boolean save(String outputFileName, SaveFormat outputFormat) {
		try {
			// check whether file is set or not
			if (_fileName.equals(""))
				throw new Exception("No file name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + _fileName;
			strURI += "?format=" + outputFormat;

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
			boolean response = Folder.saveStreamToFile(outputFileName,
					responseStream);
			responseStream.close();
			return response;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}

	}

	// / <summary>
	// / Convert PDF to different file format without using storage
	// / </summary>
	// / <param name="outputFileName"></param>
	// / <param name="outputFormat"></param>
	public void convertLocalFile(String inputPath, String outputPath,
			SaveFormat outputFormat) {
		try {

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/convert?format=" + outputFormat;

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

			InputStream stream = new FileInputStream(inputPath);

			// get response stream
			InputStream responseStream = Utils.processCommand(signedURI, "PUT",
					stream);

			Folder.saveStreamToFile(outputPath, responseStream);

			responseStream.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void convertLocalFile(InputStream inputStream, String outputPath,
			SaveFormat saveFormat) {
		try {

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/convert?format=" + saveFormat;

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
			// get response stream
			InputStream responseStream = Utils.processCommand(signedURI, "PUT",
					inputStream);

			Folder.saveStreamToFile(outputPath, responseStream);

			responseStream.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// / <summary>
	// /
	// / </summary>
	public String workSheetName;

	// / <summary>
	// / Workbook name
	// / </summary>
	public String _fileName;

}