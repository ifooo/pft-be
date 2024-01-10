package com.parcels.endpoint.rest;

import com.parcels.category.CategoryService;
import com.parcels.category.dto.CategoryDto;
import com.parcels.category.dto.CategoryUpdateCommand;
import com.parcels.endpoint.dto.PagedResponse;
import com.parcels.endpoint.dto.out.CategoryOut;
import com.parcels.endpoint.mapper.PageToPagedResponseOutConverter;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
@Slf4j
public class CategoryResource {
    private final CategoryService categoryService;
    private final ConversionService conversionService;
    private final PageToPagedResponseOutConverter<CategoryOut> pageToPagedResponseOutConverter;

    @PostMapping
    public ResponseEntity<CategoryOut> addCategory(@Valid @RequestBody CategoryUpdateCommand categoryPersistCommand) {
        CategoryDto result = categoryService.save(categoryPersistCommand);
        CategoryOut convertedResult = conversionService.convert(result, CategoryOut.class);
        return ResponseEntity.ok(convertedResult);
    }

    @DeleteMapping
    @RequestMapping("/{id}")
    public ResponseEntity<Boolean> deleteCategory(@PathVariable(name = "id") Long id) {
        Boolean b = categoryService.delete(id);
        return ResponseEntity.ok(b);
    }

    @GetMapping
    public PagedResponse<CategoryOut> getCategories(@RequestParam(name = "page", required = false, defaultValue = "0") int page,
                                                    @RequestParam(name = "size", required = false, defaultValue = "10") int size) {
        Page<CategoryDto> pagedCategories = categoryService.getCategories(page, size);
        final var result = pagedCategories.map(categoryDto -> conversionService.convert(categoryDto, CategoryOut.class));
        final var convertedResult = pageToPagedResponseOutConverter.convert(result);
        return convertedResult;
    }
}
