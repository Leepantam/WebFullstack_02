package com.leepantam.s1.util;

public class ActionFoward {
	private String path;
	private boolean check; // check 가 true면 foward, false면 redirect

	public boolean isCheck() {
		return check;
	}

	public void setCheck(boolean check) {
		this.check = check;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
