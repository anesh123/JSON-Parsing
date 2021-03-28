package com.clubos.codechallenge.repository;

import com.clubos.codechallenge.model.MemberCheckin;
import com.clubos.codechallenge.model.ResponseData;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import java.io.IOException;
import java.util.List;


import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MemberCheckinsRepository {

  private final OkHttpClient client;
  private final JsonAdapter<ResponseData<MemberCheckin>> memberCheckinAdapter;
  public MemberCheckinsRepository(final OkHttpClient client, final Moshi moshi) {
    this.client = client;
    this.memberCheckinAdapter = moshi.adapter(Types.newParameterizedType(ResponseData.class, MemberCheckin.class));
  }

  // TODO: Implement API call and return data
  public List<MemberCheckin> fetchAllByLocationId(final String locationId) throws IOException {
    Request request = new Request.Builder()
            .url("https://code-challenge-api.club-os.com/api/locations/"+locationId+"/member-checkins")
            .build();
    try(Response responseData = client.newCall(request).execute()){
      if(!responseData.isSuccessful()) throw new IOException("Unexpected code " + responseData);
      ResponseData<MemberCheckin> resp = memberCheckinAdapter.fromJson(responseData.body().source());

      return resp.getData();

    }
  }
}
