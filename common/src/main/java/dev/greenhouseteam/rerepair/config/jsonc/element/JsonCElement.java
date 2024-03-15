package dev.greenhouseteam.rerepair.config.jsonc.element;

import com.google.common.collect.ImmutableList;
import dev.greenhouseteam.rerepair.ReRepair;
import dev.greenhouseteam.rerepair.config.ReRepairConfig;
import dev.greenhouseteam.rerepair.config.jsonc.JsonCStringBuilder;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;

public abstract class JsonCElement {
    private List<String> comments = List.of();

    public List<String> comments() {
        return this.comments;
    }

    public void addComment(String comment) {
        ImmutableList.Builder<String> builder = ImmutableList.builder();
        builder.addAll(this.comments());
        builder.add(comment);
        this.comments = builder.build();
    }

    public void setComments(List<String> comment) {
        this.comments = comment;
    }

    @Override
    public String toString() {
        try {
            StringWriter writer = new StringWriter();
            write(writer);
            return writer.toString();
        } catch (IOException ex) {
            ReRepair.LOG.info("Failed to write JSONC to string. " + ex);
        }
        return "";
    }

    public void write(Writer writer) throws IOException {
        JsonCStringBuilder stringWriter = new JsonCStringBuilder(writer);
        writeJson(stringWriter);
    }

    protected abstract void writeJson(JsonCStringBuilder writer) throws IOException;

}
