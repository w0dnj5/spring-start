package hello.hello_spring.controller;

import hello.hello_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private final MemberService memberService;

    // @Autowired private MemberService; 필드 주입

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    /* setter 방식
    @Autowired
    public void setMemberService(MemberService memberService) {
        this.memberService = memberService;
    }
    */
}
