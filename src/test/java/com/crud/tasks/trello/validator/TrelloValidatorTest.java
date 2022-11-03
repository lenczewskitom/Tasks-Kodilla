package com.crud.tasks.trello.validator;

import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloCard;
import com.crud.tasks.domain.TrelloList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TrelloValidatorTest {

    @Autowired
    private TrelloValidator trelloValidator;

    @Test
    void testValidateTrelloBoards() {
        // Given

        List<TrelloList> lists = new ArrayList<>();
        lists.add(new TrelloList("1234", "listName", false));

        List<TrelloBoard> trelloBoard = new ArrayList<>();
        trelloBoard.add(new TrelloBoard("4321", "boardName", lists));
        // When
        List<TrelloBoard> validateTrelloBoardList = trelloValidator.validateTrelloBoards(trelloBoard);
        //Then
        assertEquals(1, validateTrelloBoardList.size());
    }
}