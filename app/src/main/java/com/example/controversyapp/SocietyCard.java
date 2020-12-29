package com.example.controversyapp;

import java.util.HashMap;
import java.util.Map;

public class SocietyCard {

    private String title;
    private String desc;
    private String supportString;
    private String oppositionString;

    String[] keys = {"transrac","1984","massincar","neutraltoilets",
            "gendessen", "pubbaths", "whitpriv", "paedos",
            "childsexdolls", "tiktok", "alm", "gendassign", "whiteracism",
            "curves", "models", "jkrowl", "cancul", "genroles", "ssparenting"
            , "bodycounts", "pubbreast", "transsports", "veganism",
            "university", "datweb", "popcont", "furries"};

    Map<String, String> descriptions = new HashMap<String, String>();
    Map<String, String> titles = new HashMap<String, String>();
    Map<String, String> support = new HashMap<String, String>();
    Map<String, String> opposition = new HashMap<String, String>();


    public SocietyCard(int keyNo){
        String key = keys[keyNo];
        descriptions.put("transrac","Transracial people are individuals who " +
                "assert a racial identity for themselves which differs from " +
                "their birth race.");

        descriptions.put("hunggames", "The Hunger Games (created by author " +
                "Suzanne Collins) is a fictional annual event where two people are " +
                "chosen from each state in order to compete in a fight to the death.");

        descriptions.put("massincar","The term “mass incarceration” refers to" +
                " the unique way the U.S. has locked up a vast population in " +
                "federal and state prisons, as well as local jails.");

        descriptions.put("neutraltoilets","The term gender neutral toilets " +
                "refers to public toilets that are not separated by gender or sex.");

        descriptions.put("pubbaths","Should public bathrooms allocate more " +
                "physical space to women's toilets than men's? ");

        descriptions.put("gendessen","Gender essentialism is a concept used " +
                "to examine the attribution of fixed, intrinsic, innate " +
                "qualities to women and men. In this theory, there are " +
                "certain universal, innate, biologically- or " +
                "psychologically-based features of gender that are at the " +
                "root of observed differences in the behavior of men and women.");

        descriptions.put("whitpriv","Inherent advantages possessed by a white" +
                " person on the basis of their race in a society " +
                "characterized by racial inequality and injustice.");

        descriptions.put("childsexdolls","Child sex dolls are inanimate, " +
                "human-like artifacts used for the purposes of sexual " +
                "stimulation and gratification.");

        descriptions.put("tiktok", "TikTok is a social video app that " +
                "allows users to share short videos. The app which features " +
                "stickers, filters and augmented reality was the world's " +
                "fourth most downloaded app in 2018 beating Instagram and " +
                "Snapchat.");

        descriptions.put("alm", "All Lives Matter (#AllLivesMatter) is a " +
                "slogan that has come to be associated with criticism of the " +
                "Black Lives Matter movement.");



        desc = descriptions.get(key);

        titles.put("transrac", "Transracialism");
        titles.put("1984", "1984");
        titles.put("massincar", "Mass Incarceration");
        titles.put("neutraltoilets", "Gender Neutral Toilets");
        titles.put("pubbaths", "Public Bathrooms");
        titles.put("gendessen", "Gender Essentialism");
        titles.put("whitpriv", "White Privilege");
        titles.put("paedos", "Paedophiles");
        titles.put("childsexdolls", "Child Sex Robots");
        titles.put("tiktok", "TikTok");
        titles.put("alm", "All Lives Matter");
        titles.put("gendassign","Gender Assignment at Birth");
        titles.put("whiteracism","Racism against White People");
        titles.put("curves","Curve Models");
        titles.put("models","Models");
        titles.put("jkrowl","J.K.Rowling");
        titles.put("cancul","Cancel Culture");
        titles.put("genroles","Gender Roles");
        titles.put("ssparenting","Same-sex Parenting");
        titles.put("bodycounts","Body Counts");
        titles.put("pubbreast","Public Breastfeeding");
        titles.put("transsports","Transsexualism and Sports");
        titles.put("veganism","Veganism");
        titles.put("university","University Degrees");
        titles.put("datweb","Dating Websites");
        titles.put("popcont","Population Control");
        titles.put("furries","Furries");

        title = titles.get(key);

        support.put("transrac", "People should be legally capable of changing" +
                " their ethnic identity.");

        support.put("1984", "Western societies are evolving into " +
                "authoritarian surveillance states similar to the one " +
                "imagined in the novel 1984 by George Orwell.");

        support.put("masincar", "Mass Incarceration is effective at reforming" +
                " criminals.");

        support.put("neutraltoilets", "Gender Neutral Toilet's should " +
                "be the common form of public toilet.");

        support.put("pubbaths", "Women's public toilets should get more " +
                "physical space at the expense of men's public toilets.");

        support.put("gendessen", "There are major differences between men and" +
                " women.");

        support.put("whitpriv", "White privilege exists.");

        support.put("paedos", "Paedophiles are evil predatory monsters.");

        support.put("childsexdolls", "Child sex dolls are a solution to " +
                "solving the predatory urges of paedophiles.");

        support.put("tiktok", "TikTok is a major cybersecurity risk.");

        support.put("alm", "All Lives Matter is a relevant counter to the " +
                "Black Lives Matter movement.");
        support.put("gendassign","Parents should not assign gender at birth.");
        support.put("whiteracism","You can be racist towards white people.");
        support.put("curves","Curve models normalise preventable health " +
                "issues.");
        support.put("models","Models have an easy career.");
        support.put("jkrowl","J.K.Rowling is transphobic.");
        support.put("cancul","Cancel culture has gone too far.");
        support.put("genroles","Women belong at home and not in the workplace.");
        support.put("ssparenting","Same sex parents cannot raise children as " +
                "effectively as opposite sex parents.");
        support.put("bodycounts","Its ok to shame women for having a high body count.");
        support.put("pubbreast","Women should be allowed to breastfeed their " +
                "children in public settings.");
        support.put("transsports","Transexual people should be allowed to " +
                "compete in sports as their newly assigned sex.");
        support.put("veganism","Veganism is a completely healthy diet that " +
                "meets full nutritional requirements when eaten correctly.");
        support.put("university","A university degree is no longer worth the " +
                "effort in today's society.");
        support.put("datweb","Dating websites are for people with no social " +
                "skills.");
        support.put("popcont","A one child policy should be adopted by all " +
                "nations across the globe.");
        support.put("furries","Furries should be accepted in society.");

        supportString = support.get(key);

//        opposition.put("transrac", "People should not be able to change " +
//                "their ethnic identity.");
//
//        opposition.put("hunggames", "The Hunger Games could never take place " +
//                "in western society. ");
//
//        opposition.put("masincar", " Mass Incarceration is not effective at " +
//                "reforming criminals.");
//
//        opposition.put("neutraltoilets", "Gender Neutral Toilet's should not " +
//                "be made common.");
//
//        opposition.put("pubbaths", "Men's public toilets should get at least " +
//                "the same amount of physical space as women's, if not more.");
//
//        opposition.put("deathpen", "The UK should not have a death penalty.");
//
//        opposition.put("gendessen", "There are not major differences between " +
//                "men and women.");
//
//        opposition.put("asssui", "Assisted Suicide should remain illegal.");
//
//        opposition.put("whitpriv", "White privelege does not exist.");
//
//        opposition.put("childsexdolls", "Child sex dolls encourage paedophilia.");
//
//        opposition.put("tiktok", "Tiktok is not a cybersecurity risk.");
//
//        opposition.put("alm", "All Lives Matter misses the point of the Black" +
//                " Lives Matter movement.");
//
//        opposition.put("covidmasks", "Shopkeepers should not be allowed to " +
//                "ban customers without masks.");

        oppositionString = opposition.get(key);
    }

    public String getDesc(){
        return desc;
    }
    public String getTitle(){return title;}
    public String getSupportString(){return supportString;}
    public String getOppositionString(){return oppositionString;}



}
