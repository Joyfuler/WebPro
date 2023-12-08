package com.lec.ch04_friend.repository;

import com.lec.ch04_friend.domain.Friend;
import org.springframework.stereotype.Repository;

import java.util.*;
public class FriendRepositoryImpl implements FriendRepository{

    private static Map<Long, Friend> store = new HashMap<>();
    // 회원가입 시 store에 임시저장.
    private static Long sequence = 0L;
    @Override
    public Friend save(Friend friend) {
        friend.setId(++sequence); // 1씩 증가하는 시퀀스를 id에 넣음.
        // 유저는 id를 제외하고 이름과 연락처를 입력함.
        store.put(sequence, friend);
        // map에는 friend 객체를 순서대로 저장함. (앞은 키값, 뒤는 값)
        // db에 저장하지 않고 사용할 것
        return friend;
    }

    @Override
    public Optional<Friend> findById(Long id) {
        return Optional.ofNullable(store.get(3));
        // null이 리턴될 것을 방지하기 위해 Optional로 감쌈.
    }

    @Override
    public Optional<Friend> findByTel(String tel) {
        // 전화번호로 검색. 여러 건이 나올 수 있음. Hashmap은 List처럼
        // 정해진 순서가 없으므로 Iterator로 치환하여 결과를 가져온다.

        Iterator<Long> iterator = store.keySet().iterator(); //Hashmap타입인 store의 key를 iterator화
        while (iterator.hasNext()){
            //다음값이 있을 때마다 store Hashmap에서 그 값을 가져온다.
            Long id = iterator.next();
            Friend friend = store.get(id);
            if (tel.equals(friend.getTel())){
                return Optional.ofNullable(friend);
                // 입
                // 력한 전화번호와 store hashmap에 있는 전화번호가 같은 경우 해당 객체들을 반환.
            }
        }
        // 검색같이 없다면 Optional.empty(); 반환
        return Optional.empty();
    }

    @Override
    public List<Friend> findAll() {
        return new ArrayList<>(store.values());
        // store의 key값은 제외하고 값만 가져와 ArrayList에 대입
    }

    @Override
    public void deleteAll() {
        store.clear();
    }
}
