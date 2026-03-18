package org.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HelloRestController.class)
class HelloRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void greetingUsesDefaultNameWhenMissing() throws Exception {
        mockMvc.perform(get("/greeting"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello, World!"));
    }

    @Test
    void greetingUsesProvidedName() throws Exception {
        mockMvc.perform(get("/greeting").param("name", "AREP"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello, AREP!"));
    }

    @Test
    void helloAliasBehavesLikeGreeting() throws Exception {
        mockMvc.perform(get("/hello").param("name", "Docker"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello, Docker!"));
    }
}
