package hibernate_test_many_to_many.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "section")
@Getter
@Setter
@NoArgsConstructor
public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "child_section",
            joinColumns = @JoinColumn(name ="section_id"),
            inverseJoinColumns = @JoinColumn(name = "child_id"))
    private List<Child> childrenList;

    public void addChildToSection(Child child) {
        if(childrenList == null) {
            childrenList = new ArrayList<>();
        }
        childrenList.add(child);
    }

    public Section(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Section{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
