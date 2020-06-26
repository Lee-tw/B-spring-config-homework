package com.thoughtworks.capability.gtb.demospringconfig;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
class LevelControllerTest {
    @Autowired
    private LevelController levelController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void should_return_basic_when_levelNumber_is_less_than_1() throws Exception {
        ReflectionTestUtils.setField(levelController, "levelNumber", 0);

        String result = mockMvc.perform(get("/level"))
                .andReturn()
                .getResponse()
                .getContentAsString();
        assertEquals("basic", result);
    }

    @Test
    public void should_return_advanced_when_levelNumber_is_1() throws Exception {
        ReflectionTestUtils.setField(levelController, "levelNumber", 1);

        String result = mockMvc.perform(get("/level"))
                .andReturn()
                .getResponse()
                .getContentAsString();
        assertEquals("advanced", result);
    }

    @Test
    public void should_return_advanced_when_levelNumber_is_greater_than_1() throws Exception {
        ReflectionTestUtils.setField(levelController, "levelNumber", 2);

        String result = mockMvc.perform(get("/level"))
                .andReturn()
                .getResponse()
                .getContentAsString();
        assertEquals("advanced", result);
    }
}
