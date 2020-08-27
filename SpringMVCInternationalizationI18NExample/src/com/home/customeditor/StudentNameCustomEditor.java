package com.home.customeditor;

import java.beans.PropertyEditorSupport;

public class StudentNameCustomEditor extends PropertyEditorSupport {
	
	@Override
	public void setAsText(String studentName) throws IllegalArgumentException {
		if(studentName != null && !studentName.isEmpty())
			setValue(studentName.toUpperCase());
	}

}
