package pl.nullpointerexception.shop.shelve;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.nullpointerexception.shop.product.Book;
import pl.nullpointerexception.shop.user.User;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Shelve {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String type;
    @ManyToMany
    private Set<Book> book;
}
