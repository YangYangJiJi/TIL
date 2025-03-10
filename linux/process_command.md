# 프로세스 관리하기 command

## ps
- 현재 실행되고 있는 프로세스들을 보여주는 명령어

```
$ ps [options]
 $ ps aux | grep ‘emacs’
 username 3896 0.0 2.2 56600 44468 ? Ss Sep30 4:29 emacs
 username 22843 0.0 0.0 3900 840 pts/11 S+ 08:49 0:00 grep emacs
```

## kill
- 실행되는 프로그램을 종료하는 명령어

```
$ kill [options] [process id]
```

## top
- 실행되는 프로그램들과 이들의 리소스 사용량을 확인하는 명령어
- `$ top`
