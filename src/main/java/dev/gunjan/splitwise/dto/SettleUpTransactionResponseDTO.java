package dev.gunjan.splitwise.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SettleUpTransactionResponseDTO {
    private List<String> transactions;

}
