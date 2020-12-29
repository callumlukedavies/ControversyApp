package com.example.controversyapp;

import java.util.HashMap;
import java.util.Map;

public class PoliticsCard {

    private String title;
    private String desc;
    private String supportString;
    private String oppositionString;

    String[] keys = {"trump","atomic","elecproc","guncont","defundpol",
            "fakenews", "redis", "capital","social","crimenpolice", "deathpen",
            "boris", "brexit", "immigration", "weed", "covidrules", "econpub",
            "labour", "conserv", "election", "queen", "monarch"};

    Map<String, String> descriptions = new HashMap<String, String>();
    Map<String, String> titles = new HashMap<String, String>();
    Map<String, String> support = new HashMap<String, String>();
    Map<String, String> opposition = new HashMap<String, String>();

    public PoliticsCard(int keyNo){
        String key = keys[keyNo];


        descriptions.put("trumpbiden", "Donald Trump, former businessman and " +
                "current president of the USA stands against Joe biden, a " +
                "former vice president and senator in the 2020 elections. Who" +
                " will win?");
        descriptions.put("atomic", "Nuclear weapons are the most dangerous " +
                "weapons on earth. One can destroy a whole city, potentially " +
                "killing millions, and jeopardizing the natural environment " +
                "and lives of future generations through its long-term " +
                "catastrophic effects.");
        descriptions.put("elecproc", "The president must: 1) Be a " +
                "natural-born citizen of the United States, 2) Be at least 35" +
                " years old, 3) Have been a resident of the United States for" +
                " 14 years.");
        descriptions.put("guncont", "Gun control (or firearms regulation) is " +
                "the set of laws or policies that regulate the manufacture, " +
                "sale, transfer, possession, modification, or use of firearms" +
                " by civilians.");
        descriptions.put("defundpol", "\"Defund the police\" is a slogan that" +
                " supports divesting funds from police departments and " +
                "reallocating them to non-policing forms of public safety and" +
                " community support, such as social services, youth services," +
                " housing, education, healthcare and other community resources.");
        descriptions.put("fakenews", "Fake news, also known as junk news, " +
                "pseudo-news, alternative facts or hoax news, is a form of " +
                "news consisting of deliberate disinformation or hoaxes " +
                "spread via traditional news media (print and broadcast) or " +
                "online social media.");
        descriptions.put("redis", "Redistribution of income and wealth is the" +
                " transfer of income and wealth (including physical property)" +
                " from some individuals to others by means of a social " +
                "mechanism such as taxation, charity, welfare, public " +
                "services, land reform, monetary policies, confiscation, " +
                "divorce or tort law.");
        descriptions.put("capital", "Capitalism is an economic system based " +
                "on the private ownership of the means of production and " +
                "their operation for profit.");
        descriptions.put("social", "Capitalism is an economic system based on" +
                " the private ownership of the means of production and their " +
                "operation for profit.");
        descriptions.put("crimenpolice", "High police presence is often " +
                "correlated with low crime rates - more police is a deterrent" +
                " to crime. Or is it?");

        desc = descriptions.get(key);

        titles.put("trump", "Donald Trump");
        titles.put("atomic", "Atomic Weapons");
        titles.put("elecproc", "The Presidential Election Process");
        titles.put("guncont", "Gun Control");
        titles.put("defundpol", "Defund the police");
        titles.put("fakenews", "Fake News");
        titles.put("redis", "Redistribution of Wealth");
        titles.put("capital", "Capitalism");
        titles.put("social", "Socialism");
        titles.put("crimenpolice", "Police Presence and Crime Rates");
        titles.put("deathpen", "The Death Penalty");
        titles.put("boris", "Boris Johnson");
        titles.put("brexit", "Brexit");
        titles.put("immigration", "Immigration");
        titles.put("weed", "Legalisation of weed");
        titles.put("covidrules", "Covid19 and the British Government");
        titles.put("econpub", "The Economy vs Public Health");
        titles.put("labour", "The Labour Party");
        titles.put("conserv", "The Conservative Party");
        titles.put("election", "The British Election System");
        titles.put("queen", "The Queen");
        titles.put("monarch", "The Monarchy");
        title = titles.get(key);

        support.put("trump", "Donald Trump is the best political candidate " +
                "for the 2020 presidential election.");
        support.put("atomic", "The UK should invest heavily in atomic weapons" +
                ".");
        support.put("elecproc", "Anyone should be able to run for president.");
        support.put("guncont", "Citizens should be allowed to own a gun.");
        support.put("defundpol", "The Government should cut police funding " +
                "and invest in other public services.");
        support.put("fakenews", "Anyone should be allowed to publish news.");
        support.put("redis", "The Government should redistribute wealth.");
        support.put("capital", "Capitalism is the best economic system.");
        support.put("social", "Socialism would massively improve the state of" +
                " the western countries.");
        support.put("crimenpolice", "High police presence deters crime.");
        support.put("deathpen", "The UK should have a death penalty.");
        support.put("boris", "Boris Johnson is doing a decent job at running " +
                "the british government.");
        support.put("brexit", "Leaving the european union was a great decision" +
                " by the UK public.");
        support.put("immigration", "We should only allow immigrants into the " +
                "country if they have something to offer.");
        support.put("weed", "Weed should be legalized in the uk.");
        support.put("covidrules", "The british government have handled covid19 well.");
        support.put("econpub", "The recovery of the economy takes precedence " +
                "over public health.");
        support.put("labour", "The labour party is the most competent " +
                "political party at running the british government.");
        support.put("conserv", "The conservative party is the most competent " +
                "political party at running the british government.");
        support.put("election", "The british election system is rigged.");
        support.put("queen", "The Royal family should play a more active and " +
                "visible part in the maintenance of the british government.");
        support.put("monarch", "The monarchy is an ancient and archaic system" +
                " which no longer serves the UK.");

        supportString = support.get(key);

//        opposition.put("trumpbiden", "Joe Biden should win the 2020 " +
//                "presidential election.");
//        opposition.put("atomic", "All countries should sign a treaty to " +
//                "destroy all nuclear weapons.");
//        opposition.put("elecproc", "Only people with a career in politics " +
//                "should be allowed to run for president.");
//        opposition.put("guncont", "Citizens should not be allowed to own a " +
//                "gun.");
//        opposition.put("defundpol", "Cutting police spending will not be " +
//                "beneficial to any group in society.");
//        opposition.put("fakenews", "Only commercial entities with a licence " +
//                "should be allowed to publish news.");
//        opposition.put("redis", "The Government should not redistribute wealth.");
//        opposition.put("capital", "Capitalism is a bad economic system.");
//        opposition.put("social", "Socialism would destroy the west.");
//        opposition.put("crimenpolice", "High police presence increases crime" +
//                "rates.");

        oppositionString = opposition.get(key);
    }
    public String getDesc(){
        return desc;
    }
    public String getTitle(){return title;}
    public String getSupportString(){return supportString;}
    public String getOppositionString(){return oppositionString;}
}
