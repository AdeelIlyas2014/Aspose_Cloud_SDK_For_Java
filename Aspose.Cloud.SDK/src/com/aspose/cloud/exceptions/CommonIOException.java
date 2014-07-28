package com.aspose.cloud.exceptions;

import java.io.IOException;

public class CommonIOException extends RuntimeException
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	  public CommonIOException(String message)
      {
         super(message);
      }
	  
	  public CommonIOException (String message, Throwable cause)
      {
      super (message, cause);
      }
}