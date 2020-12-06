package home.whiteelephant.repositories;

import home.whiteelephant.object.PersonGift;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "person", path = "person")
public interface PersonGiftRepository extends PagingAndSortingRepository<PersonGift, Long> {

    List<PersonGift> findAll();

    PersonGift findByName(@Param("name") String name);

    PersonGift findByGiftName(@Param("giftName") String giftName);
}
