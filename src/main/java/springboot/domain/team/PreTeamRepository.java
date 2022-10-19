package springboot.domain.team;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PreTeamRepository extends JpaRepository<PreTeam, Long> {


    @Query(value="select * from team join number on team.number_id = number.id",nativeQuery=true)
    List<PreTeam> findByNumber_id(long number_id);
}
