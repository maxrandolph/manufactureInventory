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
public class Inhouse extends Part {

    int machineID;

    public Inhouse(int partID, String name, double price, int inStock, int min, int max, int machineID) {
        super(partID, name, price, inStock, min, max);
        this.machineID = machineID;
    }

    void setMachineID(int value) {
        machineID = value;
    }

    int getMachineID() {
        return machineID;
    }

}
