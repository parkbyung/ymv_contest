package org.log5j.ymv.model.statistics;

public class StatisticsVO {
	private int age;
	private String field;
	private int applicateCount;
	public StatisticsVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StatisticsVO(int age, String field, int applicateCount) {
		super();
		this.age = age;
		this.field = field;
		this.applicateCount = applicateCount;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public int getApplicateCount() {
		return applicateCount;
	}
	public void setApplicateCount(int applicateCount) {
		this.applicateCount = applicateCount;
	}
	@Override
	public String toString() {
		return "StaticsVO [age=" + age + ", field=" + field
				+ ", applicateCount=" + applicateCount + "]";
	}
	
	
}
