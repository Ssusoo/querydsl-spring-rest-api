package me.ssu.querydslspringrestapi.domains.member.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.ssu.querydslspringrestapi.base.controller.BaseController;
import me.ssu.querydslspringrestapi.config.util.dto.ApiResponse;
import me.ssu.querydslspringrestapi.domains.member.application.MemberSignUpService;
import me.ssu.querydslspringrestapi.domains.member.dto.MemberSignUp;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@Tag(name = "회원가입")
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/member")
public class MemberController extends BaseController {

	private final MemberSignUpService memberSignUpService;

	@Operation(summary = "회원가입")
	@PostMapping("/sign-up")
	public ApiResponse<Object> createMember(@Valid @RequestBody MemberSignUp.Request request) {
		memberSignUpService.processNewMember(request);
		return responseJson();
	}
}