package com.swust.zj.base;

public class FieldModel {
	private String fieldName;
	private String type;

	public String getFieldName(int i) {
		if(i==0) {
		fieldName = Utils.getfield(fieldName);
		}else if(i==1) {
		fieldName = Utils.getModelName(fieldName);
		}
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getType() {
		if (fieldName.equals("varchar")) {
			fieldName = "String";
		} else if (fieldName.equals("int")) {
			fieldName = "Integer";
		} else if (fieldName.equals("timestamp")) {
			fieldName = "Date";
		}
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
