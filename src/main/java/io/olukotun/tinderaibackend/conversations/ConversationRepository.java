package io.olukotun.tinderaibackend.conversations;

import org.springframework.data.repository.CrudRepository;

public interface ConversationRepository extends CrudRepository<Conversation, String> {
}
