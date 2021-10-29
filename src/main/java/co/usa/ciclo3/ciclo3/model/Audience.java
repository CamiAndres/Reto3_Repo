package co.usa.ciclo3.ciclo3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


/*
Autor: Camilo Morales
*/

//Creación de la Entidad
@Entity
@Table(name="audience")
//Creación De la clase Audience en model
public class Audience implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    //Generación de atributos necesarios del auditorio
     private String name;
     private String owner;
     private Integer capacity;
     private String description;
     

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
    
        public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<Reservations> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservations> reservations) {
        this.reservations = reservations;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

 
   // Relaciones
    @ManyToOne
    @JoinColumn(name="idcategory")
    @JsonIgnoreProperties("audiences")
    private Category category;
    // Relación uno a muchos con Mensajes
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "audience")
    @JsonIgnoreProperties({"audiences", "client"})
    private List<Message> messages;
    // Relación uno a muchos con Reservaciones
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "audience")
    @JsonIgnoreProperties({"audiences", "client"})
    private List<Reservations> reservations;

    private Integer id;

    

    // Relación uno a muchos con Categoria

    // Métodos Getter and Setter de la clase Audience
    
   
}
