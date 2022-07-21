package Club.WelcomeClub.repository;

import Club.WelcomeClub.domain.Member;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@ResponseBody
public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L; //키 값을 생성해주는 역할

    @Override
    public Member save(Member member) {
        member.setId(++sequence); //ID 셋팅
        store.put(member.getId(), member); //store에 저장
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name)) //필터로 루프를 돌려서
                .findAny(); //하나라도 찾으면 그것을 반환, 없다면? null을 반환
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
