 -- 1) Drop Table & Sequence

DROP SEQUENCE BOARD_COMMENT_SEQ;
DROP TABLE BOARD_COMMENT;
DROP SEQUENCE BOARD_SEQ;
DROP TABLE BOARD;
DROP SEQUENCE BOARD_SEQ;
DROP TABLE FAVORITE;
DROP SEQUENCE FAVORITE_SEQ;
DROP TABLE REVIEW;
DROP SEQUENCE REVIEW_SEQ;
DROP TABLE GAME;
DROP TABLE MEMBER;

 -- 2 ) Table Creating
 
 CREATE TABLE MEMBER(
    MID VARCHAR2 (30) PRIMARY KEY,
    MNICKNAME VARCHAR2 (30) NOT NULL, 
    MPW VARCHAR2 (30) NOT NULL,
    MEMAIL VARCHAR2 (50) NOT NULL UNIQUE,
    MPHONE VARCHAR2 (20) NOT NULL,
    MPHOTO VARCHAR2 (60),
    MQUEST NUMBER(1),
    MANSWER VARCHAR2 (60),
    MLEVEL NUMBER(1) DEFAULT 0    
 );
  
 CREATE TABLE GAME(
    GID VARCHAR2 (60) PRIMARY KEY,
    GNAME VARCHAR2 (120) NOT NULL,
    GGENRE VARCHAR2 (60),
    GPUB VARCHAR2 (60) NOT NULL,
    GPDATE DATE,
    GICON VARCHAR2 (60),
    GDESC CLOB,
    GHIT NUMBER(1) DEFAULT 0 NOT NULL    
 );
 CREATE SEQUENCE BOARD_SEQ START WITH 1 INCREMENT BY 1 MAXVALUE 99999 NOCACHE NOCYCLE;
 CREATE TABLE BOARD(
     BNO NUMBER(8) PRIMARY KEY,
     BTITLE VARCHAR2 (120) NOT NULL,
     BCONTENT CLOB,
     BRDATE DATE DEFAULT SYSDATE,
     BIMG VARCHAR2 (120),
     BGROUP NUMBER(8) NOT NULL,
     BSTEP NUMBER(2) NOT NULL,
     BINDENT NUMBER(2) NOT NULL,
     GID VARCHAR2 (60),
     MID VARCHAR2 (36),
     FOREIGN KEY (GID) REFERENCES GAME(GID),
     FOREIGN KEY (MID) REFERENCES MEMBER(MID)
 );

SELECT * FROM BOARD;

CREATE SEQUENCE BOARD_COMMENT_SEQ START WITH 1 INCREMENT BY 1 MAXVALUE 99999 NOCACHE NOCYCLE;
CREATE TABLE BOARD_COMMENT (
    BCNO NUMBER(8) NOT NULL,
    BCTEXT VARCHAR2 (4000) NOT NULL,
    BCGROUP NUMBER(8) NOT NULL,
    BCSTEP NUMBER(2) NOT NULL,
    BCINDENT NUMBER(2) NOT NULL,
    BNO NUMBER(8),
    MID VARCHAR2 (30),
    FOREIGN KEY (BNO) REFERENCES BOARD(BNO),
    FOREIGN KEY (MID) REFERENCES MEMBER(MID)
);


SELECT * FROM BOARD_COMMENT;

CREATE SEQUENCE FAVORITE_SEQ START WITH 1 INCREMENT BY 1 MAXVALUE 99999 NOCACHE NOCYCLE;
CREATE TABLE FAVORITE (
    FID NUMBER(5) PRIMARY KEY,
    FRDATE DATE DEFAULT SYSDATE,
    GID VARCHAR2 (60) NOT NULL,
    MID VARCHAR2 (30) NOT NULL,
    FOREIGN KEY (GID) REFERENCES GAME(GID),
    FOREIGN KEY (MID) REFERENCES MEMBER(MID)
);
    
SELECT * FROM FAVORITE;    

