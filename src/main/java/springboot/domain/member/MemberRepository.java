package springboot.domain.member;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
    @Query(value = "select * from member m order by m.number_id, m.position_cd, m.member_name", nativeQuery = true)
    List<Member> sortFindAll();
    @Query(value = "SELECT * FROM member m WHERE m.number_id = :number_id", nativeQuery = true)
    List<Member> findByNumberId(long number_id);

    @Query(value = "SELECT * FROM member m WHERE m.number_id = :number_id AND m.position_cd = :position_cd", nativeQuery = true)
    List<Member> findByNumberIdAndPosition(long number_id, int position_cd);

    @Query(value = "SELECT * FROM member WHERE pre_team_id = :pre_team_id", nativeQuery = true)
    List<Member> findByPreTeamId(Long pre_team_id);


}
