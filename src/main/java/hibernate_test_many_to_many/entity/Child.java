package hibernate_test_many_to_many.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "children")
@ToString
@NoArgsConstructor
@Getter
@Setter
public class Child {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="age")
    private int age;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "child_section",
               joinColumns = @JoinColumn(name ="child_id"),
               inverseJoinColumns = @JoinColumn(name = "section_id"))
    private List<Section> sections;

    public void addSectionToChild(Section section) {
        if(sections == null) {
            sections = new ArrayList<>();
        }
        sections.add(section);
    }

    public Child(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
