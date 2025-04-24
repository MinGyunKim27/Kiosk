public class MenuItem {
    private String name;
    private String price;
    private String description;

    public MenuItem(){}

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
