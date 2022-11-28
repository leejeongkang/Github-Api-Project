package com.mobigen.sample;

import org.springframework.stereotype.Repository;

@Repository("sampleMapper")
public interface SampleMapper {
    Object getUser(String username) throws Exception;
}
