/*📌 Scenario:
You’re building a gaming character system.
Create a base class Character with fields: name and level.
Create a derived class Warrior that adds a field: weaponType.
Create another derived class Mage that adds a field: mana.
Use constructors with super to initialize the base part of the object.
Override a method displayStats() in each subclass to show their own unique stats.
Add a twist: Use the final keyword to prevent overriding of a method getLevel() (defined in Character). */
import java.util.Scanner;
class Character{
    String name;
    int level;
    Character(String name,int level){
        this.name=name;
        this.level=level;
    }
    final void encourage(){
        if(level<100){
            System.out.println("You've got this!! Keep Going!");
        }
        else if(level>=100&&level<200){
            System.out.println("You're a pro!! Let's see how far you can go!");
        }
        else if(level>200){
            System.out.println("THAT'S IT YOU'RE A GENIUS");
        }
    }
    void displayStats(){
        System.out.println("Name: "+name+" Level: "+level);
    }
}
class Warrior extends Character{
    String weaponType;
    Warrior(String name,int level,String weaponType){
        super(name,level);
        this.weaponType=weaponType;
    }
    void displayStats(){
        System.out.println("Name: "+name+" Level: "+level+" Weapon Type: "+weaponType);
    }
}
class Mage extends Character{
    int mana;
    Mage(String name,int level,int mana){
        super(name,level);
        this.mana=mana;
    }
    void displayStats(){
        System.out.println("Name: "+name+" Level: "+level+" Mana: "+mana);
    }
}
class Game_System{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter no of characters");
        int n=sc.nextInt();
        sc.nextLine();
        Character [] c=new Character [n];

        for(int i=0;i<n;i++){
            
            System.out.printf("is character %d a warrior or a mage?\n",i+1);
            String type=sc.nextLine();
            if("warrior".equalsIgnoreCase(type)){
                System.out.println("enter name:");
                String name=sc.nextLine();
                System.out.println("enter level");
                int level=sc.nextInt();
                sc.nextLine();
                System.out.println("enter weapon type");
                String weaponType=sc.nextLine();
                c[i]=new Warrior(name,level,weaponType);
            }
            else if("mage".equalsIgnoreCase(type)){
                System.out.println("enter name:");
                String name=sc.nextLine();
                System.out.println("enter level");
                int level=sc.nextInt();
                sc.nextLine();
                System.out.println("enter mana");
                int mana=sc.nextInt();
                sc.nextLine();
                c[i]=new Mage(name,level,mana);
            }
            else{
                System.out.println("invalid");
                c[i]=null;
            }
        }
        System.out.println("--- All Characters ---");
        for (int i = 0; i < n; i++) {
            if (c[i] != null) { 
                System.out.println("Character "+(i+1)+":");
                c[i].displayStats();
                c[i].encourage();
            }
        }
    }
}