DROP SEQUENCE REVIEW_SEQ;
CREATE SEQUENCE REVIEW_SEQ START WITH 1 INCREMENT BY 1 MAXVALUE 99999 NOCACHE NOCYCLE;
CREATE TABLE REVIEW (
    RID NUMBER(5) PRIMARY KEY,
    RSCORE NUMBER(1) NOT NULL,
    RTEXT CLOB NOT NULL,
    MID VARCHAR2 (30) NOT NULL,
    GID VARCHAR2 (60) NOT NULL,
    FOREIGN KEY (MID) REFERENCES MEMBER(MID),
    FOREIGN KEY (GID) REFERENCES GAME(GID)
);

SELECT * FROM REVIEW;
alter table game add ggenre varchar(60);
-- 3) Dummy Data
INSERT INTO MEMBER (MID, MNICKNAME, MPW, MEMAIL, MPHONE, MPHOTO, MQUEST, MANSWER)
    VALUES ('aaa', 'ㄹㅇ인가', '111', 'aa@bb.com', '010-1111-2222', 'unnamed.png', '1', '몰라');
INSERT INTO MEMBER (MID, MNICKNAME, MPW, MEMAIL, MPHONE, MPHOTO, MQUEST, MANSWER)
    VALUES ('bbb', 'ㅋㅋㄹㅇ', '222', 'bb@cc.co.kr', '010-1122-2323', 'unnamed.png', '2', '몰라');
INSERT INTO MEMBER (MID, MNICKNAME, MPW, MEMAIL, MPHONE, MPHOTO, MQUEST, MANSWER)
    VALUES ('ccc', '우왕굿', '444', 'cc@cc.co.kr', '010-1122-2323', 'unnamed.png', '2', '몰라');    
INSERT INTO MEMBER (MID, MNICKNAME, MPW, MEMAIL, MPHONE, MPHOTO, MQUEST, MANSWER)
    VALUES ('ddd', '전원처치다', '444', 'dd@ee.com', '010-2525-6666', 'unnamed.png', '3', '몰라');        
INSERT INTO MEMBER (MID, MNICKNAME, MPW, MEMAIL, MPHONE, MPHOTO, MQUEST, MANSWER)
    VALUES ('eee', '우하하우리배꼽', '555', 'dd@ff.com', '010-2626-7686', 'unnamed.png', '1', '아마');            
INSERT INTO MEMBER (MID, MNICKNAME, MPW, MEMAIL, MPHONE, MPHOTO, MQUEST, MANSWER)
    VALUES ('fff', '중국다롄', '666', 'sorim@chuk.gu', '010-2525-6266', 'unnamed.png', '1', '글쎄');            
INSERT INTO MEMBER (MID, MNICKNAME, MPW, MEMAIL, MPHONE, MPHOTO, MQUEST, MANSWER)
    VALUES ('ggg', '깡패축구', '2626', '33@bb.com', '010-1111-2979', 'unnamed.png', '1', '뭐지');                
INSERT INTO MEMBER (MID, MNICKNAME, MPW, MEMAIL, MPHONE, MPHOTO, MQUEST, MANSWER)
    VALUES ('hhh', '수석보좌관', '252532', '44@cc.com', '010-2521-5252', 'unnamed.png', '1', '뭐더라');                
INSERT INTO MEMBER (MID, MNICKNAME, MPW, MEMAIL, MPHONE, MPHOTO, MQUEST, MANSWER)
    VALUES ('iii', '동네축구', '5521515A2', '33@aa.ca', '010-5325-2522', 'unnamed.png', '2', '엥');                
INSERT INTO MEMBER (MID, MNICKNAME, MPW, MEMAIL, MPHONE, MPHOTO, MQUEST, MANSWER)
    VALUES ('jjj', '우즈벡헤딩슛', '111', '44@naver.com', '010-1131-2424', 'unnamed.png', '3', '뭐라고');                
