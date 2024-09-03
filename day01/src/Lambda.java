import java.util.Arrays;
import java.util.List;

public class Lambda {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("홍길동", "최태산", "김철수");

        // 함수형 스타일: 람다 표현식 사용
        names.forEach(name -> System.out.println(name));
    }
}
