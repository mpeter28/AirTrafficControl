# Air Traffic Control - Toy Coding Problem #

This solution was made with SpringBoot in Java and uses Maven to handle building and dependency management. To build this project, checkout the source code and from the command line run

     mvn clean package

The produced project jar will be in a newly made ./target folder. I did not build a UI.

## Running as an API Server ##

Once packaged into a jar, the server can be run on localhost:8080 with

     java -jar target/AirTrafficControl-1.0.jar

## Interacting wih the API ##

The API supports two GET calls and one POST call with three options

### Status Tracking (GET) ###

Returns true if the air traffic queue has been started, false otherwise

    curl localhost:8080/airTraffic/started

Returns all enqueued aircarft, their properties, and their insertion time in the queue order

    curl localhost:8080/airTraffic/queue

### Modifying the Queue (POST) ###

Starts the queue

    curl -H "Content-Type: application/json" -X POST -d '{"type":"startQueue"}' http://localhost:8080/airTraffic/request

Enqueues a new aircraft in the queue

    curl -H "Content-Type: application/json" -X POST -d '{"type":"enqueue", "airCraft": { "type":"Passenger", "size":"Large", "properties": { "foo":"bar" } } }' http://localhost:8080/airTraffic/request

Dequeues the highest priority aircraft from the queue, returning the type, size, and any custom properties of the air craft (empty queues produce empty responses)

    curl -H "Content-Type: application/json" -X POST -d '{"type":"dequeue"}' http://localhost:8080/airTraffic/request