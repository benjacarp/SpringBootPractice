package web.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import web.App;
import web.dto.ExpenseDTO;
import web.service.ExpenseService;

import java.util.Arrays;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
public class ExpenseControllerTest {

    private MockMvc mvc;

    @Mock
    private ExpenseService serviceMock;

    @Before
    public void setup() {
        mvc = MockMvcBuilders.standaloneSetup(new ExpenseController(serviceMock)).build();
    }

    @Test
    public void findAllExpensesTest() throws Exception {
        ExpenseDTO e1 = new ExpenseDTO();
        e1.setTime("1200");
        e1.setDescription("compra en el super");
        e1.setQuantity(1);

        ExpenseDTO e2 = new ExpenseDTO();
        e2.setTime("1300");
        e2.setDescription("estacionamiento super");
        e2.setQuantity(1);

        when(serviceMock.findAll()).thenReturn(Arrays.asList(e1, e2));

        mvc.perform(MockMvcRequestBuilders
                .get("/expense/")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].time", is("1200")))
                .andExpect(jsonPath("$[0].description", is("compra en el super")))
                .andExpect(jsonPath("$[0].quantity", is(1)))
                .andExpect(jsonPath("$[1].time", is("1300")))
                .andExpect(jsonPath("$[1].description", is("estacionamiento super")))
                .andExpect(jsonPath("$[1].quantity", is(1)));

        verify(serviceMock,times(1)).findAll();
        verifyNoMoreInteractions(serviceMock);
    }

}
