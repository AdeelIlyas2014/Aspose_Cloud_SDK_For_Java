package com.aspose.cloud.slides;

import java.util.List;

public class Theme {
	private List<LinkResponse> links;
	public List<LinkResponse> getlinks(){return links;}
	public void setlinks(List<LinkResponse> links){this.links=links;}

	private ThemeColorScheme colorScheme;
	public ThemeColorScheme getColorScheme(){return colorScheme;}
	public void setColorScheme(ThemeColorScheme colorScheme){this.colorScheme=colorScheme;}

	private ThemeFontScheme fontScheme;
	public ThemeFontScheme getFontScheme(){return fontScheme;}
	public void setFontScheme(ThemeFontScheme fontScheme){this.fontScheme=fontScheme;}

	private ThemeFormatScheme formatScheme;
	public ThemeFormatScheme getFormatScheme(){return formatScheme;}
	public void setFormatScheme(ThemeFormatScheme formatScheme){this.formatScheme=formatScheme;}

	private String name;
	public String getName(){return name;}
	public void setName(String name){this.name=name;}

}
