/**
 * 
 */
package com.aspose.cloud.common;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import com.aspose.cloud.exceptions.CommonIOException;
/**
 * @author Mudassir
 *
 */


public class  CopyInputStream
{
	private InputStream _is;
	private ByteArrayOutputStream _copy = new ByteArrayOutputStream();

	/**
	 * @throws CommonIOException 
	 * 
	 */
	public CopyInputStream(InputStream is)
	{
		_is = is;
		
			copy();
	}

	private int copy()
	{
		int read = 0;
		int chunk = 0;
		byte[] data = new byte[256];
		
		try {
			while(-1 != (chunk = _is.read(data)))
			{
				read += data.length;
				_copy.write(data, 0, chunk);
			}
		} catch (IOException e) {
			throw new CommonIOException("CopyInputSteam.copy() Some error occurred while copying InputSteam",e);
			
		}
		
		return read;
	}
	
	public InputStream getCopy()
	{
		return (InputStream)new ByteArrayInputStream(_copy.toByteArray());
	}
}
