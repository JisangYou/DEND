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

- relational Databases Modelingd
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

- 역정규화(denormalization)
 이전에 정규화된 데이터베이스에서 성능을 개선하기 위해 사용되는 전략이다. 컴퓨팅에서 역정규화는 일부 쓰기 성능의 손실을 감수하고 데이터를 묶거나 데이터의 복제 사본을 추가함으로써 데이터베이스의 읽기 성능을 개선하려고 시도하는 과정이다.[1][2] 아주 많은 수의 읽기 작업을 처리할 필요가 있는 관계형 데이터베이스 소프트웨어의 성능이나 스케일링에서 고려된다. 역정규화는 비정규화(unnormalized form)와는 구별한다. 데이터베이스/테이블은 이들을 효율적으로 역정규화하기 위해 우선 정규화되어야 한다.

 -  Normalization  데이터의 사본 수를 줄임으로써 데이터 무결성을 높이려는 것입니다. 추가하거나 업데이트해야하는 데이터는 가능한 한 적은 곳에서 처리됩니다.

- Denormalization 는 조인이 느려질 수 있으므로 테이블 간의 조인 수를 줄여 성능을 향상 시키려고합니다. JOINS를 줄이기 위해 데이터의 사본이 더 많아지기 때문에 데이터 무결성이 잠재적 인 영향을 미칩니다.

- 스타 스키마는 데이터 웨어하우스 스키마 중 가장 단순한 종류의 스키마인데, 한 개의 사실 테이블과 주 키 및 각 차원과 추가적인 사실들로 이루어진 스키마이다. 스타 스키마라는 이름은 스키마 다이어그램이 마치 "별표(star)" 모양이라 해서 붙인 이름이다

- 유니크 키 
본 키(primary key)는 주 키 또는 프라이머리 키라고 하며, 관계형 데이터베이스에서 조(레코드)의 식별자로 이용하기에 가장 적합한 것을 관계 (테이블)마다 단 한 설계자에 의해 선택, 정의된 후보 키를 말한다.

- 외래키 
관계형 데이터베이스에서 외래 키(외부 키, Foreign Key)는 한 테이블의 필드(attribute) 중 다른 테이블의 행(row)을 식별할 수 있는 키를 말한다.

- upsert
In RDBMS language, the term upsert refers to the idea of inserting a new row in an existing table, or updating the row if it already exists in the table. The action of updating or inserting has been described as "upsert"