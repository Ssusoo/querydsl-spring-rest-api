package me.ssu.querydslspringrestapi.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * KISA SEED 암호화 알고리즘
 */
@Component
@ConfigurationProperties(prefix = "env")
@Setter
@Getter
public class EnvProperties {
	private String serverInstanceId;
	private byte[] kisaSeedCbcSecretKey;
	private byte[] kisaSeedCbcIv;
}
