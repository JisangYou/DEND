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


- when not to use SQL

데이터에서 고 가용성 필요 : 시스템이 항상 가동 중이며 가동 중지 시간이 없음을 나타냅니다.
많은 양의 데이터 보유
선형 확장 성 필요 : 시스템에 노드를 추가해야 성능이 선형 적으로 증가합니다.
낮은 대기 시간 : 전송 지시가 수신되면 데이터가 전송되기 전에 짧은 지연.
빠른 읽기 쓰기 필요

- CAP Theorem

Consistency: Every read from the database gets the latest (and correct) piece of data or an error

Availability: Every request is received and a response is given -- without a guarantee that the data is the latest update

Partition Tolerance: The system continues to work regardless of losing network connectivity between nodes

- 아파치 카산드라
조인이 없기에, 비정규화를 제대로 시켜놓고 개발자가 미리 숙지해야함.

- CQL
no JOIN no GROUP BY and there's not any subqueries


- 
1. primary key 

DB의 pk와 비슷하다. row를 유일무이하게 해주는 key를 의미한다. 1개 이상의 키가 필요하다. 

2. composite(compound) key

primary key가 2개 이상이면 composite key라 부른다.

3. partition key

partition key는 primary key의 1번째 key(예시에서는 col1)를 의미한다. 저장소 row key로 직접 변환하고 해시 알고리즘에 따라 클러스터에 저장(분배)된다. 대부분의 질의는 partition key를 제공해서 카산드라는 요청된 데이터가 어느 노드에 있는지 알게 된다. 

4. clustering key

primary key의 1번째 key외 나머지 key를 clustering key(또는 clustering column)라 한다. 해당 key는 디스크에 데이터 순서를 안다. 하지만 어느 노드에 저장될지는 결정하지 않는다. 
순서 관련해서 오름차순, 내림차순으로 변경할 수 있다. 

