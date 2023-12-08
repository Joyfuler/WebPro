package com.lec.ch04_friend.repository;

import com.lec.ch04_friend.domain.Friend;

import java.util.List;
import java.util.Optional;


public interface FriendRepository {
    public Friend save(Friend friend);
    public Optional<Friend> findById(Long id);
    // null을 리턴하는 경우 예외가 발생하도록 함. (Optional은 자바 11부터)
    public Optional<Friend> findByTel(String tel);
    public List<Friend> findAll();
    public void deleteAll(); // test 로직에서 필요
}
