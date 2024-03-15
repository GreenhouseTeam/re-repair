package dev.greenhouseteam.rerepair.config.jsonc.element;

import com.google.gson.JsonNull;
import dev.greenhouseteam.rerepair.config.jsonc.JsonCStringBuilder;

public final class JsonCNull extends JsonCElement {
    public static final JsonCNull INSTANCE = new JsonCNull();

    private JsonCNull() {

    }

    @Override
    protected void writeJson(JsonCStringBuilder jsonWriter) {

    }

    @Override
    public int hashCode() {
        return JsonCNull.class.hashCode();
    }

    @Override
    public boolean equals(Object other) {
        return other instanceof JsonCNull;
    }
}
