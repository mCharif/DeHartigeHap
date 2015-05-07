/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hartigehap.inkoop.domain;

import java.util.Date;

/**
 *
 * @author Erik
 */
public class Purchase {
    
    /**
     * 
     */
    private Date date;
    
    /**
     * 
     */
    private Ingredient ingredient;
    
    /**
     * 
     */
    private int amount;
    
    /**
     * Instantiate a new Purchase Object.
     * 
     * @param date
     * @param ingredient
     * @param amount 
     */
    public Purchase(Date date, Ingredient ingredient, int amount) {
        this.date = date;
        this.ingredient = ingredient;
        this.amount = amount;
    }
    
    /** 
     * Get the current date.
     * 
     * @return 
     */
    public Date getDate() {
        return date;
    }
    
    /**
     * Set the date.
     * 
     * @param date 
     */
    public void setDate(Date date) {
        this.date = date;
    }
    
    /**
     * Get the current ingredient.
     * 
     * @return 
     */
    public Ingredient getIngredient() {
        return ingredient;
    }
    
    /**
     * Set the ingredient.
     * 
     * @param ingredient 
     */
    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }
    
    /**
     * Get the current amount.
     * 
     * @return 
     */
    public int getAmount() {
        return amount;
    }
    
    /**
     * Set the amount.
     * 
     * @param amount 
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }
    
}
