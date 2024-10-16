package edu.sm;

import edu.sm.dto.CrimeStatistics;
import edu.sm.service.CrimeStatisticsService;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final int BATCH_SIZE = 1000; // 한 번에 처리할 데이터 수

    public static void main(String[] args) {
        String csvFile = "C:/경찰청_범죄 발생 시간대 및 요일_20191231.csv";
        CrimeStatisticsService service = new CrimeStatisticsService();
        List<CrimeStatistics> batch = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(csvFile), Charset.forName("MS949")))) {
            String line;
            boolean isFirstLine = true;

            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                String[] values = line.split(",");
                CrimeStatistics stats = createCrimeStatistics(values);
                batch.add(stats);

                if (batch.size() >= BATCH_SIZE) {
                    processBatch(service, batch);
                    batch.clear();
                }
            }
            // 남은 데이터 처리
            if (!batch.isEmpty()) {
                processBatch(service, batch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void processBatch(CrimeStatisticsService service, List<CrimeStatistics> batch) {
        try {
            service.addBatch(batch);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // CSV 파일의 한 줄을 CrimeStatistics 객체로 변환하는 메소드
    private static CrimeStatistics createCrimeStatistics(String[] values) {
        return CrimeStatistics.builder()
                .majorCategory(values[0])
                .minorCategory(values[1])
                .time00To03(Integer.parseInt(values[2]))
                .time03To06(Integer.parseInt(values[3]))
                .time06To09(Integer.parseInt(values[4]))
                .time09To12(Integer.parseInt(values[5]))
                .time12To15(Integer.parseInt(values[6]))
                .time15To18(Integer.parseInt(values[7]))
                .time18To21(Integer.parseInt(values[8]))
                .time21To24(Integer.parseInt(values[9]))
                .timeUnknown(Integer.parseInt(values[10]))
                .sunday(Integer.parseInt(values[11]))
                .monday(Integer.parseInt(values[12]))
                .tuesday(Integer.parseInt(values[13]))
                .wednesday(Integer.parseInt(values[14]))
                .thursday(Integer.parseInt(values[15]))
                .friday(Integer.parseInt(values[16]))
                .saturday(Integer.parseInt(values[17]))
                .build();
    }
}