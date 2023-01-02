package me.ssu.querydslspringrestapi.config.jwt;

public interface AuthToken<T> {

	boolean validate();
	T getData();
}