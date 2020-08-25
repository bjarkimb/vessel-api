# A simple Vessel API

The API assumes input on the form:

```yaml
{
    "name": "Bismarck",
    "country": "Germany",
    "position": {
        "date": "1941-05-22T14:30:00.000+00:00",
        "latitude" : 64.549,
        "longitude" : -28.101,
        "speed": 30
    }
}
```

 For this example input the following is saved in the Mongodb:

```yaml
{
    "id": "5f44ccd5eb187a1a75b4e8ac",
    "name": "Bismarck",
    "position": {
        "date": "1941-05-22T14:30:00.000+00:00",
        "receivedDate": "2020-08-25T08:33:25.188+00:00",
        "latitude": 1.12659257886982,
        "longitude": -0.4904549731029265,
        "speed": 15.42
    }
}
```

The application can be tested on [heroku](https://damp-journey-33369.herokuapp.com/vessels).

I used Mongodb as I'm familiar with it and it seemed suitable to use a doocument based database to store an object with a nested object. I removed the connection to my Mongodb cluster so a new connection is needed to run the application locally.

I based my solution on two spring boot examples: [Building REST services with Spring](https://spring.io/guides/tutorials/rest/) and [Accessing Data with MongoDB](https://spring.io/guides/gs/accessing-data-mongodb/).