[출처](https://knight76.tistory.com/entry/cassandra-키의-종류-primary-key-partition-key-clustering-key-compositecompound-key-composite-partition-key)



- project

    - 스타스키마의 간단한 소개차원 테이블은 중앙의 사실 테이블과 직접적인 관계를 가진다.
    모든 차원 테이블의 속성들이 사실 테이블에 속한 속성들을 분석하기 위하여 하나의 질의에 참여하는 균등한 기회를 갖도록 한다.
    차원 모델의 배치가 별모양

    - 차원 테이블 
    차원 테이블 키(dimension table key). 차원 테이블의 기본키는 테이블에서 각 행을 유일하게 식별
    테이블은 넓다(table is wide). 많은 열을 가짐. 50개 이상의 열을 가지는 것은 특별한 것이 아님
    텍스트로 된 속성(textual attributes). 수치값을 찾기 어려움. 속성들은 텍스트 형식
    속성들은 직접 연관되지 않음(attirbues not directly related). 차원 테이블의 속성들과 그 테이블에 속성들과 직접 관련되어 있지 않음.
    정규화 되어 있지 않다(not normalized). 
    드릴다운, 롤업(drilldown, rollup).
    다수 계층(multiple hierachies)
    더 작은 개수들의 레코드(fewer number of records).

    - 사실 테이블
    합성된 키(concatenated key). 사실 테이블의 기본키는 모든 차원 테이블의 기본키(외부키)의 조합
    데이터 구체화정도(data grain). 측정값(measure)의 상세함의 수준. 합성된 키의 수준.
    완전 덧셈 측정치(fully additive measures). 
    반 덧셈 측정치(semiadditive measures).
    테이블은 깊고, 넓지 않다(table deep, not wide)
    희박 데이터(sparse data)
    퇴화 차원(degenerate dimensions). 주문번호와 같은 measure도 아닌 metric(측정규준, 지표, 실판매가, 딜러공제, 옵션가격 등..)도 아닌 속성


    ## aws

    - operational process vs analytical process

    - 디멘션은 팩트 테이블에서 값을 한정해 보여주는 테이블이다. Fact 테이블이 Measures 를 포함하는데 비해서, Dimension은 Business를 기술하는 것으로 볼 수 있다.
    - 출처: https://alnova2.tistory.com/1082 [몽상가]


    - OLAP
    ```
    출처 : https://dbrang.tistory.com/416
    
    -- 셀(Cell )
    : 하나의 데이터가 저장되는 공간으로 큐브에서 작은 육면체를 말한다.
    : 각 차원(제품/지역/기간, 아래 설명)들이 가진 멤버(항목의 좌표값)들의 조합수 만큼 
      존재한다.
-- 다차원 배열(Multi-Dimensional Array)
    : 데이터의 차원에 의해 정렬된 데이터 셀의 집합을 말한다.
    : 이차원 배열은 스프레드시트와 유사하고 삼차원은 정육면체(Cube)로 나타낼 수 있다.
      ※ 다차원 모델 : OLAP에서 일반적으로 큐브(Cube)로 명명한다.

-- 차원(Dimension)
    : 사용자가 분석하려는 항목에 대한 관점을 말한다.
    : 이차원에서 x, y축, 삼차원에서 x,y,z축(기간, 지역, 제품)을 의미한다.
-- 차원 멤버(Dimension Member[Element])
    : 차원을 구성하는 항목의 좌표값을 말한다.
    : 지역 차원의 멤버는 서울, 경기, 대구, 대전, 부산 등을 말한다.
-- 차원 계층 구조(Dimension Hierachy)
    : 한 차원의 멤버들간에 존재하는 부모-자식의 계층 구조를 말한다.
    : 하나의 차원이 여러 차원 계층 구조를 가지는 경우도 있다.
    : 년도-상/하반기-분기-월... 이렇게 예를 들면 될까요?..OTL
    : Consolidation(=Aggregatioin=Rolling up)에 사용된다.
      ※ 레벨(Level) : 계층구조는 여러 레벨(다단)을 사용하여 상위 계층과 하위 계층을 구분한다.

-- Measure/Variable
    : 분석하고자 하는 항목을 의미한다.
    : 매출액, 판매수량, 비용등.
    : 대부분의 경우 수집되는 수치데이터이다.
    : OLAP 제품에 따라 Measure, Variable, Fact, Account, Item, Structure 등으로 상용된다.

-- Attribute/Property
    : 하나의 차원에 대해 차원을 구성하는 항목들의 특성을 나타내는 정보를 의미한다.
    : 제품 차원에 대해 제품번호, 제품생산일자, 생산담당자 등이 Attribute이다.

-- Drill Down
    : Drill Down은 특정한 주제 영역에서 큰(요약된) 범위에서 작은(상세) 범위로 단계적 접근하는
      분석 방법을 말한다.
      (광역 -> 시도 -> 구 -> 동 -> 번지)
-- Roll Up
    : Roll Up은 Drill Down과 반대 방향(작은 범위 -> 큰 범위)의 단계적 접근 분석 방법을 말한다.
      (번지 -> 동 -> 구 -> 시도 -> 광역)
      ※ Drill Across : 다른 큐브에 접근하여 분석하는 방법
          Drill Through : DW나 OLAP의 상세 데이터에 접근하는 분석 방법(=Reach Through)
          이쯤 되면 정신없어 지지만~~ 참~ 쉽죠잉~ OTL

-- Pivot/Rotating
    : 분석 테이터의 축을 바꾸는 것.
    : T-SQL문에서 Pivot/Unpivot과 동일한 의미.

-- Slice
    : Slice는 한 차원의 멤버나 그 이상의 멤버를 가지고 한 값을 선택했을 때 나타나는 그 부분
      집합을 말한다.
    : 제품 당당자가 특정 제품에 대해서 선택할 때 나타나는 지역과 기간에 대한 집합
-- Dice
    : Slice된 특정 항목에 대해 Rotation이나 Drill down, Roll up 등을 이용하여 대화식으로 화면을
      디스플레이 해가며 분석하는 프로세스를 말한다.

-- rolap

ROLAP은 흔히 OLAP 표준이라고 간주되고 있는 다차원 데이터베이스 대신에, 관계형 데이터베이스 내에 저장되어 있는 데이터를 대상으로, 동적인 다차원 분석을 수행하는 OLAP의 한 형태이다.

데이터 처리는 데이터베이스 시스템이나, 중간계층 서버, 또는 클라이언트 내에서 일어날 수 있다. 2 계층 아키텍처에서, 사용자는 데이터베이스에 SQL 질의를 하고, 질의에 부합하는 데이터를 돌려 받는다. 3 계층 아키텍처에서, 사용자는 다차원 분석을 위한 요구를 하고, ROLAP 엔진은 이 요구를 SQL로 바꾸어 데이터베이스에 전달한다. 그러면, 그 동작은 반대로 수행되는데, 엔진은 SQL에서 들어온 검색결과 데이터를, 클라이언트에게 전달되기 전에 다차원 형식으로 변환한다. 관계형 데이터베이스의 전형 그대로, 일부 질의는 사전에 만들어지고 저장된다. 만약에 원하는 정보를 활용할 수 있다면, 그 질의가 사용됨으로써 시간을 절약할 수 있다. 그렇지 않으면, 그 질의는 사용자 요구로부터 그때그때 만들어진다. 마이크로소프트 액세스의 PivotTable은 3 계층 아키텍처의 한 예이다.

ROLAP이 관계형 데이터베이스를 사용하기 때문에, 다차원 데이터베이스에 적합한 일부 작업을 수행하기 위해서는 처리시간이 더 걸리며, 디스크 공간도 더 차지한다. 그러나, ROLAP은 더 많은 사용자 그룹과, 대용량 데이터를 지원하므로, 대기업의 크고 복잡한 부서 등과 같이 용량이 결정적인 요인으로 작용하는 경우에 자주 사용된다.

출처: https://dbrang.tistory.com/416 [dBRang [dɪ'·bɪ·raŋ]]
    ```

- AWS
- Redshift, ec2, s3
- 병렬 처리