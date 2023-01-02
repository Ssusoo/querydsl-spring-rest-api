package me.ssu.querydslspringrestapi.config.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import me.ssu.querydslspringrestapi.config.constant.JwtPayloadKey;

import java.security.Key;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class JwtAuthToken implements AuthToken<Claims> {

	@Getter
	private final String token;
	private final Key key;

	JwtAuthToken(String token, Key key) {
		this.token = token;
		this.key = key;
	}

	@Override
	public boolean validate() {
		var jwtClaims = getData();
		return jwtClaims != null;
	}

	@Override
	public Claims getData() {
		return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
	}

	/**
	 * JWT claims payload
	 */
	@AllArgsConstructor
	@Getter
	@Builder
	public static class TokenPayload {
		private final Long managerAccountSerialNo;
		private final String memberEmail;
		private final String memberName;
		private final List<String> roles;
		private final String managerMenuGroupId;

		/**
		 * JWT Claims 를 TokenPayload 객체로 변환
		 * @param claims
		 * @return
		 */
		public static TokenPayload of(Claims claims) {
			var roles = convertObjectToList(claims.get(JwtPayloadKey.ROLES.getKey()));
			var managerMenuGroupId = claims.get(JwtPayloadKey.MANAGER_MENU_GROUP_ID.getKey());

			return TokenPayload.builder()
					.managerAccountSerialNo(((Number) claims.get(JwtPayloadKey.MANAGER_ACCOUNT_SERIAL_NO.getKey())).longValue())
					.memberEmail(claims.get(JwtPayloadKey.MEMBER_EMAIL.getKey()).toString())
					.memberName(claims.get(JwtPayloadKey.MEMBER_NAME.getKey()).toString())
					.roles(roles)
					.managerMenuGroupId((managerMenuGroupId != null) ? managerMenuGroupId.toString() : null)
					.build();
		}

		private static List<String> convertObjectToList(Object obj) {
			List<String> list = new ArrayList<>();
			if (obj.getClass().isArray()) {
				list = Arrays.asList((String[])obj);
			}
			return list;
		}
	}
}