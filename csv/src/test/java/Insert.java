import edu.sm.dto.CrimeStatistics;
import edu.sm.service.CrimeStatisticsService;

public class Insert {
    public static void main(String[] args) {
        CrimeStatisticsService crimeStatisticsService = new CrimeStatisticsService();

        // 샘플 CrimeStatistics 객체
        CrimeStatistics crimeStats = CrimeStatistics.builder()
                .majorCategory("사이버범죄")
                .minorCategory("사이버불링")
                .time00To03(5)
                .time03To06(2)
                .time06To09(1)
                .time09To12(3)
                .time12To15(4)
                .time15To18(6)
                .time18To21(8)
                .time21To24(7)
                .timeUnknown(1)
                .sunday(5)
                .monday(4)
                .tuesday(3)
                .wednesday(6)
                .thursday(5)
                .friday(7)
                .saturday(7)
                .build();

        try {
            // 생성된 CrimeStatistics 객체를 데이터베이스에 추가
            CrimeStatistics addedStats = crimeStatisticsService.add(crimeStats);
            System.out.println("Add ID: " + addedStats.getId());
        } catch (Exception e) {
            System.out.println("범죄 통계 추가 중 오류 발생: " + e.getMessage());
            e.printStackTrace();
        }
    }
}