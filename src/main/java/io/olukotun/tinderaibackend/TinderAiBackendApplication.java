package io.olukotun.tinderaibackend;

import io.olukotun.tinderaibackend.conversations.ChatMessage;
import io.olukotun.tinderaibackend.conversations.Conversation;
import io.olukotun.tinderaibackend.conversations.ConversationRepository;
import io.olukotun.tinderaibackend.profiles.Gender;
import io.olukotun.tinderaibackend.profiles.Profile;
import io.olukotun.tinderaibackend.profiles.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class TinderAiBackendApplication implements CommandLineRunner {

    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private ConversationRepository conversationRepository;
    public static void main(String[] args) {
        SpringApplication.run(TinderAiBackendApplication.class, args);
    }
    public void run(String... args)  {
        conversationRepository.deleteAll();
        profileRepository.deleteAll();
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
        Profile profile2 = new Profile(
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
        profileRepository.save(profile2);
        profileRepository.findAll().forEach(System.out::println);

        Conversation conversation = new Conversation(
                "1",
                profile.id(),
                List.of(new ChatMessage("Hello",profile.id(), LocalDateTime.now())));

       conversationRepository.save(conversation);
       conversationRepository.findAll().forEach(System.out::println);
    }

}
