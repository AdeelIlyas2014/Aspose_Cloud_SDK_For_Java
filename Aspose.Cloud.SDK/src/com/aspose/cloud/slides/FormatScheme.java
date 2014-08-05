package com.aspose.cloud.slides;

public class FormatScheme {
	public UriResponse getSelfUri() {
		return selfUri;
	}

	public void setSelfUri(UriResponse _selfUri) {
		selfUri = _selfUri;
	}

	public BackgroundStyles[] getBackgroundStyles() {
		return backgroundStyles;
	}

	public void setBackgroundStyles(BackgroundStyles[] _backgroundStyles) {
		backgroundStyles = _backgroundStyles;
	}

	public EffectStyles[] getEffectStyles() {
		return effectStyles;
	}

	public void setEffectStyles(EffectStyles[] _effectStyles) {
		effectStyles = _effectStyles;
	}

	public FillStyles[] getFillStyles() {
		return fillStyles;
	}

	public void setFillStyles(FillStyles[] _fillStyles) {
		fillStyles = _fillStyles;
	}

	public LineStyles[] getLineStyles() {
		return lineStyles;
	}

	public void setLineStyles(LineStyles[] _lineStyles) {
		lineStyles = _lineStyles;
	}

	public FormatScheme() {
	}

	private UriResponse selfUri;
	private BackgroundStyles[] backgroundStyles;
	private EffectStyles[] effectStyles;
	private FillStyles[] fillStyles;
	private LineStyles[] lineStyles;
}
