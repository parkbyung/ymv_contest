package org.log5j.ymv.model.board;

public class FieldVO {
	private String field;

	public FieldVO() {
		super();
	}

	public FieldVO(String field) {
		super();
		this.field = field;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	@Override
	public String toString() {
		return "FieldVO [field=" + field + "]";
	}
	
	
}
