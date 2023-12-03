package com.betrybe.museumfinder.solution;

import static org.hamcrest.Matchers.hasItems;

import com.betrybe.museumfinder.dto.CollectionTypeCount;
import com.betrybe.museumfinder.service.CollectionTypeService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class CollectionTypeControllerTest2 {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private CollectionTypeService service;

  @DisplayName("getCollectionTypesCount retorna status ok e tem body")
  @Test
  void getCollectionTypesCountIsOkAndHaveBody() throws Exception {

    Mockito.when(service.countByCollectionTypes("hist, imag"))
        .thenReturn(new CollectionTypeCount(new String[]{"hist", "imag"}, 492));

    mockMvc.perform(MockMvcRequestBuilders.get("/collections/count/hist, imag"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(
            MockMvcResultMatchers.jsonPath("$.collectionTypes", hasItems(new String[]{"hist", "imag"})))
        .andExpect(MockMvcResultMatchers.jsonPath("$.count").value(492));

    Mockito.verify(service).countByCollectionTypes("hist, imag");
  }


}
