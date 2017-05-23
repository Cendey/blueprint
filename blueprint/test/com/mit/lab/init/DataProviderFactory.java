package com.mit.lab.init;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import com.mit.lab.meta.Items;
import org.testng.annotations.DataProvider;

import com.mit.lab.intf.UseInstance;
import com.mit.lab.norm.FileWriterEAM;
import com.mit.lab.norm.FireEngines;
import com.mit.lab.norm.FluentMailer;
import com.mit.lab.norm.Holder;
import com.mit.lab.norm.Word;

/**
 * <p>Project    : Blueprint</p>
 * <p>Description: DataProviderFactory</p>
 * <p>Copyright  : Copyright (c) 2014, All right reserved.</p>
 * <p>Company    : MIT-LAB Co., Ltd</p>
 *
 * @author Developer
 * @version 1.0
 * @date 4/30/2014
 */
public class DataProviderFactory {

    @DataProvider(name = "file-writer-arm-factory")
    public static Object[][] generateFileWriterARM() {
        return new Object[][]{new Object[]{"peek-a-boo"}};
    }

    @DataProvider(name = "file-writer-eam-factory")
    public static Object[][] generateFileWriterEAM() {
        UseInstance<FileWriterEAM, IOException> useInstance = fileWriterEAM -> fileWriterEAM.writeStuff("sweet");
        return new Object[][]{new Object[]{"eam.txt", useInstance}};
    }

    @DataProvider(name = "mailer-factory")
    public static Object[][] generateMailer() {
        Consumer<FluentMailer> fluentMailerConsumer = mailer -> mailer.from("build@agiledeveloper.com")
            .to("venkats@agiledeveloper.com").subject("build notification").body("...much better...");
        return new Object[][]{new Object[]{fluentMailerConsumer}};
    }

    @DataProvider(name = "holder-factory")
    public static Object[][] generateHolder() {
        Holder instance = new Holder();
        return new Object[][]{new Object[]{instance}, new Object[]{instance}, new Object[]{instance}};
    }

    @DataProvider(name = "fire-engine-factory")
    public static Object[][] generateFireEngines() {
        return new Object[][]{new Object[]{new FireEngines<>()}, new Object[]{new FireEngines<>(50.5)}};
    }

    @DataProvider(name = "worlds-factory")
    public static Object[][] generateWorlds() {
        Word contents = new Word();
        return new Object[][]{
            new Object[]{contents, "i just wanna be with you! do you know?"},
            new Object[]{contents, "but and i wanna know who is in your heart. just yourself or someone else?"},
            new Object[]{contents, "go out or stay at home!"},
            new Object[]{contents, "this is so beautiful,then as the owner i will keep of it!"}};
    }

    @DataProvider(name = "register-factory")
    public static Object[][] generateRegister() {
        return new Object[][]{
            new Object[]{"Developer"}, new Object[]{"Dina"},
            new Object[]{"JavaDeveloper@sskaje.me"}, new Object[]{"Tina"}};
    }

    @DataProvider(name = "date-factory")
    public static Object[][] generateDate() {
        String value = "yyyyMMddHHmm";
        return new Object[][]{
            new String[]{"20141231145800", value}, new String[]{"20150113180000", value},
            new String[]{"20151231135800", value}, new String[]{"20131230190000", value},
            new String[]{"20140228190000", value}};
    }

    @DataProvider(name = "string-factory")
    public static Object[][] generateString() {
        return new Object[][]{
            new String[]{"A |B| C|D", "\\|"},
            new String[]{"Hello, World! ^ I'm a programmer for java!", "\\^"}, new String[]{"OP-SE-BL", "-"},
            new String[]{"OP-SE-CONSOL", "-"}, new String[]{"OP-SE-BOOKING", "-"}};
    }

