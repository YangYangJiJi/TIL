# R에서 저장방법

## PNG 형식으로 저장
```
png("plot_example.png", width = 800, height = 600)
plot(1:10, 1:10, main = "Example Plot", xlab = "X-axis", ylab = "Y-axis")
dev.off()  # 파일 저장 완료
```

## PDF 형식으로 저장
```
pdf("plot_example.pdf", width = 7, height = 5)
plot(1:10, 1:10, main = "Example Plot", xlab = "X-axis", ylab = "Y-axis")
dev.off()  # 파일 저장 완료
```

## 데이터 저장 
```
a <- c(1, 2, 3)
b <- c("A", "B", "C")
df <- data.frame(id = 1:3, value = c(10, 20, 30))
```

**1. 변수 저장**
```
save(a, file = "a.RData")
```

**2. 여러 변수 저장**
```
save(a, b, df, file = "variables.RData")
```

**3. 작업 환경 저장**
```
save.image(file = "full_workspace.RData")
```

**4. CSV 파일 저장**
```
write.csv(df, file = "data.csv", row.names = FALSE)
```

**5. 텍스트 파일 저장**
```
write.table(df, file = "data.txt", sep = "\t", row.names = FALSE)
```
