/**
 * 
 */
package com.aspose.cloud.slides;

import java.util.List;

/**
 * @author Mudassir
 * 
 */
// / <summary>
// / represents a single property of the document
// / </summary>
public class Shape {
	public Shape() {
	}

	private String alternativeText;
	private float height;
	private boolean hidden;
	private String name;
	public String getName(){return name;}
	public void setName(String name){this.name=name;}

	private float width;
	private float x;
	private float y;
	private List<LinkResponse> shapes;
	private FillFormatURI fillFormat;
	private LineFormatURI lineFormat;

	public String getAlternativeText() {
		return alternativeText;
	}

	public float getHeight() {
		return height;
	}

	public float getWidth() {
		return width;
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public boolean getIsHidden() {
		return hidden;
	};

	public FillFormatURI getFillFormat() {
		return fillFormat;
	}

	public LineFormatURI getLineFormat() {
		return lineFormat;
	}

	public List<LinkResponse> getLinkResponse() {
		return shapes;
	}

}