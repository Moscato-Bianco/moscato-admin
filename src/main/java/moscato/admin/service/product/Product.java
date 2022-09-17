package moscato.admin.service.product;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int productId;

    @Column(nullable = false, name = "category_id")
    private int categoryId;

    private String name;

    @Column(nullable = false, unique = true, name = "origin_name")
    private String originName;

    private String brand;

    @Column(name = "product_url")
    private String productUrl;

    private String image;

    @Builder.Default
    private Double price = 0.0;

    private String currency;

    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="Asia/Seoul")
    @Column(columnDefinition = "DATE DEFAULT CURRENT_DATE", name = "release_date")
    private Date releaseDate;

    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="Asia/Seoul")
    @Column(columnDefinition = "DATE DEFAULT CURRENT_DATE", name = "end_date")
    private Date endDate;

    @Builder.Default
    @Column(name = "is_use")
    private boolean isUse = true;

}
