package com.salestax.core;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class ProductCategory implements Category {

    private Category parent;
    private String name;
    
    public ProductCategory(String name) {
        this.name = name;
    }

    private List<Category> children = new LinkedList<Category>();

    @Override
    public String getName() {
        return name;
    }

    public Category getParent() {
        return parent;
    }

    public Collection<Category> getChildren() {
       return children;
    }
    
    @Override
    public boolean addChildCategory(Category category) {
        return children.add(category);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ProductCategory other = (ProductCategory) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

}
