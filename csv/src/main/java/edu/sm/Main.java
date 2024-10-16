package edu.sm;

import edu.sm.dto.CrimeStatistics;
import edu.sm.service.CrimeStatisticsService;

import java.io.*;
import java.nio.charset.Charset;

public class Main {
    public static void main(String[] args) {
        String csvFile = "C:/경찰청_범죄 발생 시간대 및 요일_20191231.csv";
        CrimeStatisticsService service = new CrimeStatisticsService();

//        try (BufferedReader br = new BufferedReader(
//                new InputStreamReader(new FileInputStream(csvFile), Charset.forName("MS949")))) {
//            String line;
//            boolean isFirstLine = true;
//
//            while ((line = br.readLine()) != null) {
//                // CSV 파일의 첫 번째 줄(헤더)은 건너뜀(실제 데이터가 아님)
//                if (isFirstLine) {
//                    isFirstLine = false;
//                    continue;
//                }
//
//                // 쉼표로 구분된 값들을 배열로 분리
//                String[] values = line.split(",");
//
//                // CrimeStatistics 객체를 생성하고 값을 설정
//                CrimeStatistics stats = createCrimeStatistics(values);
//
//                try {
//                    // 생성된 CrimeStatistics 객체를 데이터베이스에 추가
//                    service.add(stats);
//                    System.out.println("Success");
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        // csv 파일을 읽어서 출력
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(csvFile), Charset.forName("MS949")))) {
            String line;

            // 원본 데이터 출력
//            while ((line = br.readLine()) != null) {
//                System.out.println(line);
//            }

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                for (String value : values) {
                    System.out.print(value + " ");
                }
                System.out.println();
            }
        } catch (IOException e) {
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