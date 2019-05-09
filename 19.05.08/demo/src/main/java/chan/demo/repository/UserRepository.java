package chan.demo.repository;

import chan.demo.domain.User;
import org.springframework.data.repository.CrudRepository;

//@Repository
//스프링5는 안붙임
//@Bean은 @컴포넌트, @엔티티, @컨트롤러, @레포지토리를 상징하는 독립적으로 실행가능한 메서드나 클래스
//
public interface UserRepository extends CrudRepository<User, Long> {
}
