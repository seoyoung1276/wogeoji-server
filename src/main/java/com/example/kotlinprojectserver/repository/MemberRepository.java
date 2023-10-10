package com.example.kotlinprojectserver.repository;

import com.example.kotlinprojectserver.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByMemberIdAndPassword(String memberId, String password);
}
