package hello.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository{ //일단 개발할 수 있게 뼈대만 만듦

    private static Map<Long, Member> store = new HashMap<>(); //동시성 이슈로 인해 ConcurrnetHashMap을 쓰는 것이 좋음
    @Override
    public void save(Member member) {
        store.put(member.getId(), member);

    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
