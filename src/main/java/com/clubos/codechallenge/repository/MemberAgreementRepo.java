package com.clubos.codechallenge.repository;
import com.clubos.codechallenge.model.*;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.List;

public class MemberAgreementRepo {

    private final OkHttpClient client;
    private final JsonAdapter<ResponseDataWithMetadata<MemberAgreeTypes,MemberAgreements>> memberAgreementAdaptor;

    public MemberAgreementRepo(final OkHttpClient client, final Moshi moshi) {
        this.client = client;
        this.memberAgreementAdaptor = moshi.adapter(Types.newParameterizedType(ResponseDataWithMetadata.class,MemberAgreeTypes.class,MemberAgreements.class));

    }

    public List<MemberAgreements> fetchAllByLocationId(final String locationId) throws IOException {
        Request request = new Request.Builder()
                .url("https://code-challenge-api.club-os.com/api/locations/"+locationId+"/member-agreements")
                .build();
        try(Response responseData = client.newCall(request).execute()){
            if(!responseData.isSuccessful()) throw new IOException("Unexpected code "+responseData);
            ResponseDataWithMetadata<MemberAgreeTypes,MemberAgreements> resp = memberAgreementAdaptor.fromJson(responseData.body().source());

            MemberAgreeTypes metaData = resp.getMetadata();
            List<MemberAgreements> memberAgreementData = resp.getData();
            for (MemberAgreements memberAgreementDatum : memberAgreementData) {
                Integer agreementId = memberAgreementDatum.getAgreement();
                String agreementType = metaData.getAgreementTypes().get(agreementId);
                memberAgreementDatum.setAgreementType(agreementType);
            }

            return  memberAgreementData;
        }
    }
}
