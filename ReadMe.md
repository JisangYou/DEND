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
```
ec2(컴퓨팅 서비스)
AWS의 핵심이면서 가장 많이 사용하는 가상 서버 서비스

Elastic Compute Cloud. CPU 사용량 그런 거 없이 기본적으로 켜놓은 시간을 기준으로 과금하는 구조다. 다만 새 서버 인스턴스를 생성하고 프로그램 올리고 구동하는 게 전부 제공되는 API로 다 되기 때문에 Auto Scaling 서비스와 연계해서 트래픽이 몰리면 인스턴스를 자동으로 늘려서 대응하고 트래픽이 줄어들면 만들었던 인스턴스를 없애는 일을 할 수 있다
```

```
- s3

무제한 용량을 제공하는 인터넷 스토리지 서비스

확장성이 뛰어나고 사용한 만큼만 비용을 지불한다. 버킷(Bucket)이라는 영역을 생성하고 데이터를 키-값 형식의 객체(Object)로 저장한다. 매우 저렴한 비용이 특징. 이 서비스를 활용하면 간단한 정적 웹 서비스를 만들어볼 수도 있다.

EC2가 컴퓨팅 카테고리의 근간 기술인 것처럼 이 S3서비스는 스토리지 카테고리의 근간을 이룬다. 계산은 EC2에서, 저장은 S3에서 처리하는 식. 

```



```
RedShift
데이터 웨어하우징. 정말 엄청난(페타바이트 규모) 데이터를 SQL로 다룰 때 사용
```
- 병렬 처리


- IAM

AWS Identity and Access Management(IAM)는 AWS 리소스에 대한 액세스를 안전하게 제어할 수 있는 웹 서비스입니다. IAM을 사용하여 리소스를 사용하도록 인증(로그인) 및 권한 부여(권한 있음)된 대상을 제어합니다.


- 분산 스타일

테이블을 생성할 때는 AUTO, EVEN, KEY, ALL 등 네 가지 분산 스타일 중 하나를 지정할 수 있습니다.

분산 스타일을 지정하지 않으면 Amazon Redshift에서는 AUTO 분산을 사용합니다.

- AUTO 분산

AUTO 분산을 사용하면 Amazon Redshift에서는 테이블 데이터의 크기를 기반으로 최적의 분산 스타일을 할당합니다. 예를 들어, Amazon Redshift는 처음에 작은 테이블에 ALL 분산을 할당한 다음 테이블이 더 커지면 EVEN 분산으로 변경합니다. 테이블이 ALL에서 EVEN 분산으로 변경되면 스토리지 사용률이 약간 변할 수 있습니다. 분산은 배경에서 몇 초 내에 변경되며, Amazon Redshift는 분산 스타일을 EVEN에서 ALL로 변경하지 않습니다. 테이블에 적용된 분산 스타일을 보려면 PG_CLASS_INFO 시스템 카탈로그 보기를 쿼리합니다. 자세한 내용은 분산 스타일 보기 단원을 참조하십시오. CREATE TABLE 문을 사용해 분산 스타일을 지정하지 않으면 Amazon Redshift에서는 AUTO 분산을 적용합니다.

- EVEN 분산

리더 노드는 특정 열 값에 상관없이 행을 라운드 로빈 방식으로 조각에 분산시킵니다. EVEN 분산은 테이블이 조인에 참여하지 않거나, 혹은 KEY 분산과 ALL 분산을 명확히 구분하여 선택하지 않을 때 적합합니다.

- KEY 분산

행이 열 1개의 값에 따라 분산됩니다. 리더 노드는 일치하는 값을 동일한 노드 조각에 할당합니다. 조인 키를 기준으로 테이블 페어를 분산시키면 리더 노드가 조인 열의 값에 따라 행을 조각에 공동 배치하기 때문에 공통 열에서 일치하는 값은 물리적으로 함께 저장됩니다.

- ALL 분산

전체 테이블의 복사본이 모든 노드로 분산됩니다. EVEN 분산이나 KEY 분산은 테이블 행의 일부를 각 노드에 할당하는 반면 ALL 분산은 테이블이 참여하는 조인마다 모든 행을 공동 배치합니다.

