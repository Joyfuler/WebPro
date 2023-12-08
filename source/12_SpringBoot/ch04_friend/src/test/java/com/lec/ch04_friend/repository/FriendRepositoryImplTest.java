package com.lec.ch04_friend.repository;

import com.lec.ch04_friend.domain.Friend;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
@SpringBootTest
public class FriendRepositoryImplTest {
    @Autowired
    private FriendRepository repository;

    @AfterEach
    public void afterEach(){
        repository.deleteAll();
    }
    // 각 메소드 수행 후마다 데이터를 모두 삭제하여 클래스 전체 테스트시 오류가 나지 않도록 함.
    @Test
    public void save(){
        Friend friend = new Friend("홍길동", "010-9999-9999");
        // Friend friend1 = repository.save(friend); 컨+알+v로 friend friend = 를 자동완성
        repository.save(friend);
        // dao에 이름 홍길동 전화 9999-9999로 들어가도록 테스트
        Friend resultTel = repository.findByTel("010-9999-9999").get();
        // 입력한 더미데이터가 있는지를 아래에서 테스트한다.
        // optional로 설정한 경우에는 friend로 그대로 리턴하려고 할 경우 에러 발생.
        // 뒤에 .get()을 붙여 값을 가져올 수 있게 된다.

        assertThat(friend).isEqualTo(resultTel);
        assertThat(friend.getName()).isEqualTo(resultTel.getName());
        assertThat(friend.getTel()).isEqualTo("010-9999-9999");
        assertThat(friend.getId()).isEqualTo(resultTel.getId());
        // 에러가 있을 시 sysout대신 에러를 출력하는 Assertions를 테스트시 많이 사용함
        System.out.println("save Test 완료");
    }

    @Test
    public void findByTel(){
        Friend friend = new Friend("신길동", "010-8888-7878");
        Friend f = repository.save(friend);
        Friend f2 = repository.findByTel(f.getTel()).get();
        assertThat(f).isEqualTo(f2);
        // 만일 같다면 무사히 아래줄까지 수행.
        System.out.println("findById TEST 완료");
    }

    @Test
    public void findAll(){
        Friend f1 = new Friend("홍길동", "010-9999-9999");
        // 메소드 하나 단위로 테스트이므로 위에서 동일한 값이 있어도 무방.
        Friend f2 = new Friend("신길동", "010-8888-7787");
        repository.save(f1);
        repository.save(f2); // 2개를 입력 완료. 이후 find할 때 2개가 모두 출력되어야 함.
        List<Friend> all = repository.findAll(); //컨트롤 + 알트 + v로 자동완성
        assertThat(all.size()).isEqualTo(2);
        System.out.println("길이측정이상없음");
    }
}
