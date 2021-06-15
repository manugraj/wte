# When-Then Engine

A straight forward rule engine build in spring-native with graalvm-native build


## Env Setup

Check out [BUILD](BUILD.md) document for setting up dev environment

# Build

- Build by running - `mvn -Pnative-image clean package`
- Binary as `target/wte`

# Test
- Go to target folder and
- Run `./wte -Dserver.port=8081` to verify the system running

# Docker build and exe
- Set docker memory to high value, since the compilation is AOT and requires greater memory
    - Check for error 137 - shows memory insufficiency
- Run `docker-compose build`
- Run `docker swarm init`
    - Note down the join-token
    - Run `docker swarm join-token` to get the token again
- Run `docker stack deploy -c dcoker-compose.yml re`

## Scale
- Run `docker service ls` -> find the running re service
- Run `docker service scale <service name>=3`
- Run `docker service ls` to verify new replicas deployed

## Sample Requests

```
{
  "rules" : [
    {
      "when": {
        "lhs": 2,
        "operation": "EQ",
        "rhs": 2
      },
      "then": {
        "id": 2,
        "name" : "Test -2"
      }
    },
    {
      "when": {
        "lhs": "$user.points$",
        "operation": "GTE",
        "rhs": 1000
      },
      "data": {
        "user":{
          "points" : 9999
        }
      },
      "then": {
        "id": 3,
        "name" : "Test - 3"
      }
    }
  ]
}

```