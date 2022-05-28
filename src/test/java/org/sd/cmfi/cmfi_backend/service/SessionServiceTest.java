package org.sd.cmfi.cmfi_backend.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.sd.cmfi.cmfi_backend.dao.SessionRepository;
import org.sd.cmfi.cmfi_backend.entities.Session;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class SessionServiceTest {

    @Mock
    SessionRepository sessionRepository;
    @Mock
    Session session;



    SessionService sessionService ;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        sessionService = new SessionService(sessionRepository);
    }

    @Test
    public void create() throws Exception {
        // Given
        session = new Session( 4,"1 session" ,"Matematique",null,null);
        ResponseEntity<?> s1 = sessionService.create(session);

//        assertEquals(session,s1);
//        ResultActions result = mockMvc.perform(request);

//        mockMvc.perform(sessionService.create(session)
//                .getStatusCode(status().is(200));
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(sessionService).build();

        mockMvc.perform(post("/api/session").contentType(MediaType.APPLICATION_JSON)
                        .content("{\"json\":\"request to be send\"}"))
                        .andExpect(status().isOk());



    }
}
