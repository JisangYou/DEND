# DEND

## 1 WEEK

- data engineer skill sets and roles
- data storage and processing
- move/store/explore/transform

- conceptional, logical, physical

- what is data modeling
    - the process of creating data models

- ddl(Data Definition Language)
    - CREATE, DROP, ALTER, TRUNCATE

- schema란 서로 연결되어 있는 테이블들의 모음이다
- ad-hoc 쿼리란 즉시, 바로, 임시의 의미를 가지고 있다. 
- acid(atomicity,consistency,isolation,durability)
- 일치하는 값을 포함하는 각 테이블의 열이있는 한 두 테이블을 조인 할 수 있다.
- When Not to Use a Relational Database
    - Have large amounts of data
    - Need to be able to store different data type formats
    - Need high throughput -- fast reads
    - Need a flexible schema
    - Need high availability
    - Need horizontal scalability

- 관계형 데이터베이스는 적은 양의 데이터가 있고 테이블에 조인하거나 집계를 수행해야하거나 데이터를 분석해야하는 경우 최적의 데이터베이스 선택입니다. ACID 트랜잭션을 허용하므로 비즈니스 요구에 중요하다면 관계형 데이터베이스를 유지하십시오.

- 카산드라
    -  A keyspace is a collection of tables

- relational Databases Modeling
    - Standardization of data model
    - Flexibility in adding and altering tables
    - Data Integrity
    - Standard Query Language (SQL)
    - Simplicity 
    - Intuitive Organization


- 정규화 : 데이터 중복성을 줄이고 데이터 무결성을 향상시킵니다.

- Objectives of Normal Form:
```
To free the database from unwanted insertions, updates, & deletion dependencies
To reduce the need for refactoring the database as new types of data are introduced
To make the relational model more informative to users
To make the database neutral to the query statistics
```