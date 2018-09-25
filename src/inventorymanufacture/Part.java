/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanufacture;

/**
 *
 * @author max.randolph
 */
public abstract class Part {

    // Abstract Vars
    private int partID;
    private String name;
    private double price;
    private int inStock;
    private int min;
    private int max;

    // Ctor
    Part(int partID, String name, double price, int inStock, int min, int max) {
        this.partID = partID;
        this.name = name;
        this.price = price;
        this.inStock = inStock;
        this.min = min;
        this.max = max;
    }

    // Abstract functions
    void setName(String value) {
        name = value;
    }

    public String getName() {
        return name;
    }

    public void setPrice(double value) {
        price = value;
    }

    public double getPrice() {
        return price;
    }

    public void setInStock(int value) {
        inStock = value;
    }

    public int getInStock() {
        return inStock;
    }

    public void setMin(int value) {
        min = value;
    }

    public int getMin() {
        return min;
    }

    public void setMax(int value) {
        max = value;
    }

    public int getMax() {
        return max;
    }

    public void setPartID(int value) {
        partID = value;
    }

    public int getPartID() {
        return partID;
    }

}
