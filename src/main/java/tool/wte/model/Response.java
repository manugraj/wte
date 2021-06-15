package tool.wte.model;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Response {
    public List<Map> getData() {
        return data;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Response(List<Map> data, String info) {
        this.data = Collections.unmodifiableList(data);
        this.info = info;
    }

    public Response(String info) {
        this(List.of(), info);
    }


    public Response(List<Map> data) {
        this(data, null);
    }

    private final List<Map> data;
    private String info;
}
