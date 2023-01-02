package me.ssu.querydslspringrestapi.config.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import me.ssu.querydslspringrestapi.config.constant.CommonConstant;
import me.ssu.querydslspringrestapi.config.constant.JwtPayloadKey;
import me.ssu.querydslspringrestapi.config.util.HttpUtil;
import me.ssu.querydslspringrestapi.config.util.StringUtil;
import me.ssu.querydslspringrestapi.config.util.dto.ApiInfo;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

@Slf4j
public class JwtAuthToken implements AuthToken<Claims> {

	@Getter
	private final String token;
	private final Key key;

	JwtAuthToken(String token, Key key) {
		this.token = token;
		this.key = key;
	}

	JwtAuthToken(TokenPayload dto, Key key) {
		this.key = key;

		Optional<String> value = createJwtAuthToken(dto);
		this.token = value.orElse(null);
	}

	private Optional<String> createJwtAuthToken(TokenPayload dto) {
		var expiredDate = Date.from(LocalDateTime.now()
				.plusMinutes(CommonConstant.Jwt.TOKEN_EXPIRED_MINUTES)
				.atZone(ZoneId.systemDefault()).toInstant());
		var host = "";
		var req = HttpUtil.getHttpServletRequest();
		if (req != null) {
			host = req.getHeader("host");
		}

		// API 메타정보
		String serverInstanceId = null;
		try {
			var apiInfo = ApiInfo.makeResponseApiInfo((ApiInfo) HttpUtil.getRequestAttribute("apiInfo"));
			if (StringUtil.isNotEmpty(apiInfo.getServerInstanceId())) {
				serverInstanceId = apiInfo.getServerInstanceId();
			}
		} catch (Exception e) {
			serverInstanceId = host;
		}

		var claims = Jwts.claims();
		claims.put(JwtPayloadKey.MANAGER_ACCOUNT_SERIAL_NO.getKey(), dto.getManagerAccountSerialNo());
		claims.put(JwtPayloadKey.MEMBER_EMAIL.getKey(), dto.getMemberEmail());
		claims.put(JwtPayloadKey.MEMBER_NAME.getKey(),  URLEncoder.encode(dto.getMemberName(), StandardCharsets.UTF_8));
		claims.put(JwtPayloadKey.ROLES.getKey(), dto.getRoles());
		claims.put(JwtPayloadKey.MANAGER_MENU_GROUP_ID.getKey(), dto.getManagerMenuGroupId());

		return Optional.ofNullable(Jwts.builder()
				.setIssuer(serverInstanceId)
				.setAudience(dto.getMemberEmail())
				.addClaims(claims)
				.setIssuedAt(new Date())
				.setExpiration(expiredDate)
				.signWith(key, SignatureAlgorithm.HS256)
				.compact());
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