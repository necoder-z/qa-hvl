package hvl.qa.web.repository;

import hvl.qa.web.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface VoteRepository extends JpaRepository<Vote, Long> {
    @Query("select t from Vote t where t.id = :id")
    Vote findById(@Param("id") Long id);
}
