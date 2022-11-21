import java.util.Scanner;
public class Game {
    private Scanner input=new Scanner(System.in);
    public Player player;
    public Location location;
    public void start(){
        System.out.println("Macera Oyununa Hoş Geldiniz");
        System.out.print("Lütfen Bir isim Giriniz : ");
        String playerName=input.nextLine();

        Player player=new Player(playerName);
        System.out.println("Sayın " +player.getName()+" Bu karanlık ve sisli Adaya Hoşgeldin. Burada Yaşanılan Her şey gerçek !!! \n");
        player.selectChar();
        Location location=null;
        while (true){
            player.printPlayerInfo();
            System.out.println();
            System.out.println("########### Bölgeler ###########");
            System.out.println();
            System.out.println("1-Güvenli Ev --> Can Yenilemek İçin Buraya Girin");
            System.out.println("1-Mağaza --> Eşya Satın Almak İçin Buraya Girin");
            System.out.println("3-Mağara --> Mağaraya Gir, Dikkatli Ol Canavar Çıkabilir");
            System.out.println("4-Orman --> Ormana Gir, Dikkatli Ol Canavar Çıkabilir");
            System.out.println("5-Nehir --> Nehire Gir, Dikkatli Ol Canavar Çıkabilir");
            System.out.println("0-Çıkış --> Oyunu Sonlandır");
            System.out.println("Lütfen Girmek İstediğiniz Bölgeyi Seçiniz");

            int tusLoc =input.nextInt();
            switch (tusLoc){
                case 0:
                    location=null;
                    break;
                case 1:
                    location=new SafeHouse(player);
                    break;
                case 2:
                    location=new ToolStore(player);
                    break;
                case 3:
                    location=new Cave(player);
                    break;
                case 4:
                    location=new River(player);
                    break;
                case 5:
                    location=new Forest(player);
                default:
                    System.out.println("Lütfen Geçerli Bir İşlem Giriniz");
            }

            if(!location.onLocation()){
                System.out.println("Game Over!!!");
                break;
            }
        }

    }

}
