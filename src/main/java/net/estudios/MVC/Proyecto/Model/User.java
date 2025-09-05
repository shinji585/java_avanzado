package net.estudios.MVC.Proyecto.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Getter
    @Setter
    private Person persona; 
}
