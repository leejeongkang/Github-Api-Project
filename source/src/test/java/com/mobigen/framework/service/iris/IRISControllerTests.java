package com.mobigen.framework.service.iris;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.mobigen.framework.iris.IRISProperties;
import com.mobigen.framework.iris.Token;
import com.mobigen.framework.test.AbstractRestDocTest;
import com.mobigen.sample.SampleApplication;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.ResultActions;

@ContextConfiguration(classes = SampleApplication.class)
public class IRISControllerTests extends AbstractRestDocTest {
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
    public void testStatus() throws Exception {
        // given
        String xAccessToken = getXAccessToken();

        // when
        ResultActions result = this.mockMvc
                .perform(get("/api/status").header(properties.getToken().getName(), xAccessToken));
        // then
        result.andExpect(status().isOk()).andDo(print());
    }

    @Test
    public void testRouteByLocale() throws Exception {
        // given
        String xAccessToken = getXAccessToken();

        // when
        ResultActions result = this.mockMvc
                .perform(get("/api/route").param("locale", "ko").header(properties.getToken().getName(), xAccessToken));
        // then
        result.andExpect(status().isOk()).andDo(print());
    }

    @Test
    public void testRoute() throws Exception {
        // given
        String xAccessToken = getXAccessToken();

        // when
        ResultActions result = this.mockMvc
                .perform(get("/api/route").header(properties.getToken().getName(), xAccessToken));
        // then
        result.andExpect(status().isOk()).andDo(print());
    }

    @Test
    public void testHeartbeat() throws Exception {
        // given
        String xAccessToken = getXAccessToken();

        // when
        ResultActions result = this.mockMvc
                .perform(get("/api/heartbeat").header(properties.getToken().getName(), xAccessToken));
        // then
        result.andExpect(status().isOk()).andDo(print());
    }
}
