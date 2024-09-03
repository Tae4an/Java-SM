package variable;

public class Var6 {
    public static void main(String[] args) {
        // String은 한 번 만들어지면 변경 불가, 변경된 새로운 String 객체가 생성 되는 것

        String str = "xotks@gmail.com";

        // 1. 전체 스트링 길이 출력
        // 문자열의 길이를 구하는 length() 메서드를 사용
        System.out.println("전체 스트링 길이: " + str.length()); // 결과: 15

        // 2. 메일의 아이디만 출력
        // '@' 문자의 위치를 찾고, 문자열의 시작부터 '@' 전까지 잘라서 출력
        String id = str.substring(0, str.indexOf('@'));
        System.out.println("메일 아이디: " + id); // 결과: xotks

        // 3. 메일의 도메인만 출력
        // '@' 다음부터 문자열 끝까지 잘라서 도메인 부분만 출력
        String domain = str.substring(str.indexOf('@') + 1);
        System.out.println("메일 도메인: " + domain); // 결과: gmail.com

        // 4. 도메인 주소를 (gmail.com) char array로 만들어 각 char 출력
        // 문자열 "gmail.com"을 char 배열로 변환한 후, 각 문자를 출력
        String domain2 = str.substring(str.indexOf("@") + 1,str.length());
        System.out.println(domain2);
        char[] domainArray = domain2.toCharArray();
        System.out.println("도메인 배열 출력:");
        for (char c : domainArray) {
            System.out.println(c);
        }
        // 결과:
        // g
        // m
        // a
        // i
        // l
        // .
        // c
        // o
        // m
    }
}
