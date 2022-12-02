package springboot.domain.number;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import springboot.domain.member.Member;

import java.util.List;

public interface NumberRepository extends JpaRepository<Number, Long> {
    //쿼리날리는곳
    @Query(value = "select * from number where number.number_name = :number_name", nativeQuery = true)
    Number findByNumber_name(@Param("number_name") int number_name);
    @Query(value = "SELECT * FROM number WHERE id = :number_id", nativeQuery = true)
    Number findByNumber_id(@Param("number_id") Long number_id);

    //중복검사 jpa exists 찾아보자
    @Query(value = "SELECT COUNT(n.id) > 0 FROM number n WHERE n.number_name =:number_name", nativeQuery = true)
    boolean existsByNumber_name(@Param("number_name") int number_name);
}
