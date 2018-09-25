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
    int partID;
    String name;
    double price;
    int inStock;
    int min;
    int max;

    // Abstract functions
    void setName(String value) {
        name = value;
    }

    String getName() {
        return name;
    }

    void setPrice(double value) {
        price = value;
    }

    double getPrice() {
        return price;
    }

    void setInStock(int value) {
        inStock = value;
    }

    int getInStock() {
        return inStock;
    }

    void setMin(int value) {
        min = value;
    }

    int getMin() {
        return min;
    }

    void setMax(int value) {
        max = value;
    }

    int getMax() {
        return max;
    }

    void setPartID(int value) {
        partID = value;
    }

    int getPartID() {
        return partID;
    }

}