- ALL 분산은 필요한 스토리지를 클러스터 노드 수와 곱하기 때문에 데이터를 다수의 테이블에 로드하거나, 업데이트하거나, 삽입하는 데 더 많은 시간이 걸립니다. 따라서 비교적 느리게 이동하는 테이블, 즉 업데이트가 자주 또는 광범위하게 이루어지지 않는 테이블에 한해 적합합니다. 작은 차원 테이블은 재분산 비용이 낮기 때문에 ALL 분산의 이점이 크지 않습니다.

- 
병렬처리 시스템은 프로세서를 늘려서 여러 일을 동시에, 더 빨리 처리 할 수 있게 해주는 시스템 방식이고, 분산처리 시스템은 처리할 수 있는 장비(컴퓨터 등)을 네트워크로 상호 연결하여 전체적인 일의 부분 부분을 나누어 더 빨리 처리 할 수 있게 하는 시스템 방식이다. 이 둘은 단일에서 여럿으로, 일을 동시에 처리한다는 점이 유사하지만 전체적인 틀에서 보면 일을 처리하는 방식이 매우 다르다. 병렬처리는 “동시에 여러 일”을 처리하는 것이고, 분산처리는 “하나의 일을 동시에 여럿이서” 처리하는 것

출처: https://croute.me/1 [식탁 위의 프로그래머]

- distributed computing implies multiple CPUs each with its own memory. Parallel computing uses multiple CPUs sharing the same memory.

-
Hadoop Vocabulary
Here is a list of some terms associated with Hadoop. You'll learn more about these terms and how they relate to Spark in the rest of the lesson.

Hadoop - an ecosystem of tools for big data storage and data analysis. Hadoop is an older system than Spark but is still used by many companies. The major difference between Spark and Hadoop is how they use memory. Hadoop writes intermediate results to disk whereas Spark tries to keep data in memory whenever possible. This makes Spark faster for many use cases.

Hadoop MapReduce - a system for processing and analyzing large data sets in parallel.

Hadoop YARN - a resource manager that schedules jobs across a cluster. The manager keeps track of what computer resources are available and then assigns those resources to specific tasks.

Hadoop Distributed File System (HDFS) - a big data storage system that splits data into chunks and stores the chunks across a cluster of computers.

As Hadoop matured, other tools were developed to make Hadoop easier to work with. These tools included:

Apache Pig - a SQL-like language that runs on top of Hadoop MapReduce
Apache Hive - another SQL-like interface that runs on top of Hadoop MapReduce
Oftentimes when someone is talking about Hadoop in general terms, they are actually talking about Hadoop MapReduce. However, Hadoop is more than just MapReduce. In the next part of the lesson, you'll learn more about how MapReduce works.

How is Spark related to Hadoop?
Spark, which is the main focus of this course, is another big data framework. Spark contains libraries for data analysis, machine learning, graph analysis, and streaming live data. Spark is generally faster than Hadoop. This is because Hadoop writes intermediate results to disk whereas Spark tries to keep intermediate results in memory whenever possible.

The Hadoop ecosystem includes a distributed file storage system called HDFS (Hadoop Distributed File System). Spark, on the other hand, does not include a file storage system. You can use Spark on top of HDFS but you do not have to. Spark can read in data from other sources as well such as Amazon S3.

Streaming Data
Data streaming is a specialized topic in big data. The use case is when you want to store and analyze data in real-time such as Facebook posts or Twitter tweets.

- chunk : 덩어리, 데이터 덩어리

- Spark splits up data onto multiple machines. If your songs list were split onto two machines, Machine A would first need to finish counting, and then return its own result to Machine B. And then Machine B could use the output from Machine A and add to the count.

- imperative Programming vs Declarative Programming
- how vs what


- data lake란?
데이터를 원형 그대로 저장하는 방식
대량의 데이터를 원시 형식으로 보관하는 저장소

