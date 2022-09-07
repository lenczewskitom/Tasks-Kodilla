package com.crud.tasks.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BadgesDto {
    private int votes;
    private List<TrelloAttachmentsDto> attachmentsByType;
}
