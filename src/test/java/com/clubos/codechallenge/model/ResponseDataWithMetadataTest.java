package com.clubos.codechallenge.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import java.io.IOException;
import java.util.Map;
import org.junit.jupiter.api.Test;

class ResponseDataWithMetadataTest {

  private final Moshi moshi = new Moshi.Builder().build();
  private final JsonAdapter<ResponseDataWithMetadata<HealthClubTypes, Location>> jsonAdapter = moshi.adapter(
        Types.newParameterizedType(ResponseDataWithMetadata.class, HealthClubTypes.class, Location.class));

  @Test
  public void testFromJson() throws IOException {
    String json = "{\"metadata\": {\"healthClubTypes\": {\"1\": \"Gym\", \"2\": \"Studio\"}}, \"data\": [{\"id\": 1, \"name\": \"BetterFitness\", \"healthClubType\": 1}, {\"id\": 2, \"name\": \"Planet Yoga\", \"healthClubType\": 2}]}";
    ResponseDataWithMetadata<HealthClubTypes, Location> result = jsonAdapter.fromJson(json);
    assertEquals(result.getMetadata().getHealthClubTypes().get(1), "Gym");
    assertEquals(result.getData().get(0).getId(), 1);
    assertEquals(result.getData().get(0).getName(), "BetterFitness");
    assertEquals(result.getData().get(0).getHealthClubType(), "1");

  }

  private static final class HealthClubTypes {
    private Map<Integer, String> healthClubTypes;

    public Map<Integer, String> getHealthClubTypes() {
      return healthClubTypes;
    }
  }

  private static final class Location {
    private Integer id;
    private String name;
    private String healthClubType;

    public int getId() {
      return id;
    }

    public String getName() {
      return name;
    }

    public String getHealthClubType() {
      return healthClubType;
    }
  }
}