    @DataProvider(name = "bizrule-factory")
    public static Object[][] generateBizRule() {
        Map<String, String> source = new HashMap<String, String>();
        source.put("com.mit.lab.norm.BizRule", "Biz Rule");
        source.put("java.util.HashMap", "Hash Map");
        source.put("java.util.ArrayList", "Array List");
        source.put("com.mit.lab.norm.Person", "Person");
        source.put("Truck", "com.mit.lab.norm.Truck");
        source.put("com.mit.lab.norm.Album", "Album");
        source.put("com.mit. lab.norm.Artist", "Artist");
        source.put("com.mit.lab.norm. DatePlain", "Data Plain");
        source.put(" com.mit .lab.norm.Track", "Track");
        return new Object[][]{new Object[]{source}, new Object[]{null}};
    }

    @DataProvider(name = "solution-factory")
    public static Object[][] generateNumbers() {
        return new Object[][]{
            new Object[]{5, 3},
            new Object[]{1, 3, 5, 7, 9},
            new Object[]{5, 3, 4, 7, 6, 13, 9},
            new Object[]{1, 5, 3, 3, 7},
            new Object[]{1, 5, 3, 3, 4, 7},
            new Object[]{1, 3, 5, 3, 4},
            new Object[]{10, 3, 5, 7, 2}};
    }

    @DataProvider(name = "parking-time-factory")
    public static Object[][] generateParking() {
        return new Object[][]{
            new String[]{"10:00", "15:30"},
            new String[]{"00:00", "00:15"},
            new String[]{"09:00", "09:59"},
            new String[]{"10:30", "11:31"},
            new String[]{"18:00", "19:01"}};
    }

    @DataProvider(name = "collections-factory")
    public static Object[][] generateCollections() {
        return new Object[][]{
            new Object[]{
                new ArrayList<Map<String, Object>>() {{
                    add(new HashMap<String, Object>() {{
                        put("sno.", 1);
                        put("unid", 80);
                    }});
                    add(new HashMap<String, Object>() {{
                        put("sno.", 2);
                        put("unid", 120);
                    }});
                    add(new HashMap<String, Object>() {{
                        put("sno.", 3);
                        put("unid", 40);
                    }});
                }}, "unid"},
            new Object[]{
                new ArrayList<Map<String, Object>>() {{
                    add(new HashMap<String, Object>() {{
                        put("sno.", 4);
                        put("unid", 10);
                    }});
                    add(new HashMap<String, Object>() {{
                        put("sno.", 5);
                        put("unid", 1);
                    }});
                }}, "unid"}};
    }

    @DataProvider(name = "seat-factory")
    public static Object[][] generateSeats() {
        return new Object[][]{
            new Object[]{2, "1A 2F 1C"},
            new Object[]{1, ""},
            new Object[]{10, "1A 1J 2C 2E 3F 3K"}};
    }

    @DataProvider(name = "division-factory")
    public static Object[][] generateDivision() {
        return new Object[][]{
            new Integer[]{4, 5, 1, 1, 1, 1, 4, 3, 1},
            new Integer[]{-1, 3, -4, 5, 1, -6, 2, 1},
            new Integer[]{1, -8, 16, -7, 100, -1, -2, 9, -13},
            new Integer[]{10, 80, -100, 32}};
    }

    @DataProvider(name = "script-factory")
    public static Object[][] generateScript() {
        return new Object[][]{
            new Object[]{new Items(5, 7), "item.setResult((item.num <= 15 && item.num >= 1) || (item.pos != -1))"},
            new Object[]{new Items(20, -1), "item.setResult((item.num <= 15 && item.num >= 1) || (item.pos != -1))"},
            new Object[]{
                new Items("U", null), "item.setResult(item.status!=\"S\" || (typeof item.limited!=\"undefined\"))"},
            new Object[]{
                new Items("S", null), "item.setResult(item.status==\"S\" && (typeof item.limited!=\"undefined\"))"},
            new Object[]{new Items("F", "Y"), "item.setResult(item.status==\"F\" && !item.limited)"}
        };
    }
}
