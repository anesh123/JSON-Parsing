package com.clubos.codechallenge.model;

import java.time.ZonedDateTime;

/**
 * Example JSON:
 * {
 *   "memberId": 705,
 *   "date": "2018-03-11T00:23:14.837Z"
 * }
 */
public class MemberCheckin {

  private Integer memberId;
  private ZonedDateTime date;

  public Integer getMemberId() {
    return memberId;
  }

  public ZonedDateTime getDate() {
    return date;
  }
}
