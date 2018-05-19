# Data Compression using Arithmetic Coding

Analyze and source codes included.

In example folder, there are three examples of term paper.

In arithmetic folder, there are programmes of arithmetic coding.
use this cmd to compile all the programmes:
```shell
javac *.java
```

Then use this cmd to compress files:
```shell
java AdaptiveArithmeticCompress inputFile outputFile
```
This one to decompress:
```shell
java AdaptiveArithmeticDecompress InputFile OutputFile
```

In huffman folder, use the same cmd to compile. And to compress and decompress:
```shell
java Huffman - < input.txt > output.txt  //(compress)
java Huffman + < input.txt > output.txt  //(expand)
```

You can find more in the comments of both programmes (or other java files)

Under these two folders, there are three files for test: HuckleBerry.txt, PrideAndPrejudice.txt and test.jpeg.
