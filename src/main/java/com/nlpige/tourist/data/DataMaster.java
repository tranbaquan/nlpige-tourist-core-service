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

        Traveler traveler1 = new Traveler(
                "Piper", "CJ",
                "123456789",
                "pipercj@gmail.com",
                Gender.FEMALE, LocalDate.of(1990, 11, 22),
                "https://firebasestorage.googleapis.com/v0/b/nltour-2018.appspot.com/o/photos%2F1546335256446_IMG_20190101_121448_611.jpg?alt=media&token=1c859ce9-5128-40fb-ab04-97088c2a4997",
                new Address("America", "California"),
                languages,
                "$argon2id$v=19$m=65536,t=2,p=4$20xQun7wgcWB9ARGGrufUA$5OZbv8FtfiCgvc2nOvnEtexI0+q9yHTpcneP4LDmRJg",
                LocalDateTime.of(2018, 12, 14, 17, 30),
                "US1234567");

        Traveler traveler2 = new Traveler(
                "Andrew", "Jon",
                "123456788",
                "andrew@gmail.com",
                Gender.MALE, LocalDate.of(1988, 11, 11),
                "https://firebasestorage.googleapis.com/v0/b/nltour-2018.appspot.com/o/photos%2F1546335256446_IMG_20190101_121448_611.jpg?alt=media&token=1c859ce9-5128-40fb-ab04-97088c2a4997", new Address("America", "New York"),
                languages,
                "$argon2id$v=19$m=65536,t=2,p=4$20xQun7wgcWB9ARGGrufUA$5OZbv8FtfiCgvc2nOvnEtexI0+q9yHTpcneP4LDmRJg",
                LocalDateTime.of(2018, 12, 14, 17, 30),
                "US1234567");
        Traveler traveler3 = new Traveler("Truong",
                "Nguyen Ngoc Lam Bao",
                "671605156",
                "truong@gmail.com",
                Gender.MALE, LocalDate.of(1997, 12, 13),
                "https://scontent.fsgn8-1.fna.fbcdn.net/v/t1.0-9/48366070_2235179793369792_3474806285390577664_n.jpg?_nc_cat=108&_nc_ht=scontent.fsgn8-1.fna&oh=78563cc7d07a74799b7c118b251baffe&oe=5C8D920B",
                new Address("Viet Nam", "Quan 1"),
                languages,
                "$argon2id$v=19$m=65536,t=2,p=4$20xQun7wgcWB9ARGGrufUA$5OZbv8FtfiCgvc2nOvnEtexI0+q9yHTpcneP4LDmRJg", LocalDateTime.of(2018, 12, 14, 17, 30), "VN4445222");
        Traveler traveler4 = new Traveler("Hải",
                "Trần Thanh",
                "216787544",
                "haitranit1997@gmail.com",
                Gender.MALE, LocalDate.of(1997, 12, 13),
                "https://scontent.fsgn8-1.fna.fbcdn.net/v/t1.0-9/48366070_2235179793369792_3474806285390577664_n.jpg?_nc_cat=108&_nc_ht=scontent.fsgn8-1.fna&oh=78563cc7d07a74799b7c118b251baffe&oe=5C8D920B",
                new Address("Viet Nam", "Quan 1"),
                languages, "$argon2id$v=19$m=65536,t=2,p=4$20xQun7wgcWB9ARGGrufUA$5OZbv8FtfiCgvc2nOvnEtexI0+q9yHTpcneP4LDmRJg", LocalDateTime.of(2018, 12, 14, 17, 30), "VN4414044");
        Traveler traveler5 = new Traveler("Quan",
                "Trần Bá ",
                "415007076",
                "tranbaquan.tbq@gmail.com",
                Gender.MALE, LocalDate.of(1997, 12, 13),
                "https://scontent.fsgn8-1.fna.fbcdn.net/v/t1.0-9/48366070_2235179793369792_3474806285390577664_n.jpg?_nc_cat=108&_nc_ht=scontent.fsgn8-1.fna&oh=78563cc7d07a74799b7c118b251baffe&oe=5C8D920B",
                new Address("Viet Nam", "Quan 1"),
                languages, "$argon2id$v=19$m=65536,t=2,p=4$20xQun7wgcWB9ARGGrufUA$5OZbv8FtfiCgvc2nOvnEtexI0+q9yHTpcneP4LDmRJg", LocalDateTime.of(2018, 12, 14, 17, 30), "VN6146154");
        Traveler traveler6 = new Traveler("Thiên",
                "Đinh Chí",
                "167510743",
                "chithien@gmail.com",
                Gender.MALE, LocalDate.of(1997, 12, 13),
                "https://scontent.fsgn8-1.fna.fbcdn.net/v/t1.0-9/48366070_2235179793369792_3474806285390577664_n.jpg?_nc_cat=108&_nc_ht=scontent.fsgn8-1.fna&oh=78563cc7d07a74799b7c118b251baffe&oe=5C8D920B",
                new Address("Viet Nam", "Quan 1"),
                languages, "$argon2id$v=19$m=65536,t=2,p=4$20xQun7wgcWB9ARGGrufUA$5OZbv8FtfiCgvc2nOvnEtexI0+q9yHTpcneP4LDmRJg", LocalDateTime.of(2018, 12, 14, 17, 30), "VN1235014");
        Traveler traveler7 = new Traveler("Jeremie",
                "Belpois",
                "257505163",
                "jeremiebelpois@gmail.com",
                Gender.MALE, LocalDate.of(1997, 12, 13),
                "https://scontent.fsgn8-1.fna.fbcdn.net/v/t1.0-9/48366070_2235179793369792_3474806285390577664_n.jpg?_nc_cat=108&_nc_ht=scontent.fsgn8-1.fna&oh=78563cc7d07a74799b7c118b251baffe&oe=5C8D920B",
                new Address("Viet Nam", "Quan 1"),
                languages, "$argon2id$v=19$m=65536,t=2,p=4$20xQun7wgcWB9ARGGrufUA$5OZbv8FtfiCgvc2nOvnEtexI0+q9yHTpcneP4LDmRJg", LocalDateTime.of(2018, 12, 14, 17, 30), "US3531012");
        Traveler traveler8 = new Traveler("Aelita",
                "Schaeffer",
                "745576853",
                "aelita@gmail.com",
                Gender.FEMALE, LocalDate.of(1997, 12, 13),
                "https://scontent.fsgn8-1.fna.fbcdn.net/v/t1.0-9/48366070_2235179793369792_3474806285390577664_n.jpg?_nc_cat=108&_nc_ht=scontent.fsgn8-1.fna&oh=78563cc7d07a74799b7c118b251baffe&oe=5C8D920B",
                new Address("Viet Nam", "Quan 1"),
                languages, "$argon2id$v=19$m=65536,t=2,p=4$20xQun7wgcWB9ARGGrufUA$5OZbv8FtfiCgvc2nOvnEtexI0+q9yHTpcneP4LDmRJg", LocalDateTime.of(2018, 12, 14, 17, 30), "US5504234");
        Traveler traveler9 = new Traveler("Odd",
                "Della Robbia",
                "501412357",
                "Della Robbia@gmail.com",
                Gender.MALE, LocalDate.of(1997, 12, 13),
                "https://scontent.fsgn8-1.fna.fbcdn.net/v/t1.0-9/48366070_2235179793369792_3474806285390577664_n.jpg?_nc_cat=108&_nc_ht=scontent.fsgn8-1.fna&oh=78563cc7d07a74799b7c118b251baffe&oe=5C8D920B",
                new Address("Viet Nam", "Quan 1"),
                languages, "$argon2id$v=19$m=65536,t=2,p=4$20xQun7wgcWB9ARGGrufUA$5OZbv8FtfiCgvc2nOvnEtexI0+q9yHTpcneP4LDmRJg", LocalDateTime.of(2018, 12, 14, 17, 30), "US1502641");
        Traveler traveler10 = new Traveler("Ulrich",
                "Stern",
                "674283615",
                "Stern@gmail.com",
                Gender.MALE, LocalDate.of(1997, 12, 13),
                "https://scontent.fsgn8-1.fna.fbcdn.net/v/t1.0-9/48366070_2235179793369792_3474806285390577664_n.jpg?_nc_cat=108&_nc_ht=scontent.fsgn8-1.fna&oh=78563cc7d07a74799b7c118b251baffe&oe=5C8D920B",
                new Address("Viet Nam", "Quan 1"),
                languages, "$argon2id$v=19$m=65536,t=2,p=4$20xQun7wgcWB9ARGGrufUA$5OZbv8FtfiCgvc2nOvnEtexI0+q9yHTpcneP4LDmRJg", LocalDateTime.of(2018, 12, 14, 17, 30), "FR6000446");
        mongoOperations.save(traveler1);
        mongoOperations.save(traveler2);
        mongoOperations.save(traveler3);
        mongoOperations.save(traveler4);
        mongoOperations.save(traveler5);
        mongoOperations.save(traveler6);
        mongoOperations.save(traveler7);
        mongoOperations.save(traveler8);
        mongoOperations.save(traveler9);
        mongoOperations.save(traveler10);

        Collaborator collaborator1 = new Collaborator(
                "Quan", "Trần Bá",
                "231101668",
                "tranbaquan1.tbq@gmail.com",
                Gender.MALE, LocalDate.of(1997, 11, 02),
                "https://firebasestorage.googleapis.com/v0/b/nltour-2018.appspot.com/o/photos%2F1546770781827_PicsArt_01-04-01.34.13.png?alt=media&token=8a6439b2-f52c-41f0-b9d8-7a942ee210ac",
                new Address("Viet Nam", "Ho Chi Minh City"),
                languages,
                "$argon2id$v=19$m=65536,t=2,p=4$20xQun7wgcWB9ARGGrufUA$5OZbv8FtfiCgvc2nOvnEtexI0+q9yHTpcneP4LDmRJg",
                LocalDateTime.of(2018, 12, 19, 13, 0),
                TourGuideType.PROFESSOR,
                "0393452595");

        Collaborator collaborator2 = new Collaborator(
                "Thiên", "Đinh Chí",
                "123456785",
                "dinhchithien@gmail.com",
                Gender.MALE, LocalDate.of(1997, 02, 02),
                "https://firebasestorage.googleapis.com/v0/b/nltour-2018.appspot.com/o/photos%2F1546770781827_PicsArt_01-04-01.34.13.png?alt=media&token=8a6439b2-f52c-41f0-b9d8-7a942ee210ac",
                new Address("Viet Nam", "Ho Chi Minh City"),
                languages,
                "$argon2id$v=19$m=65536,t=2,p=4$20xQun7wgcWB9ARGGrufUA$5OZbv8FtfiCgvc2nOvnEtexI0+q9yHTpcneP4LDmRJg",
                LocalDateTime.of(2018, 12, 19, 13, 0),
                TourGuideType.PROFESSOR,
                "0393939393");
        Collaborator collaborator3 = new Collaborator(
                "Yumi", "Ishiyama",
                "123456785",
                "dinhchithien@gmail.com",
                Gender.MALE, LocalDate.of(1997, 02, 02),
                "https://firebasestorage.googleapis.com/v0/b/nltour-2018.appspot.com/o/photos%2F1546770781827_PicsArt_01-04-01.34.13.png?alt=media&token=8a6439b2-f52c-41f0-b9d8-7a942ee210ac",
                new Address("Viet Nam", "Ho Chi Minh City"),
                languages,
                "$argon2id$v=19$m=65536,t=2,p=4$20xQun7wgcWB9ARGGrufUA$5OZbv8FtfiCgvc2nOvnEtexI0+q9yHTpcneP4LDmRJg",
                LocalDateTime.of(2018, 12, 19, 13, 0),
                TourGuideType.PROFESSOR,
                "0393939393");
        Collaborator collaborator4 = new Collaborator(
                "Bertolt", "Hoover",
                "138470745",
                "Hoover@gmail.com",
                Gender.MALE, LocalDate.of(1997, 02, 02),
                "https://firebasestorage.googleapis.com/v0/b/nltour-2018.appspot.com/o/photos%2F1546770781827_PicsArt_01-04-01.34.13.png?alt=media&token=8a6439b2-f52c-41f0-b9d8-7a942ee210ac",
                new Address("Viet Nam", "Ho Chi Minh City"),
                languages,
                "$argon2id$v=19$m=65536,t=2,p=4$20xQun7wgcWB9ARGGrufUA$5OZbv8FtfiCgvc2nOvnEtexI0+q9yHTpcneP4LDmRJg",
                LocalDateTime.of(2018, 12, 19, 13, 0),
                TourGuideType.PROFESSOR,
                "0393939393");
        Collaborator collaborator5 = new Collaborator(
                "Darius", "Zackly",
                "384310460",
                "Zackly@gmail.com",
                Gender.MALE, LocalDate.of(1997, 02, 02),
                "https://firebasestorage.googleapis.com/v0/b/nltour-2018.appspot.com/o/photos%2F1546770781827_PicsArt_01-04-01.34.13.png?alt=media&token=8a6439b2-f52c-41f0-b9d8-7a942ee210ac",
                new Address("Viet Nam", "Ho Chi Minh City"),
                languages,
                "$argon2id$v=19$m=65536,t=2,p=4$20xQun7wgcWB9ARGGrufUA$5OZbv8FtfiCgvc2nOvnEtexI0+q9yHTpcneP4LDmRJg",
                LocalDateTime.of(2018, 12, 19, 13, 0),
                TourGuideType.PROFESSOR,
                "0393939393");
        Collaborator collaborator6 = new Collaborator(
                "Reiner", "Braun",
                "013621215",
                "Braun@gmail.com",
                Gender.MALE, LocalDate.of(1997, 02, 02),
                "https://firebasestorage.googleapis.com/v0/b/nltour-2018.appspot.com/o/photos%2F1546770781827_PicsArt_01-04-01.34.13.png?alt=media&token=8a6439b2-f52c-41f0-b9d8-7a942ee210ac",
                new Address("Viet Nam", "Ho Chi Minh City"),
                languages,
                "$argon2id$v=19$m=65536,t=2,p=4$20xQun7wgcWB9ARGGrufUA$5OZbv8FtfiCgvc2nOvnEtexI0+q9yHTpcneP4LDmRJg",
                LocalDateTime.of(2018, 12, 19, 13, 0),
                TourGuideType.PROFESSOR,
                "0393939393");
        Collaborator collaborator7 = new Collaborator(
                "Armin", "Arlert",
                "162834268",
                "Arlert@gmail.com",
                Gender.FEMALE, LocalDate.of(1997, 02, 02),
                "https://firebasestorage.googleapis.com/v0/b/nltour-2018.appspot.com/o/photos%2F1546770781827_PicsArt_01-04-01.34.13.png?alt=media&token=8a6439b2-f52c-41f0-b9d8-7a942ee210ac",
                new Address("Viet Nam", "Ho Chi Minh City"),
                languages,
                "$argon2id$v=19$m=65536,t=2,p=4$20xQun7wgcWB9ARGGrufUA$5OZbv8FtfiCgvc2nOvnEtexI0+q9yHTpcneP4LDmRJg",
                LocalDateTime.of(2018, 12, 19, 13, 0),
                TourGuideType.PROFESSOR,
                "0393939393");
        Collaborator collaborator8 = new Collaborator(
                "Mikasa", "Ackerman",
                "123456785",
                "Ackerman@gmail.com",
                Gender.FEMALE, LocalDate.of(1997, 02, 02),
                "https://firebasestorage.googleapis.com/v0/b/nltour-2018.appspot.com/o/photos%2F1546770781827_PicsArt_01-04-01.34.13.png?alt=media&token=8a6439b2-f52c-41f0-b9d8-7a942ee210ac",
                new Address("Viet Nam", "Ho Chi Minh City"),
                languages,
                "$argon2id$v=19$m=65536,t=2,p=4$20xQun7wgcWB9ARGGrufUA$5OZbv8FtfiCgvc2nOvnEtexI0+q9yHTpcneP4LDmRJg",
                LocalDateTime.of(2018, 12, 19, 13, 0),
                TourGuideType.PROFESSOR,
                "0393939393");
        Collaborator collaborator9 = new Collaborator(
                "Eren ", "Yeager ",
                "617443341",
                "Yeager@gmail.com",
                Gender.MALE, LocalDate.of(1997, 02, 02),
                "https://firebasestorage.googleapis.com/v0/b/nltour-2018.appspot.com/o/photos%2F1546770781827_PicsArt_01-04-01.34.13.png?alt=media&token=8a6439b2-f52c-41f0-b9d8-7a942ee210ac",
                new Address("Viet Nam", "Ho Chi Minh City"),
                languages,
                "$argon2id$v=19$m=65536,t=2,p=4$20xQun7wgcWB9ARGGrufUA$5OZbv8FtfiCgvc2nOvnEtexI0+q9yHTpcneP4LDmRJg",
                LocalDateTime.of(2018, 12, 19, 13, 0),
                TourGuideType.PROFESSOR,
                "0393939393");
        Collaborator collaborator10 = new Collaborator(
                "William", "Dunbar",
                "768655363",
                "admin@nltour.com",
                Gender.MALE, LocalDate.of(1997, 02, 02),
                "https://firebasestorage.googleapis.com/v0/b/nltour-2018.appspot.com/o/photos%2F1546770781827_PicsArt_01-04-01.34.13.png?alt=media&token=8a6439b2-f52c-41f0-b9d8-7a942ee210ac",
                new Address("Viet Nam", "Ho Chi Minh City"),
                languages,
                "$argon2id$v=19$m=65536,t=2,p=4$20xQun7wgcWB9ARGGrufUA$5OZbv8FtfiCgvc2nOvnEtexI0+q9yHTpcneP4LDmRJg",
                LocalDateTime.of(2018, 12, 19, 13, 0),
                TourGuideType.PROFESSOR,
                "0393939393");


        mongoOperations.save(collaborator1);
        mongoOperations.save(collaborator2);
        mongoOperations.save(collaborator3);
        mongoOperations.save(collaborator4);
        mongoOperations.save(collaborator5);
        mongoOperations.save(collaborator6);
        mongoOperations.save(collaborator7);
        mongoOperations.save(collaborator8);
        mongoOperations.save(collaborator9);
        mongoOperations.save(collaborator10);

        Address address = new Address("Viet Nam", "Ho Chi Minh city");

        mongoOperations.save(address);
        Place place1 = new Place(
                "Ben Thanh Market",
                "https://firebasestorage.googleapis.com/v0/b/nltour-2018.appspot.com/o/places%2Fbtmk.jpg?alt=media&token=596e0289-b340-4f8f-8f05-723285c1180c",
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
                "Dinh Doc Lap",
                "https://firebasestorage.googleapis.com/v0/b/nltour-2018.appspot.com/o/places%2Fdinhdoclap.jpg?alt=media&token=51e3ea0d-c05c-4d7f-9ab7-0927bc966ec5",
                "Dinh Độc Lập (tên gọi trước đây là dinh Norodom, ngày nay còn gọi là dinh Thống Nhất hay hội trường Thống Nhất) là một công trình kiến trúc, tòa nhà ở Thành ..",
                address,
                1234
        );
        Place place3 = new Place(
                "Nha Tho Duc Ba",
                "https://firebasestorage.googleapis.com/v0/b/nltour-2018.appspot.com/o/places%2Fntdd.jpg?alt=media&token=24b15b73-ce6f-4143-83ac-6792d4876fa4",
                "Nhà thờ chính tòa Đức Bà Sài Gòn (tên chính thức: Vương cung thánh đường chính tòa Đức Mẹ Vô nhiễm Nguyên tội, tiếng Anh: Immaculate Conception ...",
                address,
                1234
        );
        Place place4 = new Place(
                "Con Rua Lake",
                "https://firebasestorage.googleapis.com/v0/b/nltour-2018.appspot.com/o/places%2Fconrualake.jpg?alt=media&token=bb69421f-c488-4086-807d-9a14343edc0c",
                "Hồ Con Rùa là tên gọi dân gian của một hồ phun nước nhân tạo nằm giữa nơi giao nhau của ba đường: Võ Văn Tần, Phạm Ngọc Thạch và Trần Cao Vân, ...",
                address,
                1234
        );
        Place place5 = new Place(
                "Pho Di Bo Nguyen Hue",
                "https://firebasestorage.googleapis.com/v0/b/nltour-2018.appspot.com/o/places%2Fpdd.jpg?alt=media&token=0c557e5f-fa29-4e36-aa97-524d8241247f",
                "Tháng 4 năm 2015, chính quyền Thành phố Hồ Chí Minh khánh thành công trình quảng trường đi bộ Nguyễn Huệ với ...",
                address,
                1234
        );
        Place place6 = new Place(
                "The War Remnants Museum",
                "https://firebasestorage.googleapis.com/v0/b/nltour-2018.appspot.com/o/places%2Fbt.jpg?alt=media&token=e7604aee-5637-4039-a8b9-57de76f5d16b",
                "Bảo tàng Chứng tích chiến tranh là một bảo tàng ở số 28 đường Võ Văn Tần, Quận 3, Thành ... Riêng pho tượng Phật được lưu giữ và sau chuyển vào Bảo tàng Blanchard de la Brosse ... Mạng Thông tin tích hợp trên Internet của TP HCM.",
                address,
                1234
        );
        Place place7 = new Place(
                "Cu Chi Tunnels",
                "https://firebasestorage.googleapis.com/v0/b/nltour-2018.appspot.com/o/places%2Fcc.jpg?alt=media&token=a2b215ab-c50d-403b-87f6-fdd97e1f90ac",
                "The tunnels of Củ Chi are an immense network of connecting underground tunnels located in the Củ Chi District of Ho Chi Minh City (Saigon), Vietnam, and are ...",
                address,
                1234
        );
        Place place8 = new Place(
                "Bao Tang Y Hoc",
                "https://firebasestorage.googleapis.com/v0/b/nltour-2018.appspot.com/o/places%2Fbtyh.jpg?alt=media&token=3a255b1e-fbc8-49a1-b747-be83b2819c98",
                "Nơi đây rất bổ ích và tôi nghĩ là cần thiết đối với những ai học ngành y và với những ai muốn tìm hiểu về y cổ truyền . Nơi đây có rất nhiều hình ảnh cung cấp ...\n",
                address,
                1234
        );
        Place place9 = new Place(
                "The Ho Chi Minh City Post Office",
                "https://firebasestorage.googleapis.com/v0/b/nltour-2018.appspot.com/o/places%2Fbd.jpg?alt=media&token=36505466-3393-4330-b1b6-8ee28b6dc9b9",
                "Bưu điện trung tâm Sài Gòn là một trong những công trình kiến trúc tiêu biểu tại Thành phố Hồ Chí Minh, tọa lạc tại số 2, Công trường Công xã Paris, Quận 1.",
                address,
                1234
        );
        Place place10 = new Place(
                "Municipal Theatre",
                "https://firebasestorage.googleapis.com/v0/b/nltour-2018.appspot.com/o/places%2Fnh.jpg?alt=media&token=650b111c-2c69-41bd-a84b-e8677bc28ba6",
                "The Municipal Theatre of Ho Chi Minh City, also known as Saigon Municipal Opera House is ... Nhà hát Lớn thành phố Hồ Chí Minh ...",
                address,
                1234
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
        mongoOperations.save(place10);

        Tour tour1 = new Tour("tour1",
                place1,
                traveler1,
                collaborator1,
                LocalDateTime.of(2018, 12, 22, 9, 00),
                190, true, false, "test"
        );
        Tour tour2 = new Tour("tour2",
                place2,
                traveler2,
                collaborator2,
                LocalDateTime.of(2018, 12, 22, 9, 00),
                190, true, false, "test"
        );
        Tour tour3 = new Tour("tour3",
                place3,
                traveler3,
                collaborator3,
                LocalDateTime.of(2018, 12, 22, 9, 00),
                190, true, true, "test"
        );
        Tour tour4 = new Tour("tour4",
                place4,
                traveler4,
                collaborator4,
                LocalDateTime.of(2018, 12, 22, 9, 00),
                190, true, true, "test"
        );
        Tour tour5 = new Tour("tour5",
                place5,
                traveler5,
                collaborator5,
                LocalDateTime.of(2018, 12, 22, 9, 00),
                190, true, false, "test"
        );
        Tour tour6 = new Tour("tour6",
                place6,
                traveler6,
                collaborator6,
                LocalDateTime.of(2018, 12, 22, 9, 00),
                190, true, false, "test"
        );
        Tour tour7 = new Tour("tour7",
                place7,
                traveler7,
                collaborator7,
                LocalDateTime.of(2018, 12, 22, 9, 00),
                190, true, true, "test"
        );
        Tour tour8 = new Tour("tour8",
                place8,
                traveler8,
                null,
                LocalDateTime.of(2018, 12, 22, 9, 00),
                190, true, false, "test"
        );
        Tour tour9 = new Tour("tour9",
                place9,
                traveler9,
                collaborator9,
                LocalDateTime.of(2018, 12, 22, 9, 00),
                190, true, true, "test"
        );
        Tour tour10 = new Tour("tour10",
                place10,
                traveler10,
                null,
                LocalDateTime.of(2018, 12, 22, 9, 00),
                190, true, false, "test"
        );

        Tour tour11 = new Tour("tour11",
                place1,
                traveler5,
                null,
                LocalDateTime.now().plusDays(2),
                190,
                false,
                false,
                "Test tour"
        );
        Tour tour12 = new Tour("tour12",
                place2,
                traveler5,
                null,
                LocalDateTime.now().plusDays(5),
                190,
                false,
                false,
                "Test tour"
        );
        Tour tour13 = new Tour("tour12",
                place3,
                traveler5,
                null,
                LocalDateTime.now().plusDays(5),
                190,
                false,
                false,
                "Test tour"
        );
        Tour tour14 = new Tour("tour12",
                place4,
                traveler5,
                null,
                LocalDateTime.now().plusDays(5),
                190,
                false,
                false,
                "Test tour"
        );
        Tour tour15 = new Tour("tour12",
                place5,
                traveler5,
                null,
                LocalDateTime.now().plusDays(5),
                190,
                false,
                false,
                "Test tour"
        );
        Tour tour16 = new Tour("tour12",
                place6,
                traveler5,
                null,
                LocalDateTime.now().plusDays(5),
                190,
                false,
                false,
                "Test tour"
        );
        Tour tour17 = new Tour("tour12",
                place7,
                traveler5,
                null,
                LocalDateTime.now().plusDays(5),
                190,
                false,
                false,
                "Test tour"
        );
        Tour tour18 = new Tour("tour12",
                place8,
                traveler5,
                null,
                LocalDateTime.now().plusDays(5),
                190,
                false,
                false,
                "Test tour"
        );
        Tour tour19 = new Tour("tour12",
                place9,
                traveler5,
                null,
                LocalDateTime.now().plusDays(5),
                190,
                false,
                false,
                "Test tour"
        );
        Tour tour20 = new Tour("tour12",
                place10,
                traveler5,
                null,
                LocalDateTime.now().plusDays(5),
                190,
                false,
                false,
                "Test tour"
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
        mongoOperations.save(tour11);
        mongoOperations.save(tour12);
        mongoOperations.save(tour13);
        mongoOperations.save(tour14);
        mongoOperations.save(tour15);
        mongoOperations.save(tour16);
        mongoOperations.save(tour17);
        mongoOperations.save(tour18);
        mongoOperations.save(tour19);
        mongoOperations.save(tour20);

        Price price1 = new Price(TourGuideType.RESIDENT, 300);
        Price price2 = new Price(TourGuideType.STUDENT, 250);
        Price price3 = new Price(TourGuideType.FREELANCER, 400);
        Price price4 = new Price(TourGuideType.PROFESSOR, 500);

        mongoOperations.save(price1);
        mongoOperations.save(price2);
        mongoOperations.save(price3);
        mongoOperations.save(price4);

        TourRegisteringEntity entity1 = new TourRegisteringEntity(tour15, collaborator10);
        TourRegisteringEntity entity2 = new TourRegisteringEntity(tour16, collaborator10);
        TourRegisteringEntity entity3 = new TourRegisteringEntity(tour17, collaborator10);
        TourRegisteringEntity entity4 = new TourRegisteringEntity(tour18, collaborator10);
        TourRegisteringEntity entity5 = new TourRegisteringEntity(tour20, collaborator10);

        mongoOperations.save(entity1);
        mongoOperations.save(entity2);
        mongoOperations.save(entity3);
        mongoOperations.save(entity4);
        mongoOperations.save(entity5);
    }
    // TODO Add more data master. Upload image to firebase
}
