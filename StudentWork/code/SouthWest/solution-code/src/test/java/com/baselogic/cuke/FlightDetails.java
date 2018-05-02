package com.baselogic.cuke;

public class FlightDetails {

	private String departureTime;

	public String getDepartTime() {
		return this.departureTime;
	}

	public void setDepartTime(String departureTime) {
		this.departureTime = departureTime;
	}

	private String arrivalTime;

	public String getArrivalTime() {
		return this.arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	private String travelTime;

	public String getTravelTime() {
		return this.travelTime;
	}

	public void setTravelTime(String travelTime) {
		this.travelTime = travelTime;
	}
}
