package com.nlpige.tourist.data;


import com.nlpige.tourist.config.SpringMongoConfig;
import com.nlpige.tourist.core.collaborator.model.Collaborator;
import com.nlpige.tourist.core.collaborator.model.TourGuideType;
import com.nlpige.tourist.core.customer.model.Address;
import com.nlpige.tourist.core.customer.model.Gender;
import com.nlpige.tourist.core.customer.model.Languages;
import com.nlpige.tourist.core.tour.model.Place;
import com.nlpige.tourist.core.tour.model.Price;
import com.nlpige.tourist.core.tour.model.Tour;
import com.nlpige.tourist.core.traveler.model.Traveler;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by IntelliJ on Tuesday, 11 December, 2018 at 23:54.
 *
 * @author Joseph Maria
 * @author Tran Ba Quan
 */
public class DataMaster {
    private MongoOperations mongoOperations;

    public DataMaster() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
        mongoOperations = (MongoOperations) context.getBean("mongoTemplate");
    }

    public void init() {
        Languages languages = new Languages("English");

        Traveler traveler1 = new Traveler(
                "Piper", "CJ",
                "123456789",
                "pipercj@gmail.com",
                Gender.FEMALE, LocalDate.of(1990, 11, 22),
                "https://firebasestorage.googleapis.com/v0/b/nltour-2018.appspot.com/o/photos%2F1546335256446_IMG_20190101_121448_611.jpg?alt=media&token=1c859ce9-5128-40fb-ab04-97088c2a4997",
                new Address("America", "California"),
                languages,
                "123456",
                LocalDateTime.of(2018, 12, 14, 17, 30),
                "US1234567");

        Traveler traveler2 = new Traveler(
                "Andrew", "Jon",
                "123456788",
                "andrew@gmail.com",
                Gender.MALE, LocalDate.of(1988, 11, 11),
                "https://firebasestorage.googleapis.com/v0/b/nltour-2018.appspot.com/o/photos%2F1546335256446_IMG_20190101_121448_611.jpg?alt=media&token=1c859ce9-5128-40fb-ab04-97088c2a4997",                new Address("America", "New York"),
                languages,
                "123456",
                LocalDateTime.of(2018, 12, 14, 17, 30),
                "US1234567");

        mongoOperations.save(traveler1);
        mongoOperations.save(traveler2);

        Collaborator collaborator1 = new Collaborator(
                "Quan", "Trần Bá",
                "231101668",
                "tranbaquan.tbq@gmail.com",
                Gender.MALE, LocalDate.of(1997, 11, 02),
                "https://firebasestorage.googleapis.com/v0/b/nltour-2018.appspot.com/o/photos%2F1546335256446_IMG_20190101_121448_611.jpg?alt=media&token=1c859ce9-5128-40fb-ab04-97088c2a4997",
                new Address("Viet Nam", "Ho Chi Minh City"),
                languages,
                "123456",
                LocalDateTime.of(2018, 12, 19, 13, 0),
                TourGuideType.PROFESSOR,
                "0393452595");

        Collaborator collaborator2 = new Collaborator(
                "Thiên", "Đinh Chí",
                "123456785",
                "dinhchithien@gmail.com",
                Gender.MALE, LocalDate.of(1997, 02, 02),
                "https://firebasestorage.googleapis.com/v0/b/nltour-2018.appspot.com/o/photos%2F1546335256446_IMG_20190101_121448_611.jpg?alt=media&token=1c859ce9-5128-40fb-ab04-97088c2a4997",
                new Address("Viet Nam", "Ho Chi Minh City"),
                languages,
                "123456",
                LocalDateTime.of(2018, 12, 19, 13, 0),
                TourGuideType.PROFESSOR,
                "0393939393");

        mongoOperations.save(collaborator1);
        mongoOperations.save(collaborator2);

        Address address = new Address("Viet Nam", "Ho Chi Minh city");

        mongoOperations.save(address);

        Place place1 = new Place(
                "Ben Thanh Market",
                "assets/images/travel.png",
                "The Ben Thanh Traditional Market (Cho Ben Thanh) is the most famous shopping destination" +
                        " in the city. This is not the cheapest market in the city but it has a good reputation, a" +
                        " central location and a history. The market was first set up as an informal gathering of vendors" +
                        " and was then organized by the French into a formal market in 1859. In 1870 a fire destroyed the" +
                        " market and it was rebuilt. The whole market was moved in 1912 to the new building and renamed The" +
                        " New Ben Thanh Market. The building received a facelift in 1985. Just outside the market is a hub" +
                        " of public transport.",
                address,
                1000);
        Place place2 = new Place(
                "Notre Dame Cathedral",
                "assets/images/travel.png",
                "Ho Chi Minh City has quite a large Catholic community who worship at this historic cathedral. The Saigon" +
                        " Basilica of Our Lady of the Immaculate Conception was built between 1863 and 1880 under the French" +
                        " colonists. They used only building materials imported from France; it has a red brick exterior" +
                        " which came from Marseilles and stained glass from Chartres Province in France. The church has an" +
                        " overall neo-Romanesque design. The walls of the interior are white with contrasting brown beams." +
                        " There is a high vaulted ceiling and elegant arches down either side of the nave.",
                address,
                1234
        );

        mongoOperations.save(place1);
        mongoOperations.save(place2);

        Tour tour1 = new Tour("tour1",
               place1,
               traveler1,
               collaborator1,
               LocalDateTime.of(2018,12,22, 9, 00),
               190,false
        );

        Tour tour2 = new Tour("tour2",
                place2,
                traveler2,
                collaborator2,
                LocalDateTime.of(2018,12,22, 9, 00),
                190,false
        );

        mongoOperations.save(tour1);
        mongoOperations.save(tour2);

        Price price1 = new Price(TourGuideType.RESIDENT, 300);
        Price price2 = new Price(TourGuideType.STUDENT, 250);
        Price price3 = new Price(TourGuideType.FREELANCER, 400);
        Price price4 = new Price(TourGuideType.PROFESSOR, 500);

        mongoOperations.save(price1);
        mongoOperations.save(price2);
        mongoOperations.save(price3);
        mongoOperations.save(price4);
    }
    // TODO
    // Add more data master. Upload image to firebase
}
