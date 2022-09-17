package moscato.admin.service.category;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "categories")
public class Category {
    @Id
    @Column(name = "category_id")
    private int categoryId;

    @Column(name = "p_category_id")
    private int pid;

    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "category_full_name")
    private String categoryFullName;

    @Column(name = "category_url")
    private String categoryUrl;

    @Column(name = "is_leaf")
    private int isLeaf;

    private int level;
}
