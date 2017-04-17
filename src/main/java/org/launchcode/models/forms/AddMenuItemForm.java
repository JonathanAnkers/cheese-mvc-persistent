package org.launchcode.models.forms;

import org.launchcode.models.Cheese;
import org.launchcode.models.Menu;

import javax.validation.constraints.NotNull;
import java.util.Iterator;

/**
 * Created by Beast on 4/13/17.
 */
public class AddMenuItemForm {

    private Menu menu;

    private Iterable<Cheese> cheeses;

    @NotNull
    private int menuId;

    @NotNull
    private int cheesesId;

    public AddMenuItemForm() { }

    public AddMenuItemForm(Menu menu, Iterable<Cheese> cheeses){
        this.menu = menu;
        this.cheeses = cheeses;

    }


    public int getMenuId() { return menuId; }

    public int getCheesesId() { return cheesesId; }

    public void setMenuId(int menuId) { this.menuId = menuId; }

    public void setCheesesId(int cheesesId) { this.cheesesId = cheesesId; }

    public Menu getMenu() {return menu;}

    public Iterable<Cheese> getCheeses() {return cheeses;}

    public void setMenu(Menu menu) {this.menu = menu;}

    public void setCheeses(Iterable<Cheese> cheeses) {this.cheeses = cheeses;}



}
