package com.sargentdisc.service.impl;

import com.sargentdisc.service.DirectoriesService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class DirectoriesServiceImpl implements DirectoriesService {


    @Value( "${configured.parent.directory}" )
    public String configuredDirectory;

    @Override
    public Set<String> searchFilesByWord(List<String> words) throws IOException {
         Set<String>  filenames = listFiles(configuredDirectory,Integer.MAX_VALUE);
         return filenames.stream().filter(s -> (words.stream().filter(d->s.contains(d))
        .count())>0).collect(Collectors.toSet());
    }

    /**
     * return file names from directory and sub directories.
     * @param dir
     * @param depth
     * @return Set<String>.
     * @throws IOException
     */
    private Set<String> listFiles(String dir, int depth) throws IOException {
        try (Stream<Path> stream = Files.walk(Paths.get(dir), depth)) {
            return stream
                    .filter(file -> !Files.isDirectory(file))
                    .map(Path::getFileName)
                    .map(Path::toString)
                    .collect(Collectors.toSet());
        }
    }
}
