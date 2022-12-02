package springboot.domain.member;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
    @Query(value = "select * from member m order by m.number_id, m.position_cd, m.member_name", nativeQuery = true)
    List<Member> sortFindAll();
    @Query(value = "SELECT * FROM member m WHERE m.number_id = :number_id", nativeQuery = true)
    List<Member> findByNumberId(@Param("number_id") long number_id);

    @Query(value = "SELECT * FROM member m WHERE m.number_id = :number_id AND m.position_cd = :position_cd", nativeQuery = true)
    List<Member> findByNumberIdAndPosition(@Param("number_id") long number_id,@Param("position_cd") int position_cd);

    @Query(value = "SELECT * FROM member WHERE pre_team_id = :pre_team_id", nativeQuery = true)
    List<Member> findByPreTeamId(@Param("pre_team_id") Long pre_team_id);


}
