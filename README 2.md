

### Getting Started

You'll need the following before starting:
* An IDE (for example, [IntelliJ IDEA Community Edition](https://www.jetbrains.com/idea/download))
* [Java SE JDK 8+](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* [Maven](https://maven.apache.org/install.html) for managing and building the project

##Libraries used

* [OkHttp](https://github.com/square/okhttp): HTTP Client
* [Javalin](https://javalin.io/): HTTP Server using Jetty
* [Moshi](https://github.com/square/moshi): JSON Serializer/Deserializer

Here's a sample OkHttp client request implementation: [OkHttpContributors.java](https://github.com/square/okhttp/blob/master/samples/simple-client/src/main/java/okhttp3/sample/OkHttpContributors.java)

#### Functionality

Endpoint that meets the specifications below. 

* `GET {API_URL}/locations/{locationId}/stats` returns JSON that contains the following:
    * A stat of the busiest day(s) of the week (Sunday, Monday, etc.) for the specified location
    * A stat of the most popular agreement(s) for the specified location
    * A stat of the most popular agreement(s) on the busiest day(s) of the week for the specified location
    * Note: If there's a tie for any stat, show both/all results

Here is an example response:

```json
{
  "busiestDays": [
    "Monday",
    "Tuesday"
  ],
  "mostPopularAgreements": [
    "PLATINUM"
  ],
  "mostPopularAgreementsOnBusiestDays": [
    "BASIC"
  ]
}
```

#### Data

To develop the endpoint, I requested data from an API containing mock data from a mock client

* `GET locations`
* `GET locations/{locationId}/member-checkins`
* `GET locations/{locationId}/member-agreements`
* The API is under [https://code-challenge-api.club-os.com/api](https://code-challenge-api.club-os.com/api)
    * Example: [https://code-challenge-api.club-os.com/api/locations/1/member-checkins](https://code-challenge-api.club-os.com/api/locations/1/member-checkins)
    



