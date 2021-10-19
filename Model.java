package com.example.agrishop;
public class Model {
    String id,name,price,quantity,category,contact,desc,image;

    public Model()
    {
        this.id = id;
        this.name = name;
        this.price=price;
        this.quantity=quantity;
        this.contact=contact;
        this.desc=desc;
        this.image= image;

    }


    public Model(String id, String name, String price, String quantity, String category, String contact, String desc, String image) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity=quantity;
        this.category=category;
        this.contact=contact;
        this.desc=desc;
        this.image= image;
    }
    public String getId()
    {
        return id;
    }
    public void setId(String id)
    {
        this.id=id;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name=name;
    }
    public String getPrice()
    {
        return price;
    }
    public void setPrice(String price)
    {
        this.price=price;
    }
    public String getQuantity()
    {
        return quantity;
    }
    public void setQuantity(String quantity)
    {
        this.quantity=quantity;
    }

    public String getCategory()
    {
        return category;
    }
    public void setCategory(String category)
    {
        this.category=category;
    }
    public String getContact()
    {
        return contact;
    }
    public void setContact(String contact)
    {
        this.contact=contact;
    }
    public String getDesc()
    {
        return desc;
    }
    public void setDesc(String desc)
    {
        this.desc=desc;
    }
    public String getImage()
    {

        return image;
    }
    public void setImage(String image)
    {
        this.image=image;
    }
}
