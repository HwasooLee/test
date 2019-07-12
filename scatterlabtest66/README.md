  * springboot, maven, mybatis, h2데이터베이스 를 이용했습니다.







  * schema.sql에 기초데이터 생성 SQL이 포함되어 있으며, 메모리DB라서 JVM을 재기동하면 데이터가 초기화 됩니다.

  * 데이터 조회방법
   JVM 기동 후 
   http://localhost:8080/h2-console
 
  * 데이터 조회 SQL
    select * from community_base;
    select * from user;

  * community_base 테이블 내에 게시글, 댓글, 대댓글 이 DEPTH 컬럼으로 구분되어있습니다.

  * restlet이나, postman 등 테스트 프로그램을 이용하여 아래 케이스로 테스트
  
	1. 게시글 리스트 조회
	method    : GET 
	url       : http://localhost:8080/community
	parameter : 없음
	
	2.게시글 상세 조회
	method    : GET 
	url       : http://localhost:8080/communityById
	parameter : communityId=1 (게시글 1~5 중 선택)
	
	3.게시글 상세 내 댓글 조회
	method    : GET 
	url       : http://localhost:8080/commentsById
	parameter : communityId=1 (게시글 1~5 중 선택)
	
	4.게시글,댓글 삭제
	method    : DELETE
	url       : http://localhost:8080/community
	parameter : communityId=1 (게시글 1~5, 댓글 6~21, 대댓글 22~25)
	
	5.좋아요 클릭
	method    : PUT
	url       : http://localhost:8080/like
	parameter : communityId=1 (게시글 1~5, 댓글 6~21, 대댓글 22~25)
	
	6.싫어요 클릭
	method    : PUT
	url       : http://localhost:8080/dislike
	parameter : communityId=1 (게시글 1~5, 댓글 6~21, 대댓글 22~25)
	
	7.게시글 등록
	method    : POST
	url       : http://localhost:8080/community
	Body      : {"title":"제목입니다","contents":"내용입니다.","regId":"scatter1"}
	
	8.댓글,대댓글 등록
	method    : POST
	url       : http://localhost:8080/comments
	Body      : {"uprId":1,"contents":"댓글내용입니다.","regId":"scatter1"}

	9.게시글 수정
	method    : PUT
	url       : http://localhost:8080/community
	Body      : {"title":"제목입니다","contents":"내용입니다.","regId":"scatter1"}
	            
