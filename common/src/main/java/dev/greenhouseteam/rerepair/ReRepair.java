package dev.greenhouseteam.rerepair;

import com.google.gson.JsonPrimitive;
import dev.greenhouseteam.rerepair.config.ReRepairConfig;
import dev.greenhouseteam.rerepair.config.jsonc.JsonCOps;
import dev.greenhouseteam.rerepair.config.jsonc.element.JsonCArray;
import dev.greenhouseteam.rerepair.config.jsonc.element.JsonCElement;
import dev.greenhouseteam.rerepair.config.jsonc.element.JsonCObject;
import dev.greenhouseteam.rerepair.config.jsonc.element.JsonCPrimitive;
import net.minecraft.world.phys.Vec3;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ReRepair {
    public static final String MOD_ID = "rerepair";
    public static final String MOD_NAME = "Re-Repair";
    public static final Logger LOG = LoggerFactory.getLogger(MOD_NAME);

    public static void init() {
        JsonCObject object = new JsonCObject();
        object.setComments(List.of("Magic will happen here...", "Watch and see."));

        JsonCPrimitive witchDoctor = new JsonCPrimitive(new JsonPrimitive("bing bang."));
        witchDoctor.addComment("Ooh eee ooh a a");
        witchDoctor.addComment("Ting tang");
        object.addElement("walla_walla", witchDoctor);

        JsonCArray array = new JsonCArray();
        array.addElement(new JsonCPrimitive(new JsonPrimitive("Sorry")));
        array.addElement(new JsonCPrimitive(new JsonPrimitive("for")));
        array.addElement(new JsonCPrimitive(new JsonPrimitive("that...")));
        array.addElement(new JsonCPrimitive(new JsonPrimitive(":(")));
        array.addComment("sfdgaoinsfgdoifadnhio awrmupetivg,jum hvgtenvtwramuipvatvhnvmuirnhmbvwpujhnqvruomjguionh pvtamr");
        object.addElement("long_string", array);

        JsonCArray intArray = new JsonCArray();
        intArray.addElement(new JsonCPrimitive(new JsonPrimitive(1)));
        intArray.addElement(new JsonCPrimitive(new JsonPrimitive(2)));
        intArray.addElement(new JsonCPrimitive(new JsonPrimitive(3)));
        intArray.addElement(new JsonCPrimitive(new JsonPrimitive(4)));
        object.addElement("int_array", intArray);

        LOG.info("\n" + object);

        JsonCElement config = ReRepairConfig.COMMON_CODEC.encodeStart(JsonCOps.INSTANCE, ReRepairConfig.DEFAULT).getOrThrow(false, LOG::error);
        LOG.info("\n" + config);

        JsonCElement clientConfig = ReRepairConfig.CLIENT_CODEC.encodeStart(JsonCOps.INSTANCE, ReRepairConfig.DEFAULT).getOrThrow(false, LOG::error);
        LOG.info("\n" + clientConfig);
    }
}