- data warehouse
"데이터(data) + 창고(warehouse)"
회사의 각 사업부문에서 수집된 모든 자료 또는 주요 자료에 관한 중앙창고
의사결정에 도움을 주기 위해, 다양한 운영 시스템에서 추출, 변환, 통합되고 요약된 데이터베이스
기업의 대단위 데이터를 사용자 관점에서 주제별로 통합하여 축적하여 별도의 장소에 저장해 놓은 것
기간 시스템의 데이터베이스에 축적된 데이터를 공통의 형식으로 변환하여 일원적으로 관리하는 데이터베이스
의사결정에 도움을 주기 위해, 기간시스템의 데이터베이스에 축적된 데이터를 공통의 형식으로 변환해서 관리하는 데이터베이스
가장 많이 사용하는 스키마: 스타 스키마

-
Four key differences between a data lake and a data warehouse
There are several differences between a data lake and a data warehouse. Data structure, ideal users, processing methods, and the overall purpose of the data are the key differentiators.

 	
- Data Lake - Data Warehouse

Data Structure

Raw - Processed

Purpose of Data

Not Yet Determined - Currently In Use

Users

Data Scientists - usiness Professionals

Accessibility

Highly accessible and quick to update - More complicated and costly to make changes

- Amazon EMR은 비즈니스, 연구원, 데이터 분석가 및 개발자가 막대한 양의 데이터를 간편하게, 비용 효율적으로 처리할 수 있는 웹 서비스입니다.

- 파이프 라인은 데이터가 처리되는 일련의 단계입니다. It's typically using either ETL or ELT

- 카프카 

아파치 카프카(Apache Kafka)는 아파치 소프트웨어 재단이 스칼라로 개발한 오픈 소스 메시지 브로커 프로젝트이다. 이 프로젝트는 실시간 데이터 피드를 관리하기 위해 통일된,높은 스루풋의 낮은 레이턴시를 지닌 플랫폼을 제공하는 것이 목표이다. 요컨대 분산 트랜잭션 로그로 구성된[1], 상당히 확장 가능한 pub/sub 메시지 큐로 정의할 수 있으며, 스트리밍 데이터를 처리하기 위한 기업 인프라를 위한 고부가 가치 기능이다.
디자인은 트랜잭션 로그에 많은 영향을 받았다

- redshift 
Amazon Redshift는 데이터 웨어하우스와 데이터 레이크 전체에 걸쳐 간단하고 비용 효율적으로 모든 데이터를 분석할 수 있는 빠르고 확장 가능한 데이터 웨어하우스입니다. Redshift는 기계 학습, 대량 병렬 쿼리 실행, 고성능 디스크의 열 기반 스토리지를 사용하여 다른 데이터 웨어하우스보다 10배 빠른 성능을 제공합니다. 몇 분 만에 새로운 데이터 웨어하우스를 설정 및 배포하고, Redshift 데이터 웨어하우스에 있는 페타바이트 규모의 데이터와 Amazon S3에 구축된 데이터 레이크에 있는 엑사바이트 규모의 데이터에 대해 쿼리를 실행할 수 있습니다.

- What is S3?
"Amazon S3 has a simple web services interface that you can use to store and retrieve any amount of data, at any time, from anywhere on the web. It gives any developer access to the same highly scalable, reliable, fast, inexpensive data storage infrastructure that Amazon uses to run its own global network of web sites." 

- Extract Transform Load (ETL) and Extract Load Transform (ELT):
"TL is normally a continuous, ongoing process with a well-defined workflow. ETL first extracts data from homogeneous or heterogeneous data sources. Then, data is cleansed, enriched, transformed, and stored either back in the lake or in a data warehouse.

"ELT (Extract, Load, Transform) is a variant of ETL wherein the extracted data is first loaded into the target system. Transformations are performed after the data is loaded into the data warehouse. ELT typically works well when the target system is powerful enough to handle transformations. Analytical databases like Amazon Redshift and Google BigQ." 
Source: Xplenty.com

- Data Validation
데이터 유효성 검사는 데이터가 존재하고 정확하며 의미있는 결과를 보장하는 프로세스입니다. 자동 유효성 검사를 통해 데이터의 품질을 보장하는 것은 모든 조직에서 데이터 파이프 라인을 구축하는 중요한 단계입니다.

