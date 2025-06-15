package org.example;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface KotRepository extends MongoRepository<Kot, String> {
}
