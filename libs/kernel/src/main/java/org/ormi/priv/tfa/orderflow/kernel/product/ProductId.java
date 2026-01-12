package org.ormi.priv.tfa.orderflow.kernel.product;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;

/**
 * This record represents a unique identifier for a Product.
 */

public record ProductId(@NotNull UUID value) {
    public static ProductId newId() {
        return new ProductId(UUID.randomUUID());
    }
}
