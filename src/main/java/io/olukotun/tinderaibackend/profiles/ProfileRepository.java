package io.olukotun.tinderaibackend.profiles;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProfileRepository extends MongoRepository<Profile, String> {
}