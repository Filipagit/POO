package testes.t2021;

import java.util.Comparator;
import java.util.Map;

public class MapEntryComparator implements Comparator<Map.Entry<String, Double>> {
    public int compare(Map.Entry<String, Double> m1, Map.Entry<String, Double> m2) {

        if (m2.getValue().equals(m1.getValue()))
            return m2.getKey().compareTo(m1.getKey());

        else
            return m1.getValue().compareTo(m2.getValue());
    }
}
