package com.betrybe.museumfinder.solution;

import static org.hamcrest.Matchers.hasItems;

import com.betrybe.museumfinder.dto.CollectionTypeCount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class CollectionTypeControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @DisplayName("getCollectionTypesCount retorna status ok e tem body")
  @Test
  void getCollectionTypesCountIsOkAndHaveBody() throws Exception {
    CollectionTypeCount body = new CollectionTypeCount(new String[]{"hist", "imag"}, 492);

    mockMvc.perform(MockMvcRequestBuilders.get("/collections/count/hist,imag"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(
            MockMvcResultMatchers.jsonPath("$.collectionTypes", hasItems(body.collectionTypes())))
        .andExpect(MockMvcResultMatchers.jsonPath("$.count").value(492));
  }

  @DisplayName("getCollectionTypesCount retorna status NOT FOUND")
  @Test
  void getCollectionTypesCountIsNotFound() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/collections/count/qualquer coisa"))
        .andExpect(MockMvcResultMatchers.status().isNotFound());
  }

  @DisplayName("getMuseusByIdIsNotFound retorna status ok e tem body")
  @Test
  void getMuseumIsOkAndHaveBody() throws Exception {
    String expectedJson = "{"
        + "\"id\": 1,"
        + "\"name\": \"Museu Casa Memória dos Ex-Combatentes da Segunda Guerra Mundial\","
        + "\"description\": \"Preservação da memória dos ex-combatentes da Segunda Guerra.\","
        + "\"address\": \"SGAN 913, s/n, conjunto F , Asa Norte, 70790-130, Brasília, DF\","
        + "\"collectionType\": \"História\","
        + "\"subject\": \"História\","
        + "\"url\": \"\","
        + "\"coordinate\": {\"latitude\": -15.75063, \"longitude\": -47.9001824}"
        + "}";

    mockMvc.perform(MockMvcRequestBuilders.get("/museums/1"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().json(expectedJson));
  }

  @DisplayName("getMuseusByIdIsNotFound retorna status NotFound")
  @Test
  void getMuseumIsNotFound() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/museums/10000"))
        .andExpect(MockMvcResultMatchers.status().isNotFound());
  }
}