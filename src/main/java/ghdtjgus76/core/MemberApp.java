package ghdtjgus76.core;

import ghdtjgus76.core.member.Grade;
import ghdtjgus76.core.member.Member;
import ghdtjgus76.core.member.MemberService;
import ghdtjgus76.core.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
//        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("findMember = " + findMember.getName());
        System.out.println("member = " + member.getName());
    }
}