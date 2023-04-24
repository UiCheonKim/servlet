package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
        회원 저장소
        ( Project 가 크면 Repository 라고 별도로 만들겠지만 작아서 그냥 같이 만듦)
 */

/**
 *  동시성 문제가 고려되어 있지 않음, 실무에서는 ConcurrenHashMap, AtomicLong 사용 고려
 */
public class MemberRepository {

    private static Map<Long, Member> store = new HashMap<>(); // 싱글톤이기 때문에 static 없어도 됨
    private static long sequence = 0L;

    // 스프링은 그냥 띄울때만 쓸거기 때문에 싱글톤 방식으로 설정
    private static final MemberRepository instance = new MemberRepository();

    public static MemberRepository getInstance() {
        return instance;
    }

    private MemberRepository(){
    }

    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id) {
        return store.get(id);
    }

    // store 에 있는 값들을 모두 꺼내서 새로운 Array list 에 담아서 넘겨줌
    // Arraylist 를 값을 넣고 빼고 조작해도 store 에 value 를 조작하지 않게 하기 위해
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    // 테스트에서만 사용 store 값 다 날림
    public void clearStore() {
        store.clear();
    }

}
