package hu.inf.unideb.library.repository;

import hu.inf.unideb.library.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MemberRepository extends JpaRepository<Member, String> {

}
