package hvl.qa.web.repository;

import hvl.qa.web.entity.Favorites;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FavoritesRepository extends JpaRepository<Favorites, Long> {
    @Query("select f from Favorites f where f.id = :id")
    Favorites findById(@Param("id") Long id);

    @Query("select f from Favorites f where f.favType = :fav_id and f.user.id = :user_id")
    List<Favorites> findAllByUserAndFavType(@Param("user_id") Long user_id, @Param("fav_id") Integer fav_id);
}
