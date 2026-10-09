public class EscaperoomMap {

    private Room winningRoom;
    private Room startRoom;

    public EscaperoomMap() {

        //ROOMS FOR THE MAP
        Room room1 = new Room("Room 1", "You are in the darkest room!");
        Room room2 = new Room("Room 2", "You are in the red room, be careful!");
        Room room3 = new Room("Room 3", "You are in the yellow room! yellow is false so be careful");
        Room room4 = new Room("Room 4", "You are in the grey room! life is grey, so move on");
        Room room5 = new Room("Room 5", "You are close to finish but you must answer 1 question to pass: \n");
        Room room6 = new Room("Room 6", "You are in the purple room! You are tripping and far away");
        Room room7 = new Room("Room 7", "You are in the pink room! You are delusional, and scared");
        Room room8 = new Room("Room 8", "You are in the brown room! It's muddy but you sense something is close");
        Room room9 = new Room("Room 9", "You are in the orange room! when life makes you oranges do what? go back!");

        //ITEMS FOR ROOMS
        room1.addItem(new Item("torch", "a burning torch"));
        room7.addItem(new Item("brush", "a powerfull brush"));
        room7.addItem(new Item("paint", "magic paint"));
        room8.addItem(new Item("book", "a book about Snow White and the 7 dwarves"));
        room2.addItem(new Item("bag" , "a box with nothing in it"));
        room2.addItem(new Item("toy", "a child toy"));
        room2.addItem(new Item("body", "a dead body on the ground"));

        //FOOD FOR ROOMS
        Food cake = new Food("cake","a sweet green cake", -30);
        Food banana = new Food("banana", "a healthy banana", 20);
        Food sketchyMeat = new Food("meat", "a juicy piece of meat", -50);
        Food vegetables = new Food("vegetables", "magic coloured vegetables", 30);
        Food joint = new Food("joint", "a big fat joint containing sketchy ingredients", -25);

        //ADDING FOOD FOR ROOMS
        room1.addItem(banana);
        room4.addItem(cake);
        room8.addItem(sketchyMeat);
        room7.addItem(vegetables);
        room2.addItem(joint);

        //SUBCLASS WEAPON ITEMS FOR ROOMS:
        RangedWeapon rifle = new RangedWeapon("rifle", "USSR ak47 rifle", 10, 35);
        RangedWeapon desertEagle = new RangedWeapon("pistol", "Israelic defence pistol", 7, 30);
        RangedWeapon bow = new RangedWeapon("bow", "precise archery bow", 9, 15);
        MeleeWeapon knife = new MeleeWeapon("dagger", "Sharp and cool sixblade dagger", 10);
        MeleeWeapon sword = new MeleeWeapon("sword", "long and majestic LOTR sword", 5);

        //ADDING WEAPONS TO ROOMS:
        room1.addItem(rifle);
        room4.addItem(knife);
        room9.addItem(knife);
        room2.addItem(sword);
        room6.addItem(bow);
        room7.addItem(desertEagle);

        //ENEMY WEAPON:
        MeleeWeapon hands = new MeleeWeapon("hands", "strong fistfull hands", 10);
        MeleeWeapon shit = new MeleeWeapon("shit", "nasty smelling shit", 20);
        MeleeWeapon poison = new MeleeWeapon("poison", "toxic smelling aroma", 30);

        //ENEMY:
        Enemy troll = new Enemy("troll", "a cave troll", "Hits you with his hands", hands, 20, room4);
        Enemy horse = new Enemy("horse", "a 3-headed horse with red eyes", "Runs you over and tries to eat you", shit, 40, room2);
        Enemy wizard = new Enemy("wizard", "mysterious smiling wizard", "Opens a bottle where a poison smell arise", poison, 50, room8);
        Enemy witch = new Enemy("eitch", "a creepy tiny witch", "laughs very loudly and points with her small elixir", poison, 50, room6);

        //ADDING ENEMIES TO ROOMS:
        room4.addEnemy(troll);
        room8.addEnemy(wizard);
        room2.addEnemy(horse);
        room6.addEnemy(witch);

        //WINNING AND START ROOM:
        this.winningRoom = room5;
        this.startRoom = room1;

        // ALL POSSIBLE DIRECTIONS IN THE ESCAPE-ROOM
        //ROOM 1:
        room1.setEast(room2);
        room1.setSouth(room4);
        //ROOM 2:
        room2.setWest(room1);
        room2.setEast(room3);
        //ROOM 3:
        room3.setWest(room2);
        room3.setSouth(room6);
        //ROOM 4:
        room4.setNorth(room1);
        room4.setSouth(room7);
        //ROOM 5:
        room5.setSouth(room8);
        //ROOM 6:
        room6.setNorth(room3);
        room6.setSouth(room9);
        //ROOM 7:
        room7.setNorth(room4);
        room7.setEast(room8);
        //ROOM 8:
        room8.setNorth(room5);
        room8.setWest(room7);
        room8.setEast(room9);
        //ROOM 9:
        room9.setNorth(room6);
        room9.setWest(room8);
    }

    public Room getStartRoom() {
        return startRoom;
    }

    public Room getWinningRoom() {
        return winningRoom;
    }


}

