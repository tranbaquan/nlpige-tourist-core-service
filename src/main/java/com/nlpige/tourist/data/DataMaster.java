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
import com.nlpige.tourist.core.tour.model.TourRegisteringEntity;
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

        Traveler traveler1 = new Traveler("Traveler Admin",
                "",
                "VN111111111",
                "tranbaquan.tbq@gmail.com",
                "+84111111111",
                Gender.MALE, LocalDate.of(1997, 12, 13),
                "https://scontent.fsgn8-1.fna.fbcdn.net/v/t1.0-9/48366070_2235179793369792_3474806285390577664_n.jpg?_nc_cat=108&_nc_ht=scontent.fsgn8-1.fna&oh=78563cc7d07a74799b7c118b251baffe&oe=5C8D920B",
                new Address("Viet Nam", "Quan 1"),
                languages, "$argon2id$v=19$m=65536,t=2,p=4$20xQun7wgcWB9ARGGrufUA$5OZbv8FtfiCgvc2nOvnEtexI0+q9yHTpcneP4LDmRJg",
                LocalDateTime.of(2018, 12, 14, 17, 30),
                "VN111111111");

        Traveler traveler2 = new Traveler(
                "Andrew", "Jon",
                "US458496281",
                "andrewjon@gmail.com",
                "0123456789",
                Gender.MALE, LocalDate.of(1988, 11, 11),
                "https://firebasestorage.googleapis.com/v0/b/nltour-2018.appspot.com/o/photos%2F1546335256446_IMG_20190101_121448_611.jpg?alt=media&token=1c859ce9-5128-40fb-ab04-97088c2a4997", new Address("America", "New York"),
                languages,
                "$argon2id$v=19$m=65536,t=2,p=4$20xQun7wgcWB9ARGGrufUA$5OZbv8FtfiCgvc2nOvnEtexI0+q9yHTpcneP4LDmRJg",
                LocalDateTime.of(2018, 12, 14, 17, 30),
                "US458496281");
        Traveler traveler3 = new Traveler("Matt",
                "Mason",
                "US671605156",
                "mattmason@gmail.com",
                "0123456789",
                Gender.MALE,
                LocalDate.of(1997, 12, 13),
                "https://scontent.fsgn8-1.fna.fbcdn.net/v/t1.0-9/48366070_2235179793369792_3474806285390577664_n.jpg?_nc_cat=108&_nc_ht=scontent.fsgn8-1.fna&oh=78563cc7d07a74799b7c118b251baffe&oe=5C8D920B",
                new Address("America", "California"),
                languages,
                "$argon2id$v=19$m=65536,t=2,p=4$20xQun7wgcWB9ARGGrufUA$5OZbv8FtfiCgvc2nOvnEtexI0+q9yHTpcneP4LDmRJg", LocalDateTime.of(2018, 12, 14, 17, 30),
                "US671605156");
        Traveler traveler4 = new Traveler("William",
                "Tom",
                "UK216787544",
                "williamtom@gmail.com",
                "0123456789",
                Gender.MALE, LocalDate.of(1997, 12, 13),
                "https://scontent.fsgn8-1.fna.fbcdn.net/v/t1.0-9/48366070_2235179793369792_3474806285390577664_n.jpg?_nc_cat=108&_nc_ht=scontent.fsgn8-1.fna&oh=78563cc7d07a74799b7c118b251baffe&oe=5C8D920B",
                new Address("England", "London"),
                languages, "$argon2id$v=19$m=65536,t=2,p=4$20xQun7wgcWB9ARGGrufUA$5OZbv8FtfiCgvc2nOvnEtexI0+q9yHTpcneP4LDmRJg",
                LocalDateTime.of(2018, 12, 14, 17, 30),
                "UK216787544");

        Traveler traveler5 = new Traveler(
                "Piper", "CJ",
                "US123456789",
                "pipercj@gmail.com",
                "0123456789",
                Gender.FEMALE, LocalDate.of(1990, 11, 22),
                "https://firebasestorage.googleapis.com/v0/b/nltour-2018.appspot.com/o/photos%2F1546335256446_IMG_20190101_121448_611.jpg?alt=media&token=1c859ce9-5128-40fb-ab04-97088c2a4997",
                new Address("America", "California"),
                languages,
                "$argon2id$v=19$m=65536,t=2,p=4$20xQun7wgcWB9ARGGrufUA$5OZbv8FtfiCgvc2nOvnEtexI0+q9yHTpcneP4LDmRJg",
                LocalDateTime.of(2018, 12, 14, 17, 30),
                "US123456789");

        mongoOperations.save(traveler1);
        mongoOperations.save(traveler2);
        mongoOperations.save(traveler3);
        mongoOperations.save(traveler4);
        mongoOperations.save(traveler5);

        Collaborator collaborator1 = new Collaborator(
                "Collaborator Admin", "",
                "231101668",
                "15130148@st.hcmuaf.edu.vn",
                "0123456789",
                Gender.MALE, LocalDate.of(1997, 11, 2),
                "https://firebasestorage.googleapis.com/v0/b/nltour-2018.appspot.com/o/photos%2F1546770781827_PicsArt_01-04-01.34.13.png?alt=media&token=8a6439b2-f52c-41f0-b9d8-7a942ee210ac",
                new Address("Viet Nam", "Ho Chi Minh City"),
                languages,
                "$argon2id$v=19$m=65536,t=2,p=4$20xQun7wgcWB9ARGGrufUA$5OZbv8FtfiCgvc2nOvnEtexI0+q9yHTpcneP4LDmRJg",
                LocalDateTime.of(2018, 12, 19, 13, 0),
                TourGuideType.PROFESSOR);

        Collaborator collaborator2 = new Collaborator(
                "Thiên", "Đinh Chí",
                "123456785",
                "dinhchithien@gmail.com",
                "0123456789",
                Gender.MALE, LocalDate.of(1997, 2, 2),
                "https://firebasestorage.googleapis.com/v0/b/nltour-2018.appspot.com/o/photos%2F1546770781827_PicsArt_01-04-01.34.13.png?alt=media&token=8a6439b2-f52c-41f0-b9d8-7a942ee210ac",
                new Address("Viet Nam", "Ho Chi Minh City"),
                languages,
                "$argon2id$v=19$m=65536,t=2,p=4$20xQun7wgcWB9ARGGrufUA$5OZbv8FtfiCgvc2nOvnEtexI0+q9yHTpcneP4LDmRJg",
                LocalDateTime.of(2018, 12, 19, 13, 0),
                TourGuideType.PROFESSOR);

        Collaborator collaborator3 = new Collaborator(
                "Quan", "Trần Bá",
                "768655363",
                "admin@nltour.com",
                "0123456789",
                Gender.MALE, LocalDate.of(1997, 2, 2),
                "https://firebasestorage.googleapis.com/v0/b/nltour-2018.appspot.com/o/photos%2F1546770781827_PicsArt_01-04-01.34.13.png?alt=media&token=8a6439b2-f52c-41f0-b9d8-7a942ee210ac",
                new Address("Viet Nam", "Ho Chi Minh City"),
                languages,
                "$argon2id$v=19$m=65536,t=2,p=4$20xQun7wgcWB9ARGGrufUA$5OZbv8FtfiCgvc2nOvnEtexI0+q9yHTpcneP4LDmRJg",
                LocalDateTime.of(2018, 12, 19, 13, 0),
                TourGuideType.PROFESSOR);


        mongoOperations.save(collaborator1);
        mongoOperations.save(collaborator2);
        mongoOperations.save(collaborator3);

        Address address = new Address("Viet Nam", "Ho Chi Minh city");

        mongoOperations.save(address);
        Place place1 = new Place(
                "Ben Thanh Market",
                "https://firebasestorage.googleapis.com/v0/b/nltour-2018.appspot.com/o/places%2Fbtmk.jpg?alt=media&token=596e0289-b340-4f8f-8f05-723285c1180c",
                "The Ben Thanh Traditional Market (Cho Ben Thanh) is the most famous shopping destination in the city. This is not the cheapest market in the city but it has a good reputation, a central location and a history. The market was first set up as an informal gathering of vendors and was then organized by the French into a formal market in 1859. In 1870 a fire destroyed the market and it was rebuilt. The whole market was moved in 1912 to the new building and renamed The New Ben Thanh Market. The building received a facelift in 1985. Just outside the market is a hub of public transport.",
                address,
                375);
        Place place2 = new Place(
                "Independence Palace (Dinh Độc Lập)",
                "https://firebasestorage.googleapis.com/v0/b/nltour-2018.appspot.com/o/places%2Fdinhdoclap.jpg?alt=media&token=51e3ea0d-c05c-4d7f-9ab7-0927bc966ec5",
                "Independence Palace (Dinh Độc Lập), also known as Reunification Palace (Vietnamese: Dinh Thống Nhất), built on the site of the former Norodom Palace, is a landmark in Ho Chi Minh City, Vietnam. It was designed by architect Ngô Viết Thụ and was the home and workplace of the President of South Vietnam during the Vietnam War. It was the site of the end of the Vietnam War during the Fall of Saigon on 30 April 1975, when a North Vietnamese Army tank crashed through its gates.",
                address,
                456
        );
        Place place3 = new Place(
                "Notre-Dame Cathedral Basilica of Saigon",
                "https://firebasestorage.googleapis.com/v0/b/nltour-2018.appspot.com/o/places%2Fntdd.jpg?alt=media&token=24b15b73-ce6f-4143-83ac-6792d4876fa4",
                "Notre-Dame Cathedral Basilica of Saigon is a cathedral located in the downtown of Ho Chi Minh City, Vietnam. Established by French colonists who initially named it Cathédrale Notre-Dame de Saïgon, the cathedral was constructed between 1863 and 1880. It has two bell towers, reaching a height of 58 meters (190 feet).",
                address,
                456
        );
        Place place4 = new Place(
                "Turtle Lake",
                "https://firebasestorage.googleapis.com/v0/b/nltour-2018.appspot.com/o/places%2Fconrualake.jpg?alt=media&token=bb69421f-c488-4086-807d-9a14343edc0c",
                "Located at the middle of Pham Ngoc Thach Street, Turtle Lake is a traffic roundabout of Pham Ngoc Thach Street with Tran Cao Van and Vo Van Tan Street. Turtle Lake attracts the tourists not only its location on the main street in the center of Saigon, but also its unique combination between Eastern and Western in architecture. Moreover, it was one of the symbols of this city that were built before 1975 and still stays nearly the same until today. The name Turtle Lake also causes a misunderstanding with visitors because actually there is no turtle at all. So, “Where is the turtle?”, “Why it called Turtle Lake?” or “Any turtles underwater?” are some very common questions which are usually asked by someone first came there.",
                address,
                876
        );
        Place place5 = new Place(
                "Nguyen Hue Walking Street",
                "https://firebasestorage.googleapis.com/v0/b/nltour-2018.appspot.com/o/places%2Fpdd.jpg?alt=media&token=0c557e5f-fa29-4e36-aa97-524d8241247f",
                "Ho Chi Minh City is not known for being friendly to pedestrians. Motorbikes zip past each other at perilous speeds, and the traffic lights are mere suggestions. For this reason, Nguyen Hue Walking Street is a very special place. It might be the only street in the city where pedestrians always have the right of way.",
                address,
                4646
        );
        Place place6 = new Place(
                "The War Remnants Museum",
                "https://firebasestorage.googleapis.com/v0/b/nltour-2018.appspot.com/o/places%2Fbt.jpg?alt=media&token=e7604aee-5637-4039-a8b9-57de76f5d16b",
                "Operated by the Vietnamese government, an earlier version of this museum opened on September 4, 1975, as the Exhibition House for US and Puppet Crimes. It was located in the former United States Information Agency building. The exhibition was not the first of its kind for the North Vietnamese side, but rather followed a tradition of such exhibitions exposing war crimes, first those of the French and then those of the Americans, who had operated in the country as early as 1954.",
                address,
                766
        );
        Place place7 = new Place(
                "Cu Chi Tunnels",
                "https://firebasestorage.googleapis.com/v0/b/nltour-2018.appspot.com/o/places%2Fcc.jpg?alt=media&token=a2b215ab-c50d-403b-87f6-fdd97e1f90ac",
                "Built under fortified villages, where peasants had been forcibly moved, Cu Chi was a 200-kilometers-long mile network of passages with underground hospitals, meeting rooms, multi-level sleeping quarters, trap doors, smokeless kitchens, air raid shelters, weapons factories, strategy rooms and even entire underground villages with theaters and movie halls. In some places the tunnels had three stories.",
                address,
                1234
        );
        Place place8 = new Place(
                "The Ho Chi Minh City Post Office",
                "https://firebasestorage.googleapis.com/v0/b/nltour-2018.appspot.com/o/places%2Fbd.jpg?alt=media&token=36505466-3393-4330-b1b6-8ee28b6dc9b9",
                "The Central Post Office in Ho Chi Minh is a beautifully preserved remnant of French colonial times and perhaps the grandest post office in all of Southeast Asia. Located next door to Notre Dame Cathedral, the two cultural sites can be visited together and offers visitors a chance to imagine life in Vietnam during the times of the Indochinese Empire. The building was designed by Alfred Foulhoux and features arched windows and wooden shutters, just as it would have in its heyday in the late 19th Century.",
                address,
                234
        );
        Place place9 = new Place(
                "Municipal Theatre",
                "https://firebasestorage.googleapis.com/v0/b/nltour-2018.appspot.com/o/places%2Fnh.jpg?alt=media&token=650b111c-2c69-41bd-a84b-e8677bc28ba6",
                "The Municipal Theatre is a smaller counterpart of the Hanoi Opera House, which was built between 1901 and 1911, and shaped like the Opéra Garnier in Paris with 800 seats to entertain French colonists. The Municipal Theatre owes its specific characteristics to the work of architect Félix Olivier, while construction was under supervision of architects Ernest Guichard and Eugène Ferret in 1900.",
                address,
                900
        );


        mongoOperations.save(place1);
        mongoOperations.save(place2);
        mongoOperations.save(place3);
        mongoOperations.save(place4);
        mongoOperations.save(place5);
        mongoOperations.save(place6);
        mongoOperations.save(place7);
        mongoOperations.save(place8);
        mongoOperations.save(place9);

        Tour tour1 = new Tour("tour1",
                place1,
                traveler1,
                collaborator1,
                LocalDateTime.of(2018, 12, 22, 9, 0),
                190, true, true, "test"
        );
        Tour tour2 = new Tour("tour2",
                place2,
                traveler1,
                collaborator2,
                LocalDateTime.of(2019, 2, 22, 9, 0),
                190, true, false, "test"
        );
        Tour tour3 = new Tour("tour3",
                place3,
                traveler1,
                null,
                LocalDateTime.of(2019, 2, 1, 9, 0),
                0, true, false, "test"
        );
        Tour tour4 = new Tour("tour4",
                place4,
                traveler1,
                null,
                LocalDateTime.of(2019, 1, 24, 9, 0),
                0, true, true, "test"
        );
        Tour tour5 = new Tour("tour5",
                place5,
                traveler5,
                null,
                LocalDateTime.of(2019, 2, 2, 9, 0),
                190, true, false, "test"
        );
        Tour tour6 = new Tour("tour6",
                place6,
                traveler2,
                collaborator1,
                LocalDateTime.of(2019, 2, 3, 9, 0),
                190, true, false, "test"
        );
        Tour tour7 = new Tour("tour7",
                place7,
                traveler2,
                collaborator2,
                LocalDateTime.of(2018, 12, 22, 9, 0),
                190, true, true, "test"
        );
        Tour tour8 = new Tour("tour8",
                place8,
                traveler3,
                null,
                LocalDateTime.of(2019, 1, 24, 9, 0),
                0, true, false, "test"
        );
        Tour tour9 = new Tour("tour9",
                place9,
                traveler3,
                collaborator3,
                LocalDateTime.of(2018, 12, 22, 9, 0),
                190, true, true, "test"
        );
        Tour tour10 = new Tour("tour10",
                place9,
                traveler4,
                null,
                LocalDateTime.of(2019, 1, 24, 9, 0),
                0, true, false, "test"
        );

        mongoOperations.save(tour1);
        mongoOperations.save(tour2);
        mongoOperations.save(tour3);
        mongoOperations.save(tour4);
        mongoOperations.save(tour5);
        mongoOperations.save(tour6);
        mongoOperations.save(tour7);
        mongoOperations.save(tour8);
        mongoOperations.save(tour9);
        mongoOperations.save(tour10);

        Price price1 = new Price(TourGuideType.RESIDENT, 300);
        Price price2 = new Price(TourGuideType.STUDENT, 250);
        Price price3 = new Price(TourGuideType.FREELANCER, 400);
        Price price4 = new Price(TourGuideType.PROFESSOR, 500);

        mongoOperations.save(price1);
        mongoOperations.save(price2);
        mongoOperations.save(price3);
        mongoOperations.save(price4);

        TourRegisteringEntity entity1 = new TourRegisteringEntity(tour3, collaborator1);
        TourRegisteringEntity entity2 = new TourRegisteringEntity(tour3, collaborator2);
        TourRegisteringEntity entity3 = new TourRegisteringEntity(tour3, collaborator3);
        TourRegisteringEntity entity4 = new TourRegisteringEntity(tour4, collaborator1);
        TourRegisteringEntity entity5 = new TourRegisteringEntity(tour4, collaborator2);

        mongoOperations.save(entity1);
        mongoOperations.save(entity2);
        mongoOperations.save(entity3);
        mongoOperations.save(entity4);
        mongoOperations.save(entity5);
    }
}
