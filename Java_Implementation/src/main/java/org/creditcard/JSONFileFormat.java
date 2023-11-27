package org.creditcard;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JSONFileFormat extends FileFormat{

    JSONFileFormat(String ipfilename, String opfilename) {
        super(ipfilename, opfilename);
    }

    @Override
    void readFile() {
        JSONParser parser = new JSONParser();

        try {
            // Parsing the JSON file
            JSONObject jsonObject = (JSONObject)parser.parse(new FileReader(getIpFileName()));

            JSONArray jsonArray = (JSONArray) jsonObject.get("cards");

            // Accessing elements in the JSONArray
            for (Object o : jsonArray) {
                JSONObject record = (JSONObject) o;
                String values = (String)record.get("cardNumber");
                cardRecords.add(values);
            }
        } catch (IOException | ParseException e) {
            setExceptionRead(e.getMessage());
            System.out.println(e.getMessage());
        }
    }

    @Override
    void writeFile() {
        JSONObject output = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        for(CreditCard card: cards) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("cardType", card.getCardType());
            jsonObject.put("cardNumber", card.getCardNumber());
            jsonArray.add(jsonObject);
        }
        output.put("cards", jsonArray);

        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writerWithDefaultPrettyPrinter();

        // Beautified JSON
        try (FileWriter beautifiedWriter = new FileWriter(getOpFileName())) {
            String beautifiedJson = writer.writeValueAsString(output);
            beautifiedWriter.write(beautifiedJson);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
