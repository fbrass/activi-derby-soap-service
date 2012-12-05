/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.spqr.activitiderbysoapservice;

/**
 * Class of a part order
 * @author said
 */
public class Order {

    private String part;
    private long amount;
    private String manufacturer;

    /**
     * Default constructor
     */
     public Order(){
        this.part=null;
        this.amount=0;
        this.manufacturer=null;
    }
     /**
      * constructer
      * @param part name of the part to order
      * @param amount amount of the part to order
      * @param manufacturer name of the manufacturer of the part
      */
    public Order(String part, long amount, String manufacturer) {
        this.part = part;
        this.amount = amount;
        this.manufacturer = manufacturer;
    }

    /**
     * Method to check if Order is correct
     * @return true for correct and false for uncorrect
     */
    public boolean isCoorect() {
        if (part.isEmpty() || amount == 0 || manufacturer.isEmpty() || part == null || manufacturer == null) {
            return false;
        }
        else return true;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }
}
