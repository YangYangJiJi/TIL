# Boyer Moore Algorithm

## 문자열 검색 알고리즘
특정 문자열에서 우리가 원하는 패턴을 찾아야 될 때가 있다. ATAGAACCAATGAACC와 같은 긴 DNA 서열에서 ATG라는 시작코돈 (물론 당연히 코돈은 mRNA기준이고, 시작코돈은 AUG이지만,, 일단 넘어가자.)을 찾으려고 한다. 문서에서 찾는다고 하면 Ctrl + F 를 하면 짠 찾아질것이다. 이 Ctrl + F가 바로 Boyer Moore 알고리즘을 이용해서 작동되는 것이다.  
<br>
그냥 염기 하나하나씩 비교하면 되는거 아닌가? 왜 이렇게 거창한 알고리즘까지 써야하는가? 한다면 컴퓨터 입장에서는 단순 문자열 검색 방식보다 Boyer Moore 알고리즘을 쓸 때가 시간복잡도가 더 효율적이기 때문이다. 이런 류의 seq에서 pattern을 찾는 문자열 검색 알고리즘을 string 알고리즘이라고 하는데, string 알고리즘에서 시간은 생명이다!! (참고로 string 알고리즘에는 Boyer Moore 말고도, KMP(Knuth-Morris-Pratt) 알고리즘, Karp-Rabin 알고리즘이 있다.)

## Boyer Moore Algorithm
Brute Force Algorithm보다 좀 더 효율적인 알고리즘이다. 잘 설계된 휴리스틱 2개를 바탕으로 중복 비교를 줄여서, 평균적으로 매우 빠른 검색이 가능한 알고리즘이다. pattern을 뒤에서 부터 텍스트에 맞춰 비교하고, 불일치 시 특정 규칙에 따라 shift (건너뛰기)한다는 것이 특징이다. 
<br>
Boyer Moore 알고리즘에서 사용하는 2가지 휴리스틱(heuristic)은 Bad Character Rule과 Good Suffix Rule이 있다. 참고로 휴리스틱이란 노하우, 지혜 정도로 알면 될것이다. 증명은 안해봤지만 오래전부터 여러번 해보니 이런 좋은 방법이 있더라~ 느낌. 이제 이 휴리스틱을 하나씩 소개할 것이다. 암튼 결론은 Boyer Moore 알고리즘에서는 Bad Character Rule과 Good Suffix Rule 휴리스틱을 함께 사용해서 이동 폭을 최대화한다는 것이다! 융통성있게 이동하는게 포인트.

### Bad Character Rule (나쁜문자규칙) 과정
*Bad Character로 쓰기엔 너무 길다.. 나쁜문자로 쓰겠다. 그리고 이 표현이 이해가 잘 간다. <br>
1. seq에서 나쁜문자를 일단 찾는다. 나쁜문자는 seq과 pattern이 불일치 하도록 만드는 놈이다. 오른쪽부터 비교를 해 나가면서 일치/불일치 여부를 확인하는 것이 특징이다. <br>
2. pattern에서 seq의 나쁜문자와 일치하는 문자를 찾는다. 일치하는 문자가 여러개라면 역시 오른쪽에 있는 놈을 기준으로 한다.  <br>
3. 그 문자들끼리 서로 일치되도록 pattern을 shift시킨다. 일치하는 문자가 아예 없다면 당황하지 말고 pattern 길이만큼 통째로 shift하면 된다. <br>
4. 이제 또 그 구간에서 새 나쁜문자를 오른쪽부터 찾는다. 반복한다. <br>
5. 반복하다보면 seq 중에서 pattern과 일치하는 부분을 찾게 된다. <br>

### Good Suffix Rule (착한접미부규칙) 케이스1 과정
1. 오른쪽에서 왼쪽방향으로 pattern과 seq이 일치하는 경우를 찾는다. 언제까지? 불일치를 만날때까지. <br>
2. 착한접미부를 발견했으면, pattern의 나머지 부분에서 착한 접미부와 일치하는 부분을 찾는다. <br>
3. 일치부분이 있으면 그 부분을 seq의 착한 접미부 부분과 일치되도록 shift 시킨다. <br>

### Good Suffix Rule (착한접미부규칙) 케이스2 과정
pattern에서 착한접미부와 일치하는 문자열이 없는 경우는, 착한접미부의 문자열을 왼쪽부터 하나씩 줄여가면서 반복해서 조사한다. 

## 파이썬에서 boyer moore 알고리즘 구현

```
class BoyerMoore:
    
    def __init__(self, alphabet, pattern):
        self.alphabet = alphabet
        self.pattern = pattern
        self.preprocess()

    def preprocess(self):
        self.process_bcr()
        self.process_gsr()
        
    def process_bcr(self):  
        self.occ = {}
        for symb in self.alphabet:
            self.occ[symb] = -1
        for j in range(len(self.pattern)):
            c = self.pattern[j]
            self.occ[c] = j
            
    def process_gsr(self):
        self.f = [0] * (len(self.pattern)+1)
        self.s = [0] * (len(self.pattern)+1)
        i = len(self.pattern)
        j = len(self.pattern)+1
        self.f[i] = j
        while i>0:
            while j<= len(self.pattern) and self.pattern[i-1] != self.pattern[j-1]:
                if self.s[j] == 0: self.s[j] = j-i;
                j = self.f[j]
            i -= 1
            j -= 1
            self.f[i] = j  
        j = self.f[0]
        for i in range(len(self.pattern)):
            if self.s[i] == 0: self.s[i] = j
            if i == j: j = self.f[j]
        
    def search_pattern(self, text):
        res = []
        i = 0
        while i <= len(text) - len(self.pattern):
            j= len(self.pattern)- 1
            while j>=0 and self.pattern[j]==text[j+i]: j -= 1 
            if (j<0):
                res.append(i)
                i += self.s[0]
            else:
                c = text[j+i]            
                i += max(self.s[j+1], j- self.occ[c])
        return res
```

## ​Boyer Moore 알고리즘의 시간복잡도 
케바케이다. 가장 최악의 경우 시간복잡도는 O(mn) = O(n) 이고, 최선의 경우는 O(n/m) 이라고 한다. 보통은 O(n)보다 낮은 시간복잡도를 가진다고 한다. <br>
언제가 최악이냐 하면, 아래 사진처럼 주어진 seq 서열에서 중복되는 부분이 많을 때이다. 중복이 많은 seq서열에서, Boyer-Moore 알고리즘은 pattern을 건너뛰는 대신, 계속해서 문자를 하나씩 비교하는 방식, 즉 바보같은 Brute Force 알고리즘이 되어버리기 때문이다. 중복이 많으면 BCR, GSR이 잘 작동할 수 가 없기 때문이다.  <br>
최선의 경우는 pattern이 잘 맞는 경우이다. 이때는 BCR과 GSR 휴리스틱이 잘 작동해서 융통성있게 딱 비교할 부분만 비교하고, 비교 안해도 되는 부분은 건너뛸 수가 있는 것이다. 일반적으로, 문자 집합 크기(alphabet size)에 비례하여 pattern이 얼마나 효과적으로 건너뛰어지는지에 따라 최선의 경우 O(n/m) 시간이 걸린다고 한다. 

## source
my naver blog (https://blog.naver.com/yangyangjiji)
