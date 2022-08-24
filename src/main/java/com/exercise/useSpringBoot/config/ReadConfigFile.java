package com.exercise.useSpringBoot.config;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@ConfigurationProperties(prefix = "text")
@Data
public class ReadConfigFile {
    private List<String> config;
}
