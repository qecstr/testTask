package com.example.testtask.Controllers;

import com.example.testtask.Controller.mongoDbController;
import com.example.testtask.Service.serviceMongoDb;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.web.servlet.function.RequestPredicates.contentType;


@WebMvcTest(mongoDbController.class)
public class mongoDbControllerTest {
    @Autowired
    private MockMvc mvc;
    @MockBean
    private serviceMongoDb s;

    @Test
    public void testSave() throws Exception{
        var request = post("/mongo/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                        {
                            "ID": 3,
                            "name": "Arsen",
                            "phoneNumber": 87185453215,
                            "secondNumber": 87775219356,
                            "dateOfBirth": "02.02.02"
                        }
                        """);

        // when
        this.mvc.perform(request)
                // then
                .andExpectAll(
                        status().isCreated(),
                        content().string("Phone is created")


                );
    }
}
