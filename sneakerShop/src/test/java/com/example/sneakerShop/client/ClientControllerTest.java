package com.example.sneakerShop.client;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
class ClientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Sql("/ClientControllerTestData.sql")
    @Transactional
    @Test
    void findAll() throws Exception {

        MvcResult res =
                mockMvc.perform(get("/clients").accept(MediaType.APPLICATION_JSON))
                        .andReturn();

        JSONArray jsonArray = new JSONArray(res.getResponse().getContentAsString());

        JSONObject jsonObject = jsonArray.getJSONObject(0);
        Assertions.assertEquals(1, jsonObject.get("id"));
        Assertions.assertEquals("Pirabakaran", jsonObject.get("lastName"));
        Assertions.assertEquals("ano.pira@gmail.com", jsonObject.get("email"));

        Assertions.assertEquals(200, res.getResponse().getStatus());
    }

    @Sql("/ClientControllerTestData.sql")
    @Transactional
    @Test
    void deleteById() throws Exception {
        MvcResult res =
                mockMvc.perform(delete("/clients/3").accept(MediaType.APPLICATION_JSON))
                        .andReturn();

        Assertions.assertEquals(204, res.getResponse().getStatus());
    }
}