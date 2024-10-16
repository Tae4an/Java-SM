import edu.sm.dto.CrimeStatistics;
import edu.sm.service.CrimeStatisticsService;

import java.util.List;

public class Select {
    public static void main(String[] args) {
        CrimeStatisticsService crimeStatisticsService = new CrimeStatisticsService();
        List<CrimeStatistics> crimeStatsList = null;

        try {
            crimeStatsList = crimeStatisticsService.get();

            if (crimeStatsList != null && !crimeStatsList.isEmpty()) {
                System.out.println("조회된 범죄 통계 데이터:");
                System.out.println("ID | 범죄 대분류 | 범죄 중분류 | 00-03시 | 03-06시 | 06-09시 | 09-12시 | 12-15시 | 15-18시 | 18-21시 | 21-24시 | 미상 | 일 | 월 | 화 | 수 | 목 | 금 | 토");
                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
                for (CrimeStatistics stats : crimeStatsList) {
                    System.out.printf("%2d | %s | %s | %d | %d | %d | %d | %d | %d | %d | %d | %d | %d | %d | %d | %d | %d | %d | %d\n",
                            stats.getId(), stats.getMajorCategory(), stats.getMinorCategory(),
                            stats.getTime00To03(), stats.getTime03To06(), stats.getTime06To09(),
                            stats.getTime09To12(), stats.getTime12To15(), stats.getTime15To18(),
                            stats.getTime18To21(), stats.getTime21To24(), stats.getTimeUnknown(),
                            stats.getSunday(), stats.getMonday(), stats.getTuesday(),
                            stats.getWednesday(), stats.getThursday(), stats.getFriday(), stats.getSaturday());
                }
                System.out.println("총 " + crimeStatsList.size() + "개의 범죄 데이터");
            } else {
                System.out.println("조회된 범죄 통계 데이터가 없습니다.");
            }
        } catch (Exception e) {
            System.out.println("범죄 통계 데이터 조회 중 오류 발생: " + e.getMessage());
            e.printStackTrace();
        }
    }
}