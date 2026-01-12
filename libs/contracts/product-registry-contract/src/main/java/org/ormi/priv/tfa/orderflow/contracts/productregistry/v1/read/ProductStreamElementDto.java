package org.ormi.priv.tfa.orderflow.contracts.productregistry.v1.read;

import java.time.Instant;

/**
 * This DTO represents a stream element for product events, containing the type of event,
 * the product ID, and the time the event occurred.
 */

public record ProductStreamElementDto(
    String type,
    String productId,
    Instant occuredAt
) {
}
