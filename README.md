# bsconf-perf

requirements:
java 1.8
maven
postgres.

# Running project

1. clone 
```bash
git https://github.com/krestovsky/bsconf-perf.git
```

2. change directory to
```bash
cd bsconf-perf
```

3. run maven
```bash
mvn clean install
```

4. configure application
```bash
vi config/config.yml
```

5. run application
```bash
java -Xmx2G -XX:MaxInlineSize=128 -server -jar target/bsconf-perf-1.0-SNAPSHOT.jar server config/config.yml
```

6. run jvm warming-up
```bash
ab -n 300000 -c 100 http://localhost:8080/users
```

7. run tests
```bash
ab -n 1000 -c 100 http://localhost:8080/users
```

8. my results
* full functionality (orm, json serialization)
```code
Concurrency Level:      100
Time taken for tests:   0.824 seconds
Complete requests:      1000
Failed requests:        0
Total transferred:      100005000 bytes
HTML transferred:       99894000 bytes
Requests per second:    1213.58 [#/sec] (mean)
Time per request:       82.400 [ms] (mean)
Time per request:       0.824 [ms] (mean, across all concurrent requests)
Transfer rate:          118520.07 [Kbytes/sec] received
```