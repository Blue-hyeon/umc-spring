package umc.blue.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.blue.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
