/**
 * 
 */
package com.aspose.cloud.storage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.SignatureException;
import java.util.List;

import org.apache.commons.io.IOUtils;

import com.aspose.cloud.common.AsposeAppNonStatic;
import com.aspose.cloud.common.BaseResponse;
import com.aspose.cloud.common.Utils;
import com.google.gson.Gson;

/**
 * @author Mudassir
 * 
 */
public class Folder {
	private AsposeAppNonStatic auth;
	private String strURIFolder = com.aspose.cloud.common.Product
			.getBaseProductUri() + "/storage/folder/";
	private String strURIFile = com.aspose.cloud.common.Product
			.getBaseProductUri() + "/storage/file/";
	private String strURIExist = com.aspose.cloud.common.Product
			.getBaseProductUri() + "/storage/exist/";
	private String strURIDisc = com.aspose.cloud.common.Product
			.getBaseProductUri() + "/storage/disc/";

	public Folder() {

	}

	public Folder(AsposeAppNonStatic auth) {
		this();
		this.auth = auth;
	}

	// / <summary>
	// / Retrives the list of files and folders under the specified folder. Use
	// empty string to specify root folder.
	// / </summary>
	// / <param name="strFolder"></param>
	// / <returns></returns>
	public List<com.aspose.cloud.storage.File> getFilesList(String strFolder) {
		try {
			// StreamReader reader = new StreamReader(Common.
			// Utils.ProcessCommand(CommonUtils.Sign(this.strURIFolder +
			// strFolder), "GET") );
			// further process JSON response
			String strJSON = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppSID and AppKey");
				} else {

					strJSON = Utils.streamToString(Utils.processCommand(
							Utils.sign(this.strURIFolder + strFolder,
									this.auth.getAppKey(),
									this.auth.getAppSID()), "GET"));
				}
			} else {
				strJSON = Utils.streamToString(Utils.processCommand(
						Utils.sign(this.strURIFolder + strFolder), "GET"));
			}

			return FileCollection.getFilesList(strJSON);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public List<com.aspose.cloud.storage.File> getFilesList(String strFolder,
			StorageType storageType, String storageName) {
		try {
			String strJSON = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppSID and AppKey");
				} else {
					strJSON = Utils.streamToString(Utils.processCommand(
							Utils.sign(this.strURIFolder + strFolder
									+ "?storage=" + storageName,
									this.auth.getAppKey(),
									this.auth.getAppSID()), "GET"));
				}
			} else {
				strJSON = Utils.streamToString(Utils.processCommand(
						Utils.sign(this.strURIFolder + strFolder + "?storage="
								+ storageName), "GET"));
			}

			return FileCollection.getFilesList(strJSON);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	// / <summary>
	// / Deletes a file from the storage. Use "FolderName/FileName" to specify a
	// file under specific folder.
	// / </summary>
	// / <param name="strFileName"></param>
	public boolean deleteFile(String strFileName) throws Exception {
		try {
			InputStream responseStream;
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					responseStream = Utils
							.processCommand(
									Utils.sign(this.strURIFile + strFileName),
									"DELETE");
				} else {
					responseStream = Utils.processCommand(
							Utils.sign(this.strURIFile + strFileName,
									this.auth.getAppKey(),
									this.auth.getAppSID()), "DELETE");
				}
			} else {
				responseStream = Utils.processCommand(
						Utils.sign(this.strURIFile + strFileName), "DELETE");
			}
			String strResponse = Utils.streamToString(responseStream);

			Gson gson = new Gson();
			// Parse the json string to JObject
			BaseResponse baseResponse = gson.fromJson(strResponse,
					BaseResponse.class);

