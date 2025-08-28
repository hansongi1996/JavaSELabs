package mylab.book.control;

import mylab.book.entity.*;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class StatisticsAnalyzer {

    // 1) 타입별 평균 가격
    public Map<String, Double> calculateAveragePriceByType(Publication[] publications) {
        Map<String, Integer> sum = new HashMap<>();
        Map<String, Integer> cnt = new HashMap<>();

        for (Publication p : publications) {
            String type = getPublicationType(p);
            sum.put(type, sum.getOrDefault(type, 0) + p.getPrice());
            cnt.put(type, cnt.getOrDefault(type, 0) + 1);
        }

        Map<String, Double> avg = new HashMap<>();
        for (String type : sum.keySet()) {
            avg.put(type, sum.get(type) / (double) cnt.get(type));
        }
        return avg;
    }

    // 2) 출판물 유형 분포(백분율)
    public Map<String, Double> calculatePublicationDistribution(Publication[] publications) {
        Map<String, Integer> cnt = new HashMap<>();
        for (Publication p : publications) {
            String type = getPublicationType(p);
            cnt.put(type, cnt.getOrDefault(type, 0) + 1);
        }

        Map<String, Double> ratio = new HashMap<>();
        int total = publications.length;
        for (String type : cnt.keySet()) {
            ratio.put(type, (cnt.get(type) * 100.0) / total);
        }
        return ratio;
    }

    // 3) 특정 연도 출판 비율
    public double calculatePublicationRatioByYear(Publication[] publications, String year) {
        int hit = 0;
        for (Publication p : publications) {
            if (p.getPublishDate() != null && p.getPublishDate().startsWith(year)) {
                hit++;
            }
        }
        return (hit * 100.0) / publications.length;
    }

    // 4) 타입 이름 헬퍼
    private String getPublicationType(Publication pub) {
        if (pub instanceof Novel) return "소설";
        if (pub instanceof Magazine) return "잡지";
        if (pub instanceof ReferenceBook) return "참고서";
        return "기타";
    }

    // 5) 통계 출력
    public void printStatistics(Publication[] publications) {
        DecimalFormat money = new DecimalFormat("#,###");
        DecimalFormat percent = new DecimalFormat("#0.00");

        // 평균 가격
        Map<String, Double> avg = calculateAveragePriceByType(publications);
        // 분포
        Map<String, Double> dist = calculatePublicationDistribution(publications);
        // 2007 비율
        double y2007 = calculatePublicationRatioByYear(publications, "2007");

        System.out.println("1. 타입별 평균 가격:");
        if (avg.containsKey("소설"))
            System.out.println("   - 소설: " + money.format(Math.round(avg.get("소설"))) + "원");
        if (avg.containsKey("참고서"))
            System.out.println("   - 참고서: " + money.format(Math.round(avg.get("참고서"))) + "원");
        if (avg.containsKey("잡지"))
            System.out.println("   - 잡지: " + money.format(Math.round(avg.get("잡지"))) + "원");
        System.out.println();

        System.out.println("2. 출판물 유형 분포:");
        System.out.println("   - 소설: " + percent.format(dist.getOrDefault("소설", 0.0)) + "%");
        System.out.println("   - 참고서: " + percent.format(dist.getOrDefault("참고서", 0.0)) + "%");
        System.out.println("   - 잡지: " + percent.format(dist.getOrDefault("잡지", 0.0)) + "%");
        System.out.println();

        System.out.println("3. 2007년에 출판된 출판물 비율: " + percent.format(y2007) + "%");
    }
}