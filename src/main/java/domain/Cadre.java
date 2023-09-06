package domain;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Cadre extends Employee {

    private List<Employee> sub = new ArrayList<Employee>();

    public Cadre() {
    }

    public Cadre(String name, Department department) {
        super(name,department);
    }
}
