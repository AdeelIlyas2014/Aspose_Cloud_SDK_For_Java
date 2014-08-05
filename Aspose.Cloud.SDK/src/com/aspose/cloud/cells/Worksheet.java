package com.aspose.cloud.cells;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import com.aspose.cloud.common.AsposeAppNonStatic;
import com.aspose.cloud.common.BaseResponse;
import com.aspose.cloud.common.Product;
import com.aspose.cloud.common.Utils;
import com.google.gson.Gson;

public class Worksheet {
	private AsposeAppNonStatic auth;

	public Worksheet(String _fileName, String worksheetName) {
		fileName = _fileName;
		workSheetName = worksheetName;
	}

	public Worksheet(String fileName, String worksheetName,
			AsposeAppNonStatic auth) {
		this(fileName, worksheetName);
		this.auth = auth;
	}

	public LinkResponse Link;

	public List<LinkResponse> getCellsList(int offset, int count) {

		try {

			// check whether file is set or not
			if (fileName.equals(""))
				throw new Exception("No file name specified");

			// build URI
			String strURI = Product.getBaseProductUri() + "/cells/" + fileName;
			strURI += "/worksheets/" + workSheetName + "/cells?offset="
					+ offset + "&count=" + count;

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

			WorksheetResponse worksheetResponse = gson.fromJson(strJSON,
					WorksheetResponse.class);

			return worksheetResponse.getCells().getCellList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public List<LinkResponse> getRowsList(int offset, int count) {

		try {
			// check whether file is set or not
			if (fileName.equals(""))
				throw new Exception("No file name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + fileName;
			strURI += "/worksheets/" + workSheetName + "/cells/rows?offset="
					+ offset + "&count=" + count;

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

			WorksheetResponse worksheetResponse = gson.fromJson(strJSON,
					WorksheetResponse.class);

			return worksheetResponse.getRows().getRowsList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<LinkResponse> getColumnsList(int offset, int count) {
		try {

			// check whether file is set or not
			if (fileName.equals(""))
				throw new Exception("No file name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + fileName;
			strURI += "/worksheets/" + workSheetName + "/cells/columns?offset="
					+ offset + "&count=" + count;

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

			WorksheetResponse worksheetResponse = gson.fromJson(strJSON,
					WorksheetResponse.class);

			return worksheetResponse.getColumns().getColumnsList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// / <summary>
	// /
	// / </summary>
	// / <param name="offset"></param>
	// / <param name="count"></param>
	// / <returns></returns>
	public int getMaxColumn(int offset, int count) {
		try {

			// check whether file is set or not
			if (fileName.equals(""))
				throw new Exception("No file name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + fileName;
			strURI += "/worksheets/" + workSheetName + "/cells?offset="
					+ offset + "&count=" + count;

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

			WorksheetResponse worksheetResponse = gson.fromJson(strJSON,
					WorksheetResponse.class);

			return worksheetResponse.getCells().getMaxColumn();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	// / <summary>
	// /
	// / </summary>
	// / <param name="offset"></param>
	// / <param name="count"></param>
	// / <returns></returns>
	public int getMaxRow(int offset, int count) {
		try {

			// check whether file is set or not
			if (fileName.equals(""))
				throw new Exception("No file name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + fileName;
			strURI += "/worksheets/" + workSheetName + "/cells?offset="
					+ offset + "&count=" + count;

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

			WorksheetResponse worksheetResponse = gson.fromJson(strJSON,
					WorksheetResponse.class);

			return worksheetResponse.getCells().getMaxRow();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	// / <summary>
	// /
	// / </summary>
	// / <param name="offset"></param>
	// / <param name="count"></param>
	// / <returns></returns>
	public int getCellsCount(int offset, int count) {
		try {

			// check whether file is set or not
			if (fileName.equals(""))
				throw new Exception("No file name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + fileName;
			strURI += "/worksheets/" + workSheetName + "/cells?offset="
					+ offset + "&count=" + count;

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

			WorksheetResponse worksheetResponse = gson.fromJson(strJSON,
					WorksheetResponse.class);

			return worksheetResponse.getCells().getCellCount();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	// / <summary>
	// /
	// / </summary>
	// / <returns></returns>
	public int getAutoShapesCount() {

		try {
			// check whether file is set or not
			if (fileName.equals(""))
				throw new Exception("No file name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + fileName;
			strURI += "/worksheets/" + workSheetName + "/autoshapes";

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

			WorksheetResponse worksheetResponse = gson.fromJson(strJSON,
					WorksheetResponse.class);

			return worksheetResponse.getAutoShapes().getAuotShapeList().size();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	// / <summary>
	// /
	// / </summary>
	// / <param name="index"></param>
	// / <returns></returns>
	public AutoShape getAutoShapeByIndex(int index) {

		try {

			// check whether file is set or not
			if (fileName.equals(""))
				throw new Exception("No file name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + fileName;
			strURI += "/worksheets/" + workSheetName + "/autoshapes/" + index;

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

			AutoShapesResponse autoShapesResponse = gson.fromJson(strJSON,
					AutoShapesResponse.class);

			return autoShapesResponse.getAutoShape();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	/***********Method  ProtectWorksheet Added by:Zeeshan*******/
	public Boolean protectWorksheet(String password, WorksheetProtectionType type, ProtectionOptions opts)
	{
		try
		{
			if (fileName.equals(""))
				throw new Exception("No file name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + fileName ;
			strURI +=  "/worksheets/" +workSheetName + "/protection";

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
			Gson gson = new Gson();

			//serialize the JSON request content
			WorksheetProtectionRequest protectionRequest = new WorksheetProtectionRequest();
            protectionRequest.setAllowDeletingColumn ( opts.getAllowDeletingColumn());
            protectionRequest.setAllowDeletingRow ( opts.getAllowDeletingRow());
            protectionRequest.setAllowEditArea ( opts.getAllowEditArea());
            protectionRequest.setAllowFiltering ( opts.getAllowFiltering());
            protectionRequest.setAllowFormattingCell ( opts.getAllowFormattingCell());
            protectionRequest.setAllowFormattingColumn ( opts.getAllowFormattingColumn());
            protectionRequest.setAllowFormattingRow ( opts.getAllowFormattingRow());
            protectionRequest.setAllowInsertingColumn ( opts.getAllowInsertingColumn());
            protectionRequest.setAllowInsertingHyperlink ( opts.getAllowInsertingHyperlink());
            protectionRequest.setAllowInsertingRow ( opts.getAllowInsertingRow());
            protectionRequest.setAllowSelectingLockedCell ( opts.getAllowSelectingLockedCell());
            protectionRequest.setAllowSelectingUnlockedCell ( opts.getAllowSelectingUnlockedCell());
            protectionRequest.setAllowSorting ( opts.getAllowSorting());
            protectionRequest.setAllowUsingPivotTable ( opts.getAllowUsingPivotTable());
            protectionRequest.setPassword ( password);
            protectionRequest.setProtectionType ( type.toString());
			
	        String strJSON = "";
			strJSON = gson.toJson(protectionRequest, WorksheetProtectionRequest.class);
			InputStream responseStream = Utils.processCommand(signedURI, "PUT",strJSON);

			String strResponse = Utils.streamToString(responseStream);

			// Parse the json string to JObject
			BaseResponse baseResponse = gson.fromJson(strResponse,
					BaseResponse.class);

			if (baseResponse.getCode().equals("200")
					& baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}




	}


	// / <summary>
	// /
	// / </summary>
	// / <param name="cellName"></param>
	// / <returns></returns>
	public Cell getCell(String cellName) {

		try {

			// check whether file is set or not
			if (fileName.equals(""))
				throw new Exception("No file name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + fileName;
			strURI += "/worksheets/" + workSheetName + "/cells/" + cellName;

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

			CellsResponse cellsResponse = gson.fromJson(strJSON,
					CellsResponse.class);

			return cellsResponse.getCell();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// / <summary>
	// /
	// / </summary>
	// / <param name="cellName"></param>
	// / <returns></returns>
	public Style getCellStyle(String cellName) {

		try {
			// check whether file is set or not
			if (fileName.equals(""))
				throw new Exception("No file name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + fileName;
			strURI += "/worksheets/" + workSheetName + "/cells/" + cellName
					+ "/style";

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

			CellsResponse cellsResponse = gson.fromJson(strJSON,
					CellsResponse.class);

			return cellsResponse.getStyle();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// / <summary>
	// /
	// / </summary>
	// / <param name="cellName"></param>
	// / <param name="style"></param>
	// / <returns></returns>
	public boolean setCellStyle(String cellName, Style style) {

		try {

			// check whether file is set or not
			if (fileName.equals(""))
				throw new Exception("No file name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + fileName;
			strURI += "/worksheets/" + workSheetName + "/cells/" + cellName
					+ "/style";

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

			String strJSON = "";

			Gson gson = new Gson();

			strJSON = gson.toJson(style, Style.class);

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

	// / <summary>
	// /
	// / </summary>
	// / <param name="index"></param>
	// / <returns></returns>
	public Chart getChartByIndex(int index) {

		try {

			// check whether file is set or not
			if (fileName.equals(""))
				throw new Exception("No file name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + fileName;
			strURI += "/worksheets/" + workSheetName + "/charts/" + index;

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

			Gson gson = new Gson();

			String strResponse = Utils.streamToString(responseStream);

			// Deserializes the JSON to a object.
			ChartsResponse chartsResponse = gson.fromJson(strResponse,
					ChartsResponse.class);

			return chartsResponse.getChart();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// / <summary>
	// /
	// / </summary>
	// / <param name="index"></param>
	// / <returns></returns>
	public Hyperlink getHyperlinkByIndex(int index) {
		try {
			// check whether file is set or not
			if (fileName.equals(""))
				throw new Exception("No file name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + fileName;
			strURI += "/worksheets/" + workSheetName + "/hyperlinks/" + index;

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

			Gson gson = new Gson();

			String strResponse = Utils.streamToString(responseStream);

			// Deserializes the JSON to a object.
			HyperlinksResponse hyperlinksResponse = gson.fromJson(strResponse,
					HyperlinksResponse.class);

			return hyperlinksResponse.getHyperlink();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	// / <summary>
	// /
	// / </summary>
	// / <param name="cellName"></param>
	// / <returns></returns>
	public Comment getComment(String cellName) {
		try {
			// check whether file is set or not
			if (fileName.equals(""))
				throw new Exception("No file name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + fileName;
			strURI += "/worksheets/" + workSheetName + "/comments/" + cellName;

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

			Gson gson = new Gson();

			String strResponse = Utils.streamToString(responseStream);
			// Deserializes the JSON to a object.
			CommentsResponse commentResponse = gson.fromJson(strResponse,
					CommentsResponse.class);

			return commentResponse.getComment();

		}

		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// / <summary>
	// /
	// / </summary>
	// / <param name="index"></param>
	// / <returns></returns>
	public OleObject getOleObjectByIndex(int index) {
		try {
			// check whether file is set or not
			if (fileName.equals(""))
				throw new Exception("No file name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + fileName;
			strURI += "/worksheets/" + workSheetName + "/oleobjects/" + index;

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

			Gson gson = new Gson();

			String strResponse = Utils.streamToString(responseStream);

			// Deserializes the JSON to a object.
			OleObjectsResponse oleObjectsResponse = gson.fromJson(strResponse,
					OleObjectsResponse.class);

			return oleObjectsResponse.getOleObject();

		}

		catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	// / <summary>
	// /
	// / </summary>
	// / <param name="index"></param>
	// / <returns></returns>
	public Picture getPictureByIndex(int index) {

		try {
			// check whether file is set or not
			if (fileName.equals(""))
				throw new Exception("No file name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + fileName;
			strURI += "/worksheets/" + workSheetName + "/pictures/" + index;

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

			Gson gson = new Gson();

			String strResponse = Utils.streamToString(responseStream);

			// Deserializes the JSON to a object.
			PicturesResponse picturesResponse = gson.fromJson(strResponse,
					PicturesResponse.class);

			return picturesResponse.getPicture();

		}

		catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public boolean addPicture(String picturePath, PictureLocation location,
			int upperLeftRow, int upperLeftColumn, int lowerRightRow,
			int lowerRightColumn) {
		try {
			if (this.fileName.equals("")) {
				throw new Exception("File Name Not Specified");
			}
			if (this.workSheetName.equals("")) {
				throw new Exception("Worksheet Name Not Specified");
			}
			InputStream response = null;
			if (location.equals(PictureLocation.Server)) {
				String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
						+ "/cells/" + this.fileName;
				strURI += "/worksheets/" + this.workSheetName
						+ "/pictures?upperLeftRow=" + upperLeftRow
						+ "&upperLeftColumn=" + upperLeftColumn
						+ "&lowerRightRow=" + lowerRightRow
						+ "&lowerRightColumn=" + lowerRightColumn
						+ "&picturePath=" + picturePath;
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
				response = Utils.processCommand(signedURI, "PUT");
			} else {
				InputStream fileStream = new FileInputStream(new File(
						picturePath));
				String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
						+ "/cells/" + fileName;
				strURI += "/worksheets/" + workSheetName
						+ "/pictures?upperLeftRow=" + upperLeftRow
						+ "&upperLeftColumn=" + upperLeftColumn
						+ "&lowerRightRow=" + lowerRightRow
						+ "&lowerRightColumn=" + lowerRightColumn;
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
				response = Utils.processCommand(signedURI, "PUT", fileStream);
			}
			Gson gson = new Gson();
			String responseString = Utils.streamToString(response);
			BaseResponse finalResponse = gson.fromJson(responseString,
					BaseResponse.class);
			if (finalResponse.getCode().equals("200")) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	// / <summary>
	// /
	// / </summary>
	// / <param name="index"></param>
	// / <returns></returns>
	public Validation getValidationByIndex(int index) {
		try {
			// check whether file is set or not
			if (fileName.equals(""))
				throw new Exception("No file name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + fileName;
			strURI += "/worksheets/" + workSheetName + "/validations/" + index;

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

			Gson gson = new Gson();

			String strResponse = Utils.streamToString(responseStream);

			// Deserializes the JSON to a object.
			ValidationsResponse validationsResponse = gson.fromJson(
					strResponse, ValidationsResponse.class);

			return validationsResponse.getValidation();

		}

		catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	// / <summary>
	// /
	// / </summary>
	// / <param name="index"></param>
	// / <returns></returns>
	public MergedCell getMergedCellByIndex(int index) {

		try {
			// check whether file is set or not
			if (fileName.equals(""))
				throw new Exception("No file name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + fileName;
			strURI += "/worksheets/" + workSheetName + "/mergedCells/" + index;

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

			Gson gson = new Gson();

			String strResponse = Utils.streamToString(responseStream);

			// Deserializes the JSON to a object.
			MergedCellsResponse mergedCellsResponse = gson.fromJson(
					strResponse, MergedCellsResponse.class);

			return mergedCellsResponse.getMergedCell();

		}

		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// / <summary>
	// /
	// / </summary>
	// / <returns></returns>
	public int getMergedCellsCount() {

		try {

			// check whether file is set or not
			if (fileName.equals(""))
				throw new Exception("No file name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + fileName;
			strURI += "/worksheets/" + workSheetName + "/mergedCells";

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

			Gson gson = new Gson();

			String strResponse = Utils.streamToString(responseStream);

			// Deserializes the JSON to a object.
			WorksheetResponse worksheetResponse = gson.fromJson(strResponse,
					WorksheetResponse.class);

			return worksheetResponse.getMergedCells().getCount();

		}

		catch (Exception e) {
			e.printStackTrace();
			return -1;
		}

	}

	// / <summary>
	// /
	// / </summary>
	// / <returns></returns>
	public int getValidationsCount() {

		try {

			// check whether file is set or not
			if (fileName.equals(""))
				throw new Exception("No file name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + fileName;
			strURI += "/worksheets/" + workSheetName + "/validations";

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

			Gson gson = new Gson();

			String strResponse = Utils.streamToString(responseStream);

			// Deserializes the JSON to a object.
			WorksheetResponse worksheetResponse = gson.fromJson(strResponse,
					WorksheetResponse.class);

			return worksheetResponse.getValidations().getCount();

		}

		catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	// / <summary>
	// /
	// / </summary>
	// / <returns></returns>
	public int getPicturesCount() {

		try {

			// check whether file is set or not
			if (fileName.equals(""))
				throw new Exception("No file name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + fileName;
			strURI += "/worksheets/" + workSheetName + "/pictures";

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

			Gson gson = new Gson();

			String strResponse = Utils.streamToString(responseStream);

			// Deserializes the JSON to a object.
			WorksheetResponse worksheetResponse = gson.fromJson(strResponse,
					WorksheetResponse.class);

			return worksheetResponse.getPictures().getPictureList().size();
		}

		catch (Exception e) {
			e.printStackTrace();
			return -1;
		}

	}

	// / <summary>
	// /
	// / </summary>
	// / <returns></returns>
	public int getOleObjectsCount() {
		try {

			// check whether file is set or not
			if (fileName.equals(""))
				throw new Exception("No file name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + fileName;
			strURI += "/worksheets/" + workSheetName + "/oleobjects";

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

			Gson gson = new Gson();

			String strResponse = Utils.streamToString(responseStream);

			// Deserializes the JSON to a object.
			WorksheetResponse worksheetResponse = gson.fromJson(strResponse,
					WorksheetResponse.class);

			return worksheetResponse.getOleObjects().getOleOjectList().size();
		}

		catch (Exception e) {
			e.printStackTrace();
			return -1;
		}

	}

	// / <summary>
	// /
	// / </summary>
	// / <returns></returns>
	public int getChartsCount() {
		try {
			// check whether file is set or not
			if (fileName.equals(""))
				throw new Exception("No file name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + fileName;
			strURI += "/worksheets/" + workSheetName + "/charts";

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

			Gson gson = new Gson();

			String strResponse = Utils.streamToString(responseStream);

			// Deserializes the JSON to a object.
			WorksheetResponse worksheetResponse = gson.fromJson(strResponse,
					WorksheetResponse.class);

			return worksheetResponse.getCharts().getChartList().size();
		}

		catch (Exception e) {
			e.printStackTrace();
			return -1;
		}

	}

	// / <summary>
	// /
	// / </summary>
	// / <returns></returns>
	public int getCommentsCount() {

		try {
			// check whether file is set or not
			if (fileName.equals(""))
				throw new Exception("No file name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + fileName;
			strURI += "/worksheets/" + workSheetName + "/comments";

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

			Gson gson = new Gson();

			String strResponse = Utils.streamToString(responseStream);

			// Deserializes the JSON to a object.
			WorksheetResponse worksheetResponse = gson.fromJson(strResponse,
					WorksheetResponse.class);

			return worksheetResponse.getComments().getCommentList().size();
		}

		catch (Exception e) {
			e.printStackTrace();
			return -1;
		}

	}

	// / <summary>
	// /
	// / </summary>
	// / <returns></returns>
	public int getHyperlinksCount() {

		try {
			// check whether file is set or not
			if (fileName.equals(""))
				throw new Exception("No file name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + fileName;
			strURI += "/worksheets/" + workSheetName + "/hyperlinks";

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

			Gson gson = new Gson();

			String strResponse = Utils.streamToString(responseStream);

			// Deserializes the JSON to a object.
			WorksheetResponse worksheetResponse = gson.fromJson(strResponse,
					WorksheetResponse.class);

			return worksheetResponse.getHyperlinks().getCount();
		}

		catch (Exception e) {
			e.printStackTrace();
			return -1;
		}

	}

	// / <summary>
	// /
	// / </summary>
	// / <returns></returns>
	public boolean hideWorksheet() {

		try {
			// check whether file is set or not
			if (fileName.equals(""))
				throw new Exception("No file name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + fileName;
			strURI += "/worksheets/" + workSheetName
					+ "/visible?isVisible=false";

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

	// / <summary>
	// /
	// / </summary>
	// / <returns></returns>
	public boolean unhideWorksheet() {

		try {
			// check whether file is set or not
			if (fileName.equals(""))
				throw new Exception("No file name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + fileName;
			strURI += "/worksheets/" + workSheetName
					+ "/visible?isVisible=true";

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

	public boolean moveWorksheet(String worksheetName, Position position) {
		try {
			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/cells/" + fileName
					+ "/worksheets/" + workSheetName + "/position";
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
			MoveWorksheet moveWorksheet = new MoveWorksheet();
			moveWorksheet.setDestinationWorksheet(worksheetName);
			moveWorksheet.setPosition(position);

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

	// / <summary>
	// /
	// / </summary>
	// / <param name="formula"></param>
	// / <returns></returns>
	public String calculateFormula(String formula) {

		try {

			// check whether file is set or not
			if (fileName.equals(""))
				throw new Exception("No file name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + fileName;
			strURI += "/worksheets/" + workSheetName
					+ "/formulaResult?formula=" + formula;

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

			Gson gson = new Gson();

			String strResponse = Utils.streamToString(responseStream);

			// Deserializes the JSON to a object.
			CalculateFormulaResponse formulaResponse = gson.fromJson(
					strResponse, CalculateFormulaResponse.class);

			return formulaResponse.getValue();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean setCellValue(String cellName, String valueType, String value) {
		try {
			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/cells/" + fileName;
			strURI += "/worksheets/" + workSheetName + "/cells/" + cellName
					+ "?value=" + value + "&type=" + valueType;

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
	// / <param name="offset"></param>
	// / <param name="count"></param>
	// / <returns></returns>
	public int getRowsCount(int offset, int count) {

		try {
			// check whether file is set or not
			if (fileName.equals(""))
				throw new Exception("No file name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + fileName;
			strURI += "/worksheets/" + workSheetName + "/rows?offset=" + offset
					+ "&count=" + count;

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

			Gson gson = new Gson();

			String strResponse = Utils.streamToString(responseStream);

			// Deserializes the JSON to a object.
			WorksheetResponse worksheetResponse = gson.fromJson(strResponse,
					WorksheetResponse.class);

			return worksheetResponse.getRows().getRowCount();

		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}

	}

	public Row getRow(int rowIndex) {

		try {
			// check whether file is set or not
			if (fileName.equals(""))
				throw new Exception("No file name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + fileName;
			strURI += "/worksheets/" + workSheetName + "/rows/" + rowIndex;

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

			Gson gson = new Gson();

			String strResponse = Utils.streamToString(responseStream);

			// Deserializes the JSON to a object.
			RowsResponse rowsResponse = gson.fromJson(strResponse,
					RowsResponse.class);

			return rowsResponse.getRow();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	public boolean addRow(int rowIndex) {

		try {
			// check whether file is set or not
			if (fileName.equals(""))
				throw new Exception("No file name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + fileName;
            strURI += "/worksheets/" + workSheetName + "/cells/rows/" + rowIndex;

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

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean editRow(int rowIndex, int height) {

		try {
			// check whether file is set or not
			if (fileName.equals(""))
				throw new Exception("No file name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+  "/cells/" + fileName;
	                strURI += "/worksheets/" + workSheetName + "/cells/rows/" + rowIndex + "?Height=" + height;

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
	public boolean deleteRow(int rowIndex) {

		try {

			// check whether file is set or not
			if (fileName.equals(""))
				throw new Exception("No file name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + fileName;
			strURI += "/worksheets/" + workSheetName + "/rows/" + rowIndex;

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

	public boolean sortData(DataSort dataSort, String cellArea) {
		try {
			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + fileName;
			strURI += "/worksheets/" + workSheetName + "/sort?cellArea="
					+ cellArea;

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

			String strJSON = "";

			Gson gson = new Gson();

			strJSON = gson.toJson(dataSort, DataSort.class);

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

	public Column getColumn(int columnIndex) {

		try {
			// check whether file is set or not
			if (fileName.equals(""))
				throw new Exception("No file name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + fileName;
			strURI += "/worksheets/" + workSheetName + "/columns/"
					+ columnIndex;

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

			// Deserializes the JSON to a object.
			ColumnsResponse columnsResponse = gson.fromJson(strJSON,
					ColumnsResponse.class);

			return columnsResponse.getColumn();
		}

		catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	private String workSheetName;
	private String fileName;
	private boolean IsVisible;
	private boolean IsSelected;
	private boolean IsGridLinesVisible;
	private boolean IsProtected;
	private int Index;
	private String Name;

	public String getWorkSheetName() {
		return workSheetName;
	}

	public String getFileName() {
		return fileName;
	}

	public boolean getIsVisible() {
		return IsVisible;
	}

	public boolean getIsSelected() {
		return IsSelected;
	}

	public boolean getIsGridLinesVisible() {
		return IsGridLinesVisible;
	}

	public boolean getIsProtected() {
		return IsProtected;
	}

	public int getIndex() {
		return Index;
	}

	public String getName() {
		return Name;
	}
	
	public Boolean unProtectWorksheet(String password, WorksheetProtectionType type, ProtectionOptions opts)
	{
		try
		{
			if (fileName.equals(""))
				throw new Exception("No file name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + fileName ;
			strURI +=  "/worksheets/" +workSheetName + "/protection";

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
			Gson gson = new Gson();

			//serialize the JSON request content
			WorksheetProtectionRequest protectionRequest = new WorksheetProtectionRequest();
            protectionRequest.setAllowDeletingColumn ( opts.getAllowDeletingColumn());
            protectionRequest.setAllowDeletingRow ( opts.getAllowDeletingRow());
            protectionRequest.setAllowEditArea ( opts.getAllowEditArea());
            protectionRequest.setAllowFiltering ( opts.getAllowFiltering());
            protectionRequest.setAllowFormattingCell ( opts.getAllowFormattingCell());
            protectionRequest.setAllowFormattingColumn ( opts.getAllowFormattingColumn());
            protectionRequest.setAllowFormattingRow ( opts.getAllowFormattingRow());
            protectionRequest.setAllowInsertingColumn ( opts.getAllowInsertingColumn());
            protectionRequest.setAllowInsertingHyperlink ( opts.getAllowInsertingHyperlink());
            protectionRequest.setAllowInsertingRow ( opts.getAllowInsertingRow());
            protectionRequest.setAllowSelectingLockedCell ( opts.getAllowSelectingLockedCell());
            protectionRequest.setAllowSelectingUnlockedCell ( opts.getAllowSelectingUnlockedCell());
            protectionRequest.setAllowSorting ( opts.getAllowSorting());
            protectionRequest.setAllowUsingPivotTable ( opts.getAllowUsingPivotTable());
            protectionRequest.setPassword ( password);
            protectionRequest.setProtectionType ( type.toString());
			
	        String strJSON = "";
			strJSON = gson.toJson(protectionRequest, WorksheetProtectionRequest.class);
			InputStream responseStream = Utils.processCommand(signedURI, "DELETE",strJSON);

			String strResponse = Utils.streamToString(responseStream);

			// Parse the json string to JObject
			BaseResponse baseResponse = gson.fromJson(strResponse,
					BaseResponse.class);

			if (baseResponse.getCode().equals("200")
					& baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}




	}


}
