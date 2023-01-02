package me.ssu.querydslspringrestapi.config.constant;

import lombok.Getter;

@Getter
public enum ClientHeaderKey {

	AUTHORIZATION("Authorization");

	private final String key;

	ClientHeaderKey(final String key) {
		this.key = key;
	}
}