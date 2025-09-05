package net.estudios.MVC.Proyecto.Model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Person {
   @Getter
   @Setter
   private String name;
   @Getter
   @Setter
   private int age;    
}
