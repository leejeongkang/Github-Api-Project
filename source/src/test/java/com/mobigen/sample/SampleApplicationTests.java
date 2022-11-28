package com.mobigen.sample;

import com.mobigen.framework.iris.IRISProperties;
import com.mobigen.framework.iris.Token;
import com.mobigen.framework.test.AbstractRestDocTest;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;

import javax.servlet.http.Cookie;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class SampleApplicationTests extends AbstractRestDocTest {
    @Autowired
    private Token token;

    @Autowired
    private IRISProperties properties;

    private String getXAccessToken() throws Exception {
        String username = properties.getTest().getBrickUsername();
        String password = properties.getTest().getBrickPassword();
        String xAccessToken = token.getXAccessToken(username, password);
        return xAccessToken;
    }

    @Test
    void testGetUser() throws Exception {
        // given
        String xAccessToken = getXAccessToken();

        // when
        ResultActions result = this.mockMvc.perform(get("/api/user").accept(MediaType.APPLICATION_JSON)
                .header(properties.getToken().getName(), xAccessToken));
        String content = result.andReturn().getResponse().getContentAsString();
        result.andExpect(status().isOk()).andDo(print());

        // then
        JSONAssert.assertEquals(this.expectedJsonResultStr, content, false);
    }

    @Test
    void testGetusername() throws Exception {
        // given
        String xAccessToken = getXAccessToken();
        String username = "root";

        // when
        ResultActions result = this.mockMvc.perform(get("/api/user/{username}", username)
                .accept(MediaType.APPLICATION_JSON).header(properties.getToken().getName(), xAccessToken));
        String content = result.andReturn().getResponse().getContentAsString();
        result.andExpect(status().isOk()).andDo(print());

        // then
        JSONAssert.assertEquals(this.expectedJsonResultStr, content, false);
    }

    @Test
    void testLocale() throws Exception {
        // TEST ENGLISH =====================
        // given
        Cookie cookie = new Cookie("locale", "en");
        String xAccessToken = getXAccessToken();

        // when
        ResultActions result = this.mockMvc.perform(get("/api/message").accept(MediaType.APPLICATION_JSON)
                .cookie(cookie).header(properties.getToken().getName(), xAccessToken).session(this.mockSession));
        String content = result.andReturn().getResponse().getContentAsString();
        result.andExpect(status().isOk()).andDo(print());

        // then
        String en = this.getJsonResultData(content);
        assertEquals("TEST", en);

        // TEST KOREA =====================
        // given
        cookie = new Cookie("locale", "ko");

        // when
        result = this.mockMvc.perform(
                get("/api/message").accept(MediaType.APPLICATION_JSON).cookie(cookie).session(this.mockSession));
        content = result.andReturn().getResponse().getContentAsString();
        result.andExpect(status().isOk()).andDo(print());

        // then
        String ko = this.getJsonResultData(content);
        assertEquals("테스트", ko);
    }
}
