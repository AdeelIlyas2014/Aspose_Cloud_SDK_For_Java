package com.aspose.cloud.pdf;

/** 
represents Text in PDF document
*/
public class TextReplace
{
	public TextReplace(){}
	private String oldValue;
	private String newValue;
	private String regex;
	
	public final String getOldValue(){ return oldValue; }
	public final String getNewValue(){ return newValue; }
	public final String getRegex(){ return regex; }
	public final void setOldValue(String value){ oldValue = value; }
	public final void setNewValue(String value){ newValue = value; }
	public final void setRegex(String value){ regex = value; }
}
