import edu.sm.dto.CrimeStatistics;
import edu.sm.service.CrimeStatisticsService;

public class Update {
    public static void main(String[] args) {
        CrimeStatisticsService crimeStatisticsService = new CrimeStatisticsService();

        // 업데이트할 CrimeStatistics 객체 생성
        CrimeStatistics crimeStats = CrimeStatistics.builder()
                .id(1) // 업데이트할 레코드의 ID
                .majorCategory("강력범죄")
                .minorCategory("연쇄살인")
                .time00To03(11111)
                .time03To06(31111)
                .time06To09(2)
                .time09To12(4)
                .time12To15(5)
                .time15To18(7)
                .time18To21(966666)
                .time21To24(8)
                .timeUnknown(1)
                .sunday(666666)
                .monday(5)
                .tuesday(4)
                .wednesday(7)
                .thursday(6)
                .friday(8)
                .saturday(8)
                .build();

        try {
            CrimeStatistics updatedStats = crimeStatisticsService.modify(crimeStats);
            System.out.println("범죄 통계 데이터가 성공적으로 업데이트되었습니다:");
            System.out.println("ID: " + updatedStats.getId());
            System.out.println("범죄 대분류: " + updatedStats.getMajorCategory());
            System.out.println("범죄 중분류: " + updatedStats.getMinorCategory());
            System.out.println("00시-03시 발생 건수: " + updatedStats.getTime00To03());
            System.out.println("18시-21시 발생 건수: " + updatedStats.getTime18To21());
            System.out.println("일요일 발생 건수: " + updatedStats.getSunday());
            System.out.println("토요일 발생 건수: " + updatedStats.getSaturday());
        } catch (Exception e) {
            System.out.println("범죄 통계 데이터 수정 중 오류 발생: " + e.getMessage());
            e.printStackTrace();
        }
    }
}