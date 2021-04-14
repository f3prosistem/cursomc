package com.f3pro.cursomc.resources.exception;

import java.io.Serializable;

public class FieldMessege implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String fildName;
    private String messege;
    
	public FieldMessege(String fildName, String messege) {
		super();
		this.fildName = fildName;
		this.messege = messege;
	}
	public String getFildName() {
		return fildName;
	}
	public void setFildName(String fildName) {
		this.fildName = fildName;
	}
	public String getMessege() {
		return messege;
	}
	public void setMessege(String messege) {
		this.messege = messege;
	}
    
    

}
