# **📌 해시 테이블(Hash Table)과 해시 맵(Hash Map) 완벽 정리**

## **1️⃣ 해시 테이블(Hash Table)란?**
**해시 테이블(Hash Table)**은 **키(key)와 값(value) 쌍을 저장하는 데이터 구조**입니다.  
- **빠른 검색(O(1))**이 가능하여 **딕셔너리(dictionary)와 같은 연관 배열(associative array)**을 구현할 때 사용됩니다.  
- 해시 함수를 사용하여 **키를 해시값(hash value)로 변환하고, 해당 값을 인덱스로 사용**하여 데이터에 빠르게 접근할 수 있습니다.  
- **Python의 `dict`(딕셔너리)가 해시 테이블 기반으로 구현**되어 있습니다.  

---

## **2️⃣ 해시 함수(Hash Function)란?**
해시 테이블에서 **키를 숫자로 변환하는 함수**를 **해시 함수(Hash Function)**라고 합니다.  
- 해시 함수는 **임의의 크기의 데이터를 고정된 크기의 값으로 변환**합니다.  
- 변환된 값(해시값, **hash value**)을 **인덱스로 사용**하여 데이터를 저장합니다.  
- **이상적인 해시 함수의 조건**:
  1. 같은 입력에 대해 항상 같은 해시값을 반환해야 함 (결정적)
  2. 서로 다른 입력이 가능한 한 서로 다른 해시값을 가져야 함 (충돌 최소화)
  3. 빠르게 계산할 수 있어야 함

### **💡 Python의 `hash()` 함수 예제**
```python
print(hash("hello"))  # 문자열을 해시값으로 변환
print(hash(123))      # 정수를 해시값으로 변환
print(hash((1, 2, 3)))  # 튜플도 해시 가능 (불변형 데이터만 가능)
```
✔ **출력 (해시값은 실행할 때마다 다를 수 있음)**:
```
-5821467828138597383
123
529344067295497451
```
- `hash()` 함수는 **숫자형, 문자열, 튜플과 같은 불변(immutable) 객체에서만 사용 가능**.
- `list`, `set`, `dict` 등 **가변(mutable) 객체는 해시 불가능**.

---

## **3️⃣ 해시 테이블의 구조**
해시 테이블은 **배열(Array)과 연결 리스트(Linked List)를 조합**하여 구현됩니다.

1. **해시 함수(Hash Function)**: 키를 해시값으로 변환하여 배열의 인덱스로 사용
2. **배열(Array)**: 해시값을 인덱스로 사용하여 데이터를 저장
3. **충돌 해결(Collision Resolution)**: 두 개 이상의 키가 같은 해시값을 가질 경우 처리 방법

---

## **4️⃣ 해시 충돌(Hash Collision)**
### **🔹 해시 충돌이란?**
서로 다른 키가 **같은 해시값을 가질 때 발생**하는 문제입니다.  
해시 함수가 해시 테이블의 크기보다 많은 키를 처리해야 할 때 충돌이 발생할 가능성이 높아집니다.

### **🔹 충돌 해결 방법**
1. **체이닝(Chaining)**
   - 같은 해시값을 가진 여러 개의 데이터를 **연결 리스트(Linked List)**로 저장하는 방식.
   - 같은 해시값을 가지는 요소들을 리스트에 저장하여 **탐색 시 리스트를 순회**함.
   - Python의 `dict`는 **체이닝 방식**을 사용합니다.

2. **오픈 어드레싱(Open Addressing)**
   - 충돌이 발생하면 **다른 빈 슬롯을 찾아 저장**하는 방식.
   - **선형 탐색(Linear Probing)**, **이차 탐색(Quadratic Probing)** 등의 기법이 있음.
   - 탐색 속도는 빨라질 수 있지만, **테이블이 가득 차면 성능이 저하됨**.

---

## **5️⃣ Python의 `dict`(딕셔너리)와 해시 테이블**
Python의 `dict`는 **해시 테이블 기반으로 구현**되어 있으며, **체이닝(Chaining) 기법을 사용**하여 충돌을 해결합니다.

