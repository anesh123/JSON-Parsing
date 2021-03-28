package com.clubos.codechallenge.model;

import java.util.Collections;
import java.util.List;

public class LocationStatistics {
  private final List<String> busiestDays;
  private final List<String> mostPopularAgreements;
  private final List<String> mostPopularAgreementsOnBusiestDays;

  public LocationStatistics(final List<String> busiestDays,
      final List<String> mostPopularAgreements,
      final List<String> mostPopularAgreementsOnBusiestDays) {
    this.busiestDays = busiestDays;
    this.mostPopularAgreements = mostPopularAgreements;
    this.mostPopularAgreementsOnBusiestDays = mostPopularAgreementsOnBusiestDays;
  }

  public static class Builder {
    private List<String> busiestDays = Collections.emptyList();
    private List<String> mostPopularAgreements = Collections.emptyList();
    private List<String> mostPopularAgreementsOnBusiestDays = Collections.emptyList();

    public Builder() {
    }

    public Builder setBusiestDays(final List<String> busiestDays) {
      this.busiestDays = busiestDays;
      return this;
    }

    public Builder setMostPopularAgreements(final List<String> mostPopularAgreements) {
      this.mostPopularAgreements = mostPopularAgreements;
      return this;
    }

    public Builder setMostPopularAgreementsOnBusiestDays(
        final List<String> mostPopularAgreementsOnBusiestDays) {
      this.mostPopularAgreementsOnBusiestDays = mostPopularAgreementsOnBusiestDays;
      return this;
    }

    public LocationStatistics build() {
      return new LocationStatistics(busiestDays, mostPopularAgreements, mostPopularAgreementsOnBusiestDays);
    }
  }
}
