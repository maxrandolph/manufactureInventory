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

    // Ctor
    Inventory(ArrayList<Product> products, ArrayList<Part> allParts) {
        this.products = products;
        this.allParts = allParts;
    }

    Inventory() {
        this.products = new ArrayList<Product>();
        this.allParts = new ArrayList<Part>();
    }

    // functions
    void addProduct(Product product) {
        products.add(product);
    }

    boolean removeProduct(int productId) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductID() == productId) {
                products.remove(i);
                return true;
            }
        }
        return false;
    }

    Product lookupProduct(int productId) {
        for (Product product : products) {
            if (product.getProductID() == productId) {
                return product;
            }
        }
        return null;
    }

    void updateProduct(int productId, Product updatedProduct) {
        for (Product product : products) {
            if (product.getProductID() == productId) {
                product = updatedProduct;
                return;
            }
        }
    }

    void addPart(Part part) {
        allParts.add(part);
    }

    boolean deletePart(Part part) {
        for (int i = 0; i < allParts.size(); i++) {
            if (allParts.get(i).getPartID() == part.partID) {
                allParts.remove(i);
                return true;
            }
        }
        return false;
    }

    Part lookupPart(int partID) {
        for (Part part : allParts) {
            if (part.getPartID() == partID) {
                return part;
            }
        }
        return null;
    }

    void updatePart(int partID, Part updatedPart) {
        for (Part part : allParts) {
            if (part.getPartID() == partID) {
                part = updatedPart;
                return;
            }
        }
    }
}
