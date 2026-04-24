package dev.gunjan.splitwise.service.strategy;

import dev.gunjan.splitwise.dto.SettleUpTransactionResponseDTO;
import dev.gunjan.splitwise.model.Group;

public interface SettleUpStrategy {
    SettleUpTransactionResponseDTO settleUp(Group group);
}
