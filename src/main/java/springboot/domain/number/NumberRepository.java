package springboot.domain.number;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NumberRepository extends JpaRepository<Number, Long> {
    //쿼리날리는곳
}
