package com.sargentdisc.api;

import com.sargentdisc.service.DirectoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/search")
public class SearchController {

    @Autowired
    DirectoriesService directoriesService;

    //Sample endpoint http://localhost:8081/search/files?words=abc,cbd,efg
    @GetMapping("/files")
    public ResponseEntity<Set<String>> searchFiles(@RequestParam String words){
        Set<String> filesResponse =new HashSet<>();
        try {
            List<String> inputWords = Arrays.asList(words.split(","));
            filesResponse = directoriesService.searchFilesByWord(inputWords);
        }catch (IOException e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<Set<String>>(filesResponse, HttpStatus.OK);
    }
}
