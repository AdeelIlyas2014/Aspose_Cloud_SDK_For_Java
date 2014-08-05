package com.aspose.cloud.cells;

import java.lang.String;
import java.io.InputStream;

import com.aspose.cloud.common.*;
import com.google.gson.*;

public class ChartEditor {
	// / <summary>
	// / ChartEditor Class Constructor
	// / </summary>
	private AsposeAppNonStatic auth;

	public ChartEditor(String fileName, String worksheetName) {
		_fileName = fileName;
		workSheetName = worksheetName;
		gson = new Gson();

	}

	public ChartEditor(String fileName, String worksheetName,
			AsposeAppNonStatic auth) {
		this(fileName, worksheetName);
		this.auth = auth;
	}

	public boolean addChart(ChartType chartType, int upperLeftRow,
			int upperLeftColumn, int lowerRightRow, int lowerRightColumn)
			throws Exception {
		try {
			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/cells/" + _fileName;
			strURI += "/worksheets/" + workSheetName + "/charts?chartType="
					+ chartType + "&upperLeftRow=" + upperLeftRow
					+ "&upperLeftColumn=" + upperLeftColumn + "&lowerRightRow="
					+ lowerRightRow + "&lowerRightColumn=" + lowerRightColumn;

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

			// further process JSON response
			String strJSON = Utils.streamToString(responseStream);

			BaseResponse baseResponse = gson.fromJson(strJSON,
					BaseResponse.class);

			if (baseResponse.getCode().equals("200")
					&& baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;

		} catch (Exception ex) {
			throw new Exception(ex.getMessage());
		}
	}

	public boolean deleteChart(int chartIndex) throws Exception {
		// check whether file is set or not
		if (_fileName.equals(""))
			throw new Exception("No file name specified");

		// build URI
		String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
				+ "/cells/" + _fileName;
		strURI += "/worksheets/" + workSheetName + "/charts/" + chartIndex;

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

		InputStream responseStream = Utils.processCommand(signedURI, "DELETE");

		// further process JSON response
		String strJSON = Utils.streamToString(responseStream);

		BaseResponse baseResponse = gson.fromJson(strJSON, BaseResponse.class);

		if (baseResponse.getStatus().equals("OK"))
			return true;
		else
			return false;
	}

	public ChartArea getChartArea(int chartIndex) throws Exception {
		// check whether file is set or not
		if (_fileName.equals(""))
			throw new Exception("No file name specified");

		// build URI
		String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
				+ "/cells/" + _fileName;
		strURI += "/worksheets/" + workSheetName + "/charts/" + chartIndex
				+ "/chartArea";

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

		// further process JSON response
		String strJSON = Utils.streamToString(responseStream);

		// Deserializes the JSON to a object.
		ChartEditorResponse chartResponse = gson.fromJson(strJSON,
				ChartEditorResponse.class);

		return chartResponse.getChartArea();
	}

	public FillFormat getFillFormat(int chartIndex) throws Exception {
		
		// check whether file is set or not
		if (_fileName.equals(""))
			throw new Exception("No file name specified");

		// build URI
		String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
				+ "/cells/" + _fileName;
		strURI += "/worksheets/" + workSheetName + "/charts/" + chartIndex
				+ "/chartArea/fillFormat";

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

		// further process JSON response
		String strJSON = Utils.streamToString(responseStream);

		// Deserializes the JSON to a object.
		ChartEditorResponse chartResponse = gson.fromJson(strJSON,
				ChartEditorResponse.class);

		return chartResponse.getFillFormat();
	}

	public Line getBorder(int chartIndex) throws Exception {
		// check whether file is set or not
		if (_fileName.equals(""))
			throw new Exception("No file name specified");

		// build URI
		String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
				+ "/cells/" + _fileName;
		strURI += "/worksheets/" + workSheetName + "/charts/" + chartIndex
				+ "/chartArea/border";

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

		// further process JSON response
		String strJSON = Utils.streamToString(responseStream);

		// Deserializes the JSON to a object.
		ChartEditorResponse chartResponse = gson.fromJson(strJSON,
				ChartEditorResponse.class);

		return chartResponse.getLine();

	}

	// / <summary>
	// /
	// / </summary>
	public String _fileName;

	// / <summary>
	// /
	// / </summary>
	public String workSheetName;

	Gson gson = null;
}