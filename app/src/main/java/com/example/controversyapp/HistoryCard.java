package com.example.controversyapp;

import java.util.HashMap;
import java.util.Map;

public class HistoryCard {
    String title;
    String desc;
    String supportString;

    String[] keys = {"viet","beng","9/11","colon","hiro","pyramids","nazis",
            "assassin","ispal", "stoneage"};

    Map<String, String> descriptions = new HashMap<String, String>();
    Map<String, String> titles = new HashMap<String, String>();
    Map<String, String> support = new HashMap<String, String>();

    public HistoryCard(int keyNo){
        String key = keys[keyNo];

        titles.put("viet", "Vietnam War");
        titles.put("beng", "Benghazi");
        titles.put("9/11", "George Bush did 9/11");
        titles.put("colon", "British Colonialism");
        titles.put("hiro", "Bombings of Hiroshima");
        titles.put("pyramids", "The Pyramids of Egypt");
        titles.put("nazis", "Nazi's");
        titles.put("moon", "Moon Landing");
        titles.put("assassin", "Assassination of JFK");
        titles.put("ispal", "Israeli/Palestinian Conflict");
        titles.put("stoneage", "The Stone Age");
        title = titles.get(key);

        support.put("viet", "The vietnamese war was a heroic effort to " +
                "eradicate the dangerous spread of communism.");
        support.put("beng", "The 2012 Benghazi attacks could have been " +
                "prevented.");
        support.put("9/11", "George Bush organised the 9/11 attacks.");
        support.put("colon", "British colonialism had a net positive effect " +
                "on the world.");
        support.put("hiro", "The bombings of Hiroshima and Nagasaki were a " +
                "necessary attack. ");
        support.put("pyramids", "Aliens gave the egyptians the technology to " +
                "build the pyramids.");
        support.put("nazis", "Nazis should not have been held responsible for" +
                " their beliefs, since the vast majority fell prey to " +
                "brainwashing and propaganda.");
        support.put("moon", "The apollo moon landing was a hoax.");
        support.put("assassin", "Assassination of The government assassinated" +
                " JFK.");
        support.put("ispal", "The land of Israel belongs to the Jewish people" +
                ".");
        support.put("stoneage", "Humans were better off before the advent of " +
                "farming.");
        supportString = support.get(key);
    }
    public String getDesc(){
        return desc;
    }
    public String getTitle(){return title;}
    public String getSupportString(){return supportString;}
}
