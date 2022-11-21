import java.util.Random;

public abstract class BattalLoc extends Location{
    private Obstacle obstacle;
    private String award;
    private int maxObstacle;

    public BattalLoc(Player player, String name,Obstacle obstacle,String award, int maxObstacle) {
        super(player, name);
        this.obstacle=obstacle;
        this.award=award;
        this.maxObstacle=maxObstacle;
    }

    @Override
    public boolean onLocation() {
        int numberObstacle=this.numberRandomObstacle();
        System.out.println("Şu an Buradasınız: "+this.getName());
        System.out.println("Dikkatli Ol!! Çünkü "+numberObstacle+" Tane " +this.getObstacle().getName()+" Var ");
        System.out.println("<S>avaş ya da <K>aç");
        String selectCase= input.nextLine();
        selectCase=selectCase.toUpperCase();

        if(selectCase.equals("S") && combat(numberObstacle)){
            System.out.println(this.getName()+ " Tüm Düşmanları Temizlediniz");
            return true;
        }

        if(this.getPlayer().getHealth()<=0){
            System.out.println("Öldünüz");
            return false;
        }

        return true;
    }

    public boolean combat(int obsNumber){

        for(int i=1;i<=obsNumber;i++){
            this.getObstacle().setHealth(this.getObstacle().getOrjinalHealth());
            playerStats();
            obstacleStats(i);
            while (this.getPlayer().getHealth()>0 && this.getObstacle().getHealth()>0){
                System.out.println("<V>ur yada <K>aç: ");
                String selectCombat=input.nextLine().toUpperCase();
                if(selectCombat.equals("V")){
                    System.out.println("Siz Vurdunuz!");
                    obstacle.setHealth(this.getObstacle().getHealth()-this.getPlayer().getTotalDamage());
                    afterHit();
                    if(this.getObstacle().getHealth()>0){
                        System.out.println();
                        System.out.println("Canavar Size Vurdu");
                        player.setHealth(this.getPlayer().getHealth()-this.getObstacle().getDamage());
                    }
                    afterHit();
                }
                else {
                    return false;
                }

            }

            if (this.getObstacle().getHealth()<this.getPlayer().getHealth()){
                System.out.println("Düşmanı Yendiniz");
                System.out.println(this.getObstacle().getAward() +" Para Kazandınız");
                this.getPlayer().setMoney(this.getPlayer().getMoney()+this.getObstacle().getAward());
                System.out.println("Güncel Paranız: "+this.getPlayer().getMoney());
            }

        }
       return false;
    }

    public void afterHit(){

        System.out.println("Kalan Canınız: "+this.getPlayer().getHealth());
        System.out.println(this.getObstacle().getName()+" Canı: "+this.getObstacle().getHealth());
        System.out.println("------------");
    }

    public void playerStats(){

        System.out.println("Oyuncu Bilgileri");
        System.out.println("--------------------------");
        System.out.println("Sağlık: "+this.getPlayer().getHealth());
        System.out.println("Silah: "+this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Hasar: "+this.getPlayer().getTotalDamage());
        System.out.println("Zırh: "+this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Bloklama: "+this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Para: "+this.getPlayer().getMoney());
        System.out.println();


    }

    public void obstacleStats(int i){
        System.out.println(i+". Canavar Bilgileri");
        System.out.println("--------------------------");
        System.out.println("Canavar: "+this.getObstacle().getName());
        System.out.println("Sağlık: "+this.getObstacle().getHealth());
        System.out.println("Hasar: "+this.getObstacle().getDamage());
        System.out.println("Ödül: "+this.getObstacle().getAward());
        System.out.println();
    }

    public int numberRandomObstacle(){
        Random r=new Random();
        return r.nextInt(this.maxObstacle)+1;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }
}
