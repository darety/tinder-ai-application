package io.olukotun.tinderaibackend;

import io.olukotun.tinderaibackend.profile.Gender;
import io.olukotun.tinderaibackend.profile.Profile;
import io.olukotun.tinderaibackend.profile.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TinderAiBackendApplication implements CommandLineRunner {

    @Autowired
    private ProfileRepository profileRepository;
    public static void main(String[] args) {
        SpringApplication.run(TinderAiBackendApplication.class, args);
    }
    public void run(String... args) throws Exception {
        Profile profile = new Profile(
                "1",
                "olu",
                "olukotun",
                40,
                "Nigeria",
                Gender.MALE,
                "Software engineer",
                "olu.gpg",
                "joke"
        );
        profileRepository.save(profile);
        profileRepository.findAll().forEach(System.out::println);

    }

}
