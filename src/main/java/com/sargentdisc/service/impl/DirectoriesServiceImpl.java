package com.sargentdisc.service.impl;

import com.sargentdisc.model.FilesResponse;
import com.sargentdisc.service.DirectoriesService;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
public class DirectoriesServiceImpl implements DirectoriesService {

    @Override
    public List<FilesResponse> searchFilesByWord(String word) {
        List<FilesResponse> filesResponses =  new ArrayList<>();
        configuredDirectory.getBytes(StandardCharsets.UTF_8);
        return filesResponses;
    }
}
