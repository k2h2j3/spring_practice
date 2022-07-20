package Club.WelcomeClub.repository;

import Club.WelcomeClub.domain.Member;
import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); //회원 정보 저장
    Optional<Member> findById(Long id); //회원 아이디 조회
    Optional<Member> findByName(String name); //회원 이름 조회
    List<Member> findAll(); //모든 회원 리스트 반환
}
