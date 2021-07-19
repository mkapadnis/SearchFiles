package com.sargentdisc;

import com.sargentdisc.api.SearchController;
import com.sargentdisc.service.impl.DirectoriesServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.Collections;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class SearchControllerTest {

    @InjectMocks
    SearchController searchController;

    @Mock
    DirectoriesServiceImpl directoriesService;

    @Test
    public void testContext(){
        assertNotNull(searchController);
        assertNotNull(directoriesService);
    }

    @Test
    public void tesSearchFilesAPI() throws IOException {
        Mockito.when(directoriesService.searchFilesByWord(ArgumentMatchers.any())).thenReturn(Collections.emptySet());
        ResponseEntity<Set<String>>  responseEntity = searchController.searchFiles("abc,cde");
        assertTrue(responseEntity.getStatusCodeValue() == 200);
    }
}
