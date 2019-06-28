package hvl.qa.web.service;

import hvl.qa.web.entity.Favorites;

import java.util.List;

public interface FavoritesService {
    Favorites addFavorites(Favorites favorites);

    void delete(long id);

    Favorites getById(Long id);

    Favorites editFavorites(Favorites favorites);

    List<Favorites> getAll();

    List<Favorites> getAllByUserAndFavType(Long userId, Integer favTypeId);
}