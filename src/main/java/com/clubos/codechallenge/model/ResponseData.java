package com.clubos.codechallenge.model;

import java.util.List;

/**
 * Used for extracting data out of the `data` key from an HTTP response
 *
 * For example:
 * {
 *   "data": [{ <-- ResponseData provides serialization/deserialization for this key
 *     "id": 1,
 *     "name": "BetterFitness"
 *   }, {
 *     "id": 2,
 *     "name": "Planet Yoga"
 *   }]
 * }
 */
public class ResponseData<T> {

  private List<T> data;
  public List<T> getData() {
    return data;
  }
}
