package mylab.book.control;

import mylab.book.entity.*;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class StatisticsAnalyzer {

    // 1) Ÿ�Ժ� ��� ����
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

    // 2) ���ǹ� ���� ����(�����)
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

    // 3) Ư�� ���� ���� ����
    public double calculatePublicationRatioByYear(Publication[] publications, String year) {
        int hit = 0;
        for (Publication p : publications) {
            if (p.getPublishDate() != null && p.getPublishDate().startsWith(year)) {
                hit++;
            }
        }
        return (hit * 100.0) / publications.length;
    }

    // 4) Ÿ�� �̸� ����
    private String getPublicationType(Publication pub) {
        if (pub instanceof Novel) return "�Ҽ�";
        if (pub instanceof Magazine) return "����";
        if (pub instanceof ReferenceBook) return "����";
        return "��Ÿ";
    }

    // 5) ��� ���
    public void printStatistics(Publication[] publications) {
        DecimalFormat money = new DecimalFormat("#,###");
        DecimalFormat percent = new DecimalFormat("#0.00");

        // ��� ����
        Map<String, Double> avg = calculateAveragePriceByType(publications);
        // ����
        Map<String, Double> dist = calculatePublicationDistribution(publications);
        // 2007 ����
        double y2007 = calculatePublicationRatioByYear(publications, "2007");

        System.out.println("1. Ÿ�Ժ� ��� ����:");
        if (avg.containsKey("�Ҽ�"))
            System.out.println("   - �Ҽ�: " + money.format(Math.round(avg.get("�Ҽ�"))) + "��");
        if (avg.containsKey("����"))
            System.out.println("   - ����: " + money.format(Math.round(avg.get("����"))) + "��");
        if (avg.containsKey("����"))
            System.out.println("   - ����: " + money.format(Math.round(avg.get("����"))) + "��");
        System.out.println();

        System.out.println("2. ���ǹ� ���� ����:");
        System.out.println("   - �Ҽ�: " + percent.format(dist.getOrDefault("�Ҽ�", 0.0)) + "%");
        System.out.println("   - ����: " + percent.format(dist.getOrDefault("����", 0.0)) + "%");
        System.out.println("   - ����: " + percent.format(dist.getOrDefault("����", 0.0)) + "%");
        System.out.println();

        System.out.println("3. 2007�⿡ ���ǵ� ���ǹ� ����: " + percent.format(y2007) + "%");
    }
}