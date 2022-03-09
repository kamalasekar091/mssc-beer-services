package guru.springframework.msscbeerservices.bootstrap;

import guru.springframework.msscbeerservices.domain.Beer;
import guru.springframework.msscbeerservices.repositories.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;


@Component
public class BeerLoader implements CommandLineRunner {

    public static final String BEER_1_UPC = "0631234200036";
    public static final String BEER_2_UPC = "0631234300019";
    public static final String BEER_3_UPC = "0083783375213";

    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBeerObjects();
    }

    private void loadBeerObjects() {
        Beer b1 = Beer.builder()
                .beerName("Mango Bobs")
                .beerStyle("IPA")
                .minOnHead(12)
                .quantityToBrew(200)
                .price(new BigDecimal("12.95"))
                .UPC(BEER_1_UPC)
                .build();

        Beer b2 = Beer.builder()
                .beerName("Galaxy Cat")
                .beerStyle("PALE_ALE")
                .minOnHead(12)
                .quantityToBrew(200)
                .price(new BigDecimal("12.95"))
                .UPC(BEER_2_UPC)
                .build();

        Beer b3 = Beer.builder()
                .beerName("Pinball Porter")
                .beerStyle("PALE_ALE")
                .minOnHead(12)
                .quantityToBrew(200)
                .price(new BigDecimal("12.95"))
                .UPC(BEER_3_UPC)
                .build();

        if(beerRepository.count()==0){
            beerRepository.save(b1);
            beerRepository.save(b2);
            beerRepository.save(b3);
        }

        System.out.println("Count----------------->: "+beerRepository.count());

    }
}
