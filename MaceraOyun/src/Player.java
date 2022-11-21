import java.util.Scanner;

public class Player {

    private Scanner input=new Scanner(System.in);
    private Inventory inventory;
    private int damage;
    private int health;
    private int money;
    private String charName;
    private String name;
    private int orjinalHealth;

    public Player(String name) {
        this.name = name;
        this.orjinalHealth=health;
        this.inventory=new Inventory();
    }

    public void selectChar(){
        System.out.println("-------------------------------");
        System.out.println("Lütfen Bir Karakter Seçiniz: ");
        System.out.println("-------------------------------");
        GameChar[] charList={new Samurai(),new Archer(),new Knight()};

        for (GameChar gameChar:charList) {
            System.out.println(gameChar.getId()+": "+gameChar.getCharName()+"\t Hasar: "+ gameChar.getDamage()+"\t Sağlık: "+gameChar.getHealth()+ "\t para: "+gameChar.getMoney());
        }

        int tusChar =input.nextInt();
        switch(tusChar){
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());
        }

        System.out.println("Oyuncu: "+this.getName()+
                "\t Karakter: "+this.getCharName()+
                "\t Hasar: "+this.getDamage()+
                "\t Sağlık: "+this.getHealth()+
                "\t Para: "+this.getMoney());


    }

    public void initPlayer(GameChar gameChar){
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setOrjinalHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        this.setCharName(gameChar.getCharName());
    }

    public void printPlayerInfo(){
        System.out.println("Silahınız: "+this.getInventory().getWeapon().getName()+
                "\t Karakter: "+this.getCharName()+
                "\t Hasar: "+this.getDamage()+
                "\t Sağlık: "+this.getHealth()+
                "\t Para: "+this.getMoney());
        System.out.println("Zırhınız: "+this.getInventory().getArmor().getName()+
                "\t Karakter: "+this.getCharName()+
                "\t Hasar: "+this.getTotalDamage()+
                "\t Sağlık: "+this.getHealth()+
                "\t Para: "+this.getMoney());
    }
    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getTotalDamage(){
        return damage+this.getInventory().getWeapon().getDamage();
    }
    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getOrjinalHealth() {
        return orjinalHealth;
    }

    public void setOrjinalHealth(int orjinalHealth) {
        this.orjinalHealth = orjinalHealth;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
