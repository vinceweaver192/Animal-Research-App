package course.examples.UI.GridLayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class displayTextActivity  extends Activity {

    private String[] animalList = {
            "Ducks are also called 'waterfowl' because they are normally found in places where there is water like ponds, streams, and rivers. \n" +
                    "\nDucks can live up to 20 years, depending on the species and if well cared for. \n" +
                    "\nThe production of eggs is affected by daylight. \n" +
                    "\nWhen there is more daylight, the ducks will lay more eggs.",

            "Hedgehogs are nocturnal.\n" +
                    "\nThey are called hedgehogs for a reason.\n" +
                    "\nHedgehogs can hibernate.\n" +
                    "\nHedgehogs are lactose intolerant.\n" +
                    "\nThey weren't always called hedgehogs.\n" +
                    "\nTheir long snout is useful.\n" +
                    "\nThey don't use their eyes to hunt.\n" +
                    "\nThere isn't just one species of hedgehog.",

            "Bears are extraordinarily intelligent animals.\n" +
                    "\nBears grieve deeply for others.\n" +
                    "\nBears have excellent senses of smell, sight and hearing.\n" +
                    "\nSome species of Asiatic bear build nests in the trees.\n" +
                    "\nBears care deeply about family members.",

            "The leopard is the most elusive and secretive of the large felids.\n" +
                    "\nLeopards are predominantly solitary animals that have large territories.\n" +
                    "\nLike cats kept as companions, leopards will growl when angry and purr when content.\n" +
                    "\nLeopards tend to have two or three cubs per gestation.",

            "Some lizards can detach their tails if caught by surprise.\n" +
                    "\nLizards live almost everywhere!\n" +
                    "\nSome species of lizard will go their entire lives without drinking water.\n" +
                    "\nWhile most lizards are not dangerous to be around, there are a few exceptions to this rule.\n" +
                    "\nLizards can change color at will.",

            "A group of penguins in the water is called a raft but on land they're called a waddle!\n" +
                    "\nThe black and white “tuxedo” look donned by most penguin species is a clever camouflage called countershading.\n" +
                    "\nPenguins may huddle together for several reasons.\n" +
                    "\nPenguins evolved to fly underwater.",

            "Pigs are very clean animals.\n" +
                    "\nPigs can't sweat.\n" +
                    "\nPigs are smarter than your dog.\n" +
                    "\nMother pigs sing to their babies.\n" +
                    "\nPigs love belly rubs!\n" +
                    "\nPigs have an excellent sense of direction.\n" +
                    "\nPigs dream and like to sleep nose-to-nose.\n" +
                    "\nPigs have excellent memories.",

            "Polar bears are classified as marine mammals.\n" +
                    "\nPolar bears are actually black, not white.\n" +
                    "\nThey can swim constantly for days at a time.\n" +
                    "\nLess than 2% of polar bear hunts are successful.\n" +
                    "\nScientists can extract polar bear DNA from just their footprints.\n" +
                    "\nThey face more threats than climate change.",

            "Scorpions Are Ancient Organisms.\n" +
                    "\nThey Can Survive Just About Anything.\n" +
                    "\nScorpions Are Arachnids.\n" +
                    "\nScorpions Dance Before Mating.\n" +
                    "\n10. They Glow in the Dark.\n" +
                    "\n10. They Eat Just About Anything.",

            "Grizzly bears and grolar bears are hybrids.\n" +
                    "\nThe hump on a grizzly bear's back is a huge muscle.\n" +
                    "\nBears don't hibernate.\n" +
                    "\nClimate change can affect a grizzly bear's diet.\n" +
                    "\nGrizzly bears love to eat moths.",

            "Pandas have great camouflage for their environment.\n" +
                    "\nTheir eyes are different to normal bears.\n" +
                    "\nCubs are well protected in their first month.\n" +
                    "\nCourageous cubs!\n" +
                    "\nA helping hand.\n" +
                    "\nThey spend a lot of their day eating.\n" +
                    "\nBamboo is critical to their diet.\n" +
                    "\nBut they do occasionally eat something other than bamboo.",

            "Whales are divided into two main groups.\n" +
                    "\nHumpback whales don't eat for most of the year.\n" +
                    "\nAll toothed whales have a 'melon' in their foreheads.\n" +
                    "\nSome whales bubble net feed.\n" +
                    "\nThere used to be thousands of blue whales.\n" +
                    "\nWhales are often caught in nets."};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_text);

        Intent intent = getIntent();

        TextView animalFacts = (TextView) findViewById(R.id.textView);

        int thePos = intent.getIntExtra("pos", 0);

        animalFacts.setText(animalList[thePos]);
    }
}