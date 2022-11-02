package com.crud.tasks.mapper;


import com.crud.tasks.domain.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class MapperTest {

    @Autowired
    private TrelloMapper trelloMapper;

    @Test
    void testMapToBoards() {
        // Given
        List<TrelloListDto> lists = new ArrayList<>();
        lists.add(new TrelloListDto("1234", "testList", false));

        List<TrelloBoardDto> trelloBoardDto = new ArrayList<>();
        trelloBoardDto.add(new TrelloBoardDto("4321", "testBoard", lists));
        // When
        List<TrelloBoard> boardList = trelloMapper.mapToBoards(trelloBoardDto);
        // Then
        assertEquals("4321", boardList.get(0).getId());
        assertEquals("testBoard", boardList.get(0).getName());
        assertEquals(1, boardList.get(0).getLists().size());
    }

    @Test
    void testMapToBoardsDto() {
        // Given
        List<TrelloList> lists = new ArrayList<>();
        lists.add(new TrelloList("1234", "testList", false));

        List<TrelloBoard> trelloBoard = new ArrayList<>();
        trelloBoard.add(new TrelloBoard("4321", "testBoard", lists));
        // When
        List<TrelloBoardDto> boardListDto = trelloMapper.mapToBoardsDto(trelloBoard);
        // Then
        assertEquals("4321", boardListDto.get(0).getId());
        assertEquals("testBoard", boardListDto.get(0).getName());
        assertEquals(1, boardListDto.get(0).getLists().size());
    }

    @Test
    void testMapToList() {
        // Given
        List<TrelloListDto> lists = new ArrayList<>();
        lists.add(new TrelloListDto("1234", "testList", false));
        // When
        List<TrelloList> trelloLists = trelloMapper.mapToList(lists);
        // Then
        assertEquals("1234", trelloLists.get(0).getId());
        assertEquals("testList", trelloLists.get(0).getName());
        assertEquals(false, trelloLists.get(0).isClosed());
    }

    @Test
    void testMapToListDto() {
        // Given
        List<TrelloList> lists = new ArrayList<>();
        lists.add(new TrelloList("1234", "testList", false));
        // When
        List<TrelloListDto> trelloLists = trelloMapper.mapToListDto(lists);
        // Then
        assertEquals("1234", trelloLists.get(0).getId());
        assertEquals("testList", trelloLists.get(0).getName());
        assertEquals(false, trelloLists.get(0).isClosed());
    }

    @Test
    void testMapToCard() {
        // Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("testCard", "testDescription", "testPos", "1234");
        // When
        TrelloCard trelloCard = trelloMapper.mapToCard(trelloCardDto);
        // Then
        assertEquals("testCard", trelloCard.getName());
        assertEquals("testDescription", trelloCard.getDescription());
        assertEquals("testPos", trelloCard.getPos());
        assertEquals("1234", trelloCard.getListId());
    }

    @Test
    void testMapToCardDto() {
        // Given
        TrelloCard trelloCard = new TrelloCard("testCard", "testDescription", "testPos", "1234");
        // When
        TrelloCardDto trelloCardDto = trelloMapper.mapToCardDto(trelloCard);
        // Then
        assertEquals("testCard", trelloCardDto.getName());
        assertEquals("testDescription", trelloCardDto.getDescription());
        assertEquals("testPos", trelloCardDto.getPos());
        assertEquals("1234", trelloCardDto.getListId());
    }
}
