package net.estudios.MVC.Proyecto.Model.PersonalityTypes;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@EqualsAndHashCode
public class CustomCategory {
    @Getter
    @Setter
    private  String customCategory; 
    
    public CustomCategory(String category){
        this.customCategory = category;
    }


    // here you find the personality toString 
    @Override
    public String toString(){
        return "Category = " + this.customCategory;
    }

    
}
