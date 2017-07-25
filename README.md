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
```benchmark
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

* just string writing
```benchmark
Concurrency Level:      100
Time taken for tests:   0.098 seconds
Complete requests:      1000
Failed requests:        0
Total transferred:      132000 bytes
HTML transferred:       2000 bytes
Requests per second:    10200.33 [#/sec] (mean)
Time per request:       9.804 [ms] (mean)
Time per request:       0.098 [ms] (mean, across all concurrent requests)
Transfer rate:          1314.89 [Kbytes/sec] received
```

* only db call and element count result
```benchmark
Concurrency Level:      100
Time taken for tests:   0.684 seconds
Complete requests:      1000
Failed requests:        0
Total transferred:      136000 bytes
HTML transferred:       6000 bytes
Requests per second:    1461.14 [#/sec] (mean)
Time per request:       68.440 [ms] (mean)
Time per request:       0.684 [ms] (mean, across all concurrent requests)
Transfer rate:          194.06 [Kbytes/sec] received
```