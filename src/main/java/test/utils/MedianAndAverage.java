package test.utils;

import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class MedianAndAverage {
    public double findMedian(List<Integer> prices) {
        Collections.sort(prices);
        int n = prices.size();
        if (n % 2 == 0) {
            return (prices.get(n / 2 - 1) + prices.get(n / 2)) / 2.0;
        } else {
            return prices.get(n / 2);
        }
    }
    public double findAverage(List<Integer> prices) {
        double sum = 0;
            for (int j = 0; j < prices.size(); j++) {
                sum += prices.get(j);
            }
            return sum / prices.size();
    }
}
