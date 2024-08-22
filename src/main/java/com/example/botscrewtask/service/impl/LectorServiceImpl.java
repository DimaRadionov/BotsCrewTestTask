package com.example.botscrewtask.service.impl;

import com.example.botscrewtask.model.Lector;
import com.example.botscrewtask.repository.LectorRepository;
import com.example.botscrewtask.service.LectorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LectorServiceImpl implements LectorService {
    private final LectorRepository lectorRepository;

    public String globalSearch(String template) {
        List<Lector> lectors = lectorRepository.findByNameContaining(template);
        return lectors.stream()
                .map(Lector::getName)
                .collect(Collectors.joining(", "));
    }
}
