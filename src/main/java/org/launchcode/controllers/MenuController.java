package org.launchcode.controllers;

import org.launchcode.models.Cheese;
import org.launchcode.models.data.MenuDao;
import org.launchcode.models.forms.AddMenuItemForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.launchcode.models.data.CheeseDao;
import org.launchcode.models.Menu;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Iterator;


/**
 * Created by Beast on 4/13/17.
 */

@Controller
@RequestMapping("menu")
public class MenuController {


    @Autowired
    private MenuDao menuDao;

    @Autowired
    private CheeseDao cheeseDao;


    @RequestMapping(value = "")
    public String index(Model model) {


        model.addAttribute("title", "Menu");
        model.addAttribute("menuitem", menuDao.findAll());

        return "menu/index";

    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {

        model.addAttribute(new Menu());
        model.addAttribute("title", "Add Menu");

        return "menu/add";

    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute @Valid Menu menu, Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Menu");
            return "menu/add";

        }
        menuDao.save(menu);
        return "redirect:view/" + menu.getId();

    }

    //view


    @RequestMapping(value = "view/{seti}", method = RequestMethod.GET)
    public String viewMenu(Model model, @PathVariable("seti") int value) {

        Menu litmenu = menuDao.findOne(value);

        model.addAttribute("menuitem", litmenu);
        model.addAttribute("title", litmenu.getName() + " : Menu");

        return "menu/view";

    }


    //this is the add item to menu section


    //good
    @RequestMapping(value = "add-item/{seti}", method = RequestMethod.GET)
    public String addItem(Model model, @PathVariable("seti") int value) {

        Menu menu = menuDao.findOne(value);
        Iterable<Cheese> cheese = cheeseDao.findAll();


        model.addAttribute("form", new AddMenuItemForm(menu, cheese));
        model.addAttribute("title", "Added item to menu:" + menu.getName());

        return "menu/add-item";

    }


    @RequestMapping(value = "add-item/{seti}", method = RequestMethod.POST)
    public String addItem(Model model, @Valid AddMenuItemForm addForm, Errors errors) {


        if (errors.hasErrors()) {
            model.addAttribute("title", "Add To Menu");
            return "menu/add-item" + addForm.getMenuId();
        }

        Cheese cheeses = cheeseDao.findOne(addForm.getCheesesId());
        Menu theMenu = menuDao.findOne(addForm.getMenuId());
        theMenu.addItem(cheeses);
        menuDao.save(theMenu);
        return "redirect:/menu/view/" + addForm.getMenuId();

    }


}









