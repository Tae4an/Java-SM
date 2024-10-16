import edu.sm.service.CrimeStatisticsService;

public class Delete {
    public static void main(String[] args) {
        CrimeStatisticsService crimeStatisticsService = new CrimeStatisticsService();
        Integer id = 39; // 삭제할 레코드의 ID

        try {
            boolean isDeleted = crimeStatisticsService.remove(id);
            if (isDeleted) {
                System.out.println("ID " + id + " 삭제");
            } else {
                System.out.println("ID " + id + " 삭제하지 못했습니다.");
            }
        } catch (Exception e) {
            System.out.println("범죄 통계 데이터 삭제 중 오류 발생: " + e.getMessage());
            e.printStackTrace();
        }
    }
}