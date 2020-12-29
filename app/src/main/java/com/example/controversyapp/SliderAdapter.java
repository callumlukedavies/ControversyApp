package com.example.controversyapp;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;



public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context){
        this.context = context;
    }

    public int[] sliderImages = {
            R.drawable.ic_friends,
            R.drawable.ic_teams,
            R.drawable.ic_huddle,
            R.drawable.ic_introduction,
            R.drawable.ic_debate,
            R.drawable.ic_spectators
    };

    public String[] sliderTitles = {
            "Controversy.",
            "How to play",
            "Preparation",
            "Introduction to position",
            "Debate",
            "Questions"
    };


    public String[] sliderDescriptions = {
            "Controversy. is a competitive party game in which teams compete" +
                    " to win debates on contentious issues from popular " +
                    "culture. There are three rounds per game, and each round" +
                    " sees a player from each team go head to head in a " +
                    "fierce debate. In order to win, they must convince a " +
                    "group of spectators to take their side of the debate.",

            "Here's how the game works: Each round, teams take turns choosing " +
                    "categories. The choosing team for that round will " +
                    "nominate someone to play that round. This player gets to" +
                    " choose a category and a position on each topic in the " +
                    "category. The opposing team must nominate someone to " +
                    "take the opposition on one of these topics, otherwise " +
                    "they must forfeit.",

            "Once a player from the opposing team has taken an opposition, " +
                    "each team simultaneously gets 2 minutes to discuss their" +
                    " position with their teammates.",

            "Each team must then present an introduction to their position. " +
                    "This lasts for two minutes and is lead by the choosing " +
                    "team.",

            "After the introduction phase is the debate. You will get to " +
                    "discuss the topic with the other player, and you should " +
                    "use this time to convince the spectators to vote for you" +
                    ". Caution: Things can get heated!",

            "Lastly, the spectators will be given the opportunity to ask " +
                    "questions. This will allow the players to clarify any " +
                    "points they made during the debate. Once the spectators " +
                    "are satisfied, they will silently vote for the winner of" +
                    " that round."
    };



    @Override
    public int getCount() {
        return sliderImages.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view,
                                    @NonNull Object object) {
        return view == (ConstraintLayout) object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position){

        layoutInflater =
                (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout,
                container, false);

        TextView slideTitle = (TextView) view.findViewById(R.id.slide_title);

        ImageView slideImageView =
                (ImageView) view.findViewById(R.id.slide_image);
        TextView slideDescription =
                (TextView) view.findViewById(R.id.slide_description);

        slideTitle.setText(sliderTitles[position]);
        slideImageView.setImageResource(sliderImages[position]);
        slideDescription.setText(sliderDescriptions[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object){
        container.removeView((ConstraintLayout)object);

    }
}
