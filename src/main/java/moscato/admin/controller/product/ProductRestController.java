package moscato.admin.controller.product;

import lombok.RequiredArgsConstructor;
import moscato.admin.service.product.Product;
import moscato.admin.service.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.time.LocalDate;
import java.util.*;

import static org.springframework.util.StringUtils.hasText;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/product/r/*")
public class ProductRestController {

    @Autowired
    ProductRepository productRepository;

    @RequestMapping(value = "/lists-advanced", method = RequestMethod.GET)
    public DataTablesOutput<Product> listAdvanced(@Valid DataTablesInput input) {
        categorySpecification categorySpecification = new categorySpecification(input);
        useSpecification useSpecification = new useSpecification(input);
        keywordSpecification keywordSpecification = new keywordSpecification(input);
        return productRepository.findAll(input, categorySpecification.and(useSpecification).and(keywordSpecification));
    }

    private static class categorySpecification implements Specification<Product> {
        private final Integer categoryId;

        categorySpecification(DataTablesInput input) {
            String categoryFilter = input.getColumn("categoryId").getSearch().getValue();
            if (!hasText(categoryFilter)) {
                categoryId = null;
                return;
            }
            categoryId = Integer.parseInt(categoryFilter);
        }

        @Override
        public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
            Expression<Integer> salary = root.get("categoryId").as(Integer.class);
            if (categoryId != null) {
                return criteriaBuilder.equal(salary, categoryId);
            } else {
                return criteriaBuilder.conjunction();
            }
        }
    }

    private static class useSpecification implements Specification<Product> {
        private final Integer use;

        useSpecification(DataTablesInput input) {
            String useFilter = input.getColumn("isUse").getSearch().getValue();
            if (!hasText(useFilter)) {
                use = null;
                return;
            }
            use = Integer.parseInt(useFilter);
        }

        @Override
        public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
            Expression<Integer> isUse = root.get("isUse").as(Integer.class);
            if (use != null) {
                return criteriaBuilder.equal(isUse, use);
            } else {
                return criteriaBuilder.conjunction();
            }
        }
    }

    private static class keywordSpecification implements Specification<Product> {
        private String keyword;

        keywordSpecification(DataTablesInput input) {
            String keywordFilter = input.getColumn("name").getSearch().getValue();
            input.getColumn("name").getSearch().setValue("");
            if (!hasText(keywordFilter)) {
                keyword = null;
                return;
            }
            keyword = "%" + keywordFilter + "%";
        }

        @Override
        public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
            Expression<String> name = root.get("name").as(String.class);
            Expression<String> originName = root.get("originName").as(String.class);
            Expression<String> brand = root.get("brand").as(String.class);
            if (keyword != null) {
                return criteriaBuilder.or(
                            criteriaBuilder.like(name, "%"+ keyword + "%"),
                            criteriaBuilder.or(
                                    criteriaBuilder.like(originName, "%" + keyword + "%")
                            ),
                            criteriaBuilder.or(
                                    criteriaBuilder.like(brand, "%" + keyword + "%")
                            )
                );
            } else {
                return criteriaBuilder.conjunction();
            }
        }
    }
}
