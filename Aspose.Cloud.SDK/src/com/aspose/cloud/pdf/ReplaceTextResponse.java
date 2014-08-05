package com.aspose.cloud.pdf;

import java.util.ArrayList;

/** 
represents response of a single text item
*/
public class ReplaceTextResponse extends com.aspose.cloud.common.BaseResponse
{
	private ArrayList<LinkResponse> links;
	private int matches;
	
	public final ArrayList<LinkResponse> getLinks(){ return links; }
	public final int getMatches(){ return matches; }
	
	public final void setLinks(ArrayList<LinkResponse> value){ links = value; }
	public final void setMatches(int value){ matches = value; }
}
