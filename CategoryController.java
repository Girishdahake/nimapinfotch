package controller;

@RestController
@RequestMapping("http://localhost:8080/api/categories?page=3")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public Page<Category> getAll(@RequestParam(defaultValue = "0") int page) {
        return categoryService.getAll(PageRequest.of(page, 10));
    }

    @GetMapping("/{id}")
    public Category getById(@PathVariable Long id) {
        return categoryService.getById(id);
    }

    @PostMapping
    public Category create(@RequestBody Category category) {
        return categoryService.save(category);
    }

    @PutMapping("/{id}")
    public Category update(@PathVariable Long id, @RequestBody Category category) {
        return categoryService.update(id, category);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        categoryService.delete(id);
    }
}
