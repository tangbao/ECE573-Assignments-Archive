START=`date +%s%N`;
java AdaptiveArithmeticDecompress PAP.txt PAP_de.txt;
END=`date +%s%N`;
time = $((END-START))
time = `expr $time/100`
echo $time
