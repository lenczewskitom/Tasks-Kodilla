package com.crud.tasks.domain;

import lombok.Data;

import java.util.List;

@Data
public class BadgesDto {
    private int votes;
    private List<TrelloAttachmentsDto> trelloAttachments;
}
