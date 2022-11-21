public class SafeHouse extends NormalLoc{

    public SafeHouse(Player player) {
        super(player, "Güvenli ev");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Güvenli Evdesiniz !");
        System.out.println("Canınız Yenilendi !");
        this.getPlayer().setHealth(this.getPlayer().getOrjinalHealth());

        return true;
    }
}
