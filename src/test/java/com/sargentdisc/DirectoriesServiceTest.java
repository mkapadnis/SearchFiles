package com.sargentdisc;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.sargentdisc.service.impl.DirectoriesServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;

import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
public class DirectoriesServiceTest {

    @InjectMocks
    DirectoriesServiceImpl directoriesService;

    @Test
    public void testContext(){
        assertNotNull(directoriesService);
    }
    @Test
    public void testSearchFilesByWord() throws IOException {
        List<String> wordsTest = Arrays.asList("abc","efg");
        directoriesService.configuredDirectory = ".//FilesDirectory//";
        Set<String> files = directoriesService.searchFilesByWord(wordsTest);
        assertTrue(files.size()==2);
        assertTrue(files.stream().anyMatch(s->s.equalsIgnoreCase("abc.txt")));
        assertTrue(files.stream().anyMatch(s->s.equalsIgnoreCase("efg.txt")));
        assertFalse(files.stream().anyMatch(s->s.equalsIgnoreCase("pqrxyz.txt")));
    }
}