SELECT * FROM MEMBER;
---
SELECT * FROM GAME;
INSERT INTO GAME (GID, GNAME, GPUB, GPDATE, GICON, GDESC)
    VALUES ('fo4m', 'EA SPORTS FC Online M', 'NEXON Company', TO_DATE('2018-08-01','YYYY-MM-DD'), 'thum2.jpg', '새로운 Look&Feel로 더욱 세련되게!
게임 플레이 템포와 체감 개선을 통해 더욱 현실감 있게!
파워슛, 하드태클, 녹온 드리블로 더욱 다양하게!
모든 것이 새로워진 FC 모바일에서, 나만의 팀을 완성하세요!!');

INSERT INTO GAME (GID, GNAME, GPUB, GPDATE, GICON, GDESC)
    VALUES ('wos','WOS:화이트 아웃 서바이벌', 'Century Games Pte.Ltd.','2023-09-15','thum3.jpg','화이트 아웃 서바이벌은 빙하 종말 서바이벌 전략 게임입니다. 매혹적인 기계와 복잡한 사안들이 여러분을 기다리고 있습니다.

급격하게 하락한 지구의 기온으로 인간 사회에 대혼란이 일어났습니다. 무너져가는 집에서 탈출한 사람들은 이제 혹독한 눈보라, 공격적인 짐승들, 그들의 절망을 먹이로 삼는 기회주의적인 악당들과 같은 새로운 난관에 부딪히게 되었습니다.');

INSERT INTO GAME (GID, GNAME, GPUB, GPDATE, GICON, GDESC)
    VALUES ('leneagem','리니지M','NCSOFT','2019-09-24','thum7.jpg','■ MMORPG의 시작과 끝, 리니지M
PC의 향수와 그 이상의 혁신으로,
언제 어디서나 위대한 서사의 주인공이 되십시오.

■ 변하지 않는 가치
다양한 재미를 선사할 클래스
오픈 필드에서 벌어지는 적과의 조우
대규모 전장의 치열한 전투
이 모든 추억을 함께 할 혈맹까지
시간이 지나도 변하지 않는 가치를 경험하세요.

■ 보다 강력해진 대규모 전투의 재미
광활한 필드 내 모든 곳이 전투의 접점
테베라스부터 에스카로스까지, 요일별로 쉴 틈 없이 펼쳐지는 월드 던전
지배의 탑 등 전 월드 최상위 연합들의 강함을 증명할 마스터 던전

■ 조작
자유롭고 간편한 아크 셀렉터부터 무접속 플레이까지, 끊임없는 기술의 혁신

■ 모바일 UI
최소의 조작으로 최대의 효과를 발휘하는 모바일 전투 UI');

INSERT INTO GAME (GID, GNAME, GPUB, GPDATE, GICON, GDESC)
    VALUES ('skiagb','세븐나이츠 키우기','Netmarble','2023-09-01','thum1.jpg','▶방치만으로도 성장하는 나만의 세븐나이츠
전투도 성장도 쉽고 빠르게!
자동 사냥으로 손쉬운 전투, 접속하지 않아도 경험치와 골드를 획득할 수 있어요.

▶나만의 영웅을 수집해 보세요.
매력 만점 귀여운 세븐나이츠의 등장
개성 넘치는 영웅들로 나만의 팀을 구성해 보세요.

▶10 vs 10 전략적 전투!
최대 10명의 캐릭터들이 펼치는 시원시원한 전투
필드, 던전, 결투장에서 나만의 매력적인 영웅들을 뽐내보세요.

▶펫, 코스튬으로 더욱 화려하게!
귀여운 펫과 개성만점 코스튬으로 나만의 영웅을 만들어보세요.

▶풍성한 접속 이벤트! 루비가 쏟아진다!
폭풍 성장 지원!
매일매일 쏟아지는 풍성한 접속 보상으로, 빠르게 영웅들을 성장 시켜보세요.');

INSERT INTO GAME (GID, GNAME, GPUB, GPDATE, GICON, GDESC)
    VALUES ('cod', '콜 오브 드래곤즈', 'FARLIGHT', '2023-09-15','thum11.jpg','■ 베헤모스
최대 40인의 레이드로 진행되는 베헤모스 포획!
모든 사람들이 선망하고, 또 두려워하는 베헤모스를 사로잡아 연맹의 비밀병기로 활용하세요!
호기롭게 진군 중인 적군 모두를 움직일 수도 없는 두려움 속으로 밀어 넣고, 전쟁의 판도를 당신의 손아귀 안에 담을 수 있는 수는 베헤모스 뿐입니다!
히드라, 자이언트, 자이언트 베어, 그리고 플레임 드래곤까지! 단 하나의 수만으로 전세를 뒤집어보세요!

■ 무료치료
가슴 아프지만 전쟁에는 반드시 부상자가 발생하기 마련입니다.
그들의 가족을 위해서라도, 사상자를 최소화하고 일상으로 복귀시키는 건 지휘자의 중요한 책무 중 한가지입니다.
하지만 치료 인원에 제한이 있고, 수많은 재화가 필요한 것만큼 통솔자로서 한탄스러운 일이 없죠.
그래서 [ 콜 오브 드래곤즈 ]에서는 부상자의 치료에 지원을 아끼지 않기로 했습니다!
마음껏 전쟁하고, 마음 편히 복귀하십시오! 인원 제한이 없고, 재화가 필요하지 않은 치료소가 전쟁 영웅들을 환대할 것입니다!

■ 아티팩트
영웅들에게는 그들에게 어울리는 신화적인 장비를 부여하는 게 정석입니다.
하지만 신화적인 장비라고 그들의 능력치만 올려준다면, ” 신화적인 “ 장비라 할 수 있을까요? “ 진짜 “ 신화적인 장비라면, 응당 그에 맞는 스킬이 있어야 할 것입니다.
“ 은신 ” , ” 텔레포트 ” , ” 단체 버프 ” 등등 전장의 판도를 바꿀 수 있는 다양한 아티팩트 스킬!
영웅에게 어울리는 장비를 부여하고, 시너지를 발생시킬 수 있는 액티브 스킬을 활용하세요!
당신만의 전략과 함께 전세를 뒤집을 히든 카드로 작용하기에 부족함이 없을 것입니다!');

INSERT INTO GAME (GID, GNAME, GPUB, GPDATE, GICON, GDESC)
    VALUES ('nightcrows', '나이트 크로우', 'Wemade Co., Ltd', '2023-10-03','thum5.jpg','https://nightcrows.co.kr/

◈게임 소개◈

마법이 공존하는 13세기를 배경으로 새롭게 창조된 유럽 대륙,
“Deus vult”, 신의 이름으로 시작되는 그 거대한 전쟁의 역사로 초대합니다.

▣”Creatio Mundi” (Creation of the world)▣
마법이 공존하는 13세기 유럽. 판타지와 현실이 함께하는 새로운 세상을 창조하였습니다.
낮과 밤, 밝음과 어둠, 질서와 혼돈, 권력과 반란까지, 모든 것들이 충돌하는 중세 유럽.
언리얼 엔진 5로 그려낸 가장 현실적인 역사 속 유럽 대륙을 경험할 수 있습니다.

▣”Modus Vivendi” (Way of life)▣
RPG에서의 캐릭터는 또 다른 “나”입니다.
이제 운과 우연에 의지하지 않고, 나의 시간, 노력, 그리고 선택에 따른 승급과 전직을 통해 나의 캐릭터는 성장하며, 나이트 크로우 단원으로서 주어진 역할을 수행해 나갑니다. 이것이 바로 나이트 크로우가 추구하는 RPG 본연의 성장이자 삶의 방식입니다.

▣”Alta Volare” (Fly high)▣
이제 땅과 하늘, 그 사이 모든 공간이 전장이 됩니다.
나이트 크로우의 이야기 속 유럽 대륙에서는 "글라이더"를 통해 드디어 하늘을 품게 되었습니다. 글라이더는 고저차를 이용한 단순한 활강에 그치지 않고, 활공과 호버링 그리고 상승 기류를 이용한 다양한 전략적인 전투까지 가능하게 하며, 평면적인 전투에서 벗어난 입체적인 전투의 경험을 선사합니다.');

INSERT INTO GAME (GID, GNAME, GPUB, GPDATE, GICON, GDESC, GHIT)
    VALUES ('odin', '오딘: 발할라 라이징', 'Kakao Games Corp.', '2021-06-26', 'thum6.jpg', '▣게임 소개▣
■ MMORPG, 신의 영역에 도전하다
모션 캡처, 3D캡처 등을 통한 실사 그래픽 구현
언리얼 엔진4로 보다 완벽하게, 보다 아름답게!
심리스 방식으로 로딩없이 자유로운 오픈 필드

■ 신의 영역을 향한 모험의 시작
방대한 스케일에 디테일을 더한 북유럽 신화 세계관
미드가르드, 요툰하임 등 신화 속 4개 대륙에서의 모험!
거인, 난쟁이, 알브, 인간 등 다양한 종족의 등장

■ 내 방식대로 신의 영역을 탐험하다
벽타기, 수영 등 지형지물을 이용하는 전략적 플레이
명확한 역할 구분으로 나에게 맞는 클래스를 찾다!
연계 스킬, 조건부 스킬로 나만의 전투 스타일 완성

■ 전사여, 신의 영역을 차지하라
북유럽 신화 속 신과 괴수에 맞서다!
압도적인 스케일의 보스 레이드
발할라를 차지하기 위한 대규모 RvR', 1);

INSERT INTO GAME (GID, GNAME, GPUB, GPDATE, GICON, GDESC, GHIT)
    VALUES ('pubg','배틀그라운드','KRAFTON, Inc.', '2018-05-15', 'thum16.jpg', '▶배틀그라운드 (PUBG) 모바일 게임 소개◀
배그 모바일 게임은 다수의 유저들이 배틀로얄 전장에서 총기 및 각종 전투 아이템을 활용하여 각자의 전략으로 최후의 승자를 가려내는 서바이벌 형식의 fps 배틀로얄 모바일 게임입니다.

배틀그라운드 (PUBG) 모바일 게임의 리얼한 서바이벌 배틀로얄 전장
배그 모바일 게임은 언리얼 엔진 4를 기반으로 한 HD 그래픽과 3D 사운드로 리얼한 전장을 구현했습니다.
실존하는 다양한 서바이벌 무기와 전투 장비들, 실제 총기 사운드 등을 통해 모배는 생생한 fps 배틀로얄 전투 체험감을 선사합니다.',1);

INSERT INTO GAME (GID, GNAME, GPUB, GPDATE, GICON, GDESC, GHIT)
    VALUES ('redline', '항로: 레드라인', 'WORCESTER FESTIVAL LTD', '2023-10-14', 'thum_line.png','불타는 궁극기, 자유로운 대결! 시원하고 짜릿한 전투를 지금 바로 체험해보세요!


클래식 재현: 인기 IP 캐릭터 대집합, 당신만의 팀을 구성하고 좋아하는 캐릭터와 함께 바다 모험을 떠나세요!


개성있는 콘텐츠: 임펠 다운, 바다 시련부터 정상전쟁까 원하는 콘텐츠가 다 있습니다. 빨리 와서 당신만의 심해 보물을 받아가세요!


가벼운 플레이: 자동 전투만으로도 레벨업할 수 있습니다. 여러가지 자동 시스템이 들어있으니 지금부터 스테이지와 레벨에 대한 적정을 버리고 카드 게임의 매력을 맘껏 즐기세요!


전략적 배치: 능력치 상성, 스킬 상성과 아티팩트 콘텐츠가 어우러져 좋아하는 캐릭터가 누구인 상관없이 조합만 잘하면 다 이길 수 있습니다!',1);

INSERT INTO GAME (GID, GNAME, GPUB, GPDATE, GICON, GDESC, GHIT)
    VALUES ('teamfighttactics','전략적 팀 전투: 리그 오브 레전드 전략 게임', 'Riot Games,Inc','2023-03-17', 'thum_league.png','리그 오브 레전드를 만든 라이엇 게임즈가 선보이는 전략적 팀 전투는 팀 구성 능력을 시험하는 궁극의 멀티플레이어 PvP 오토 배틀러입니다.

8인 난투전에서 챔피언을 모집하고 배치하며 전투를 벌이고 기발한 전략을 펼쳐서 승리를 향해 나아가세요. 팀 조합이 수백 가지에 달하고 메타가 끊임없이 진화하니 가능한 전략은 무궁무진하지만, 단 한 명만 승리를 거머쥘 수 있습니다.

굉장한 자동 전투가 펼쳐지는 결투장에서 턴제 전략의 대가가 되어보세요. 체스 같은 게임플레이와 상호작용, 경쟁을 선사하는 다양한 멀티플레이어 게임 모드에서 적을 뛰어넘는 전략으로 끝까지 살아남아 최후의 승자가 되세요!

재창조된 룬테라
폭풍이 룬테라의 여러 지역을 조각내고 합쳐 기이한 신세계를 창조하며 광장을 혼돈에 빠뜨렸습니다.
신규 전략가들을 선두에 세우고 좋아하는 룬테라 챔피언을 승리로 이끌어 보세요. 미니 티모와 한 무리의 칼날부리 그리고 다양한 외형의 포로가 등장합니다!
자신의 플레이스타일을 뒷받침할 수 있도록 증강에 영향을 주는 전설의 위력을 불러내보세요.

익숙한 친구들과 새로운 전투를
공동으로 이루어지는 멀티플레이어 챔피언 선택을 통해 막강한 팀을 구성하세요.
라운드마다 전투를 벌이며 마지막까지 살아남아야 합니다.
무작위로 등장하는 챔피언과 게임 내 이벤트의 영향으로 게임 양상이 매번 달라지니 창의력과 기지를 발휘해 필승 전략을 구상해보세요.

장소 불문 플레이 가능
PC와 Mac, 모바일에 걸쳐 펼쳐지는 턴제 전투에서 친구에게 도전하고 적을 쓰러뜨릴 수 있습니다.
친구와 함께 플레이하며 누가 최후의 승자가 될 자질을 가졌는지 확인해보세요.',1);

INSERT INTO GAME (GID, GNAME, GPUB, GPDATE, GICON, GDESC, GHIT)
    VALUES ('royalmatch', '로얄 매치 Royal Match', 'Dream Games, Ltd.','2021-02-24','thum13.jpg','지금 새로운 모험을 시작하세요! 색깔별로 블럭을 밀고, 퍼즐을 풀고, 성을 꾸미고, 동전도 모으세요. 로얄 캐슬에는 승부욕을 자극하는 재미있는 매치 3 퍼즐이 가득하답니다! 색깔 블럭을 3개 이상 맞춰서 게임판을 비우고 퍼즐을 해결해보세요! 짜릿한 재미로 가득한 로얄 매치를 지금 바로 무료로 즐겨보세요!

로얄 매치의 로버트 왕이 왕궁을 아름답게 꾸미는 데 여러분의 도움이 필요하대요. 레벨 완료 후 다음 에피소드로 넘어가기 전에 왕궁을 먼저 방문해보세요! 왕궁의 공간을 하나씩 다 꾸밀 때마다 동전을 받아요. 왕의 거처를 멋지게 꾸미고 보너스와 추가 부스터를 받아서 모험을 이어가세요!

게임 속에 두뇌를 자극하는 퍼즐이 가득하거든요! 새로운 에피소드마다 무료 동전, 특별한 보상, 놀라운 퀘스트, 아름다운 장소들과 더불어 끝내주는 매치를 즐길 수 있답니다!

끝내주는 그래픽과 신나는 퍼즐로 가득한, 최고의 매치 3 게임 로얄 매치를 지금 플레이 해보세요.',1);

INSERT INTO GAME (GID, GNAME, GPUB, GPDATE, GICON, GDESC, GHIT)
  VALUES ('genshin', '원신', 'MIHOYO', '2020-09-25', 'thum9.jpg', '〓자유도 높은 오픈월드 시스템〓
《원신》은 오픈월드 어드벤처 게임으로, 여행자님은 「티바트」 대륙에 들어온 순간부터 산을 넘고, 강을 건너며 새로운 세계로의 모험을 떠날 수 있습니다. 공중에 떠다니는 선령들과 기이한 장치들을 발견하게 되면, 어떤 놀라운 일이 발생할지 기대해보세요!

〓원소 상호작용을 통한 전략적인 전투〓
원소가 살아 숨 쉬는 티바트 세계에는 바람, 번개, 물, 불, 얼음, 풀, 바위 7개 원소가 존재합니다! 「신의 눈」을 가진 캐릭터는 원소의 힘을 사용해 전투와 탐험을 수행할 수 있습니다. 물과 불이 만나면 「증발」하고 불과 번개는 「과부하」를 일으키며, 번개와 물이 만나면 「감전」이 발생합니다. 상대에 맞게 적절한 원소 효과를 사용하는 것이 바로 승리의 열쇠입니다!

〓고퀄리티 그래픽과 OST〓
《원신》은 카툰렌더링 기술을 활용한 고퀄리티 그래픽으로 제작되었습니다. 캐릭터들의 실시간 동작들을 세밀하게 조정해 높은 퀄리티의 연출 효과를 표현했습니다. 24시간에 따라 밤낮이 바뀌고, 날씨와 OST도 환경에 맞게 변화합니다. 또한, 여행자 여러분들은 티바트 세계 어디에 있든, 세계 정상급 교향악단인 런던필하모니 오케스트라와 상하이 교향악단이 선보이는 지역 특색 가득한 연주도 들을 수 있습니다!

〓각양각색의 동료들과 함께하는 모험〓
여러분은 여행 중 독특한 능력을 지닌 동료들을 만날 수 있습니다. 최고의 파티를 조합하고, 여행 중 수집한 재료로 캐릭터를 강화하여 티바트 대륙의 몬스터와 비경을 정복해 보세요! 높은 산 정상에 서면 비와 눈, 그리고 아름다운 구름이 눈앞에 펼쳐집니다. 그러나 아직 잃어버린 혈육과의 재회와 「원신」의 진실을 밝혀내지 못했습니다……. 여행자, 진정한 모험은 이제 시작됐습니다!',1);

INSERT INTO GAME (GID, GNAME, GPUB, GPDATE, GICON, GDESC, GHIT, GGENRE)
VALUES ('gardenscapes', '꿈의 정원(Gardenscapes)', 'PlayRix', '2016-08-25', 'thum_garden.png', 'Playrix 꿈 시리즈(Scapes™ 시리즈)의 첫 히트작, 꿈의 정원에 오신 것을 환영합니다. 3조각 맞추기 퍼즐을 풀어 정원의 영광을 되찾아주세요!

3조각 맞추기 레벨을 깨며 정원의 여러 구역을 복원 또는 장식하고, 그에 얽힌 비밀을 파헤치며 여러분의 집사 오스틴을 비롯한 게임 캐릭터들을 만나 보세요! 지금 바로 꿈의 정원을 만들어요!

게임 특징:
* 독창적인 게임 플레이: 한 게임에서 조각 맞추기와 정원 복원하기, 꾸미기, 그리고 참신한 이야기를 모두 즐길 수 있습니다.
* 수천 개의 독창적인 3조각 맞추기 레벨
* 친근한 게임 캐릭터
* 언제나 기분을 북돋아주는 사랑스러운 동물
* 최신 소식을 접할 수 있는 게임 내 소셜 네트워크
* 독특한 구조로 만들어진 정원의 여러 구역: 부서진 분수대와 미스터리 미로 등
* 커뮤니티: Facebook 친구들과 이웃이 되세요!',1,'시뮬레이션');

INSERT INTO GAME (GID, GNAME, GPUB, GPDATE, GICON, GDESC, GHIT, GGENRE)
VALUES ('uparu', '우파루 오딧세이', 'NHN Corp.', '2023-10-04', 'thum_uparu.png', '▦ 강력 추천! 우파루 오딧세이 특징 ▦
1. 수백 가지 종류의 매력적인 우파루 총집합!
신비의 생명체 우파루를 모으고, 키우는 컬렉션 SNG!
상상을 뛰어넘는 다양한 조합으로 귀염뽀짝한 우파루를 소환하세요.
키우는 재미가 가득한 우파루를 수집하여 개성 넘치는 컬렉션을 완성해보세요.

2. 우파루들의 일상을 만나는 힐링타임 ♥
유니크한 서식지와 다양한 장식들로 꾸민 나만의 마을에서
우파루들의 이야기에 귀 기울여 보세요.

3. 먹이와 물약으로 반전 매력 성장 ♬
특색 있는 변신에 비밀 능력까지! 
우파루의 반전 매력에 빠져 보세요.

4. 세상을 구원할 우파루의 전투!
다양한 속성 조합으로 덱을 구성하여 전략적인 전투를 즐겨보세요.',1,'시뮬레이션');

INSERT INTO GAME (GID, GNAME, GPUB, GPDATE, GICON, GDESC, GHIT, GGENRE)
VALUES ('hkstarrail', '붕괴:스타레일', '호요버스', '2023-04-26', 'thum_hkstarrail.jpg', '[붕괴: 스타레일]은 HoYoverse 신작 은하 판타지 RPG 게임입니다
「은하열차」를 타고 은하계의 신비롭고 환상적인 풍경을 경험하며, 모험과 짜릿함이 가득한 여정의 선율을 즐겨보세요.
플레이어는 여러 세계에서 새로운 친구를 만나고 반가운 친구와 재회하며 함께 「스텔라론」으로 인한 분쟁을 해결하고 비밀을 파헤치게 됩니다. 여정의 끝이 뭇별에 닿길!

□ 다양한 세계에서 즐기는 탐험 - 자유 탐사, 인터랙티브 수수께끼
3, 2, 1 워프 개시! 기물이 봉인된 우주정거장, 얼음으로 뒤덮인 기이한 행성, 흉물을 수렵하는 거대 함대... 열차가 정차하는 역마다 새로운 은하 세계가 펼쳐집니다! 기묘하고 환상적인 문명과 세계를 자유롭게 탐색하고 수상한 배후에 숨겨진 수수께끼를 풀어보세요!

□ 보는 재미와 듣는 즐거움 - 영화같이 몰입감 넘치는 체험
실시간 렌더링으로 고퀄리티 스토리 표현, 신규 개발 캐릭터 표정 시스템으로 실감 나는 감정 묘사, 자체 사운드 제작팀 HOYO-MiX의 전력을 다한 BGM, 당신의, 당신에 의한, 당신을 위한 은하 판타지, 지금 바로 여정에 올라 갈등과 협력 사이에서 자신의 의지로 선택하고 이야기의 결말에 도달하세요!

□ 개성 넘치는 캐릭터 - 함께 만나 떠나는 개척 여정
별바다에는 끝없는 모험과 만남이 있습니다. 동료들을 위한 티켓을 준비해 이 놀라운 여정에 몸을 실으세요! 기억을 잃은 영민한 소녀, 고결하고 정직한 실버메인 철위대, 다소 나태해 보이는 운기 장군, 베일에 싸인 제복 미녀까지... 함께 「스텔라론」의 위기에 맞서고 웃음과 눈물이 한데 모인 현재, 과거, 미래를 만드세요.',1,'턴제RPG');

select * from game;