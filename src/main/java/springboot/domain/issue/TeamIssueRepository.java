package springboot.domain.issue;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamIssueRepository extends JpaRepository<TeamIssue, Long> {
}
