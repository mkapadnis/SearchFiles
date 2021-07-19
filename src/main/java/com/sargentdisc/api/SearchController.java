package com.sargentdisc.api;

import com.sargentdisc.model.FilesResponse;
import com.sargentdisc.service.DirectoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("search")
public class SearchController {

    @Autowired
    DirectoriesService directoriesService;

    @GetMapping("/files")
    public ResponseEntity<List<FilesResponse>> searchFiles(@RequestParam String word){

        List<FilesResponse> filesResponse = null;

        filesResponse = directoriesService.searchFilesByWord(word);

        return new ResponseEntity<List<FilesResponse>>(filesResponse, HttpStatus.OK);
    }
}
