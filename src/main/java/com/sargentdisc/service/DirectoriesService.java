package com.sargentdisc.service;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public interface DirectoriesService {

    /**
     * find files where by multiple filenames
     * @param words
     * @return
     * @throws IOException
     */
    Set<String> searchFilesByWord(List<String> words) throws IOException;
}
