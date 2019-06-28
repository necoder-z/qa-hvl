package hvl.qa.web.service.impl;

import hvl.qa.web.entity.Favorites;
import hvl.qa.web.repository.FavoritesRepository;
import hvl.qa.web.service.FavoritesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoritesServiceImpl implements FavoritesService {
    @Autowired
    private FavoritesRepository favoritesRepository;

    @Override
    public Favorites addFavorites(Favorites favorites) {
        Favorites savedFavorites = favoritesRepository.saveAndFlush(favorites);

        return savedFavorites;
    }

    @Override
    public void delete(long id) {
        favoritesRepository.delete(id);
    }

    @Override
    public Favorites getById(Long id) {
        return favoritesRepository.findById(id);
    }

    @Override
    public Favorites editFavorites(Favorites favorites) {
        return favoritesRepository.saveAndFlush(favorites);
    }

    @Override
    public List<Favorites> getAll() {
        return favoritesRepository.findAll();
    }

    @Override
    public List<Favorites> getAllByUserAndFavType(Long userId, Integer favTypeId) {
        return favoritesRepository.findAllByUserAndFavType(userId, favTypeId);
    }

}