- DAGs

 DAGs are a special subset of graphs in which the edges between nodes have a specific direction, and no cycles exist. When we say “no cycles exist” what we mean is the nodes cant create a path back to themselves.

- callable 

호출 가능 객체는 다른 함수에 인수로 포함될 수있는 함수를 전달하는 것으로 생각할 수 있습니다. callable의 예는 map, reduce, filter입니다

-airflow 
에어플로우가 타 작업 흐름 관리 도구에 비해 나은 점은:

동적인 작업 흐름 정의: 작업 흐름은 파이썬 코드로 정의되며 동적으로 작성될 수 있습니다.
확장성: 새로운 연산자와 실행자를 쉽게 정의하고 라이브러리를 확장할 수 있게 합니다.
간결함: Jinja 템플릿 엔진을 통해 깔끔하게 스크립트 매개 변수를 전달합니다.
가용성: 모듈 아키텍쳐를 가지며 클러스터로 확장 가능한 메시지 큐를 통해 작업을 관리합니다.

출처: https://jwon.org/airflow-concepts

Airflow is a platform to programmatically author, schedule and monitor workflows.

Use airflow to author workflows as directed acyclic graphs (DAGs) of tasks. The airflow scheduler executes your tasks on an array of workers while following the specified dependencies. Rich command line utilities make performing complex surgeries on DAGs a snap. The rich user interface makes it easy to visualize pipelines running in production, monitor progress, and troubleshoot issues when needed.

When workflows are defined as code, they become more maintainable, versionable, testable, and collaborative.

- The Airflow UI is control interface for users and maintainers that allows them to execute and monitor DAGs

- Airflow is based on Scheduler(Starts DAGs based on triggers or schedules and moves them towards completion), Workers(The workers run and record the outcome of individual pipeline tasks), UI/Web Server, Queue, Database

- 후킹
후킹은 소프트웨어 공학 용어로, 운영 체제나 응용 소프트웨어 등의 각종 컴퓨터 프로그램에서 소프트웨어 구성 요소 간에 발생하는 함수 호출, 메시지, 이벤트 등을 중간에서 바꾸거나 가로채는 명령, 방법, 기술이나 행위를 말한다.

- DAG 
A collection of nodes and edges that describe the order of operations for a data pipeline

- Task
An instantiated step in a pipeline fully parameterized for execution(수행할 작업)

- Hook
A reusable connection to an external database or system

- Operator
An abstract building block that can be configured to perform some work(자바에서 클래스와 인스턴스 관계로 비유하자면, 오퍼레이터와 태스크의 관계가 클래스와 인스턴스 관계와 비슷하다. Airflow에서 자주 수행되는 태스크들을 위해 다양한 오퍼레이터를 미리 제공)

- Data Lineage

The data lineage of a dataset describes the discrete steps involved in the creation, movement, and calculation of that dataset.

- why Schedules 

파이프 라인 일정은 주어진 실행에서 처리해야하는 데이터의 양을 줄일 수 있습니다. 그것은 데이터 파이프 라인이 마지막으로 실행 된 이후의 기간 동안 만 데이터를 실행하는 범위를 작업에 도움이됩니다. 범위가 없는 순진한 분석에서 우리는 항상 모든 데이터를 분석합니다.
일정을 사용하여 주어진 파이프 라인 실행 기간과 관련된 데이터 만 선택하면 우리 파이프 라인이 수행하는 분석의 품질과 정확성을 향상시킬 수 있습니다.
일정에 따라 파이프 라인을 실행하면 파이프 라인 실행 시간이 단축됩니다.
더 넓은 범위의 분석은 이미 완료된 작업을 활용할 수 있습니다. 에 대한. 예를 들어 지금까지의 모든 달에 대한 집계가 예정된 작업에 의해 이미 완료 되었다면 현재 달에 대한 집계 만 수행하고 기존 합계에 집계 만 추가하면됩니다.

- Selecting the time period

What is the size of data, on average, for a time period? 

How frequently is data arriving, and how often does the analysis need to be performed? 

What's the frequency on related datasets?

- Schedule default is one day