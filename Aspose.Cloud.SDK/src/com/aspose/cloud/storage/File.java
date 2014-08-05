/**
 * 
 */
package com.aspose.cloud.storage;
import java.util.Date;

/**
 * @author Mudassir
 *
 */
/// <summary>
/// Represents a File part of the Folder resource response
/// </summary>
public class File {
    public File()
    { }
    /// <summary>
    /// Represents file name.
    /// </summary>
    private String name;

    /// <summary>
    /// Indicates whether a folder or file.
    /// </summary>
    private boolean isFolder;

    /// <summary>
    /// Represents last modification date of file or folder.
    /// </summary>
//Need to verify
//     public Calendar ModifiedDate;
//    public String ModifiedDate;
    private Date modifiedDate;

    /// <summary>
    /// Represents the size of the File or Folder.
    /// </summary>
    private long size;
    
    public String getName(){return name;}
    public boolean getIsFolder(){return isFolder;}
    public Date getModifiedDate(){return modifiedDate;}
    public long getSize(){return size;}

}
