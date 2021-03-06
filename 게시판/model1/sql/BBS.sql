DROP TABLE  BBS
CASCADE CONSTRAINTS;


DROP SEQUENCE SEQ_BBS;


CREATE TABLE BBS(
	SEQ NUMBER(8) PRIMARY KEY,
	ID VARCHAR2(50) NOT NULL,		-- 글의 작성자
	
	REF NUMBER(8) NOT NULL,			-- 그룹번호 (seq과 같이감)		
	STEP NUMBER(8) NOT NULL,        -- 게시판 보는 순서..? (변경됨)
	DEPTH NUMBER(8) NOT NULL,       -- 댓글 depth 카운트 
	
	TITLE VARCHAR2(200) NOT NULL,   -- 제목
	CONTENT VARCHAR2(4000) NOT NULL,-- 내용
	WDATE DATE NOT NULL,            -- 날짜
	
	DEL NUMBER(1) NOT NULL,			-- 삭제 (1이면 숨기기)
	READCOUNT NUMBER(8) NOT NULL    -- 조회수
);


CREATE SEQUENCE SEQ_BBS
START WITH 1
INCREMENT BY 1;


--ID는 Member에서 가져와 쓴다.
ALTER TABLE BBS
ADD CONSTRAINT FK_BBS_ID FOREIGN KEY(ID)
REFERENCES MEMBER(ID);

SELECT * FROM BBS;



--최종 출력 쿼리문
SELECT SEQ, ID, REF, STEP, DEPTH, TITLE, CONTENT, WDATE, DEL, READCOUNT              
FROM(SELECT ROW_NUMBER()OVER(ORDER BY REF DESC, STEP ASC) AS RNUM,
     		SEQ, ID, REF, STEP, DEPTH, TITLE, CONTENT, WDATE, DEL, READCOUNT
	 FROM BBS
	 WHERE TITLE LIKE % + search + %
	 ORDER BY REF DESC, STEP ASC)
WHERE RNUM >= 11 AND RNUM <= 20
