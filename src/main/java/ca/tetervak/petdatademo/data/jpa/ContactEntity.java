package ca.tetervak.petdatademo.data.jpa;

import jakarta.persistence.*;

@Entity
@Table(name = "contact")
public class ContactEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id = null;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    public ContactEntity() {
    }

    public ContactEntity(String email, String phone) {
        this.email = email;
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
