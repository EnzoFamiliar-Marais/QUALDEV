package org.ormi.priv.tfa.orderflow.cqrs.infra.persistence;

import org.ormi.priv.tfa.orderflow.cqrs.EventEnvelope;
import org.ormi.priv.tfa.orderflow.cqrs.infra.jpa.EventLogEntity;

/**
 * This interface defines the contract for an Event Log Repository,
 * responsible for appending event log entries.
 */

public interface EventLogRepository {
    EventLogEntity append(EventEnvelope<?> eventLog);
}
