//Jonthan Kosuhan, pd 1, jan 14 2025
//sets and gets things and makes a final string
public class Country {
    // Private instance variables
    private String name;
    private String cap;
    private String lang;
    private String img;

    // Constructor
    public Country(String name, String cap, String lang, String img) {
        this.name = name;
        this.cap = cap;
        this.lang = lang;
        this.img = img;
    }

    // Accessor/get methods
    public String getName() {
        return name;
    }

    public String getCap() {
        return cap;
    }

    public String getLang() {
        return lang;
    }

    public String getImg() {
        return img;
    }

    // toString() method
    //makes the string telling the user what the country is and everything else about it.
    //name,cap, and lang all have to have a pramater.
    @Override
    public String toString() {
        return name + "'s capital is " + cap + " and its primary language is " + lang + ".";
    }
}
