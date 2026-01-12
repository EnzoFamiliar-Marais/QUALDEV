package org.ormi.priv.tfa.orderflow.cqrs.infra.persistence;

import java.util.List;

import org.ormi.priv.tfa.orderflow.cqrs.infra.jpa.OutboxEntity;

/**
 * This interface defines the contract for an Outbox Repository,
 * responsible for managing outbox entries for reliable event delivery.
 */

public interface OutboxRepository {
    void publish(OutboxEntity entity);
    List<OutboxEntity> fetchReadyByAggregateTypeOrderByAggregateVersion(String aggregateType, int limit, int maxRetries);
    void delete(OutboxEntity entity);
    void markFailed(OutboxEntity entity, String err);
    void markFailed(OutboxEntity entity, String err, int retryAfter);
}
