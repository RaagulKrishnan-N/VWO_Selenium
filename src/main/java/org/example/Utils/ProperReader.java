package org.example.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public class ProperReader {
    // It will Read our Property File

    // Empty Constructor

//    static FileInputStream fileInputStream =null; // Giving null avoid creating empty space for static Initially
//    static Properties p = null;
//
//    static Map<String,String> PROP_KEYS = new HashMap<>();  //Using HashMap Reading Files from Property file
//
//    //  Then We're using static to Reading From the file
//
//    static {
//        try {
//            fileInputStream = new FileInputStream(new File(System.getProperty("C:\\Users\\rkrishna01\\IdeaProjects\\Selenium_Framework\\src\\test\\resources\\config.properties")));
//            p = new Properties();
//            p.load(fileInputStream);
//
//            for (Object Key : p.keySet()){
//                PROP_KEYS.put(String.valueOf(Key),p.getProperty(String.valueOf(Key))); // Putting the Values in the PROP_KEYS
//            }
//
//        }catch (Exception e){
//            e.printStackTrace();
//
//        }finally {
//            if(Objects.nonNull(fileInputStream)){  // If not Null Close After Executing the above Code which static is null then it gives value
//                try {
//                    fileInputStream.close();
//                }catch (IOException e2){
//                    e2.printStackTrace();
//                }
//            }
//        }
//    }
//
//    public static String readKey (String key) throws Exception {
//        if (key == null && p.getProperty(key) == null){
//            throw new Exception(p.getProperty(key)+ "Not Found");
//        }else {
//            return PROP_KEYS.get(key);
//        }
//
//    }

    ProperReader(){

    }

    public static String readKey(String key) throws Exception {
        FileInputStream fileInputStream = null;
        Properties p = null;
        try {
            fileInputStream = new FileInputStream(new File("src/test/resources/config.properties")); // Entered Manually
            p = new Properties();
            p.load(fileInputStream);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (Objects.nonNull(fileInputStream)) {
                fileInputStream.close();
            }
        }

        if (p.getProperty(key) == null) {
            throw new Exception(p.getProperty(key) + " not found!!");
        } else {
            return p.getProperty(key);
        }

    }
}
