# Java Code Challenge - 2020

In this code challenge, you'll demonstrate your programming abilities by building an aggregate service. We expect the challenge to take you about two hours.

### Getting Started

You'll need the following before starting:
* An IDE (for example, [IntelliJ IDEA Community Edition](https://www.jetbrains.com/idea/download))
* [Java SE JDK 8+](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* [Maven](https://maven.apache.org/install.html) for managing and building the project

Clone, bootstrap and run the project:

```
$ git clone git@github.com:TechniqueSoftware/code-challenge-2019.git
$ # cd into desired project
$ # to build and run from the command line, use the following commands
$ mvn install
$ mvn exec:java -e
```

A server should now be running on your machine at [http://localhost:7000](http://localhost:7000).

### Instructions

The product team would like you to create an aggregate service that returns statistics for a health club location. This service will hypothetically be used by a front-end team to build a dashboard for club owners that will help them decide when to run promotions for membership agreements. The success of a promotion relies on check-in volume and the popularity of a membership agreement.

We've already set up some of the aggregate's architecture. This project is using the following libraries:

* [OkHttp](https://github.com/square/okhttp): HTTP Client
* [Javalin](https://javalin.io/): HTTP Server using Jetty
* [Moshi](https://github.com/square/moshi): JSON Serializer/Deserializer

Here's a sample OkHttp client request implementation: [OkHttpContributors.java](https://github.com/square/okhttp/blob/master/samples/simple-client/src/main/java/okhttp3/sample/OkHttpContributors.java)

#### Functionality

Implement an endpoint that meets the specifications below. **Functionality is the highest priority**.

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

To develop the endpoint, request data from an API for one of our mock clients.

* `GET locations`
* `GET locations/{locationId}/member-checkins`
* `GET locations/{locationId}/member-agreements`
* The API is under [https://code-challenge-api.club-os.com/api](https://code-challenge-api.club-os.com/api)
    * Example: [https://code-challenge-api.club-os.com/api/locations/1/member-checkins](https://code-challenge-api.club-os.com/api/locations/1/member-checkins)
    
#### Testing

Our engineering team uses testing to prevent bugs and fuel a culture of confidence and trust. To keep this code challenge short, we don't require that you write tests. However, JUnit has been provided if you'd like to use it to check your answers. To run tests from the command line, use:

```
$ mvn surefire:test
```

### If you have questions...

We can't guarantee equal availability for all candidates during the code challenge. To be fair, no questions will be answered. If you have a question, please send it with your submission.

### Submission

When you've completed the code challenge, remove any IDE directories and the `target` directory, zip the project and attach it in a response to the code challenge email. Please share any notes on your code or how you think the challenge went!

### Evaluation

What are we looking for in your submission? We'll be evaluating submissions in this order:

* Functional API (no compile or runtime exceptions)
* Clear, well written and structured code
* Amount of criteria met
