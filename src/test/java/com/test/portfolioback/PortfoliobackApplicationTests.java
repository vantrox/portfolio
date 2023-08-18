package com.test.portfolioback;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.portfolioback.controller.PortfolioController;
import com.test.portfolioback.entities.Portfolio;
import com.test.portfolioback.exception.NotFoundException;
import com.test.portfolioback.model.PortfolioModel;
import com.test.portfolioback.repository.PortfolioRepository;
import com.test.portfolioback.services.PortfolioService;
import java.util.Optional;
import javax.ws.rs.core.MediaType;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 *
 * @author Robson J Silva <vantrox@yahoo.com.br>
 */
@WebMvcTest(PortfolioController.class)
class PortfoliobackApplicationTests {
    
    @Autowired
    MockMvc mockMvc;
    
    @Autowired
    ObjectMapper mapper;
    
    @MockBean
    PortfolioService portfolioService;
    
    @MockBean
    PortfolioRepository portfolioRepository;
    
    Portfolio RECORD_1 = new Portfolio(999L, "TEST", "TEST");
    Portfolio RECORD_2 = new Portfolio(998L, "TEST2", "TEST2");
    Portfolio RECORD_3 = new Portfolio(997L, "TEST3", "TEST3");
    
    @Test
    public void shouldReturnExistingPortfolio() throws Exception {
        Mockito.when(portfolioRepository.findById(RECORD_1.getId())).thenReturn(Optional.of(RECORD_1));
        Mockito.when(portfolioService.get(RECORD_1.getId())).thenReturn(new PortfolioModel().entityToModel(RECORD_1));
        
        mockMvc.perform(MockMvcRequestBuilders
                .get("/portfolio/999")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.title", is("TEST")));
    }
    
    @Test
    public void shouldReturnNotFoundForNonExistingPortfolio() throws Exception {
        Mockito.when(portfolioService.get(999L)).thenThrow(new NotFoundException());
        
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.get("/portfolio/999")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);
        
        mockMvc.perform(mockRequest)
                .andExpect(status().is(404));
    }
    
    @Test
    public void shouldUpdatePortfolio() throws Exception {
        PortfolioModel updatedRecord = PortfolioModel.builder()
                .id(999L)
                .description("TESTUPDATE")
                .title("TESTUPDATE")
                .build();
        
        Mockito.when(portfolioRepository.findById(RECORD_1.getId())).thenReturn(Optional.of(RECORD_1));
        Mockito.when(portfolioService.update(updatedRecord)).thenReturn(updatedRecord);
        
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.put("/portfolio/update")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.mapper.writeValueAsString(updatedRecord));
        
        mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.title", is("TESTUPDATE")));
    }
}
