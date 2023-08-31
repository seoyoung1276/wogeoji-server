package com.example.kotlinprojectserver.service;

import com.example.kotlinprojectserver.entity.Member;
import com.example.kotlinprojectserver.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> getMemberById(Long memberId) {
        return memberRepository.findById(memberId);
    }

    public Member createMember(Member member) {
        return memberRepository.save(member);
    }

    public Member updateMember(Long memberId, Member updatedMember) {
        if (memberRepository.existsById(memberId)) {
            updatedMember.setMemberId(memberId);
            return memberRepository.save(updatedMember);
        } else {
            throw new RuntimeException("Member not found with ID: " + memberId);
        }
    }

    public void deleteMember(Long memberId) {
        memberRepository.deleteById(memberId);
    }
}
