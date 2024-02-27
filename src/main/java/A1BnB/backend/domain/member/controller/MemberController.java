package A1BnB.backend.domain.member.controller;

import A1BnB.backend.domain.member.dto.MemberSignupRequest;
import A1BnB.backend.domain.member.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class MemberController {

    @Autowired
    private final MemberService memberService;

    @PostMapping("")
    public void signUp(@Valid @RequestBody MemberSignupRequest signupParam) {
        // 회원 가입
        memberService.registerUser(signupParam);
    }

}
