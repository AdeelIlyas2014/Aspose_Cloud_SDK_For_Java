package com.aspose.cloud.slides;

import java.util.List;

public class Slide {
	private List<LinkResponse> links;
	public List<LinkResponse> getlinks(){return links;}
	public void setlinks(List<LinkResponse> links){this.links=links;}

	private Images images;
	public Images getImages(){return images;}
	public void setImages(Images images){this.images=images;}

	private Placeholders placeholders;
	public Placeholders getPlaceholders(){return placeholders;}
	public void setPlaceholders(Placeholders placeholders){this.placeholders=placeholders;}

	private Shapes shapes;
	public Shapes getShapes(){return shapes;}
	public void setShapes(Shapes shapes){this.shapes=shapes;}

	private SlideTheme theme;
	public SlideTheme getTheme(){return theme;}
	public void setTheme(SlideTheme theme){this.theme=theme;}

}
