# Cheatsheets

## Docker

| Description         | Example                                                                                                         |
|---------------------|-----------------------------------------------------------------------------------------------------------------|
| Pull image          | `docker pull mysql:8.2.0`                                                                                       |
| Create a container  | `docker run --name VikiMySQLInstance -e MYSQL_ROOT_PASSWORD=password123 -p 3306:3306 -p 33060:33060 -d mysql:8.2.0` |
| List all containers | `docker ps -a`                                                                                                  |
| Start a container   | `docker start 16c1e28cc1cf` # container id                                                                      |
| Stop a container    | `docker stop 16c1e28cc1cf` # container id                                                                       |
| Remove a container  | `docker rm MySQLInstance` # container name                                                                      |

## MySQL

| Description       | Example                                 |
|-------------------|-----------------------------------------|
| Start MySQL       | `mysql -h localhost -P 3306 -u root -p` |
| Get MySQL version | `SELECT VERSION();`                     |
| Describe table    | `SHOW CREATE TABLE employees;`          |

## Conda

| Description              | Example                                           |
|--------------------------|---------------------------------------------------|
| Create conda environment | `conda create --name MachineLearning python=3.10` |
| Activate conda           | `conda activate MachineLearning`                  |

