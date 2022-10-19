package springboot.domain.number;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface NumberRepository extends JpaRepository<Number, Long> {
    //쿼리날리는곳
    @Query(value = "select * from number where number.number_name = :number_name", nativeQuery = true)
    Number findByNumber_name(int number_name);
}
