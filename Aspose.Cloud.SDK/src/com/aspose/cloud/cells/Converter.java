package com.aspose.cloud.cells;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import com.aspose.cloud.common.AsposeAppNonStatic;
import com.aspose.cloud.common.Utils;
import com.aspose.cloud.exceptions.AuthorizationException;
import com.aspose.cloud.exceptions.CellsIOException;
import com.aspose.cloud.exceptions.ParameterMissingException;
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
		FileName = fileName;
	}

	public Converter(String fileName, AsposeAppNonStatic auth) {
		this(fileName);
		this.auth = auth;
	}

	// / <summary>
	// / Converter Class Constructor
	// / </summary>
	public Converter(String fileName, String worksheetName) {
		FileName = fileName;
		WorkSheetName = worksheetName;

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
	public boolean AutoShapeToImage(int index, String outputFileName,
			ImageFormat outputformat) {
			// check whether file is set or not
			if (FileName.equals(""))
				throw new ParameterMissingException("No file name specified");
			else if (WorkSheetName.equals(""))
				throw new ParameterMissingException("No Worksheet name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + FileName;
			strURI += "/worksheets/" + WorkSheetName + "/autoshapes/" + index
					+ "?format=" + outputformat;

			// sign URI
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("Converter.AutoShapeToImage: Please Specify AppKey and AppSID");
				} else {
					signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.Sign(strURI);
			}
			boolean response = false;
			InputStream responseStream=null;
			try {
			responseStream = Utils.ProcessCommand(signedURI, "GET");
			response = Folder.SaveStreamToFile(outputFileName,
					responseStream);
			
		    responseStream.close();
			} catch (IOException e) {
				try {
				responseStream.close();
				} catch (Exception e2) {
					
				}
				throw new CellsIOException("Converter.AutoShapeToImage: Some IO error occured while reading remote stream.",e);
			}
			return response;
		
	}

	// / <summary>
	// /
	// / </summary>
	// / <param name="index"></param>
	// / <param name="outputFileName"></param>
	// / <param name="outputformat"></param>
	public boolean ChartToImage(int index, String outputFileName,
			ImageFormat outputformat) {
		
			// check whether file is set or not
			if (FileName.equals(""))
				throw new ParameterMissingException("No file name specified");
			else if (WorkSheetName.equals(""))
				throw new ParameterMissingException("No Worksheet name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + FileName;
			strURI += "/worksheets/" + WorkSheetName + "/charts/" + index
					+ "?format=" + outputformat;

			// sign URI
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("Converter.ChartToImage: Please Specify AppKey and AppSID");
				} else {
					signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.Sign(strURI);
			}

			boolean response = false;
			InputStream responseStream=null;
			try {
			responseStream = Utils.ProcessCommand(signedURI, "GET");
			response = Folder.SaveStreamToFile(outputFileName,
					responseStream);
			responseStream.close();
			} catch (IOException e) {
				try {
				responseStream.close();
				} catch (Exception e2) {
					
				}
				throw new CellsIOException("Converter.ChartToImage: Some IO error occured while reading remote stream.",e);
			}
			return response;
		

	}

	// / <summary>
	// /
	// / </summary>
	// / <param name="index"></param>
	// / <param name="outputFileName"></param>
	// / <param name="outputformat"></param>
	public boolean OleObjectToImage(int index, String outputFileName,
			ImageFormat outputformat) {
			// check whether file is set or not
			if (FileName.equals(""))
				throw new ParameterMissingException("No file name specified");
			else if (WorkSheetName.equals(""))
				throw new ParameterMissingException("No Worksheet name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + FileName;
			strURI += "/worksheets/" + WorkSheetName + "/oleobjects/" + index
					+ "?format=" + outputformat;

			// sign URI
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("Converter.OleObjectToImage: Please Specify AppKey and AppSID");
				} else {
					signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.Sign(strURI);
	
			}
			boolean response = false;
			InputStream responseStream=null;
	        try {
			     responseStream = Utils.ProcessCommand(signedURI, "GET");
			     response = Folder.SaveStreamToFile(outputFileName,
					responseStream);
			     responseStream.close();
	        } catch (IOException e) {
		     try {
		            responseStream.close();
		         } catch (Exception e2) { }
		     
		        	 throw new CellsIOException("Converter.OleObjectToImage: Some IO error occured while reading remote stream.",e);
		    }
		   
	
			return response;
		
	}

	// / <summary>
	// /
	// / </summary>
	// / <param name="index"></param>
	// / <param name="outputFileName"></param>
	// / <param name="outputformat"></param>
	public boolean PictureToImage(int index, String outputFileName,
			ImageFormat outputformat) {

			// check whether file is set or not
			if (FileName.equals(""))
				throw new ParameterMissingException("No file name specified");
			else if (WorkSheetName.equals(""))
				throw new ParameterMissingException("No Worksheet name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + FileName;
			strURI += "/worksheets/" + WorkSheetName + "/pictures/" + index
					+ "?format=" + outputformat;

			// sign URI
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("Converter.PictureToImage: Please Specify AppKey and AppSID");
				} else {
					signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.Sign(strURI);
			}
			boolean response = false;
			InputStream responseStream=null;
	        try {
			responseStream = Utils.ProcessCommand(signedURI, "GET");
			response = Folder.SaveStreamToFile(outputFileName,
					responseStream);
			responseStream.close();
	        } catch (IOException e) {
			     try {
			            responseStream.close();
			         } catch (Exception e2) {}
			        	 throw new CellsIOException("Converter.PictureToImage: Some IO error occured while reading remote stream.",e);
			    }
	        
			return response;
		
	}

	// / <summary>
	// /
	// / </summary>
	// / <param name="outputFileName"></param>
	// / <param name="outputFormat"></param>
	// / <param name="saveLocation"></param>

	public boolean WorksheetToImage(String outputFileName,
			ImageFormat outputFormat) {
			// check whether file is set or not
			if (FileName.equals(""))
				throw new ParameterMissingException("No file name specified");
			else if (WorkSheetName.equals(""))
				throw new ParameterMissingException("No Worksheet name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + FileName;
			strURI += "/worksheets/" + WorkSheetName + "?format="
					+ outputFormat;

			// sign URI
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("Converter.WorksheetToImage: Please Specify AppKey and AppSID");
				} else {
					signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.Sign(strURI);
			}
			boolean response = false;
			InputStream responseStream=null;
	        try {
			responseStream = Utils.ProcessCommand(signedURI, "GET");
			response = Folder.SaveStreamToFile(outputFileName,
					responseStream);
			responseStream.close();
	        } catch (IOException e) {
			     try {
			            responseStream.close();
			         } catch (Exception e2) {}
			        	 throw new CellsIOException("Converter.WorksheetToImage: Some IO error occured while reading remote stream.",e);
			    }
	        
			return response;
	}

	public boolean Save(String outputFileName, SaveFormat outputFormat)  {
			// check whether file is set or not
			if (FileName.equals(""))
				throw new ParameterMissingException("No file name specified");

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/" + FileName;
			strURI += "?format=" + outputFormat;

			// sign URI
			String signedURI = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("Converter.Save: Please Specify AppKey and AppSID");
				} else {
					signedURI = Utils.Sign(strURI, this.auth.getAppKey(),
							this.auth.getAppSID());
				}
			} else {
				signedURI = Utils.Sign(strURI);
			}
			boolean response = false;
			InputStream responseStream=null;
	        try {
			responseStream = Utils.ProcessCommand(signedURI, "GET");
			response = Folder.SaveStreamToFile(outputFileName,
					responseStream);
			responseStream.close();
	        } catch (IOException e) {
			     try {
			            responseStream.close();
			         } catch (Exception e2) {}
			        	 throw new CellsIOException("Converter.Save: Some IO error occured while reading remote stream.",e);
			    }
	        
			return response;
	}

	// / <summary>
	// / Convert PDF to different file format without using storage
	// / </summary>
	// / <param name="outputFileName"></param>
	// / <param name="outputFormat"></param>
	public void ConvertLocalFile(String inputPath, String outputPath,
			SaveFormat outputFormat) {

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/convert?format=" + outputFormat;

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
			InputStream responseStream=null;
			InputStream stream =null;
	        try {
			stream = new FileInputStream(inputPath);

			// get response stream
			responseStream = Utils.ProcessCommand(signedURI, "PUT",
					stream);

			Folder.SaveStreamToFile(outputPath, responseStream);

			responseStream.close();
			stream.close();
	        } catch (IOException e) {
			     try {
			            responseStream.close();
			            stream.close();
			         } catch (Exception e2) {}
			        	 throw new CellsIOException("Converter.ConvertLocalFile: Some IO error occured while writing to remote stream.",e);
			    }
	        


	}

	public void ConvertLocalFile(InputStream inputStream, String outputPath,
			SaveFormat saveFormat)  {

			// build URI
			String strURI = com.aspose.cloud.common.Product.getBaseProductUri()
					+ "/cells/convert?format=" + saveFormat;

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
			InputStream responseStream=null;
	        try {
			// get response stream
			responseStream = Utils.ProcessCommand(signedURI, "PUT",
					inputStream);

			Folder.SaveStreamToFile(outputPath, responseStream);

			responseStream.close();
	        } catch (IOException e) {
			     try {
			            responseStream.close();
			         } catch (Exception e2) {}
			        	 throw new CellsIOException("Converter.ConvertLocalFile: Some IO error occured while writing to remote stream.",e);
			    }
	        
	}

	// / <summary>
	// /
	// / </summary>
	public String WorkSheetName;

	// / <summary>
	// / Workbook name
	// / </summary>
	public String FileName;

}