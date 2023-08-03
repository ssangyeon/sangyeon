# sangyeon

스프링부트+mysql+jpa를 이용하여 crud(생성, 읽기, 갱신, 삭제)기능을 연습
mysql을 처음써봄. mysqlworkbench, dbeaver을 설치해 보았다.

엔티티를 만들때 @Builder사용- 빌더 패턴을 생성자 파라미터가 많을 경우 가독성이 좋지 않으므로 사용함.

DTO를 만들때 @NoArgsConstructor, @AllArgsConstructor
dto(data transfer object)-데이터 전송을 위해 도메인 모델대신 사용되는 객체
@NoArgsConstructor- 파라미터가 없는 기본 생성자를 생성
@AllArgsConstructor- 모든 필드 값을 파라미터로 받는 생성자를 생성

controller 만들때 
@Slf4j(simple loggin facade for java)- java.util.logging등과같은 다양한 프레임 워크에 대한 추상화역할(즉 log쓸때 사용하는듯)
@RestController-@controller+@responsebody의 조합이라고함(모든 핸들러 메소드에서 @responsebody를 사용할 필요 없음)
@RequiredArgsConstructor- final이나 @NonNull인 필드 값만 파라미터로 받는 생성자를 생성
log.info
json형식- (java script object notation) key-value한쌍으로 이루어진 데이터 오브젝트를 전달하기위해 사용함. 인터넷에서 자료주고받을때 자료표현방법임
ResponseEntity-상태코드(httpstatus.ok)반환값으로 사용되는듯
@RequestBody- json객체로 넘어오는 것을 받아서 자바객체로 변환.
@ResponseBody- 자바객체를 http요청의 바디내용으로 매핑하여 클라이언트로 전송.
ResponseEntity.status(상태코드).body(객체)-status와 body를 이용하여 상태코드와 json으로 변환할 객체를 지정
@PathVariable-@GetMapping의 {}안에 들어올 파라미터명

다음 프로젝트에서는 게시판을 만들어보면서 타임리프를통해 프론트부분까지 구현해보는것을 목표로 진행해봐야지

