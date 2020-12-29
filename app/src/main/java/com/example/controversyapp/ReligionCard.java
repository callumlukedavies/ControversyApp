package com.example.controversyapp;

import java.util.HashMap;
import java.util.Map;

public class ReligionCard {
    private String title;
    private String desc;
    private String supportString;
    private String oppositionString;

    String[] keys = {"circ", "sciology", "abort", "genddisc", "existgod",
            "onechurch", "relviolence", "ethjesus", "zionism", "incest",
            "fwvsf", "pros", "covwomen", "holscript", "priests", "isis",
            "islam", "relseg", "monpol"};

    Map<String, String> descriptions = new HashMap<String, String>();
    Map<String, String> titles = new HashMap<String, String>();
    Map<String, String> support = new HashMap<String, String>();
    Map<String, String> opposition = new HashMap<String, String>();

    public ReligionCard(int keyNo) {
        String key = keys[keyNo];

        descriptions.put("circ", "Circumcision is the surgical removal of the" +
                " foreskin, the tissue covering the head (glans) of the penis" +
                ". It is an ancient practice that has its origin in religious" +
                " rites. Today, many parents have their sons circumcised for " +
                "religious or other reasons.");

        descriptions.put("sciology", "Scientology is a set of beliefs and " +
                "practices invented by American author L. Ron Hubbard, and an" +
                " associated movement. It has been variously defined as a " +
                "cult, a business or a new religious movement.");

        descriptions.put("abort", "Abortion is when a pregnancy is ended so " +
                "that it doesn't result in the birth of a child. Sometimes it" +
                " is called 'termination of pregnancy'.");

        descriptions.put("genddisc", "Discrimination in employment and " +
                "opportunity against a person (typically a woman) on grounds " +
                "of sex.");

        descriptions.put("existgod", "The Being perfect in power, wisdom, and" +
                " goodness who is worshipped (as in Judaism, Christianity, " +
                "Islam, and Hinduism) as creator and ruler of the universe.");

        descriptions.put("onechurch", "There are 4300 religions in the world " +
                "that all have different beliefs about god. Is it possible " +
                "that only one of these is the true church of god?");

        descriptions.put("relviolence", "Religious violence is violence that " +
                "is motivated by, or in reaction to, religious precepts, " +
                "texts, or the doctrines of a target or an attacker. Does " +
                "religion encourage violence?");

        descriptions.put("ethjesus", "Many depictions of jesus throughout " +
                "history have shown jesus as a white man. However it is " +
                "recognised by scholars that jesus is not in fact white, but " +
                "middle eastern.");

        descriptions.put("zionism", "Zionism is both an ideology and " +
                "nationalist movement among the Jewish people that espouses " +
                "the re-establishment of and support for a Jewish state in " +
                "the territory defined as the historic Land of Israel.");

        descriptions.put("incest", "Sexual intercourse between persons so " +
                "closely related that they are forbidden by law to marry.");

        descriptions.put("fwvsf", "Free will - Freedom of humans to make " +
                "choices that are not determined by prior causes or by divine" +
                " intervention.\n Fate - A predetermined course of events " +
                "often held to be an irresistible power or agency.");

        descriptions.put("pros", "The act or practice of engaging in " +
                "promiscuous sexual relations especially for money.");

        desc = descriptions.get(key);

        titles.put("circ", "Circumcision");
        titles.put("sciology", "Scientology");
        titles.put("abort", "Abortion");
        titles.put("genddisc", "Gender Discrimination");
        titles.put("existgod", "Existence of God");
        titles.put("onechurch", "One True Church");
        titles.put("relviolence", "Religious Violence");
        titles.put("ethjesus", "Ethnicity of Jesus");
        titles.put("zionism", "Zionism");
        titles.put("incest", "Incest");
        titles.put("fwvsf", "Free Will Vs Fate");
        titles.put("pros", "Prostitution");
        titles.put("covwomen", "Covering of Women");
        titles.put("holscript", "Holy Scriptures");
        titles.put("priests", "Priests");
        titles.put("isis", "ISIS");
        titles.put("islam", "Islamaphobia");
        titles.put("relseg", "Religious Segregation");
        titles.put("monpol", "Monotheism vs Polytheism");


        title = titles.get(key);

        support.put("circ", "The circumcision of a child is the choice of the" +
                " parent.");
        support.put("sciology", "Scientology should be recognized and treated" +
                " as a real religion.");
        support.put("abort", "Abortion should not be considered murder.");
        support.put("genddisc", "Gender discrimination exists in the workplace.");
        support.put("existgod", "God/gods exists.");
        support.put("onechurch", "There is only one church of God.");
        support.put("relviolence", "Religion encourages violence.");
        support.put("ethjesus", "Jesus is a white man.");
        support.put("zionism", "Anti-Zionism is a form of Anti-Semitism.");
        support.put("incest", "Incest relationships should be accepted.");
        support.put("fwvsf", "People have free will.");
        support.put("pros", "Prostitution should be legal.");
        support.put("covwomen", "Women should be covered up when out in " +
                "public settings.");
        support.put("holscript", "Holy scriptures are true.");
        support.put("priests", "Priests who have committed sexual acts " +
                "against minors should be viewed as homosexuals instead of " +
                "paedophiles.");
        support.put("isis", "ISIS is a fringe group of terrorists that does " +
                "not act on the true values of Islam.");
        support.put("islam", "The majority of white british people are " +
                "islamaphobic.");
        support.put("relseg", "Society should separate people based on their " +
                "religious beliefs.");
        support.put("monpol", "If there is a god, only one exists.");

        supportString = support.get(key);


//        opposition.put("circ", "Circumcision should only be performed with " +
//                "the consent of the child concerned.");
//        opposition.put("sciology", "Scientology is a pseudo religion and " +
//                "should be recognized and treated as such.");
//        opposition.put("abort", "Abortion is the murder of a child and should" +
//                " be made illegal.");
//        opposition.put("genddisc", "Gender discrimination is a outdated " +
//                "theory of inequality at the workplace.");
//        opposition.put("existgod", "God does not exist.");
//        opposition.put("onechurch", "God exists outside of religion and " +
//                "therefore can be reached through any religion.");
//        opposition.put("relviolence", "Religion does not encourage violence.");
//        opposition.put("ethjesus", "Jesus is not white.");
//        opposition.put("zionism", "Anti-Zionism has nothing to do with " +
//                "Anti-Semitism.");
//        opposition.put("incest", "Incest relationships are wrong and should " +
//                "not be allowed.");
//        opposition.put("fwvsf", "Our choices are not our own; our destiny is " +
//                "preordained.");
//        opposition.put("pros", "Prostitution should remain illegal.");

        oppositionString = opposition.get(key);
    }
    public String getDesc(){
        return desc;
    }
    public String getTitle(){return title;}
    public String getSupportString(){return supportString;}
    public String getOppositionString(){return oppositionString;}
}
