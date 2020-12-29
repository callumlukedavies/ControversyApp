package com.example.controversyapp;

import java.util.HashMap;
import java.util.Map;

public class ScienceCard {
    private String title;
    private String desc;
    private String supportString;
    private String oppositionString;

    String[] keys = {"globalwarming", "animaltesting", "flatearth",
            "evolution", "covid", "fracking", "spe", "cloning",
            "facfarm", "ai", "seccures", "socsci", "vacc", "aging",
            "flatface", "cyborgs", "techimp", "altmed"};

    Map<String, String> descriptions = new HashMap<String, String>();
    Map<String, String> titles = new HashMap<String, String>();
    Map<String, String> support = new HashMap<String, String>();
    Map<String, String> opposition = new HashMap<String, String>();

    public ScienceCard(int keyNo){
        String key = keys[keyNo];

        descriptions.put("globalwarming", "Global warming is the long-term " +
                "heating of Earth’s climate system observed since the " +
                "pre-industrial period (between 1850 and 1900) due to human " +
                "activities, primarily fossil fuel burning, which increases " +
                "heat-trapping greenhouse gas levels in Earth’s atmosphere.");

        descriptions.put("fracking", "Fracking is the process of drilling " +
                "down into the earth before a high-pressure water mixture is " +
                "directed at the rock to release the gas inside.");

        descriptions.put("animaltesting", "Animal experiments are widely used" +
                " to develop new medicines and to test the safety of other " +
                "products.");

        descriptions.put("spe", "A social psychology experiment that " +
                "attempted to investigate the psychological effects of " +
                "perceived power, focusing on the struggle between prisoners " +
                "and prison officers.");

        descriptions.put("cloning", "The term cloning describes a number of " +
                "different processes that can be used to produce genetically " +
                "identical copies of a biological entity.");

        descriptions.put("evolution", "In biology, evolution is the change " +
                "in the characteristics of a species over several " +
                "generations and relies on the process of natural selection.");

        descriptions.put("covid", "Coronavirus disease (COVID-19) is an " +
                "infectious disease caused by a newly discovered coronavirus." +
                " Most people infected with the COVID-19 virus will " +
                "experience mild to moderate respiratory illness and recover" +
                " without requiring special treatment.");

        descriptions.put("facfarm", "A system of rearing livestock using " +
                "highly intensive methods, by which poultry, pigs, or cattle " +
                "are confined indoors under strictly controlled conditions.");

        descriptions.put("ai", "Artificial intelligence (AI), " +
                "sometimes called machine intelligence, is intelligence " +
                "demonstrated by machines, unlike the natural intelligence " +
                "displayed by humans and animals.");

        descriptions.put("flatearth", "The flat Earth model is an archaic " +
                "conception of Earth's shape as a plane or disk.");

        desc = descriptions.get(key);

        titles.put("globalwarming", "Global Warming");
        titles.put("animaltesting", "Animal Testing");
        titles.put("flatearth", "Flat Earth");
        titles.put("evolution", "Evolution");
        titles.put("covid", "Coronavirus");
        titles.put("fracking", "Fracking");
        titles.put("spe", "The Stanford Prison Experiment");
        titles.put("cloning", "Cloning");
        titles.put("facfarm", "Factory Farming");
        titles.put("ai", "Artificial Intelligence");
        titles.put("seccures","Secret Cures");
        titles.put("socsci","The Social Sciences");
        titles.put("vacc","Vaccines");
        titles.put("aging","Aging is a disease");
        titles.put("flatface","Flat Faced Pets");
        titles.put("cyborgs","Cyborgs");
        titles.put("techimp","Technical Implants");
        titles.put("altmed","Alternative Medicine");

        title = titles.get(key);

        support.put("globalwarming", "Global warming is a scientific " +
                "phenomenon caused by humans that is a real threat to the " +
                "planet.");
        support.put("animaltesting", "Testing on animals allows us to gauge " +
                "whether a new medicine/product is safe for humans, and " +
                "without it we would be harming people.");
        support.put("flatearth", "A spherical planet is a piece of government" +
                " propaganda used to perpetuate space exploration for the " +
                "secret funding of the illuminati.");
        support.put("evolution", "Evolution is a natural process which is " +
                "responsible for the existence of animals in nature.");
        support.put("covid", "Coronavirus is a man-made virus made in a " +
                "laboratory.");
        support.put("fracking", "Fracking is a necessary method for " +
                "extracting oil and therefore is justified.");
        support.put("spe", "The SPE holds important scientific value in " +
                "exposing the effects on people in power.");
        support.put("cloning", "Cloning is a useful scientific tool that does" +
                " not infringe upon the biological entities rights.");
        support.put("facfarm", "Factory farming is necessary to provide food " +
                "for society.");
        support.put("ai", "AI will be the end of civilization as we know it.");
        support.put("seccures","The government is hiding cures for diseases from us.");
        support.put("socsci","The social sciences are not real sciences.");
        support.put("vacc","Vaccines are not safe and can cause disabilities " +
                "such as autism in developing children.");
        support.put("aging","Aging is a disease and to some extent will be " +
                "preventable in the future.");
        support.put("flatface","The breeding of flat faced pets is immoral.");
        support.put("cyborgs","Humans are already cyborgs.");
        support.put("techimp","Humans should use implant technology.");
        support.put("altmed","Alternative medicine is a pseudoscience.");

        supportString = support.get(key);

//        opposition.put("globalwarming", "Global warming is a natural cycle " +
//                "that the earth goes through, and poses no threat to the planet.");
//        opposition.put("animaltesting", "Testing on animals is an " +
//                "unnecessary and harmful practice.");
//        opposition.put("flatearth", "The earth is a sphere in space, and " +
//                "there exists plenty evidence to support it.");
//        opposition.put("evolution", "Evolution is a flawed theory that isn't " +
//                "based on any observable concrete facts.");
//        opposition.put("covid", "Coronavirus is a man-made virus made in a " +
//                "laboratory.");
//        opposition.put("fracking", "Fracking is an environmentally " +
//                "destructive practice and is therefore unethical.");
//        opposition.put("spe", "The SPE was a highly unethical study that " +
//                "disregarded the mental and physical health of its " +
//                "participants.");
//        opposition.put("cloning", "Cloning is a highly unethical practice " +
//                "that infinges upon the rights of the entity to be cloned.");
//        opposition.put("facfarm", "Factory farming causes the mass suffering " +
//                "of animals and contributes to global warming.");
//        opposition.put("ai", "AI will be the end of civilization as we know " +
//                "it.");
//
//        oppositionString = opposition.get(key);

    }
    public String getDesc(){
        return desc;
    }
    public String getTitle(){return title;}

    public String getSupportString(){return supportString;}

    public String getOppositionString(){return oppositionString;}
}
