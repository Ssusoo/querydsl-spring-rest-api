package me.ssu.querydslspringrestapi.config.sns.application;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "messageSend", url = "${external-api.push}")
public interface PushClient {

}