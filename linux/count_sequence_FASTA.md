# Multiple Fasta 파일에 몇 개의 서열이 들어있는지 확인해보기
- 예시 파일은 Acanthaster_planci의 Protein 서열 파일을 사용

```
# wget 명령을 통해 파일을 다운로드 합니다.
$ wget https://ftp.ncbi.nlm.nih.gov/genomes/Acanthaster_planci/protein/protein.fa.gz

# gunzip 명령을 통해 압축을 풉니다.
$ gunzip protein.fa.gz

# grep 명령어를 통해 ">" 가 들어간 라인을 찾습니다.
# Fasta 서열은 ">"를 기준으로 구분할 수 있습니다.
# wc-l 명령을 통해 출력된 라인 수를 셉니다.
# wc 명령어는 단어나 라인등의 숫자를 세주는 명령어 입니다. -l 옵션을 주어 라인수를 셉니다.
# | 를 통해 두 명령어를 연결하여 사용할 수 있습니다.
# 왼쪽 실행 결과가 오른쪽 명령어의 입력으로 들어갑니다.
$ grep ">" protein.fa | wc-l
33214
```