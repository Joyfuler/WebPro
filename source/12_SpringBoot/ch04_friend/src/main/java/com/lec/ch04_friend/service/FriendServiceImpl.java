package com.lec.ch04_friend.service;

import com.lec.ch04_friend.domain.Friend;
import com.lec.ch04_friend.repository.FriendRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Slf4j
public class FriendServiceImpl implements FriendService{

    private FriendRepository repository;
    @Autowired
    public FriendServiceImpl(FriendRepository repository){
        this.repository = repository;
    }
    @Override
    public void join(Friend friend) { // 중복된 전화번호를 먼저 찾고, 중복된 경우 저장X
        validateDuplicateFriendTel(friend);
        // optional 안의 메소드. 만일 result가 null이 아니라면 friend1 함수를 실행.
        // 만일 중복되지 않아서 위 예외에 걸리지 않았다면 아랫줄까지 실행됨.
        repository.save(friend);
    }

    private void validateDuplicateFriendTel(Friend friend){
        // 중복된 전화번호라면 날림
        Optional<Friend> result = repository.findByTel(friend.getTel());
        repository.findByTel(friend.getTel()).ifPresent(friend1 -> {
            throw new IllegalStateException("이미 존재하는 친구입니다.");
        });

    }

    @Override
    public Optional<Friend> findOne(long id) {
        return repository.findById(id);
    }

    @Override
    public List<Friend> findFriends() {
        return repository.findAll();
    }
}
