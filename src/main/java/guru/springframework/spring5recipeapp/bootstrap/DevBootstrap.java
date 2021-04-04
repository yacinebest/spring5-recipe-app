package guru.springframework.spring5recipeapp.bootstrap;

import guru.springframework.spring5recipeapp.domain.Category;
import guru.springframework.spring5recipeapp.domain.UnitOfMeasure;
import guru.springframework.spring5recipeapp.repositories.CategoryRepository;
import guru.springframework.spring5recipeapp.repositories.RecipeRepository;
import guru.springframework.spring5recipeapp.repositories.UnitOfMeasureRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;
    private RecipeRepository recipeRepository;

    public DevBootstrap(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository, RecipeRepository recipeRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.recipeRepository = recipeRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        List<Category> categories = new ArrayList<Category>();
        categories.add(new Category("American"));
        categories.add(new Category("Italian"));
        categories.add(new Category("Mexican"));
        categories.add(new Category("Fast Food"));
        categoryRepository.saveAll(categories);

        List<UnitOfMeasure> unitOfMeasures = new ArrayList<UnitOfMeasure>();
        unitOfMeasures.add(new UnitOfMeasure("Teaspoon"));
        unitOfMeasures.add(new UnitOfMeasure("Tablespoon"));
        unitOfMeasures.add(new UnitOfMeasure("Cup"));
        unitOfMeasures.add(new UnitOfMeasure("Pinch"));
        unitOfMeasures.add(new UnitOfMeasure("Ounce"));
        unitOfMeasureRepository.saveAll(unitOfMeasures);
    }

}