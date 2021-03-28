package com.clubos.codechallenge.adapter;

import com.squareup.moshi.FromJson;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.ToJson;
import java.io.IOException;
import java.time.ZoneId;
import java.time.ZonedDateTime;

// Adapter for Moshi to understand how to serialize/deserialize ZonedDateTime in Coordinated Universal Time
public class ZonedDateTimeUTCAdapter {
  private static final ZoneId UTC = ZoneId.of("Z");

  @FromJson
  public ZonedDateTime fromJson(JsonReader reader) throws IOException {
    final String string = reader.nextString();
    return string != null ? ZonedDateTime.parse(string) : null;
  }

  @ToJson
  public void toJson(JsonWriter writer, ZonedDateTime value) throws IOException {
    final String string = value != null ? value.withZoneSameInstant(UTC).toString() : null;
    writer.value(string);
  }
}
