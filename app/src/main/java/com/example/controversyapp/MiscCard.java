package com.example.controversyapp;

import java.util.HashMap;
import java.util.Map;

public class MiscCard {
    String title;
    String desc;
    String supportString;

    String[] keys = {"cann","adhd","pluto","kard","plassurg",
            "pocfemmov", "segsports", "frats", "darkvsmilk", "dogscats",
            "marigate", "womenonly", "pizzaolives", "milk", "sweatshops",
            "workmot", "elitepaedo", "illum", "realitytv", "freeuni"
            , "zoos", "starwars"};

    Map<String, String> descriptions = new HashMap<String, String>();
    Map<String, String> titles = new HashMap<String, String>();
    Map<String, String> support = new HashMap<String, String>();

    public MiscCard(int keyNo) {
        String key = keys[keyNo];
        descriptions.put("cann", "Cannibalism is the act of consuming another" +
                " individual of the same species as food. Cannibalism is a " +
                "common ecological interaction in the animal kingdom and has" +
                " been recorded in more than 1,500 species.");
        descriptions.put("adhd", "Attention deficit hyperactivity disorder " +
                "(ADHD) is a mental health disorder that can cause " +
                "above-normal levels of hyperactive and impulsive behaviors.");
        descriptions.put("pluto", "Pluto, originally a planet, has been " +
                "downgraded to a dwarf planet for failing to meet official " +
                "size requirements.");
        descriptions.put("vegan", "Someone who doesn’t consume products " +
                "derived from animals.");
        descriptions.put("roids", "Chemical compound which enhances the " +
                "body's ability to build muscle mass.");
        descriptions.put("doping", "The use of performance enhancing drugs " +
                "in competitive sports.");
        descriptions.put("kard", "The Kardashian family, also referred to as " +
                "the Kardashian-Jenner family, is an American family that is" +
                " prominent in the fields of entertainment, fashion design, " +
                "and business.");
        descriptions.put("plassurg", "Modifying one's body through the use of" +
                " surgery to the end of improving one's appearance.");
        descriptions.put("truman", "The Truman Doctrine was an American " +
                "foreign policy whose stated purpose was to contain Soviet " +
                "geopolitical expansion during the Cold War.");
        descriptions.put("frats", "A social organization at universities made" +
                " up of young men. Many cases of sexual assault have been " +
                "reported to be a result of american ‘frat’ culture, which " +
                "is deemed toxic and dangerous.");
        descriptions.put("minwag", "The rate of payment that an employer is " +
                "legally obliged to pay its employees. In the US, the " +
                "minimum wage is notorious for being below the living wage.");
        desc = descriptions.get(key);

        titles.put("cann", "Cannibalism");
        titles.put("adhd", "ADHD");
        titles.put("pluto", "Pluto");
        titles.put("kard", "The Kardashians Fame");
        titles.put("plassurg", "Plastic Surgery");
        titles.put("pocfemmov","Women of Colour and Feminism");
        titles.put("segsports","Segregation in Sports");
        titles.put("frats", "Fraternities and Sexual Assault");
        titles.put("darkvsmilk","Dark vs Milk Chocolate");
        titles.put("dogscats","Dogs vs Cats");
        titles.put("marigate","Marijuana");
        titles.put("womenonly","Women Only");
        titles.put("pizzaolives","Olives on Pizza");
        titles.put("milk","Milk");
        titles.put("sweatshops","Third World Sweatshops");
        titles.put("workmot","Motivations to work");
        titles.put("elitepaedo","Elite Paedophile Ring");
        titles.put("illum","The Illuminati");
        titles.put("realitytv","Reality TV Shows");
        titles.put("freeuni","Free University Degrees");
        titles.put("zoos","Zoo's");
        titles.put("starwars","The new Star Wars Trilogy");
        title = titles.get(key);


        support.put("cann", "Cannibalism is a natural behaviour observed in " +
                "many species across the animal kingdom, and is therefore " +
                "justified.");
        support.put("adhd", "ADHD is not real.");
        support.put("pluto", "Pluto is a planet.");
        support.put("kard", "The Kardashians deserve the fame they have.");
        support.put("plassurg", "Cosmetic Surgery is bad for feminism.");
        support.put("pocfemmov","Feminism does not recognise the struggle " +
                "that women of colour go through, and is therefore " +
                "hypocritical.");
        support.put("segsports","Segregation in sports is sexist.");
        support.put("frats", "Fraternities practice behaviour that encourages" +
                " sexual assault.");
        support.put("darkvsmilk","Dark chocolate wins the fight.");
        support.put("dogscats","Dogs make for better pets.");
        support.put("marigate","Marijuana is the gateway drug.");
        support.put("womenonly","Women only clubs are sexist against men.");
        support.put("pizzaolives","Olives are the worst possible topping you " +
                "could put on a pizza.");
        support.put("milk","Milk is healthy for humans to drink.");
        support.put("sweatshops","Third world sweatshops are moral.");
        support.put("workmot","The majority of people would not work if their" +
                " financial needs were taken care of.");
        support.put("elitepaedo","There exists an elite paedophile ring that " +
                "trafficks and abuses children.");
        support.put("illum","The illuminati rules the world.");
        support.put("realitytv","Reality television destroys brain cells.");
        support.put("freeuni","University education should be free for those " +
                "with low income backgrounds.");
        support.put("zoos","Zoos should be banned.");
        support.put("starwars","The new star wars trilogy is garbage.");
        supportString = support.get(key);
    }
    public String getDesc(){return desc;
    }
    public String getTitle(){return title;}
    public String getSupportString(){return supportString;}


}
