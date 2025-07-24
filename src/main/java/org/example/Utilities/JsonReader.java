package org.example.Utilities;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class JsonReader {
    //mapper.readValue(...) is used to read the JSON file.
    //
    //filePath is the path to your JSON file.
    //
    //new TypeReference<>() {} tells Jackson:
    //
    //"Convert the JSON into a List of HashMaps, where both keys and values are Strings."
    public static Object[][] getjsondataashashmap(String filepath) throws IOException {
        ObjectMapper mappervalue=new ObjectMapper();
        List <HashMap<String,String>> datalist=mappervalue.readValue(new File(filepath), new TypeReference<>(){});
        Object [][]result=new Object[datalist.size()][1];
        for(int i=0;i<datalist.size();i++){
            result[i][0]=datalist.get(i);
        }

        return result;
    }
}
