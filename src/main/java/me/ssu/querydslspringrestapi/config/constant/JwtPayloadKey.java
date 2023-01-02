package me.ssu.querydslspringrestapi.config.constant;

import lombok.Getter;

@Getter
public enum JwtPayloadKey {
	MANAGER_ACCOUNT_SERIAL_NO("managerAccountSerialNo"),
	MEMBER_EMAIL("memberEmail"),
	MEMBER_NAME("memberName"),
	ROLES("roles"),
	MANAGER_MENU_GROUP_ID("managerMenuGroupId");

	private final String key;

	JwtPayloadKey(final String key) {
		this.key = key;
	}
}