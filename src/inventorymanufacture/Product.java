/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanufacture;

import java.util.ArrayList;

/**
 *
 * @author max.randolph
 */
public class Product {

    // members
    ArrayList<Part> associatedParts;
    int productID;
    String name;
    double price;
    int inStock;
    int min;
    int max;

    // Functions
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

    void addAssociatedPart(Part part) {
        associatedParts.add(part);
    }

    boolean removeAssociatedPart(int partID) {
        return false;
    }

    Part lookupAssocatedPart(int partID) {
        return null;
    }

    void setProductID(int value) {
        productID = value;
    }

    int getProductID() {
        return productID;
    }
}
