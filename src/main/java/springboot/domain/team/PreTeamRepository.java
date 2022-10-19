package springboot.domain.team;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PreTeamRepository extends JpaRepository<PreTeam, Long> {


    @Query(value="SELECT * FROM pre_team t WHERE t.number_id = :number_id",nativeQuery=true)
    List<PreTeam> findByNumberId(long number_id);
}
