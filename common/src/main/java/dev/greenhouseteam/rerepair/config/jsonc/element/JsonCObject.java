package dev.greenhouseteam.rerepair.config.jsonc.element;

import com.google.gson.internal.LinkedTreeMap;
import dev.greenhouseteam.rerepair.config.jsonc.JsonCStringBuilder;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

public class JsonCObject extends JsonCElement {
    private final Map<String, JsonCElement> elements = new LinkedTreeMap<>(false);

    public Map<String, JsonCElement> elements() {
        return Map.copyOf(this.elements);
    }

    public void addElement(String key, JsonCElement element) {
        this.elements.put(key, element);
    }

    @Override
    protected void writeJson(JsonCStringBuilder jsonWriter) throws IOException {
        jsonWriter.comments(this.comments());
        jsonWriter.beginObject();
        for (Map.Entry<String, JsonCElement> e : elements().entrySet()) {
            jsonWriter.comments(e.getValue().comments());
            jsonWriter.key(e.getKey());
            e.getValue().writeJson(jsonWriter);
        }
        jsonWriter.endObject();
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.elements(), this.comments());
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof JsonCObject object)) {
            return false;
        }
        return object.elements().equals(this.elements()) && object.comments().equals(this.comments());
    }
}
