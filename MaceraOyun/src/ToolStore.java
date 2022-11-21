public class ToolStore extends NormalLoc{
    public ToolStore(Player player) {
        super(player, "Mağaza");
    }

    @Override
    public boolean onLocation() {
        System.out.println("------- Mağazaya Hoş Geldiniz :) -------");
        System.out.println("1-Silahlar");
        System.out.println("2-Zırhlar");
        System.out.println("3-Çıkış");
        System.out.println("Seçimiz");
        int selectCase=input.nextInt();
        while (selectCase<1 || selectCase>3){
            System.out.print("Yanlış Seçim Yaptınız Lütfen Tekrar Bir Seçim Yapınız: ");
            selectCase=input.nextInt();
        }

        switch (selectCase){
            case 1:
                printWeapon();
                buyWeapon();
                break;
            case 2:
                printArmor();
                buyArmor();
                break;
            default:
                System.out.println("Bir Daha Bekleriz");
                return true;
        }

        return true;
    }

    public void printWeapon(){
        System.out.println("Silahlar");
        System.out.println();

        for (Weapon w: Weapon.weapons()){
            System.out.println(w.getName()+" <ID: "+w.getId()+ "> <Hasar: "+w.getDamage()+"> <Para: "+w.getPrice()+">");
        }

    }

    public void buyWeapon(){
        System.out.println("Lütfen Bir Silah Seçiniz: ");

        int selectWaopenId =input.nextInt();

        while (selectWaopenId <1 || selectWaopenId >Weapon.weapons().length){
            System.out.print("Yanlış Seçim Yaptınız Lütfen Tekrar Bir Seçim Yapınız: ");
            selectWaopenId =input.nextInt();
        }

        Weapon selectWaopen=Weapon.getWeaponObjById(selectWaopenId);

        if(selectWaopen!=null){
            if(selectWaopen.getPrice() > player.getMoney()){
                System.out.println("Seçtiğiniz silah için paranız yetersizdir");
            }
            else{
                System.out.println(selectWaopen.getName()+" Silahını Satın Aldınız");
                int balanceMoney=player.getMoney()-selectWaopen.getPrice();
                this.getPlayer().setMoney(balanceMoney);
                System.out.println("Kalan Paranız: "+this.player.getMoney());
                this.getPlayer().getInventory().setWeapon(selectWaopen);
                this.player.setDamage(this.player.getDamage()+this.player.getInventory().getWeapon().getDamage());

            }
        }
    }
    public void printArmor(){
        System.out.println("Zırhlar");
        System.out.println();

        for (Armor a: Armor.armors()){
            System.out.println(a.getName()+" <ID: "+a.getId()+ "> <Engelleme: "+a.getBlock()+"> <Para: "+a.getPrice()+">");
        }
    }

    public void buyArmor(){
        System.out.println("Lütfen Bir Zırh Seçiniz: ");

        int selectArmorId =input.nextInt();

        while (selectArmorId <1 || selectArmorId >Armor.armors().length){
            System.out.print("Yanlış Seçim Yaptınız Lütfen Tekrar Bir Seçim Yapınız: ");
            selectArmorId =input.nextInt();
        }

        Armor selectArmor=Armor.getArmorObjById(selectArmorId);

        if(selectArmor.getPrice()>player.getMoney()){
            System.out.println("Seçtiğiniz zırh için paranız yetersizdir");
        }
        else{
            System.out.println(selectArmor.getName()+" Zırhını Sçtiniz");
            int balanceMoney=player.getMoney()-selectArmor.getPrice();
            this.player.setMoney(balanceMoney);
            System.out.println("Kalan Paranız: "+this.player.getMoney());
            this.getPlayer().getInventory().setArmor(selectArmor);
            int balanceHealty=this.player.getHealth()+this.player.getInventory().getArmor().getBlock();
            this.player.setHealth(balanceHealty);
        }
    }

    public void menu(){

    }

    public void buy(){

    }

}
