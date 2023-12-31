package com.example.gongu.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class NoteCriteria {
    private int page;
    private int amount;
    private Long senderNumber;
    private Long recieverNumber;

    public NoteCriteria() {
        this.page = 1;
        this.amount = 15;
    }
}