			if (baseResponse.getCode().equals("200")
					& baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public boolean deleteFile(String strFileName, StorageType storageType,
			String storageName) throws Exception {
		try {
			InputStream responseStream = null;
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppSID and AppKey");
				} else {

					responseStream = Utils.processCommand(
							Utils.sign(this.strURIFile + strFileName
									+ "?storage=" + storageName,
									this.auth.getAppKey(),
									this.auth.getAppSID()), "DELETE");
				}
			} else {
				responseStream = Utils.processCommand(
						Utils.sign(this.strURIFile + strFileName + "?storage="
								+ storageName), "DELETE");
			}
			String strResponse = Utils.streamToString(responseStream);

			Gson gson = new Gson();
			// Parse the json string to JObject
			BaseResponse baseResponse = gson.fromJson(strResponse,
					BaseResponse.class);

			if (baseResponse.getCode().equals("200")
					& baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public boolean uploadFile(InputStream fileStream, String strRemoteFileName,
			String strFolder) throws Exception {
		return uploadFile(fileStream, strRemoteFileName, strFolder, null, null);
	}

	
	

	
	// / <summary>
	// / Deletes an empty folder from the storage. Use
	// "FolderName/SubFolderName" for sub folders.
	// / </summary>
	// / <param name="strFolderName"></param>
	public boolean deleteFolder(String strFolderName) throws Exception {
		try {
			InputStream responseStream = null;
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppSID and AppKey");
				} else {
					responseStream = Utils.processCommand(Utils.sign(
							this.strURIFolder, this.auth.getAppKey(),
							this.auth.getAppSID()), "DELETE");
				}
			} else {
				responseStream = Utils
						.processCommand(
								Utils.sign(this.strURIFolder + strFolderName),
								"DELETE");
			}
			String strResponse = Utils.streamToString(responseStream);

			Gson gson = new Gson();
			// Parse the json string to JObject
			BaseResponse baseResponse = gson.fromJson(strResponse,
					BaseResponse.class);

			if (baseResponse.getCode().equals("200")
					& baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public boolean deleteFolder(String strFolderName, StorageType storageType,
			String storageName) throws Exception {
		try {
			InputStream responseStream = null;
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
				} else {
					responseStream = Utils.processCommand(
							Utils.sign(this.strURIFolder + strFolderName
									+ "?storage=" + storageName,
									this.auth.getAppKey(),
									this.auth.getAppSID()), "DELETE");
				}

			} else {
				responseStream = Utils.processCommand(
						Utils.sign(this.strURIFolder + strFolderName
								+ "?storage=" + storageName), "DELETE");
			}

			String strResponse = Utils.streamToString(responseStream);

			Gson gson = new Gson();
			// Parse the json string to JObject
			BaseResponse baseResponse = gson.fromJson(strResponse,
					BaseResponse.class);

			if (baseResponse.getCode().equals("200")
					& baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	public boolean uploadFile(String strFile, String strFolder) throws Exception {
		 return uploadFile(strFile, strFolder, null, null);
		 }
	public boolean uploadFile(String strFile, String strFolder,StorageType storageType, String storageName) throws Exception {
		File localFile = new File(strFile);
		FileInputStream fileStream = new FileInputStream(localFile);
		String strRemoteFileName = localFile.getName();
		return uploadFile(fileStream, strRemoteFileName, strFolder,	storageType, storageName);

	}
	


	public boolean uploadFile(InputStream fileStream, String strRemoteFileName, String strFolder,
			StorageType storageType, String storageName) throws Exception {

			try {
				
				String strURIRequest = this.strURIFile
						+ (strFolder.equals("") ? "" : strFolder + "/")
						+ strRemoteFileName;
				String strURISigned = "";
				if (this.auth != null) {
					if (!this.auth.validateAuth()) {
						System.out.println("Please Specify AppSID and AppKey");
					} else {
						strURISigned = Utils.sign(strURIRequest,
								this.auth.getAppKey(), this.auth.getAppSID());
					}
				} else {
					strURISigned = Utils.sign(strURIRequest);
				}
				String strResponse = Utils.uploadFileBinary(fileStream,
						strURISigned, "PUT");

				if (strResponse.contains("OK"))
					return true;
				else
					return false;
			} catch (Exception ex) {
				throw new Exception(ex.getMessage());
			}
		}


	// / <summary>
	// / Creates a folder under the specified folder. If no path specified,
	// creates a folder under the root folder.
	// / </summary>
	// / <param name="strFolder"></param>
	public boolean createFolder(String strFolder) throws Exception {
		try {
			String strURIRequest = this.strURIFolder + strFolder;
			String strURISigned = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppSID and AppKey");
				} else {
					strURISigned = Utils.sign(strURIRequest,
							this.auth.getAppKey(), this.auth.getAppSID());
				}
			} else {
				strURISigned = Utils.sign(strURIRequest);
			}

			Utils.processCommand(strURISigned, "PUT");
			InputStream responseStream = Utils.processCommand(strURISigned,
					"PUT");

			String strJSON = Utils.streamToString(responseStream);

			Gson gson = new Gson();
			// Parse and Deserializes the JSON to a object.
			BaseResponse baseResponse = gson.fromJson(strJSON,
					BaseResponse.class);

			if (baseResponse.getCode().equals("200")
					& baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public boolean createFolder(String strFolder, StorageType storageType,
			String storageName) throws Exception {
		try {
			String strURIRequest = this.strURIFolder + strFolder + "?storage="
					+ storageName;
			String strURISigned = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppSID and AppKey");
				} else {
					strURISigned = Utils.sign(strURIRequest,
							this.auth.getAppKey(), this.auth.getAppSID());
				}
			} else {
				strURISigned = Utils.sign(strURIRequest);
			}

			Utils.processCommand(strURISigned, "PUT");
			InputStream responseStream = Utils.processCommand(strURISigned,
					"PUT");

			String strJSON = Utils.streamToString(responseStream);

			Gson gson = new Gson();
			// Parse and Deserializes the JSON to a object.
			BaseResponse baseResponse = gson.fromJson(strJSON,
					BaseResponse.class);

			if (baseResponse.getCode().equals("200")
					& baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	// / <summary>
	// / Checks whether file or folder exists on the Aspose storage.
	// / </summary>
	// / <param name="strFolderOrFile"></param>
	// / <returns></returns>
	public com.aspose.cloud.storage.FileExist fileExist(String strFolderOrFile) {
		try {
			String strURIRequest = this.strURIExist + strFolderOrFile;
			String strURISigned = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppSID and AppKey");
				} else {
					strURISigned = Utils.sign(strURIRequest,
							this.auth.getAppKey(), this.auth.getAppSID());
				}
			} else {
				strURISigned = Utils.sign(strURIRequest);
			}
			InputStream responseStream = Utils.processCommand(strURISigned,
					"GET");

			String strJSON = Utils.streamToString(responseStream);

			Gson gson = new Gson();
			// Parse the json string to JObject
			ExistResponse existResponse = gson.fromJson(strJSON,
					ExistResponse.class);

			return existResponse.getFileExist();

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public com.aspose.cloud.storage.FileExist fileExist(String strFolderOrFile,
			StorageType storageType, String storageName) {
		try {
			String strURIRequest = this.strURIExist + strFolderOrFile
					+ "?storage=" + storageName;
			String strURISigned = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppSID and AppKey");
				} else {
					strURISigned = Utils.sign(strURIRequest,
							this.auth.getAppKey(), this.auth.getAppSID());
				}
			} else {
				strURISigned = Utils.sign(strURIRequest);
			}

			InputStream responseStream = Utils.processCommand(strURISigned,
					"GET");

			String strJSON = Utils.streamToString(responseStream);

			Gson gson = new Gson();
			// Parse the json string to JObject
			ExistResponse existResponse = gson.fromJson(strJSON,
					ExistResponse.class);

			return existResponse.getFileExist();

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	// / <summary>
	// / Provides the total / free disc size in bytes for your app.
	// / </summary>
	// / <returns></returns>
	public DiscUsage getDiscUsage() {
		try {
			InputStream responseStream = null;
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppSID and AppKey");
				} else {
					responseStream = Utils.processCommand(Utils.sign(
							this.strURIDisc, this.auth.getAppKey(),
							this.auth.getAppSID()), "GET");
				}
			} else {
				responseStream = Utils.processCommand(
						Utils.sign(this.strURIDisc), "GET");
			}

			String strJSON = Utils.streamToString(responseStream);

			Gson gson = new Gson();
			// Parse the json string to JObject
			DiscResponse discResponse = gson.fromJson(strJSON,
					DiscResponse.class);

			return discResponse.getDiscUsage();

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public DiscUsage getDiscUsage(StorageType storageType, String storageName) {
		try {
			InputStream responseStream = null;
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppSID and AppKey");
				} else {
					responseStream = Utils.processCommand(Utils.sign(
							this.strURIDisc + "?storage=" + storageName,
							this.auth.getAppKey(), this.auth.getAppSID()),
							"GET");
				}
			} else {
				responseStream = Utils
						.processCommand(
								Utils.sign(this.strURIDisc + "?storage="
										+ storageName), "GET");
			}

			String strJSON = Utils.streamToString(responseStream);

			Gson gson = new Gson();
			// Parse the json string to JObject
			DiscResponse discResponse = gson.fromJson(strJSON,
					DiscResponse.class);

			return discResponse.getDiscUsage();

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	// / <summary>
	// / Get file from Aspose server
	// / </summary>
	// / <param name="fileName">file name on the server</param>
	// / <returns></returns>
	public InputStream getFile(String fileName) throws SignatureException {
		try {
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppSID and AppKey");
					return null;
				} else {
					return Utils.processCommand(
							Utils.sign(this.strURIFile + fileName,
									this.auth.getAppKey(),
									this.auth.getAppSID()), "GET");
				}
			} else {
				return Utils.processCommand(
						Utils.sign(this.strURIFile + fileName), "GET");
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public InputStream getFile(String fileName, StorageType storageType,
			String storageName) throws SignatureException {
		try {
			if (this.auth != null) {

				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppSID and AppKey");
					return null;
				} else {
					return Utils.processCommand(Utils.sign(this.strURIFile
							+ fileName + "?storage=" + storageName,
							this.auth.getAppKey(), this.auth.getAppSID()),
							"GET");
				}
			} else {
				return Utils.processCommand(
						Utils.sign(this.strURIFile + fileName + "?storage="
								+ storageName), "GET");
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	// / <summary>
	// / Get file output file name and input stream as arguments and saves file
	// on disk
	// / </summary>

	// / <returns></returns>

	public static boolean saveStreamToFile(String FileNameWithPath,
			InputStream inputStream) {

		try {

			// write the inputStream to a FileOutputStream
			OutputStream out = new FileOutputStream(new File(FileNameWithPath));
			IOUtils.copy(inputStream, out);
			return true;

		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

}
