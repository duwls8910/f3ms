package springboot.domain.member;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
    @EntityGraph(attributePaths = {"memberIssue"})
    List<Member> findAll();

    @Query(value = "SELECT * FROM member m WHERE m.number_id = :number_id", nativeQuery = true)
    List<Member> findByNumberId(Long number_id);

    @Query(value = "SELECT * FROM member m WHERE m.number_id = :number_id AND m.position_cd = :position_cd", nativeQuery = true)
    List<Member> findByNumberIdAndPosition(Long number_id, int position_cd);
}
