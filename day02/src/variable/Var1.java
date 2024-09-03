package variable;

public class Var1 {
    public static void main(String[] args) {
        int inputNum = 10; // 변수 이름이 알파벳과 숫자로 구성되어 있으며, 관례적으로 camelCase를 사용. 적절한 변수 이름

        int num1 = 10; // 숫자로 시작하지 않고, 알파벳으로 시작하므로 유효한 변수 이름. 'num1'도 의미를 잘 전달함

        int $num = 10; // '$' 문자는 변수 이름으로 사용 가능하지만, 일반적으로 변수 이름에 잘 사용하지 않음.
                       // '$'는 시스템에서 생성된 변수를 나타내거나 내부적으로 사용될 수 있어 혼동을 줄 수 있음

        int 한글 = 10; // 유니코드를 지원하므로 변수 이름에 한글도 사용 가능. 다만, 코드 가독성과 유지보수를 위해 권장되지 않음.
                      // 대부분의 개발자들이 알파벳 기반의 코드 작성에 익숙하기 때문에, 한글 변수명은 팀 작업 시 혼란을 줄 수 있음

        /* bad case 예시
        int 1num = 10; // 숫자로 시작하는 변수 이름은 허용되지 않음. 변수 이름은 알파벳이나 '$', '_'로 시작해야 함

        int #num = 10; // '#'과 같은 특수문자는 변수 이름에 사용할 수 없음. '$'와 '_'만 허용됨

        int class = 10; // 'class'와 같은 예약어(키워드)는 변수 이름으로 사용할 수 없음
        */

    }
}
