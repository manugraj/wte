package tool.wte.utils;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Maps {

    public static Map<String, Object> flatten(Map<String, Object> map) {
        return flatten(map, ".");
    }

    public static Map<String, Object> flatten(Map<String, Object> map, String delimiter) {
        return map.entrySet().stream()
                .flatMap(k->Maps.flatten0(k.getKey(), delimiter,k))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private static Stream<Map.Entry<String, ?>> flatten0(String base, String delimiter, Map.Entry<String, ?> entry) {
        if (entry.getValue() instanceof Map) {
            return ((Map<String,?>) entry.getValue()).entrySet().stream().map(k->Map.entry(String.format("%s%s%s",base,delimiter,k.getKey()), k.getValue())).flatMap(k->Maps.flatten0(k.getKey(), delimiter,k));
        }
        return Stream.of(entry);
    }

}