package lv4;

public class MenuItemLV4 {
    public String name;
    public String price;
    public String description;

    public MenuItemLV4(){}

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
