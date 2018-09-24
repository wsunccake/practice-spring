# Mongo Setup

```mysql
// create database
> use rest_tutorial

// create collection
> db.createCollection("pet")

// create entity
> db.getCollection("pet").insertMany([
  {
    "name": "Spot",
    "species": "dog",
    "breed": "pitbull"
  },
  {
    "name": "Daisy",
    "species": "cat",
    "breed": "calico"
  },
  {
    "name": "Bella",
    "species": "dog",
    "breed": "australian shepard"
  }
])

// query
> db.pet.find({})
```


# Run Application

```bash
linux:~/db-mongo # gradle wrapper
linux:~/db-mongo # ./gradlew bootRun
```


# Test Web

```bash
linux:~ # curl http://localhost:8080/pet
```

