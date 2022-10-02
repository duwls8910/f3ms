package springboot.domain.team;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {


    @Query(value="select * from team join number on team.number_id = number.number_id",nativeQuery=true)
    List<Team> findByNumber_id(int number_id);
}
