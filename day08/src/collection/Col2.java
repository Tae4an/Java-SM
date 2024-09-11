package collection;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Col2{
    public static void main(String[] args) {
        // 1 부터 45까지 에서 6개의 숫자를 중복되지 않게 추출하시오
        // Set을 사용

        Set<Integer> set = new HashSet<>();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            set.add(random.nextInt(45)+1);
        }
        System.out.println(set);
    }
}
