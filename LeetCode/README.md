1️⃣ in — key 존재 확인
count = {"a": 2, "b": 1}

"a" in count      # True
"c" in count      # False


이건 내부적으로 hash lookup O(1) 이다.

그래서 이런 코드가 가능:

if ch not in count:
    return False

2️⃣ .keys(), .values(), .items()
count = {"a": 2, "b": 1}

count.keys()    # dict_keys(['a', 'b'])
count.values()  # dict_values([2, 1])
count.items()   # dict_items([('a', 2), ('b', 1)])


가장 많이 쓰는 건 .items():

for key, value in count.items():
    print(key, value)


실전 예:

for ch, freq in count.items():
    if freq != 0:
        return False

3️⃣ .pop(key) — 안전하게 제거
count = {"a": 2, "b": 1}

count.pop("a")   # 2
count            # {"b": 1}


존재 안 할 수도 있을 때:

count.pop("a", 0)   # 없으면 0 반환


Anagram에서 이게 자주 쓰인다:

count[ch] -= 1
if count[ch] == 0:
    count.pop(ch)

4️⃣ .setdefault() — 있으면 그대로, 없으면 만들기
count = {}

count.setdefault("a", 0)   # 없으면 0 넣음
count["a"] += 1


이 코드는:

count["a"] = count.get("a", 0) + 1


과 같은 의미다.

5️⃣ .update() — dict 합치기
a = {"x": 1, "y": 2}
b = {"y": 5, "z": 3}

a.update(b)
# a = {"x": 1, "y": 5, "z": 3}


오른쪽 dict가 덮어쓴다.

6️⃣ .clear()
count.clear()


dict를 비운다.

7️⃣ .copy() — 얕은 복사
a = {"x": 1}
b = a.copy()


b는 a와 독립적.

8️⃣ dict는 "해시 기반 Set + Array" 구조다

Python dict는 내부적으로:

hash(key) → index → value


그래서:

연산	시간
lookup	O(1)
insert	O(1)
delete	O(1)

이게 Anagram, Two Sum, Sliding Window, Frequency Counting이 전부 dict 쓰는 이유다.