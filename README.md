![logo](trojan.png)
# TrojanFactory
Spoof file extensions.


```java
/*
 * 1: file_name (Ex: ann) (after the "ann" and "exe" will be added then it will become "annexe")
 * // to spoof exe file name (see english "https://lotsofwords.com/" words that ends with the wanted extension..
 * // and remove the last letters that matches the extension to make it as a whole file name "word")
 * 
 * 2: rc
 * 3: fake_extension (Ex: pdf)
 * 4: real_extension (Ex: exe)
 * 
 * 3 > reverse < 4
 * fake: "exe.pdf"
 * real "pdf.exe"
 * 
 * with ann:
 * 	annexe.pdf
 */
```