### **✅ `dict` 사용 예제**
```python
my_dict = {}  # 빈 딕셔너리 생성

# 값 추가
my_dict["apple"] = 10
my_dict["banana"] = 5
my_dict["cherry"] = 7

# 값 조회 (O(1) 시간 복잡도)
print(my_dict["apple"])  # 10
print(my_dict["banana"])  # 5
```
✔ **출력:**
```
10
5
```
- `dict`는 해시 테이블을 기반으로 **O(1)**의 시간 복잡도로 빠른 검색이 가능합니다.

---

## **6️⃣ 해시 맵(Hash Map)이란?**
**해시 맵(Hash Map)은 해시 테이블의 구현 방식 중 하나**로, 키-값 쌍을 저장하는 자료 구조입니다.
- **해시 맵(Hash Map) = 해시 테이블 + 충돌 해결 방법**
- Python에서는 `dict`가 해시 맵 역할을 수행합니다.
- Java에서는 `HashMap` 클래스를 사용하여 해시 맵을 구현합니다.

### **✅ Python에서 해시 맵(`dict`) 활용 예제**
```python
hash_map = {}

# 키-값 쌍 추가
hash_map["a"] = 1
hash_map["b"] = 2
hash_map["c"] = 3

# 값 조회 (O(1) 연산)
print(hash_map.get("a"))  # 1

# 키 존재 여부 확인
print("b" in hash_map)  # True

# 키-값 삭제
del hash_map["c"]
print(hash_map)  # {'a': 1, 'b': 2}
```
✔ **출력:**
```
1
True
{'a': 1, 'b': 2}
```

---

## **7️⃣ Python의 `defaultdict`와 `Counter`**
Python에서는 `collections` 모듈을 활용하여 해시 테이블을 더 쉽게 사용할 수 있습니다.

### **✅ `defaultdict` 사용**
```python
from collections import defaultdict

d = defaultdict(int)  # 기본값이 0인 딕셔너리 생성

d["apple"] += 1
d["banana"] += 2

print(d)  # defaultdict(<class 'int'>, {'apple': 1, 'banana': 2})
```

### **✅ `Counter`를 사용한 해시 테이블**
```python
from collections import Counter

fruits = ["apple", "banana", "apple", "cherry", "banana", "banana"]
count = Counter(fruits)  # 각 요소의 등장 횟수를 해시 테이블로 저장

print(count)  # Counter({'banana': 3, 'apple': 2, 'cherry': 1})
```

---

## **8️⃣ 해시 테이블 vs 해시 맵 차이점**
| **구분** | **해시 테이블(Hash Table)** | **해시 맵(Hash Map)** |
|----------|------------------|----------------|
| **설명** | 키-값 쌍을 저장하는 데이터 구조 | 해시 테이블을 구현한 자료구조 |
| **충돌 해결 방식** | 오픈 어드레싱, 체이닝 | 주로 체이닝 방식 사용 |
| **Python에서 구현** | `dict`, `defaultdict`, `Counter` | `dict` |
| **Java에서 구현** | `Hashtable` 클래스 | `HashMap` 클래스 |
| **속도** | 빠름 (O(1) 검색) | 빠름 (O(1) 검색) |
| **멀티스레드 지원** | 일반적으로 지원 안 함 | `ConcurrentHashMap`이 지원 |

---

## **📌 결론**
✅ **해시 테이블(Hash Table)은 키-값을 저장하는 데이터 구조이며, 해시 맵(Hash Map)은 이를 구현한 자료구조입니다.**  
✅ **Python의 `dict`는 해시 테이블을 기반으로 하며, 충돌 해결 방식으로 체이닝(Chaining)을 사용합니다.**  
✅ **Python의 `defaultdict`, `Counter` 등을 활용하면 더욱 편리하게 해시 맵을 사용할 수 있습니다.**  
✅ **시간 복잡도 O(1)로 빠르게 데이터 검색이 가능하여, 많은 알고리즘 문제에서 활용됩니다!** 🚀