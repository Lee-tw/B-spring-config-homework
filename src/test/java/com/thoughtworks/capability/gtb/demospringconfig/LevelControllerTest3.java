package com.thoughtworks.capability.gtb.demospringconfig;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@TestPropertySource(properties = "levelNumber=2")
class LevelControllerTest3 {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void should_return_basic_when_levelNumber_is_less_than_1() throws Exception {
        String result = mockMvc.perform(get("/level"))
                .andReturn()
                .getResponse()
                .getContentAsString();
        assertEquals("advanced", result);
    }
}
