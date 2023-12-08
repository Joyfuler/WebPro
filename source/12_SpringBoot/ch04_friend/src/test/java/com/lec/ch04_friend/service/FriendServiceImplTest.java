package com.lec.ch04_friend.service;

import com.lec.ch04_friend.domain.Friend;
import com.lec.ch04_friend.repository.FriendRepository;
import com.lec.ch04_friend.repository.FriendRepositoryImpl;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FriendServiceImplTest {
    /*
    private FriendRepository repository = new FriendRepositoryImpl();
    private FriendService friendService = new FriendServiceImpl(repository);*/

    @Autowired
    private FriendRepository repository;
    @Autowired
    private FriendService friendService;

    @AfterEach
    public void afterEach(){
        repository.deleteAll();
    }

    @Test
    void 중복되지않은전화번호친구등록() {
        Friend friend = new Friend("홍길동", "010-9999-9999");
        friendService.join(friend);
        List<Friend> friends = friendService.findFriends();// 전체를 다 받은 후 전화번호가 있는지 본다.
        Friend resultFriend = null;
        for (Friend f : friends){
            if (f.getTel().equals(friend.getTel())){
                resultFriend = f;
                // 입력한 이후, 리스트에서 해당 정보로 등록한 데이터가 있는지를 확인한다.
                // Assertions로 확인하고 문제 없다면 메시지를 출력 후 메소드 종료
            }
        }

        assertThat(friend).isEqualTo(resultFriend);
        System.out.println("중복되지 않은 전화번호 친구 등록 테스트 완료");

    }

    @Test
    void 중복전화번호친구등록(){
        Friend f1 = new Friend("홍길동", "010-9999-9999");
        Friend f2 = new Friend("신길동", "010-9999-9999");
        // f1은 문제없이 insert, f2는 예외가 발생해야 함.
        friendService.join(f1);
        try {
            friendService.join(f2);
        } catch (IllegalStateException e){
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 친구입니다.");
            System.out.println("중복된 전화번호 등록 중복테스트 완료");
            // 중복된 아이디라고 예외가 뿌려진다면 정상적으로 종료된 것. (오류 발생하는 것은
            // 테스트 단계에서 이상해 보일 수 있으므로 정상 종료하도록 처리해야 함.)
        }
    }

   /* @Test
    void findOne() {
        Friend friend = new Friend("ghdrlfehd", "010-9999-9999");
        friendService.join(friend);
        // 입력을 완료했다면 해당 id로 찾아서 문제없이 찾아지는지 확인
        Friend result = friendService.findOne(friend.getId(1)).();
        assertThat(friend.getName()).isEqualTo(result.getName());
        assertThat(friend.getTel()).isEqualTo(result.getTel());
        System.out.println("findOne Test 성공적으로 완료됨");

    }*/

    @Test
    void findFriends() {
    }
}