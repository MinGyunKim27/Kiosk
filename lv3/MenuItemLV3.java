package lv3;

public class MenuItemLV3 {
    public String name;
    public String price;
    public String description;

    public MenuItemLV3(){}

    public void setMenu(String name,String price,String description){
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getName(){
        return this.name;
    }
    public String getPrice(){
        return this.price;
    }
    public String getDescription(){
        return this.description;
    }

}
