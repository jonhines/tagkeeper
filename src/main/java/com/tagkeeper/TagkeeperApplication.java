package com.tagkeeper;

import com.tagkeeper.entities.Course;
import com.tagkeeper.entities.Player;
import com.tagkeeper.entities.Tag;
import com.tagkeeper.entities.User;
import com.tagkeeper.repositories.CourseRepository;
import com.tagkeeper.repositories.PlayerRepository;
import com.tagkeeper.repositories.TagRepository;
import com.tagkeeper.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.geo.Point;

import java.util.Date;

@SpringBootApplication
public class TagkeeperApplication implements CommandLineRunner
{

    public static void main(String[] args)
    {
        SpringApplication.run(TagkeeperApplication.class, args);
    }

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public void run(String... args) throws Exception
    {

        playerRepository.deleteAll();

        /**
         *
         *
         *
         * USERS
         *
         *
         */

        User user = userRepository.findByUsername("squintz");
        if(user == null)
        {
            userRepository.save(new User("squintz","password"));
        }

        /**
         *
         *
         * PLAYERS
         *
         *
         */
        Player squintz = new Player("Squintz", "Hines", "Right", "Katana", 0);
        if(playerRepository.findByFirstName(squintz.getFirstName()) == null)
            playerRepository.save(squintz);

        tagRepository.save(new Tag(1, new Date(), squintz.getId()));

        Player kev = new Player("Kev", "Fox", "Right", "Mako", 4);
        if(playerRepository.findByFirstName(kev.getFirstName()) == null)
            playerRepository.save(kev);

        tagRepository.save(new Tag(3, new Date(), kev.getId()));

        Player ruddy = new Player("Eric", "Rudman", "Right", "Katana", 0);
        if(playerRepository.findByFirstName(ruddy.getFirstName()) == null)
            playerRepository.save(ruddy);

        tagRepository.save(new Tag(5, new Date(), ruddy.getId()));

        Player stevens = new Player("Ben", "Stevens", "Right", "Buzzz", 2);
        if(playerRepository.findByFirstName(stevens.getFirstName()) == null)
            playerRepository.save(stevens);

        tagRepository.save(new Tag(2, new Date(), stevens.getId()));

        Player danny = new Player("Danny", "Fox", "Right", "Roadrunner", 1);
        if(playerRepository.findByFirstName(danny.getFirstName()) == null)
            playerRepository.save(danny);
        tagRepository.save(new Tag(6, new Date(), danny.getId()));

        Player marky = new Player("Marky", "Sheppard", "Right", "Sidewinder", 0);
        if(playerRepository.findByFirstName(marky.getFirstName()) == null)
            playerRepository.save(marky);

        tagRepository.save(new Tag(4, new Date(), marky.getId()));

        /**
         *
         *
         * COURSES
         *
         *
         *
         */
        Point maplePoint = new Point(42.276061, -71.895286);
        Course mapleHill = new Course("Maple Hill", maplePoint);

        if(courseRepository.findByName(mapleHill.getName()) == null)
            courseRepository.save(mapleHill);

        Point barrePoint = new Point(42.427888, -72.0237);
        Course barre = new Course("Barre Falls Dam", barrePoint);

        if(courseRepository.findByName(barre.getName()) == null)
            courseRepository.save(barre);

        Point buffPoint = new Point(42.119511,-71.904941);
        Course buff = new Course("Buffumville Dam", buffPoint);

        if(courseRepository.findByName(buff.getName()) == null)
            courseRepository.save(buff);

        Point wThomp = new Point(41.954578,-71.903083);
        Course thomp = new Course("West Thompson Lake", wThomp);

        if(courseRepository.findByName(thomp.getName()) == null)
            courseRepository.save(thomp);
    }

}
