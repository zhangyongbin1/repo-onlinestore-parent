package com.zhangyongbin.onlinestore;


import com.zhangyongbin.onlinestore.common.utils.JsonUtils;
import com.zhangyongbin.onlinestore.pojo.TbContent;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RepoOnlinestoreManagerWebApplication.class)
public class RepoOnlinestoreManagerWebApplicationTests {
    private MockMvc mockMvc; //模拟MVC对象，通过MockMvcBuilders.webAppContextSetup(this.wac).build()初始化
    //    @Autowired   
    //    private MockHttpSession session;// 注入模拟的http session   
    //    @Autowired    
    //     private MockHttpServletRequest request; // 注入模拟的http request
    @Autowired
    private WebApplicationContext wac;//注入webapplicationContext
    @Before //在测试开始前初始化工作
    public void setup(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }
    @Test
    public void test() throws Exception {
       MvcResult result;
        result = mockMvc.perform(post("/content/query/list").contentType(MediaType.APPLICATION_JSON_UTF8)
                .param("categoryId","89").param("page","1").param("rows","20"))
                .andExpect(status().isOk())
                .andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    public void testAddTbContent() throws Exception {
        TbContent tbContent = new TbContent();
        tbContent.setId(Long.valueOf(33));
        tbContent.setCategoryId(Long.valueOf(89));
        MvcResult result;
        result = mockMvc.perform(post("/content/save").contentType(MediaType.APPLICATION_JSON_UTF8)
                .param("id","33").param("categoryId","89").param("title","testtest"))
                .andExpect(status().isOk())
                .andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }

}
