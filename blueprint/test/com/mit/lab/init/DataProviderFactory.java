package com.mit.lab.init;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

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
}
