package com.aspose.cloud.words;

public class DocumentEntry
{
	public DocumentEntry()
	{
	}

	public DocumentEntry(String href, String importFormatMode)
	{
		setHref(href);
		setImportFormatMode(importFormatMode);
	}

	private String href;
	public final String getHref()
	{
		return href;
	}
	public final void setHref(String value)
	{
		href = value;
	}

	private String importFormatMode;
	public final String getImportFormatMode()
	{
		return importFormatMode;
	}
	public final void setImportFormatMode(String value)
	{
		importFormatMode = value;
	}
}

