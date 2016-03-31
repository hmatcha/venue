package com.venue.domain;

public class InvalidSeatHoldIdException extends Exception {
	public InvalidSeatHoldIdException(String errorMessage) {
		super(errorMessage);
	}
}
