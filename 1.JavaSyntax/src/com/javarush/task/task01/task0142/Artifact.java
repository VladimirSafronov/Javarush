package com.javarush.task.task01.task0142;

/* 
Амиго очень умный
*/

public class Artifact {

    int id;
    String culture;
    int century;

    public Artifact(int id) {
        this.id = id;
    }

    public Artifact(int id, String culture) {
        this.id = id;
        this.culture = culture;
    }

    public Artifact(int id, String culture, int century) {
        this.id = id;
        this.culture = culture;
        this.century = century;
    }

    public static void main(String[] args) {
        Artifact artifact1 = new Artifact(1);
        Artifact artifact2 = new Artifact(2, "Europe");
        Artifact artifact3 = new Artifact(3, "China", 11);

        User user1 = new User("ann", (short) 12, 160);
        User user2 = new User((short) 11, "bob", 150);
        User user3 = new User(180, (short) 15, "andrew");
    }
}
