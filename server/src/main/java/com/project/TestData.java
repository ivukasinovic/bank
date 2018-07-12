package com.project;

import com.project.config.Converter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by Ivan V. on 12-Jul-18
 */
@Component
public class TestData {


    public TestData() {
    }

    @PostConstruct
    private void init() {
        Converter conv = new Converter();
    }

}