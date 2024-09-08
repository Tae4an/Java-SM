package workshop;

public class Driver {
    private String name;
    private int age;
    private int license;

    public Driver() {
    }

    public Driver(String name, int age, int license) {
        this.name = name;
        this.age = age;
        this.license = license;
    }

    @Override
    public String toString() {
        String licenseType;
        switch (license) {
            case 1 -> licenseType = "1종 대형";
            case 2 -> licenseType = "1종 보통";
            case 3 -> licenseType = "2종 보통";
            default -> licenseType = "알 수 없음";
        }

        return String.format(
                "┌───────────────────────────────────────────┐\n" +
                        "│              운전자 정보                    │\n" +
                        "├───────────────────────────────────────────┤\n" +
                        "│ 이름: %-10s   │ 나이: %3d세          │\n" +
                        "│ 면허: %-10s                         │\n" +
                        "└───────────────────────────────────────────┘",
                name, age, licenseType
        );
    }
}
