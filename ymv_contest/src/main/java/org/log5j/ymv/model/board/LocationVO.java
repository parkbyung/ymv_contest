package org.log5j.ymv.model.board;

public class LocationVO {
	private String location;

	public LocationVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LocationVO(String location) {
		super();
		this.location = location;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "LocationVO [location=" + location + "]";
	}
	
	
}
