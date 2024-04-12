package Model;

import java.io.Serializable;
import java.time.LocalDate;

import static Model.JustScanner.Scan;

/**
 * Класс коллекции, которую мы храним в программе
 * */

public class SpaceMarine implements Serializable, Comparable<SpaceMarine>{ //разбор на байты и сбор обратно
    private Long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private final Coordinates coordinates = new Coordinates(); //Поле не может быть null
    private final LocalDate creationDate = LocalDate.now(); //Поле не может быть null, Значение этого поля должно генерироваться автоматически

    private Long health; //Поле может быть null, Значение поля должно быть больше 0
    private Long heartCount; //Поле не может быть null, Значение поля должно быть больше 0, Максимальное значение поля: 3
    private MeleeWeapon meleeWeapon; //Поле не может быть null
    private Chapter chapter; //Поле может быть null

    public SpaceMarine() {
        this.setChapter();
        this.setId();
        this.setName();
        this.setHealth();
        this.setHeartCount();
        this.setMeleeWeapon();
        System.out.println("SpaceMarine " + this.name + " создан");
    }

    private void setChapter(){
        int chapterChoice;
        while(true) {
            try {
                System.out.print("Если хотите добавить Chapter, введите 1 иначе 2: ");
                chapterChoice = Integer.parseInt(Scan());
                if (chapterChoice != 1 && chapterChoice != 2) {
                    System.out.println("Введите 1 или 2!");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Надо ввести int!");
            }
        }
        switch (chapterChoice){
            case 1:
                this.chapter = new Chapter();
                this.chapter.makeChapter();
                break;
            case 2:
                break;
        }
    }
    private void setMeleeWeapon() {
        while (true) {
            System.out.println("Введите номер оружия ближнего боя");
            System.out.println("1 - POWER_SWORD\n2 - MANREAPER\n3 - LIGHTING_CLAW\n4 - POWER_BLADE");
            try{
                int weaponChoice = Integer.parseInt(Scan());
                if (weaponChoice < 1 || weaponChoice > 4) {
                    System.out.println("Вы указали неправильный номер! Проверьте и введите еще раз");
                }

                else {
                    switch (weaponChoice) {
                        case 1 ->
                            this.meleeWeapon = MeleeWeapon.POWER_SWORD;
                        case 2 ->
                            this.meleeWeapon = MeleeWeapon.MANREAPER;
                        case 3 ->
                            this.meleeWeapon = MeleeWeapon.LIGHTING_CLAW;
                        case 4 ->
                            this.meleeWeapon = MeleeWeapon.POWER_BLADE;
                    }
                    break;
                }
            }catch(NumberFormatException e){
                System.out.println("Надо ввести int!");
            }
        }
    }
    private void setHeartCount(){
        while (true) {
            System.out.print("Введите heartCount(0<heartCount<=3): ");
            try{
                this.heartCount = Long.parseLong(Scan());
                if (this.heartCount>3 || this.heartCount<=0){
                    System.out.println("Значение heartCount должно быть от 1 до 3!");
                }else{
                    break;
                }
            }catch(NumberFormatException e){
                System.out.println("Надо ввести Long");
            }

        }
    }

    private void setHealth(){
        while(true){
            System.out.print("Введите значение больше 0 (Long)health: ");
            try{
                String sHealth = Scan();
                if (sHealth.replaceAll(" ", "").equals("")){
                    this.health = null;
                    break;
                }
                this.health = Long.parseLong(sHealth);
                if (this.health<=0){
                    System.out.println("Значение health должно быть больше 0!");
                }else{
                    break;
                }
            }catch(NumberFormatException e){
                System.out.println("Надо ввести Long!");
            }
        }
    }
    public void setId(){
        this.id = Identifiers.generate();
    }
    //пришлось сделать паблик тк взял за значение и его надо менять
    private void setName(){
        while (true){
            System.out.print("Введите имя: ");
            this.name = Scan();
            if(this.name.replaceAll(" ", "").equals("")){
                System.out.println("Вы ввели пустую строчку! Имя не может быть пустой строчкой.");
            }else{break;}
        }
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Coordinates getCoordinates() {
        return this.coordinates;
    }

    public LocalDate getCreationDate() {
        return this.creationDate;
    }

    public Long getHealth() {
        return this.health;
    }

    public Long getHeartCount() {
        return this.heartCount;
    }

    public MeleeWeapon getMeleeWeapon() {
        return this.meleeWeapon;
    }

    public Chapter getChapter() {
        return this.chapter;
    }

    @Override
    public String toString(){
        return ("Name: " + this.name + "\nid: " + this.id + "\nКоординаты: " + this.coordinates + "\nДата: " + this.creationDate+"\nhealth: " + this.health + ", heartCount: " + this.heartCount +
                "\nmeleeWeapon: " + this.meleeWeapon + "\nChapter: "+ this.chapter);
    }

    @Override
    public int compareTo(SpaceMarine o) {
        return this.id.compareTo(o.getId());
    }
}

