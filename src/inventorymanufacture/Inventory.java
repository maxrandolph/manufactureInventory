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
public class Inventory {

    // members
    ArrayList<Product> products;
    ArrayList<Part> allParts;

    // functions
    void addProduct(Product product) {
        products.add(product);
    }

    // Todo 
    boolean removeProduct(int productId) {
        return false;
    }

    Product lookupProduct(int productId) {
        return null;
    }

    void updateProduct(int productId, Product updatedProduct) {

    }

    void addPart(Part part) {

    }

    boolean deletePart(Part part) {
        return false;
    }

    Part lookupPart(int partID) {
        return null;
    }

    void updatePart(int partID, Part updatedPart) {

    }
}
