/**
 * 
 */
package com.aspose.cloud.storage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import com.aspose.cloud.exceptions.AuthorizationException;
import com.aspose.cloud.exceptions.CommonIOException;
import com.aspose.cloud.exceptions.StorageAPIException;
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
	public List<com.aspose.cloud.storage.File> GetFilesList(String strFolder) {
			// StreamReader reader = new StreamReader(Common.
			// Utils.ProcessCommand(CommonUtils.Sign(this.strURIFolder +
			// strFolder), "GET") );
			// further process JSON response
			String strJSON = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppSID and AppKey");
					throw new AuthorizationException("Folder.GetFilesList: Please Specify AppKey and AppSID");
					
				} else {

					strJSON = Utils.StreamToString(Utils.ProcessCommand(
							Utils.Sign(this.strURIFolder + strFolder,
									this.auth.getAppKey(),
									this.auth.getAppSID()), "GET"));
				}
			} else {
				strJSON = Utils.StreamToString(Utils.ProcessCommand(
						Utils.Sign(this.strURIFolder + strFolder), "GET"));
			}

			return FileCollection.getFilesList(strJSON);
	}

	public List<com.aspose.cloud.storage.File> GetFilesList(String strFolder,
			StorageType storageType, String storageName) {
			String strJSON = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppSID and AppKey");
					throw new AuthorizationException("Folder.GetFilesList: Please Specify AppKey and AppSID");
					
				} else {
					strJSON = Utils.StreamToString(Utils.ProcessCommand(
							Utils.Sign(this.strURIFolder + strFolder
									+ "?storage=" + storageName,
									this.auth.getAppKey(),
									this.auth.getAppSID()), "GET"));
				}
			} else {
				strJSON = Utils.StreamToString(Utils.ProcessCommand(
						Utils.Sign(this.strURIFolder + strFolder + "?storage="
								+ storageName), "GET"));
			}

			return FileCollection.getFilesList(strJSON);
	}

	// / <summary>
	// / Deletes a file from the storage. Use "FolderName/FileName" to specify a
	// file under specific folder.
	// / </summary>
	// / <param name="strFileName"></param>
	public boolean DeleteFile(String strFileName) {
			InputStream responseStream;
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					responseStream = Utils
							.ProcessCommand(
									Utils.Sign(this.strURIFile + strFileName),
									"DELETE");
				} else {
					responseStream = Utils.ProcessCommand(
							Utils.Sign(this.strURIFile + strFileName,
									this.auth.getAppKey(),
									this.auth.getAppSID()), "DELETE");
				}
			} else {
				responseStream = Utils.ProcessCommand(
						Utils.Sign(this.strURIFile + strFileName), "DELETE");
			}
			String strResponse = Utils.StreamToString(responseStream);

			Gson gson = new Gson();
			// Parse the json string to JObject
			BaseResponse baseResponse = gson.fromJson(strResponse,
					BaseResponse.class);

			if (baseResponse.getCode().equals("200")
					& baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;

	}

	public boolean DeleteFile(String strFileName, StorageType storageType,
			String storageName)  {
			InputStream responseStream = null;
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppSID and AppKey");
					throw new AuthorizationException("Folder.DeleteFile: Please Specify AppKey and AppSID");
					
				} else {

					responseStream = Utils.ProcessCommand(
							Utils.Sign(this.strURIFile + strFileName
									+ "?storage=" + storageName,
									this.auth.getAppKey(),
									this.auth.getAppSID()), "DELETE");
				}
			} else {
				responseStream = Utils.ProcessCommand(
						Utils.Sign(this.strURIFile + strFileName + "?storage="
								+ storageName), "DELETE");
			}
			String strResponse = Utils.StreamToString(responseStream);

			Gson gson = new Gson();
			// Parse the json string to JObject
			BaseResponse baseResponse = gson.fromJson(strResponse,
					BaseResponse.class);

			if (baseResponse.getCode().equals("200")
					& baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;

	}

	public boolean UploadFile(InputStream fileStream, String strRemoteFileName,
			String strFolder) throws Exception {
		return UploadFile(fileStream, strRemoteFileName, strFolder, null, null);
	}

	
	

	
	// / <summary>
	// / Deletes an empty folder from the storage. Use
	// "FolderName/SubFolderName" for sub folders.
	// / </summary>
	// / <param name="strFolderName"></param>
	public boolean DeleteFolder(String strFolderName) {
			InputStream responseStream = null;
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppSID and AppKey");
					throw new AuthorizationException("Folder.DeleteFolder: Please Specify AppKey and AppSID");
					
				} else {
					responseStream = Utils.ProcessCommand(Utils.Sign(
							this.strURIFolder, this.auth.getAppKey(),
							this.auth.getAppSID()), "DELETE");
				}
			} else {
				responseStream = Utils
						.ProcessCommand(
								Utils.Sign(this.strURIFolder + strFolderName),
								"DELETE");
			}
			String strResponse = Utils.StreamToString(responseStream);

			Gson gson = new Gson();
			// Parse the json string to JObject
			BaseResponse baseResponse = gson.fromJson(strResponse,
					BaseResponse.class);

			if (baseResponse.getCode().equals("200")
					& baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;
	}

	public boolean DeleteFolder(String strFolderName, StorageType storageType,
			String storageName) {
			InputStream responseStream = null;
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppKey and AppSID");
					throw new AuthorizationException("Folder.DeleteFolder: Please Specify AppKey and AppSID");

				} else {
					responseStream = Utils.ProcessCommand(
							Utils.Sign(this.strURIFolder + strFolderName
									+ "?storage=" + storageName,
									this.auth.getAppKey(),
									this.auth.getAppSID()), "DELETE");
				}

			} else {
				responseStream = Utils.ProcessCommand(
						Utils.Sign(this.strURIFolder + strFolderName
								+ "?storage=" + storageName), "DELETE");
			}

			String strResponse = Utils.StreamToString(responseStream);

			Gson gson = new Gson();
			// Parse the json string to JObject
			BaseResponse baseResponse = gson.fromJson(strResponse,
					BaseResponse.class);

			if (baseResponse.getCode().equals("200")
					& baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;
	}
	public boolean UploadFile(String strFile, String strFolder){
		 return UploadFile(strFile, strFolder, null, null);
		 }
	public boolean UploadFile(String strFile, String strFolder,StorageType storageType, String storageName){
		File localFile = new File(strFile);
		FileInputStream fileStream;
		try {
			fileStream = new FileInputStream(localFile);
		} catch (FileNotFoundException e) {
			throw new StorageAPIException("Folder.UploadFile: Specified file not found!",e);
		}
		String strRemoteFileName = localFile.getName();
		return UploadFile(fileStream, strRemoteFileName, strFolder,	storageType, storageName);

	}
	


	public boolean UploadFile(InputStream fileStream, String strRemoteFileName, String strFolder,
			StorageType storageType, String storageName) {

				
				String strURIRequest = this.strURIFile
						+ (strFolder.equals("") ? "" : strFolder + "/")
						+ strRemoteFileName;
				String strURISigned = "";
				if (this.auth != null) {
					if (!this.auth.validateAuth()) {
						System.out.println("Please Specify AppSID and AppKey");
						throw new AuthorizationException("Folder.UploadFile: Please Specify AppKey and AppSID");

					} else {
						strURISigned = Utils.Sign(strURIRequest,
								this.auth.getAppKey(), this.auth.getAppSID());
					}
				} else {
					strURISigned = Utils.Sign(strURIRequest);
				}
				String strResponse = Utils.UploadFileBinary(fileStream,
						strURISigned, "PUT");

				if (strResponse.contains("OK"))
					return true;
				else
					return false;
			
		}


	// / <summary>
	// / Creates a folder under the specified folder. If no path specified,
	// creates a folder under the root folder.
	// / </summary>
	// / <param name="strFolder"></param>
	public boolean CreateFolder(String strFolder) {
			String strURIRequest = this.strURIFolder + strFolder;
			String strURISigned = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppSID and AppKey");
					throw new AuthorizationException("Folder.CreateFolder: Please Specify AppKey and AppSID");

				} else {
					strURISigned = Utils.Sign(strURIRequest,
							this.auth.getAppKey(), this.auth.getAppSID());
				}
			} else {
				strURISigned = Utils.Sign(strURIRequest);
			}

			Utils.ProcessCommand(strURISigned, "PUT");
			InputStream responseStream = Utils.ProcessCommand(strURISigned,
					"PUT");

			String strJSON = Utils.StreamToString(responseStream);

			Gson gson = new Gson();
			// Parse and Deserializes the JSON to a object.
			BaseResponse baseResponse = gson.fromJson(strJSON,
					BaseResponse.class);

			if (baseResponse.getCode().equals("200")
					& baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;
	}

	public boolean CreateFolder(String strFolder, StorageType storageType,
			String storageName) {
			String strURIRequest = this.strURIFolder + strFolder + "?storage="
					+ storageName;
			String strURISigned = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppSID and AppKey");
					throw new AuthorizationException("Folder.CreateFolder: Please Specify AppKey and AppSID");

				} else {
					strURISigned = Utils.Sign(strURIRequest,
							this.auth.getAppKey(), this.auth.getAppSID());
				}
			} else {
				strURISigned = Utils.Sign(strURIRequest);
			}

			Utils.ProcessCommand(strURISigned, "PUT");
			InputStream responseStream = Utils.ProcessCommand(strURISigned,
					"PUT");

			String strJSON = Utils.StreamToString(responseStream);

			Gson gson = new Gson();
			// Parse and Deserializes the JSON to a object.
			BaseResponse baseResponse = gson.fromJson(strJSON,
					BaseResponse.class);

			if (baseResponse.getCode().equals("200")
					& baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;
	}

	// / <summary>
	// / Checks whether file or folder exists on the Aspose storage.
	// / </summary>
	// / <param name="strFolderOrFile"></param>
	// / <returns></returns>
	public com.aspose.cloud.storage.FileExist FileExist(String strFolderOrFile) {
			String strURIRequest = this.strURIExist + strFolderOrFile;
			String strURISigned = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppSID and AppKey");
					throw new AuthorizationException("Folder.FileExist: Please Specify AppKey and AppSID");

				} else {
					strURISigned = Utils.Sign(strURIRequest,
							this.auth.getAppKey(), this.auth.getAppSID());
				}
			} else {
				strURISigned = Utils.Sign(strURIRequest);
			}
			InputStream responseStream = Utils.ProcessCommand(strURISigned,
					"GET");

			String strJSON = Utils.StreamToString(responseStream);

			Gson gson = new Gson();
			// Parse the json string to JObject
			ExistResponse existResponse = gson.fromJson(strJSON,
					ExistResponse.class);

			return existResponse.getFileExist();

	}

	public com.aspose.cloud.storage.FileExist FileExist(String strFolderOrFile,
			StorageType storageType, String storageName) {
			String strURIRequest = this.strURIExist + strFolderOrFile
					+ "?storage=" + storageName;
			String strURISigned = "";
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppSID and AppKey");
					throw new AuthorizationException("Folder.FileExist: Please Specify AppKey and AppSID");

				} else {
					strURISigned = Utils.Sign(strURIRequest,
							this.auth.getAppKey(), this.auth.getAppSID());
				}
			} else {
				strURISigned = Utils.Sign(strURIRequest);
			}

			InputStream responseStream = Utils.ProcessCommand(strURISigned,
					"GET");

			String strJSON = Utils.StreamToString(responseStream);

			Gson gson = new Gson();
			// Parse the json string to JObject
			ExistResponse existResponse = gson.fromJson(strJSON,
					ExistResponse.class);

			return existResponse.getFileExist();

	}

	// / <summary>
	// / Provides the total / free disc size in bytes for your app.
	// / </summary>
	// / <returns></returns>
	public DiscUsage GetDiscUsage() {
			InputStream responseStream = null;
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppSID and AppKey");
					throw new AuthorizationException("Folder.GetDiscUsage: Please Specify AppKey and AppSID");

				} else {
					responseStream = Utils.ProcessCommand(Utils.Sign(
							this.strURIDisc, this.auth.getAppKey(),
							this.auth.getAppSID()), "GET");
				}
			} else {
				responseStream = Utils.ProcessCommand(
						Utils.Sign(this.strURIDisc), "GET");
			}

			String strJSON = Utils.StreamToString(responseStream);

			Gson gson = new Gson();
			// Parse the json string to JObject
			DiscResponse discResponse = gson.fromJson(strJSON,
					DiscResponse.class);

			return discResponse.getDiscUsage();

	}

	public DiscUsage GetDiscUsage(StorageType storageType, String storageName) {
			InputStream responseStream = null;
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppSID and AppKey");
					throw new AuthorizationException("Folder.GetDiscUsage: Please Specify AppKey and AppSID");

				} else {
					responseStream = Utils.ProcessCommand(Utils.Sign(
							this.strURIDisc + "?storage=" + storageName,
							this.auth.getAppKey(), this.auth.getAppSID()),
							"GET");
				}
			} else {
				responseStream = Utils
						.ProcessCommand(
								Utils.Sign(this.strURIDisc + "?storage="
										+ storageName), "GET");
			}

			String strJSON = Utils.StreamToString(responseStream);

			Gson gson = new Gson();
			// Parse the json string to JObject
			DiscResponse discResponse = gson.fromJson(strJSON,
					DiscResponse.class);

			return discResponse.getDiscUsage();

	}

	// / <summary>
	// / Get file from Aspose server
	// / </summary>
	// / <param name="fileName">file name on the server</param>
	// / <returns></returns>
	public InputStream GetFile(String fileName) throws SignatureException {
			if (this.auth != null) {
				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppSID and AppKey");
					throw new AuthorizationException("Folder.GetFile: Please Specify AppKey and AppSID");

				} else {
					return Utils.ProcessCommand(
							Utils.Sign(this.strURIFile + fileName,
									this.auth.getAppKey(),
									this.auth.getAppSID()), "GET");
				}
			} else {
				return Utils.ProcessCommand(
						Utils.Sign(this.strURIFile + fileName), "GET");
			}

	}

	public InputStream GetFile(String fileName, StorageType storageType,
			String storageName) throws SignatureException, CommonIOException {
			if (this.auth != null) {

				if (!this.auth.validateAuth()) {
					System.out.println("Please Specify AppSID and AppKey");
					throw new AuthorizationException("Folder.GetFile: Please Specify AppKey and AppSID");

				} else {
					return Utils.ProcessCommand(Utils.Sign(this.strURIFile
							+ fileName + "?storage=" + storageName,
							this.auth.getAppKey(), this.auth.getAppSID()),
							"GET");
				}
			} else {
				return Utils.ProcessCommand(
						Utils.Sign(this.strURIFile + fileName + "?storage="
								+ storageName), "GET");
			}

	}

	// / <summary>
	// / Get file output file name and input stream as arguments and saves file
	// on disk
	// / </summary>

	// / <returns></returns>

	public static boolean SaveStreamToFile(String FileNameWithPath,
			InputStream inputStream) {

		try {

			// write the inputStream to a FileOutputStream
			OutputStream out = new FileOutputStream(new File(FileNameWithPath));
			IOUtils.copy(inputStream, out);
			return true;

		} catch (FileNotFoundException e) {
		   throw new StorageAPIException("Folder.SaveStreamToFile: Specified file not found!",e);
		} catch (IOException e) {
			   throw new StorageAPIException("Folder.SaveStreamToFile: Cannot write to OutputSteam!",e);
		}
	}

}
