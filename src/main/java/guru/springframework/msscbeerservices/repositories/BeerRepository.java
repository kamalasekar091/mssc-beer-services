package guru.springframework.msscbeerservices.repositories;

import guru.springframework.msscbeerservices.domain.Beer;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface BeerRepository extends PagingAndSortingRepository<Beer, UUID> {
}
