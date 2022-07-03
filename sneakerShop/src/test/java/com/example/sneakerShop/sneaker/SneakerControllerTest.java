package com.example.sneakerShop.sneaker;

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
class SneakerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Sql("/SneakerControllerTestData.sql")
    @Transactional
    @Test
    void findAll() throws Exception {
        MvcResult res =
                mockMvc.perform(get("/sneakers").accept(MediaType.APPLICATION_JSON))
                        .andReturn();

        JSONArray jsonArray = new JSONArray(res.getResponse().getContentAsString());

        JSONObject jsonObject = jsonArray.getJSONObject(1);
        Assertions.assertEquals(5, jsonObject.get("id"));
        Assertions.assertEquals("Air Jordan", jsonObject.get("brand"));
        Assertions.assertEquals(340.70, jsonObject.get("price"));

        Assertions.assertEquals(200, res.getResponse().getStatus());
    }

    @Sql("/SneakerControllerTestData.sql")
    @Transactional
    @Test
    void findById() throws Exception {
        MvcResult res =
                mockMvc.perform(get("/sneakers/7").accept(MediaType.APPLICATION_JSON))
                        .andReturn();

        JSONAssert.assertEquals(
                "{\"id\":7,\"name\":\"Yeezy 350 Cream\",\"description\":\"The new Yeezys\",\"image\":null,\"price\":250.4,\"brand\":\"Adidas Yeezy\"}",
                res.getResponse().getContentAsString(), JSONCompareMode.LENIENT);

        Assertions.assertEquals(302, res.getResponse().getStatus());
    }
}