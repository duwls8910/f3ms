package springboot.domain.issue;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberIssueRepository extends JpaRepository<MemberIssue, Long> {
}
