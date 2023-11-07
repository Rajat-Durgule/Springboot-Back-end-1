package com.app.repository.mongoDb;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.app.model.mongoDb.Sequence;

public interface SequenceRepository extends MongoRepository<Sequence, String> {
}
