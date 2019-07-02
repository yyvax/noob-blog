package com.nooblog.properties;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BlogProperties {

    @Getter
    @Value("${com.nooblog.name}")
    private String name;

    @Getter
    @Value("${com.nooblog.title}")
    private String title;


}
