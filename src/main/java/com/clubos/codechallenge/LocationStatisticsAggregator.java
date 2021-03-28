package com.clubos.codechallenge;

import com.clubos.codechallenge.adapter.ZonedDateTimeUTCAdapter;
import com.clubos.codechallenge.model.LocationStatistics;
import com.clubos.codechallenge.repository.MemberAgreementRepo;
import com.clubos.codechallenge.repository.MemberCheckinsRepository;
import com.clubos.codechallenge.service.LocationStatisticsService;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import io.javalin.Javalin;
import okhttp3.OkHttpClient;




public class LocationStatisticsAggregator {

  // Third party services
  private static final OkHttpClient client = new OkHttpClient.Builder().build();
  private static final Moshi moshi = new Moshi.Builder().add(new ZonedDateTimeUTCAdapter()).build();

  // Repositories
  private static final MemberCheckinsRepository memberCheckinsRepository = new MemberCheckinsRepository(client, moshi);
  private static final MemberAgreementRepo memberAgreementRepo = new MemberAgreementRepo(client,moshi);


  // TODO: declare other repositories...

  // Service(s)
  private static final LocationStatisticsService locationStatisticsService = new LocationStatisticsService();

  // Server and controllers - typically, these things would deserve their own classes
  // We've kept this implementation simple
  public static void main(String... args)  {

    JsonAdapter<LocationStatistics> locationStatisticsAdapter = moshi.adapter(LocationStatistics.class);

    Javalin app = Javalin.create().start(7000);

    // Health check
    app.get("/", ctx -> ctx.result("OK"));

    // TODO: Implement statistic resolution

    app.get("/locations/:id/stats", (ctx) -> {
      String id = ctx.pathParam("id");
      LocationStatistics locationStatistics = new LocationStatistics(
              locationStatisticsService.resolveBusiestDaysOfWeek(memberCheckinsRepository.fetchAllByLocationId(id)),
              locationStatisticsService.resolveMostPopularAgreements(memberAgreementRepo.fetchAllByLocationId(id)),
              locationStatisticsService.resolveMostPopularAgreementsOnBd(memberAgreementRepo.fetchAllByLocationId(id),memberCheckinsRepository.fetchAllByLocationId(id))
              );

      String jsonResponse = locationStatisticsAdapter.toJson(locationStatistics);
      ctx.result(jsonResponse);
    });
  }
}
