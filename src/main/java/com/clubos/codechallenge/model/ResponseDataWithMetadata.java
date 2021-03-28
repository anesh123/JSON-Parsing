package com.clubos.codechallenge.model;

/**
 * Used for extracting data and metadata out of a JSON HTTP response
 *
 * For example:
 * {
 *   "metadata": { <-- ResponseDataWithMetadata provides serialization/deserialization for this key
 *     "healthClubTypes": {
 *       "1": "Gym",
 *       "2": "Studio"
 *     }
 *   },
 *   "data": [{ <-- ResponseData provides serialization/deserialization for this key
 *     "id": 1,
 *     "name": "BetterFitness",
 *     "healthClubType": 1
 *   }, {
 *     "id": 2,
 *     "name": "Planet Yoga",
 *     "healthClubType": 2
 *   }]
 * }
 */
public class ResponseDataWithMetadata<S, T> extends ResponseData<T> {
  private S metadata;

  public S getMetadata() {
    return metadata;
  }
}
