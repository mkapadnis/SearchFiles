package com.sargentdisc.service;

import com.sargentdisc.model.FilesResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DirectoriesService {

    @Value( "${configured.parent.directory}" )
    String configuredDirectory="";

    List<FilesResponse> searchFilesByWord(String word);
}
