package com.aspose.cloud.common;

public class AsposeAppNonStatic {
	private String appSID;
	private String appKey;

	public AsposeAppNonStatic(String _appKey, String _appSID) {
		this.appKey = _appKey;
		this.appSID = _appSID;
	}

	public String getAppSID() {
		return appSID;
	}

	public void setAppSID(String _appSID) {
		appSID = _appSID;
	}

	public String getAppKey() {
		return appKey;
	}

	public void setAppKey(String _appKey) {
		appKey = _appKey;
	}

	public boolean validateAuth() {
		if (this.appKey.equals("") || this.appKey.equals(null) || this.appKey.length() == 0
				|| this.appSID.equals("") || this.appKey.equals(null) || this.appSID.length() == 0) {
			return false;
		} else {
			return true;
		}

	}

}
