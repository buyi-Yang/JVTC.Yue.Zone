# BigInteger

```java
import java.math.BigInteger;

public class BigIntegerDemo {
    public static void main(String[] args) {
        // 声明一个大整数
        BigInteger bigInt = BigInteger.ZERO;

        // 加
        bigInt = bigInt.add(BigInteger.valueOf(8));

        // 减
        bigInt = bigInt.subtract(BigInteger.valueOf(3));

        // 乘
        bigInt = bigInt.multiply(BigInteger.valueOf(2));

        // 除
        bigInt = bigInt.divide(BigInteger.valueOf(3));

        // 指定进制转换
        System.out.println(bigInt.toString(16));
    }
}
```
