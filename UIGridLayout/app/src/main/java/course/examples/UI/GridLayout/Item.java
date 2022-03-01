package course.examples.UI.GridLayout;

public class Item {

    String animalListName;
    int animalListImage;
    String animalFacts;

    public Item(String animalName,int animalImage, String animalFacts)
    {
        this.animalListImage=animalImage;
        this.animalListName=animalName;
        this.animalFacts=animalFacts;
    }
    public String getAnimalName()
    {
        return animalListName;
    }
    public int getAnimalImage()
    {
        return animalListImage;
    }
    public String getAnimalFacts() { return animalFacts; }

}
