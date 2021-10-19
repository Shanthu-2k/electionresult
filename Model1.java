package com.example.agrishop;

public class Model1 {
    String id,pid,name,price,quantity,contact,phone,address,units,amount,desc;



    public Model1(String id,String pid, String name, String price,String quantity, String contact, String desc,String phone, String address, String units, String amount) {
        this.id = id;
        this.pid = pid;
        this.name = name;
        this.price=price;
        this.quantity = quantity;
        this.contact = contact;
        this.desc=desc;
        this.phone = phone;
        this.address = address;
        this.units = units;
        this.amount = amount;
    }

    public String getId()
    {
        return id;
    }
    public void setId(String id)
    {
        this.id=id;
    }
    public String getPid()
    {
        return pid;
    }
    public void setPid(String pid)
    {
        this.pid=pid;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name=name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPrice() {
        return price;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public String getQuantity()
    {
        return quantity;
    }
    public void setQuantity(String quantity)
    {
        this.quantity=quantity;
    }
    public String getContact()
    {
        return contact;
    }
    public void setContact(String contact)
    {
        this.id=contact;
    }
    public String getPhone()
    {
        return phone;
    }
    public void setPhone(String phone)
    {
        this.phone=phone;
    }
    public String getAddress()
    {
        return address;
    }
    public void setAddress(String address)
    {
        this.address=address;
    }
    public String getUnits()
    {
        return units;
    }
    public void setUnits(String units)
    {
        this.units=units;
    }
    public String getAmount()
    {
        return amount;
    }
    public void setAmount(String amount)
    {
        this.amount=amount;
    }
}
